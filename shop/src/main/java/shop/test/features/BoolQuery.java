package shop.test.features;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import utils.Client;

import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

public class BoolQuery {
    public static void main(String[] args) {

        SearchResponse response = Client.getInstance().prepareSearch("products")
                .setTypes("product")
                .setQuery(QueryBuilders.boolQuery().should(matchQuery("shortDescription", "AA")))
                .get();

        for (SearchHit hit : response.getHits().getHits()) {
            Map<String, Object> map = hit.getSourceAsMap();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
                System.out.println("++++++++++++++++++++++++++");
            }
//            Terms agg1 = response.getAggregations().get("products");
//            System.out.println(agg1);
        }
    }
}
