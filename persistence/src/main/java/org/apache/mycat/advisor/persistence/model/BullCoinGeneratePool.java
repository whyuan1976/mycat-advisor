package org.apache.mycat.advisor.persistence.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by cjl on 2016/4/20.
 */
@Entity
@Table(name = "bull_coin_generate_pool", schema = "", catalog = "advisor")
public class BullCoinGeneratePool {
	@Id
	@Column(name = "id", nullable = false, insertable = true, updatable = true)
	private Long id;
	private String currencytype;
	private Long serialno;
	private String password;
	private Float facevalue;
	private Date begindete;
	private Date enddate;
	private String status;
	private Date insertdate;
	private Timestamp lastupdatetime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Basic @Column(name = "currencytype", nullable = false, insertable = true, updatable = true, length = 1) public String getCurrencytype() {
		return currencytype;
	}

	public void setCurrencytype(String currencytype) {
		this.currencytype = currencytype;
	}

	@Basic @Column(name = "serialno", nullable = false, insertable = true, updatable = true) public Long getSerialno() {
		return serialno;
	}

	public void setSerialno(Long serialno) {
		this.serialno = serialno;
	}

	@Basic @Column(name = "password", nullable = true, insertable = true, updatable = true, length = 64) public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Basic @Column(name = "facevalue", nullable = true, insertable = true, updatable = true, precision = 2) public Float getFacevalue() {
		return facevalue;
	}

	public void setFacevalue(Float facevalue) {
		this.facevalue = facevalue;
	}

	@Basic @Column(name = "begindete", nullable = true, insertable = true, updatable = true) public Date getBegindete() {
		return begindete;
	}

	public void setBegindete(Date begindete) {
		this.begindete = begindete;
	}

	@Basic @Column(name = "enddate", nullable = true, insertable = true, updatable = true) public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	@Basic @Column(name = "status", nullable = true, insertable = true, updatable = true, length = 1) public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Basic @Column(name = "insertdate", nullable = true, insertable = true, updatable = true) public Date getInsertdate() {
		return insertdate;
	}

	public void setInsertdate(Date insertdate) {
		this.insertdate = insertdate;
	}

	@Basic @Column(name = "lastupdatetime", nullable = false, insertable = true, updatable = true) public Timestamp getLastupdatetime() {
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

		BullCoinGeneratePool that = (BullCoinGeneratePool) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		if (currencytype != null ? !currencytype.equals(that.currencytype) : that.currencytype != null)
			return false;
		if (serialno != null ? !serialno.equals(that.serialno) : that.serialno != null)
			return false;
		if (password != null ? !password.equals(that.password) : that.password != null)
			return false;
		if (facevalue != null ? !facevalue.equals(that.facevalue) : that.facevalue != null)
			return false;
		if (begindete != null ? !begindete.equals(that.begindete) : that.begindete != null)
			return false;
		if (enddate != null ? !enddate.equals(that.enddate) : that.enddate != null)
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
		result = 31 * result + (serialno != null ? serialno.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + (facevalue != null ? facevalue.hashCode() : 0);
		result = 31 * result + (begindete != null ? begindete.hashCode() : 0);
		result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
		result = 31 * result + (status != null ? status.hashCode() : 0);
		result = 31 * result + (insertdate != null ? insertdate.hashCode() : 0);
		result = 31 * result + (lastupdatetime != null ? lastupdatetime.hashCode() : 0);
		return result;
	}
}
