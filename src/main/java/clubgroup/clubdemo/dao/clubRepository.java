package clubgroup.clubdemo.dao;

import clubgroup.clubdemo.po.club;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface clubRepository {

    /**
     * 新增俱乐部
     */
    @Insert("insert into club(clubName,clubPerson,clubType,createTime,activityTimes,memberNumber,remarks)" +
            "values(#{clubName},#{clubPerson},#{clubType},#{createTime},#{activityTimes},#{memberNumber},#{remarks})")
    public void save(club club);

    /**
     * 根据ID删除俱乐部
     */
    @Delete("delete from club where clubId=#{id}")
    public void delete(@Param("id")Long id);

    /**
     * 查询所有俱乐部
     */
    @Select("select * from club")
    public List<club> list();

    /**
     * 查询指定ID的俱乐部
     */
    @Select("select * from club where clubId=#{id}")
    public club findClubById(@Param("id") Long id);

    /**
     * 更新指定ID的俱乐部信息
     * @param club
     * @param id
     */
    @Update("update club set clubName=#{club.clubName},clubPerson=#{club.clubPerson}," +
            "memberNumber=#{club.memberNumber} where clubId=#{clubId}")
    public void updateClubById(@Param("club")club club,@Param("clubId") Long id);

    /**
     * 查询除指定ID以外的俱乐部信息
     * @param id
     * @return
     */
    @Select("select * from club where clubId!=#{id}")
    public List<club> listOtherClub(@Param("id") Long id);
}
