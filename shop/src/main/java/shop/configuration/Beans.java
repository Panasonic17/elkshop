package shop.configuration;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;



@Configuration
public class Beans {
    @Autowired
    TransportClient client;

    @Bean
    @Scope("prototype")
    public SearchRequestBuilder searchRequestBuilder() {
        return client.prepareSearch("products").setTypes("product");
    }

    @Bean
    @Scope("prototype")
    public BoolQueryBuilder boolQueryBuilder() {
        return  new BoolQueryBuilder();
    }
}
