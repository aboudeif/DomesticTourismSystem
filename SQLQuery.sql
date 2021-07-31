
CREATE DATABASE [DTSDB]
-- CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = 'DTS_data',
FILENAME = 'D:\DataBase\DTSDB_data.mdf',
SIZE = 8MB,
FILEGROWTH = 5MB)
 LOG ON 
( NAME = 'DTS_log',
FILENAME = 'D:\DataBase\DTSDB_log.ldf',
SIZE = 5MB,
FILEGROWTH = 5MB)
 COLLATE Arabic_CI_AI

GO

USE [DTSDB]

CREATE TABLE City
(
id INT IDENTITY(1,1),
city VARCHAR(50) NOT NULL UNIQUE,
CONSTRAINT PK_City PRIMARY KEY(id)
);

Go

CREATE TABLE ServiceProvider --Partners, Hostel owners and transport owners
(
id INT IDENTITY(1,1),
class NCHAR(3) NOT NULL, -- Class = Hostel Owner, Transport Owner, Partner, Ad Company
[name] VARCHAR(75) NOT NULL, --Company Name
CRN CHAR(30) NOT NULL, --Commercial Register number
email NVARCHAR(75),
cityID INT NULL,
localAdd VARCHAR(100),
[type] VARCHAR(30) NOT NULL, --Contractor type like 'äÇÏí ÑíÇÖí','ãÄÓÓÉ ÊÚáíãíÉ','ÔÑßÉ',..
CREATEDate DATE NOT NULL DEFAULT GETDATE(),
idle BIT NOT NULL DEFAULT 0, --status are '1=idle','0=active'
discount FLOAT NULL DEFAULT 0.0 CHECK(discount BETWEEN 0.0 and 1.0),
CONSTRAINT CK_SPClass CHECK (class IN (N'hst',N'trs',N'prt',N'ad')),
CONSTRAINT FK_SPCityID FOREIGN KEY (cityID) REFERENCES City(id) ON DELETE SET NULL,
CONSTRAINT PK_SP PRIMARY KEY (id)
);

Go

CREATE TABLE Person
(
id INT IDENTITY(1,1),
class NCHAR(3) NOT NULL, -- Class = Guide, Tourist, Agent
[name] VARCHAR(75) NOT NULL,
NID CHAR(14) NOT NULL,
gender BIT NOT NULL DEFAULT 0,
mobile CHAR(11) NOT NULL UNIQUE,
birthDate DATE NOT NULL,
email NVARCHAR(75),
cityID INT NULL,
localAdd VARCHAR(100),
creatDate SMALLDATETIME NOT NULL DEFAULT GETDATE(),
idle BIT NOT NULL DEFAULT 0,
CONSTRAINT CK_prsClass CHECK (class IN (N'gud',N'tur',N'agn')),
CONSTRAINT FK_prsCityID FOREIGN KEY (cityID) REFERENCES City(id) ON DELETE SET NULL,
CONSTRAINT PK_Person PRIMARY KEY (id)
);
Go

CREATE TABLE Transport
(
id INT IDENTITY (1,1),
[type] VARCHAR(30) NOT NULL, --Transport type like 'ÃæÊæÈíÓ','ÓíÇÑÉ','ãÑßÈ',..
ownerID INT NULL,
number VARCHAR(25) NULL,
model NVARCHAR(30) NULL,
capacity SMALLINT DEFAULT 0 CHECK(capacity >= 0),
cityID INT NULL,
creatDate SMALLDATETIME NOT NULL DEFAULT GETDATE(),
cost MONEY NOT NULL DEFAULT 0, -- cost per day
idle BIT NOT NULL DEFAULT 0,
CONSTRAINT FK_trsCityID FOREIGN KEY (cityID) REFERENCES City(id) ON DELETE SET NULL,
CONSTRAINT FK_trsOwnerID FOREIGN KEY (ownerID) REFERENCES ServiceProvider(id) ON DELETE SET NULL,
CONSTRAINT PK_Transport PRIMARY KEY (id)
);
Go

