package shop.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class WelcomeController {

    @RequestMapping("/")
    public String welcome(ModelMap map, HttpServletRequest request) {
        System.out.println(request.getAttribute("name"));
        map.put("currentDate", new Date());
        return "welcome";
    }
}