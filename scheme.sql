CREATE TABLE IF NOT EXISTS workers
(
    id            bigserial,
    name          varchar(255)     NOT NULL,
    creation_date date             NOT NULL DEFAULT now(),
    salary        double precision NOT NULL,
    start_date    date             NOT NULL,
    "position"    smallint,
    status        smallint         NOT NULL,
    p_birthday    date,
    p_hair_color  smallint,
    p_nationality smallint,
    p_loc_x       double precision,
    p_loc_y       double precision,
    p_loc_z       double precision,
    p_loc_name    varchar(255),
    CONSTRAINT workers_pkey PRIMARY KEY (id)
)