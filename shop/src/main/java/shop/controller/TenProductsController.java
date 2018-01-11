package shop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import shop.entity.product.Product;
import shop.test.features.getAllBattareis;

@Controller
public class TenProductsController {
    @RequestMapping("/tenProducts")
    public String welcome(ModelMap map) {
        getAllBattareis.doSnth(); //b= new getAllBattareis();

        System.out.println("heresdw");
        Product p[] = new Product[10];
        Product product = new Product();
        product.productId = 333;
        product.sku = 444;
        for (int i = 0; i <10 ; i++) {
            p[i]=product;
        }
//        p[0] = product;
//        p[3] = product;

        map.put("products", p);
        return "tenProd";
    }
}
