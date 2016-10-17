/**
 * This script has been written for use with an Oracle database for utlization of the book sources for Java EE 7 Recipes.
 * 
 * To use, first create a schema within your database into which these objects will be created and populated.
 * 
 * Next, grant the schema the necessary privileges to create tables, procedures,
 * and sequences.
 *
 * Lastly, connect as the schema that you have created and execute this script.
 *
 * Author: J. Juneau
 */

-- ***** Create tables *****
create table book_author(
id          NUMERIC primary key,
lastname        varchar2(30),
firstname       varchar2(30),
bio			clob);

create table book(
id			number(38, 0) primary key,
title		varchar2(150),
image		varchar2(500),
description clob);

create table chapter(
id			number primary key,
book_id     number,
chapter_number number,
title		varchar2(150),
description	clob);

create table contact(
id			number primary key,
firstname		varchar2(50),
lastname		varchar2(50),
email		varchar2(150),
password	varchar2(30),
description clob,
occupation	varchar2(150),
receiveNotifications varchar2(1),
gender		varchar2(1));

create table author_work(
id              number primary key,
author_id       number not null,
book_id           number,
constraint author_work_fk
foreign key(author_id) references book_author(id));

create table author_work_legacy(
book_id			number,
author_id		number);

create table author_detail (
id				number primary key,
author_id		number,
address1		varchar2(200),
address2		varchar2(200),
city			varchar2(250),
state			varchar2(2),
zip				varchar2(10),
start_date		date,
notes			clob);

alter table author_detail
add constraint author_detail_fk
foreign key (author_id) references author(id);

create table author(
id 				number primary key,
lastname        varchar2(30),
firstname       varchar2(30),
bio			clob);

create table book_book_author(
bookAuthors_id	number,
books_id		number);

create table book_order (
id				number primary key,
book			number,
quantity		number);

create table order_detail(
id				number primary key,
order_id		number,
customer_id		number);

create table employee(
id			number primary key,
firstname		varchar2(30),
lastname		varchar2(30),
age			number,
job_id		number,
status		varchar2(50));

create table jobs(
job_id		number primary key,
title		varchar2(50),
division	varchar2(50),
salary		number);

create table book_category(
id				number primary key,
name			varchar2(50),
category_type	varchar2(30),
genre			varchar2(50),
category_desc	varchar2(2000),
store_id		number);

create table book_store(
id				number primary key,
name			varchar2(100),
location_city   varchar2(100),
location_state	varchar2(2));

create table users(
id number,
username varchar2(150) not null, 
password varchar2(50) not null,
primary key (id));

create table groups(
id number,
username varchar2(150) not null,
groupname varchar2(100) not null,
primary key(id));

create table recipes(
id numeric,
recipe_number varchar(10),
recipe_name varchar(150),
description varchar(250),
text        varchar(2000));

-- ***** End of Table Creation  *****

-- ***** Create Sequences *****
create sequence book_author_s
start with 100
increment by 1;

create sequence book_s
start with 100
increment by 1;

create sequence chapter_s
start with 1
increment by 1;

create sequence contact_s
start with 1
increment by 1;

create sequence author_work_s
start with 100
increment by 1;

create sequence author_detail_s
start with 1
increment by 1;

create sequence author_s
start with 1
increment by 1;

create sequence order_s
start with 1
increment by 1;

create sequence order_detail_s
start with 1
increment by 1;

create sequence employee_pk_s
start with 1
increment by 1;

create sequence jobs_pk_s
start with 1
increment by 1;

create sequence users_s
start with 1
increment by 1;

create sequence groups_s
start with 1
increment by 1;

-- ***** End of Sequence Creation  *****

-- ***** Populate Tables *****

insert into book_author values(
book_author_s.nextval,
'JUNEAU',
'JOSH',
'N/A');

insert into book_author values(
book_author_s.nextval,
'DEA',
'CARL',
'N/A');

insert into book_author values(
book_author_s.nextval,
'BEATY',
'MARK',
'N/A');

