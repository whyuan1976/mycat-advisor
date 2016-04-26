package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by cjl on 2016/4/25.
 */
@Entity
@Table(name = "tab_order", schema = "", catalog = "advisor")
public class TabOrder {
    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private Long id;
    private Long productId;
    private Integer status;
    private String paynumber;
    private Integer paytype;
    private Integer orderStep;
    private Float earnings; //订单金额
    private long createTime;
    private long updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "earnings", nullable = false, insertable = true, updatable = true)
    public Float getEarnings() {
        return earnings;
    }

    public void setEarnings(Float earnings) {
        this.earnings = earnings;
    }

    @Column(name = "product_id", nullable = false, insertable = true, updatable = true)
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }


    @Column(name = "status", nullable = true, insertable = true, updatable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    @Column(name = "paynumber", nullable = true, insertable = true, updatable = true, length = 32)
    public String getPaynumber() {
        return paynumber;
    }

    public void setPaynumber(String paynumber) {
        this.paynumber = paynumber;
    }


    @Column(name = "paytype", nullable = true, insertable = true, updatable = true)
    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }


    @Column(name = "order_step", nullable = true, insertable = true, updatable = true)
    public Integer getOrderStep() {
        return orderStep;
    }

    public void setOrderStep(Integer orderStep) {
        this.orderStep = orderStep;
    }

    @Column(name = "create_time", nullable = true, insertable = true, updatable = true)
    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
    @Column(name = "update_time", nullable = true, insertable = true, updatable = true)
    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabOrder tabOrder = (TabOrder) o;

        if (id != null ? !id.equals(tabOrder.id) : tabOrder.id != null) return false;
        if (productId != null ? !productId.equals(tabOrder.productId) : tabOrder.productId != null) return false;
        if (status != null ? !status.equals(tabOrder.status) : tabOrder.status != null) return false;
        if (paynumber != null ? !paynumber.equals(tabOrder.paynumber) : tabOrder.paynumber != null) return false;
        if (paytype != null ? !paytype.equals(tabOrder.paytype) : tabOrder.paytype != null) return false;
        if (orderStep != null ? !orderStep.equals(tabOrder.orderStep) : tabOrder.orderStep != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (paynumber != null ? paynumber.hashCode() : 0);
        result = 31 * result + (paytype != null ? paytype.hashCode() : 0);
        result = 31 * result + (orderStep != null ? orderStep.hashCode() : 0);
        return result;
    }
}
