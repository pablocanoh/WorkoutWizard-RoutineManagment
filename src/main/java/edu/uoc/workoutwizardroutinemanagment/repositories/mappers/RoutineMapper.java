package edu.uoc.workoutwizardroutinemanagment.repositories.mappers;

import com.edu.jooq.tables.pojos.Routine;
import com.edu.jooq.tables.records.RoutineRecord;

import java.util.Collection;

public final class RoutineMapper {

    private RoutineMapper() {
        // This class is not meant to be instantiated
    }

    public static Routine map(RoutineRecord record) {
        return new Routine(
            record.getId(),
            record.getCreatedDate(),
            record.getUpdatedDate(),
            record.getState()
        );
    }

    public static Collection<Routine> map(Collection<RoutineRecord> record) {
        return record.stream().map(RoutineMapper::map).toList();
    }
}
