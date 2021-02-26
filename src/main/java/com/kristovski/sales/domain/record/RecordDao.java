package com.kristovski.sales.domain.record;

import com.kristovski.sales.domain.common.BaseDao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RecordDao extends BaseDao {

    public List<Record> findAll() {
        final String query = """
                SELECT
                id, date_added, value, type, description
                FROM
                records d
                """;
        try (Connection connection = getConnection();
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
