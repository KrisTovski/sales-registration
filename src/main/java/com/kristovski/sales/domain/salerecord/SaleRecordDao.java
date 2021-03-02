package com.kristovski.sales.domain.salerecord;

import com.kristovski.sales.domain.common.BaseDao;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SaleRecordDao extends BaseDao {

    public List<SaleRecord> findAll() {
        final String query = """
                SELECT
                id, date_added, value, type, description, user_id
                FROM
                records
                """;
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            List<SaleRecord> allSaleRecords = new ArrayList<>();
            while (resultSet.next()) {
                SaleRecord saleRecord = mapRow(resultSet);
                allSaleRecords.add(saleRecord);
            }
            return allSaleRecords;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(SaleRecord saleRecord) {
        final String query = """
                INSERT INTO
                records (date_added, value, type, description, user_id)
                VALUES
                (?,?,?,?,?) 
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setObject(1, saleRecord.getDateAdded());
            statement.setBigDecimal(2, saleRecord.getValue());
            statement.setString(3, saleRecord.getType().name());
            statement.setInt(4, saleRecord.getUserId());
            statement.executeUpdate();
            ResultSet generatedKey = statement.getGeneratedKeys();
            if (generatedKey.next()) {
                saleRecord.setId(generatedKey.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private SaleRecord mapRow(ResultSet resultSet) throws SQLException {
        int recordId = resultSet.getInt("id");
        LocalDateTime dateAdded = resultSet.getTimestamp("date_added").toLocalDateTime();
        BigDecimal value = resultSet.getBigDecimal("value");
        SaleRecordType type = SaleRecordType.valueOf(resultSet.getString("type"));
        String description = resultSet.getString("description");
        int userId = resultSet.getInt("user_id");
        return new SaleRecord(recordId, dateAdded, value, type, description, userId);
    }
}
