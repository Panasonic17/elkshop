package shop.services.averange;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.json.JSONObject;
import org.springframework.stereotype.Service;


@Service
public class AvgService {

    public void addAvgValue(SearchRequestBuilder searchRequestBuilder, String name, String field) {
        searchRequestBuilder.addAggregation(AggregationBuilders.avg(name).field(field));
    }

    public double getAvg(SearchResponse response, String name) {
        String json = response.getAggregations().get(name).toString();
        JSONObject jsonObject=new JSONObject(json);
        JSONObject valueObject= (JSONObject) jsonObject.get(name);
        return Double.parseDouble(valueObject.get("value")+"");
    }
}
