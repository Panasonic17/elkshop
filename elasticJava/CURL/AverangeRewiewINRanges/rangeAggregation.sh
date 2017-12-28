curl -XGET 'localhost:9200/products/_search?pretty' -H 'Content-Type: application/json' -d'
{   "size" : 0,
    "aggs" : {
        "price_ranges" : {
            "range" : {
                "field" : "regularPrice",
                "ranges" : [
                    { "to" : 10.0 },
                    { "from" : 10.0, "to" : 50.0 },
                    { "from" : 50.0 }
                ]
            },
            "aggs" :{
                 "avg_grade" : { "avg" : { "field" : "customerReviewAverage" } }
            }
        }
    }
}
'
