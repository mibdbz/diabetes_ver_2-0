package pl.mibdbz.diabetes.service;

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
	
	private double calculateCarbo(int grams, Product tempProduct) {
		
		double numberOfCarbo = (grams * tempProduct.getCarbohydrates()) / 100;
		
		double carboExchanger = numberOfCarbo / 10;
		
		carboExchanger *= 100;
		
		carboExchanger = Math.round(carboExchanger);
		
		carboExchanger /= 100;
		
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
		
		double temp = (productForCalculating.getCarbohydrates() * grams) / 100;
		tempProduct.setCarbohydrates(rounding(temp));
		
		tempProduct.setKcal((productForCalculating.getKcal() * grams) / 100);
		
		temp = (productForCalculating.getProteins() * grams) / 100;
		tempProduct.setProteins(rounding(temp));
		
		temp = (productForCalculating.getFat() * grams) / 100;
		tempProduct.setFat(rounding(temp));
		
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
