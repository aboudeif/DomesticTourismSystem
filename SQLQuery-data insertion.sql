
USE [DTSDB]

INSERT INTO CIty (city) 
			VALUES  ('ÃÓæÇä'),
					('ÃÓíæØ'),
					('ÇáÃÓßäÏÑíÉ'),
					('ÇáÅÓãÇÚíáíÉ'),
					('ÇáÃÞÕÑ'),
					('ÇáÈÍÑ ÇáÃÍãÑ'),
					('ÇáÈÍíÑÉ'),
					('ÇáÌíÒÉ'),
					('ÇáÏÞåáíÉ'),
					('ÇáÓæíÓ'),
					('ÇáÔÑÞíÉ'),
					('ÇáÛÑÈíÉ'),
					('ÇáÞÇåÑÉ'),
					('ÇáÞáíæÈíÉ'),
					('ÇáãäæÝíÉ'),
					('ÇáãäíÇ'),
					('ÇáæÇÏí ÇáÌÏíÏ'),
					('Èäí ÓæíÝ'),
					('ÈæÑÓÚíÏ'),
					('ÌäæÈ ÓíäÇÁ'),
					('ÓæåÇÌ'),
					('ÔãÇá ÓíäÇÁ'),
					('ãØÑæÍ'),
					('ÏãíÇØ');
INSERT INTO ServiceProvider (class,[name],CRN,email,cityID,localAdd,[type],discount)
			VALUES ('trs','ÔÑßÉÇáäÞá ÇáÓíÇÍí','Ó Ê 5668','info@turtravel.com',3,'ãÈäí 5 ÔÇÑÚ ÇáÃÓæÇÑ','ÔÑßÉ',NULL),
				   ('trs','ÔÑßÉ ÇáÓÝÑ ÇáÓÑíÚ','Ó Ê 46464354','partner@fast-travel.com',4,'ÑÞã 3 ÇáÏæÑ 3 ÇáãíÏÇä ÇáÌÏíÏ','ÔÑßÉ',NULL),
				   ('hst','ãßÊÈ ÇáÍÇÌ ÃÈæ ÌÚÝÑ ááÚÞÇÑÇÊ','Ó Ê 1312545875','abougaffar@gmail.com',17,'ãÈäí 5 ÇáØÑíÞ ÇáÒÑÇÚí ÞÑíÉ ÃÈæ ÇáÓÈÇÚ','ãßÊÈ ÚÞÇÑí',NULL),
				   ('hst','ÔÑßÉ ÇáÝäÇÏÞ ÇáÚÇáãíÉ','Ó Ê 10158655','info@interhotel.com',3,'ÑÞã 13 ãíÏÇä ÇáäÕÑ','ÔÑßÉ',NULL),
				   ('prt','ãÄÓÓÉ ÇáÔÑÞ','Ó Ê 165484326959','info@est.com',3,'ãÈäí 5 ÇáÏæÑ 9 ÇáØÑíÞ ÇáÓÑíÚ','ãÄÓÓÉ',0.30),
				   ('prt','ÇáÔÑßÉ ÇáãÕÑíÉ áÊæÒíÚ ÇáßåÑÈÇÁ','Ó Ê 25688','info@ecte.com',4,'ãíÏÇä ÇáÚÇÕãÉ ãÈäí 66','ÔÑßÉ',0.22),
				   ('ad','ÔÑßÉ ãÇÊÑíßÓ ááÏÚÇíÉ æÇáÅÚáÇä','Ó Ê 65468435','send@matrix.com',3,'ÇáãäØÞÉ ÇáÃæáí ãÈäí 15 ÇáÏæÑ 6','ÔÑßÉ',NULL);

