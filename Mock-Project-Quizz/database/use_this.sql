create database MockSystem
go
use MockSystem
go
create table Account(
	username varchar(20) NOT NULL PRIMARY KEY,
	password varchar(20) NOT NULL,
	dateBirth varchar(20) NOT NULL,
	email varchar(40),
	job varchar(40),
	role tinyint null,
	image text,
)
go

create table Category(
	id int identity primary key not null,
	name nvarchar(40) not null,
	description text,
	img_src text,
)
go

create table Test(
	id int identity primary key not null,
	topic nvarchar(20) not null,
	name nvarchar(20) not null,
	category_id int not null,
	username varchar(20) null,
	constraint fk_test_category_id
	foreign key (category_id)
	references Category(id),
	constraint fk_test_username
	foreign key (username)
	references Account(username),

)
go


create table Score(
	username varchar(20) not null,
	test_id int not null,
	attemp int not null,
	score int null,
	numsCorrectperTotal varchar(20) null,
	constraint fk_score_username
	foreign key (username)
	references Account(username),
	constraint fk_score_test_id
	foreign key (test_id)
	references Test(id)
)
go

create table Quiz(
	id int identity primary key not null,
	test_id int not null,
	question text null,
	correctAnsw text null,
	incorrectAnsw_1 text null,
	incorrectAnsw_2 text null,
	incorrectAnsw_3 text null,
	constraint fk_quiz_test_id
	foreign key (test_id)
	references Test(id),
)
go

insert into Account values('admin001', '001',  '1-1-2000', 'admin001@email.com','admin', 0, null);
insert into Account values('admin002', '002', '1-1-2000', 'admin002@email.com','admin', 0, null);
insert into Account values('admin003', '003',  '1-1-2000', 'admin003@email.com', 'admin', 0, null);
insert into Account values('user001', '001', '1-1-2000', 'user001@email.com', 'student', 1, null);
go

insert into Category values('C++', 'About C++', 'https://google.com/');
insert into Category values('Java', 'About Java', 'https://google.com/');
insert into Category values('Python', 'About Python', 'https://google.com/');
go

insert into Test values('Ngon ngu lap trinh', 'C++ test', 1, 'admin001');
go

insert into Score values('user001', 1, 1, 100, '10/10');
go

insert into Quiz values(1, 'C++ la gi', 'Ngon ngu lap trinh', 'Ngon ngu danh dau van ban', '1 ky hieu', 'Tat ca deu sai');
go



