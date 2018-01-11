curl -XGET 'localhost:9200/products/product/_search?pretty' -H 'Content-Type: application/json' -d'
{
    "size": 0,
    "aggs" : {
        "test" : {
            "percentile_ranks" : {
                "field" : "regularPrice",
                "values" : [10, 50]
            }
        }
    }
}
'
