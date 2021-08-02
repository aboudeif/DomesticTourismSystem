
USE [DTSDB]

INSERT INTO CIty (city) 
			VALUES  ('√”Ê«‰'),
					('√”ÌÊÿ'),
					('«·√”ﬂ‰œ—Ì…'),
					('«·≈”„«⁄Ì·Ì…'),
					('«·√ﬁ’—'),
					('«·»Õ— «·√Õ„—'),
					('«·»ÕÌ—…'),
					('«·ÃÌ“…'),
					('«·œﬁÂ·Ì…'),
					('«·”ÊÌ”'),
					('«·‘—ﬁÌ…'),
					('«·€—»Ì…'),
					('«·ﬁ«Â—…'),
					('«·ﬁ·ÌÊ»Ì…'),
					('«·„‰Ê›Ì…'),
					('«·„‰Ì«'),
					('«·Ê«œÌ «·ÃœÌœ'),
					('»‰Ì ”ÊÌ›'),
					('»Ê—”⁄Ìœ'),
					('Ã‰Ê» ”Ì‰«¡'),
					('”ÊÂ«Ã'),
					('‘„«· ”Ì‰«¡'),
					('„ÿ—ÊÕ'),
					('œ„Ì«ÿ');
INSERT INTO ServiceProvider (class,[name],CRN,email,cityID,localAdd,[type],discount)
			VALUES ('trs','‘—ﬂ…«·‰ﬁ· «·”Ì«ÕÌ','”   5668','info@turtravel.com',3,'„»‰Ì 5 ‘«—⁄ «·√”Ê«—','‘—ﬂ…',NULL),
				   ('trs','‘—ﬂ… «·”›— «·”—Ì⁄','”   46464354','partner@fast-travel.com',4,'—ﬁ„ 3 «·œÊ— 3 «·„Ìœ«‰ «·ÃœÌœ','‘—ﬂ…',NULL),
				   ('hst','„ﬂ » «·Õ«Ã √»Ê Ã⁄›— ··⁄ﬁ«—« ','”   1312545875','abougaffar@gmail.com',17,'„»‰Ì 5 «·ÿ—Ìﬁ «·“—«⁄Ì ﬁ—Ì… √»Ê «·”»«⁄','„ﬂ » ⁄ﬁ«—Ì',NULL),
				   ('hst','‘—ﬂ… «·›‰«œﬁ «·⁄«·„Ì…','”   10158655','info@interhotel.com',3,'—ﬁ„ 13 „Ìœ«‰ «·‰’—','‘—ﬂ…',NULL),
				   ('prt','„ƒ””… «·‘—ﬁ','”   165484326959','info@est.com',3,'„»‰Ì 5 «·œÊ— 9 «·ÿ—Ìﬁ «·”—Ì⁄','„ƒ””…',0.30),
				   ('prt','«·‘—ﬂ… «·„’—Ì… · Ê“Ì⁄ «·ﬂÂ—»«¡','”   25688','info@ecte.com',4,'„Ìœ«‰ «·⁄«’„… „»‰Ì 66','‘—ﬂ…',0.22),
				   ('ad','‘—ﬂ… „« —Ìﬂ” ··œ⁄«Ì… Ê«·≈⁄·«‰','”   65468435','send@matrix.com',3,'«·„‰ÿﬁ… «·√Ê·Ì „»‰Ì 15 «·œÊ— 6','‘—ﬂ…',NULL);

INSERT INTO Agent (usrID,[password],[name],NID,gender,mobile,birthDate,email,cityID,localAdd) 
			VALUES ('Abdallah','5555','⁄»œ «··Â „Õ„œ «·”Ìœ','28910215465884',0,'01222365485','1989-10-01','comofcom@gmail.com',3,'‘ﬁ… 7 ⁄„«—… 9 ‘«—⁄ «·Ã·«¡ - ÕÌ «·„‰ “Â'),
				   ('Hazem','2222','Õ«“„ Õ„«œ','28911111165884',0,'01222745485','1989-9-15','hazem@gmail.com',3,' ‘ﬁ… 203 „Ìœ«‰ ›Ìﬂ Ê—Ì« - ÕÌ «·„‰ “Â'),
				   ('Abdelaal','1111','„Õ„œ ⁄»œ «·⁄«· „Õ„œ','28910217894384',0,'01236575485','1984-6-3','abdelaal@gmail.com',3,'ÕÌ «·»” «‰ - „œÌ‰… «·“ÂÊ—'),
				   ('Mas3oud','0000','„Õ„œ „”⁄Êœ','23560012123241',0,'01285463215','2001-7-4','mas3oud@gmail.com',3,' —ﬁ„ 3 ÿ—Ìﬁ 5 «·ÕÌ «·≈œ«—Ì «·À«‰Ì');