insert into book_author values(
book_author_s.nextval,
'GUIME',
'FREDDY',
'N/A');

insert into book_author values(
book_author_s.nextval,
'OCONNER',
'JOHN',
'N/A');


insert into book values(
book_s.nextval,
'Java 7 Recipes',
'java7recipes.png',
'Java 7 Recipes offers solutions to common programming problems encountered every day while developing Java-based applications. Fully updated with the newest features and techniques available, Java 7 Recipes provides code examples involving Servlets, Java FX 2.0, XML, Java Swing, and much more. Content is presented in the popular problem-solution format: Look up the programming problem that you want to solve. Read the solution. Apply the solution directly in your own code. Problem solved.  The problem-solution approach sets Java 7 Recipes apart from other books on the topic. Java 7 Recipes is focused less on the language itself and more on what you can do with it that is useful. The book respects your time by always focusing on a task that you might want to perform using the language. Solutions come first. Explanations come later. You are free to crib from the book and apply the code examples directly to your own projects.');

insert into book values(
book_s.nextval,
'Java EE 7 Recipes',
'javaee7recipes.png',
'Your go-to resource for Java EE 7 technology.');

insert into book values(
book_s.nextval,
'Java FX 2.0 - Introduction by Example',
'javafx.png',
'JavaFX 2.0: Introduction by Example provides a quick start to programming the JavaFX 2.0 platform.');

insert into author_work values(
author_work_s.nextval,
(select id from book_author where lastname = 'JUNEAU'),
(select id from book where title = 'Java 7 Recipes'));

insert into author_work values(
author_work_s.nextval,
(select id from book_author where lastname = 'BEATY'),
(select id from book where title = 'Java 7 Recipes'));

insert into author_work values(
author_work_s.nextval,
(select id from book_author where lastname = 'DEA'),
(select id from book where title = 'Java 7 Recipes'));

insert into author_work values(
author_work_s.nextval,
(select id from book_author where lastname = 'GUIME'),
(select id from book where title = 'Java 7 Recipes'));

insert into author_work values(
author_work_s.nextval,
(select id from book_author where lastname = 'OCONNER'),
(select id from book where title = 'Java 7 Recipes'));

insert into author_work values(
author_work_s.nextval,
(select id from book_author where lastname = 'JUNEAU'),
(select id from book where title = 'Java EE 7 Recipes'));

insert into author_work values(
author_work_s.nextval,
(select id from book_author where lastname = 'DEA'),
(select id from book where title = 'Java FX 2.0 - Introduction by Example'));

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
1,
'Getting Started with Java 7',
'chapter description'
);

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
2,
'Strings',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
3,
'Numbers and Dates',
'chapter description'
);

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
4,
'Data Structures, Conditionals, and Iteration',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
5,
'Input and Output',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
6,
'Exceptions, Logging, and Debugging',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
7,
'Object-Oriented Java',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
8,
'Concurrency',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
9,
'Debugging and Unit Testing',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
10,
'Unicode, Internationalization, and Currency Codes',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
11,
'Working with Databases (JDBC)',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
12,
'Java 2D Graphics and Media',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
13,
'Java 3D',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
14,
'Swing API',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
15,
'JavaFX Fundamentals',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
16,
'Graphics with JavaFX',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
17,
'Media with JavaFX',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
18,
'Working with Servlets',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
19,
'Applets',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
20,
'JavaFX on the Web',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
21,
'Email',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
22,
'XML and Web Services',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java 7 Recipes'),
23,
'Networking',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java EE 7 Recipes'),
1,
'Introduction to Servlets',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java EE 7 Recipes'),
2,
'JavaServer Pages',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java EE 7 Recipes'),
3,
'The Basics of JavaServer Faces',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java EE 7 Recipes'),
4,
'Facelets',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java EE 7 Recipes'),
5,
'JavaServer Faces Standard Components',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java EE 7 Recipes'),
6,
'Advanced JavaServer Faces and Ajax',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java EE 7 Recipes'),
7,
'JDBC',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java EE 7 Recipes'),
8,
'Object-Relational Mapping',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java EE 7 Recipes'),
9,
'Enterprise JavaBeans',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java EE 7 Recipes'),
10,
'The Query API and JPQL',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java EE 7 Recipes'),
11,
'Oracles GlassFish',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java EE 7 Recipes'),
12,
'Contexts and Dependency Injection',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java EE 7 Recipes'),
13,
'Java Message Service',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java EE 7 Recipes'),
14,
'Authentication and Security',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java EE 7 Recipes'),
15,
'Java Web Services',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java EE 7 Recipes'),
16,
'Enterprise Solutions Using Alternative Programming Languages',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java EE 7 Recipes'),
17,
'WebSockets and JSON-P',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java EE 7 Recipes'),
18,
'JavaFX in the Enterprise',
'chapter description');

