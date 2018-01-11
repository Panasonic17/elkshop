package previousProject.java;

import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import utils.Client;

import java.io.IOException;

public class mian {
    public static void main(String[] args) throws IOException {
//        Tweet t1 = new Tweet("sawa", null, "Sawa testing");
//        XContentBuilder xContentBuilder = t1.getXContent();
//        IndexResponse response = ElasticCRUD.put("blogs", "tweet", xContentBuilder);
//        GetResponse response =ElasticCRUD.get("blogs","tweet","1"); //Client.getInstance().prepareGet("blogs", "tweet", "6").get();
//        System.out.println(Tweet.getTweetFromJson(response.toString()));
//        System.out.println(response);
//        PopulateAccounts.populateAccounts();
//        System.out.println("PP");
        SearchResponse scrollResp = Client.getInstance().prepareSearch("accounts").setTypes("account").setQuery(QueryBuilders.matchQuery("gender","F")).setSize(4).get();
//        System.out.println(scrollResp);
        BulkRequest bk=new BulkRequest();
//        Client.getInstance().bulk()

    }
}

//        curl -XGET 'localhost:9200/accounts/account/_search?pretty' -H 'Content-Type: application/json' -d'
//        {
//                "query": {
//                "term": {
//                "gender": "M"
//                }
//                }
//        }
//        '