INSERT INTO Agent (usrID,[password],[name],NID,gender,mobile,birthDate,email,cityID,localAdd) 
			VALUES ('Abdallah','5555','ÚÈÏ Çááå ãÍãÏ ÇáÓíÏ','28910215465884',0,'01222365485','1989-10-01','comofcom@gmail.com',3,'ÔÞÉ 7 ÚãÇÑÉ 9 ÔÇÑÚ ÇáÌáÇÁ - Íí ÇáãäÊÒå'),
				   ('Hazem','2222','ÍÇÒã ÍãÇÏ','28911111165884',0,'01222745485','1989-9-15','hazem@gmail.com',3,' ÔÞÉ 203 ãíÏÇä ÝíßÊæÑíÇ - Íí ÇáãäÊÒå'),
				   ('Abdelaal','1111','ãÍãÏ ÚÈÏ ÇáÚÇá ãÍãÏ','28910217894384',0,'01236575485','1984-6-3','abdelaal@gmail.com',3,'Íí ÇáÈÓÊÇä - ãÏíäÉ ÇáÒåæÑ'),
				   ('Mas3oud','0000','ãÍãÏ ãÓÚæÏ','23560012123241',0,'01285463215','2001-7-4','mas3oud@gmail.com',3,' ÑÞã 3 ØÑíÞ 5 ÇáÍí ÇáÅÏÇÑí ÇáËÇäí');
INSERT INTO Advertisement (companyID,info,designCost) 
			VALUES (NULL,'ÅÚáÇä ÔÑã æÇáÛÑÏÞÉ 1',450),
				   (NULL,'ÅÚáÇä ÔÑã æÇáÛÑÏÞÉ - ãÍãÏ Úáí',800),
				   (7,'ÅÚáÇä ÞíÊÈÇí æÃäØæäíÇÏÓ ÔåÑ 7',1570.0),
				   (7,'ÇáÅÚáÇä ÇáÃÓÇÓí',950.0),
				   (NULL,'ÅÚáÇä ÚÇã - ÍÓä ÑãÖÇä ',13200.0),
				   (7,'Matrix co. demo',300.0),
				   (NULL,'ÇáÃåÑÇãÇÊ + ÝäÏÞ ÔíÑÇÊæä',795.0),
				   (7,'ÅÚáÇä ãíßÓ ÕíÝ 2020',3500.0);
INSERT INTO Guide (rate,specialty,[name],NID,gender,mobile,birthDate,email,cityID,localAdd)
			VALUES(250.0,'ÊÑÝíåí','ÃÍãÏ ÍÓä ÚÈÏ ÇáÑÍãä','28563214976425',0,'01165232547','1990-5-16','ahmedhassan12@yahoo.com',3,'16 ÔÇÑÚ ÇáãäÔíÉ ÇáÚØÇÑíä'),
				  (300.0,'ÊÇÑíÎ ÝÑÚæäí','ßÑíã ÃÍãÏ ãÍãÏ','29856987542136',0,'01256365874','1989-12-1','kareemahmed@gmail.com',2,'ÞÑíÉ ÇáäÓÑ ÇáÃÎÖÑ ØÑíÞ ÇáÓÈÇÚ'),
				  (350.0,'ÊÇÑíÎ ÅÓáÇãí','ÚÈÏ ÇáÓáÇã ÚÈÏ ÇáÕãÏ ÚÈÏ ÇáÓáÇã','28967458965478',0,'01125475412','1987-3-22','abdelsalaam@yahoo.com',5,'ÔÞÉ 15 Èáæß 7 Íí Ãæá'),
				  (200.0,'ãÍãíÇÊ','ãÄãä ÚÈÏÇáÑÄæÝ ãÍãæÏ','23625014563298',0,'01023548769','1985-5-26','elsayedm@msn.com',3,'Ãæá äÝÞ ÇáãÑæÑ ÔÇÑÚ ÇáÚÞÑÈ'),
				  (600.0,'ÛæÕ æÓæÇÍá','ÇáÓíÏ ÃÍãÏ ÚÈÏ ÇáÓÊÇÑ','20368565892544',0,'01063254784','2001-10-24',NULL,7,'23 ÔÇÑÚ ÇáÔíÎ ãÑßÒ ÞæíÓäÇ'),
				  (450.0,'ÍíæÇäÇÊ ÈÑíÉ','æÇÆá ãÍãæÏ ÍÓä','29657484563201',0,'01256385520','1999-11-23','waeell@gmail.com',10,'33 ÔÇÑÚ Çáäíá'),
				  (750.0,'ÕÍÇÑí','ÚÈÇÓ ÚÈÏ ÇáÑÍíã ÇáÌäÏí','36559621478541',0,'01125463254','2005-8-18','abbas2011@icloud.com',22,'404 ãíÏÇä ÇáäÔÇÑ'),
				  (290.0,'ÊÇÑíÎ ÝÑÚæäí','ÝÇÑæÞ ãÍãæÏ ßãÇá','36598562147410',0,'01025469654','2004-6-19','farouk@yahoo.com',5,'äÇÕíÉ ÔÇÑÚ ÇááÈÇä - ãíÊ äÕÑ'),
				  (450.0,'ÑíÇÖí','ÃÍãÏ ãÍãæÏ ÍÇãÏ','26593001458691',0,'01232541253','1998-5-19','a_mlion@gmail.com',19,'17 ØÑíÞ ÇáÈÍÑ Çáßíáæ 13 íãíä');
