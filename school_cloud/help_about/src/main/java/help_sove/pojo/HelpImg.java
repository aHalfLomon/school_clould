package help_sove.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class HelpImg implements Serializable {
    private static final long serialVersionUID = -91350806266809940L;
    /**
     * 图片url 
     */
    private String hImgUrl;
    /**
     * 图片所属求助反馈ID
     */
    private String hImgSid;
    /**
     * 图片编号 ;在求助，反馈详情页展示的顺序
     */
    private Integer hImg;


    public String getHImgUrl() {
        return hImgUrl;
    }

    public void setHImgUrl(String hImgUrl) {
        this.hImgUrl = hImgUrl;
    }

    public String getHImgSid() {
        return hImgSid;
    }

    public void setHImgSid(String hImgSid) {
        this.hImgSid = hImgSid;
    }

    public Integer getHImg() {
        return hImg;
    }

    public void setHImg(Integer hImg) {
        this.hImg = hImg;
    }

}

