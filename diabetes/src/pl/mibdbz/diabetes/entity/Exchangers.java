package pl.mibdbz.diabetes.entity;


public class Exchangers {

	private double carbohydrates;
	
	private double proteinAndFat;
	
	
	
	public Exchangers() {
		
	}
	
	

	public Exchangers(double carbohydrates, double proteinAndFat) {
		this.carbohydrates = carbohydrates;
		this.proteinAndFat = proteinAndFat;
	}



	public double getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(double carbohydrates) {
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
