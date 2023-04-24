package geteway.filter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description TODO
 * @ClassName MyGatewayFilter
 * @Author 龙涛05664416459
 * @Date 2023/4/24 23:23
 **/
@Component
@Order(-1)
public class MyGatewayFilter implements GlobalFilter {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 过滤器逻辑
        String aus = exchange.getRequest().getHeaders().getFirst("Authorization");
        String authorization=aus.substring(7);
        Boolean aBoolean = redisTemplate.hasKey("guoqi:" + authorization);
        if (aBoolean){
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }
}


