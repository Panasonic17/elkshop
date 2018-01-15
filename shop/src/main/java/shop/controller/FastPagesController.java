package shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.entity.product.Product;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Oleksandr_Shainoga on 1/15/2018.
 */
@Controller
public class FastPagesController {

    @RequestMapping("/searchPage")
    public String welcome() {
        return "searchPage";
    }

    @RequestMapping("/startComplexSearch")
    public String complexSearch() {
        return "complexSearch";
    }
}
