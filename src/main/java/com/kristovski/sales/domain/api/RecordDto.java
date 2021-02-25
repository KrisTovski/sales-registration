package com.kristovski.sales.domain.api;

import com.kristovski.sales.domain.record.RecordType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RecordDto {

    private int id;
    private LocalDateTime dateAdded;
    private BigDecimal value;
    private RecordType type;
    private String description;

    public RecordDto(int id, LocalDateTime dateAdded, BigDecimal value, RecordType type, String description) {
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

    public RecordType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}