CREATE TABLE Hostel
(
id INT IDENTITY(1,1),
[name] NVARCHAR(75) NOT NULL,
[type] VARCHAR(30) NOT NULL, --Hostel type like 'ÝäÏÞ','ÔÞÉ ÝäÏÞíÉ','áæßÇäÏÉ',..
ownerID INT NULL,
creatDate SMALLDATETIME NOT NULL DEFAULT GETDATE(),
idle BIT NOT NULL DEFAULT 0,
cityID INT NULL,
localAdd VARCHAR(100),
capacity SMALLINT DEFAULT 0 CHECK(capacity >= 0),
hotelDegree INT NOT NULL DEFAULT 0,
cost MONEY NOT NULL DEFAULT 0, -- cost Per Night
CONSTRAINT CK_hstHotelDegree CHECK (hotelDegree BETWEEN 0 AND 7),
CONSTRAINT FK_hstCityID FOREIGN KEY (cityID) REFERENCES City(id) ON DELETE SET NULL,
CONSTRAINT FK_hstOwnerID FOREIGN KEY (ownerID) REFERENCES ServiceProvider(id) ON DELETE SET NULL,
CONSTRAINT PK_Hostel PRIMARY KEY (id)
);

Go

CREATE TABLE Place
(
id INT IDENTITY(1,1),
[type] NVARCHAR(50) NOT NULL, --Place type like 'Planetarium','ãÚÈÏ ÝÑÚæäí','ÔÇØÆ',..
idle BIT NOT NULL DEFAULT 0,
[name] NVARCHAR(50) NOT NULL,
cityID INT NULL,
capacity SMALLINT NOT NULL DEFAULT 0 CHECK(capacity >= 0),
cost MONEY NOT NULL DEFAULT 0, -- cost Per tourist Visit
creatDate SMALLDATETIME NOT NULL DEFAULT GETDATE(),
CONSTRAINT FK_plcCityID FOREIGN KEY (cityID) REFERENCES City(id) ON DELETE SET NULL,
CONSTRAINT PK_Place PRIMARY KEY (id)
);

Go

CREATE TABLE GuideRate
(
exDegree INT NOT NULL DEFAULT 0, -- experience degree
rate MONEY NOT NULL DEFAULT 0,
CONSTRAINT CK_gudExDegree CHECK (exDegree BETWEEN 0 AND 5),
CONSTRAINT PK_GuideRate PRIMARY KEY (exDegree)
);

GO

CREATE TABLE Guide
(
id INT,
exDegree INT,
specialty VARCHAR(15) NOT NULL,  -- specialty like 'ÊÑÝíåí','ÓÇÍáí','ÝÑÚæäí',..
CONSTRAINT FK_gudPrsID FOREIGN KEY (id) REFERENCES Person(id) ON DELETE CASCADE,
CONSTRAINT FK_gudExDegree FOREIGN KEY (exDegree) REFERENCES GuideRate(exDegree) ON DELETE SET NULL ON UPDATE CASCADE,
CONSTRAINT PK_Guide PRIMARY KEY (id)
);

Go
CREATE TABLE Brochure
(
id INT IDENTITY(1,1),
companyID INT NULL,
pages TINYINT NOT NULL DEFAULT 0,
creatDate SMALLDATETIME NOT NULL DEFAULT GETDATE(),
designCost MONEY NOT NULL DEFAULT 0,
cost MONEY NOT NULL DEFAULT 0, -- prINTing cost
idle BIT NOT NULL DEFAULT 0, 
CONSTRAINT FK_bruCompanyID FOREIGN KEY (companyID) REFERENCES ServiceProvider(id) ON DELETE SET NULL ON UPDATE CASCADE,
CONSTRAINT PK_Brochure PRIMARY KEY (id)
);

Go

CREATE TABLE Travel
(
id INT IDENTITY (1,1),
title NVARCHAR(MAX), 
creatDate SMALLDATETIME NOT NULL DEFAULT GETDATE(),
idle BIT NOT NULL DEFAULT 0, 
startDate DATE NOT NULL,
endDate DATE NOT NULL,
daysNum TINYINT NOT NULL DEFAULT 0,
price MONEY NOT NULL DEFAULT 0,
CONSTRAINT PK_Travel PRIMARY KEY (id)
);

Go

CREATE TABLE Tourist
(
id INT,
prtID INT NULL,
info NVARCHAR(MAX),
score SMALLINT NOT NULL DEFAULT 0,
balance MONEY NOT NULL DEFAULT 0,
CONSTRAINT FK_turPrsID FOREIGN KEY (id) REFERENCES Person(id) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT FK_turPrtID FOREIGN KEY (prtID) REFERENCES ServiceProvider(id) ON DELETE SET NULL,
CONSTRAINT PK_Tourist PRIMARY KEY (id)
);

GO

CREATE TABLE Phone
(
id INT,
phone CHAR(11) UNIQUE NOT NULL,
fax BIT NULL,
CONSTRAINT FK_phPrsID FOREIGN KEY (id) REFERENCES ServiceProvider(id) ON DELETE CASCADE,
CONSTRAINT PK_Phone PRIMARY KEY(id,phone)
);

