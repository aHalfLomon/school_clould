package help_sove.handel;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //log.info("start insert fill ....");
        this.setFieldValByName("hData", new Date(), metaObject);
        this.setFieldValByName("hSTime", new Date(), metaObject);
        this.setFieldValByName("hImg", 0, metaObject);
        this.setFieldValByName("hState", 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //log.info("start update fill ....");
        this.setFieldValByName("userUpdateTime", new Date(), metaObject);
    }
}
