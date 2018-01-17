package DarkSideOfTheMoon;

import DarkSideOfTheMoon.utils.Client;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.global.Global;
import shop.services.averange.AvgService;

import java.util.Map;

/**
 * Created by Oleksandr_Shainoga on 1/16/2018.
 */
public class Avg {
    public static void main(String[] args) {
        AvgService avgService=new AvgService();
        SearchResponse response = Client.getInstance().prepareSearch("products")
                .setTypes("product")
                .setSize(0)
                .setQuery(QueryBuilders.matchAllQuery())
                .addAggregation(AggregationBuilders.avg("avg").field("regularPrice"))
//                .addAggregation(AggregationBuilders.range("test").field("regularPrice").addRange(0, 10).addRange(10, 50).addRange(50, Double.MAX_VALUE)
//                        .subAggregation(AggregationBuilders.avg("test1").field("customerReviewAverage")))
                .get();
        System.out.println(avgService.getAvg(response,"avg"));
//        Aggregation a =response.getAggregations().get("avg");
//        System.out.println(a.toString());
//        System.out.println(response.getAggregations().get("avg").getMetaData());
    }
}
