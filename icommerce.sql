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
-- Data for Name: brand; Type: TABLE DATA; Schema: icommerce; Owner: todo
--

COPY icommerce.brand (id, name) FROM stdin;
1	Pepsi
2	Cocacola
3	Apple
\.


--
-- Data for Name: user; Type: TABLE DATA; Schema: icommerce; Owner: todo
--

COPY icommerce."user" (id, username) FROM stdin;
1	admin
\.


--
-- Data for Name: cart; Type: TABLE DATA; Schema: icommerce; Owner: todo
--

COPY icommerce.cart (user_id) FROM stdin;
1
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
-- Data for Name: product; Type: TABLE DATA; Schema: icommerce; Owner: todo
--

COPY icommerce.product (id, color, name, price, brand_id, category_id) FROM stdin;
1	1	Pepsi Light	10000.00	1	1
2	0	Cocacola Zero	10000.00	2	1
3	1	Pepsi Poca	5000.00	1	2
4	2	Iphone	40000000.00	3	3
\.


--
-- Data for Name: cart_product; Type: TABLE DATA; Schema: icommerce; Owner: todo
--

COPY icommerce.cart_product (cart_id, product_id, quantity) FROM stdin;
1	1	3
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
-- Name: product_id_seq; Type: SEQUENCE SET; Schema: icommerce; Owner: todo
--

SELECT pg_catalog.setval('icommerce.product_id_seq', 1, false);


--
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: icommerce; Owner: todo
--

SELECT pg_catalog.setval('icommerce.user_id_seq', 1, false);


--
-- PostgreSQL database dump complete
--

