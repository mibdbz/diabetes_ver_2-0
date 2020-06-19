package pl.mibdbz.diabetes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.mibdbz.diabetes.dao.ProductDAO;
import pl.mibdbz.diabetes.entity.Product;
import pl.mibdbz.diabetes.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/list")
	public String productsList(Model theModel) {
		
		List<Product> theProducts = productService.getProducts();
		
		theModel.addAttribute("products", theProducts);
		
		return "products-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		
		return "product-add-form";
	}
	
}
