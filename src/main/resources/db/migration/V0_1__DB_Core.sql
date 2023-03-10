--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1 (Debian 15.1-1.pgdg110+1)
-- Dumped by pg_dump version 15.1 (Debian 15.1-1.pgdg110+1)

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: app_users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.app_users (
    user_id bigint NOT NULL,
    email character varying(255) NOT NULL,
    nick character varying(255) NOT NULL,
    password character varying(255) NOT NULL
);


ALTER TABLE public.app_users OWNER TO postgres;

--
-- Name: enrolled; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enrolled (
    tournament_id bigint NOT NULL,
    team_id bigint NOT NULL
);


ALTER TABLE public.enrolled OWNER TO postgres;

--
-- Name: game; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.game (
    game_id bigint NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.game OWNER TO postgres;

--
-- Name: game_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.game_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.game_id_seq OWNER TO postgres;

--
-- Name: match; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.match (
    match_id bigint NOT NULL,
    phase integer NOT NULL,
    score_team_a integer,
    score_team_b integer,
    team_a bigint,
    team_b bigint,
    tournament bigint NOT NULL
);


ALTER TABLE public.match OWNER TO postgres;

--
-- Name: match_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.match_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.match_id_seq OWNER TO postgres;

--
-- Name: team; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.team (
    team_id bigint NOT NULL,
    name character varying(255) NOT NULL,
    size integer NOT NULL
);


ALTER TABLE public.team OWNER TO postgres;

--
-- Name: team_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.team_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.team_id_seq OWNER TO postgres;

--
-- Name: team_member; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.team_member (
    user_id bigint NOT NULL,
    team_id bigint NOT NULL
);


ALTER TABLE public.team_member OWNER TO postgres;

--
-- Name: tournament; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tournament (
    tournament_id bigint NOT NULL,
    name character varying(255) NOT NULL,
    phases integer NOT NULL,
    game_id bigint NOT NULL
);


ALTER TABLE public.tournament OWNER TO postgres;

--
-- Name: tournament_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tournament_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tournament_id_seq OWNER TO postgres;

--
-- Name: user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_id_seq OWNER TO postgres;


--
-- Name: game_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.game_id_seq', 1, false);


--
-- Name: match_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.match_id_seq', 1, false);


--
-- Name: team_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.team_id_seq', 1, false);


--
-- Name: tournament_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tournament_id_seq', 1, false);


--
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_id_seq', 1, false);


--
-- Name: app_users app_users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.app_users
    ADD CONSTRAINT app_users_pkey PRIMARY KEY (user_id);


--
-- Name: enrolled enrolled_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enrolled
    ADD CONSTRAINT enrolled_pkey PRIMARY KEY (tournament_id, team_id);


--
-- Name: game game_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game
    ADD CONSTRAINT game_pkey PRIMARY KEY (game_id);


--
-- Name: match match_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.match
    ADD CONSTRAINT match_pkey PRIMARY KEY (match_id);


--
-- Name: team_member team_member_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.team_member
    ADD CONSTRAINT team_member_pkey PRIMARY KEY (user_id, team_id);


--
-- Name: team team_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.team
    ADD CONSTRAINT team_pkey PRIMARY KEY (team_id);


--
-- Name: tournament tournament_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tournament
    ADD CONSTRAINT tournament_pkey PRIMARY KEY (tournament_id);


--
-- Name: match fk3rhfo41cxvle3g89q5oyn1l84; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.match
    ADD CONSTRAINT fk3rhfo41cxvle3g89q5oyn1l84 FOREIGN KEY (team_a) REFERENCES public.team(team_id);


--
-- Name: team_member fk3thy5vxpjcyyjweje5o8sd6g7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.team_member
    ADD CONSTRAINT fk3thy5vxpjcyyjweje5o8sd6g7 FOREIGN KEY (user_id) REFERENCES public.app_users(user_id);


--
-- Name: enrolled fk4as39qsh1mcfssnfkcp2vjduf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enrolled
    ADD CONSTRAINT fk4as39qsh1mcfssnfkcp2vjduf FOREIGN KEY (tournament_id) REFERENCES public.tournament(tournament_id);


--
-- Name: tournament fk5iaxeujiox85paiek0n3rh3k8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tournament
    ADD CONSTRAINT fk5iaxeujiox85paiek0n3rh3k8 FOREIGN KEY (game_id) REFERENCES public.game(game_id);


--
-- Name: enrolled fk7wa8uqtg1pjbjw9cdhhw45aah; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enrolled
    ADD CONSTRAINT fk7wa8uqtg1pjbjw9cdhhw45aah FOREIGN KEY (team_id) REFERENCES public.team(team_id);


--
-- Name: team_member fk9ubp79ei4tv4crd0r9n7u5i6e; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.team_member
    ADD CONSTRAINT fk9ubp79ei4tv4crd0r9n7u5i6e FOREIGN KEY (team_id) REFERENCES public.team(team_id);


--
-- Name: match fkfoqyohr8n3j5btp6rdb72cleq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.match
    ADD CONSTRAINT fkfoqyohr8n3j5btp6rdb72cleq FOREIGN KEY (tournament) REFERENCES public.tournament(tournament_id);


--
-- Name: match fkr9cgi2rk0ts9t0wwpbkyv1xwl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.match
    ADD CONSTRAINT fkr9cgi2rk0ts9t0wwpbkyv1xwl FOREIGN KEY (team_b) REFERENCES public.team(team_id);


--
-- PostgreSQL database dump complete
--

