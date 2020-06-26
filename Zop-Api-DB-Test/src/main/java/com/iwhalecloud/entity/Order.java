package com.iwhalecloud.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Order implements Serializable {

    private int orderId;

    private String orderName;

    private Date createDate;

    private String userName;


    public Order() {
    }

    public Order(int orderId, String orderName, Date createDate) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.createDate = createDate;
    }

}
