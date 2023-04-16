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
    private String h_id;
    /**
     * 解决状态;0待解决 1解决
     */
    private String h_sovePerson;
    private Date h_s_time;
    private Integer h_state;
    /**
     * 解决方案
     */
    private String h_s_fa;


    public String getHId() {
        return h_id;
    }

    public void setHId(String hId) {
        this.h_id = hId;
    }

    public Integer getHState() {
        return h_state;
    }

    public void setHState(Integer hState) {
        this.h_state = hState;
    }

    public String getHSFa() {
        return h_s_fa;
    }

    public void setHSFa(String hSFa) {
        this.h_s_fa = hSFa;
    }

    public Date getH_s_time() {
        return h_s_time;
    }

    public void setH_s_time(Date h_s_time) {
        this.h_s_time = h_s_time;
    }

    public String getH_sovePerson() {
        return h_sovePerson;
    }

    public void setH_sovePerson(String h_sovePerson) {
        this.h_sovePerson = h_sovePerson;
    }
}

