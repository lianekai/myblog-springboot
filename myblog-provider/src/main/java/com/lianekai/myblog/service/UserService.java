package com.lianekai.myblog.service;

import com.lianekai.myblog.pojo.dto.UserDTO;

/**
 * 用户服务
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/04/09 00:54
 */
public interface UserService {

    /**登录*/
    Boolean login(UserDTO userDTO);

    /**登录*/
    Boolean logout(UserDTO userDTO);

}
