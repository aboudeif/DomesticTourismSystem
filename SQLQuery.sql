
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

CREATE TABLE ServiceProvider --Partners, Hostel owners, transport owners and Advertisement Company
(
id INT IDENTITY(1,1),
class NCHAR(3) NOT NULL, -- Class = Hostel Owner, Transport Owner, Partner, Ad Company
[name] VARCHAR(75) NOT NULL, --Company Name
CRN CHAR(30) NOT NULL, --Commercial Register number
email NVARCHAR(75),
cityID INT NULL,
localAdd VARCHAR(100),
[type] VARCHAR(30) NOT NULL, --Contractor type like '���� �����','����� �������','����',..
CREATEDate DATE NOT NULL DEFAULT GETDATE(),
idle BIT NOT NULL DEFAULT 0, --status are '1=idle','0=active'
discount FLOAT NULL DEFAULT 0.0 CHECK(discount BETWEEN 0.0 and 1.0),
CONSTRAINT CK_SPClass CHECK (class IN (N'hst',N'trs',N'prt',N'ad')),
CONSTRAINT FK_SPCityID FOREIGN KEY (cityID) REFERENCES City(id) ON DELETE SET NULL,
CONSTRAINT PK_SP PRIMARY KEY (id)
);

Go


CREATE TABLE Transport
(
id INT IDENTITY (1,1),
[type] VARCHAR(30) NOT NULL, --Transport type like '�������','�����','����',..
ownerID INT NULL,
panelNo VARCHAR(25) NULL,
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
[type] VARCHAR(30) NOT NULL, --Hostel type like '����','��� ������','�������',..
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
[type] NVARCHAR(50) NOT NULL, --Place type like 'Planetarium','���� ������','����',..
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
USE [DTSDB]

CREATE TABLE Guide
(
id INT IDENTITY(1,1),
specialty VARCHAR(15) NOT NULL,  -- specialty like '������','�����','������',..
[name] VARCHAR(75) NOT NULL, 
NID CHAR(14) NOT NULL,
gender BIT NOT NULL DEFAULT 0,
mobile CHAR(11) NOT NULL UNIQUE,
birthDate DATE NOT NULL,
email NVARCHAR(75),
cityID INT NULL,
localAdd VARCHAR(100),
rate MONEY NOT NULL DEFAULT 0,
creatDate SMALLDATETIME NOT NULL DEFAULT GETDATE(),
idle BIT NOT NULL DEFAULT 0,
CONSTRAINT FK_gudCityID FOREIGN KEY (cityID) REFERENCES City(id) ON DELETE SET NULL,
CONSTRAINT PK_Guide PRIMARY KEY (id)
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
price MONEY NOT NULL DEFAULT 0,
CONSTRAINT PK_Travel PRIMARY KEY (id)
);

Go

CREATE TABLE Tourist
(
id INT IDENTITY(1,1),
prtID INT NULL,
info NVARCHAR(MAX),
balance MONEY NOT NULL DEFAULT 0,
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
CONSTRAINT FK_turPrtID FOREIGN KEY (prtID) REFERENCES ServiceProvider(id) ON DELETE SET NULL,
CONSTRAINT FK_turCityID FOREIGN KEY (cityID) REFERENCES City(id) ON DELETE SET NULL,
CONSTRAINT PK_Tourist PRIMARY KEY (id)
);

GO

CREATE TABLE Phone
(
id INT,
phone VARCHAR(11) UNIQUE NOT NULL,
fax BIT NULL,
CONSTRAINT FK_phPrsID FOREIGN KEY (id) REFERENCES ServiceProvider(id) ON DELETE CASCADE,
CONSTRAINT PK_Phone PRIMARY KEY(id,phone)
);

Go

CREATE TABLE Advertisement
(
id INT IDENTITY(1,1),
companyID INT NULL,
info VARCHAR(MAX),
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
daysNum TINYINT NOT NULL DEFAULT 0,
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


CREATE TABLE Campaign
(
id INT IDENTITY(1,1),
trvID INT NOT NULL,
adID INT NOT NULL,
media NVARCHAR(50) NOT NULL,
targetedNum INT NULL,
reachedNum INT NULL,
startDate DATE NOT NULL,
endDate DATE NULL,
regDate SMALLDATETIME NOT NULL DEFAULT GETDATE(),
cost MONEY NOT NULL DEFAULT 0, -- promotion cost
idle BIT NOT NULL DEFAULT 0,
CONSTRAINT FK_cmpTrvID FOREIGN KEY (trvID) REFERENCES Travel(id) ON DELETE CASCADE,
CONSTRAINT FK_adID FOREIGN KEY (adID) REFERENCES Advertisement(id) ON DELETE CASCADE,
CONSTRAINT PK_Campaign PRIMARY KEY(id)
);


GO

CREATE TABLE Agent
(
id INT IDENTITY(1,1),
usrID NCHAR(10) UNIQUE NOT NULL,
[password] NVARCHAR(30) NOT NULL,
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
CONSTRAINT FK_agnCityID FOREIGN KEY (cityID) REFERENCES City(id) ON DELETE SET NULL,
CONSTRAINT PK_Agent PRIMARY KEY (id)
);







/*TABLEs name shortcut for foreign keys:
ServiceProvider --> SP
Travel	  --> trv
Transport --> trs
Hostel    --> hst
Place     --> plc
Guide     --> gud
Tourist   --> tur
Agent --> agn
Advertisement --> ad
City-->cty



*/
