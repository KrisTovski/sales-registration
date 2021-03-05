package com.kristovski.sales.domain.api;

import com.kristovski.sales.domain.salerecord.SaleRecord;
import com.kristovski.sales.domain.salerecord.SaleRecordDao;
import com.kristovski.sales.domain.salerecord.SaleRecordType;
import com.kristovski.sales.domain.user.UserDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class SaleRecordService {

    private final SaleRecordDao saleRecordDao = new SaleRecordDao();
    private final RecordMapper recordMapper = new RecordMapper();

    public void add(SaleRecordSaveRequestDto saveRequestDto, SaleRecordType type) {
        SaleRecord recordToSave = recordMapper.map(saveRequestDto, type);
        saleRecordDao.save(recordToSave);
    }

    public List<SaleRecordDto> findAll(int pageIndex, int pageSize) {

        return saleRecordDao.findAll(pageIndex, pageSize)
                .stream().map(RecordMapper::map)
                .collect(Collectors.toList());
    }

    public Integer getNumberOfRows() {
        return saleRecordDao.getNumberOfRows();
    }


    private static class RecordMapper {
        private final UserDao userDao = new UserDao();

        static SaleRecordDto map(SaleRecord r) {
            return new SaleRecordDto(
                    r.getId(),
                    r.getDateAdded(),
                    r.getValue(),
                    r.getType(),
                    r.getDescription()
            );

        }

        SaleRecord map(SaleRecordSaveRequestDto rs, SaleRecordType type) {

            return new SaleRecord(
                    LocalDateTime.now(),
                    rs.getValue(),
                    type,
                    rs.getDescription(),
                    userDao.findByUsername(rs.getAuthor())
                            .orElseThrow()
                            .getId()

            );
        }

    }
}
