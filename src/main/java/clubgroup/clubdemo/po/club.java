package clubgroup.clubdemo.po;

import java.io.Serializable;
import java.util.Date;

public class club implements Serializable {

    private Long clubId;
    private String clubName;
    private String clubPerson;
    private Integer clubType;
    private String clubTypeStr;
    private Date createTime;
    private String createTimeStr;
    private Long activityTimes;
    private Long memberNumber;
    private String remarks;

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getClubTypeStr() {
        if(clubType!=null){
            if(clubType==0){
                clubTypeStr="足球";
            }
            if(clubType==1){
                clubTypeStr="羽毛球";
            }
            if(clubType==2){
                clubTypeStr="篮球";
            }
            if(clubType==3){
                clubTypeStr="乒乓球";
            }
        }
        return clubTypeStr;
    }

    public void setClubTypeStr(String clubTypeStr) {
        this.clubTypeStr = clubTypeStr;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubPerson() {
        return clubPerson;
    }

    public void setClubPerson(String clubPerson) {
        this.clubPerson = clubPerson;
    }

    public Integer getClubType() {
        return clubType;
    }

    public void setClubType(Integer clubType) {
        this.clubType = clubType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getActivityTimes() {
        return activityTimes;
    }

    public void setActivityTimes(Long activityTimes) {
        this.activityTimes = activityTimes;
    }

    public Long getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(Long memberNumber) {
        this.memberNumber = memberNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "clubgroup.clubdemo.po.club{" +
                "activityTimes=" + activityTimes +
                ", clubId=" + clubId +
                ", clubName='" + clubName + '\'' +
                ", clubPerson='" + clubPerson + '\'' +
                ", clubType=" + clubType +
                ", clubTypeStr='" + clubTypeStr + '\'' +
                ", createTime=" + createTime +
                ", createTimeStr='" + createTimeStr + '\'' +
                ", memberNumber=" + memberNumber +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
