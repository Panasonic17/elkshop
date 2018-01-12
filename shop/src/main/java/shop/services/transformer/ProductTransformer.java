package shop.services.transformer;

import org.elasticsearch.search.SearchHit;
import org.springframework.stereotype.Service;
import shop.entity.product.Product;

import java.util.Map;

/**
 * Created by Oleksandr_Shainoga on 1/12/2018.
 */
@Service
public class ProductTransformer {
    public Product hitnToProduct(SearchHit hit) {
//        hit.
        Map<String, Object> map = hit.getSourceAsMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());

        }
        return null;
    }
}
