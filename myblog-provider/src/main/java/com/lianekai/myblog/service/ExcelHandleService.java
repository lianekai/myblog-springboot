package com.lianekai.myblog.service;

import com.lianekai.myblog.dto.ExportParamDTO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ExcelHandleService {

    void exportForDynamic(HttpServletResponse response, ExportParamDTO exportParamDTO) throws IOException;
}
