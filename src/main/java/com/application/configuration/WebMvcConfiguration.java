package com.application.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
@EnableWebMvc
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedHeaders("X-Auth-Token", "Access-Control-Allow-Headers","X-Frame-Options",
                        "X-Requested-With, Content-Type, Authorization, Origin, Accept, " +
                                "Access-Control-Request-Method, Access-Control-Request-Headers");
    }


    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**",
                        "/css/**",
                        "/js/**",
                        "/icon/**",
                        "/img/**")
                .addResourceLocations("classpath:/css/",
                        "classpath:/icon/",
                        "classpath:/img/",
                        "classpath:/js/",
                        "/resources/");

    }
}
