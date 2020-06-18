package pl.mibdbz.diabetes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.mibdbz.diabetes.dao.ProductDAO;
import pl.mibdbz.diabetes.entity.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductDAO productDAO;
	

	@RequestMapping("/list")
	public String productsList(Model theModel) {
		
		List<Product> theProducts = productDAO.getProducts();
		
		theModel.addAttribute("products", theProducts);
		
		return "products-list";
	}
}
