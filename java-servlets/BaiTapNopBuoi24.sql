CREATE DATABASE crmapp;
USE crmapp;

CREATE TABLE roles(
	id int auto_increment,
	description varchar(50),
	
	PRIMARY KEY(id)
);

CREATE TABLE users(
	id int auto_increment,
	password varchar(255),
	first_name varchar(50),
	last_name varchar(50),
	username varchar(255),
	phone varchar(12),
	id_role int,
	
	PRIMARY KEY(id)
);

CREATE TABLE task(
	id int auto_increment,
	id_user int,
	id_project int,
	id_status int,
	name varchar(255),
	start_date timestamp DEFAULT now(),
	end_date timestamp NOT NULL,
	
	PRIMARY KEY(id)
);

CREATE TABLE project(
	id int auto_increment,
	name varchar(255),
	start_date timestamp DEFAULT now(),
	end_date timestamp NOT NULL,
	
	PRIMARY KEY(id)
);

CREATE TABLE status(
	id int auto_increment,
	name varchar(10),
	
	PRIMARY KEY(id)
);

ALTER TABLE users ADD CONSTRAINT FK_id_role_users FOREIGN KEY(id_role) REFERENCES roles(id);
ALTER TABLE task ADD CONSTRAINT FK_id_user_task FOREIGN KEY(id_user) REFERENCES users(id);
ALTER TABLE task ADD CONSTRAINT FK_id_project_task FOREIGN KEY(id_project) REFERENCES project(id);
ALTER TABLE task ADD CONSTRAINT FK_id_status_task FOREIGN KEY(id_status) REFERENCES status(id);
