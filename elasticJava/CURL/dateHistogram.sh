curl -XPOST 'localhost:9200/products/_search?size=0&pretty' -H 'Content-Type: application/json' -d'
{
    "aggs" : {
        "sales_over_time" : {
            "date_histogram" : {
                "field" : "startDate",
                "interval" : "month"
            }
        }
    }
}
'
