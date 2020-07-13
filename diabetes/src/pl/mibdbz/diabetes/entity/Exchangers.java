package pl.mibdbz.diabetes.entity;

import java.math.BigDecimal;

public class Exchangers {

	private BigDecimal carbohydrates;
	
	private BigDecimal proteinAndFat;
	
	
	
	public Exchangers() {
		
	}
	
	

	public Exchangers(BigDecimal carbohydrates, BigDecimal proteinAndFat) {
		this.carbohydrates = carbohydrates;
		this.proteinAndFat = proteinAndFat;
	}



	public BigDecimal getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(BigDecimal carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public BigDecimal getProteinAndFat() {
		return proteinAndFat;
	}

	public void setProteinAndFat(BigDecimal proteinAndFat) {
		this.proteinAndFat = proteinAndFat;
	}



	@Override
	public String toString() {
		return "Exchangers [Carbohydrates=" + carbohydrates + ", ProteinAndFat=" + proteinAndFat + "]";
	}
	

	
	
}
