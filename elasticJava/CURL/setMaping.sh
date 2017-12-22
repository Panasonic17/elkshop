curl -XPUT 'localhost:9200/products/_mapping/product?pretty' -H 'Content-Type: application/json' -d'
{
  "properties": {
     "productId" : {
            "type" : "long"
          },
          "shortDescription" : {
            "type" : "text",
            "index" : "false",
            "fields" : {
              "keyword" : {
                "type" : "keyword",
                "ignore_above" : 256
              }
            }
          },
          "sku" : {
            "type" : "long"
          }
        }
  }
'
