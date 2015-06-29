package com.home.primeseller;

import java.util.Date;

public class Order {
    private String orderId;
    private Integer itemNumber;
    private Date orderTime;
    private Integer waiterId;
    private Integer chefId;
    private Date waiterConsumeTime;
    private Date waiterProducesTime;

    public Integer getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(Integer waiterId) {
        this.waiterId = waiterId;
    }

    public Integer getChefId() {
        return chefId;
    }

    public void setChefId(Integer chefId) {
        this.chefId = chefId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getWaiterConsumeTime() {
        return waiterConsumeTime;
    }

    public void setWaiterConsumeTime(Date waiterConsumeTime) {
        this.waiterConsumeTime = waiterConsumeTime;
    }

    public Date getWaiterProducesTime() {
        return waiterProducesTime;
    }

    public void setWaiterProducesTime(Date waiterProducesTime) {
        this.waiterProducesTime = waiterProducesTime;
    }

}
