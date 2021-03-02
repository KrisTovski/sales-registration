package com.kristovski.sales.domain.api;

import com.kristovski.sales.domain.salerecord.SaleRecordType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SaleRecordDto {

    private int id;
    private LocalDateTime dateAdded;
    private BigDecimal value;
    private SaleRecordType type;
    private String description;

    public SaleRecordDto(int id, LocalDateTime dateAdded, BigDecimal value, SaleRecordType type, String description) {
        this.id = id;
        this.dateAdded = dateAdded;
        this.value = value;
        this.type = type;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
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
}

