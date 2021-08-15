
-- ≈Ã„«·Ì ⁄œœ «·—Õ·« 
SELECT count(id) FROM Travel;

-- TRAVEL IDs
SELECT id FROM Travel;

-- ⁄‰Ê«‰ «·—Õ·…
DECLARE  @id AS INT = 2
SELECT (@id) AS id
,(SELECT title FROM Travel WHERE id = @id) AS title
--  «—ÌŒ «·≈‰‘«¡
,(SELECT creatDate FROM Travel WHERE id = @id) AS creatDate

-- «·Õ«·…
,(SELECT idle FROM Travel WHERE id = @id) AS idle

--  «—ÌŒ »œ«Ì… «·—Õ·…
,(SELECT startDate FROM Travel WHERE id = @id) AS startDate

--  «—ÌŒ ‰Â«Ì… «·—Õ·…
,(SELECT endDate FROM Travel WHERE id = @id) AS endDate

-- ⁄œœ √Ì«„ «·—Õ·…
,(SELECT DATEDIFF(DAY, (SELECT startDate FROM Travel WHERE id = @id) ,(SELECT endDate FROM Travel WHERE id = @id))) AS dayNum


-- ”⁄— «·—Õ·… ··›—œ
,(SELECT price FROM Travel WHERE id = @id) AS price

-- ≈Ã„«·Ì ⁄œœ «·”Ì«Õ «·„‘ —ﬂÌ‰
,(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = @id) AS turNum

--≈Ã„«·Ì ⁄œœ Ê”«∆· «·‰ﬁ· «·„‘«—ﬂ…
,(SELECT COUNT(trvID) FROM RegTransport WHERE trvID = @id) AS trsNum

-- «· ﬂ·›… «·≈Ã„«·Ì… ·Ê”«∆· «·‰ﬁ· «·„‘«—ﬂ…
,(SELECT SUM(totalCost) FROM RegTransport WHERE trvID = @id) AS trsCost

-- ≈Ã„«·Ì ⁄œœ √„«ﬂ‰ «·≈ﬁ«„… «·„ÕÃÊ“…
,(SELECT COUNT(trvID) FROM RegHostel WHERE trvID = @id) AS hstNum

-- «· ﬂ·›… «·≈Ã„«·Ì… ·√„«ﬂ‰ «·≈ﬁ«„… «·„ÕÃÊ“…
,(SELECT SUM(totalCost) FROM RegHostel WHERE trvID = @id) AS hstCost

-- ≈Ã„«·Ì ⁄œœ «·„—‘œÌ‰ «·”Ì«ÕÌ‰
,(SELECT COUNT(trvID) FROM RegGuide WHERE trvID = @id) AS gudNum

-- «· ﬂ·›… «·≈Ã„«·Ì… ··„—‘œÌ‰ «·”Ì«ÕÌ‰ «·„‘«—ﬂÌ‰
,(SELECT SUM(totalCost) FROM RegGuide WHERE trvID = @id) AS gudCost

-- ≈Ã„«·Ì ⁄œœ «·√„«ﬂ‰ «·”Ì«ÕÌ… «·„”Ã·… 
,(SELECT COUNT(trvID) FROM RegPlace WHERE trvID = @id) AS plcNum

-- «· ﬂ·›… «·≈Ã„«·Ì… ·“Ì«—… ··√„«ﬂ‰ «·”Ì«ÕÌ…
,(SELECT (SELECT SUM(totalCost) FROM RegPlace WHERE trvID = @id)*
(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = @id)) AS plcCost


-- ≈Ã„«·Ì ⁄œœ «·√⁄·«‰«  «·„‰‘Ê—… 
,(SELECT COUNT(trvID) FROM Campaign WHERE trvID = @id) AS adNum

-- «· ﬂ·›… «·≈Ã„«·Ì… ··√⁄·«‰«  «·„‰‘Ê—…
,(SELECT SUM(cost) FROM Campaign WHERE trvID = @id) AS adCost

-- ≈Ã„«·Ì ⁄«∆œ«  «·—Õ·…
,(SELECT SUM(actualProfit) FROM RegTourist WHERE trvID = @id) AS trvProfit


-- ≈Ã„«·Ì  ﬂ·›… «·—Õ·…

,(SELECT (SELECT SUM(totalCost) FROM RegTransport WHERE trvID = @id) +
						  (SELECT SUM(totalCost) FROM RegHostel WHERE trvID = @id) +
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





