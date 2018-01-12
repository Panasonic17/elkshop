package shop.services.get;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import shop.components.utils.Client;
import shop.entity.product.Product;

import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

@Service
public class GetTenProducts {

    TransportClient client = Client.getInstance();

    public Product[] getTenProducts() {
        Product[] products = new Product[10];
        SearchResponse response = shop.test.features.utils.Client.getInstance().prepareSearch("products")
                .setTypes("product")
                .setQuery(QueryBuilders.boolQuery().should(matchQuery("shortDescription", "AA")))
                .get();
        int i = 0;
        for (SearchHit hit : response.getHits().getHits()) {
            JSONObject jsonObject = new JSONObject(hit.getSourceAsString());
            Product p = new Product();
            p.populateObject(jsonObject);
            products[i] = p;
            i++;
        }
        return products;
    }
}

