package com.kristovski.sales.client.records;

import com.kristovski.sales.domain.api.RecordDto;
import com.kristovski.sales.domain.api.RecordService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/records")
public class RecordsController extends HttpServlet {

    RecordService recordService = new RecordService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RecordDto> recordDtos = recordService.findAll();
        request.setAttribute("records", recordDtos);
        request.getRequestDispatcher("/WEB-INF/views/records.jsp").forward(request, response);
    }
}

