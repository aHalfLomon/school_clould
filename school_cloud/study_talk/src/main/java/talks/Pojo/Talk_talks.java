package talks.Pojo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (STk)表实体类
 *
 * @author makejava
 * @since 2023-04-05 16:47:26
 */
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
public class Talk_talks extends Model<Talk_talks> {
    //评论的ID
    private String tkId;
    //由此来展示评论用户的部分信息
    private String tkUid;
    //评论帖子ID
    private String tkTid;
    //评论内容
    private String tkSource;
    //发表评论的时间
    private Date tkData;


    public String getTkId() {
        return tkId;
    }

    public void setTkId(String tkId) {
        this.tkId = tkId;
    }

    public String getTkUid() {
        return tkUid;
    }

    public void setTkUid(String tkUid) {
        this.tkUid = tkUid;
    }

    public String getTkTid() {
        return tkTid;
    }

    public void setTkTid(String tkTid) {
        this.tkTid = tkTid;
    }

    public String getTkSource() {
        return tkSource;
    }

    public void setTkSource(String tkSource) {
        this.tkSource = tkSource;
    }

    public Date getTkData() {
        return tkData;
    }

    public void setTkData(Date tkData) {
        this.tkData = tkData;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.tkId;
    }
    }

