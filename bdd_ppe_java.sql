PGDMP         :                y           PPE2021_restauration_hou    9.4.19    11.1 !    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            ?           1262    26551    PPE2021_restauration_hou    DATABASE     ?   CREATE DATABASE "PPE2021_restauration_hou" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';
 *   DROP DATABASE "PPE2021_restauration_hou";
             hou    false            ?           0    0 #   DATABASE "PPE2021_restauration_hou"    ACL     ?   REVOKE ALL ON DATABASE "PPE2021_restauration_hou" FROM PUBLIC;
REVOKE ALL ON DATABASE "PPE2021_restauration_hou" FROM hou;
GRANT ALL ON DATABASE "PPE2021_restauration_hou" TO hou;
GRANT CONNECT,TEMPORARY ON DATABASE "PPE2021_restauration_hou" TO PUBLIC;
                  hou    false    2040            ?           0    0    SCHEMA public    ACL     ?   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                  postgres    false    6            ?            1259    47229    commande    TABLE     u   CREATE TABLE public.commande (
    idpatient integer,
    idrepas integer,
    date date,
    id integer NOT NULL
);
    DROP TABLE public.commande;
       public      	   guendouzi    false            ?            1259    47262    commande_id_seq    SEQUENCE     x   CREATE SEQUENCE public.commande_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.commande_id_seq;
       public    	   guendouzi    false    177            ?           0    0    commande_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.commande_id_seq OWNED BY public.commande.id;
            public    	   guendouzi    false    178            ?            1259    26614    patient    TABLE     ?   CREATE TABLE public.patient (
    id integer NOT NULL,
    nom character varying NOT NULL,
    prenom character varying NOT NULL,
    numchambre integer NOT NULL,
    idservice integer NOT NULL
);
    DROP TABLE public.patient;
       public      	   guendouzi    false            ?           0    0    TABLE patient    ACL     ?   REVOKE ALL ON TABLE public.patient FROM PUBLIC;
REVOKE ALL ON TABLE public.patient FROM guendouzi;
GRANT ALL ON TABLE public.patient TO guendouzi;
GRANT ALL ON TABLE public.patient TO hou;
            public    	   guendouzi    false    173            ?            1259    26638 	   personnel    TABLE     ?   CREATE TABLE public.personnel (
    id integer NOT NULL,
    nom character varying NOT NULL,
    idservice integer NOT NULL,
    password character varying
);
    DROP TABLE public.personnel;
       public      	   guendouzi    false            ?           0    0    TABLE personnel    ACL     ?   REVOKE ALL ON TABLE public.personnel FROM PUBLIC;
REVOKE ALL ON TABLE public.personnel FROM guendouzi;
GRANT ALL ON TABLE public.personnel TO guendouzi;
GRANT ALL ON TABLE public.personnel TO hou;
            public    	   guendouzi    false    176            ?            1259    26622    repas    TABLE     _   CREATE TABLE public.repas (
    id integer NOT NULL,
    libelle character varying NOT NULL
);
    DROP TABLE public.repas;
       public      	   guendouzi    false            ?           0    0    TABLE repas    ACL     ?   REVOKE ALL ON TABLE public.repas FROM PUBLIC;
REVOKE ALL ON TABLE public.repas FROM guendouzi;
GRANT ALL ON TABLE public.repas TO guendouzi;
GRANT ALL ON TABLE public.repas TO hou;
            public    	   guendouzi    false    174            ?            1259    26630    service    TABLE     a   CREATE TABLE public.service (
    id integer NOT NULL,
    libelle character varying NOT NULL
);
    DROP TABLE public.service;
       public      	   guendouzi    false            ?           0    0    TABLE service    ACL     ?   REVOKE ALL ON TABLE public.service FROM PUBLIC;
