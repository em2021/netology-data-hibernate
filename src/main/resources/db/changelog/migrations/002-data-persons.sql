--changeset em2021:1
insert into hibernate.persons (name, surname, age, phonenumber, city_of_living)
values ('Tom', 'Green', 23, '99999999' , 'Moscow');

insert into hibernate.persons (name, surname, age, phonenumber, city_of_living)
values ('John', 'Black', 23, '99997999' , 'Moscow');

insert into hibernate.persons (name, surname, age, phonenumber, city_of_living)
values ('Peter', 'Petrov', 29, '99997993' , 'Monaco');

insert into hibernate.persons (name, surname, age, phonenumber, city_of_living)
values ('Anna', 'Belova', 27, '3333333' , 'NY');

insert into hibernate.persons (name, surname, age, phonenumber, city_of_living)
values ('Emma', 'Ivanova', 28, '333333391' , 'Toronto');

insert into hibernate.persons (name, surname, age, phonenumber, city_of_living)
values ('Alex', 'Yefimov', 40, '23333333' , 'Chicago');
--rollback truncate table hibernate.persons;