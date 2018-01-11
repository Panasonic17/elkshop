package shop.test.features;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.range.InternalRange;
import shop.test.features.utils.Client;

/**
 * Created by Oleksandr_Shainoga on 12/27/2017.
 */
public class RangeSelect {
    public static void main(String[] args) {
        SearchResponse response = Client.getInstance().prepareSearch("products")
                .setTypes("product")
                .addAggregation(AggregationBuilders.range("test").field("regularPrice").addRange(0, 10).addRange(10, 50).addRange(50, Double.MAX_VALUE)
                        .subAggregation(AggregationBuilders.avg("test1").field("customerReviewAverage")))
                .get();
        InternalRange agg1 = response.getAggregations().get("test");
        System.out.println(agg1);
        System.out.println(response.getAggregations().get("test1").toString());
    }
}
