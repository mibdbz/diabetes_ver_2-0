package pl.mibdbz.diabetes.entity;


public class Exchangers {

	private double Carbohydrates;
	
	private double ProteinAndFat;
	
	
	
	public Exchangers() {
		
	}
	
	

	public Exchangers(double carbohydrates, double proteinAndFat) {
		Carbohydrates = carbohydrates;
		ProteinAndFat = proteinAndFat;
	}



	public double getCarbohydrates() {
		return Carbohydrates;
	}

	public void setCarbohydrates(double carbohydrates) {
		Carbohydrates = carbohydrates;
	}

	public double getProteinAndFat() {
		return ProteinAndFat;
	}

	public void setProteinAndFat(double proteinAndFat) {
		ProteinAndFat = proteinAndFat;
	}



	@Override
	public String toString() {
		return "Exchangers [Carbohydrates=" + Carbohydrates + ", ProteinAndFat=" + ProteinAndFat + "]";
	}
	

	
	
}
