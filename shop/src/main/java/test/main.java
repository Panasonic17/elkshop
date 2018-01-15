package test;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import shop.configuration.ElkConnector;
import shop.services.searchService.SearchService;

/**
 * Created by Oleksandr_Shainoga on 1/12/2018.
 */
public class main {

    public static void main(String[] args) {
        SearchService searchService=new SearchService();
        SearchRequestBuilder searchRequestBuilder= ElkConnector.transportClient().prepareSearch("products")
                .setTypes("product")
                .setQuery(QueryBuilders.matchAllQuery());
        searchService.addSearchText( "q");
        searchService.priceBounds(1d,2d);
        searchRequestBuilder=searchService.build();
        System.out.println(searchRequestBuilder);
    }
}
