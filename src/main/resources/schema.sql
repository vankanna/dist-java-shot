create table Products (
      id int primary key auto_increment,
      name varchar(200) not null,
      description varchar(500) not null,
      price double not null,
      stock int not null,
      image_file_name varchar(200)
);