INSERT INTO Hostel (ownerID,[name],[type],cityID,localAdd,capacity,hotelDegree,cost)
			VALUES  (4,'ÝäÏÞ ÔíÑÇÊæä','ÝäÏÞ',3,'ÇáãäÊÒå',200,7,2400.0),
					(3,'ÝäÏÞ ÑãÓíÓ','ÝäÏÞ',4,'ßæÑäíÔ Çáäíá - ÑãÓíÓ',200,5,1400.0),
					(NULL,'áæßÇäÏÉ ÇáÈÇÔÇ','áæßÇäÏÉ',6,'ÑÞã 14 ÔÇÑÚ ÇáÍÇÌ ÚÑÝÉ',50,2,150.0),
					(NULL,'ÃÈÑÇÌ ÇáÔãÓ','ÔÞÉ ãÝÑæÔÉ',2,'ãíÏÇä ÇáãäÍá',50,2,100.0),
					(3,'ÔÇáíåÇÊ ÞÑíÉ ÇáÛÒÇá','ÔÇáíå',9,'ÑÞã 17 ÞÑíÉ ÇáÛÒÇá',44,3,190.0),
					(3,'ÔÞÞ ÇáíÇÞæÊ','ÔÞÞ ÝäÏÞíÉ',20,'ÔÇÑÚ ÇáãÏÑÓÉ - ÚãÇÑÇÊ ÇáíÇÞæÊ',25,3,300.0),
					(4,'ÝäÏÞ ÇáÔíÎ ÍÓäíä','ÝäÏÞ',17,'ÑÞã 22 ÔÇÑÚ ÇáÈÍÑ',130,3,250.0);
INSERT INTO Place ([type],[name],cityID,capacity,cost)
			VALUES('ÔÇØÆ','ÔÇØÆ ÇáÓÚÇÏÉ',9,300,25.0),
				  ('ãÚÈÏ ÝÑÚæäí','ãÚÈÏ ÃÈæÓãÈá',19,150,50.0),
				  ('ãÓÌÏ','ãÓÌÏ ãÍãÏ Úáí',4,200,30.0),
				  ('ÞáÚÉ','ÞáÚÉ ÞíÊÈÇí',3,220,25.0),
				  ('åÑã','åÑã ÎæÝæ',5,25,75.0),
				  ('ãÊÍÝ','ÇáãÊÍÝ ÇáÞæãí',4,700,125.0),
				  ('Planetarium','ÇáÞÈÉ ÇáÓãÇæíÉ',3,100,30.0);
INSERT INTO Travel (title,startDate,endDate,price)
			VALUES ('ÑÍáÉ Åáí ãÚÇáã ÇáÇÓßäÏÑíÉ','2021-07-11','2021-07-12',1200.0),
				   ('ÑÍáÉ ÔÑã æÇáÛÑÏÞÉ áãÏÉ 3 ÃíÇã','2021-08-15','2021-08-18',5200.0);
