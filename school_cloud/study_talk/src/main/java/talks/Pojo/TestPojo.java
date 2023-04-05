package talks.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname TestPojo
 * @Description TODO
 * @Date 2023/4/5 11:43
 * @Created by wang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestPojo {
    private String tk_id;
    private String tk_uid;
    private String tk_tid;
    private String tk_source;
    private String tk_data;

}
