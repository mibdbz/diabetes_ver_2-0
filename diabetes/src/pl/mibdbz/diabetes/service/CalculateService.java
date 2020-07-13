package pl.mibdbz.diabetes.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import pl.mibdbz.diabetes.entity.Exchangers;
import pl.mibdbz.diabetes.entity.Product;

@Service
public class CalculateService {

	public Exchangers calculateExchangers(int grams, Product tempProduct) {
		
		Exchangers exc = new Exchangers();
		
		exc.setCarbohydrates(calculateCarbo(grams, tempProduct));
		
		exc.setProteinAndFat(calculateProteinsAndFat(grams, tempProduct));
		
		return exc;
	}
	
	private BigDecimal calculateCarbo(int grams, Product tempProduct) {
		
		BigDecimal numberOfCarbo = tempProduct.getCarbohydrates();
				numberOfCarbo = (numberOfCarbo.multiply(new BigDecimal(grams)));
				numberOfCarbo = numberOfCarbo.divide(new BigDecimal(100));
		
		BigDecimal carboExchanger = numberOfCarbo.divide(new BigDecimal(10));
		
		/*carboExchanger *= 100;
		
		carboExchanger = Math.round(carboExchanger);
		
		carboExchanger /= 100;*/
		
		return carboExchanger;
	}
	
	private BigDecimal calculateProteinsAndFat(int grams, Product tempProduct) {
		
		BigDecimal numberOfProteins = tempProduct.getProteins();
				   numberOfProteins = numberOfProteins.multiply(new BigDecimal(grams));
				   numberOfProteins = numberOfProteins.divide(new BigDecimal(100));
				
		BigDecimal numberOfFat = tempProduct.getFat();
				   numberOfFat = numberOfFat.multiply(new BigDecimal(grams));
				   numberOfFat = numberOfFat.divide(new BigDecimal(100));
		
		BigDecimal proteinExchanger = numberOfProteins.multiply(new BigDecimal(4));
		
		BigDecimal fatExchanger = numberOfFat.multiply(new BigDecimal(9));
		
		BigDecimal proteinsAndFatExchanger = (proteinExchanger.add(fatExchanger));
				   proteinsAndFatExchanger = proteinsAndFatExchanger.divide(new BigDecimal(100));
		
		//return rounding(proteinsAndFatExchanger);
		return proteinsAndFatExchanger;
	}

	public Product calculateProductGrams(int grams, Product productForCalculating) {
		
		Product tempProduct = new Product();
		
		BigDecimal temp = productForCalculating.getCarbohydrates();
				   temp = temp.multiply(new BigDecimal(grams));
				   temp = temp.divide(new BigDecimal(100));
				
		//tempProduct.setCarbohydrates(rounding(temp));
		
		tempProduct.setKcal((productForCalculating.getKcal() * grams) / 100);
		
				   temp = productForCalculating.getProteins();
				   temp = temp.multiply(new BigDecimal(grams));
				   temp = temp.divide(new BigDecimal(100));
				   
		tempProduct.setProteins(temp);
		
		temp = productForCalculating.getFat();
		temp = temp.multiply(new BigDecimal(grams));
		temp = temp.divide(new BigDecimal(100));
		
		tempProduct.setFat(temp);
		
		tempProduct.setName(productForCalculating.getName());
		tempProduct.setId(productForCalculating.getId());
		tempProduct.setType(productForCalculating.getType());
		
		return tempProduct;
	}
	
	private double rounding(double tempDouble) {
		
		tempDouble *= 100;
		
		tempDouble = Math.round(tempDouble);
		
		tempDouble /= 100;

		return tempDouble;
	}
	
	
}
