create sequence "2Danhé".reportId;

create table "2Danhé".leak (
                               id integer not null default nextval('"2Danhé".reportId'),
                               first_name character varying not null,
                               last_name character varying not null,
                               email character varying not null,
                               city character varying not null,
                               postal character varying(4) not null,
                               street character varying not null,
                               house_number character varying not null,
                               "comment" character varying not null,
                               constraint id_key Primary key(id)
);


grant all privileges on schema "2Danhé" to hakkaton_02, local_r0854458, local_r0887519, local_r0663460, local_r0887747, local_r0867396, local_r0867998, local_r0867998, local_r0887053, local_s0212115, local_r0808540, local_r0790852 with grant option;
grant all privileges on ALL SEQUENCES IN SCHEMA "2Danhé" to hakkaton_02, local_r0854458, local_r0887519, local_r0663460, local_r0887747, local_r0867396, local_r0867998, local_r0867998, local_r0887053, local_s0212115, local_r0808540, local_r0790852 with grant option;
grant all privileges on ALL TABLES IN SCHEMA "2Danhé" to hakkaton_02, local_r0854458, local_r0887519, local_r0663460, local_r0887747, local_r0867396, local_r0867998, local_r0867998, local_r0887053, local_s0212115, local_r0808540, local_r0790852 with grant option;