INSERT INTO Transport ([type],panelNo,model,capacity,cityID,cost)
			VALUES	  ('ÃæÊæÈíÓ','Ó Ó È 3 4 5','ãíÑÓíÏíÓ 2005',50,7,300),
					  ('ÃæÊæÈíÓ','Ú á á 2 3 5','ÊæíæÊÇ 2017',70,3,900),
					  ('ãíäí ÈÇÕ','ÃÌÑÉ ÇáÌíÒÉ - 458674','ãíÊÓæÈíÔí 2014',30,15,200.0),
					  ('ÓíÇÑÉ','Õ í È 3 6 8','ÈíÌæ 2005',7,9,70.0),
					  ('áíãæÒíä','Í í á 4 5 ','ÃæÏí 2019',14,3,500.0),
					  ('ãÑßÈ ÔÑÇÚíÉ',NULL,NULL,25,4,700.0);
INSERT INTO Tourist (prtID ,info,balance,[name],NID,gender,mobile,birthDate,email,cityID,localAdd)
			VALUES	(NULL,NULL,3000.0,' ãÍãÏ ÍÓíä ÇáÔíÎ','25636586547521',0,'01125632512','2000-6-14',NULL,3,'ÑÞã 13 ÇáÏæÑ ÇáËÇáË ÎáÝ äÇÏí ÇáäÓÑ'),
					(5,NULL,2300.0,'ÚáÇÁ ÇáÏíä ÎÇáÏ','25658541230125',0,'01144587541','2001-7-16',NULL,3,'ÔÞÉ 208 ÔÇÑÚ ÇáÌáÇÁ Íí ÇáãäÊÒå'),
					(5,NULL,3700.0,'ÍãÇÏÉ ÃÍãÏ ÍãÇÏÉ','20114857965412',0,'01253621421','2000-9-28',NULL,3,'ÑÞã 22 Ãæá ÔÇÑÚ ÇáßæÑäíÔ'),
					(5,NULL,1000.0,'ÅÓãÇÚíá ãÍãÏ ãÍãÏ','23365652214875',0,'01123665412','2005-3-2','famaoljf@gbft.com',3,'Èáæß 5 ÔÞÉ 14 ãäØÞÉ 7 ÇáØÑíÞ ÇáÏæáí'),
					(NULL,NULL,5000.0,'Ããíä ãÍãÏ ãÍãæÏ','22012255874698',0,'01023201254','2003-3-3',NULL,4,'ÑÞã 18 ÔÇÑÚ ÇáãÚáã ÌÇÈÑ Íí ÇáÈÓÊÇä'),
					(NULL,NULL,1000.0,'ãÍÝæÙ ÍÓäíä ÚÈÏ ÇáÍãíÏ','20120165478965',0,'01025486594','2001-8-17',NULL,4,'ÝíáÇ 9 ÔÇÑÚ ÓãíÑ ãÏíäÉ ÇáÓáÇã'),
					(6,NULL,1000.0,'ÃÏã ÝÊÍí ÓÚíÏ','32652141021254',0,'01125463254','1999-5-17',NULL,3,'ÑÞã 44 Íí ÇáÌãÑß ÈÌæÇÑ ÈÇÈ 10'),
					(5,NULL,2400.0,'ÓÇãÍ ÛÑíÈ ÒÇåÑ','33625145879521',0,'01121154254','1998-11-8',NULL,3,'ÔÇÑÚ ÇáÏæáÝíä ãäØÞÉ ÇáÈÍÑ'),
					(6,NULL,700.0,'ßãÇá ÇáÏíä ÚíÏ ßÇãá','20069987741251',0,'01115362112','2005-7-13',NULL,4,'ÈÌæÇÑ ãÈäí ÇáÅÐÇÚÉ æÇáÊáíÝÒíæä Íí ÇáÚÌæÒÉ'),
					(6,NULL,1300.0,'ÑÇÔÏ ãÍãÏ ÔÇåíä','23311199885541',0,'01002255544','2002-7-14','muyymaij@gmail.com',3,'ÑÞã 12 ÇáÏæÑ ÇáÓÇÈÚ ãíÏÇä ÇáÔíÎ'),
					(6,NULL,900.0,'ÃÍãÏ ÛÒÇá ÝÇÖá','20784585974568',0,'01021236543','2001-12-6','nmarmmaermt@yahoo.com',3,'Ãæá ãÍØÉ ÇáÊÑÇã Èáæß 4 ÇáÏæÑ ÇáÚÇÔÑ'),
					(6,NULL,2000.0,'ÝÇÖá ÃÍãÏ ÞÇÓã','35410012141259',0,'01111566858','1999-10-2',NULL,4,'ÈÑÌ ÇáÕÞÑ ÃãÇã äÝÞ ÇáÓáØÇä ÇáÏæÑ 6'),
					(NULL,NULL,500.0,'ÇáÓíÏ ÝÖá ÚæíÓ','32226598745213',0,'01212333666','2005-8-20',NULL,4,'ÚãÇÑÉ 23 ÃãÇã ãÍØÉ ÑãÓíÓ'),
					(NULL,NULL,900.0,'ãÑæÇä ÚÈÏ ÇáÞÇÏÑ ÍÓíä','32558745651245',0,'01285469855','2002-7-23',NULL,3,'ÔÇÑÚ 56 ãäØÞÉ 6 Íí 11'),
					(6,NULL,1700.0,'íæÓÝ ãÍãÏ ÚÈÇÓ','26510014121321',0,'01263611110','2000-9-17',NULL,3,'ÑÞã 7 ÔÇÑÚ ÇáÍí ÈÌæÇÑ ãÈäí ÇáÍí ÇáÞÏíã');

