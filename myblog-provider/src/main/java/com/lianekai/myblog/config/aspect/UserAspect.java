package com.lianekai.myblog.config.aspect;

import com.lianekai.myblog.annotation.SysLog;
import com.lianekai.myblog.cache.UserLocalCache;
import com.lianekai.myblog.pojo.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.beans.BeanMap;
import org.apache.logging.log4j.util.Strings;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 用户切面
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/04/09 01:16
 */
@Aspect
@Component
@Slf4j
public class UserAspect {

    /**
     * 定义一个切点：所有被OperationRecent注解修饰的方法会织入advice
     */
    @Pointcut("@annotation(com.lianekai.myblog.annotation.SysLog)")
    private void loginCut(){}

    @Before("loginCut()")
    public void beforeLogin(JoinPoint point) {
        Object[] params = point.getArgs();
        String jobNumber= Strings.EMPTY;
        if(params[0] instanceof UserDTO){
            BeanMap beanMap=BeanMap.create(params[0]);
            jobNumber= (String) beanMap.get("jobNumber");
        }

        /**在进入切点之前将工号加入到本地缓存*/
        UserLocalCache.set(jobNumber);
        log.info("OperatorName:{}", UserLocalCache.get());
    }

    @AfterReturning(pointcut = "loginCut()", returning = "result")
    @Async("asyncExecutor")
    public Object afterLogin(JoinPoint point, Object result){
        /**如果返回值为boolean 而且 不为true 不执行操作日志记录*/
        boolean booleanFlag = "true".equalsIgnoreCase(result.toString()) || "false".equalsIgnoreCase(result.toString());
        if (booleanFlag && !Boolean.parseBoolean(result.toString())) {
            return null;
        }

        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        SysLog sysLog = methodSignature.getMethod().getAnnotation(SysLog.class);
        Object[] object = point.getArgs();

        String operateDesc=sysLog.type().getOperationZh();
        String operator=UserLocalCache.get();

        log.info("进入到日志记录了：当前日志为："+operator+operateDesc);

        UserLocalCache.unload();
        log.info("移出缓存的用户信息："+UserLocalCache.get());
        return result;

    }

}
