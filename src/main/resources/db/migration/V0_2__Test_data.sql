--
-- Data for Name: app_users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.app_users (user_id, email, nick, password) FROM stdin;
1	email1	nick1	pass1
2	email2	nick2	pass2
3	email3	nick3	pass3
4	email4	nick4	pass4
\.


--
-- Data for Name: enrolled; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.enrolled (tournament_id, team_id) FROM stdin;
\.


--
-- Data for Name: game; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.game (game_id, name) FROM stdin;
\.


--
-- Data for Name: match; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.match (match_id, phase, score_team_a, score_team_b, team_a, team_b, tournament) FROM stdin;
\.


--
-- Data for Name: team; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.team (team_id, name, size) FROM stdin;
\.


--
-- Data for Name: team_member; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.team_member (user_id, team_id) FROM stdin;
\.


--
-- Data for Name: tournament; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tournament (tournament_id, name, game) FROM stdin;
\.


