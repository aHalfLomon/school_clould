package users.handler;

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
        this.setFieldValByName("userCreateTime", new Date(), metaObject);
        this.setFieldValByName("userUpdateTime", new Date(), metaObject);
        this.setFieldValByName("userType", "学生", metaObject);
        this.setFieldValByName("userAvatar", "http://121.36.100.147:9000/test/testb6876ca502a1738f46c1acd00163fe3_1682082691051.jpg",metaObject);
        this.setFieldValByName("userIntroduct", "这个人什么都没有留下", metaObject);
        this.setFieldValByName("userStatus", "1", metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //log.info("start update fill ....");
        this.setFieldValByName("userUpdateTime", new Date(), metaObject);
    }
}
