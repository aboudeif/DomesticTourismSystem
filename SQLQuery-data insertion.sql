
USE [DTSDB]

INSERT INTO CIty (city) 
			VALUES  ('�����'),
					('�����'),
					('����������'),
					('�����������'),
					('������'),
					('����� ������'),
					('�������'),
					('������'),
					('��������'),
					('������'),
					('�������'),
					('�������'),
					('�������'),
					('���������'),
					('��������'),
					('������'),
					('������ ������'),
					('��� ����'),
					('�������'),
					('���� �����'),
					('�����'),
					('���� �����'),
					('�����'),
					('�����');
INSERT INTO ServiceProvider (class,[name],CRN,email,cityID,localAdd,[type],discount)
			VALUES ('trs','��������� �������','� � 5668','info@turtravel.com',3,'���� 5 ���� �������','����',NULL),
				   ('trs','���� ����� ������','� � 46464354','partner@fast-travel.com',4,'��� 3 ����� 3 ������� ������','����',NULL),
				   ('hst','���� ����� ��� ���� ��������','� � 1312545875','abougaffar@gmail.com',17,'���� 5 ������ ������� ���� ��� ������','���� �����',NULL),
				   ('hst','���� ������� ��������','� � 10158655','info@interhotel.com',3,'��� 13 ����� �����','����',NULL),
				   ('prt','����� �����','� � 165484326959','info@est.com',3,'���� 5 ����� 9 ������ ������','�����',0.30),
				   ('prt','������ ������� ������ ��������','� � 25688','info@ecte.com',4,'����� ������� ���� 66','����',0.22),
				   ('ad','���� ������� ������� ��������','� � 65468435','send@matrix.com',3,'������� ������ ���� 15 ����� 6','����',NULL);

INSERT INTO Agent (usrID,[password],[name],NID,gender,mobile,birthDate,email,cityID,localAdd) 
			VALUES ('Abdallah','5555','��� ���� ���� �����','28910215465884',0,'01222365485','1989-10-01','comofcom@gmail.com',3,'��� 7 ����� 9 ���� ������ - �� �������'),
				   ('Hazem','2222','���� ����','28911111165884',0,'01222745485','1989-9-15','hazem@gmail.com',3,' ��� 203 ����� �������� - �� �������'),
				   ('Abdelaal','1111','���� ��� ����� ����','28910217894384',0,'01236575485','1984-6-3','abdelaal@gmail.com',3,'�� ������� - ����� ������'),
				   ('Mas3oud','0000','���� �����','23560012123241',0,'01285463215','2001-7-4','mas3oud@gmail.com',3,' ��� 3 ���� 5 ���� ������� ������');
INSERT INTO Advertisement (companyID,info,designCost) 
			VALUES (NULL,'����� ��� �������� 1',450),
				   (NULL,'����� ��� �������� - ���� ���',800),
				   (7,'����� ������ ���������� ��� 7',1570.0),
				   (7,'������� �������',950.0),
				   (NULL,'����� ��� - ��� ����� ',13200.0),
				   (7,'Matrix co. demo',300.0),
				   (NULL,'��������� + ���� �������',795.0),
				   (7,'����� ���� ��� 2020',3500.0);
INSERT INTO Guide (rate,specialty,[name],NID,gender,mobile,birthDate,email,cityID,localAdd)
			VALUES(250.0,'������','���� ��� ��� ������','28563214976425',0,'01165232547','1990-5-16','ahmedhassan12@yahoo.com',3,'16 ���� ������� ��������'),
				  (300.0,'����� ������','���� ���� ����','29856987542136',0,'01256365874','1989-12-1','kareemahmed@gmail.com',2,'���� ����� ������ ���� ������'),
				  (350.0,'����� ������','��� ������ ��� ����� ��� ������','28967458965478',0,'01125475412','1987-3-22','abdelsalaam@yahoo.com',5,'��� 15 ���� 7 �� ���'),
				  (200.0,'������','���� ��������� �����','23625014563298',0,'01023548769','1985-5-26','elsayedm@msn.com',3,'��� ��� ������ ���� ������'),
				  (600.0,'��� ������','����� ���� ��� ������','20368565892544',0,'01063254784','2001-10-24',NULL,7,'23 ���� ����� ���� ������'),
				  (450.0,'������� ����','���� ����� ���','29657484563201',0,'01256385520','1999-11-23','waeell@gmail.com',10,'33 ���� �����'),
				  (750.0,'�����','���� ��� ������ ������','36559621478541',0,'01125463254','2005-8-18','abbas2011@icloud.com',22,'404 ����� ������'),
				  (290.0,'����� ������','����� ����� ����','36598562147410',0,'01025469654','2004-6-19','farouk@yahoo.com',5,'����� ���� ������ - ��� ���'),
				  (450.0,'�����','���� ����� ����','26593001458691',0,'01232541253','1998-5-19','a_mlion@gmail.com',19,'17 ���� ����� ������ 13 ����');
