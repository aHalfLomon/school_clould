package shop.config.minio;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qjp
 */
@Data
@Configuration
public class MinIoClientConfig {
    private String endpoint="http://121.36.100.147:9000";
    private String accessKey="minioadmin";
    private String secretKey="minioadmin";

    /**
     * 注入minio 客户端
     * @return
     */
    @Bean
    public MinioClient minioClient(){

        return MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }

}
