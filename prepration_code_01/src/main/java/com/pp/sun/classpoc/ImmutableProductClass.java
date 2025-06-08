package com.pp.sun.classpoc;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Getter
public final class ImmutableProductClass {

    final private Long productId ;
    final private String productName ;
    final private Double productPrice ;
    final private Integer productQuantity ;
    final private String productSize ;
    final private Date productExpireDate ;
    final private List<String> productAvabilityLocations ;

    public ImmutableProductClass(Long productId, String productName, Double productPrice,
                                 Integer productQuantity, String productSize, Date productExpireDate,
                                 List<String> productAvabilityLocations) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productSize = productSize;
        this.productExpireDate = productExpireDate;
        this.productAvabilityLocations = productAvabilityLocations;
    }
    
    public Date getProductExpireDate() {// Defencive Copy for object/date Object
        return new Date(this.productExpireDate.getTime());
    }

    public List<String> getProductAvabilityLocations() { // Defencive Copy Collections
        return new ArrayList<>(productAvabilityLocations);
    }

    @Override
    public String toString() {
        return "ImmutableProductClass{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                ", productSize='" + productSize + '\'' +
                ", productExpireDate=" + productExpireDate +
                ", productAvabilityLocations=" + productAvabilityLocations +
                '}';
    }
}
