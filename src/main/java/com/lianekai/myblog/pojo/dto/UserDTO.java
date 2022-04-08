package com.lianekai.myblog.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 *用户入参实体类
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/04/09 01:11
 */
@ToString
@Setter
@Getter
@Accessors(chain = true)
public class UserDTO {

    private String bid;

    private String name;

    private String jobNumber;

    private String note;

    private String phone;

    private String email;
}
