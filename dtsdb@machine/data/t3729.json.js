window.repositoryObject = {"columns_custom_fields":[],"relations_custom_fields":[],"unique_keys_custom_fields":[],"triggers_custom_fields":[],"object_id":"t3729","name":"RegPlace","subtype":"TABLE","is_user_defined":false,"description":null,"summary":[{"field":"Documentation","value":{"_type":"link","name":"DTSDB@MACHINE","id":"d6"}},{"field":"Schema","value":"dbo"},{"field":"Name","value":"RegPlace"},{"field":"Type","value":"Table"},{"field":"Module","value":[{"_type":"link","name":"New module","id":"m107"}]}],"columns":[{"id":"column-34394","object_id":"column-34394","name":"trvID","name_without_path":"trvID","description":null,"is_pk":true,"is_identity":false,"data_type":"int","data_length":null,"is_nullable":false,"computed_formula":null,"default_value":null,"path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[{"id":"t3735","name":"Travel","name_show_schema":"dbo.Travel"}]},{"id":"column-34395","object_id":"column-34395","name":"plcID","name_without_path":"plcID","description":null,"is_pk":true,"is_identity":false,"data_type":"int","data_length":null,"is_nullable":false,"computed_formula":null,"default_value":null,"path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[{"id":"t3726","name":"Place","name_show_schema":"dbo.Place"}]},{"id":"column-34396","object_id":"column-34396","name":"regDate","name_without_path":"regDate","description":null,"is_pk":false,"is_identity":false,"data_type":"smalldatetime","data_length":null,"is_nullable":false,"computed_formula":null,"default_value":"getdate()","path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[]},{"id":"column-34397","object_id":"column-34397","name":"totalCost","name_without_path":"totalCost","description":null,"is_pk":false,"is_identity":false,"data_type":"money","data_length":null,"is_nullable":false,"computed_formula":null,"default_value":"0","path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[]}],"relations":[{"name":"FK_plcID","title":null,"description":null,"is_user_defined":false,"foreign_table":"RegPlace","foreign_table_show_schema":"dbo.RegPlace","foreign_table_verbose":"RegPlace","foreign_table_verbose_show_schema":"dbo.RegPlace","foreign_table_object_id":"t3729","primary_table":"Place","primary_table_show_schema":"dbo.Place","primary_table_verbose":"Place","primary_table_verbose_show_schema":"dbo.Place","primary_table_object_id":"t3726","pk_cardinality":"1x","fk_cardinality":"mx","constraints":[{"primary_column_path":null,"primary_column":"id","foreign_column_path":null,"foreign_column":"plcID"}],"custom_fields":{}},{"name":"FK_plcTrvID","title":null,"description":null,"is_user_defined":false,"foreign_table":"RegPlace","foreign_table_show_schema":"dbo.RegPlace","foreign_table_verbose":"RegPlace","foreign_table_verbose_show_schema":"dbo.RegPlace","foreign_table_object_id":"t3729","primary_table":"Travel","primary_table_show_schema":"dbo.Travel","primary_table_verbose":"Travel","primary_table_verbose_show_schema":"dbo.Travel","primary_table_object_id":"t3735","pk_cardinality":"1x","fk_cardinality":"mx","constraints":[{"primary_column_path":null,"primary_column":"id","foreign_column_path":null,"foreign_column":"trvID"}],"custom_fields":{}}],"unique_keys":[{"name":"PK_RegPlace","description":null,"is_pk":true,"is_user_defined":false,"columns":[{"path":null,"name_without_path":"trvID","name":"trvID"},{"path":null,"name_without_path":"plcID","name":"plcID"}],"custom_fields":{}}],"triggers":[],"dependencies":null,"imported_at":"2021-08-04 15:45"};