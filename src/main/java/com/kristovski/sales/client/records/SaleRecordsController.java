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

@WebServlet("/records/{page_id}")
public class SaleRecordsController extends HttpServlet {

    SaleRecordService saleRecordService = new SaleRecordService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page_id");
        if(page == null || "".equals(page)){
            page = "1";
        }
        Integer currentPage = Integer.valueOf(page);
        Integer pageSize = 5;

        List<SaleRecordDto> saleRecordDtos = saleRecordService.findAll(currentPage,pageSize);
        request.setAttribute("records", saleRecordDtos);
        int rows = saleRecordService.getNumberOfRows();
        int noOfPages = rows / pageSize;
        if(noOfPages % pageSize > 0){
            noOfPages++;
        }
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("pageSize", pageSize);

        request.getRequestDispatcher("/WEB-INF/views/records.jsp").forward(request, response);
    }
}

