package shop.handler;

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
        this.setFieldValByName("shopData", new Date(), metaObject);
        this.setFieldValByName("buyData", new Date(), metaObject);
        this.setFieldValByName("evnData", new Date(), metaObject);
        this.setFieldValByName("shopBuy", 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //log.info("start update fill ....");
        this.setFieldValByName("userUpdateTime", new Date(), metaObject);
    }
}
