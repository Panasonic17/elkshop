package shop.controller.testing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import shop.entity.product.Product;
import shop.services.get.GetTenProducts;

@Controller
public class TenProductsController {
    @Autowired
    GetTenProducts getTenProducts;

    @RequestMapping("/tenProducts")

    public String welcome(ModelMap map) {
//        RangeSelect.main(null);

        System.out.println("heresdw");
        Product p[] = getTenProducts.getTenProducts();

//        p[0] = product;
//        p[3] = product;

        map.put("products", p);
        return "tenProd";
    }
}
