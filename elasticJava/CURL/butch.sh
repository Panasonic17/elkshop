curl -XPOST 'localhost:9200/_bulk?pretty' -H 'Content-Type: application/json' -d'
{ "index" : { "_index" : "PopulateData", "_type" : "type1", "_id" : "1" } }
{ "field1" : "value1" }
{ "delete" : { "_index" : "PopulateData", "_type" : "type1", "_id" : "2" } }
{ "create" : { "_index" : "PopulateData", "_type" : "type1", "_id" : "3" } }
{ "field1" : "value3" }
{ "update" : {"_id" : "1", "_type" : "type1", "_index" : "PopulateData"} }
{ "doc" : {"field2" : "value2"} }
'
