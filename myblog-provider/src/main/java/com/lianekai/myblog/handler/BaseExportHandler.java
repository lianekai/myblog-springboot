package com.lianekai.myblog.handler;

import javax.servlet.http.HttpServletResponse;

/**
 * @author lianekai
 * @date 2022/5/25 23:14
 * @version: 1.0
 * @description 导出控制器的统一拦截设置相关参数
 */
public class BaseExportHandler{
    
    protected  void setResponseHeadAsExcel(HttpServletResponse response, String fileName){
        /**对Excel导出做统一处理*/
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=utf-8''" + fileName);
        response.setHeader("Access-Control-Expose-Headers","Content-Disposition");
    }
}
