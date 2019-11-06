package clubgroup.clubdemo.service.serviceImpl;

import clubgroup.clubdemo.clubException;
import clubgroup.clubdemo.dao.clubRepository;
import clubgroup.clubdemo.po.club;
import clubgroup.clubdemo.service.clubService;
import clubgroup.clubdemo.util.DateAndString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("clubService")
@Transactional
public class clubServiceImpl implements clubService {

    @Autowired
    private clubRepository clubRepository;

    /**
     * 由于表单传的值是yyyy-MM-dd格式的日期字符串，
     * 所以此方法配合工具类DateAndString将其转换为日期格式后，
     * 再存入日期字段createTime并持久化到数据库
     * @param club
     */
    public void setClubCreateTime(club club){
        String createTimeStr = club.getCreateTimeStr();
        if(createTimeStr!=null&&createTimeStr!=""){
            Date date = DateAndString.stringToDate(createTimeStr);
            club.setCreateTime(date);
        }
    }

    /**
     * 由于数据库存入的值是Date类型的createTime，
     * 因此页面要显示yyyy-MM-dd格式，需要转换为字符串后，赋值给字段createTimeStr，
     * 再放到前台去显示
     * @param club
     */
    public void setClubCreateTimeStr(club club) {
        Date createTime = club.getCreateTime();
        if (createTime != null) {
            String createTimeStr = DateAndString.dateToString(createTime);
            club.setCreateTimeStr(createTimeStr);
        }
    }

    /**
     * 新增俱乐部
     * @param club
     */
    @Override
    public void saveClub(club club) {
        setClubCreateTime(club);
        clubRepository.save(club);
    }

    /**
     * 删除指定ID的俱乐部
     * @param id
     */
    @Override
    public void deleteClub(Long id) {
        club delClub = clubRepository.findClubById(id);
        Long memberNumber = delClub.getMemberNumber();
        //当会员数为0时才执行删除动作
        if(memberNumber==0){
            clubRepository.delete(id);
        }else {
            throw new clubException("此处报异常的原因：会员数为0才可以删除俱乐部信息！");
        }
    }

    /**
     * 查询所有俱乐部
     * @return
     */
    @Override
    public List<club> listClub() {
        List<club> clubList = clubRepository.list();
        for(club cb:clubList){
            setClubCreateTimeStr(cb);
        }
        return clubList;
    }

    /**
     * 查询指定ID的俱乐部
     * @param id
     * @return
     */
    @Override
    public club findClubById(Long id) {
        club cb = clubRepository.findClubById(id);
        setClubCreateTimeStr(cb);
        return cb;
    }

    /**
     * 更新指定ID的俱乐部
     * @param club
     * @param id
     */
    @Override
    public void updateClub(club club, Long id) {
        setClubCreateTime(club);
        clubRepository.updateClubById(club,id);
    }

    /**
     * 查询除指定ID以外的俱乐部信息
     * @param id
     * @return
     */
    @Override
    public List<club> listOtherClub(Long id) {
        List<club> clubList = clubRepository.listOtherClub(id);
        return clubList;
    }
}
