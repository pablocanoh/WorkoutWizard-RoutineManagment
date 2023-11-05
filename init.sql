-- create alert table a load some initial data
create table Routine
(
    id           uuid primary key,
    created_date timestamp default now() NOT NULL,
    updated_date timestamp default now() NOT NULL,
    state        text                    NOT NULL
);

create table DaySession
(
    id           uuid primary key,
    created_date timestamp default now() NOT NULL,
    updated_date timestamp default now() NOT NULL,
    state        text                    NOT NULL,
    routine_id   uuid references Routine (id),
    dayOfWeek    text                    NOT NULL
);

create table Exercise
(
    id           uuid primary key,
    created_date timestamp default now() NOT NULL,
    updated_date timestamp default now() NOT NULL,
    state        text                    NOT NULL,
    name         text                    NOT NULL,
    description  text                    NOT NULL,
    bodyPart     text                    NOT NULL
);

create table ExerciseSession
(
    id           uuid primary key,
    created_date timestamp default now() NOT NULL,
    updated_date timestamp default now() NOT NULL,
    state        text                    NOT NULL,
    daySessionId uuid references DaySession (id),
    exerciseId   uuid references Exercise (id),
    numOfSets    integer                 NOT NULL,
    numOfReps    integer                 NOT NULL,
    weight       integer                 NOT NULL
);

-- dummy data
insert into Routine (id, state)
values ('00000000-0000-0000-0000-000000000000', 'ACTIVE');

insert into DaySession (id, state, routine_id, dayOfWeek)
values ('00000000-0000-0000-0000-000000000000', 'ACTIVE', '00000000-0000-0000-0000-000000000000', 'MONDAY');

insert into Exercise (id, state, name, description, bodyPart)
values ('00000000-0000-0000-0000-000000000000', 'ACTIVE', 'Bench Press', 'Bench Press', 'CHEST');

insert into ExerciseSession (id, state, daySessionId, exerciseId, numOfSets, numOfReps, weight)
values ('00000000-0000-0000-0000-000000000000', 'ACTIVE', '00000000-0000-0000-0000-000000000000',
        '00000000-0000-0000-0000-000000000000', 3, 10, 100);