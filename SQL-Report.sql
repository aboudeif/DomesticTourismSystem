
-- ������ ��� �������
SELECT COUNT(id) FROM Travel;

-- TRAVEL IDs
SELECT id FROM Travel;

-- ����� ������
SELECT title FROM Travel WHERE id = 2;�

-- ����� �������
SELECT creatDate FROM Travel WHERE id = 2;

-- ������
SELECT idle FROM Travel WHERE id = 2;

-- ����� ����� ������
SELECT startDate FROM Travel WHERE id = 2;

-- ����� ����� ������
SELECT endDate FROM Travel WHERE id = 2;

-- ��� ���� ������
SELECT DATEDIFF(DAY, (SELECT startDate FROM Travel WHERE id = 2) ,(SELECT endDate FROM Travel WHERE id = 2))


-- ��� ������ �����
SELECT price FROM Travel WHERE id = 2;

-- ������ ��� ������ ���������
SELECT COUNT(trvID) FROM RegTourist WHERE trvID = 2;

--������ ��� ����� ����� ��������
SELECT COUNT(totalCost) FROM RegTransport WHERE trvID = 2;

-- ������� ��������� ������ ����� ��������
SELECT SUM(totalCost) FROM RegTransport WHERE trvID = 2;

-- ������ ��� ����� ������� ��������
SELECT COUNT(trvID) FROM RegHostel WHERE trvID = 2;

-- ������� ��������� ������ ������� ��������
SELECT SUM(totalCost) FROM RegHostel WHERE trvID = 2;

-- ������ ��� �������� ��������
SELECT COUNT(trvID) FROM RegGuide WHERE trvID = 2;

-- ������� ��������� �������� �������� ���������
SELECT SUM(totalCost) FROM RegGuide WHERE trvID = 2;

-- ������ ��� ������� �������� ������� 
SELECT COUNT(trvID) FROM RegPlace WHERE trvID = 2;

-- ������� ��������� ������ ������� ��������
SELECT (SELECT SUM(cost) FROM Place WHERE id in (SELECT plcID FROM RegPlace WHERE trvID = 2))*
(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = 2);


-- ������ ��� ��������� �������� 
SELECT COUNT(trvID) FROM Campaign WHERE trvID = 2;

-- ������� ��������� ��������� ��������
SELECT SUM(cost) FROM Campaign WHERE trvID = 2;

-- ������ ������ ������
SELECT SUM(actualProfit) FROM RegTourist WHERE trvID = 2


-- ������ ����� ������
DECLARE  @id AS int = 2
DECLARE  @cost AS MONEY = (SELECT SUM(totalCost) FROM RegTransport WHERE trvID = @id) +
						  (SELECT SUM(totalCost) FROM RegHostel WHERE trvID = @id) +
						  ((SELECT SUM(cost) FROM Place WHERE id in (SELECT plcID FROM RegPlace WHERE trvID = 2))*
						  (SELECT COUNT(trvID) FROM RegTourist WHERE trvID = 2)) +
						  (SELECT SUM(totalCost) FROM RegGuide WHERE trvID = @id) +
						  (SELECT SUM(cost) FROM Campaign WHERE trvID = @id)
SELECT @cost

-- ���� ��� ������
DECLARE  @trvid AS int = 2
DECLARE  @trvprofit AS MONEY = (SELECT SUM(actualProfit) FROM RegTourist WHERE trvID = @trvid)-
							   ((SELECT SUM(totalCost) FROM RegTransport WHERE trvID = @trvid)+
							   (SELECT SUM(totalCost) FROM RegHostel WHERE trvID = @trvid) +
							   ((SELECT SUM(cost) FROM Place WHERE id in (SELECT plcID FROM RegPlace WHERE trvID = 2))*
							   (SELECT COUNT(trvID) FROM RegTourist WHERE trvID = 2))+
							   (SELECT SUM(totalCost) FROM RegGuide WHERE trvID = @trvid) +
							   (SELECT SUM(cost) FROM Campaign WHERE trvID = @trvid))
SELECT @trvprofit


