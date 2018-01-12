package shop.services.get;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.entity.product.Product;
import shop.services.transformer.ProductTransformer;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

@Service
public class GetTenProducts {
    @Autowired
    TransportClient client;

    public Product[] getTenProducts() {
        Product[] products = new Product[10];
        SearchResponse response = client.prepareSearch("products")
                .setTypes("product")
                .setQuery(QueryBuilders.matchAllQuery())
                .get();
        int i = 0;
        for (SearchHit hit : response.getHits().getHits()) {
            JSONObject jsonObject = new JSONObject(hit.getSourceAsString());
            ProductTransformer tp = new ProductTransformer();
            Product p = tp.jsonObjToProduct(jsonObject);
            products[i] = p;
            i++;
        }
        return products;
    }
}

