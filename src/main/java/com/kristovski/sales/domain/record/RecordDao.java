package com.kristovski.sales.domain.record;

import com.kristovski.sales.config.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RecordDao {

    private final DataSource dataSource;

    public RecordDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Record> findAll() {
        final String query = """
                SELECT
                id, date_added, value, type, description
                FROM
                records d
                """;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            List<Record> allRecords = new ArrayList<>();
            while (resultSet.next()) {
                Record record = mapRow(resultSet);
                allRecords.add(record);
            }
            return allRecords;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Record mapRow(ResultSet resultSet) throws SQLException {
        int recordId = resultSet.getInt("id");
        LocalDateTime dateAdded = resultSet.getTimestamp("date_added").toLocalDateTime();
        BigDecimal value = resultSet.getBigDecimal("value");
        RecordType type = RecordType.valueOf(resultSet.getString("type"));
        String description = resultSet.getString("description");
        return new Record(recordId, dateAdded, value, type, description);
    }
}
