create table book (
	id int not null generated always as identity primary key,
	title varchar not null ,
	category varchar not null ,
	isbn int generated always as identity,
	year_release int not null
)

create table author (
	id int not null generated always as identity primary key,
	author_name varchar not null
)

create table book_author (
	id int not null generated always as identity primary key,
	constraint id_book int foreign key references book(id),
	constraint id_author int foreign key references author(id)
)

create table editor (
	id int not null generated always as identity primary key,
	stock int not null,
	editor_name varchar not null ,
	constraint id_book foreign key(id) references book(id)
)

create table contact (
	id int not null generated always as identity primary key,
	constraint id_editor foreign key(id) references editor(id),
	phone varchar not null
)

create table editor_contact (
	id int not null generated always as identity primary key,
	constraint id_editor foreign key(id) references editor(id),
	constraint id_contact foreign key(id) references contact(id)
)

create table client (
	id int not null generated always as identity primary key,
	cpf varchar not null ,
	client_name varchar not null ,
	address varchar not null ,
	phone varchar not null ,
	email varchar not null 
)

create table order_request(
	id int not null generated always as identity primary key,
	constraint id_client foreign key(id) references client(id)
)


create table order_book (
	id int not null generated always as identity primary key,
	amount int not null,
	constraint id_order foreign key(id) references order_request(id),
	constraint id_book foreign key(id) references book(id)
)
