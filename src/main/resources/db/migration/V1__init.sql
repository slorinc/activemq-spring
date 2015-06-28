CREATE TABLE PERSON (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	firstname varchar(255) not null,
	lastname varchar(255) not null,
	timestamp TIMESTAMP DEFAULT SYSTIMESTAMP NOT NULL
);

CREATE TABLE JMSPOLL (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	updatetype varchar(20) not null,
	personid BIGINT NOT NULL,
	updatedate TIMESTAMP NOT NULL,
	timestamp TIMESTAMP DEFAULT SYSTIMESTAMP NOT NULL,
	FOREIGN KEY(personId) REFERENCES PERSON(ID)
);

insert into PERSON (firstname, lastname) values ('LORINC', 'SONNEVEND');
