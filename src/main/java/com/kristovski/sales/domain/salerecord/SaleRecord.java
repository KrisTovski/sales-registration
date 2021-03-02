package com.kristovski.sales.domain.salerecord;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SaleRecord {

    private Integer id;
    private LocalDateTime dateAdded;
    private BigDecimal value;
    private SaleRecordType type;
    private String description;
    private Integer userId;

    public SaleRecord(Integer id, LocalDateTime dateAdded, BigDecimal value, SaleRecordType type, String description, Integer userId) {
        this(dateAdded, value, type, description, userId);
        this.id = id;

    }

    public SaleRecord(LocalDateTime dateAdded, BigDecimal value, SaleRecordType type, String description, Integer userId) {
        this.dateAdded = dateAdded;
        this.value = value;
        this.type = type;
        this.description = description;
        this.userId = userId;
    }


    public Integer getId() {
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

    public Integer getUserId() {
        return userId;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
