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
@Table(name = "order_setp", schema = "", catalog = "advisor")
public class OrderSetp {
	@Id
	@Column(name = "id", nullable = false, insertable = true, updatable = true)
	private Long id;
	private Long orderId;
	private Long stepId;
	private Timestamp insertTime;
	private Timestamp updateTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	 @Column(name = "order_id", nullable = true, insertable = true, updatable = true) public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	 @Column(name = "step_id", nullable = true, insertable = true, updatable = true) public Long getStepId() {
		return stepId;
	}

	public void setStepId(Long stepId) {
		this.stepId = stepId;
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

		OrderSetp orderSetp = (OrderSetp) o;

		if (id != null ? !id.equals(orderSetp.id) : orderSetp.id != null)
			return false;
		if (orderId != null ? !orderId.equals(orderSetp.orderId) : orderSetp.orderId != null)
			return false;
		if (stepId != null ? !stepId.equals(orderSetp.stepId) : orderSetp.stepId != null)
			return false;
		if (insertTime != null ? !insertTime.equals(orderSetp.insertTime) : orderSetp.insertTime != null)
			return false;
		if (updateTime != null ? !updateTime.equals(orderSetp.updateTime) : orderSetp.updateTime != null)
			return false;

		return true;
	}

	@Override public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
		result = 31 * result + (stepId != null ? stepId.hashCode() : 0);
		result = 31 * result + (insertTime != null ? insertTime.hashCode() : 0);
		result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
		return result;
	}
}
