curl -XGET 'localhost:9200/accounts/account/_search?pretty' -H 'Content-Type: application/json' -d'
{
  "query": {
    "term": {
      "gender": "f"
    }
  }
}
'