insert into chapter values(
chapter_s.nextval,
(select id from book where title = 'Java EE 7 Recipes'),
19,
'Concurrency and Batch Applications',
'chapter description');

insert into jobs values(
jobs_pk_s.nextval,
'IT TITLE A',
'IT',
60000);

insert into jobs values(
jobs_pk_s.nextval,
'IT TITLE B',
'IT',
70000);

insert into jobs values(
jobs_pk_s.nextval,
'IT TITLE C',
'IT',
40000);

insert into jobs values(
jobs_pk_s.nextval,
'HR TITLE A',
'HR',
50000);

insert into jobs values(
jobs_pk_s.nextval,
'HR TITLE B',
'HR',
60000);

insert into jobs values(
jobs_pk_s.nextval,
'TITLE A',
'SALES',
65000);

insert into employee values(
employee_pk_s.nextval,
'JOE',
'DEVELOPER',
25,
(select job_id from jobs where title = 'IT TITLE C'));

insert into employee values(
employee_pk_s.nextval,
'JANE',
'DEVELOPER',
32,
(select job_id from jobs where title = 'IT TITLE A'),
'INACTIVE');

insert into employee values(
employee_pk_s.nextval,
'BOB',
'SMITH',
25,
(select job_id from jobs where title = 'HR TITLE A'),
'ACTIVE');

insert into book_store values(
1,
'ACME ONLINE',
'NA',
'NA');

insert into book_store values(
2,
'ACME BOOKSTORE',
'CHICAGO',
'IL');

insert into book_category values (
1,
'DEVELOPMENT',
'IT',
'EDUCATION',
'This category focuses on application development');

insert into book_category values (
2,
'OPERATING SYSTEMS',
'IT',
'EDUCATION',
'This category focuses on operating systems');

insert into book_category values(
3,
'MOBILE',
'IT',
'EDUCATION',
'This category focuses on mobile');

insert into users values(
users_s.nextval,
'admin',
dbms_obfuscation_toolkit.md5(input=>utl_raw.cast_to_raw('javaeerecipes')));

insert into users values(
users_s.nextval,
'user',
dbms_obfuscation_toolkit.md5(input=>utl_raw.cast_to_raw('testpass')));

insert into groups values(
groups_s.nextval,
'admin', 'administrator');

insert into groups values(
groups_s.nextval,
'user','reader');

insert into contact values(
 contact_s.nextval,
   'JOE',
   'USER',
   'myemail@myemailprovider.com',
   null,
   null,
   null,
   'N',
   'M');


-- ***** End Population of Tables *****

-- ***** Create Procedures *****

create or replace procedure CREATE_USER (username IN VARCHAR2,
										 password IN VARCHAR2) AS
begin
  -- Add implementation for creating database user here
  null;
end;
/

create or replace procedure FIND_SUM (num1 IN NUMBER,
								      num2 IN NUMBER,
									  sum  OUT NUMBER) as
begin
    sum := num1 + num2;
end;
/


create or replace procedure dummy_proc (text IN VARCHAR2,msg OUT VARCHAR2) asbegin-- Do something, in this case the IN parameter value is assigned to the OUT parameter
msg :=text;end;

commit;/
