window.repository = {"title": "DTSDB@MACHINE","license": "trial","license_expires_at": "2021-08-18","exported_at": "2021-08-04 16:36","structure": [{"id": "d6","object_id": "d6","type": "documentation","name": "DTSDB@MACHINE","subtype": null,"is_user_defined": false,"children": [{"id": "d6m","object_id": "d6m","type": "modules","name": "Modules","subtype": null,"is_user_defined": false,"children": [{"id": "m107","object_id": "m107","type": "module","name": "New module","subtype": null,"is_user_defined": true,"children": [{"id": "m107t","object_id": "m107t","type": "module_tables","name": "Tables","subtype": null,"is_user_defined": false,"children": [{"id": "m107t3719","object_id": "t3719","type": "module_table","name": "Advertisement","subtype": "TABLE","is_user_defined": false,"columns": ["id","companyID","info","designCost","CREATEDate","idle"],},{"id": "m107t3720","object_id": "t3720","type": "module_table","name": "Agent","subtype": "TABLE","is_user_defined": false,"columns": ["id","usrID","password","name","NID","gender","mobile","birthDate","email","cityID","localAdd","creatDate","idle"],},{"id": "m107t3721","object_id": "t3721","type": "module_table","name": "Campaign","subtype": "TABLE","is_user_defined": false,"columns": ["id","trvID","adID","media","targetedNum","reachedNum","startDate","endDate","regDate","cost","idle"],},{"id": "m107t3722","object_id": "t3722","type": "module_table","name": "City","subtype": "TABLE","is_user_defined": false,"columns": ["id","city"],},{"id": "m107t3723","object_id": "t3723","type": "module_table","name": "Guide","subtype": "TABLE","is_user_defined": false,"columns": ["id","specialty","name","NID","gender","mobile","birthDate","email","cityID","localAdd","rate","creatDate","idle"],},{"id": "m107t3724","object_id": "t3724","type": "module_table","name": "Hostel","subtype": "TABLE","is_user_defined": false,"columns": ["id","name","type","ownerID","creatDate","idle","cityID","localAdd","capacity","hotelDegree","cost"],},{"id": "m107t3725","object_id": "t3725","type": "module_table","name": "Phone","subtype": "TABLE","is_user_defined": false,"columns": ["id","phone","fax"],},{"id": "m107t3726","object_id": "t3726","type": "module_table","name": "Place","subtype": "TABLE","is_user_defined": false,"columns": ["id","type","idle","name","cityID","capacity","cost","creatDate"],},{"id": "m107t3727","object_id": "t3727","type": "module_table","name": "RegGuide","subtype": "TABLE","is_user_defined": false,"columns": ["trvID","gudID","daysNum","regDate","totalCost"],},{"id": "m107t3728","object_id": "t3728","type": "module_table","name": "RegHostel","subtype": "TABLE","is_user_defined": false,"columns": ["trvID","hstID","roomNum","nightsNum","totalCost","regDate"],},{"id": "m107t3729","object_id": "t3729","type": "module_table","name": "RegPlace","subtype": "TABLE","is_user_defined": false,"columns": ["trvID","plcID","regDate","totalCost"],},{"id": "m107t3730","object_id": "t3730","type": "module_table","name": "RegTourist","subtype": "TABLE","is_user_defined": false,"columns": ["trvID","turID","regDate","actualProfit"],},{"id": "m107t3731","object_id": "t3731","type": "module_table","name": "RegTransport","subtype": "TABLE","is_user_defined": false,"columns": ["trvID","trsID","daysNum","totalCost","regDate"],},{"id": "m107t3732","object_id": "t3732","type": "module_table","name": "ServiceProvider","subtype": "TABLE","is_user_defined": false,"columns": ["id","class","name","CRN","email","cityID","localAdd","type","CREATEDate","idle","discount"],},{"id": "m107t3733","object_id": "t3733","type": "module_table","name": "Tourist","subtype": "TABLE","is_user_defined": false,"columns": ["id","prtID","info","balance","name","NID","gender","mobile","birthDate","email","cityID","localAdd","creatDate","idle"],},{"id": "m107t3734","object_id": "t3734","type": "module_table","name": "Transport","subtype": "TABLE","is_user_defined": false,"columns": ["id","type","ownerID","panelNo","model","capacity","cityID","creatDate","cost","idle"],},{"id": "m107t3735","object_id": "t3735","type": "module_table","name": "Travel","subtype": "TABLE","is_user_defined": false,"columns": ["id","title","creatDate","idle","startDate","endDate","price"],},]},]},]},{"id": "d6t","object_id": "d6t","type": "tables","name": "Tables","subtype": null,"is_user_defined": false,"children": [{"id": "t3719","object_id": "t3719","type": "table","name": "Advertisement","subtype": "TABLE","is_user_defined": false,"columns": ["id","companyID","info","designCost","CREATEDate","idle"],},{"id": "t3720","object_id": "t3720","type": "table","name": "Agent","subtype": "TABLE","is_user_defined": false,"columns": ["id","usrID","password","name","NID","gender","mobile","birthDate","email","cityID","localAdd","creatDate","idle"],},{"id": "t3721","object_id": "t3721","type": "table","name": "Campaign","subtype": "TABLE","is_user_defined": false,"columns": ["id","trvID","adID","media","targetedNum","reachedNum","startDate","endDate","regDate","cost","idle"],},{"id": "t3722","object_id": "t3722","type": "table","name": "City","subtype": "TABLE","is_user_defined": false,"columns": ["id","city"],},{"id": "t3723","object_id": "t3723","type": "table","name": "Guide","subtype": "TABLE","is_user_defined": false,"columns": ["id","specialty","name","NID","gender","mobile","birthDate","email","cityID","localAdd","rate","creatDate","idle"],},{"id": "t3724","object_id": "t3724","type": "table","name": "Hostel","subtype": "TABLE","is_user_defined": false,"columns": ["id","name","type","ownerID","creatDate","idle","cityID","localAdd","capacity","hotelDegree","cost"],},{"id": "t3725","object_id": "t3725","type": "table","name": "Phone","subtype": "TABLE","is_user_defined": false,"columns": ["id","phone","fax"],},{"id": "t3726","object_id": "t3726","type": "table","name": "Place","subtype": "TABLE","is_user_defined": false,"columns": ["id","type","idle","name","cityID","capacity","cost","creatDate"],},{"id": "t3727","object_id": "t3727","type": "table","name": "RegGuide","subtype": "TABLE","is_user_defined": false,"columns": ["trvID","gudID","daysNum","regDate","totalCost"],},{"id": "t3728","object_id": "t3728","type": "table","name": "RegHostel","subtype": "TABLE","is_user_defined": false,"columns": ["trvID","hstID","roomNum","nightsNum","totalCost","regDate"],},{"id": "t3729","object_id": "t3729","type": "table","name": "RegPlace","subtype": "TABLE","is_user_defined": false,"columns": ["trvID","plcID","regDate","totalCost"],},{"id": "t3730","object_id": "t3730","type": "table","name": "RegTourist","subtype": "TABLE","is_user_defined": false,"columns": ["trvID","turID","regDate","actualProfit"],},{"id": "t3731","object_id": "t3731","type": "table","name": "RegTransport","subtype": "TABLE","is_user_defined": false,"columns": ["trvID","trsID","daysNum","totalCost","regDate"],},{"id": "t3732","object_id": "t3732","type": "table","name": "ServiceProvider","subtype": "TABLE","is_user_defined": false,"columns": ["id","class","name","CRN","email","cityID","localAdd","type","CREATEDate","idle","discount"],},{"id": "t3733","object_id": "t3733","type": "table","name": "Tourist","subtype": "TABLE","is_user_defined": false,"columns": ["id","prtID","info","balance","name","NID","gender","mobile","birthDate","email","cityID","localAdd","creatDate","idle"],},{"id": "t3734","object_id": "t3734","type": "table","name": "Transport","subtype": "TABLE","is_user_defined": false,"columns": ["id","type","ownerID","panelNo","model","capacity","cityID","creatDate","cost","idle"],},{"id": "t3735","object_id": "t3735","type": "table","name": "Travel","subtype": "TABLE","is_user_defined": false,"columns": ["id","title","creatDate","idle","startDate","endDate","price"],},]},]},],"objects": {"m107t": { _ref: "data/m107t.json.js" },"d6": { _ref: "data/d6.json.js" },"d6t": { _ref: "data/d6t.json.js" },"d6m": { _ref: "data/d6m.json.js" },"t3719": { _ref: "data/t3719.json.js" },"t3721": { _ref: "data/t3721.json.js" },"t3720": { _ref: "data/t3720.json.js" },"t3724": { _ref: "data/t3724.json.js" },"t3728": { _ref: "data/t3728.json.js" },"t3722": { _ref: "data/t3722.json.js" },"t3726": { _ref: "data/t3726.json.js" },"t3723": { _ref: "data/t3723.json.js" },"t3727": { _ref: "data/t3727.json.js" },"t3730": { _ref: "data/t3730.json.js" },"t3729": { _ref: "data/t3729.json.js" },"t3732": { _ref: "data/t3732.json.js" },"t3725": { _ref: "data/t3725.json.js" },"t3734": { _ref: "data/t3734.json.js" },"t3733": { _ref: "data/t3733.json.js" },"t3731": { _ref: "data/t3731.json.js" },"t3735": { _ref: "data/t3735.json.js" },"m107": { _ref: "data/m107.json.js" },}};