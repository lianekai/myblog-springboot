package com.lianekai.myblog;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 我的博客的单体Spring Boot 应用
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/04/08 21:56
 */
@SpringBootApplication
public class MyBlogApplication {
    public static void main(String[] args) {
        SpringApplication springApplication=new SpringApplication(MyBlogApplication.class);
        springApplication.setBannerMode(Banner.Mode.CONSOLE);
        springApplication.run(args);
    }
}
