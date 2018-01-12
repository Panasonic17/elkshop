package shop.controller.testing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.entity.product.Product;
import shop.services.get.GetNProducts;

@Controller
public class ProductsController {
    @Autowired
    GetNProducts getNProducts;

    @RequestMapping("/products")
    public String welcome(ModelMap map, @RequestParam(value="n", required=false, defaultValue="10") Integer n) {
        Product p[] = getNProducts.getProducts(n);
        map.put("products", p);
        return "showAllProducts";
    }
}