INSERT INTO RegTransport (trvID,trsID,daysNum,totalCost)
			VALUES       (1,2,2,2*(SELECT cost FROM Transport WHERE id = 2)),
						 (1,5,1,1*(SELECT cost FROM Transport WHERE id = 5)),
						 (2,1,2,2*(SELECT cost FROM Transport WHERE id = 1)),
						 (2,3,1,1*(SELECT cost FROM Transport WHERE id = 3)),
						 (2,6,3,3*(SELECT cost FROM Transport WHERE id = 6));
INSERT INTO RegTourist (trvID,turID,actualProfit)
			VALUES	   (1,1,(SELECT price FROM Travel WHERE id = 1)-ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 16)),0)*(SELECT price FROM Travel WHERE id = 1)),
					   (2,10,(SELECT price FROM Travel WHERE id = 2)-ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 10)),0)*(SELECT price FROM Travel WHERE id = 2)),
					   (1,5,(SELECT price FROM Travel WHERE id = 1)-ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 5)),0)*(SELECT price FROM Travel WHERE id = 1)),
					   (1,2,(SELECT price FROM Travel WHERE id = 1)-ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 2)),0)*(SELECT price FROM Travel WHERE id = 1)),
					   (2,8,(SELECT price FROM Travel WHERE id = 2)-ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 8)),0)*(SELECT price FROM Travel WHERE id = 2)),
					   (1,3,(SELECT price FROM Travel WHERE id = 1)-ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 3)),0)*(SELECT price FROM Travel WHERE id = 1)),
					   (2,9,(SELECT price FROM Travel WHERE id = 2)-ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 9)),0)*(SELECT price FROM Travel WHERE id = 2)),
					   (1,7,(SELECT price FROM Travel WHERE id = 1)-ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 7)),0)*(SELECT price FROM Travel WHERE id = 1)),
					   (2,14,(SELECT price FROM Travel WHERE id = 2)-ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 14)),0)*(SELECT price FROM Travel WHERE id = 2)),
					   (2,15,(SELECT price FROM Travel WHERE id = 2)-ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 15)),0)*(SELECT price FROM Travel WHERE id = 2)),
					   (1,4,(SELECT price FROM Travel WHERE id = 1)-ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 4)),0)*(SELECT price FROM Travel WHERE id = 1)),
					   (1,6,(SELECT price FROM Travel WHERE id = 1)-ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 6)),0)*(SELECT price FROM Travel WHERE id = 1));
