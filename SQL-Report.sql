
-- ≈Ã„«·Ì ⁄œœ «·—Õ·« 
SELECT count(id) FROM Travel;

-- TRAVEL IDs
SELECT id FROM Travel;

-- ⁄‰Ê«‰ «·—Õ·…
<<<<<<< HEAD
SELECT title FROM Travel WHERE id = 2;

=======
DECLARE  @id AS INT = 2
SELECT (@id) AS id
,(SELECT title FROM Travel WHERE id = @id) AS title
>>>>>>> 6c293dbeda4c499650e60a29076f333119c87823
--  «—ÌŒ «·≈‰‘«¡
,(SELECT creatDate FROM Travel WHERE id = @id) AS creatDate

-- «·Õ«·…
,(SELECT idle FROM Travel WHERE id = @id) AS idle

--  «—ÌŒ »œ«Ì… «·—Õ·…
,(SELECT startDate FROM Travel WHERE id = @id) AS startDate

--  «—ÌŒ ‰Â«Ì… «·—Õ·…
,(SELECT endDate FROM Travel WHERE id = @id) AS endDate

-- ⁄œœ √Ì«„ «·—Õ·…
<<<<<<< HEAD
SELECT DATEDIFF(DAY, (SELECT startDate FROM Travel WHERE id = 2) ,(SELECT endDate FROM Travel WHERE id = 2)) as 'NumOfDays'
=======
,(SELECT DATEDIFF(DAY, (SELECT startDate FROM Travel WHERE id = @id) ,(SELECT endDate FROM Travel WHERE id = @id))) AS dayNum
>>>>>>> 6c293dbeda4c499650e60a29076f333119c87823


-- ”⁄— «·—Õ·… ··›—œ
,(SELECT price FROM Travel WHERE id = @id) AS price

-- ≈Ã„«·Ì ⁄œœ «·”Ì«Õ «·„‘ —ﬂÌ‰
<<<<<<< HEAD
SELECT COUNT(trvID) as 'count' FROM RegTourist WHERE trvID = 2;

--≈Ã„«·Ì ⁄œœ Ê”«∆· «·‰ﬁ· «·„‘«—ﬂ…
SELECT COUNT(totalCost) as 'count' FROM RegTransport WHERE trvID = 2;

-- «· ﬂ·›… «·≈Ã„«·Ì… ·Ê”«∆· «·‰ﬁ· «·„‘«—ﬂ…
SELECT SUM(totalCost) 'cost' FROM RegTransport WHERE trvID = 2;

-- ≈Ã„«·Ì ⁄œœ √„«ﬂ‰ «·≈ﬁ«„… «·„ÕÃÊ“…
SELECT COUNT(trvID) 'count' FROM RegHostel WHERE trvID = 2;
=======
,(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = @id) AS turNum

--≈Ã„«·Ì ⁄œœ Ê”«∆· «·‰ﬁ· «·„‘«—ﬂ…
,(SELECT COUNT(trvID) FROM RegTransport WHERE trvID = @id) AS trsNum

-- «· ﬂ·›… «·≈Ã„«·Ì… ·Ê”«∆· «·‰ﬁ· «·„‘«—ﬂ…
,(SELECT SUM(totalCost) FROM RegTransport WHERE trvID = @id) AS trsCost

-- ≈Ã„«·Ì ⁄œœ √„«ﬂ‰ «·≈ﬁ«„… «·„ÕÃÊ“…
,(SELECT COUNT(trvID) FROM RegHostel WHERE trvID = @id) AS hstNum
>>>>>>> 6c293dbeda4c499650e60a29076f333119c87823

-- «· ﬂ·›… «·≈Ã„«·Ì… ·√„«ﬂ‰ «·≈ﬁ«„… «·„ÕÃÊ“…
,(SELECT SUM(totalCost) FROM RegHostel WHERE trvID = @id) AS hstCost

-- ≈Ã„«·Ì ⁄œœ «·„—‘œÌ‰ «·”Ì«ÕÌ‰
,(SELECT COUNT(trvID) FROM RegGuide WHERE trvID = @id) AS gudNum

-- «· ﬂ·›… «·≈Ã„«·Ì… ··„—‘œÌ‰ «·”Ì«ÕÌ‰ «·„‘«—ﬂÌ‰
,(SELECT SUM(totalCost) FROM RegGuide WHERE trvID = @id) AS gudCost

-- ≈Ã„«·Ì ⁄œœ «·√„«ﬂ‰ «·”Ì«ÕÌ… «·„”Ã·… 
,(SELECT COUNT(trvID) FROM RegPlace WHERE trvID = @id) AS plcNum

