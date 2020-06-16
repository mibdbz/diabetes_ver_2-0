package pl.mibdbz.diabetes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

	@RequestMapping("/list")
	public String productsList(Model theModel) {
		
		return "products-list";
	}
}
