package pl.mibdbz.diabetes.controller;


import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.mibdbz.diabetes.entity.Exchangers;
import pl.mibdbz.diabetes.entity.Product;
import pl.mibdbz.diabetes.service.CalculateService;
import pl.mibdbz.diabetes.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CalculateService calculateService;
	
	private Product productForCalculating;
	
	@Value("#{typesOptions}") 
	private Map<String, String> typesOptions;
	
	
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	

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
		
		theModel.addAttribute("typesOptions", typesOptions);
		
		return "product-add-form";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@Valid @ModelAttribute("product") Product theProduct, BindingResult bindingResult, Model theModel) {
		
		theModel.addAttribute("typesOptions", typesOptions);
		
		System.out.println("Binding result: " + bindingResult);
		
		if(bindingResult.hasErrors()) {
			return "product-add-form";
		} else {
		
		productService.saveProduct(theProduct);
		
		return "redirect:/product/list";
		}
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("productId") int theId, Model theModel) {
		
		Product theProduct = productService.getProduct(theId);
		
		theModel.addAttribute("product", theProduct);
		
		theModel.addAttribute("typesOptions", typesOptions);
		
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
		
		productForCalculating = productService.getProduct(theId);
		
		theModel.addAttribute("product", productForCalculating);
		
		return "product-inside";
	}
	
	@GetMapping("/howMuchGrams")
	public String howMuchGrams(@RequestParam("numberOfGrams") int grams, Model theModel) {
		
		Exchangers exchangers = calculateService.calculateExchangers(grams, productForCalculating);
		
		System.out.println(exchangers);
		
		Product gramsOfProduct = calculateService.calculateProductGrams(grams, productForCalculating);
		
		theModel.addAttribute("product", gramsOfProduct);		
		theModel.addAttribute("exchangers", exchangers);
		theModel.addAttribute("grams", grams);
		
		return "show-exchangers";
	}
	
	
	
}
