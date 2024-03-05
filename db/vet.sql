PGDMP  $    4                |            vet    16.1    16.1 <    +           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ,           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            -           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            .           1262    32958    vet    DATABASE     ~   CREATE DATABASE vet WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE vet;
                postgres    false            �            1259    35327    animals    TABLE     B  CREATE TABLE public.animals (
    animal_id bigint NOT NULL,
    animal_breed character varying(255),
    animal_color character varying(255),
    animal_date_of_birth date,
    animal_gender character varying(255),
    animal_name character varying(255),
    animal_species character varying(255),
    owner_id bigint
);
    DROP TABLE public.animals;
       public         heap    postgres    false            �            1259    35326    animals_animal_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.animals_animal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.animals_animal_id_seq;
       public          postgres    false    218            /           0    0    animals_animal_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.animals_animal_id_seq OWNED BY public.animals.animal_id;
          public          postgres    false    217            �            1259    35336    appointments    TABLE     �   CREATE TABLE public.appointments (
    appointment_id bigint NOT NULL,
    appointment_date timestamp(6) without time zone,
    appointment_animal_id bigint,
    appointment_doctor_id bigint
);
     DROP TABLE public.appointments;
       public         heap    postgres    false            �            1259    35335    appointments_appointment_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointments_appointment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.appointments_appointment_id_seq;
       public          postgres    false    220            0           0    0    appointments_appointment_id_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.appointments_appointment_id_seq OWNED BY public.appointments.appointment_id;
          public          postgres    false    219            �            1259    35343    available_dates    TABLE     �   CREATE TABLE public.available_dates (
    available_date_id bigint NOT NULL,
    available_date date,
    available_date_doctor_id bigint
);
 #   DROP TABLE public.available_dates;
       public         heap    postgres    false            �            1259    35342 %   available_dates_available_date_id_seq    SEQUENCE     �   CREATE SEQUENCE public.available_dates_available_date_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 <   DROP SEQUENCE public.available_dates_available_date_id_seq;
       public          postgres    false    222            1           0    0 %   available_dates_available_date_id_seq    SEQUENCE OWNED BY     o   ALTER SEQUENCE public.available_dates_available_date_id_seq OWNED BY public.available_dates.available_date_id;
          public          postgres    false    221            �            1259    34885 	   customers    TABLE       CREATE TABLE public.customers (
    customer_id bigint NOT NULL,
    customer_address character varying(255),
    customer_city character varying(255),
    customer_email character varying(255),
    customer_name character varying(255),
    customer_phone character varying(255)
);
    DROP TABLE public.customers;
       public         heap    postgres    false            �            1259    34884    customers_customer_id_seq    SEQUENCE     �   CREATE SEQUENCE public.customers_customer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.customers_customer_id_seq;
       public          postgres    false    216            2           0    0    customers_customer_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.customers_customer_id_seq OWNED BY public.customers.customer_id;
          public          postgres    false    215            �            1259    35350    doctors    TABLE       CREATE TABLE public.doctors (
    doctor_id bigint NOT NULL,
    doctor_address character varying(255),
    doctor_city character varying(255),
    doctor_email character varying(255),
    doctor_name character varying(255),
    doctor_phone character varying(255)
);
    DROP TABLE public.doctors;
       public         heap    postgres    false            �            1259    35349    doctors_doctor_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.doctors_doctor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.doctors_doctor_id_seq;
       public          postgres    false    224            3           0    0    doctors_doctor_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.doctors_doctor_id_seq OWNED BY public.doctors.doctor_id;
          public          postgres    false    223            �            1259    35359    owners    TABLE       CREATE TABLE public.owners (
    owner_id bigint NOT NULL,
    owner_address character varying(255),
    owner_city character varying(255),
    owner_email character varying(255),
    owner_name character varying(255),
    owner_phone character varying(255)
);
    DROP TABLE public.owners;
       public         heap    postgres    false            �            1259    35358    owners_owner_id_seq    SEQUENCE     |   CREATE SEQUENCE public.owners_owner_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.owners_owner_id_seq;
       public          postgres    false    226            4           0    0    owners_owner_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.owners_owner_id_seq OWNED BY public.owners.owner_id;
          public          postgres    false    225            �            1259    35368    vaccines    TABLE     �   CREATE TABLE public.vaccines (
    vaccine_id bigint NOT NULL,
    vaccine_code character varying(255),
    vaccination_end_date date,
    vaccine_name character varying(255),
    vaccination_date date,
    animal_id bigint
);
    DROP TABLE public.vaccines;
       public         heap    postgres    false            �            1259    35367    vaccines_vaccine_id_seq    SEQUENCE     �   CREATE SEQUENCE public.vaccines_vaccine_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.vaccines_vaccine_id_seq;
       public          postgres    false    228            5           0    0    vaccines_vaccine_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.vaccines_vaccine_id_seq OWNED BY public.vaccines.vaccine_id;
          public          postgres    false    227            o           2604    35330    animals animal_id    DEFAULT     v   ALTER TABLE ONLY public.animals ALTER COLUMN animal_id SET DEFAULT nextval('public.animals_animal_id_seq'::regclass);
 @   ALTER TABLE public.animals ALTER COLUMN animal_id DROP DEFAULT;
       public          postgres    false    218    217    218            p           2604    35339    appointments appointment_id    DEFAULT     �   ALTER TABLE ONLY public.appointments ALTER COLUMN appointment_id SET DEFAULT nextval('public.appointments_appointment_id_seq'::regclass);
 J   ALTER TABLE public.appointments ALTER COLUMN appointment_id DROP DEFAULT;
       public          postgres    false    220    219    220            q           2604    35346 !   available_dates available_date_id    DEFAULT     �   ALTER TABLE ONLY public.available_dates ALTER COLUMN available_date_id SET DEFAULT nextval('public.available_dates_available_date_id_seq'::regclass);
 P   ALTER TABLE public.available_dates ALTER COLUMN available_date_id DROP DEFAULT;
       public          postgres    false    222    221    222            n           2604    34888    customers customer_id    DEFAULT     ~   ALTER TABLE ONLY public.customers ALTER COLUMN customer_id SET DEFAULT nextval('public.customers_customer_id_seq'::regclass);
 D   ALTER TABLE public.customers ALTER COLUMN customer_id DROP DEFAULT;
       public          postgres    false    215    216    216            r           2604    35353    doctors doctor_id    DEFAULT     v   ALTER TABLE ONLY public.doctors ALTER COLUMN doctor_id SET DEFAULT nextval('public.doctors_doctor_id_seq'::regclass);
 @   ALTER TABLE public.doctors ALTER COLUMN doctor_id DROP DEFAULT;
       public          postgres    false    224    223    224            s           2604    35362    owners owner_id    DEFAULT     r   ALTER TABLE ONLY public.owners ALTER COLUMN owner_id SET DEFAULT nextval('public.owners_owner_id_seq'::regclass);
 >   ALTER TABLE public.owners ALTER COLUMN owner_id DROP DEFAULT;
       public          postgres    false    226    225    226            t           2604    35371    vaccines vaccine_id    DEFAULT     z   ALTER TABLE ONLY public.vaccines ALTER COLUMN vaccine_id SET DEFAULT nextval('public.vaccines_vaccine_id_seq'::regclass);
 B   ALTER TABLE public.vaccines ALTER COLUMN vaccine_id DROP DEFAULT;
       public          postgres    false    228    227    228                      0    35327    animals 
   TABLE DATA           �   COPY public.animals (animal_id, animal_breed, animal_color, animal_date_of_birth, animal_gender, animal_name, animal_species, owner_id) FROM stdin;
    public          postgres    false    218   zI                  0    35336    appointments 
   TABLE DATA           v   COPY public.appointments (appointment_id, appointment_date, appointment_animal_id, appointment_doctor_id) FROM stdin;
    public          postgres    false    220   GJ       "          0    35343    available_dates 
   TABLE DATA           f   COPY public.available_dates (available_date_id, available_date, available_date_doctor_id) FROM stdin;
    public          postgres    false    222   �J                 0    34885 	   customers 
   TABLE DATA           �   COPY public.customers (customer_id, customer_address, customer_city, customer_email, customer_name, customer_phone) FROM stdin;
    public          postgres    false    216   �J       $          0    35350    doctors 
   TABLE DATA           r   COPY public.doctors (doctor_id, doctor_address, doctor_city, doctor_email, doctor_name, doctor_phone) FROM stdin;
    public          postgres    false    224   	K       &          0    35359    owners 
   TABLE DATA           k   COPY public.owners (owner_id, owner_address, owner_city, owner_email, owner_name, owner_phone) FROM stdin;
    public          postgres    false    226   �K       (          0    35368    vaccines 
   TABLE DATA           }   COPY public.vaccines (vaccine_id, vaccine_code, vaccination_end_date, vaccine_name, vaccination_date, animal_id) FROM stdin;
    public          postgres    false    228   4L       6           0    0    animals_animal_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.animals_animal_id_seq', 6, true);
          public          postgres    false    217            7           0    0    appointments_appointment_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.appointments_appointment_id_seq', 7, true);
          public          postgres    false    219            8           0    0 %   available_dates_available_date_id_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('public.available_dates_available_date_id_seq', 5, true);
          public          postgres    false    221            9           0    0    customers_customer_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.customers_customer_id_seq', 1, false);
          public          postgres    false    215            :           0    0    doctors_doctor_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.doctors_doctor_id_seq', 5, true);
          public          postgres    false    223            ;           0    0    owners_owner_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.owners_owner_id_seq', 5, true);
          public          postgres    false    225            <           0    0    vaccines_vaccine_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.vaccines_vaccine_id_seq', 6, true);
          public          postgres    false    227            |           2606    35334    animals animals_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (animal_id);
 >   ALTER TABLE ONLY public.animals DROP CONSTRAINT animals_pkey;
       public            postgres    false    218            ~           2606    35341    appointments appointments_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT appointments_pkey PRIMARY KEY (appointment_id);
 H   ALTER TABLE ONLY public.appointments DROP CONSTRAINT appointments_pkey;
       public            postgres    false    220            �           2606    35348 $   available_dates available_dates_pkey 
   CONSTRAINT     q   ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT available_dates_pkey PRIMARY KEY (available_date_id);
 N   ALTER TABLE ONLY public.available_dates DROP CONSTRAINT available_dates_pkey;
       public            postgres    false    222            v           2606    34892    customers customers_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (customer_id);
 B   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_pkey;
       public            postgres    false    216            �           2606    35357    doctors doctors_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.doctors
    ADD CONSTRAINT doctors_pkey PRIMARY KEY (doctor_id);
 >   ALTER TABLE ONLY public.doctors DROP CONSTRAINT doctors_pkey;
       public            postgres    false    224            �           2606    35366    owners owners_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.owners
    ADD CONSTRAINT owners_pkey PRIMARY KEY (owner_id);
 <   ALTER TABLE ONLY public.owners DROP CONSTRAINT owners_pkey;
       public            postgres    false    226            x           2606    34912 &   customers uk_47v7cerfyndk4lx4vcu64cxyl 
   CONSTRAINT     k   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT uk_47v7cerfyndk4lx4vcu64cxyl UNIQUE (customer_email);
 P   ALTER TABLE ONLY public.customers DROP CONSTRAINT uk_47v7cerfyndk4lx4vcu64cxyl;
       public            postgres    false    216            z           2606    34914 &   customers uk_bn3wq4vhuqco545y52xp96gqd 
   CONSTRAINT     k   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT uk_bn3wq4vhuqco545y52xp96gqd UNIQUE (customer_phone);
 P   ALTER TABLE ONLY public.customers DROP CONSTRAINT uk_bn3wq4vhuqco545y52xp96gqd;
       public            postgres    false    216            �           2606    35375    vaccines vaccines_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT vaccines_pkey PRIMARY KEY (vaccine_id);
 @   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT vaccines_pkey;
       public            postgres    false    228            �           2606    35386 '   appointments fk27d0xcbajwaeeun2doojsae4    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fk27d0xcbajwaeeun2doojsae4 FOREIGN KEY (appointment_doctor_id) REFERENCES public.doctors(doctor_id);
 Q   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fk27d0xcbajwaeeun2doojsae4;
       public          postgres    false    220    4738    224            �           2606    35396 $   vaccines fkeasdy15b2kp5j4k13x2dfudqs    FK CONSTRAINT     �   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT fkeasdy15b2kp5j4k13x2dfudqs FOREIGN KEY (animal_id) REFERENCES public.animals(animal_id);
 N   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT fkeasdy15b2kp5j4k13x2dfudqs;
       public          postgres    false    4732    228    218            �           2606    35391 *   available_dates fkf7jtwolyhaj07c4oh0j4pncb    FK CONSTRAINT     �   ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT fkf7jtwolyhaj07c4oh0j4pncb FOREIGN KEY (available_date_doctor_id) REFERENCES public.doctors(doctor_id);
 T   ALTER TABLE ONLY public.available_dates DROP CONSTRAINT fkf7jtwolyhaj07c4oh0j4pncb;
       public          postgres    false    224    4738    222            �           2606    35376 "   animals fkgr5mmh0igp89obm9dye25jsi    FK CONSTRAINT     �   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT fkgr5mmh0igp89obm9dye25jsi FOREIGN KEY (owner_id) REFERENCES public.owners(owner_id);
 L   ALTER TABLE ONLY public.animals DROP CONSTRAINT fkgr5mmh0igp89obm9dye25jsi;
       public          postgres    false    4740    226    218            �           2606    35381 (   appointments fko4t945rb708af9ry6syof7bwt    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fko4t945rb708af9ry6syof7bwt FOREIGN KEY (appointment_animal_id) REFERENCES public.animals(animal_id);
 R   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fko4t945rb708af9ry6syof7bwt;
       public          postgres    false    218    4732    220               �   x�m����@D��_�(&c�=j�,����e/=I�CFf'�{M���BS��UwU�[��xqQ�NS3�&����`ˍG�	�X�\i��sY�e�v��[�)�Z�U����t�vR��_�+��v��_	X4�	�yrU��a(þ���eT<�C�䣷��e%�S_!�9�1p;��W����������`�MN          R   x�]��	� E��d
��%&Bg��s��h-ܿ��h����n����zH|��S�Җ@���O�*^�S�OlI����b��=      "   3   x�EǱ  ���EP�q�9��t1�2��0�������FwW�{�wxA�            x������ � �      $   �   x���O
B!��s�9A��(�n�F�R�9���'�Т��w�ߚ�QmJ�?��r��C;_�T�^�ȲM�+��_z�9��bТiѴ`�h/��l? @��6 ٱx�ۗ��ԠUӪi�6��xЁnN�^�y o��d�      &   y   x�3�,I-.QHLI)J-.s�3K*������铘��PT��
Q���eD�F���Ĝ��Ă�"�^c��:���T�k5!JkP~zj�BpIjQNf^:\�)Q��s��32Kލ���� i>jx      (   �   x�]�K
�0��ur�\��k��� \u3�S: 㢧���۟�fF���J2%U�0���Nh����M��R_k�H�h�ǅfgE���Y�B'��N����:�d܁(��b�Zo� T{.���d`�1/�!Z7��-���]OY���g~U����ɡ~��.��^{Gc     