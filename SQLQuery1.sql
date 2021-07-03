
CREATE DATABASE [DTS]
 CONTAINMENT = NONE
 ON  PRIMARY 
( name = 'DTS_data',
filename = 'D:\- Database Management Systems\DomesticTourismSystem\DataBase\DTS_data.mdf',
SIZE = 8MB,
FILEGROWTH = 5MB)
 LOG ON 
( NAME = 'DTS_log',
filename = 'D:\- Database Management Systems\DomesticTourismSystem\DataBase\DTS_log.ldf',
SIZE = 5MB,
FILEGROWTH = 5MB)
 collate Arabic_CI_AI

GO
use [DTS]

create table Contractor --Partners, Hostel owners and transport owners
(
code int identity(1,1) primary key,
[name] varchar(75) not null, --Name of person or company 
ID char(20) not null, --National ID for persons or Commercial Register number for companies
email nvarchar(100),
flat varchar(10),
building varchar(20),
street varchar(20),
[zone] varchar(20),
city varchar(50) default '«·√”ﬂ‰œ—Ì…',
[type] varchar(30) default '‘—ﬂ…',
contractDate date not null,
contractTermination date null,
[state] bit default 1
);

Go


create table Transport
(
code int identity (1,1) primary key,
[type] varchar(30) default '√Ê Ê»Ì”',
ownercode int null foreign key references Contractor(code),
number varchar(25) null,
model nvarchar(30) null,
capacity smallint default 1 check(capacity > 0),
[state] bit default 1,
city varchar(50) default '«·√”ﬂ‰œ—Ì…',
creatDate smalldatetime not null,
costPerDay smallmoney default 0
);

Go

create table Hostel
(
code int identity(1,1) primary key,
[type] varchar(30) default '›‰œﬁ',
[name] nvarchar(75) not null,
ownerCode int null foreign key references Contractor(code) ,
creatDate smalldatetime not null,
[state] bit default 1,
city varchar(50) default '«·√”ﬂ‰œ—Ì…',
capacity smallint default 1 check(capacity > 0),
hotelDegree char(1) default 3 not null,
costPerNight smallmoney default 0
);

Go

create table Place
(
code int identity(1,1) primary key,
[type] nvarchar(50) not null default '‘«ÿ∆',
[name] nvarchar(75) not null,
city varchar(50) default '«·√”ﬂ‰œ—Ì…',
capacity smallint default 1 check(capacity > 0),
costPerVisit smallmoney default 0
);

Go

create table Guide
(
NID char(14) primary key,
[name] varchar(75) not null,
gender bit not null default 1,
mobile char(11) not null unique,
email nvarchar(50) null,
birthDate date not null,
city varchar(50) default '«·√”ﬂ‰œ—Ì…',
Specialty varchar(15) not null default '›—⁄Ê‰Ì',
creatDate smalldatetime not null,
costPerGroup smallmoney not null default 0,
[state] bit not null default 1
);

Go
create table Brochure
(
code int identity(1,1) primary key,
pages tinyint not null default 1,
creatDate smalldatetime not null,
[type] varchar(15) not null default 'ﬂ Ì»',
cost smallmoney not null default 0
);

Go
create table Travel
(
code int identity (1,1) primary key,
creatDate smalldatetime not null,
[state] bit not null default 1,
startDate date not null,
endDate date not null,
cost money not null default 0
);

Go

create table [Partner]
(
code int primary key foreign key references Contractor(code),
discount float not null default 0.2 check(discount between 0 and 1),
);

Go
create table Tourist
(
NID char(14) primary key,
[name] varchar(75) not null,
gender bit not null default 1,
birthDate date not null,
mobile char(11) not null,
email varchar(50),
partnerCode int foreign key references [Partner](code) null,
info nvarchar(max),
score smallint not null default 0,
balance money not null default 0,
creatDate smalldatetime not null,
city varchar(50) default '«·√”ﬂ‰œ—Ì…',
[state] bit not null default 1
);

create table Phone
(
contractorCode int foreign key references Contractor(code),
phone char(11) unique not null,
fax bit default 0 not null,
constraint PK_Phone primary key(contractorCode,phone)
);

Go

create table PartnerTourist
(
partnerCode int foreign key references [Partner](code),
NID char(14) foreign key references Tourist(NID),
constraint PK_PartnerTourist primary Key(partnerCode,NID)
);

Go

create table RegTransport
(
travelCode int foreign key references Travel(code),
transportCode int foreign key references Transport(code),
regDate smalldatetime not null,
constraint PK_RegTrandport primary key(travelCode,transportCode)
);

Go

create table RegHostel
(
travelCode int foreign key references Travel(code),
hostelCode int foreign key references Hostel(code),
regDate smalldatetime not null,
constraint PK_RegHostel primary key(travelCode,hostelCode)
);

Go

create table RegPlace
(
travelCode int foreign key references Travel(code),
placeCode int foreign key references Place(code),
regDate smalldatetime not null,
constraint PK_RegPlace primary key(travelCode,placeCode)
);

Go

create table RegGuide
(
travelCode int foreign key references Travel(code),
guideCode char(14) foreign key references Guide(NID),
regDate smalldatetime not null,
constraint PK_RegGuide primary key(travelCode,guideCode)
);

Go

create table RegTourist
(
travelCode int foreign key references Travel(code),
touristCode char(14) foreign key references Tourist(NID),
regDate smalldatetime not null,
constraint PK_RegTourist primary key(travelCode,touristCode)
);

Go

create table RegBrochure
(
travelCode int foreign key references Travel(code),
brochureCode int foreign key references Brochure(code),
regDate smalldatetime not null,
constraint PK_RegBrochure primary key(travelCode,brochureCode)
);