INSERT INTO Advertisement (companyID,info,designCost) 
			VALUES (NULL,'≈⁄·«‰ ‘—„ Ê«·€—œﬁ… 1',450),
				   (NULL,'≈⁄·«‰ ‘—„ Ê«·€—œﬁ… - „Õ„œ ⁄·Ì',800),
				   (7,'≈⁄·«‰ ﬁÌ »«Ì Ê√‰ÿÊ‰Ì«œ” ‘Â— 7',1570.0),
				   (7,'«·≈⁄·«‰ «·√”«”Ì',950.0),
				   (NULL,'≈⁄·«‰ ⁄«„ - Õ”‰ —„÷«‰ ',13200.0),
				   (7,'Matrix co. demo',300.0),
				   (NULL,'«·√Â—«„«  + ›‰œﬁ ‘Ì—« Ê‰',795.0),
				   (7,'≈⁄·«‰ „Ìﬂ” ’Ì› 2020',3500.0);
INSERT INTO Guide (rate,specialty,[name],NID,gender,mobile,birthDate,email,cityID,localAdd)
			VALUES(250.0,' —›ÌÂÌ','√Õ„œ Õ”‰ ⁄»œ «·—Õ„‰','28563214976425',0,'01165232547','1990-5-16','ahmedhassan12@yahoo.com',3,'16 ‘«—⁄ «·„‰‘Ì… «·⁄ÿ«—Ì‰'),
				  (300.0,' «—ÌŒ ›—⁄Ê‰Ì','ﬂ—Ì„ √Õ„œ „Õ„œ','29856987542136',0,'01256365874','1989-12-1','kareemahmed@gmail.com',2,'ﬁ—Ì… «·‰”— «·√Œ÷— ÿ—Ìﬁ «·”»«⁄'),
				  (350.0,' «—ÌŒ ≈”·«„Ì','⁄»œ «·”·«„ ⁄»œ «·’„œ ⁄»œ «·”·«„','28967458965478',0,'01125475412','1987-3-22','abdelsalaam@yahoo.com',5,'‘ﬁ… 15 »·Êﬂ 7 ÕÌ √Ê·'),
				  (200.0,'„Õ„Ì« ','„ƒ„‰ ⁄»œ«·—ƒÊ› „Õ„Êœ','23625014563298',0,'01023548769','1985-5-26','elsayedm@msn.com',3,'√Ê· ‰›ﬁ «·„—Ê— ‘«—⁄ «·⁄ﬁ—»'),
				  (600.0,'€Ê’ Ê”Ê«Õ·','«·”Ìœ √Õ„œ ⁄»œ «·” «—','20368565892544',0,'01063254784','2001-10-24',NULL,7,'23 ‘«—⁄ «·‘ÌŒ „—ﬂ“ ﬁÊÌ”‰«'),
				  (450.0,'ÕÌÊ«‰«  »—Ì…','Ê«∆· „Õ„Êœ Õ”‰','29657484563201',0,'01256385520','1999-11-23','waeell@gmail.com',10,'33 ‘«—⁄ «·‰Ì·'),
				  (750.0,'’Õ«—Ì','⁄»«” ⁄»œ «·—ÕÌ„ «·Ã‰œÌ','36559621478541',0,'01125463254','2005-8-18','abbas2011@icloud.com',22,'404 „Ìœ«‰ «·‰‘«—'),
				  (290.0,' «—ÌŒ ›—⁄Ê‰Ì','›«—Êﬁ „Õ„Êœ ﬂ„«·','36598562147410',0,'01025469654','2004-6-19','farouk@yahoo.com',5,'‰«’Ì… ‘«—⁄ «··»«‰ - „Ì  ‰’—'),
				  (450.0,'—Ì«÷Ì','√Õ„œ „Õ„Êœ Õ«„œ','26593001458691',0,'01232541253','1998-5-19','a_mlion@gmail.com',19,'17 ÿ—Ìﬁ «·»Õ— «·ﬂÌ·Ê 13 Ì„Ì‰');
