package shop.services.get;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.entity.product.Product;
import shop.services.transformer.ProductTransformer;

import java.util.ArrayList;

/**
 * Created by Oleksandr_Shainoga on 1/12/2018.
 */
@Service
public class GetProducts {
    @Autowired
    TransportClient client;


    public Product[] getProducts(SearchResponse response) {
        ArrayList<Product> products = new ArrayList<>();

        int i = 0;
        for (SearchHit hit : response.getHits().getHits()) {
            JSONObject jsonObject = new JSONObject(hit.getSourceAsString());
            ProductTransformer tp = new ProductTransformer();
            Product p = tp.jsonObjToProduct(jsonObject);
            products.add(p);
        }
        Product[] productArr = new Product[products.size()];
        for (int j = 0; j < products.size(); j++) {
            productArr[j] = products.get(j);
        }
        return productArr;
    }

    //pererob!!1
    public Product[] getProducts(SearchRequestBuilder searchRequestBuilder) {
        ArrayList<Product> products = new ArrayList<>();
        SearchResponse response = searchRequestBuilder.get();
        int i = 0;
        for (SearchHit hit : response.getHits().getHits()) {
            JSONObject jsonObject = new JSONObject(hit.getSourceAsString());
            ProductTransformer tp = new ProductTransformer();
            Product p = tp.jsonObjToProduct(jsonObject);
            products.add(p);
        }
        Product[] productArr = new Product[products.size()];
        for (int j = 0; j < products.size(); j++) {
            productArr[j] = products.get(j);
        }
        return productArr;
    }
}
