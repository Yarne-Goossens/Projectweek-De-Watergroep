-- noinspection SqlNoDataSourceInspectionForFile
-- noinspection SqlDialectInspectionForFile

set search_path to "2Danhé";

CREATE SEQUENCE "2Danhé".employee_id_seq;

CREATE TABLE "2Danhé".employee
(
    id       integer                                        NOT NULL DEFAULT nextval('"2Danhé".employee_id_seq'::regclass),
    name     character varying COLLATE pg_catalog."default" NOT NULL,
    email    character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT employee_pkey PRIMARY KEY (id)
);

INSERT INTO "2Danhé".employee ("name", "email", "password")
values ('Bob', 'bob@wg.be', '1f40fc92da241694750979ee6cf582f2d5d7d28e18335de05abc54d0560e0f5302860c652bf08d560252aa5e74210546f369fbbbce8c12cfc7957b2652fe9a75');
INSERT INTO "2Danhé".employee ("name", "email", "password")
values ('test', 't@t.be', '99f97d455d5d62b24f3a942a1abc3fa8863fc0ce2037f52f09bd785b22b800d4f2e7b2b614cb600ffc2a4fe24679845b24886d69bb776fcfa46e54d188889c6f');
INSERT INTO "2Danhé".employee ("name", "email", "password")
values ('Yannick', 'yv@wg.be', 'ef71c21470c7c39f7ecd2a67c8d5dcd0cb9c8efeb1881ca85200943b08b040d3a0e6fabfaf91e23e877d19535f20e71902c569ee772412e92b11634343483df3');
INSERT INTO "2Danhé".employee ("name", "email", "password")
values ('Jan-Willem', 'jw@wg.be', 'ee1067d2c54d8b095bb7b3937aa40968cc3475e4360433a8bf816217e823271fcc9e7222dd9e57afb5675d999b88f49574ed8e6a3833b1437910e9aba7b6575f');

grant all privileges on schema "2Danhé" to hakkaton_02, local_r0854458, local_r0887519, local_r0663460, local_r0887747, local_r0867396, local_r0867998, local_r0867998, local_r0887053, local_s0212115, local_r0808540, local_r0790852 with grant option;
grant all privileges on ALL SEQUENCES IN SCHEMA "2Danhé" to hakkaton_02, local_r0854458, local_r0887519, local_r0663460, local_r0887747, local_r0867396, local_r0867998, local_r0867998, local_r0887053, local_s0212115, local_r0808540, local_r0790852 with grant option;
grant all privileges on ALL TABLES IN SCHEMA "2Danhé" to hakkaton_02, local_r0854458, local_r0887519, local_r0663460, local_r0887747, local_r0867396, local_r0867998, local_r0867998, local_r0887053, local_s0212115, local_r0808540, local_r0790852 with grant option;

hashed passwords:
t: 99f97d455d5d62b24f3a942a1abc3fa8863fc0ce2037f52f09bd785b22b800d4f2e7b2b614cb600ffc2a4fe24679845b24886d69bb776fcfa46e54d188889c6f
a: 1f40fc92da241694750979ee6cf582f2d5d7d28e18335de05abc54d0560e0f5302860c652bf08d560252aa5e74210546f369fbbbce8c12cfc7957b2652fe9a75
pwd: ee1067d2c54d8b095bb7b3937aa40968cc3475e4360433a8bf816217e823271fcc9e7222dd9e57afb5675d999b88f49574ed8e6a3833b1437910e9aba7b6575f
psw: ef71c21470c7c39f7ecd2a67c8d5dcd0cb9c8efeb1881ca85200943b08b040d3a0e6fabfaf91e23e877d19535f20e71902c569ee772412e92b11634343483df3