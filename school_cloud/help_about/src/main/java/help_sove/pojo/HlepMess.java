package help_sove.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (HlepMess)实体类
 *
 * @author makejava
 * @since 2023-04-11 11:37:11
 */
public class HlepMess implements Serializable {
    private static final long serialVersionUID = 107108958048741983L;
    /**
     * 求助，反馈ID
     */
    private String hId;
    /**
     * 求助，反馈人;展示发起人的部分基本信息
     */
    private String hUid;
    /**
     * 求助，反馈内容
     */
    private String hSource;
    /**
     * 解决状态:0待解决 1解决
     */
    private Integer hState;
    /**
     * 求助、反馈时间
     */
    private Date hData;


    public String getHId() {
        return hId;
    }

    public void setHId(String hId) {
        this.hId = hId;
    }

    public String getHUid() {
        return hUid;
    }

    public void setHUid(String hUid) {
        this.hUid = hUid;
    }

    public String getHSource() {
        return hSource;
    }

    public void setHSource(String hSource) {
        this.hSource = hSource;
    }

    public Integer getHState() {
        return hState;
    }

    public void setHState(Integer hState) {
        this.hState = hState;
    }

    public Date gethData() {
        return hData;
    }

    public void sethData(Date hData) {
        this.hData = hData;
    }

}

