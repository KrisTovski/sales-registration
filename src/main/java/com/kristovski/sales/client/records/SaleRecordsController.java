package com.kristovski.sales.client.records;

import com.kristovski.sales.domain.api.SaleRecordDto;
import com.kristovski.sales.domain.api.SaleRecordService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/records")
public class SaleRecordsController extends HttpServlet {

    SaleRecordService saleRecordService = new SaleRecordService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SaleRecordDto> saleRecordDtos = saleRecordService.findAll();
        request.setAttribute("records", saleRecordDtos);
        request.getRequestDispatcher("/WEB-INF/views/records.jsp").forward(request, response);
    }
}

