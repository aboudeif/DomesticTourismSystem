window.repositoryObject = {"columns_custom_fields":[],"relations_custom_fields":[],"unique_keys_custom_fields":[],"triggers_custom_fields":[],"object_id":"t3724","name":"Hostel","subtype":"TABLE","is_user_defined":false,"description":null,"summary":[{"field":"Documentation","value":{"_type":"link","name":"DTSDB@MACHINE","id":"d6"}},{"field":"Schema","value":"dbo"},{"field":"Name","value":"Hostel"},{"field":"Type","value":"Table"},{"field":"Module","value":[{"_type":"link","name":"New module","id":"m107"}]}],"columns":[{"id":"column-34361","object_id":"column-34361","name":"id","name_without_path":"id","description":null,"is_pk":true,"is_identity":true,"data_type":"int","data_length":null,"is_nullable":false,"computed_formula":null,"default_value":null,"path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[]},{"id":"column-34362","object_id":"column-34362","name":"name","name_without_path":"name","description":null,"is_pk":false,"is_identity":false,"data_type":"nvarchar","data_length":"75","is_nullable":false,"computed_formula":null,"default_value":null,"path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[]},{"id":"column-34363","object_id":"column-34363","name":"type","name_without_path":"type","description":null,"is_pk":false,"is_identity":false,"data_type":"varchar","data_length":"30","is_nullable":false,"computed_formula":null,"default_value":null,"path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[]},{"id":"column-34364","object_id":"column-34364","name":"ownerID","name_without_path":"ownerID","description":null,"is_pk":false,"is_identity":false,"data_type":"int","data_length":null,"is_nullable":true,"computed_formula":null,"default_value":null,"path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[{"id":"t3732","name":"ServiceProvider","name_show_schema":"dbo.ServiceProvider"}]},{"id":"column-34365","object_id":"column-34365","name":"creatDate","name_without_path":"creatDate","description":null,"is_pk":false,"is_identity":false,"data_type":"smalldatetime","data_length":null,"is_nullable":false,"computed_formula":null,"default_value":"getdate()","path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[]},{"id":"column-34366","object_id":"column-34366","name":"idle","name_without_path":"idle","description":null,"is_pk":false,"is_identity":false,"data_type":"bit","data_length":null,"is_nullable":false,"computed_formula":null,"default_value":"0","path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[]},{"id":"column-34367","object_id":"column-34367","name":"cityID","name_without_path":"cityID","description":null,"is_pk":false,"is_identity":false,"data_type":"int","data_length":null,"is_nullable":true,"computed_formula":null,"default_value":null,"path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[{"id":"t3722","name":"City","name_show_schema":"dbo.City"}]},{"id":"column-34368","object_id":"column-34368","name":"localAdd","name_without_path":"localAdd","description":null,"is_pk":false,"is_identity":false,"data_type":"varchar","data_length":"100","is_nullable":true,"computed_formula":null,"default_value":null,"path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[]},{"id":"column-34369","object_id":"column-34369","name":"capacity","name_without_path":"capacity","description":null,"is_pk":false,"is_identity":false,"data_type":"smallint","data_length":null,"is_nullable":true,"computed_formula":null,"default_value":"0","path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[]},{"id":"column-34370","object_id":"column-34370","name":"hotelDegree","name_without_path":"hotelDegree","description":null,"is_pk":false,"is_identity":false,"data_type":"int","data_length":null,"is_nullable":false,"computed_formula":null,"default_value":"0","path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[]},{"id":"column-34371","object_id":"column-34371","name":"cost","name_without_path":"cost","description":null,"is_pk":false,"is_identity":false,"data_type":"money","data_length":null,"is_nullable":false,"computed_formula":null,"default_value":"0","path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[]}],"relations":[{"name":"FK_hstCityID","title":null,"description":null,"is_user_defined":false,"foreign_table":"Hostel","foreign_table_show_schema":"dbo.Hostel","foreign_table_verbose":"Hostel","foreign_table_verbose_show_schema":"dbo.Hostel","foreign_table_object_id":"t3724","primary_table":"City","primary_table_show_schema":"dbo.City","primary_table_verbose":"City","primary_table_verbose_show_schema":"dbo.City","primary_table_object_id":"t3722","pk_cardinality":"1x","fk_cardinality":"mx","constraints":[{"primary_column_path":null,"primary_column":"id","foreign_column_path":null,"foreign_column":"cityID"}],"custom_fields":{}},{"name":"FK_hstOwnerID","title":null,"description":null,"is_user_defined":false,"foreign_table":"Hostel","foreign_table_show_schema":"dbo.Hostel","foreign_table_verbose":"Hostel","foreign_table_verbose_show_schema":"dbo.Hostel","foreign_table_object_id":"t3724","primary_table":"ServiceProvider","primary_table_show_schema":"dbo.ServiceProvider","primary_table_verbose":"ServiceProvider","primary_table_verbose_show_schema":"dbo.ServiceProvider","primary_table_object_id":"t3732","pk_cardinality":"1x","fk_cardinality":"mx","constraints":[{"primary_column_path":null,"primary_column":"id","foreign_column_path":null,"foreign_column":"ownerID"}],"custom_fields":{}},{"name":"FK_hstID","title":null,"description":null,"is_user_defined":false,"foreign_table":"RegHostel","foreign_table_show_schema":"dbo.RegHostel","foreign_table_verbose":"RegHostel","foreign_table_verbose_show_schema":"dbo.RegHostel","foreign_table_object_id":"t3728","primary_table":"Hostel","primary_table_show_schema":"dbo.Hostel","primary_table_verbose":"Hostel","primary_table_verbose_show_schema":"dbo.Hostel","primary_table_object_id":"t3724","pk_cardinality":"1x","fk_cardinality":"mx","constraints":[{"primary_column_path":null,"primary_column":"id","foreign_column_path":null,"foreign_column":"hstID"}],"custom_fields":{}}],"unique_keys":[{"name":"PK_Hostel","description":null,"is_pk":true,"is_user_defined":false,"columns":[{"path":null,"name_without_path":"id","name":"id"}],"custom_fields":{}}],"triggers":[],"dependencies":null,"imported_at":"2021-08-04 15:45"};