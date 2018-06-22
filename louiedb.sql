CREATE TABLE userAdmin (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	user VARCHAR(30), password VARCHAR(30),
	userlevel INTEGER NOT NULL
);

CREATE TABLE faculty (
	facultyid INTEGER PRIMARY KEY AUTO_INCREMENT,
	firstname VARCHAR(30),
	lastname VARCHAR(30),
	username VARCHAR(30),
	password VARCHAR(30),
	userlevel INTEGER
);

CREATE TABLE students (
	studentid INTEGER PRIMARY KEY AUTO_INCREMENT, 
	firstname VARCHAR(30),
	lastname VARCHAR(30),
	username VARCHAR(30),
	password VARCHAR(30),
	subject VARCHAR(50),
	userlevel INTEGER,
	grade INTEGER
);

ALTER TABLE students AUTO_INCREMENT=4000;

INSERT INTO userAdmin(user, password, userlevel) VALUES ('louievic', 'sancon','1');
INSERT INTO faculty(firstname, lastname, username, password, userlevel) VALUES ('louievic', 'sancon', 'hehe', 'hehe', 2);
INSERT INTO students(firstname, lastname, username, password, subject, userlevel, grade) VALUES ('stud1', 'studln','sample', 'sample', 'samplesubject', 4, 89);