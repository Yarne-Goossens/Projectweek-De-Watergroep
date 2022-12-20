create sequence "2Danhé".service_assignmentId;

create table "2Danhé".service_assignment (
                               id integer not null default nextval('"2Danhé".service_assignmentId'),
                               city character varying not null,
                               postal character varying(4) not null,
                               street character varying not null,
                               house_number character varying not null,
                               technician character varying,
                               "type" character varying not null,
                               start_date date not null,
                               end_date date,
                               "comment" character varying,
                               constraint service_assignment_pkey Primary key(id)
);

grant all privileges on schema "2Danhé" to hakkaton_02, local_r0854458, local_r0887519, local_r0663460, local_r0887747, local_r0867396, local_r0867998, local_r0867998, local_r0887053, local_s0212115, local_r0808540, local_r0790852 with grant option;
grant all privileges on ALL SEQUENCES IN SCHEMA "2Danhé" to hakkaton_02, local_r0854458, local_r0887519, local_r0663460, local_r0887747, local_r0867396, local_r0867998, local_r0867998, local_r0887053, local_s0212115, local_r0808540, local_r0790852 with grant option;
grant all privileges on ALL TABLES IN SCHEMA "2Danhé" to hakkaton_02, local_r0854458, local_r0887519, local_r0663460, local_r0887747, local_r0867396, local_r0867998, local_r0867998, local_r0887053, local_s0212115, local_r0808540, local_r0790852 with grant option;
