package shop.controller;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.entity.product.Product;
import shop.services.get.GetProducts;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Slider {

    @Autowired
    GetProducts getProducts;
    @Autowired
    TransportClient client;


    private int size = 10;
    @RequestMapping("/show")
//    @Scope("session") // ???????????
    public String welcome(HttpServletRequest request, ModelMap map, @RequestParam(value = "from", required = false, defaultValue = "0") Integer from) {
        System.out.println("qq");

        SearchRequestBuilder searchRequestBuilder = (SearchRequestBuilder) request.getSession().getAttribute("searchRequestBuilder");
        System.out.println(searchRequestBuilder);
        if(searchRequestBuilder==null){
            searchRequestBuilder=client.prepareSearch("products")
                    .setTypes("product")
                    .setQuery(QueryBuilders.matchAllQuery());
            request.getSession().setAttribute("searchRequestBuilder",searchRequestBuilder);
        }
        searchRequestBuilder.setSize(size).setFrom(from);

        Product p[] = getProducts.getProducts(searchRequestBuilder);
        map.put("products", p);
        map.put("next", from + size);
        return "show";
    }
}
