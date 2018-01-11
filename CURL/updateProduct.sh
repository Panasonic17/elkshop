curl -XPOST 'localhost:9200/products/product/-170840956/_update?pretty&pretty' -H 'Content-Type: application/json' -d'
{
  "script" : "ctx._source.sku += 3"
}
'
