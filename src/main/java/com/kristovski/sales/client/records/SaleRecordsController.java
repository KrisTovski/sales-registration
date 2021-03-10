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


        String page = request.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }
        int currentPage = Integer.parseInt(page);
        int recordsPerPage = 10;

        if (request.getParameter("currentPage") != null)
            currentPage = Integer.parseInt(request.getParameter("currentPage"));

        List<SaleRecordDto> saleRecordDtos = saleRecordService.findAll((currentPage - 1) * recordsPerPage, recordsPerPage);
        request.setAttribute("saleRecords", saleRecordDtos);

        int totalRecords = saleRecordService.getNumberOfRows();
        int noOfPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);

        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);

        request.getRequestDispatcher("/WEB-INF/views/records.jsp").forward(request, response);
    }
}

