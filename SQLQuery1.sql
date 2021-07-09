
CREATE DATABASE [DTS]
 CONTAINMENT = NONE
 ON  PRIMARY 
( name = 'DTS_data',
filename = 'D:\DataBase\DTS_data.mdf',
SIZE = 8MB,
FILEGROWTH = 5MB)
 LOG ON 
( NAME = 'DTS_log',
filename = 'D:\DataBase\DTS_log.ldf',
SIZE = 5MB,
FILEGROWTH = 5MB)
 collate Arabic_CI_AI

GO
use [DTS]

create table Contractor --Partners, Hostel owners and transport owners
(
id int identity(1,1),
[name] varchar(75) not null, --Name of person or company 
idNum char(20) not null, --National ID for persons or Commercial Register number for companies
email nvarchar(100),
flat varchar(10),
building varchar(20),
street varchar(20),
[zone] varchar(20),
city varchar(50) default '«·√”ﬂ‰œ—Ì…',
[type] varchar(30) default '‘—ﬂ…',
contractDate date not null,
contractTermination date null,
[state] bit default 1,
constraint PK_Contractor primary key (id)
);

Go


create table Transport
(
id int identity (1,1),
[type] varchar(30) default '√Ê Ê»Ì”',
ownerID int null,
number varchar(25) null,
model nvarchar(30) null,
capacity smallint default 1 check(capacity > 0),
[state] bit default 1,
city varchar(50) default '«·√”ﬂ‰œ—Ì…',
creatDate smalldatetime not null,
costPerDay smallmoney default 0,
constraint FK_trsOwnerID foreign key (ownerID) references Contractor(id) on delete set null,
constraint PK_Transport primary key (id)
);

Go

create table Hostel
(
id int identity(1,1),
[type] varchar(30) default '›‰œﬁ',
[name] nvarchar(75) not null,
ownerID int null,
creatDate smalldatetime not null,
[state] bit default 1,
city varchar(50) default '«·√”ﬂ‰œ—Ì…',
capacity smallint default 1 check(capacity > 0),
hotelDegree char(1) default 3 not null,
costPerNight smallmoney default 0,
constraint FK_hstOwnerID foreign key (ownerID) references Contractor(id) on delete set null,
constraint PK_Hostel primary key (id)
);

Go

create table Place
(
id int identity(1,1),
[type] nvarchar(50) not null default '‘«ÿ∆',
[name] nvarchar(75) not null,
city varchar(50) default '«·√”ﬂ‰œ—Ì…',
capacity smallint default 1 check(capacity > 0),
costPerVisit smallmoney default 0,
constraint PK_Place primary key (id)
);

Go

create table Guide
(
id int identity(1,1),
NID char(14),
[name] varchar(75) not null,
gender bit not null default 1,
mobile char(11) not null unique,
email nvarchar(50) null,
birthDate date not null,
city varchar(50) default '«·√”ﬂ‰œ—Ì…',
Specialty varchar(15) not null default '›—⁄Ê‰Ì',
creatDate smalldatetime not null,
costPerGroup smallmoney not null default 0,
[state] bit not null default 1,
constraint PK_Guide primary key (id)
);

Go
create table Brochure
(
id int identity(1,1),
pages tinyint not null default 1,
creatDate smalldatetime not null,
[type] varchar(15) not null default 'ﬂ Ì»',
cost smallmoney not null default 0,
constraint PK_Brochure primary key (id)
);

Go
create table Travel
(
id int identity (1,1),
creatDate smalldatetime not null,
[state] bit not null default 1,
startDate date not null,
endDate date not null,
cost money not null default 0,
constraint PK_Travel primary key (id)
);

Go

create table [Partner]
(
id int,
discount float not null default 0.2 check(discount between 0 and 1),
constraint FK_prtCntID foreign key (id) references Contractor(id) on delete cascade,
constraint PK_Partner primary key (id)
);

Go

/*Tables name shortcut for foreign keys:
Contractor --> cnt
Travel	  --> trv
Transport --> trs
Hostel    --> hst
Place     --> plc
Guide     --> gud
Tourist   --> tur
Brochure  --> bru
*/

create table Tourist
(
id int identity(1,1),
NID char(14),
[name] varchar(75) not null,
gender bit not null default 1,
birthDate date not null,
mobile char(11) not null,
email varchar(50),
prtID int null,
info nvarchar(max),
score smallint not null default 0,
balance money not null default 0,
creatDate smalldatetime not null,
city varchar(50) default '«·√”ﬂ‰œ—Ì…',
[state] bit not null default 1,
constraint FK_turPrtID foreign key (prtID) references [Partner](id) on delete set null,
constraint PK_Tourist primary key (id)
);

GO

create table Phone
(
id int,
phone char(11) unique not null,
fax bit null,
constraint FK_phCntID foreign key (id) references Contractor(id) on delete cascade ,
constraint PK_Phone primary key(id,phone)
);


Go



create table RegTransport
(
trvID int,
trsID int,
regDate smalldatetime not null,
constraint FK_trsTrvID foreign key (trvID) references Travel(id) on delete cascade,
constraint FK_trsID foreign key (trsID) references Transport(id) on delete cascade,
constraint PK_RegTrandport primary key(trvID,trsID)
);

Go

create table RegHostel
(
trvID int,
hstID int,
regDate smalldatetime not null,
constraint FK_hstTrvID foreign key (trvID) references Travel(id) on delete cascade,
constraint FK_hstID  foreign key (hstID) references Hostel(id) on delete cascade,
constraint PK_RegHostel primary key(trvID,hstID)
);

Go

create table RegPlace
(
trvID int,
plcID int,
regDate smalldatetime not null,
constraint FK_plcTrvID foreign key (trvID) references Travel(id) on delete cascade,
constraint FK_plcID foreign key (plcID) references Place(id) on delete cascade,
constraint PK_RegPlace primary key(trvID,plcID)
);

Go

create table RegGuide
(
trvID int,
gudID int,
regDate smalldatetime not null,
constraint FK_gudTrvID foreign key (trvID) references Travel(id) on delete cascade,
constraint FK_gudID foreign key (gudID) references Guide(id) on delete cascade,
constraint PK_RegGuide primary key(trvID,gudID)
);

Go

create table RegTourist
(
trvID int,
turID int,
regDate smalldatetime not null,
constraint FK_turTrvID foreign key (trvID) references Travel(id) on delete cascade,
constraint FK_turID foreign key (turID) references Tourist(id) on delete cascade,
constraint PK_RegTourist primary key(trvID,turID)
);

Go

create table RegBrochure
(
trvID int,
bruID int,
regDate smalldatetime not null,
constraint FK_bruTrvID foreign key (trvID) references Travel(id) on delete cascade,
constraint FK_bruID foreign key (bruID) references Brochure(id) on delete cascade,
constraint PK_RegBrochure primary key(trvID,bruID)
);

