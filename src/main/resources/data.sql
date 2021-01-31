INSERT INTO faculty (faculty_id, title, head) VALUES
(1, 'Test faculty', 'Test Head');

INSERT INTO st_group (gr_id, direction, level, title, faculty_id)
VALUES (1, 'Test direction', 'Test level', 'Test title', 1);

INSERT INTO student (student_id, first_name, last_name, birth_date, gr_id)
VALUES (1, 'Test1', 'Test2', 'Test birthday', 1);