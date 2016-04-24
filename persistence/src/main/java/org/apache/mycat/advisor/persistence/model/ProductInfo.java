package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by cjl on 2016/4/20.
 */
@Entity
@Table(name = "product_info", schema = "", catalog = "advisor")
public class ProductInfo {
	@Id
	@Column(name = "id", nullable = false, insertable = true, updatable = true)
	private Long id;
	private String name;
	private String title;
	private Long type;
	private Float price;
	private String unit;
	private String businessArea;
	private String technologyArea;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	 @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 50) public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 @Column(name = "title", nullable = true, insertable = true, updatable = true, length = 50) public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	 @Column(name = "type", nullable = true, insertable = true, updatable = true) public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	 @Column(name = "price", nullable = true, insertable = true, updatable = true, precision = 0) public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	 @Column(name = "unit", nullable = true, insertable = true, updatable = true, length = 20) public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	 @Column(name = "business_area", nullable = true, insertable = true, updatable = true, length = 100) public String getBusinessArea() {
		return businessArea;
	}

	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}

	 @Column(name = "technology_area", nullable = true, insertable = true, updatable = true, length = 100) public String getTechnologyArea() {
		return technologyArea;
	}

	public void setTechnologyArea(String technologyArea) {
		this.technologyArea = technologyArea;
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ProductInfo that = (ProductInfo) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		if (name != null ? !name.equals(that.name) : that.name != null)
			return false;
		if (title != null ? !title.equals(that.title) : that.title != null)
			return false;
		if (type != null ? !type.equals(that.type) : that.type != null)
			return false;
		if (price != null ? !price.equals(that.price) : that.price != null)
			return false;
		if (unit != null ? !unit.equals(that.unit) : that.unit != null)
			return false;
		if (businessArea != null ? !businessArea.equals(that.businessArea) : that.businessArea != null)
			return false;
		if (technologyArea != null ? !technologyArea.equals(that.technologyArea) : that.technologyArea != null)
			return false;

		return true;
	}

	@Override public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (price != null ? price.hashCode() : 0);
		result = 31 * result + (unit != null ? unit.hashCode() : 0);
		result = 31 * result + (businessArea != null ? businessArea.hashCode() : 0);
		result = 31 * result + (technologyArea != null ? technologyArea.hashCode() : 0);
		return result;
	}
}
