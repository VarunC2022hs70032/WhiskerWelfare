INSERT INTO public.user (id, first_name, last_name, username, "password")
VALUES (1, 'John', 'Doe', 'johndoe', '$2a$10$MMOkMuO8zVcXl8YH2GrZSOYf/9zeC/sznGHRVzAq0T8.tzet7QJWq');
INSERT INTO public.user (id, first_name, last_name, username, "password")
VALUES (2, 'Linda', 'Calvin', 'lindacalvin', '$2a$10$I5hOscIFqw73AU2/my0H0.vHAjI/rxXGcI49PB/jl8krTcM7VqkCy');
INSERT INTO public.user (id, first_name, last_name, username, "password")
VALUES (3, 'Jeffrey', 'Taylor', 'jeffreytaylor', '$2a$10$0grDMvQ7mSRLDAS6zuGOp.0ycwhgAzyE2FgLHzCV8KaXXP2TtGJ/W');

SELECT setval('sequence_user', max(id)) FROM public.user;