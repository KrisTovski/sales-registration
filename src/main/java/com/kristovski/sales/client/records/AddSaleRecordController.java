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
        request.getRequestDispatcher("/WEB-INF/views/add-record.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SaleRecordSaveRequestDto saveRequestDto = createSaveRequest(request);
        recordService.add(saveRequestDto);
        response.sendRedirect(request.getContextPath());
    }

    private SaleRecordSaveRequestDto createSaveRequest(HttpServletRequest request) {
        String loggedInUsername = request.getUserPrincipal().getName();
        BigDecimal value = new BigDecimal(request.getParameter("value"));
        SaleRecordType type = new SaleRecordType.valueOf(request.getParameter("type"));

        return new SaleRecordSaveRequestDto(
                request.getParameter(value),
                request.getParameter("type"),
                request.getParameter("description"),
                loggedInUsername
        );
    }
}
