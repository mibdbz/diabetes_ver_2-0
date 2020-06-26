package pl.mibdbz.diabetes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		Product theProduct = new Product();
		
		theModel.addAttribute("product", theProduct);
		
		return "product-add-form";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product theProduct) {
		
		productService.saveProduct(theProduct);
		
		return "redirect:/product/list";
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("productId") int theId, Model theModel) {
		
		Product theProduct = productService.getProduct(theId);
		
		theModel.addAttribute("product", theProduct);
		
		return "product-add-form";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("productId") int theId) {
		
		productService.deleteProduct(theId);
		
		return "redirect:/product/list";
	}
	
	@GetMapping("/search")
	public String searchProducts(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		
		List<Product> theProducts = productService.searchForProducts(theSearchName);
		
		theModel.addAttribute("products", theProducts);
		
		return "products-list";
	}
	
	@GetMapping("/insideForm")
	public String insideForm(@RequestParam("productId") int theId, Model theModel) {
		
		Product theProduct = productService.getProduct(theId);
		
		theModel.addAttribute("product", theProduct);
		
		return "product-inside";
	}
	
	
}
