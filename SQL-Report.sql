
-- ≈Ã„«·Ì ⁄œœ «·—Õ·« 
SELECT COUNT(id) FROM Travel;

-- TRAVEL IDs
SELECT id FROM Travel;

-- ⁄‰Ê«‰ «·—Õ·…
SELECT title FROM Travel WHERE id = 2;Ú

--  «—ÌŒ «·≈‰‘«¡
SELECT creatDate FROM Travel WHERE id = 2;

-- «·Õ«·…
SELECT idle FROM Travel WHERE id = 2;

--  «—ÌŒ »œ«Ì… «·—Õ·…
SELECT startDate FROM Travel WHERE id = 2;

--  «—ÌŒ ‰Â«Ì… «·—Õ·…
SELECT endDate FROM Travel WHERE id = 2;

-- ⁄œœ √Ì«„ «·—Õ·…
SELECT DATEDIFF(DAY, (SELECT startDate FROM Travel WHERE id = 2) ,(SELECT endDate FROM Travel WHERE id = 2))


-- ”⁄— «·—Õ·… ··›—œ
SELECT price FROM Travel WHERE id = 2;

-- ≈Ã„«·Ì ⁄œœ «·”Ì«Õ «·„‘ —ﬂÌ‰
SELECT COUNT(trvID) FROM RegTourist WHERE trvID = 2;

--≈Ã„«·Ì ⁄œœ Ê”«∆· «·‰ﬁ· «·„‘«—ﬂ…
SELECT COUNT(totalCost) FROM RegTransport WHERE trvID = 2;

-- «· ﬂ·›… «·≈Ã„«·Ì… ·Ê”«∆· «·‰ﬁ· «·„‘«—ﬂ…
SELECT SUM(totalCost) FROM RegTransport WHERE trvID = 2;

-- ≈Ã„«·Ì ⁄œœ √„«ﬂ‰ «·≈ﬁ«„… «·„ÕÃÊ“…
SELECT COUNT(trvID) FROM RegHostel WHERE trvID = 2;

-- «· ﬂ·›… «·≈Ã„«·Ì… ·√„«ﬂ‰ «·≈ﬁ«„… «·„ÕÃÊ“…
SELECT SUM(totalCost) FROM RegHostel WHERE trvID = 2;

-- ≈Ã„«·Ì ⁄œœ «·„—‘œÌ‰ «·”Ì«ÕÌ‰
SELECT COUNT(trvID) FROM RegGuide WHERE trvID = 2;

-- «· ﬂ·›… «·≈Ã„«·Ì… ··„—‘œÌ‰ «·”Ì«ÕÌ‰ «·„‘«—ﬂÌ‰
SELECT SUM(totalCost) FROM RegGuide WHERE trvID = 2;

-- ≈Ã„«·Ì ⁄œœ «·√„«ﬂ‰ «·”Ì«ÕÌ… «·„”Ã·… 
SELECT COUNT(trvID) FROM RegPlace WHERE trvID = 2;

-- «· ﬂ·›… «·≈Ã„«·Ì… ·“Ì«—… ··√„«ﬂ‰ «·”Ì«ÕÌ…
SELECT (SELECT SUM(cost) FROM Place WHERE id in (SELECT plcID FROM RegPlace WHERE trvID = 2))*
(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = 2);


-- ≈Ã„«·Ì ⁄œœ «·√⁄·«‰«  «·„‰‘Ê—… 
SELECT COUNT(trvID) FROM Campaign WHERE trvID = 2;

-- «· ﬂ·›… «·≈Ã„«·Ì… ··√⁄·«‰«  «·„‰‘Ê—…
SELECT SUM(cost) FROM Campaign WHERE trvID = 2;

-- ≈Ã„«·Ì ⁄«∆œ«  «·—Õ·…
SELECT SUM(actualProfit) FROM RegTourist WHERE trvID = 2


-- ≈Ã„«·Ì  ﬂ·›… «·—Õ·…
DECLARE  @id AS int = 2
DECLARE  @cost AS MONEY = (SELECT SUM(totalCost) FROM RegTransport WHERE trvID = @id) +
						  (SELECT SUM(totalCost) FROM RegHostel WHERE trvID = @id) +
						  ((SELECT SUM(cost) FROM Place WHERE id in (SELECT plcID FROM RegPlace WHERE trvID = 2))*
						  (SELECT COUNT(trvID) FROM RegTourist WHERE trvID = 2)) +
						  (SELECT SUM(totalCost) FROM RegGuide WHERE trvID = @id) +
						  (SELECT SUM(cost) FROM Campaign WHERE trvID = @id)
SELECT @cost

-- ’«›Ì —»Õ «·—Õ·…
DECLARE  @trvid AS int = 2
DECLARE  @trvprofit AS MONEY = (SELECT SUM(actualProfit) FROM RegTourist WHERE trvID = @trvid)-
							   ((SELECT SUM(totalCost) FROM RegTransport WHERE trvID = @trvid)+
							   (SELECT SUM(totalCost) FROM RegHostel WHERE trvID = @trvid) +
							   ((SELECT SUM(cost) FROM Place WHERE id in (SELECT plcID FROM RegPlace WHERE trvID = 2))*
							   (SELECT COUNT(trvID) FROM RegTourist WHERE trvID = 2))+
							   (SELECT SUM(totalCost) FROM RegGuide WHERE trvID = @trvid) +
							   (SELECT SUM(cost) FROM Campaign WHERE trvID = @trvid))
SELECT @trvprofit


