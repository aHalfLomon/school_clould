package talks.Pojo;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
public class School_talk extends Model<School_talk> {
    //帖子编号；由系统生成（主键）
    private String tId;
    //发帖人id ；记录发帖人的ID，以展示发帖人的部分信息
    private String tUid;
    //发帖带的图片（暂定一张）
    private String tImg;
    //发帖内容
    private String tSource;
    //发帖日期
    private Date tData;
    //帖子收藏数量
    private Integer tUscCount;
    //帖子点赞数量
    private Integer tLikeCount;
    //帖子状态
    private String tStatus;


    public String getTId() {
        return tId;
    }

    public void setTId(String tId) {
        this.tId = tId;
    }

    public String getTUid() {
        return tUid;
    }

    public void setTUid(String tUid) {
        this.tUid = tUid;
    }

    public String getTImg() {
        return tImg;
    }

    public void setTImg(String tImg) {
        this.tImg = tImg;
    }

    public String getTSource() {
        return tSource;
    }

    public void setTSource(String tSource) {
        this.tSource = tSource;
    }

    public Date getTData() {
        return tData;
    }

    public void setTData(Date tData) {
        this.tData = tData;
    }

    public Integer getTUscCount() {
        return tUscCount;
    }

    public void setTUscCount(Integer tUscCount) {
        this.tUscCount = tUscCount;
    }

    public Integer getTLikeCount() {
        return tLikeCount;
    }

    public void setTLikeCount(Integer tLikeCount) {
        this.tLikeCount = tLikeCount;
    }

    public String getTStatus() {
        return tStatus;
    }

    public void setTStatus(String tStatus) {
        this.tStatus = tStatus;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.tId;
    }
    }

