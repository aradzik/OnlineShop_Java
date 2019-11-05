package com.project.shop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bag")
public class Bag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer prodbagid;
    private Integer productid;
    private Integer userid;


    public Bag() {
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Bag(Integer productid, Integer userid) {
        this.productid = productid;
        this.userid = userid;
    }

    public Integer getProdbagid() {
        return prodbagid;
    }

    public void setProdbagid(Integer prodbagid) {
        this.prodbagid = prodbagid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }
}
