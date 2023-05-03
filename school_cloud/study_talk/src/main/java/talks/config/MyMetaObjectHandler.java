package talks.config;

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
        this.setFieldValByName("usc_data", new Date(), metaObject);
        this.setFieldValByName("t_like_date", new Date(), metaObject);
        this.setFieldValByName("t_date", new Date(), metaObject);
        this.setFieldValByName("tk_data", new Date(), metaObject);
        this.setFieldValByName("usc_data", new Date(), metaObject);
        this.setFieldValByName("like_data", new Date(), metaObject);
        this.setFieldValByName("tk_data", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
