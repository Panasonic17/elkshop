package shop.test.features;


import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.json.JSONObject;
import shop.entity.product.Product;
import shop.services.transformer.ProductTransformer;
import shop.test.features.utils.Client;

import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

public class BoolQuery {
    public static void main(String[] args) {
        ProductTransformer transformer=new ProductTransformer();
        SearchResponse response = Client.getInstance().prepareSearch("products")
                .setTypes("product")
                .setQuery(QueryBuilders.boolQuery().should(matchQuery("shortDescription", "AA")))
                .get();
//        System.out.println("++++++++++++++++++++++++++");
        for (SearchHit hit : response.getHits().getHits()) {

            JSONObject jsonObject=new JSONObject(hit.getSourceAsString());
            Product p=new Product();
            p.populateObject(jsonObject);
            System.out.println("PRODUCT "+ p);
//            Map<String, Object> map = hit.getSourceAsMap();
//            transformer.hitnToProduct(hit);
//            for (Map.Entry<String, Object> entry : map.entrySet()) {
////                System.out.println(entry.getKey() + " " + entry.getValue());
//
//            }
//            System.out.println("++++++++++++++++++++++++++");
//            Terms agg1 = response.getAggregations().get("products");
//            System.out.println(agg1);
        }
    }
}
