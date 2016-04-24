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
@Table(name = "bull_coin_chg", schema = "", catalog = "advisor")
public class BullCoinChg {
	@Id
	@Column(name = "id", nullable = false, insertable = true, updatable = true) public Long getId() {
		return id;
	}
	private Long id;



	public void setId(Long id) {
		this.id = id;
	}

	private String currencytype;

	 @Column(name = "currencytype", nullable = true, insertable = true, updatable = true, length = 1) public String getCurrencytype() {
		return currencytype;
	}

	public void setCurrencytype(String currencytype) {
		this.currencytype = currencytype;
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

	private String channelno;

	 @Column(name = "channelno", nullable = true, insertable = true, updatable = true, length = 16) public String getChannelno() {
		return channelno;
	}

	public void setChannelno(String channelno) {
		this.channelno = channelno;
	}

	private String branchbank;

	 @Column(name = "branchbank", nullable = true, insertable = true, updatable = true, length = 128) public String getBranchbank() {
		return branchbank;
	}

	public void setBranchbank(String branchbank) {
		this.branchbank = branchbank;
	}

	private String payaccount;

	 @Column(name = "payaccount", nullable = true, insertable = true, updatable = true, length = 64) public String getPayaccount() {
		return payaccount;
	}

	public void setPayaccount(String payaccount) {
		this.payaccount = payaccount;
	}

	private String paybank;

	 @Column(name = "paybank", nullable = true, insertable = true, updatable = true, length = 128) public String getPaybank() {
		return paybank;
	}

	public void setPaybank(String paybank) {
		this.paybank = paybank;
	}

	private String businesscode;

	 @Column(name = "businesscode", nullable = true, insertable = true, updatable = true, length = 4) public String getBusinesscode() {
		return businesscode;
	}

	public void setBusinesscode(String businesscode) {
		this.businesscode = businesscode;
	}

	private Float lastamount;

	 @Column(name = "lastamount", nullable = true, insertable = true, updatable = true, precision = 2) public Float getLastamount() {
		return lastamount;
	}

	public void setLastamount(Float lastamount) {
		this.lastamount = lastamount;
	}

	private Float confirmedamount;

	 @Column(name = "confirmedamount", nullable = true, insertable = true, updatable = true, precision = 2) public Float getConfirmedamount() {
		return confirmedamount;
	}

	public void setConfirmedamount(Float confirmedamount) {
		this.confirmedamount = confirmedamount;
	}

	private Float afteramount;

	 @Column(name = "afteramount", nullable = true, insertable = true, updatable = true, precision = 2) public Float getAfteramount() {
		return afteramount;
	}

	public void setAfteramount(Float afteramount) {
		this.afteramount = afteramount;
	}

	private String specification;

	 @Column(name = "specification", nullable = true, insertable = true, updatable = true, length = 256) public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
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

		BullCoinChg that = (BullCoinChg) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		if (currencytype != null ? !currencytype.equals(that.currencytype) : that.currencytype != null)
			return false;
		if (serialno != null ? !serialno.equals(that.serialno) : that.serialno != null)
			return false;
		if (transactiondate != null ? !transactiondate.equals(that.transactiondate) : that.transactiondate != null)
			return false;
		if (channelno != null ? !channelno.equals(that.channelno) : that.channelno != null)
			return false;
		if (branchbank != null ? !branchbank.equals(that.branchbank) : that.branchbank != null)
			return false;
		if (payaccount != null ? !payaccount.equals(that.payaccount) : that.payaccount != null)
			return false;
		if (paybank != null ? !paybank.equals(that.paybank) : that.paybank != null)
			return false;
		if (businesscode != null ? !businesscode.equals(that.businesscode) : that.businesscode != null)
			return false;
		if (lastamount != null ? !lastamount.equals(that.lastamount) : that.lastamount != null)
			return false;
		if (confirmedamount != null ? !confirmedamount.equals(that.confirmedamount) : that.confirmedamount != null)
			return false;
		if (afteramount != null ? !afteramount.equals(that.afteramount) : that.afteramount != null)
			return false;
		if (specification != null ? !specification.equals(that.specification) : that.specification != null)
			return false;
		if (lastupdatetime != null ? !lastupdatetime.equals(that.lastupdatetime) : that.lastupdatetime != null)
			return false;

		return true;
	}

	@Override public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (currencytype != null ? currencytype.hashCode() : 0);
		result = 31 * result + (serialno != null ? serialno.hashCode() : 0);
		result = 31 * result + (transactiondate != null ? transactiondate.hashCode() : 0);
		result = 31 * result + (channelno != null ? channelno.hashCode() : 0);
		result = 31 * result + (branchbank != null ? branchbank.hashCode() : 0);
		result = 31 * result + (payaccount != null ? payaccount.hashCode() : 0);
		result = 31 * result + (paybank != null ? paybank.hashCode() : 0);
		result = 31 * result + (businesscode != null ? businesscode.hashCode() : 0);
		result = 31 * result + (lastamount != null ? lastamount.hashCode() : 0);
		result = 31 * result + (confirmedamount != null ? confirmedamount.hashCode() : 0);
		result = 31 * result + (afteramount != null ? afteramount.hashCode() : 0);
		result = 31 * result + (specification != null ? specification.hashCode() : 0);
		result = 31 * result + (lastupdatetime != null ? lastupdatetime.hashCode() : 0);
		return result;
	}
}