INSERT INTO Hostel (ownerID,[name],[type],cityID,localAdd,capacity,hotelDegree,cost)
			VALUES  (4,'›‰œﬁ ‘Ì—« Ê‰','›‰œﬁ',3,'«·„‰ “Â',200,7,2400.0),
					(3,'›‰œﬁ —„”Ì”','›‰œﬁ',4,'ﬂÊ—‰Ì‘ «·‰Ì· - —„”Ì”',200,5,1400.0),
					(NULL,'·Êﬂ«‰œ… «·»«‘«','·Êﬂ«‰œ…',6,'—ﬁ„ 14 ‘«—⁄ «·Õ«Ã ⁄—›…',50,2,150.0),
					(NULL,'√»—«Ã «·‘„”','‘ﬁ… „›—Ê‘…',2,'„Ìœ«‰ «·„‰Õ·',50,2,100.0),
					(3,'‘«·ÌÂ«  ﬁ—Ì… «·€“«·','‘«·ÌÂ',9,'—ﬁ„ 17 ﬁ—Ì… «·€“«·',44,3,190.0),
					(3,'‘ﬁﬁ «·Ì«ﬁÊ ','‘ﬁﬁ ›‰œﬁÌ…',20,'‘«—⁄ «·„œ—”… - ⁄„«—«  «·Ì«ﬁÊ ',25,3,300.0),
					(4,'›‰œﬁ «·‘ÌŒ Õ”‰Ì‰','›‰œﬁ',17,'—ﬁ„ 22 ‘«—⁄ «·»Õ—',130,3,250.0);
INSERT INTO Place ([type],[name],cityID,capacity,cost)
			VALUES('‘«ÿ∆','‘«ÿ∆ «·”⁄«œ…',9,300,25.0),
				  ('„⁄»œ ›—⁄Ê‰Ì','„⁄»œ √»Ê”„»·',19,150,50.0),
				  ('„”Ãœ','„”Ãœ „Õ„œ ⁄·Ì',4,200,30.0),
				  ('ﬁ·⁄…','ﬁ·⁄… ﬁÌ »«Ì',3,220,25.0),
				  ('Â—„','Â—„ ŒÊ›Ê',5,25,75.0),
				  ('„ Õ›','«·„ Õ› «·ﬁÊ„Ì',4,700,125.0),
				  ('Planetarium','«·ﬁ»… «·”„«ÊÌ…',3,100,30.0);
INSERT INTO Travel (title,startDate,endDate,price)
			VALUES ('—Õ·… ≈·Ì „⁄«·„ «·«”ﬂ‰œ—Ì…','2021-07-11','2021-07-12',1200.0),
				   ('—Õ·… ‘—„ Ê«·€—œﬁ… ·„œ… 3 √Ì«„','2021-08-15','2021-08-18',5200.0);
INSERT INTO Transport ([type],panelNo,model,capacity,cityID,cost)
			VALUES	  ('√Ê Ê»Ì”','” ” » 3 4 5','„Ì—”ÌœÌ” 2005',50,7,300),
					  ('√Ê Ê»Ì”','⁄ · · 2 3 5',' ÊÌÊ « 2017',70,3,900),
					  ('„Ì‰Ì »«’','√Ã—… «·ÃÌ“… - 458674','„Ì ”Ê»Ì‘Ì 2014',30,15,200.0),
					  ('”Ì«—…','’ Ì » 3 6 8','»ÌÃÊ 2005',7,9,70.0),
					  ('·Ì„Ê“Ì‰','Õ Ì · 4 5 ','√ÊœÌ 2019',14,3,500.0),
					  ('„—ﬂ» ‘—«⁄Ì…',NULL,NULL,25,4,700.0);
