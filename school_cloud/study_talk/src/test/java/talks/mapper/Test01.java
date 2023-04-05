package talks.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import talks.Pojo.STk;

import java.util.List;

/**
 * @Description TODO
 * @ClassName talks.mapper.Test01
 * @Author 龙涛05664416459
 * @Date 2023/4/5 16:22
 **/
@SpringBootTest
public class Test01 {

    @Autowired
    Testmapper testmapper;

    @Test
    void xx(){
        List<STk> findalltk = testmapper.findalltk();
        System.out.println(findalltk);
    }

}
