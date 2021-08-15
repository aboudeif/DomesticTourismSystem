
-- ������ ��� �������
SELECT count(id) FROM Travel;

-- TRAVEL IDs
SELECT id FROM Travel;

-- ����� ������
DECLARE  @id AS INT = 2
SELECT (@id) AS id
,(SELECT title FROM Travel WHERE id = @id) AS title
-- ����� �������
,(SELECT creatDate FROM Travel WHERE id = @id) AS creatDate

-- ������
,(SELECT idle FROM Travel WHERE id = @id) AS idle

-- ����� ����� ������
,(SELECT startDate FROM Travel WHERE id = @id) AS startDate

-- ����� ����� ������
,(SELECT endDate FROM Travel WHERE id = @id) AS endDate

-- ��� ���� ������
,(SELECT DATEDIFF(DAY, (SELECT startDate FROM Travel WHERE id = @id) ,(SELECT endDate FROM Travel WHERE id = @id))) AS dayNum


-- ��� ������ �����
,(SELECT price FROM Travel WHERE id = @id) AS price

-- ������ ��� ������ ���������
,(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = @id) AS turNum

--������ ��� ����� ����� ��������
,(SELECT COUNT(trvID) FROM RegTransport WHERE trvID = @id) AS trsNum

-- ������� ��������� ������ ����� ��������
,(SELECT SUM(totalCost) FROM RegTransport WHERE trvID = @id) AS trsCost

-- ������ ��� ����� ������� ��������
,(SELECT COUNT(trvID) FROM RegHostel WHERE trvID = @id) AS hstNum

-- ������� ��������� ������ ������� ��������
,(SELECT SUM(totalCost) FROM RegHostel WHERE trvID = @id) AS hstCost

-- ������ ��� �������� ��������
,(SELECT COUNT(trvID) FROM RegGuide WHERE trvID = @id) AS gudNum

-- ������� ��������� �������� �������� ���������
,(SELECT SUM(totalCost) FROM RegGuide WHERE trvID = @id) AS gudCost

-- ������ ��� ������� �������� ������� 
,(SELECT COUNT(trvID) FROM RegPlace WHERE trvID = @id) AS plcNum

-- ������� ��������� ������ ������� ��������
,(SELECT (SELECT SUM(totalCost) FROM RegPlace WHERE trvID = @id)*
(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = @id)) AS plcCost


-- ������ ��� ��������� �������� 
,(SELECT COUNT(trvID) FROM Campaign WHERE trvID = @id) AS adNum

-- ������� ��������� ��������� ��������
,(SELECT SUM(cost) FROM Campaign WHERE trvID = @id) AS adCost

-- ������ ������ ������
,(SELECT SUM(actualProfit) FROM RegTourist WHERE trvID = @id) AS trvProfit


-- ������ ����� ������

,(SELECT (SELECT SUM(totalCost) FROM RegTransport WHERE trvID = @id) +
						  (SELECT SUM(totalCost) FROM RegHostel WHERE trvID = @id) +
						  ((SELECT SUM(totalCost) FROM RegPlace WHERE trvID = @id)*
						  (SELECT COUNT(trvID) FROM RegTourist WHERE trvID = @id)) +
						  (SELECT SUM(totalCost) FROM RegGuide WHERE trvID = @id) +
						  (SELECT SUM(cost) FROM Campaign WHERE trvID = @id)) AS trvCost


-- ���� ��� ������
-- DECLARE  @trvid AS int = @id
,(SELECT (SELECT SUM(actualProfit) FROM RegTourist WHERE trvID = @id)-
							   ((SELECT SUM(totalCost) FROM RegTransport WHERE trvID = @id)+
							   (SELECT SUM(totalCost) FROM RegHostel WHERE trvID = @id) +
							   ((SELECT SUM(totalCost) FROM RegPlace WHERE trvID = @id)*
							   (SELECT COUNT(trvID) FROM RegTourist WHERE trvID = @id))+
							   (SELECT SUM(totalCost) FROM RegGuide WHERE trvID = @id) +
							   (SELECT SUM(cost) FROM Campaign WHERE trvID = @id))) AS trvNetProfit;





