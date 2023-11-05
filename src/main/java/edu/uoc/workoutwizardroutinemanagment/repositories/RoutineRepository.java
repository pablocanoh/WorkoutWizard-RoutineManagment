package edu.uoc.workoutwizardroutinemanagment.repositories;

import com.edu.jooq.tables.pojos.Routine;
import edu.uoc.workoutwizardroutinemanagment.repositories.mappers.RoutineMapper;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

import static com.edu.jooq.tables.Routine.ROUTINE;

@Repository
public class RoutineRepository {

    private final DSLContext dsl;

    @Autowired
    public RoutineRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public Collection<Routine> selectAll() {
        return RoutineMapper.map(dsl.selectFrom(ROUTINE).fetch());
    }
}
