package clubgroup.clubdemo.service;

import clubgroup.clubdemo.po.club;

import java.util.List;

public interface clubService {

    /**
     * 新增俱乐部
     * @param club
     */
    public void saveClub(club club);

    /**
     * 根据id删除俱乐部
     * @param id
     */
    public void deleteClub(Long id);

    /**
     * 查询所有俱乐部
     * @return
     */
    public List<club> listClub();

    /**
     * 查询指定ID的俱乐部
     * @param id
     */
    public club findClubById(Long id);

    /**
     * 更新指定ID的俱乐部
     * @param club
     */
    public void updateClub(club club,Long id);

    /**
     * 查询除指定ID以外的俱乐部信息
     * @param id
     * @return
     */
    List<club> listOtherClub(Long id);
}
