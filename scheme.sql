CREATE TABLE IF NOT EXISTS public.workers
(
    id            bigint                                              NOT NULL DEFAULT nextval('workers_id_seq'::regclass),
    name          character varying(255) COLLATE pg_catalog."default" NOT NULL,
    creation_date date                                                NOT NULL DEFAULT now(),
    salary        double precision                                    NOT NULL,
    start_date    date                                                NOT NULL,
    "position"    smallint,
    status        smallint                                            NOT NULL,
    p_birthday    date,
    p_hair_color  smallint,
    p_nationality smallint,
    p_loc_x       double precision,
    p_loc_y       double precision,
    p_loc_z       double precision,
    p_loc_name    character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT workers_pkey PRIMARY KEY (id)
)