package shop.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class WelcomeController {

	@RequestMapping("/w")
	public String welcome(ModelMap map) {
		map.put("currentDate", new Date());
		return "welcome";
	}
	@RequestMapping("/wd")
	public String welcome1(ModelMap map) {
		map.put("currentDate", new Date());
		return "welcome1";
	}
}