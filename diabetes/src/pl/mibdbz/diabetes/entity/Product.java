package pl.mibdbz.diabetes.entity;



import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import pl.mibdbz.diabetes.validator.DoubleField;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull(message = "Obowiazkowe")
	@Size(min=1, message="Obowiazkowe")
	@Column(name = "name")
	private String name;
	
	@NotNull(message="Obowiazkowe")
	@Min(value=0, message="Nie moze byc ujemna")
	@Max(value=1000, message="Nie moze byc wieksza niz 1000")
	@Column(name = "kcal")
	private Integer kcal;
	
	@NotNull(message="Obowiazkowe")
	@Min(value=0, message="Nie moze byc ujemna")
	@Max(value=1000, message="Nie moze byc wieksza niz 1000")
	@Column(name = "carbohydrates")
	private BigDecimal carbohydrates;
	
	@NotNull(message="Obowiazkowe")
	@Min(value=0, message="Nie moze byc ujemna")
	@Max(value=1000, message="Nie moze byc wieksza niz 1000")
	@Column(name = "proteins")
	private BigDecimal proteins;
	
	@NotNull(message="Obowiazkowe")
	@Min(value=0, message="Nie moze byc ujemna")
	@Max(value=1000, message="Nie moze byc wieksza niz 1000")
	@Column(name = "fat")
	private BigDecimal fat;
	
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

	public Integer getKcal() {
		return kcal;
	}

	public void setKcal(Integer kcal) {
		this.kcal = kcal;
	}

	public BigDecimal getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(BigDecimal carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public BigDecimal getProteins() {
		return proteins;
	}

	public void setProteins(BigDecimal proteins) {
		this.proteins = proteins;
	}

	public BigDecimal getFat() {
		return fat;
	}

	public void setFat(BigDecimal fat) {
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
