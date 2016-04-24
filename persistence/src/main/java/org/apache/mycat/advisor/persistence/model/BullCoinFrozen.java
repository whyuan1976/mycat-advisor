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
@Table(name = "bull_coin_frozen", schema = "", catalog = "advisor")
public class BullCoinFrozen {
	@Id
	@Column(name = "id", nullable = false, insertable = true, updatable = true) public Long getId() {
		return id;
	}

	private Long id;


	public void setId(Long id) {
		this.id = id;
	}

	private String operorigin;

	 @Column(name = "operorigin", nullable = true, insertable = true, updatable = true, length = 1) public String getOperorigin() {
		return operorigin;
	}

	public void setOperorigin(String operorigin) {
		this.operorigin = operorigin;
	}

	private String currencytype;

	 @Column(name = "currencytype", nullable = true, insertable = true, updatable = true, length = 1) public String getCurrencytype() {
		return currencytype;
	}

	public void setCurrencytype(String currencytype) {
		this.currencytype = currencytype;
	}

	private String confirmnumber;

	 @Column(name = "confirmnumber", nullable = true, insertable = true, updatable = true, length = 32) public String getConfirmnumber() {
		return confirmnumber;
	}

	public void setConfirmnumber(String confirmnumber) {
		this.confirmnumber = confirmnumber;
	}

	private Date confirmdate;

	 @Column(name = "confirmdate", nullable = true, insertable = true, updatable = true) public Date getConfirmdate() {
		return confirmdate;
	}

	public void setConfirmdate(Date confirmdate) {
		this.confirmdate = confirmdate;
	}

	private String serialno;

	 @Column(name = "serialno", nullable = true, insertable = true, updatable = true, length = 30) public String getSerialno() {
		return serialno;
	}

	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}

	private Date transactiondate;

	 @Column(name = "transactiondate", nullable = true, insertable = true, updatable = true) public Date getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}

	private Float abnmfrozen;

	 @Column(name = "abnmfrozen", nullable = true, insertable = true, updatable = true, precision = 2) public Float getAbnmfrozen() {
		return abnmfrozen;
	}

	public void setAbnmfrozen(Float abnmfrozen) {
		this.abnmfrozen = abnmfrozen;
	}

	private Float frozen;

	 @Column(name = "frozen", nullable = true, insertable = true, updatable = true, precision = 2) public Float getFrozen() {
		return frozen;
	}

	public void setFrozen(Float frozen) {
		this.frozen = frozen;
	}

	private Float abnmunfrozen;

	 @Column(name = "abnmunfrozen", nullable = true, insertable = true, updatable = true, precision = 2) public Float getAbnmunfrozen() {
		return abnmunfrozen;
	}

	public void setAbnmunfrozen(Float abnmunfrozen) {
		this.abnmunfrozen = abnmunfrozen;
	}

	private Byte frozencause;

	 @Column(name = "frozencause", nullable = true, insertable = true, updatable = true) public Byte getFrozencause() {
		return frozencause;
	}

	public void setFrozencause(Byte frozencause) {
		this.frozencause = frozencause;
	}

	private Date frozendeadline;

	 @Column(name = "frozendeadline", nullable = true, insertable = true, updatable = true) public Date getFrozendeadline() {
		return frozendeadline;
	}

	public void setFrozendeadline(Date frozendeadline) {
		this.frozendeadline = frozendeadline;
	}

	private String specification;

	 @Column(name = "specification", nullable = true, insertable = true, updatable = true, length = 512) public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	private Date insertdate;

	 @Column(name = "insertdate", nullable = true, insertable = true, updatable = true) public Date getInsertdate() {
		return insertdate;
	}

	public void setInsertdate(Date insertdate) {
		this.insertdate = insertdate;
	}

	private Timestamp lastupdatetime;

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

		BullCoinFrozen that = (BullCoinFrozen) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		if (operorigin != null ? !operorigin.equals(that.operorigin) : that.operorigin != null)
			return false;
		if (currencytype != null ? !currencytype.equals(that.currencytype) : that.currencytype != null)
			return false;
		if (confirmnumber != null ? !confirmnumber.equals(that.confirmnumber) : that.confirmnumber != null)
			return false;
		if (confirmdate != null ? !confirmdate.equals(that.confirmdate) : that.confirmdate != null)
			return false;
		if (serialno != null ? !serialno.equals(that.serialno) : that.serialno != null)
			return false;
		if (transactiondate != null ? !transactiondate.equals(that.transactiondate) : that.transactiondate != null)
			return false;
		if (abnmfrozen != null ? !abnmfrozen.equals(that.abnmfrozen) : that.abnmfrozen != null)
			return false;
		if (frozen != null ? !frozen.equals(that.frozen) : that.frozen != null)
			return false;
		if (abnmunfrozen != null ? !abnmunfrozen.equals(that.abnmunfrozen) : that.abnmunfrozen != null)
			return false;
		if (frozencause != null ? !frozencause.equals(that.frozencause) : that.frozencause != null)
			return false;
		if (frozendeadline != null ? !frozendeadline.equals(that.frozendeadline) : that.frozendeadline != null)
			return false;
		if (specification != null ? !specification.equals(that.specification) : that.specification != null)
			return false;
		if (insertdate != null ? !insertdate.equals(that.insertdate) : that.insertdate != null)
			return false;
		if (lastupdatetime != null ? !lastupdatetime.equals(that.lastupdatetime) : that.lastupdatetime != null)
			return false;

		return true;
	}

	@Override public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (operorigin != null ? operorigin.hashCode() : 0);
		result = 31 * result + (currencytype != null ? currencytype.hashCode() : 0);
		result = 31 * result + (confirmnumber != null ? confirmnumber.hashCode() : 0);
		result = 31 * result + (confirmdate != null ? confirmdate.hashCode() : 0);
		result = 31 * result + (serialno != null ? serialno.hashCode() : 0);
		result = 31 * result + (transactiondate != null ? transactiondate.hashCode() : 0);
		result = 31 * result + (abnmfrozen != null ? abnmfrozen.hashCode() : 0);
		result = 31 * result + (frozen != null ? frozen.hashCode() : 0);
		result = 31 * result + (abnmunfrozen != null ? abnmunfrozen.hashCode() : 0);
		result = 31 * result + (frozencause != null ? frozencause.hashCode() : 0);
		result = 31 * result + (frozendeadline != null ? frozendeadline.hashCode() : 0);
		result = 31 * result + (specification != null ? specification.hashCode() : 0);
		result = 31 * result + (insertdate != null ? insertdate.hashCode() : 0);
		result = 31 * result + (lastupdatetime != null ? lastupdatetime.hashCode() : 0);
		return result;
	}
}
