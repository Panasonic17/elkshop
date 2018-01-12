package DarkSideOfTheMoon;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import DarkSideOfTheMoon.utils.Client;

import java.util.Map;


public class getAllBattareis {

    public static void main(String[] args) {
        SearchResponse response = Client.getInstance().prepareSearch("products")
                .setTypes("product")
                .setQuery(QueryBuilders.termQuery("class", "batteries"))
                .addAggregation(AggregationBuilders.terms("products").field("manufacturer"))
                .get();

        for (SearchHit hit : response.getHits().getHits()) {
            Map<String,Object> map=hit.getSourceAsMap();
            for(Map.Entry<String,Object> entry: map.entrySet()){
                System.out.println(entry.getKey()+ " "+  entry.getValue());
                System.out.println("++++++++++++++++++++++++++");
            }
            Terms agg1 = response.getAggregations().get("products");
            System.out.println(agg1);
        }
    }
}
