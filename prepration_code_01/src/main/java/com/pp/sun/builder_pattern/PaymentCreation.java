package com.pp.sun.builder_pattern;

import java.util.Date;

public final class PaymentCreation {

    private final Integer id ;
    private final String paymentWay ;
    private final Date paymentDate ;
    private final Double paymentAmount ;

    private PaymentCreation(builder builder){
        this.id = builder.id;
        this.paymentWay = builder.paymentWay;
        this.paymentDate = builder.paymentDate;
        this.paymentAmount = builder.paymentAmount;
    }

    public Integer getId() {
        return id;
    }

    public String getPaymentWay() {
        return paymentWay;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public static class builder{
        private  Integer id ;
        private  String paymentWay ;
        private  Date paymentDate ;
        private  Double paymentAmount ;


        public builder id(Integer id) {
            this.id = id;
            return this;
        }

        public builder paymentWay(String paymentWay) {
            this.paymentWay = paymentWay;
            return this;

        }

        public builder paymentDate(Date paymentDate) {
            this.paymentDate = paymentDate;
            return this;

        }

        public builder paymentAmount(Double paymentAmount) {
            this.paymentAmount = paymentAmount;
            return this;

        }

        public  PaymentCreation build(){
            return  new PaymentCreation(this);
        }
    }

    @Override
    public String toString() {
        return "PaymentCreation{" +
                "id=" + id +
                ", paymentWay='" + paymentWay + '\'' +
                ", paymentDate=" + paymentDate +
                ", paymentAmount=" + paymentAmount +
                '}';
    }
}
