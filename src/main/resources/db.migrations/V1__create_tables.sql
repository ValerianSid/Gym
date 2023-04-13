CREATE TABLE gym.gym_user (
    id bigserial primary key,
    name varchar(255),
    uuid uuid,
    phone varchar(255),
    email varchar(255),
    role varchar(255),
    last_entry date
);

CREATE TABLE gym.basic_exercise (
    id bigserial primary key,
    name varchar(255),
    instruction varchar(255),
    muscle_group varchar(255)
);

CREATE TABLE gym.training_programm (
    id bigserial primary key,
    name varchar(255),
    description varchar(255)
);

CREATE TABLE gym.training_programm_exercise (
    id bigserial primary key,
    description varchar(255),
    basic_exercise_id bigint references basic_exercise(id),
    training_programm_id bigint references training_programm(id)
);

CREATE TABLE gym.individual_training_programm (
    id bigserial primary key,
    name varchar(255),
    description varchar(255),
    gym_user_id bigint references gym_user(id)
);

CREATE TABLE gym.individual_exercise (
    id bigserial primary key,
    description varchar(255),
    repeats smallint,
    execution_time smallint,
    weight real,
    individual_training_programm_id bigint references individual_training_programm(id),
    basic_exercise_id bigint references basic_exercise(id)
);

CREATE TABLE gym.complete_training (
    id bigserial primary key,
    execution_date date,
    individual_training_programm_id bigint references individual_training_programm(id)
);