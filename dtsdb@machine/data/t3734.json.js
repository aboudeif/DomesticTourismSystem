window.repositoryObject = {"columns_custom_fields":[],"relations_custom_fields":[],"unique_keys_custom_fields":[],"triggers_custom_fields":[],"object_id":"t3734","name":"Transport","subtype":"TABLE","is_user_defined":false,"description":null,"summary":[{"field":"Documentation","value":{"_type":"link","name":"DTSDB@MACHINE","id":"d6"}},{"field":"Schema","value":"dbo"},{"field":"Name","value":"Transport"},{"field":"Type","value":"Table"},{"field":"Module","value":[{"_type":"link","name":"New module","id":"m107"}]}],"columns":[{"id":"column-34432","object_id":"column-34432","name":"id","name_without_path":"id","description":null,"is_pk":true,"is_identity":true,"data_type":"int","data_length":null,"is_nullable":false,"computed_formula":null,"default_value":null,"path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[]},{"id":"column-34433","object_id":"column-34433","name":"type","name_without_path":"type","description":null,"is_pk":false,"is_identity":false,"data_type":"varchar","data_length":"30","is_nullable":false,"computed_formula":null,"default_value":null,"path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[]},{"id":"column-34434","object_id":"column-34434","name":"ownerID","name_without_path":"ownerID","description":null,"is_pk":false,"is_identity":false,"data_type":"int","data_length":null,"is_nullable":true,"computed_formula":null,"default_value":null,"path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[{"id":"t3732","name":"ServiceProvider","name_show_schema":"dbo.ServiceProvider"}]},{"id":"column-34435","object_id":"column-34435","name":"panelNo","name_without_path":"panelNo","description":null,"is_pk":false,"is_identity":false,"data_type":"varchar","data_length":"25","is_nullable":true,"computed_formula":null,"default_value":null,"path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[]},{"id":"column-34436","object_id":"column-34436","name":"model","name_without_path":"model","description":null,"is_pk":false,"is_identity":false,"data_type":"nvarchar","data_length":"30","is_nullable":true,"computed_formula":null,"default_value":null,"path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[]},{"id":"column-34437","object_id":"column-34437","name":"capacity","name_without_path":"capacity","description":null,"is_pk":false,"is_identity":false,"data_type":"smallint","data_length":null,"is_nullable":true,"computed_formula":null,"default_value":"0","path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[]},{"id":"column-34438","object_id":"column-34438","name":"cityID","name_without_path":"cityID","description":null,"is_pk":false,"is_identity":false,"data_type":"int","data_length":null,"is_nullable":true,"computed_formula":null,"default_value":null,"path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[{"id":"t3722","name":"City","name_show_schema":"dbo.City"}]},{"id":"column-34439","object_id":"column-34439","name":"creatDate","name_without_path":"creatDate","description":null,"is_pk":false,"is_identity":false,"data_type":"smalldatetime","data_length":null,"is_nullable":false,"computed_formula":null,"default_value":"getdate()","path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[]},{"id":"column-34440","object_id":"column-34440","name":"cost","name_without_path":"cost","description":null,"is_pk":false,"is_identity":false,"data_type":"money","data_length":null,"is_nullable":false,"computed_formula":null,"default_value":"0","path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[]},{"id":"column-34441","object_id":"column-34441","name":"idle","name_without_path":"idle","description":null,"is_pk":false,"is_identity":false,"data_type":"bit","data_length":null,"is_nullable":false,"computed_formula":null,"default_value":"0","path":null,"level":1,"item_type":"COLUMN","is_user_defined":false,"custom_fields":{},"linked_terms":null,"references":[]}],"relations":[{"name":"FK_trsCityID","title":null,"description":null,"is_user_defined":false,"foreign_table":"Transport","foreign_table_show_schema":"dbo.Transport","foreign_table_verbose":"Transport","foreign_table_verbose_show_schema":"dbo.Transport","foreign_table_object_id":"t3734","primary_table":"City","primary_table_show_schema":"dbo.City","primary_table_verbose":"City","primary_table_verbose_show_schema":"dbo.City","primary_table_object_id":"t3722","pk_cardinality":"1x","fk_cardinality":"mx","constraints":[{"primary_column_path":null,"primary_column":"id","foreign_column_path":null,"foreign_column":"cityID"}],"custom_fields":{}},{"name":"FK_trsOwnerID","title":null,"description":null,"is_user_defined":false,"foreign_table":"Transport","foreign_table_show_schema":"dbo.Transport","foreign_table_verbose":"Transport","foreign_table_verbose_show_schema":"dbo.Transport","foreign_table_object_id":"t3734","primary_table":"ServiceProvider","primary_table_show_schema":"dbo.ServiceProvider","primary_table_verbose":"ServiceProvider","primary_table_verbose_show_schema":"dbo.ServiceProvider","primary_table_object_id":"t3732","pk_cardinality":"1x","fk_cardinality":"mx","constraints":[{"primary_column_path":null,"primary_column":"id","foreign_column_path":null,"foreign_column":"ownerID"}],"custom_fields":{}},{"name":"FK_trsID","title":null,"description":null,"is_user_defined":false,"foreign_table":"RegTransport","foreign_table_show_schema":"dbo.RegTransport","foreign_table_verbose":"RegTransport","foreign_table_verbose_show_schema":"dbo.RegTransport","foreign_table_object_id":"t3731","primary_table":"Transport","primary_table_show_schema":"dbo.Transport","primary_table_verbose":"Transport","primary_table_verbose_show_schema":"dbo.Transport","primary_table_object_id":"t3734","pk_cardinality":"1x","fk_cardinality":"mx","constraints":[{"primary_column_path":null,"primary_column":"id","foreign_column_path":null,"foreign_column":"trsID"}],"custom_fields":{}}],"unique_keys":[{"name":"PK_Transport","description":null,"is_pk":true,"is_user_defined":false,"columns":[{"path":null,"name_without_path":"id","name":"id"}],"custom_fields":{}}],"triggers":[],"dependencies":null,"imported_at":"2021-08-04 15:45"};