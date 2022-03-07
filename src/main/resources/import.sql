-- USER
-- username: Alexis password: 12345
INSERT INTO USERS (ID, LAST_NAME, PASSWORD, ROLE) VALUES (1, 'Alexis', '$2a$12$lP1HdpYa4yT./wnilPzf0OoxaVHJunEkkxw4SwkYL5obPjq.fG8Xy', 'USER');
-- username: Sam password: 12345
INSERT INTO USERS (ID, LAST_NAME, PASSWORD, ROLE) VALUES (2, 'Sam', '$2a$12$lP1HdpYa4yT./wnilPzf0OoxaVHJunEkkxw4SwkYL5obPjq.fG8Xy', 'USER');

-- ADMIN
-- password: admin_pass
INSERT INTO USERS (ID, LAST_NAME, PASSWORD, ROLE) VALUES (3, 'admin', '$2a$12$rbmC6cJOZqDMXY1oQxupzOliJ2.v9J1EXYiUY2a52qSTpBJVd3vyq', 'ADMIN');

INSERT INTO POLLS (ID, CLOSED_AT, CREATED_AT, DESCRIPTION, NAME) VALUES (1, '2022-03-05', '2022-03-05', 'Первый важный опрос', 'Первый опрос');
INSERT INTO POLLS (ID, CLOSED_AT, CREATED_AT, DESCRIPTION, NAME) VALUES (2, '2022-03-05', '2022-03-05', 'Важнее первого опрос', 'Второй опрос');

INSERT INTO QUESTIONS (ID, QUESTION_TEXT, TYPE, POLL_ID) VALUES (1, 'Как тебя зовут?', 'TEXT', 1);
INSERT INTO QUESTIONS (ID, QUESTION_TEXT, TYPE, POLL_ID) VALUES (6, 'ЧТо тебе нравится на текущем месте работы?', 'TEXT', 2);

