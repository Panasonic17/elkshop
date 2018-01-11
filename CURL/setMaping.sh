curl -XPUT 'localhost:9200/products/_mapping/product?pretty' -H 'Content-Type: application/json' -d'
{
  "properties": {
      "class" : {
            "type" : "text",
            "fielddata": true,
            "fields" : {
              "keyword" : {
                "type" : "keyword",
                "ignore_above" : 256
              }
            }
          },
          "productId" : {
            "type" : "long"
          },
          "shortDescription" : {
            "type" : "text",
            "fielddata" : true,
            "fields" : {
              "keyword" : {
                "type" : "keyword",
                "ignore_above" : 256
              }
            }
          },
          "manufacturer" : {
            "type" : "text",
             "fielddata" : true,
            "fields" : {
              "keyword" : {
                "type" : "keyword",
                "ignore_above" : 256
              }
            }
          },
          "sku" : {
            "type" : "long"
          },
          "subclass" : {
            "type" : "text",
            "fields" : {
              "keyword" : {
                "type" : "keyword",
                "ignore_above" : 256
              }
            }
          }
}
  }
'