Go

CREATE TABLE Advertisement
(
id INT IDENTITY(1,1),
companyID INT NULL,
info VARCHAR(250),
designCost MONEY NOT NULL DEFAULT 0,
CREATEDate SMALLDATETIME NOT NULL DEFAULT GETDATE(),
idle BIT NOT NULL DEFAULT 0,
CONSTRAINT FK_adCompanyID FOREIGN KEY (companyID) REFERENCES ServiceProvider(id) ON DELETE SET NULL,
CONSTRAINT PK_Advertisement PRIMARY KEY(id)
);


Go

CREATE TABLE RegTransport
(
trvID INT,
trsID INT,
setsNum TINYINT NOT NULL,
daysNum TINYINT NOT NULL,
totalCost MONEY NOT NULL DEFAULT 0, --computed attribute = trsCost * daysNum
regDate SMALLDATETIME NOT NULL DEFAULT GETDATE(),
CONSTRAINT FK_trsTrvID FOREIGN KEY (trvID) REFERENCES Travel(id) ON DELETE CASCADE,
CONSTRAINT FK_trsID FOREIGN KEY (trsID) REFERENCES Transport(id) ON DELETE CASCADE,
CONSTRAINT PK_RegTrandport PRIMARY KEY(trvID,trsID)
);

Go

CREATE TABLE RegHostel
(
trvID INT,
hstID INT,
roomNum SMALLINT NOT NULL,
nightsNum TINYINT NOT NULL,
totalCost MONEY NOT NULL DEFAULT 0, --computed attribute = hstCost * nightsNum
regDate SMALLDATETIME NOT NULL DEFAULT GETDATE(),
CONSTRAINT FK_hstTrvID FOREIGN KEY (trvID) REFERENCES Travel(id) ON DELETE CASCADE,
CONSTRAINT FK_hstID  FOREIGN KEY (hstID) REFERENCES Hostel(id) ON DELETE CASCADE,
CONSTRAINT PK_RegHostel PRIMARY KEY(trvID,hstID)
);

Go

CREATE TABLE RegPlace
(
trvID INT,
plcID INT,
visitorsNum SMALLINT NOT NULL DEFAULT 0,
regDate SMALLDATETIME NOT NULL DEFAULT GETDATE(),
totalCost MONEY NOT NULL DEFAULT 0, --computed attribute = plcCost * visitorsNum
CONSTRAINT FK_plcTrvID FOREIGN KEY (trvID) REFERENCES Travel(id) ON DELETE CASCADE,
CONSTRAINT FK_plcID FOREIGN KEY (plcID) REFERENCES Place(id) ON DELETE CASCADE,
CONSTRAINT PK_RegPlace PRIMARY KEY(trvID,plcID)
);

Go

CREATE TABLE RegGuide
(
trvID INT,
gudID INT,
groupNum TINYINT NOT NULL DEFAULT 0,
regDate SMALLDATETIME NOT NULL DEFAULT GETDATE(),
totalCost MONEY NOT NULL DEFAULT 0, --computed attribute = gudCost * groupNum
CONSTRAINT FK_gudTrvID FOREIGN KEY (trvID) REFERENCES Travel(id) ON DELETE CASCADE,
CONSTRAINT FK_gudID FOREIGN KEY (gudID) REFERENCES Guide(id) ON DELETE CASCADE,
CONSTRAINT PK_RegGuide PRIMARY KEY(trvID,gudID)
);

Go

CREATE TABLE RegTourist
(
trvID INT,
turID INT,
regDate SMALLDATETIME NOT NULL DEFAULT GETDATE(),
actualProfit MONEY NOT NULL DEFAULT 0, --computed attribute = trvPrice * prtDiscount
CONSTRAINT FK_turTrvID FOREIGN KEY (trvID) REFERENCES Travel(id) ON DELETE CASCADE,
CONSTRAINT FK_turID FOREIGN KEY (turID) REFERENCES Tourist(id) ON DELETE CASCADE,
CONSTRAINT PK_RegTourist PRIMARY KEY(trvID,turID)
);

Go

CREATE TABLE RegBrochure
(
trvID INT,
bruID INT,
quantity SMALLINT NOT NULL DEFAULT 0,
regDate SMALLDATETIME NOT NULL DEFAULT GETDATE(),
totalCost MONEY NOT NULL DEFAULT 0, --computed attribute = bruCost * quantity
CONSTRAINT FK_bruTrvID FOREIGN KEY (trvID) REFERENCES Travel(id) ON DELETE CASCADE,
CONSTRAINT FK_bruID FOREIGN KEY (bruID) REFERENCES Brochure(id) ON DELETE CASCADE,
CONSTRAINT PK_RegBrochure PRIMARY KEY(trvID,bruID)
);