INSERT INTO RegPlace (trvID,plcID)
			VALUES	 (1,7),
					 (2,2),
					 (2,3),
					 (1,6),
					 (2,1);
INSERT INTO RegHostel (trvID,hstID,roomNum,nightsNum,totalCost)
			VALUES	 (1,1,100,1,4*1*(SELECT cost FROM Hostel WHERE Hostel.id = 1)),
					 (2,3,50,2,2*2*(SELECT cost FROM Hostel WHERE Hostel.id = 3)),
					 (2,6,25,2,3*2*(SELECT cost FROM Hostel WHERE Hostel.id = 6)),
					 (1,2,100,1,3*1*(SELECT cost FROM Hostel WHERE Hostel.id = 2));
INSERT INTO RegGuide (trvID,gudID,daysNum,totalCost)
			VALUES       (1,1,2,2 * (SELECT rate FROM Guide WHERE Guide.id = 1)),
						 (1,2,1,1 * (SELECT rate FROM Guide WHERE Guide.id = 2)),
						 (1,8,2,2 * (SELECT rate FROM Guide WHERE Guide.id = 8)),
						 (2,5,1,1 * (SELECT rate FROM Guide WHERE Guide.id = 5)),
						 (2,7,2,2 * (SELECT rate FROM Guide WHERE Guide.id = 7));
INSERT INTO Phone (id,phone,fax)
			VALUES(1,03564215,0),
				  (1,05623556,0),
				  (1,04562311,1),
				  (2,0325655,1),
				  (3,0254156,0),
				  (3,0232545,0),
				  (4,03030215,0),
				  (5,05857566,0),
				  (6,02145655,1),
				  (7,0245688,0),
				  (7,65565898,1),
				  (6,36562598,1),
				  (2,56856958,0);

INSERT INTO Campaign (trvID,adID,media,targetedNum,reachedNum,startDate,endDate,cost)
			VALUES	 (1,3,'Facebook',7000,5000,'2021-7-1','2021-7-7',100.0),
					 (1,3,'Youtube',12000,8000,'2021-7-2','2021-7-8',200.0),
					 (1,3,'ÌÑíÏÉ ÇáÃåÑÇã',NULL,NULL,'2021-7-13','2021-7-13',1200.0),
					 (2,1,'Facebook',7000,6000,'2021-8-1','2021-8-7',150.0),
					 (2,1,'Youtube',6000,4000,'2021-8-2','2021-8-5',100.0),
					 (1,3,'instagram',17000,1500,'2021-8-13','2021-8-23',600.0);

-- new tourist
INSERT INTO Tourist (prtID ,info,balance,[name],NID,gender,mobile,birthDate,email,cityID,localAdd)
					VALUES			(6,NULL,1200.0,'ÍÓä ãÍãÏ ÚÈÇÓ','26510010021321',0,'01263001110','2000-9-17',NULL,3,'ÑÞã 7 ÔÇÑÚ ÇáÍí ÈÌæÇÑ ãÈäí ÇáÍí ÇáÞÏíã');
-- reg tourist
DECLARE @turprft AS MONEY = (SELECT price FROM Travel WHERE id = 1)-
		  ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 16)),0)*
		   (SELECT price FROM Travel WHERE id = 1)
IF (SELECT balance FROM Tourist WHERE id = 16) >= @turprft
	BEGIN
	INSERT INTO RegTourist (trvID,turID,actualProfit) VALUES (1,16,@turprft)
	UPDATE Tourist SET balance = (balance-@turprft) WHERE id = 16
	END
ELSE
	SELECT 'Not enugh balance'

-- del reg tourist
UPDATE Tourist SET balance = (balance+(SELECT actualProfit FROM RegTourist WHERE trvID = 1 AND turID = 1)) WHERE id = 1
DELETE RegTourist WHERE trvID = 1 AND turID = 1

-- test
select * from RegTourist


