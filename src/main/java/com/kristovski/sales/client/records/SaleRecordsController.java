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


        int currentPage = 1;
        int recordsPerPage = 10;

        if (request.getParameter("currentPage") != null)
            currentPage = Integer.parseInt(request.getParameter("currentPage"));

        saleRecordService.findAll((currentPage - 1) * recordsPerPage, recordsPerPage);

        int totalRecords = saleRecordService.getNumberOfRows();
        int numOfPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);

        request.setAttribute("noOfPages", numOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);

        request.getRequestDispatcher("/WEB-INF/views/records.jsp").forward(request, response);
    }
}

