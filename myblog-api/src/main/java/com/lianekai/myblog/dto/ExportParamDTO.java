package com.lianekai.myblog.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * @author lianekai
 * @version: 1.0
 * @date 2022/5/25 21:41
 * @description 导出参数DTO
 */
@Getter
@Setter
@Accessors(chain = true)
public class ExportParamDTO {

    @ApiModelProperty(value = "是否导出数据，与生成模板共用接口 用于区分", example = "false")
    private Boolean exportData;

    /**参数映射*/
    @ApiModelProperty(value = "导出参数的参数映射集合支持传List数据", example = "")
    private Map<String,Object> paramMap;

    public static ExportParamDTO build(Map<String,Object> paramMap){
        return new ExportParamDTO().setParamMap(paramMap);
    }

    public static ExportParamDTO build(){
        return new ExportParamDTO();
    }
}
