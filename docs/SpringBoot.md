一、什么是自动装配

在使用SpringBoot的时候，会自动将Bean装配到IoC容器中。例如我们在使用Redis数据库的时候，会引入依赖spring-boot-starter-data-redis。在引入这个依赖后，服务初始化的时候，会将操作Redis需要的组件注入到IoC容器中进行后续使用
自动装配大致过程如下：

获取到组件（例如spring-boot-starter-data-redis）META-INF文件夹下的spring.factories文件 
spring.factories文件中列出需要注入IoC容器的类 将实体类注入到IoC容器中进行使用

二、自动装配原理

自动装配大致流程是通过@SpringBootApplication进行实现，这个注解声明在SpringBoot的启动类上

1、SpringBoot启动类

2、@SpringBootApplication注解

SpringBoot启动类=>@SpringBootApplication

3、@SpringBootConfiguration注解

SpringBoot启动类=>@SpringBootApplication=>@SpringBootConfiguration