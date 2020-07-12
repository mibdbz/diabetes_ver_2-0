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
	
	private double calculateProteinsAndFat(int grams, Product tempProduct) {
		
		double numberOfProteins = (grams * tempProduct.getProteins()) / 100;
		double numberOfFat = (grams * tempProduct.getFat()) / 100;
		
		double proteinExchanger = numberOfProteins * 4;
		double fatExchanger = numberOfFat * 9;
		
		double proteinsAndFatExchanger = (proteinExchanger + fatExchanger) / 100;
		
		return rounding(proteinsAndFatExchanger);
	}

	public Product calculateProductGrams(int grams, Product productForCalculating) {
		
		Product tempProduct = new Product();
		
		BigDecimal temp = productForCalculating.getCarbohydrates();
		temp = temp.multiply(new BigDecimal(grams));
		temp = temp.divide(new BigDecimal(100));
				
		//tempProduct.setCarbohydrates(rounding(temp));
		
		tempProduct.setKcal((productForCalculating.getKcal() * grams) / 100);
		
		double anotherTemp = (productForCalculating.getProteins() * grams) / 100;
		tempProduct.setProteins(rounding(anotherTemp));
		
		anotherTemp = (productForCalculating.getFat() * grams) / 100;
		tempProduct.setFat(rounding(anotherTemp));
		
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