-- «· ﬂ·›… «·≈Ã„«·Ì… ·“Ì«—… ··√„«ﬂ‰ «·”Ì«ÕÌ…
<<<<<<< HEAD
SELECT (SELECT SUM(cost) FROM Place WHERE id in (SELECT plcID FROM RegPlace WHERE trvID = 2))*
(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = 2) 'cost';


-- ≈Ã„«·Ì ⁄œœ «·√⁄·«‰«  «·„‰‘Ê—… 
SELECT COUNT(trvID) 'count' FROM Campaign WHERE trvID = 2;

-- «· ﬂ·›… «·≈Ã„«·Ì… ··√⁄·«‰«  «·„‰‘Ê—…
SELECT SUM(cost) 'cost' FROM Campaign WHERE trvID = 2;

-- ≈Ã„«·Ì ⁄«∆œ«  «·—Õ·…
SELECT SUM(actualProfit) 'profit' FROM RegTourist WHERE trvID = 2;
=======
,(SELECT (SELECT SUM(totalCost) FROM RegPlace WHERE trvID = @id)*
(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = @id)) AS plcCost


-- ≈Ã„«·Ì ⁄œœ «·√⁄·«‰«  «·„‰‘Ê—… 
,(SELECT COUNT(trvID) FROM Campaign WHERE trvID = @id) AS adNum

-- «· ﬂ·›… «·≈Ã„«·Ì… ··√⁄·«‰«  «·„‰‘Ê—…
,(SELECT SUM(cost) FROM Campaign WHERE trvID = @id) AS adCost

-- ≈Ã„«·Ì ⁄«∆œ«  «·—Õ·…
,(SELECT SUM(actualProfit) FROM RegTourist WHERE trvID = @id) AS trvProfit
>>>>>>> 6c293dbeda4c499650e60a29076f333119c87823


-- ≈Ã„«·Ì  ﬂ·›… «·—Õ·…

,(SELECT (SELECT SUM(totalCost) FROM RegTransport WHERE trvID = @id) +
						  (SELECT SUM(totalCost) FROM RegHostel WHERE trvID = @id) +
<<<<<<< HEAD
						  ((SELECT SUM(cost) FROM Place WHERE id in (SELECT plcID FROM RegPlace WHERE trvID = @id))*
						  (SELECT COUNT(trvID) FROM RegTourist WHERE trvID = @id)) +
						  (SELECT SUM(totalCost) FROM RegGuide WHERE trvID = @id) +
						  (SELECT SUM(cost) FROM Campaign WHERE trvID = @id)
SELECT @cost 'totalcost';

-- ’«›Ì —»Õ «·—Õ·…
DECLARE  @trvid AS int = 2
DECLARE  @trvprofit AS MONEY = (SELECT SUM(actualProfit) FROM RegTourist WHERE trvID = @trvid)-
							   ((SELECT SUM(totalCost) FROM RegTransport WHERE trvID = @trvid)+
							   (SELECT SUM(totalCost) FROM RegHostel WHERE trvID = @trvid) +
							   ((SELECT SUM(cost) FROM Place WHERE id in (SELECT plcID FROM RegPlace WHERE trvID = @trvid))*
							   (SELECT COUNT(trvID) FROM RegTourist WHERE trvID = @trvid))+
							   (SELECT SUM(totalCost) FROM RegGuide WHERE trvID = @trvid) +
							   (SELECT SUM(cost) FROM Campaign WHERE trvID = @trvid))
SELECT @trvprofit 'totalprofit';
=======
						  ((SELECT SUM(totalCost) FROM RegPlace WHERE trvID = @id)*
						  (SELECT COUNT(trvID) FROM RegTourist WHERE trvID = @id)) +
						  (SELECT SUM(totalCost) FROM RegGuide WHERE trvID = @id) +
						  (SELECT SUM(cost) FROM Campaign WHERE trvID = @id)) AS trvCost


-- ’«›Ì —»Õ «·—Õ·…
-- DECLARE  @trvid AS int = @id
,(SELECT (SELECT SUM(actualProfit) FROM RegTourist WHERE trvID = @id)-
							   ((SELECT SUM(totalCost) FROM RegTransport WHERE trvID = @id)+
							   (SELECT SUM(totalCost) FROM RegHostel WHERE trvID = @id) +
							   ((SELECT SUM(totalCost) FROM RegPlace WHERE trvID = @id)*
							   (SELECT COUNT(trvID) FROM RegTourist WHERE trvID = @id))+
							   (SELECT SUM(totalCost) FROM RegGuide WHERE trvID = @id) +
							   (SELECT SUM(cost) FROM Campaign WHERE trvID = @id))) AS trvNetProfit;



>>>>>>> 6c293dbeda4c499650e60a29076f333119c87823


