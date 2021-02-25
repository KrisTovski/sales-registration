package com.kristovski.sales.domain.record;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Record {

    private Integer id;
    private LocalDateTime dateAdded;
    private BigDecimal value;
    private RecordType type;
    private String description;

    public Record(Integer id, LocalDateTime dateAdded, BigDecimal value, RecordType type, String description) {
        this(dateAdded, value, type, description);
        this.id = id;

    }

    public Record(LocalDateTime dateAdded, BigDecimal value, RecordType type, String description) {
        this.dateAdded = dateAdded;
        this.value = value;
        this.type = type;
        this.description = description;
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

    public RecordType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
