package help_sove.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class HelpSove implements Serializable {
    private static final long serialVersionUID = 155691998684149364L;
    /**
     * 求助，反馈ID
     */
    private String hId;
    /**
     * 解决状态;0待解决 1解决
     */

    private Date h_s_time;
    private Integer hState;
    /**
     * 解决方案
     */
    private String hSFa;


    public String getHId() {
        return hId;
    }

    public void setHId(String hId) {
        this.hId = hId;
    }

    public Integer getHState() {
        return hState;
    }

    public void setHState(Integer hState) {
        this.hState = hState;
    }

    public String getHSFa() {
        return hSFa;
    }

    public void setHSFa(String hSFa) {
        this.hSFa = hSFa;
    }

    public Date getH_s_time() {
        return h_s_time;
    }

    public void setH_s_time(Date h_s_time) {
        this.h_s_time = h_s_time;
    }
}

