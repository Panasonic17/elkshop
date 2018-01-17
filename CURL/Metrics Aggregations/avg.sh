curl -XPOST 'localhost:9200/products/_search?size=0&pretty' -H 'Content-Type: application/json' -d'
{
    "query": { "term": {"class" : "batteries"}},
    "aggs" : {
        "avg_price" : { "avg" : { "field" : "regularPrice" } }
    }
}
'
