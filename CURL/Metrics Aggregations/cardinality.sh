curl -XGET 'localhost:9200/products/_search?pretty' -H 'Content-Type: application/json' -d'
{
"size":0,
 "query": { "match_all": {} },
 "aggs" : {
        "class_count" : {
            "cardinality" : {
                "field" : "class"
            }
        }
    }
}
'