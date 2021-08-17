
-- ������ ��� �������
SELECT count(id) FROM Travel;

-- TRAVEL IDs
SELECT id FROM Travel;

-- ����� ������
<<<<<<< HEAD
SELECT title FROM Travel WHERE id = 2;

=======
DECLARE  @id AS INT = 2
SELECT (@id) AS id
,(SELECT title FROM Travel WHERE id = @id) AS title
>>>>>>> 6c293dbeda4c499650e60a29076f333119c87823
-- ����� �������
,(SELECT creatDate FROM Travel WHERE id = @id) AS creatDate

-- ������
,(SELECT idle FROM Travel WHERE id = @id) AS idle

-- ����� ����� ������
,(SELECT startDate FROM Travel WHERE id = @id) AS startDate

-- ����� ����� ������
,(SELECT endDate FROM Travel WHERE id = @id) AS endDate

-- ��� ���� ������
<<<<<<< HEAD
SELECT DATEDIFF(DAY, (SELECT startDate FROM Travel WHERE id = 2) ,(SELECT endDate FROM Travel WHERE id = 2)) as 'NumOfDays'
=======
,(SELECT DATEDIFF(DAY, (SELECT startDate FROM Travel WHERE id = @id) ,(SELECT endDate FROM Travel WHERE id = @id))) AS dayNum
>>>>>>> 6c293dbeda4c499650e60a29076f333119c87823


-- ��� ������ �����
,(SELECT price FROM Travel WHERE id = @id) AS price

-- ������ ��� ������ ���������
<<<<<<< HEAD
SELECT COUNT(trvID) as 'count' FROM RegTourist WHERE trvID = 2;

--������ ��� ����� ����� ��������
SELECT COUNT(totalCost) as 'count' FROM RegTransport WHERE trvID = 2;

-- ������� ��������� ������ ����� ��������
SELECT SUM(totalCost) 'cost' FROM RegTransport WHERE trvID = 2;

-- ������ ��� ����� ������� ��������
SELECT COUNT(trvID) 'count' FROM RegHostel WHERE trvID = 2;
=======
,(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = @id) AS turNum

--������ ��� ����� ����� ��������
,(SELECT COUNT(trvID) FROM RegTransport WHERE trvID = @id) AS trsNum

-- ������� ��������� ������ ����� ��������
,(SELECT SUM(totalCost) FROM RegTransport WHERE trvID = @id) AS trsCost

-- ������ ��� ����� ������� ��������
,(SELECT COUNT(trvID) FROM RegHostel WHERE trvID = @id) AS hstNum
>>>>>>> 6c293dbeda4c499650e60a29076f333119c87823

-- ������� ��������� ������ ������� ��������
,(SELECT SUM(totalCost) FROM RegHostel WHERE trvID = @id) AS hstCost

-- ������ ��� �������� ��������
,(SELECT COUNT(trvID) FROM RegGuide WHERE trvID = @id) AS gudNum

-- ������� ��������� �������� �������� ���������
,(SELECT SUM(totalCost) FROM RegGuide WHERE trvID = @id) AS gudCost

-- ������ ��� ������� �������� ������� 
,(SELECT COUNT(trvID) FROM RegPlace WHERE trvID = @id) AS plcNum

-- ������� ��������� ������ ������� ��������
<<<<<<< HEAD
SELECT (SELECT SUM(cost) FROM Place WHERE id in (SELECT plcID FROM RegPlace WHERE trvID = 2))*
(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = 2) 'cost';


-- ������ ��� ��������� �������� 
SELECT COUNT(trvID) 'count' FROM Campaign WHERE trvID = 2;

-- ������� ��������� ��������� ��������
SELECT SUM(cost) 'cost' FROM Campaign WHERE trvID = 2;

-- ������ ������ ������
SELECT SUM(actualProfit) 'profit' FROM RegTourist WHERE trvID = 2;
=======
,(SELECT (SELECT SUM(totalCost) FROM RegPlace WHERE trvID = @id)*
(SELECT COUNT(trvID) FROM RegTourist WHERE trvID = @id)) AS plcCost


-- ������ ��� ��������� �������� 
,(SELECT COUNT(trvID) FROM Campaign WHERE trvID = @id) AS adNum

-- ������� ��������� ��������� ��������
,(SELECT SUM(cost) FROM Campaign WHERE trvID = @id) AS adCost

-- ������ ������ ������
,(SELECT SUM(actualProfit) FROM RegTourist WHERE trvID = @id) AS trvProfit
>>>>>>> 6c293dbeda4c499650e60a29076f333119c87823


-- ������ ����� ������

,(SELECT (SELECT SUM(totalCost) FROM RegTransport WHERE trvID = @id) +
						  (SELECT SUM(totalCost) FROM RegHostel WHERE trvID = @id) +
<<<<<<< HEAD
						  ((SELECT SUM(cost) FROM Place WHERE id in (SELECT plcID FROM RegPlace WHERE trvID = @id))*
						  (SELECT COUNT(trvID) FROM RegTourist WHERE trvID = @id)) +
						  (SELECT SUM(totalCost) FROM RegGuide WHERE trvID = @id) +
						  (SELECT SUM(cost) FROM Campaign WHERE trvID = @id)
SELECT @cost 'totalcost';

-- ���� ��� ������
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


-- ���� ��� ������
-- DECLARE  @trvid AS int = @id
,(SELECT (SELECT SUM(actualProfit) FROM RegTourist WHERE trvID = @id)-
							   ((SELECT SUM(totalCost) FROM RegTransport WHERE trvID = @id)+
							   (SELECT SUM(totalCost) FROM RegHostel WHERE trvID = @id) +
							   ((SELECT SUM(totalCost) FROM RegPlace WHERE trvID = @id)*
							   (SELECT COUNT(trvID) FROM RegTourist WHERE trvID = @id))+
							   (SELECT SUM(totalCost) FROM RegGuide WHERE trvID = @id) +
							   (SELECT SUM(cost) FROM Campaign WHERE trvID = @id))) AS trvNetProfit;



>>>>>>> 6c293dbeda4c499650e60a29076f333119c87823


