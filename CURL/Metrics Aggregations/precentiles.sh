curl -XGET 'localhost:9200/products/product/_search?pretty' -H 'Content-Type: application/json' -d'
{
    "size": 0,
    "aggs" : {
        "load_time_outlier" : {
            "percentiles" : {
                "field" : "regularPrice" 
            }
        }
    }
}
'
