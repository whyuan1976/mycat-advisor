package org.apache.mycat.advisor.persistence.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cjl on 2016/4/20.
 */
@Entity
@Table(name = "product_type", schema = "", catalog = "advisor")
public class ProductType {
	@Id
	@Column(name = "id", nullable = false, insertable = true, updatable = true)
	private Long id;
	private String typeName;
	private String typeCode;
	private Integer sort;
	private Timestamp insertTime;
	private Timestamp updateTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	 @Column(name = "type_name", nullable = true, insertable = true, updatable = true, length = 20) public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Basic @Column(name = "type_code", nullable = true, insertable = true, updatable = true, length = 20) public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	@Basic @Column(name = "sort", nullable = true, insertable = true, updatable = true) public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Basic @Column(name = "insert_time", nullable = true, insertable = true, updatable = true) public Timestamp getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}

	@Basic @Column(name = "update_time", nullable = true, insertable = true, updatable = true) public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ProductType that = (ProductType) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null)
			return false;
		if (typeCode != null ? !typeCode.equals(that.typeCode) : that.typeCode != null)
			return false;
		if (sort != null ? !sort.equals(that.sort) : that.sort != null)
			return false;
		if (insertTime != null ? !insertTime.equals(that.insertTime) : that.insertTime != null)
			return false;
		if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null)
			return false;

		return true;
	}

	@Override public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
		result = 31 * result + (typeCode != null ? typeCode.hashCode() : 0);
		result = 31 * result + (sort != null ? sort.hashCode() : 0);
		result = 31 * result + (insertTime != null ? insertTime.hashCode() : 0);
		result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
		return result;
	}
}