INSERT INTO Tourist (prtID ,info,balance,[name],NID,gender,mobile,birthDate,email,cityID,localAdd)
			VALUES	(NULL,NULL,3000.0,' „Õ„œ Õ”Ì‰ «·‘ÌŒ','25636586547521',0,'01125632512','2000-6-14',NULL,3,'—ﬁ„ 13 «·œÊ— «·À«·À Œ·› ‰«œÌ «·‰”—'),
					(5,NULL,2300.0,'⁄·«¡ «·œÌ‰ Œ«·œ','25658541230125',0,'01144587541','2001-7-16',NULL,3,'‘ﬁ… 208 ‘«—⁄ «·Ã·«¡ ÕÌ «·„‰ “Â'),
					(5,NULL,3700.0,'Õ„«œ… √Õ„œ Õ„«œ…','20114857965412',0,'01253621421','2000-9-28',NULL,3,'—ﬁ„ 22 √Ê· ‘«—⁄ «·ﬂÊ—‰Ì‘'),
					(5,NULL,1000.0,'≈”„«⁄Ì· „Õ„œ „Õ„œ','23365652214875',0,'01123665412','2005-3-2','famaoljf@gbft.com',3,'»·Êﬂ 5 ‘ﬁ… 14 „‰ÿﬁ… 7 «·ÿ—Ìﬁ «·œÊ·Ì'),
					(NULL,NULL,5000.0,'√„Ì‰ „Õ„œ „Õ„Êœ','22012255874698',0,'01023201254','2003-3-3',NULL,4,'—ﬁ„ 18 ‘«—⁄ «·„⁄·„ Ã«»— ÕÌ «·»” «‰'),
					(NULL,NULL,1000.0,'„Õ›ÊŸ Õ”‰Ì‰ ⁄»œ «·Õ„Ìœ','20120165478965',0,'01025486594','2001-8-17',NULL,4,'›Ì·« 9 ‘«—⁄ ”„Ì— „œÌ‰… «·”·«„'),
					(6,NULL,1000.0,'√œ„ › ÕÌ ”⁄Ìœ','32652141021254',0,'01125463254','1999-5-17',NULL,3,'—ﬁ„ 44 ÕÌ «·Ã„—ﬂ »ÃÊ«— »«» 10'),
					(5,NULL,2400.0,'”«„Õ €—Ì» “«Â—','33625145879521',0,'01121154254','1998-11-8',NULL,3,'‘«—⁄ «·œÊ·›Ì‰ „‰ÿﬁ… «·»Õ—'),
					(6,NULL,700.0,'ﬂ„«· «·œÌ‰ ⁄Ìœ ﬂ«„·','20069987741251',0,'01115362112','2005-7-13',NULL,4,'»ÃÊ«— „»‰Ì «·≈–«⁄… Ê«· ·Ì›“ÌÊ‰ ÕÌ «·⁄ÃÊ“…'),
					(6,NULL,1300.0,'—«‘œ „Õ„œ ‘«ÂÌ‰','23311199885541',0,'01002255544','2002-7-14','muyymaij@gmail.com',3,'—ﬁ„ 12 «·œÊ— «·”«»⁄ „Ìœ«‰ «·‘ÌŒ'),
					(6,NULL,900.0,'√Õ„œ €“«· ›«÷·','20784585974568',0,'01021236543','2001-12-6','nmarmmaermt@yahoo.com',3,'√Ê· „Õÿ… «· —«„ »·Êﬂ 4 «·œÊ— «·⁄«‘—'),
					(6,NULL,2000.0,'›«÷· √Õ„œ ﬁ«”„','35410012141259',0,'01111566858','1999-10-2',NULL,4,'»—Ã «·’ﬁ— √„«„ ‰›ﬁ «·”·ÿ«‰ «·œÊ— 6'),
					(NULL,NULL,500.0,'«·”Ìœ ›÷· ⁄ÊÌ”','32226598745213',0,'01212333666','2005-8-20',NULL,4,'⁄„«—… 23 √„«„ „Õÿ… —„”Ì”'),
					(NULL,NULL,900.0,'„—Ê«‰ ⁄»œ «·ﬁ«œ— Õ”Ì‰','32558745651245',0,'01285469855','2002-7-23',NULL,3,'‘«—⁄ 56 „‰ÿﬁ… 6 ÕÌ 11'),
					(6,NULL,1700.0,'ÌÊ”› „Õ„œ ⁄»«”','26510014121321',0,'01263611110','2000-9-17',NULL,3,'—ﬁ„ 7 ‘«—⁄ «·ÕÌ »ÃÊ«— „»‰Ì «·ÕÌ «·ﬁœÌ„');
