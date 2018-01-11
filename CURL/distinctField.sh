curl -XGET 'localhost:9200/products/product/_search?pretty' -H 'Content-Type: application/json' -d'
{"size": 1,
    "aggs" : {
        
        "genres" : {
        
            "terms" : { "field" : "class" },
           
        }
        
    }
}
'
