package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by cjl on 2016/4/20.
 */
@Entity
@Table(name = "product_step_tpl", schema = "", catalog = "advisor")
public class ProductStepTpl {
	@Id
	@Column(name = "id", nullable = false, insertable = true, updatable = true)
	private Long id;
	private Long productId;
	private Integer step;
	private String stepTitle;
	private Timestamp insertTime;
	private Timestamp updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	 @Column(name = "product_id", nullable = true, insertable = true, updatable = true) public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	 @Column(name = "step", nullable = true, insertable = true, updatable = true) public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	 @Column(name = "step_title", nullable = true, insertable = true, updatable = true, length = 50) public String getStepTitle() {
		return stepTitle;
	}

	public void setStepTitle(String stepTitle) {
		this.stepTitle = stepTitle;
	}

	 @Column(name = "insert_time", nullable = true, insertable = true, updatable = true) public Timestamp getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}

	 @Column(name = "update_time", nullable = true, insertable = true, updatable = true) public Timestamp getUpdateTime() {
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

		ProductStepTpl that = (ProductStepTpl) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		if (productId != null ? !productId.equals(that.productId) : that.productId != null)
			return false;
		if (step != null ? !step.equals(that.step) : that.step != null)
			return false;
		if (stepTitle != null ? !stepTitle.equals(that.stepTitle) : that.stepTitle != null)
			return false;
		if (insertTime != null ? !insertTime.equals(that.insertTime) : that.insertTime != null)
			return false;
		if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null)
			return false;

		return true;
	}

	@Override public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (productId != null ? productId.hashCode() : 0);
		result = 31 * result + (step != null ? step.hashCode() : 0);
		result = 31 * result + (stepTitle != null ? stepTitle.hashCode() : 0);
		result = 31 * result + (insertTime != null ? insertTime.hashCode() : 0);
		result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
		return result;
	}
}
