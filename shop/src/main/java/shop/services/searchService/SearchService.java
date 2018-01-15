package shop.services.searchService;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import shop.configuration.ElkConnector;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


@Component
public class SearchService {
    @Autowired
    SearchRequestBuilder searchRequestBuilder;

    @Autowired
    BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();

    public void addSearchText(String text) {
        String fields[] = {"name", "shortDescription", "productClass", "longDescription", "manufacturer"};
        boolQueryBuilder.must().add(QueryBuilders.multiMatchQuery(text, fields));
    }

    public SearchRequestBuilder setSize(SearchRequestBuilder searchRequestBuilder, Integer size) {
        return searchRequestBuilder.setSize(size);
    }

    public void priceBounds(Double min, Double max) {
//        System.out.println("bounds "+ max + " "+ min );
//        searchRequestBuilder.setQuery(QueryBuilders
//                .rangeQuery("price")
//                .from(min)
//                .to(max)
//        );
        boolQueryBuilder.must().add(QueryBuilders
                .rangeQuery("regularPrice")
                .from(min)
                .to(max)
        );
//        return searchRequestBuilder;
    }

    public SearchRequestBuilder build() {
        System.err.println("bAD IDEA  need to rewrite  Search service byild");
//        SearchRequestBuilder   searchRequestBuilder= ElkConnector.transportClient().prepareSearch("products")
//                .setTypes("product")
//                .setQuery(QueryBuilders.matchAllQuery());

        searchRequestBuilder.setQuery(boolQueryBuilder);
        boolQueryBuilder = new BoolQueryBuilder(); // here is big bad idea @!!!!!!!!!!!!!!
        return searchRequestBuilder;
    }

}

