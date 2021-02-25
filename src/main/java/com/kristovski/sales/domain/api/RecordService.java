package com.kristovski.sales.domain.api;

import com.kristovski.sales.domain.record.Record;
import com.kristovski.sales.domain.record.RecordDao;

import java.util.List;
import java.util.stream.Collectors;

public class RecordService {

    private final RecordDao recordDao = new RecordDao();

    public List<RecordDto> findAll() {
        return recordDao.findAll()
                .stream().map(RecordMapper::map)
                .collect(Collectors.toList());
    }

    private static class RecordMapper {
        static RecordDto map(Record r) {
            return new RecordDto(
                    r.getId(),
                    r.getDateAdded(),
                    r.getValue(),
                    r.getType(),
                    r.getDescription()
            );

        }
    }
}
