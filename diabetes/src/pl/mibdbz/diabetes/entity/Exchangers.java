package pl.mibdbz.diabetes.entity;

import java.math.BigDecimal;

public class Exchangers {

	private BigDecimal carbohydrates;
	
	private double proteinAndFat;
	
	
	
	public Exchangers() {
		
	}
	
	

	public Exchangers(BigDecimal carbohydrates, double proteinAndFat) {
		this.carbohydrates = carbohydrates;
		this.proteinAndFat = proteinAndFat;
	}



	public BigDecimal getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(BigDecimal carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public double getProteinAndFat() {
		return proteinAndFat;
	}

	public void setProteinAndFat(double proteinAndFat) {
		this.proteinAndFat = proteinAndFat;
	}



	@Override
	public String toString() {
		return "Exchangers [Carbohydrates=" + carbohydrates + ", ProteinAndFat=" + proteinAndFat + "]";
	}
	

	
	
}
