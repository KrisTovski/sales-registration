package com.kristovski.sales.domain.api;

import com.kristovski.sales.domain.salerecord.SaleRecordType;

import java.math.BigDecimal;

public class SaleRecordSaveRequestDto {

    private BigDecimal value;
    private SaleRecordType type;
    private String description;
    private String author;


    public SaleRecordSaveRequestDto(BigDecimal value, SaleRecordType type, String description, String author) {

        this.value = value;
        this.type = type;
        this.description = description;
        this.author = author;
    }

    public SaleRecordSaveRequestDto(BigDecimal value, String description, String author) {
        this.value = value;
        this.description = description;
        this.author = author;
    }

    public BigDecimal getValue() {
        return value;
    }

    public SaleRecordType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }


}
