package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by cjl on 2016/4/20.
 */
@Entity
@Table(name = "bull_coin_positions", schema = "", catalog = "advisor")
public class BullCoinPositions {
	@Id
	@Column(name = "id", nullable = false, insertable = true, updatable = true)
	private Long id;
	private String currencytype;
	private Float balance;
	private Float abnmfrozen;
	private Float frozen;
	private Byte status;
	private Date insertdate;
	private Timestamp lastupdatetime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	 @Column(name = "currencytype", nullable = true, insertable = true, updatable = true, length = 1) public String getCurrencytype() {
		return currencytype;
	}

	public void setCurrencytype(String currencytype) {
		this.currencytype = currencytype;
	}

	 @Column(name = "balance", nullable = true, insertable = true, updatable = true, precision = 2) public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	 @Column(name = "abnmfrozen", nullable = true, insertable = true, updatable = true, precision = 2) public Float getAbnmfrozen() {
		return abnmfrozen;
	}

	public void setAbnmfrozen(Float abnmfrozen) {
		this.abnmfrozen = abnmfrozen;
	}

	 @Column(name = "frozen", nullable = true, insertable = true, updatable = true, precision = 2) public Float getFrozen() {
		return frozen;
	}

	public void setFrozen(Float frozen) {
		this.frozen = frozen;
	}

	 @Column(name = "status", nullable = true, insertable = true, updatable = true) public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	 @Column(name = "insertdate", nullable = true, insertable = true, updatable = true) public Date getInsertdate() {
		return insertdate;
	}

	public void setInsertdate(Date insertdate) {
		this.insertdate = insertdate;
	}

	 @Column(name = "lastupdatetime", nullable = false, insertable = true, updatable = true) public Timestamp getLastupdatetime() {
		return lastupdatetime;
	}

	public void setLastupdatetime(Timestamp lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		BullCoinPositions that = (BullCoinPositions) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		if (currencytype != null ? !currencytype.equals(that.currencytype) : that.currencytype != null)
			return false;
		if (balance != null ? !balance.equals(that.balance) : that.balance != null)
			return false;
		if (abnmfrozen != null ? !abnmfrozen.equals(that.abnmfrozen) : that.abnmfrozen != null)
			return false;
		if (frozen != null ? !frozen.equals(that.frozen) : that.frozen != null)
			return false;
		if (status != null ? !status.equals(that.status) : that.status != null)
			return false;
		if (insertdate != null ? !insertdate.equals(that.insertdate) : that.insertdate != null)
			return false;
		if (lastupdatetime != null ? !lastupdatetime.equals(that.lastupdatetime) : that.lastupdatetime != null)
			return false;

		return true;
	}

	@Override public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (currencytype != null ? currencytype.hashCode() : 0);
		result = 31 * result + (balance != null ? balance.hashCode() : 0);
		result = 31 * result + (abnmfrozen != null ? abnmfrozen.hashCode() : 0);
		result = 31 * result + (frozen != null ? frozen.hashCode() : 0);
		result = 31 * result + (status != null ? status.hashCode() : 0);
		result = 31 * result + (insertdate != null ? insertdate.hashCode() : 0);
		result = 31 * result + (lastupdatetime != null ? lastupdatetime.hashCode() : 0);
		return result;
	}
}
