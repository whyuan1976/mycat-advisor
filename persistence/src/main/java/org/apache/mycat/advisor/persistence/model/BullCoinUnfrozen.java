package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Created by cjl on 2016/4/20.
 */
@Entity
@Table(name = "bull_coin_unfrozen", schema = "", catalog = "advisor")
public class BullCoinUnfrozen {
	@Id
	@Column(name = "id", nullable = false, insertable = true, updatable = true)
	private Long id;
	private String operorigin;
	private String currencytype;
	private String serialno;
	private Date transactiondate;
	private String originalserialno;
	private Date originaltransactiondate;
	private Float abnmfrozen;
	private Float frozen;
	private Byte unfrozencause;
	private Date insertdate;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "operorigin", nullable = true, insertable = true, updatable = true, length = 1) public String getOperorigin() {
		return operorigin;
	}

	public void setOperorigin(String operorigin) {
		this.operorigin = operorigin;
	}

	 @Column(name = "currencytype", nullable = true, insertable = true, updatable = true, length = 1) public String getCurrencytype() {
		return currencytype;
	}

	public void setCurrencytype(String currencytype) {
		this.currencytype = currencytype;
	}

	 @Column(name = "serialno", nullable = false, insertable = true, updatable = true, length = 30) public String getSerialno() {
		return serialno;
	}

	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}

	 @Column(name = "transactiondate", nullable = false, insertable = true, updatable = true) public Date getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}

	 @Column(name = "originalserialno", nullable = false, insertable = true, updatable = true, length = 30) public String getOriginalserialno() {
		return originalserialno;
	}

	public void setOriginalserialno(String originalserialno) {
		this.originalserialno = originalserialno;
	}

	 @Column(name = "originaltransactiondate", nullable = false, insertable = true, updatable = true) public Date getOriginaltransactiondate() {
		return originaltransactiondate;
	}

	public void setOriginaltransactiondate(Date originaltransactiondate) {
		this.originaltransactiondate = originaltransactiondate;
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

	 @Column(name = "unfrozencause", nullable = true, insertable = true, updatable = true) public Byte getUnfrozencause() {
		return unfrozencause;
	}

	public void setUnfrozencause(Byte unfrozencause) {
		this.unfrozencause = unfrozencause;
	}

	 @Column(name = "insertdate", nullable = true, insertable = true, updatable = true) public Date getInsertdate() {
		return insertdate;
	}

	public void setInsertdate(Date insertdate) {
		this.insertdate = insertdate;
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		BullCoinUnfrozen that = (BullCoinUnfrozen) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		if (operorigin != null ? !operorigin.equals(that.operorigin) : that.operorigin != null)
			return false;
		if (currencytype != null ? !currencytype.equals(that.currencytype) : that.currencytype != null)
			return false;
		if (serialno != null ? !serialno.equals(that.serialno) : that.serialno != null)
			return false;
		if (transactiondate != null ? !transactiondate.equals(that.transactiondate) : that.transactiondate != null)
			return false;
		if (originalserialno != null ? !originalserialno.equals(that.originalserialno) : that.originalserialno != null)
			return false;
		if (originaltransactiondate != null ?
				!originaltransactiondate.equals(that.originaltransactiondate) :
				that.originaltransactiondate != null)
			return false;
		if (abnmfrozen != null ? !abnmfrozen.equals(that.abnmfrozen) : that.abnmfrozen != null)
			return false;
		if (frozen != null ? !frozen.equals(that.frozen) : that.frozen != null)
			return false;
		if (unfrozencause != null ? !unfrozencause.equals(that.unfrozencause) : that.unfrozencause != null)
			return false;
		if (insertdate != null ? !insertdate.equals(that.insertdate) : that.insertdate != null)
			return false;

		return true;
	}

	@Override public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (operorigin != null ? operorigin.hashCode() : 0);
		result = 31 * result + (currencytype != null ? currencytype.hashCode() : 0);
		result = 31 * result + (serialno != null ? serialno.hashCode() : 0);
		result = 31 * result + (transactiondate != null ? transactiondate.hashCode() : 0);
		result = 31 * result + (originalserialno != null ? originalserialno.hashCode() : 0);
		result = 31 * result + (originaltransactiondate != null ? originaltransactiondate.hashCode() : 0);
		result = 31 * result + (abnmfrozen != null ? abnmfrozen.hashCode() : 0);
		result = 31 * result + (frozen != null ? frozen.hashCode() : 0);
		result = 31 * result + (unfrozencause != null ? unfrozencause.hashCode() : 0);
		result = 31 * result + (insertdate != null ? insertdate.hashCode() : 0);
		return result;
	}
}
