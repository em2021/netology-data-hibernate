--changeset em2021:1
create schema if not exists hibernate;
--rollback drop schema hibernate;

--changeset em2021:2
create table hibernate.persons(
	name varchar(255), constraint name_has_letters_only check (name similar to '[A-z]*'),
	surname varchar(255), constraint surname_has_letters_only check (surname similar to '[A-z]*'),
	age int constraint positive_age check (age > 0 and age < 200),
	phonenumber varchar(255) constraint phonenumber_has_numbers_only check (phonenumber similar to '[0-9]*') unique,
	city_of_living varchar(255),
	primary key (name, surname, age)
);
--rollback drop table hibermate.persons;