GO

CREATE TABLE Campaign
(
trvID INT,
adID INT,
media NVARCHAR(50) NOT NULL,
targetedNum INT NOT NULL DEFAULT 0,
reachedNum INT NOT NULL DEFAULT 0,
startDate DATE NOT NULL,
endDate DATE NULL,
regDate SMALLDATETIME NOT NULL DEFAULT GETDATE(),
cost MONEY NOT NULL DEFAULT 0, -- promotion cost
CONSTRAINT FK_adTrvID FOREIGN KEY (trvID) REFERENCES Travel(id) ON DELETE CASCADE,
CONSTRAINT FK_adID FOREIGN KEY (adID) REFERENCES Advertisement(id) ON DELETE CASCADE,
CONSTRAINT PK_RegAdvertisment PRIMARY KEY(trvID,adID)
);

GO

CREATE TABLE AgentRate
(
id INT,
[role] NCHAR(10) NOT NULL UNIQUE, -- roles are (operator, supervisor, admin)
rate MONEY NOT NULL DEFAULT 0,
CONSTRAINT CK_agnRole CHECK ([role] IN (N'operator', N'supervisor', N'admin')),
CONSTRAINT PK_AgentRate PRIMARY KEY (id)
);

GO

CREATE TABLE Agent
(
id INT,
roleID INT,
usrID NCHAR(10) UNIQUE NOT NULL,
[password] NVARCHAR(30),
CONSTRAINT FK_agnprsID FOREIGN KEY (id) REFERENCES Person(id) ON DELETE CASCADE,
CONSTRAINT FK_agnRoleID FOREIGN KEY (roleID) REFERENCES AgentRate(id) ON DELETE SET NULL ON UPDATE CASCADE,
CONSTRAINT PK_Agent PRIMARY KEY (id)
);

Go

CREATE TABLE AgentLog
(
id INT IDENTITY(1,1),
agnID INT,
[log] SMALLDATETIME NOT NULL DEFAULT GETDATE(),
[type] BIT DEFAULT 0, -- 0=LOGin, 1=LOGout
CONSTRAINT FK_logUsrID FOREIGN KEY (agnID) REFERENCES Agent(id) ON DELETE CASCADE,
CONSTRAINT PK_AgentLog PRIMARY KEY (id)
);

Go

CREATE TABLE AgentAction
(
agnID INT,
[action] NCHAR(3) NOT NULL, -- Actions are ('new', 'edit', 'active','idle', 'delete')
[type] NCHAR(6) NOT NULL, -- Types like Turist, Travel, ..
itemID INT NOT NULL,
[time] SMALLDATETIME NOT NULL DEFAULT GETDATE(),
CONSTRAINT CK_agnActAction CHECK([action] IN ('new', 'edt', 'act','idl', 'del')),
CONSTRAINT CK_agnActType CHECK([type] IN ('tur', 'trv', 'SPHst','SPTrs','SPad','trs','prt',
'hst','plc','gud','agn','cty','bru','ad','regTur','regGud','regAd','regBru','regHst','regTrs','regPlc','gudRat','agnRat')),
CONSTRAINT FK_ActionAgnID FOREIGN KEY (agnID) REFERENCES Agent(id) ON DELETE CASCADE,
CONSTRAINT PK_AgentAction PRIMARY KEY (agnID,[time])
);



--23 direct action class 
--3 indirect show class 
-- telephone and email report
-- production [pro,combany balance, call cost,design cost(c)]
--or company open balance[ year, balance, ÏÇÆä, ãÏíä
-- ÇáÍÓÇÈ ÇáãÝÕá > ÊÇÑíÎ ÇáÚãáíÉ - ÇáÞíãÉ - äæÚ ÇáÚãáíÉ - ÇáÑÕíÏ - ÏÇÆä - ãÏíä>



/*TABLEs name shortcut for foreign keys:
ServiceProvider --> SP
Travel	  --> trv
Transport --> trs
Hostel    --> hst
Place     --> plc
Guide     --> gud
Tourist   --> tur
Brochure  --> bru
Agent --> agn
Advertisement --> ad
Person --> prs
City-->cty
GuideRate--> gudRat
AgentRate--> agnRat


*/
