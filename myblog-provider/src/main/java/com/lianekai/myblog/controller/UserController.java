package com.lianekai.myblog.controller;

import com.lianekai.myblog.pojo.dto.UserDTO;
import com.lianekai.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/04/09 01:58
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user/login")
    public Boolean login(@RequestBody UserDTO userDTO){
        return userService.login(userDTO);
    }
}
