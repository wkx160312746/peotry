package io.renren.modules.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.servlet.config.annotation.*;

import java.util.concurrent.Executors;


/**
 *  create by wkx  on  2020/6/30
 * 跨域请求支持/token拦截
 * tip:只能写在一个配置类里
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Value("${upImgUrl}")
    private  String upImgUrl;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:" + upImgUrl);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置跨域
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        System.out.println("配置拦截器");

    }
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer){
        // 设置线程池
        configurer.setTaskExecutor(new ConcurrentTaskExecutor(Executors.newFixedThreadPool(3)));
        configurer.setDefaultTimeout(30000);
    }
}
