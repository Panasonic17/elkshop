curl -XGET 'localhost:9200/products/_search?pretty' -H 'Content-Type: application/json' -d'
{
  "query": {
    "bool": {
      "should": [
        { "match": { "longDescription":  "MN2400B4Z" }},
        { "match": { "class": "BATTERIES"   }}
      ]
    }
  }
}
'
