
CREATE DATABASE [DTSDB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( name = 'DTS_data',
filename = 'D:\DataBase\DTSDB_data.mdf',
SIZE = 8MB,
FILEGROWTH = 5MB)
 LOG ON 
( NAME = 'DTS_log',
filename = 'D:\DataBase\DTSDB_log.ldf',
SIZE = 5MB,
FILEGROWTH = 5MB)
 collate Arabic_CI_AI

GO

use [DTSDB]

create table City
(
id int identity(1,1),
city varchar(50) not null unique,
constraint PK_City primary key(id)
);

Go

create table CntType
(
id int identity(1,1),
[type] nvarchar(50) not null unique, --Contractor type like 'äÇÏí ÑíÇÖí','ãÄÓÓÉ ÊÚáíãíÉ','ÔÑßÉ',..
constraint PK_CntType primary key(id)
);

GO

create table Contractor --Partners, Hostel owners and transport owners
(
id int identity(1,1),
cityID int,
class nchar(3) not null, -- Class like Hostel Owner, Transport Owner, Partner, ..
[name] varchar(75) not null, --Company Name
CRN char(20) not null, --Commercial Register number
email nvarchar(75),
[zone] varchar(10),
localAdd varchar(20),
typeID int,
contractDate date not null,
contractTermination date null,
[state] bit not null default 0, --states are '1=idle','0=active'
discount float null default 0.2 check(discount between 0 and 1),
constraint CK_cntClass check (class in ('hst','trs','prt','ad')),
constraint FK_cntCityID foreign key (cityID) references City(id) on delete set null,
constraint FK_cntTypeID foreign key (typeID) references CntType(id) on delete set null,
constraint PK_Contractor primary key (id)
);

Go

create table Freelancer
(
id int identity(1,1),
[name] varchar(75) not null,
NID char(20) not null,
gender bit not null default 0,
mobile char(11) not null unique,
birthDate date not null,
email nvarchar(75),
cityID int,
[zone] varchar(20),
localAdd varchar(20),
salary money not null default 0,
empDate date not null,
empTermination date null,
[state] bit not null default 0,
constraint FK_flcCityID foreign key (cityID) references City(id) on delete set null,
constraint PK_Freelancer primary key (id)
);
Go
create table TrsType
(
id int identity(1,1),
[type] nvarchar(50) not null unique, --Transport type like 'ÃæÊæÈíÓ','ÓíÇÑÉ','ãÑßÈ',..
constraint PK_TrsType primary key(id)
);

GO

create table Transport
(
id int identity (1,1),
typeID int,
ownerID int null,
number varchar(25) null,
model nvarchar(30) null,
capacity smallint default 0 check(capacity >= 0),
cityID int,
creatDate smalldatetime not null,
cost money not null default 0, -- cost per day
[state] bit not null default 0,
constraint FK_trsCityID foreign key (cityID) references City(id) on delete set null,
constraint FK_trsTypeID foreign key (typeID) references TrsType(id) on delete set null,
constraint FK_trsOwnerID foreign key (ownerID) references Contractor(id) on delete set null,
constraint PK_Transport primary key (id)
);
Go
create table HstType
(
id int identity(1,1),
[type] nvarchar(50) not null unique, --Hostel type like 'ÝäÏÞ','ÔÞÉ ÝäÏÞíÉ','áæßÇäÏÉ',..
constraint PK_HstType primary key(id)
);

Go

create table Hostel
(
id int identity(1,1),
typeID int,
[name] nvarchar(75) not null,
ownerID int null,
creatDate smalldatetime not null,
[state] bit not null default 0,
cityID int,
[zone] varchar(20),
localAdd varchar(20),
capacity smallint default 0 check(capacity >= 0),
hotelDegree char(1) default 3 not null,
cost money not null default 0, -- cost Per Night
constraint FK_hstCityID foreign key (cityID) references City(id) on delete set null,
constraint FK_hstTypeID foreign key (typeID) references HstType(id) on delete set null,
constraint FK_hstOwnerID foreign key (ownerID) references Contractor(id) on delete set null,
constraint PK_Hostel primary key (id)
);

Go

create table PlcType
(
id int identity(1,1),
[type] nvarchar(50) not null unique, --Place type like 'Planetarium','ãÚÈÏ ÝÑÚæäí','ÔÇØÆ',..
constraint PK_PlcType primary key(id)
);

Go

create table Place
(
id int identity(1,1),
typeID int,
[state] bit not null default 0,
[name] nvarchar(50) not null,
cityID int,
capacity smallint not null default 0 check(capacity >= 0),
cost money not null default 0, -- cost Per Visit
constraint FK_plcTypeID foreign key (typeID) references PlcType(id) on delete set null,
constraint FK_plcCityID foreign key (cityID) references City(id) on delete set null,
constraint PK_Place primary key (id)
);

Go

create table Guide
(
id int,
specialty varchar(15) not null,  -- specialty like 'ÊÑÝíåí','ÓÇÍáí','ÝÑÚæäí',..
exDegree varchar(15) not null, -- experience degree like 'ÎÈíÑ','ãÊæÓØ','ÌíÏ',..
constraint CK_gudSpecialty check(specialty in('ÝÑÚæäí', 'ÔæÇØÆ', 'ÛæÕ','ÅÓáÇãí', 'ãÓíÍí', 'ÕÍÇÑí','ãÍãíÇÊ', 'ÊÑÝíåí')),
constraint CK_gudExDegree check(exDegree in('ãÓÊÌÏ', 'ããÇÑÓ', 'ãÊæÓØ','ÌíÏ', 'ÝæÞ ÌíÏ', 'ãÍÊÑÝ','ÎÈíÑ')),
constraint FK_gudFlcID foreign key (id) references Freelancer(id) on delete cascade,
constraint PK_Guide primary key (id)
);

Go
create table Brochure
(
id int identity(1,1),
companyID int null,
pages tinyint not null default 0,
creatDate smalldatetime not null,
designCost money not null default 0,
cost money not null default 0, -- printing cost
[state] bit not null default 0, 
constraint FK_bruCompanyID foreign key (companyID) references Contractor(id) on delete set null,
constraint PK_Brochure primary key (id)
);

Go

create table Travel
(
id int identity (1,1),
title nvarchar(100), 
creatDate smalldatetime not null,
[state] bit not null default 0, 
startDate date not null,
endDate date not null,
daysNum tinyint not null default 0,
price smallmoney not null default 0,
trvCost money not null default 0,
trvProfit money not null default 0,
turNum smallint not null default 0,
bruNum smallint not null default 0,
bruCost money not null default 0,
adNum tinyint not null default 0,
adCost money not null default 0,
trsCapacity int not null default 0,
hstCapacity int not null default 0,
constraint PK_Travel primary key (id)
);

Go

create table Tourist
(
id int identity(1,1),
NID char(14),
[name] varchar(75) not null,
gender bit not null default 0,
birthDate date not null,
mobile char(11) not null,
email varchar(50),
prtID int null,
info nvarchar(max),
score smallint not null default 0,
balance money not null default 0,
creatDate smalldatetime not null,
cityID int,
[state] bit not null default 0,
constraint FK_turCityID foreign key (cityID) references City(id) on delete set null,
constraint FK_turPrtID foreign key (prtID) references Contractor(id) on delete set null,
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
create table Media
(
id int identity(1,1),
media nvarchar(50) not null unique,
constraint PK_Media primary key(id)
);

GO

create table Advertisement
(
id int identity(1,1),
mediaID int,
companyID int,
info varchar(150),
designCost money not null default 0,
cost money not null default 0, -- promotion cost
targetedNum int not null default 0,
reachedNum int not null default 0,
startDate date not null,
endDate date,
[state] bit not null default 0,
constraint FK_adMediaID foreign key (mediaID) references Media(id) on delete set null,
constraint FK_adCompanyID foreign key (companyID) references Contractor(id) on delete set null,
constraint PK_Advertisement primary key(id)
);


Go

create table RegTransport
(
trvID int,
trsID int,
setsNum tinyint,
daysNum tinyint,
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
bedNum smallint,
nightNum tinyint,
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
visitorNum smallint not null default 0,
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
groupNum tinyint not null default 50,
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
quantity smallint not null default 0,
totalCost money not null default 0,
regDate smalldatetime not null,
constraint FK_bruTrvID foreign key (trvID) references Travel(id) on delete cascade,
constraint FK_bruID foreign key (bruID) references Brochure(id) on delete cascade,
constraint PK_RegBrochure primary key(trvID,bruID)
);

GO

create table RegAdvertisement
(
trvID int,
adID int,
quantity smallint not null default 0,
totalCost money not null default 0,
regDate smalldatetime not null,
constraint FK_adTrvID foreign key (trvID) references Travel(id) on delete cascade,
constraint FK_adID foreign key (adID) references Advertisement(id) on delete cascade,
constraint PK_RegAdvertisment primary key(trvID,adID)
);

GO

create table Agent
(
id int,
usrID nchar(10) unique not null,
[role] nchar(10) not null default 'operator', -- roles are (operator, supervisor, admin)
[password] nvarchar(20),
constraint CK_agnRole check ([role] in ('operator', 'supervisor', 'admin')),
constraint FK_agnFlcID foreign key (id) references Freelancer(id) on delete cascade,
constraint PK_Agent primary key (id)
);

Go

create Table AgentLogin
(
agnID int,
[login] smalldatetime not null,
[logout] smalldatetime,
constraint FK_loginUsrID foreign key (agnID) references Agent(id),
constraint PK_AgentLogin primary key (agnID,[login])
);

Go

create table AgentAction
(
agnID int,
[action] nchar(3) not null, -- Actions are ('new', 'edit', 'active','idle', 'delete')
[type] nchar(6) not null, -- Types like Turist, Travel, ..
itemID int not null,
[time] smalldatetime not null,
constraint CK_agnActAction check([action] in('new', 'edt', 'act','idl', 'del')),
constraint CK_agnActType check([type] in('tur', 'trv', 'cntHst','cntTrs','cntad', 'flc','trs',
'hst','plc','gud','agn','bru','pro','ad','regTur','regGud','regAd','regBru','regHst','regTrs','regPlc')),
constraint FK_ActionAgnID foreign key (agnID) references Agent(id),
constraint PK_AgentAction primary key (agnID,[time])
);

GO

create table Porduction
(
id int identity(1,1),
agnID int,
totalAgn int not null default 0,
totalTrv int not null default 0,
adCost money not null default 0,
trsCost money not null default 0,
gudCost money not null default 0,
hstCost money not null default 0,
plcCost money not null default 0,
prtCost money not null default 0,
bruCost money not null default 0,
agnCost money not null default 0,
operatingCost money not null default 0,
turProfit money not null default 0,
totalCost money not null default 0,
totalProfit money not null default 0,
tax float not null default 0.20 check(tax between 0 and 1),
natProfit money not null default 0,
[state] bit not null default 0,
constraint FK_proAgnID foreign key (agnID) references Agent(id),
constraint PK_Porduction primary key(id)
);


/*Tables name shortcut for foreign keys:
Contractor --> cnt
Travel	  --> trv
Transport --> trs
Hostel    --> hst
Place     --> plc
Guide     --> gud
Tourist   --> tur
Brochure  --> bru
Porduction -->pro
Agent --> agn
Advertisement --> ad
Freelancer --> flc
*/
