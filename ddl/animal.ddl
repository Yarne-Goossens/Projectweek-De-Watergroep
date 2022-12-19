-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

CREATE SCHEMA 2Danhé;

CREATE SEQUENCE 2Danhé.animal_id_seq;

CREATE TABLE 2Danhé.animal
(   id integer NOT NULL DEFAULT nextval('2Danhé.animal_id_seq'::regclass),
    name character varying COLLATE pg_catalog."default" NOT NULL,
    type character varying COLLATE pg_catalog."default",
    food integer,
    CONSTRAINT animal_pkey PRIMARY KEY (id, name)
);

INSERT INTO 2Danhé.animal ("name","type","food") values ('Blub','vis',5);
INSERT INTO 2Danhé.animal ("name","type","food") values ('Mia','kat',7);

grant all privileges on schema 2Danhé to hakkaton_02;
grant all privileges on ALL TABLES IN SCHEMA 2Danhé to hakkaton_02;
grant all privileges on ALL SEQUENCES IN SCHEMA 2Danhé to hakkaton_02;


