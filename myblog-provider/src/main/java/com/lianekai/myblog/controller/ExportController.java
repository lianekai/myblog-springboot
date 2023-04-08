package com.lianekai.myblog.controller;

import com.lianekai.myblog.dto.ExportParamDTO;
import com.lianekai.myblog.handler.BaseExportHandler;
import com.lianekai.myblog.service.ExcelHandleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author lianekai
 * @date 2022/5/25 23:13
 * @version: 1.0
 * @description TODO
 */
public class ExportController extends BaseExportHandler {

    @Resource
    ExcelHandleService excelHandleService;

    @ApiOperation(value = "导出动态参数接口", httpMethod = "POST")
    @PostMapping(value = "/my-blog/export/exportForDynamic")
    public void exportForDynamic(HttpServletResponse response, @RequestBody ExportParamDTO exportParamDTO) throws IOException {
        String fileName = URLEncoder.encode("团队成员导出", StandardCharsets.UTF_8.name()).replaceAll("\\+", "%20");
        super.setResponseHeadAsExcel(response,fileName);
        excelHandleService.exportForDynamic(response,exportParamDTO);
    }


}