INSERT INTO Hostel (ownerID,[name],[type],cityID,localAdd,capacity,hotelDegree,cost)
			VALUES  (4,'���� �������','����',3,'�������',200,7,2400.0),
					(3,'���� �����','����',4,'������ ����� - �����',200,5,1400.0),
					(NULL,'������� ������','�������',6,'��� 14 ���� ����� ����',50,2,150.0),
					(NULL,'����� �����','��� ������',2,'����� ������',50,2,100.0),
					(3,'������� ���� ������','�����',9,'��� 17 ���� ������',44,3,190.0),
					(3,'��� �������','��� ������',20,'���� ������� - ������ �������',25,3,300.0),
					(4,'���� ����� �����','����',17,'��� 22 ���� �����',130,3,250.0);
INSERT INTO Place ([type],[name],cityID,capacity,cost)
			VALUES('����','���� �������',9,300,25.0),
				  ('���� ������','���� �������',19,150,50.0),
				  ('����','���� ���� ���',4,200,30.0),
				  ('����','���� ������',3,220,25.0),
				  ('���','��� ����',5,25,75.0),
				  ('����','������ ������',4,700,125.0),
				  ('Planetarium','����� ��������',3,100,30.0);
INSERT INTO Travel (title,startDate,endDate,price)
			VALUES ('���� ��� ����� ����������','2021-07-11','2021-07-12',1200.0),
				   ('���� ��� �������� ���� 3 ����','2021-08-15','2021-08-18',5200.0);
INSERT INTO Transport ([type],panelNo,model,capacity,cityID,cost)
			VALUES	  ('�������','� � � 3 4 5','�������� 2005',50,7,300),
					  ('�������','� � � 2 3 5','������ 2017',70,3,900),
					  ('���� ���','���� ������ - 458674','��������� 2014',30,15,200.0),
					  ('�����','� � � 3 6 8','���� 2005',7,9,70.0),
					  ('�������','� � � 4 5 ','���� 2019',14,3,500.0),
					  ('���� ������',NULL,NULL,25,4,700.0);
INSERT INTO Tourist (prtID ,info,balance,[name],NID,gender,mobile,birthDate,email,cityID,localAdd)
			VALUES	(NULL,NULL,3000.0,' ���� ���� �����','25636586547521',0,'01125632512','2000-6-14',NULL,3,'��� 13 ����� ������ ��� ���� �����'),
					(5,NULL,2300.0,'���� ����� ����','25658541230125',0,'01144587541','2001-7-16',NULL,3,'��� 208 ���� ������ �� �������'),
					(5,NULL,3700.0,'����� ���� �����','20114857965412',0,'01253621421','2000-9-28',NULL,3,'��� 22 ��� ���� ��������'),
					(5,NULL,1000.0,'������� ���� ����','23365652214875',0,'01123665412','2005-3-2','famaoljf@gbft.com',3,'���� 5 ��� 14 ����� 7 ������ ������'),
					(NULL,NULL,5000.0,'���� ���� �����','22012255874698',0,'01023201254','2003-3-3',NULL,4,'��� 18 ���� ������ ���� �� �������'),
					(NULL,NULL,1000.0,'����� ����� ��� ������','20120165478965',0,'01025486594','2001-8-17',NULL,4,'���� 9 ���� ���� ����� ������'),
					(6,NULL,1000.0,'��� ���� ����','32652141021254',0,'01125463254','1999-5-17',NULL,3,'��� 44 �� ������ ����� ��� 10'),
					(5,NULL,2400.0,'���� ���� ����','33625145879521',0,'01121154254','1998-11-8',NULL,3,'���� �������� ����� �����'),
					(6,NULL,700.0,'���� ����� ��� ����','20069987741251',0,'01115362112','2005-7-13',NULL,4,'����� ���� ������� ����������� �� �������'),
					(6,NULL,1300.0,'���� ���� �����','23311199885541',0,'01002255544','2002-7-14','muyymaij@gmail.com',3,'��� 12 ����� ������ ����� �����'),
					(6,NULL,900.0,'���� ���� ����','20784585974568',0,'01021236543','2001-12-6','nmarmmaermt@yahoo.com',3,'��� ���� ������ ���� 4 ����� ������'),
					(6,NULL,2000.0,'���� ���� ����','35410012141259',0,'01111566858','1999-10-2',NULL,4,'��� ����� ���� ��� ������� ����� 6'),
					(NULL,NULL,500.0,'����� ��� ����','32226598745213',0,'01212333666','2005-8-20',NULL,4,'����� 23 ���� ���� �����'),
					(NULL,NULL,900.0,'����� ��� ������ ����','32558745651245',0,'01285469855','2002-7-23',NULL,3,'���� 56 ����� 6 �� 11'),
					(6,NULL,1700.0,'���� ���� ����','26510014121321',0,'01263611110','2000-9-17',NULL,3,'��� 7 ���� ���� ����� ���� ���� ������');

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
					 (1,3,'����� �������',NULL,NULL,'2021-7-13','2021-7-13',1200.0),
					 (2,1,'Facebook',7000,6000,'2021-8-1','2021-8-7',150.0),
					 (2,1,'Youtube',6000,4000,'2021-8-2','2021-8-5',100.0),
					 (1,3,'instagram',17000,1500,'2021-8-13','2021-8-23',600.0);

-- new tourist
INSERT INTO Tourist (prtID ,info,balance,[name],NID,gender,mobile,birthDate,email,cityID,localAdd)
					VALUES			(6,NULL,1200.0,'��� ���� ����','26510010021321',0,'01263001110','2000-9-17',NULL,3,'��� 7 ���� ���� ����� ���� ���� ������');
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


