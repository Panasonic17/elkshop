curl -XGET 'localhost:9200/_search?pretty' -H 'Content-Type: application/json' -d'
{
"explain":true,
    "query" : {
        "match": { "class": "COMPACT DISC" }
    },
    "highlight" : {
        "fields" : {
            "class" : {}
        }
    }
}
'
