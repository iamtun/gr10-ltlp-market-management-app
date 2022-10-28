package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_types")
public class ProductType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "product_type_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "type_name", nullable = false, columnDefinition = "nvarchar(255)")
	private String name;

	@Column(nullable = false, columnDefinition = "nvarchar(255)")
	private String unit;

	public ProductType(String name, String unit) {
		super();
		this.name = name;
		this.unit = unit;
	}

	public ProductType() {
		super();
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ProductType [id=" + id + ", name=" + name + ", unit=" + unit + "]";
	}

}
