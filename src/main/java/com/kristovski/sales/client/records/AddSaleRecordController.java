package com.kristovski.sales.client.records;

import com.kristovski.sales.domain.api.SaleRecordSaveRequestDto;
import com.kristovski.sales.domain.api.SaleRecordService;
import com.kristovski.sales.domain.salerecord.SaleRecordType;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/record/add")
@ServletSecurity(
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = "USER"),
                @HttpMethodConstraint(value = "POST", rolesAllowed = "USER")
        }
)
public class AddSaleRecordController extends HttpServlet {
    private SaleRecordService recordService = new SaleRecordService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/addrecord.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SaleRecordSaveRequestDto saveRequestDto = createSaveRequest(request);
        SaleRecordType type = SaleRecordType.valueOf(request.getParameter("type"));
        recordService.add(saveRequestDto, type);
        response.sendRedirect(request.getContextPath() + "/records");
    }

    private SaleRecordSaveRequestDto createSaveRequest(HttpServletRequest request) {
        BigDecimal value = new BigDecimal(request.getParameter("value"));
        String description = request.getParameter("description");
        String author = request.getUserPrincipal().getName();

        SaleRecordSaveRequestDto saveRequestDto = new SaleRecordSaveRequestDto(value, description, author);
        return saveRequestDto;
    }


}
