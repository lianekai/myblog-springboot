package com.lianekai.myblog.service.impl;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.lianekai.myblog.common.ResultEnum;
import com.lianekai.myblog.dto.ExportParamDTO;
import com.lianekai.myblog.exception.ExceptionConstructor;
import com.lianekai.myblog.handler.CustomColumnWidthHandler;
import com.lianekai.myblog.service.ExcelHandleService;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author lianekai
 * @date 2022/5/25 23:25
 * @version: 1.0
 * @description TODO
 */
public class ExcelHandleServiceImpl implements ExcelHandleService {

    @Override
    public void exportForDynamic(HttpServletResponse response, ExportParamDTO exportParamDTO) throws IOException {
        Map<String,Object> paramMap=exportParamDTO.getParamMap();
        if(CollectionUtils.isEmpty(paramMap)){
            ExceptionConstructor.runtimeBusExpConstructor(ResultEnum.DATA_IS_ERROR.getCode(),"导出参数map为空~！");
        }
        String sheetName=(String)paramMap.get("sheetName");


        ExcelWriterBuilder excelWriterBuilder = EasyExcelFactory
                .write(response.getOutputStream())
                .excelType(ExcelTypeEnum.XLSX)
                .registerWriteHandler(new CustomColumnWidthHandler());

        ExcelWriter writer = excelWriterBuilder.build();

        ExcelWriterSheetBuilder excelWriterSheetBuilder = new ExcelWriterSheetBuilder(writer);

        /**动态添加表头，适用一些表头动态变化的场景*/
        WriteSheet writeSheet = excelWriterSheetBuilder.build();
        writeSheet.setSheetName(sheetName);
        writeSheet.setSheetNo(1);
    }
}