INSERT INTO RegTransport (trvID,trsID,daysNum,totalCost)
			VALUES       (1,2,2,2*(SELECT cost FROM Transport WHERE id = 2)),
						 (1,5,1,1*(SELECT cost FROM Transport WHERE id = 5)),
						 (2,1,2,2*(SELECT cost FROM Transport WHERE id = 1)),
						 (2,3,1,1*(SELECT cost FROM Transport WHERE id = 3)),
						 (2,6,3,3*(SELECT cost FROM Transport WHERE id = 6));
INSERT INTO RegTourist (trvID,turID,actualProfit)
			VALUES	   (1,1,ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 1))*-1*(SELECT price FROM Travel WHERE id = 1),0)+(SELECT price FROM Travel WHERE id = 1)),
					   (2,10,ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 10))*-1*(SELECT price FROM Travel WHERE id = 2),0)+(SELECT price FROM Travel WHERE id = 2)),
					   (1,5,ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 5))*-1*(SELECT price FROM Travel WHERE id = 1),0)+(SELECT price FROM Travel WHERE id = 1)),
					   (1,2,ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 2))*-1*(SELECT price FROM Travel WHERE id = 1),0)+(SELECT price FROM Travel WHERE id = 1)),
					   (2,8,ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 8))*-1*(SELECT price FROM Travel WHERE id = 2),0)+(SELECT price FROM Travel WHERE id = 2)),
					   (1,3,ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 3))*-1*(SELECT price FROM Travel WHERE id = 1),0)+(SELECT price FROM Travel WHERE id = 1)),
					   (2,9,ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 9))*-1*(SELECT price FROM Travel WHERE id = 2),0)+(SELECT price FROM Travel WHERE id = 2)),
					   (1,7,ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 7))*-1*(SELECT price FROM Travel WHERE id = 1),0)+(SELECT price FROM Travel WHERE id = 1)),
					   (2,14,ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 14))*-1*(SELECT price FROM Travel WHERE id = 2),0)+(SELECT price FROM Travel WHERE id = 2)),
					   (2,15,ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 15))*-1*(SELECT price FROM Travel WHERE id = 2),0)+(SELECT price FROM Travel WHERE id = 2)),
					   (1,4,ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 4))*-1*(SELECT price FROM Travel WHERE id = 1),0)+(SELECT price FROM Travel WHERE id = 1)),
					   (1,6,ISNULL((SELECT discount FROM ServiceProvider WHERE id = (SELECT prtID FROM Tourist WHERE id = 6))*-1*(SELECT price FROM Travel WHERE id = 1),0)+(SELECT price FROM Travel WHERE id = 1));
INSERT INTO RegPlace (trvID,plcID,totalCost)
			VALUES	 (1,7,(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = 1)*(SELECT cost FROM Place WHERE id = 7)),
					 (2,2,(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = 2)*(SELECT cost FROM Place WHERE id = 2)),
					 (2,3,(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = 2)*(SELECT cost FROM Place WHERE id = 3)),
					 (1,6,(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = 1)*(SELECT cost FROM Place WHERE id = 6)),
					 (2,1,(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = 2)*(SELECT cost FROM Place WHERE id = 1));
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
					 (1,3,'Ã—Ìœ… «·√Â—«„',NULL,NULL,'2021-7-13','2021-7-13',1200.0),
					 (2,1,'Facebook',7000,6000,'2021-8-1','2021-8-7',150.0),
					 (2,1,'Youtube',6000,4000,'2021-8-2','2021-8-5',100.0),
					 (1,3,'instagram',17000,1500,'2021-8-13','2021-8-23',600.0);
