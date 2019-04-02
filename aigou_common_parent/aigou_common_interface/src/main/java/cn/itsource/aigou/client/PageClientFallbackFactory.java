package cn.itsource.aigou.client;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PageClientFallbackFactory implements FallbackFactory<PageClient> {
    @Override
    public PageClient create(Throwable throwable) {
        return new PageClient() {
            @Override
            public void createPage(Map<String, Object> params) {
                System.out.println("该服务已被降级！");
            }
        };
    }
}