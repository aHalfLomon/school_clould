package shop.config;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shop.handler.MyMetaObjectHandler;


/**
 * @Description TODO
 * @ClassName MybatisPlusConfig
 * @Author 龙涛05664416459
 * @Date 2023/4/13 21:26
 **/
@Configuration
public class MybatisPlusConfig {

    @Autowired
    private MyMetaObjectHandler myMetaObjectHandler;

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加乐观锁插件
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }

    @Bean
    public MybatisPlusPropertiesCustomizer mybatisPlusPropertiesCustomizer() {
        return (properties) -> properties.getGlobalConfig().setMetaObjectHandler(myMetaObjectHandler);
    }
}
