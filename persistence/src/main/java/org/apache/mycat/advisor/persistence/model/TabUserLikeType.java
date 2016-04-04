package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by cjl on 2016/3/20.
 */
@Table(name = "tab_user_like_type")
public class TabUserLikeType {
    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private Long id;
    private Long typeId;
    private Long userId;
    @Transient
    private String userName;
    @Transient
    private String typeName;
    @Transient
    private String typeCode;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type_id", nullable = true, insertable = true, updatable = true)
    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "user_id", nullable = true, insertable = true, updatable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "userName", nullable = true, insertable = false, updatable = false)
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Basic
	@Column(name = "typeName", nullable = true, insertable = false, updatable = false)
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Basic
	@Column(name = "typeCode", nullable = true, insertable = false, updatable = false)
	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabUserLikeType that = (TabUserLikeType) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
