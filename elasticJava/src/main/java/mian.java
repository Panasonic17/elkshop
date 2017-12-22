import Entity.accounts.Account;
import Entity.blogs.Tweet;
import Transform.AccountTransformers;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import utils.Client;
import utils.ElasticCRUD;
import utils.Populate.PopulateAccounts;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

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
        ArrayList<Account> accounts = AccountTransformers.getAccounts(scrollResp.toString());
//        System.out.println(scrollResp);
        for (Account a:accounts){
            System.out.println(a);
            System.out.println("+++++++++++++++++++++++++++++++++++++");
        }

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
