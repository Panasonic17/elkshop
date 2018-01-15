package shop.controller.saerch;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.entity.product.Product;
import shop.services.get.GetProducts;
import shop.services.searchService.SearchService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SearchController {

    @Autowired
    SearchService searchService;
    @Autowired
    GetProducts getProducts;
    @Autowired
    TransportClient client;

    @RequestMapping("/textSearch")
    public String textSearch(HttpServletRequest request, ModelMap map, @RequestParam(value = "texstSearch") String texstSearch) {
        searchService.addSearchText(texstSearch);
        SearchRequestBuilder searchRequestBuilder=searchService.build();
        Product p[] = getProducts.getProducts(searchRequestBuilder);
        map.put("products", p);
        return "show";
    }

    @RequestMapping("/complexSearch")
    public String complexSearch(HttpServletRequest request, ModelMap map, @RequestParam(value = "texstSearch") String texstSearch,
                          @RequestParam(value = "min", required=false) Double min,
                          @RequestParam(value = "max", required=false) Double max) {

        if(!texstSearch.equals(""))
        searchService.addSearchText(texstSearch);
        if(min!=null&&max!=null)
        searchService.priceBounds(min,max);

        SearchRequestBuilder searchRequestBuilder=searchService.build();
        request.getSession().setAttribute("searchRequestBuilder",searchRequestBuilder);
        Product p[] = getProducts.getProducts(searchRequestBuilder);
        map.put("products", p);
        return "show";
    }

}
