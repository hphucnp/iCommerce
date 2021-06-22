--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: icommerce; Type: SCHEMA; Schema: -; Owner: todo
--

CREATE SCHEMA icommerce;


ALTER SCHEMA icommerce OWNER TO todo;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: brand; Type: TABLE; Schema: icommerce; Owner: todo
--

CREATE TABLE icommerce.brand (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE icommerce.brand OWNER TO todo;

--
-- Name: brand_id_seq; Type: SEQUENCE; Schema: icommerce; Owner: todo
--

CREATE SEQUENCE icommerce.brand_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE icommerce.brand_id_seq OWNER TO todo;

--
-- Name: brand_id_seq; Type: SEQUENCE OWNED BY; Schema: icommerce; Owner: todo
--

ALTER SEQUENCE icommerce.brand_id_seq OWNED BY icommerce.brand.id;


--
-- Name: cart; Type: TABLE; Schema: icommerce; Owner: todo
--

CREATE TABLE icommerce.cart (
    user_id bigint NOT NULL
);


ALTER TABLE icommerce.cart OWNER TO todo;

--
-- Name: cart_product; Type: TABLE; Schema: icommerce; Owner: todo
--

CREATE TABLE icommerce.cart_product (
    cart_id bigint NOT NULL,
    product_id bigint NOT NULL,
    quantity integer NOT NULL
);


ALTER TABLE icommerce.cart_product OWNER TO todo;

--
-- Name: category; Type: TABLE; Schema: icommerce; Owner: todo
--

CREATE TABLE icommerce.category (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE icommerce.category OWNER TO todo;

--
-- Name: category_id_seq; Type: SEQUENCE; Schema: icommerce; Owner: todo
--

CREATE SEQUENCE icommerce.category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE icommerce.category_id_seq OWNER TO todo;

--
-- Name: category_id_seq; Type: SEQUENCE OWNED BY; Schema: icommerce; Owner: todo
--

ALTER SEQUENCE icommerce.category_id_seq OWNED BY icommerce.category.id;


--
-- Name: order; Type: TABLE; Schema: icommerce; Owner: todo
--

CREATE TABLE icommerce."order" (
    id bigint NOT NULL,
    status integer,
    cart_user_id bigint
);


ALTER TABLE icommerce."order" OWNER TO todo;

--
-- Name: order_id_seq; Type: SEQUENCE; Schema: icommerce; Owner: todo
--

CREATE SEQUENCE icommerce.order_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE icommerce.order_id_seq OWNER TO todo;

--
-- Name: order_id_seq; Type: SEQUENCE OWNED BY; Schema: icommerce; Owner: todo
--

ALTER SEQUENCE icommerce.order_id_seq OWNED BY icommerce."order".id;


--
-- Name: order_product; Type: TABLE; Schema: icommerce; Owner: todo
--

CREATE TABLE icommerce.order_product (
    order_id bigint NOT NULL,
    product_id bigint NOT NULL,
    quantity integer NOT NULL
);


ALTER TABLE icommerce.order_product OWNER TO todo;

--
-- Name: orders; Type: TABLE; Schema: icommerce; Owner: todo
--

CREATE TABLE icommerce.orders (
    id bigint NOT NULL,
    status integer,
    cart_user_id bigint
);


ALTER TABLE icommerce.orders OWNER TO todo;

--
-- Name: orders_id_seq; Type: SEQUENCE; Schema: icommerce; Owner: todo
--

CREATE SEQUENCE icommerce.orders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE icommerce.orders_id_seq OWNER TO todo;

--
-- Name: orders_id_seq; Type: SEQUENCE OWNED BY; Schema: icommerce; Owner: todo
--

ALTER SEQUENCE icommerce.orders_id_seq OWNED BY icommerce.orders.id;


--
-- Name: product; Type: TABLE; Schema: icommerce; Owner: todo
--

CREATE TABLE icommerce.product (
    id bigint NOT NULL,
    color integer,
    name character varying(255),
    price numeric(19,2),
    brand_id bigint,
    category_id bigint
);


ALTER TABLE icommerce.product OWNER TO todo;

--
-- Name: product_id_seq; Type: SEQUENCE; Schema: icommerce; Owner: todo
--

CREATE SEQUENCE icommerce.product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE icommerce.product_id_seq OWNER TO todo;

--
-- Name: product_id_seq; Type: SEQUENCE OWNED BY; Schema: icommerce; Owner: todo
--

ALTER SEQUENCE icommerce.product_id_seq OWNED BY icommerce.product.id;


--
-- Name: user; Type: TABLE; Schema: icommerce; Owner: todo
--

CREATE TABLE icommerce."user" (
    id bigint NOT NULL,
    username character varying(255)
);


ALTER TABLE icommerce."user" OWNER TO todo;

--
-- Name: user_id_seq; Type: SEQUENCE; Schema: icommerce; Owner: todo
--

CREATE SEQUENCE icommerce.user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE icommerce.user_id_seq OWNER TO todo;

--
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: icommerce; Owner: todo
--

ALTER SEQUENCE icommerce.user_id_seq OWNED BY icommerce."user".id;


--
-- Name: brand id; Type: DEFAULT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce.brand ALTER COLUMN id SET DEFAULT nextval('icommerce.brand_id_seq'::regclass);


--
-- Name: category id; Type: DEFAULT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce.category ALTER COLUMN id SET DEFAULT nextval('icommerce.category_id_seq'::regclass);


--
-- Name: order id; Type: DEFAULT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce."order" ALTER COLUMN id SET DEFAULT nextval('icommerce.order_id_seq'::regclass);


--
-- Name: orders id; Type: DEFAULT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce.orders ALTER COLUMN id SET DEFAULT nextval('icommerce.orders_id_seq'::regclass);


--
-- Name: product id; Type: DEFAULT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce.product ALTER COLUMN id SET DEFAULT nextval('icommerce.product_id_seq'::regclass);


--
-- Name: user id; Type: DEFAULT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce."user" ALTER COLUMN id SET DEFAULT nextval('icommerce.user_id_seq'::regclass);


--
-- Data for Name: brand; Type: TABLE DATA; Schema: icommerce; Owner: todo
--

COPY icommerce.brand (id, name) FROM stdin;
1	Pepsi
2	Cocacola
3	Apple
\.


--
-- Data for Name: cart; Type: TABLE DATA; Schema: icommerce; Owner: todo
--

COPY icommerce.cart (user_id) FROM stdin;
1
\.


--
-- Data for Name: cart_product; Type: TABLE DATA; Schema: icommerce; Owner: todo
--

COPY icommerce.cart_product (cart_id, product_id, quantity) FROM stdin;
1	1	3
\.


--
-- Data for Name: category; Type: TABLE DATA; Schema: icommerce; Owner: todo
--

COPY icommerce.category (id, name) FROM stdin;
3	electronics device
2	food
1	beverage
\.


--
-- Data for Name: order; Type: TABLE DATA; Schema: icommerce; Owner: todo
--

COPY icommerce."order" (id, status, cart_user_id) FROM stdin;
\.


--
-- Data for Name: order_product; Type: TABLE DATA; Schema: icommerce; Owner: todo
--

COPY icommerce.order_product (order_id, product_id, quantity) FROM stdin;
\.


--
-- Data for Name: orders; Type: TABLE DATA; Schema: icommerce; Owner: todo
--

COPY icommerce.orders (id, status, cart_user_id) FROM stdin;
\.


--
-- Data for Name: product; Type: TABLE DATA; Schema: icommerce; Owner: todo
--

COPY icommerce.product (id, color, name, price, brand_id, category_id) FROM stdin;
1	1	Pepsi Light	10000.00	1	1
3	1	Pepsi Poca	5000.00	1	2
2	0	Cocacola Zero	10000.00	2	1
4	2	Iphone	40000000.00	3	3
\.


--
-- Data for Name: user; Type: TABLE DATA; Schema: icommerce; Owner: todo
--

COPY icommerce."user" (id, username) FROM stdin;
1	admin
\.


--
-- Name: brand_id_seq; Type: SEQUENCE SET; Schema: icommerce; Owner: todo
--

SELECT pg_catalog.setval('icommerce.brand_id_seq', 1, false);


--
-- Name: category_id_seq; Type: SEQUENCE SET; Schema: icommerce; Owner: todo
--

SELECT pg_catalog.setval('icommerce.category_id_seq', 1, false);


--
-- Name: order_id_seq; Type: SEQUENCE SET; Schema: icommerce; Owner: todo
--

SELECT pg_catalog.setval('icommerce.order_id_seq', 1, false);


--
-- Name: orders_id_seq; Type: SEQUENCE SET; Schema: icommerce; Owner: todo
--

SELECT pg_catalog.setval('icommerce.orders_id_seq', 1, false);


--
-- Name: product_id_seq; Type: SEQUENCE SET; Schema: icommerce; Owner: todo
--

SELECT pg_catalog.setval('icommerce.product_id_seq', 1, false);


--
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: icommerce; Owner: todo
--

SELECT pg_catalog.setval('icommerce.user_id_seq', 1, false);


--
-- Name: brand brand_pkey; Type: CONSTRAINT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce.brand
    ADD CONSTRAINT brand_pkey PRIMARY KEY (id);


--
-- Name: cart cart_pkey; Type: CONSTRAINT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce.cart
    ADD CONSTRAINT cart_pkey PRIMARY KEY (user_id);


--
-- Name: cart_product cart_product_pkey; Type: CONSTRAINT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce.cart_product
    ADD CONSTRAINT cart_product_pkey PRIMARY KEY (cart_id, product_id);


--
-- Name: category category_pkey; Type: CONSTRAINT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);


--
-- Name: order order_pkey; Type: CONSTRAINT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce."order"
    ADD CONSTRAINT order_pkey PRIMARY KEY (id);


--
-- Name: order_product order_product_pkey; Type: CONSTRAINT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce.order_product
    ADD CONSTRAINT order_product_pkey PRIMARY KEY (order_id, product_id);


--
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- Name: product product_pkey; Type: CONSTRAINT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- Name: user user_pkey; Type: CONSTRAINT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- Name: product fk1mtsbur82frn64de7balymq9s; Type: FK CONSTRAINT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce.product
    ADD CONSTRAINT fk1mtsbur82frn64de7balymq9s FOREIGN KEY (category_id) REFERENCES icommerce.category(id);


--
-- Name: cart_product fk2kdlr8hs2bwl14u8oop49vrxi; Type: FK CONSTRAINT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce.cart_product
    ADD CONSTRAINT fk2kdlr8hs2bwl14u8oop49vrxi FOREIGN KEY (product_id) REFERENCES icommerce.product(id);


--
-- Name: order_product fkb3sm2umdh0yd7jwrnda0qixd0; Type: FK CONSTRAINT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce.order_product
    ADD CONSTRAINT fkb3sm2umdh0yd7jwrnda0qixd0 FOREIGN KEY (order_id) REFERENCES icommerce."order"(id);


--
-- Name: order_product fkhnfgqyjx3i80qoymrssls3kno; Type: FK CONSTRAINT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce.order_product
    ADD CONSTRAINT fkhnfgqyjx3i80qoymrssls3kno FOREIGN KEY (product_id) REFERENCES icommerce.product(id);


--
-- Name: order_product fkl5mnj9n0di7k1v90yxnthkc73; Type: FK CONSTRAINT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce.order_product
    ADD CONSTRAINT fkl5mnj9n0di7k1v90yxnthkc73 FOREIGN KEY (order_id) REFERENCES icommerce.orders(id);


--
-- Name: cart fkl70asp4l4w0jmbm1tqyofho4o; Type: FK CONSTRAINT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce.cart
    ADD CONSTRAINT fkl70asp4l4w0jmbm1tqyofho4o FOREIGN KEY (user_id) REFERENCES icommerce."user"(id);


--
-- Name: cart_product fklv5x4iresnv4xspvomrwd8ej9; Type: FK CONSTRAINT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce.cart_product
    ADD CONSTRAINT fklv5x4iresnv4xspvomrwd8ej9 FOREIGN KEY (cart_id) REFERENCES icommerce.cart(user_id);


--
-- Name: order fkpdly5nr07hvmmluij7hb3x9mo; Type: FK CONSTRAINT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce."order"
    ADD CONSTRAINT fkpdly5nr07hvmmluij7hb3x9mo FOREIGN KEY (cart_user_id) REFERENCES icommerce.cart(user_id);


--
-- Name: product fks6cydsualtsrprvlf2bb3lcam; Type: FK CONSTRAINT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce.product
    ADD CONSTRAINT fks6cydsualtsrprvlf2bb3lcam FOREIGN KEY (brand_id) REFERENCES icommerce.brand(id);


--
-- Name: orders fks84f9jydtqgr70reya5boh3i9; Type: FK CONSTRAINT; Schema: icommerce; Owner: todo
--

ALTER TABLE ONLY icommerce.orders
    ADD CONSTRAINT fks84f9jydtqgr70reya5boh3i9 FOREIGN KEY (cart_user_id) REFERENCES icommerce.cart(user_id);


--
-- PostgreSQL database dump complete
--

