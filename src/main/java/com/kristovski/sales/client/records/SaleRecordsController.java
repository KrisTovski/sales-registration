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

@WebServlet(urlPatterns = {"/records", "/records/{page_id}"})
public class SaleRecordsController extends HttpServlet {

    SaleRecordService saleRecordService = new SaleRecordService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int currentpage = 1;
        int numRecords = 10;

        if (request.getParameter("page") != null)
            currentpage = Integer.parseInt(request.getParameter("page"));

        List<SaleRecordDto> saleRecordDtos = saleRecordService.findAll((currentpage - 1) * numRecords, numRecords);

        int totalRecords = saleRecordService.getNumberOfRows();
        int numPages = (int) Math.ceil(totalRecords * 1.0 / numRecords);

        request.setAttribute("records", saleRecordDtos);
        request.setAttribute("numPages", numPages);
        request.setAttribute("currentPage", currentpage);

        request.getRequestDispatcher("/WEB-INF/views/records.jsp").forward(request, response);
    }
}

