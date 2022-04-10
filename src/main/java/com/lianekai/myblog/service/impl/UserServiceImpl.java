package com.lianekai.myblog.service.impl;

import com.lianekai.myblog.annotation.SysLog;
import com.lianekai.myblog.common.OperationTypeEnum;
import com.lianekai.myblog.pojo.dto.UserDTO;
import com.lianekai.myblog.service.UserService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用户服务
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/04/09 00:55
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    @SysLog(bizType = "登录", type = OperationTypeEnum.LOGIN)
    public Boolean login(UserDTO userDTO) {
        String name = userDTO.getName();
        log.info(name + "进行了登录");
        return Boolean.TRUE;
    }

    @Override
    @SysLog(bizType = "登出", type = OperationTypeEnum.LOGOUT)
    public Boolean logout(UserDTO userDTO) {
        String name = userDTO.getName();
        log.info(name + "退出了登录");
        return Boolean.TRUE;
    }

}