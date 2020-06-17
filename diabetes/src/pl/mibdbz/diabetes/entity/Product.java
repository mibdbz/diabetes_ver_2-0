package pl.mibdbz.diabetes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "kcal")
	private int kcal;
	
	@Column(name = "carbohydrates")
	private double carbohydrates;
	
	@Column(name = "proteins")
	private double proteins;
	
	@Column(name = "fat")
	private double fat;
	
	@Column(name = "type")
	private String type;
	
	
	
	public Product() {
		
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	public double getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(double carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public double getProteins() {
		return proteins;
	}

	public void setProteins(double proteins) {
		this.proteins = proteins;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", kcal=" + kcal + ", carbohydrates=" + carbohydrates
				+ ", proteins=" + proteins + ", fat=" + fat + ", type=" + type + "]";
	}
	

	
	
	
	
	
}