REVOKE ALL ON TABLE public.service FROM guendouzi;
GRANT ALL ON TABLE public.service TO guendouzi;
GRANT ALL ON TABLE public.service TO hou;
            public    	   guendouzi    false    175            q           2604    47264    commande id    DEFAULT     j   ALTER TABLE ONLY public.commande ALTER COLUMN id SET DEFAULT nextval('public.commande_id_seq'::regclass);
 :   ALTER TABLE public.commande ALTER COLUMN id DROP DEFAULT;
       public    	   guendouzi    false    178    177            ?          0    47229    commande 
   TABLE DATA               @   COPY public.commande (idpatient, idrepas, date, id) FROM stdin;
    public    	   guendouzi    false    177   $       ?          0    26614    patient 
   TABLE DATA               I   COPY public.patient (id, nom, prenom, numchambre, idservice) FROM stdin;
    public    	   guendouzi    false    173   k$       ?          0    26638 	   personnel 
   TABLE DATA               A   COPY public.personnel (id, nom, idservice, password) FROM stdin;
    public    	   guendouzi    false    176   ]%       ?          0    26622    repas 
   TABLE DATA               ,   COPY public.repas (id, libelle) FROM stdin;
    public    	   guendouzi    false    174   ?%       ?          0    26630    service 
   TABLE DATA               .   COPY public.service (id, libelle) FROM stdin;
    public    	   guendouzi    false    175   ?%                   0    0    commande_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.commande_id_seq', 24, true);
            public    	   guendouzi    false    178            {           2606    47266    commande commande_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.commande
    ADD CONSTRAINT commande_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.commande DROP CONSTRAINT commande_pkey;
       public      	   guendouzi    false    177            s           2606    26621    patient patient_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.patient
    ADD CONSTRAINT patient_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.patient DROP CONSTRAINT patient_pkey;
       public      	   guendouzi    false    173            y           2606    26645    personnel personnel_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.personnel
    ADD CONSTRAINT personnel_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.personnel DROP CONSTRAINT personnel_pkey;
       public      	   guendouzi    false    176            u           2606    26629    repas repas_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.repas
    ADD CONSTRAINT repas_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.repas DROP CONSTRAINT repas_pkey;
       public      	   guendouzi    false    174            w           2606    26637    service service_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.service
    ADD CONSTRAINT service_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.service DROP CONSTRAINT service_pkey;
       public      	   guendouzi    false    175            ~           2606    47234    commande ce_idpatient_patient    FK CONSTRAINT     ?   ALTER TABLE ONLY public.commande
    ADD CONSTRAINT ce_idpatient_patient FOREIGN KEY (idpatient) REFERENCES public.patient(id);
 G   ALTER TABLE ONLY public.commande DROP CONSTRAINT ce_idpatient_patient;
       public    	   guendouzi    false    1907    173    177                       2606    47239    commande ce_idrepas_repas    FK CONSTRAINT     x   ALTER TABLE ONLY public.commande
    ADD CONSTRAINT ce_idrepas_repas FOREIGN KEY (idrepas) REFERENCES public.repas(id);
 C   ALTER TABLE ONLY public.commande DROP CONSTRAINT ce_idrepas_repas;
       public    	   guendouzi    false    1909    174    177            |           2606    26646    patient ce_idservice_service    FK CONSTRAINT        ALTER TABLE ONLY public.patient
    ADD CONSTRAINT ce_idservice_service FOREIGN KEY (idservice) REFERENCES public.service(id);
 F   ALTER TABLE ONLY public.patient DROP CONSTRAINT ce_idservice_service;
       public    	   guendouzi    false    173    175    1911            }           2606    26651    personnel ce_idservice_service    FK CONSTRAINT     ?   ALTER TABLE ONLY public.personnel
    ADD CONSTRAINT ce_idservice_service FOREIGN KEY (idservice) REFERENCES public.service(id);
 H   ALTER TABLE ONLY public.personnel DROP CONSTRAINT ce_idservice_service;
       public    	   guendouzi    false    1911    175    176            ?   I   x?e???0???KIvH3?_?#??sg?´k?q???????)1g??ڷ????F?z?1r??u ??? ?      ?   ?   x?U?Ak!????)?cK?M??BJ!Ћ?%?.Z)??w쩽x??7??>B?>??Vh?%????I??????K?8͖ٛdh<W?T?[J???6mvx\?m^0???`HՀ????????A??Dq񎟡x??y?9??}f[W*?q??z]?-a???6B???S?g?"?щi???j.x%?]??p??lz??[E#J?m?ٝnJ??<??zҍ???$#>????Q5      ?   C   x?3?L/M?K?/???4?,I-.?2???/?4?pL8??sR?ܜT?@AA*?)gjQj?)DE? $?      ?   -   x?3?,N?+V(?L?KI?2??r?K??S??9?R???b???? !??      ?   Q   x?3?,JM???M,????2?,H-?,IUH?KK?KN?2?LLN?/M?H?M?+?2??/8???????$??M--?????? Lv     