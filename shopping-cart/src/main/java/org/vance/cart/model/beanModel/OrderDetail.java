package org.vance.cart.model.beanModel;

public class OrderDetail {

    private String orderId;

    private GoodsInfo item = new GoodsInfo();

    public OrderDetail() {

    }

    public OrderDetail(String orderId, GoodsInfo item) {
        this.orderId = orderId;
        this.item = item;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public GoodsInfo getItem() {
        return item;
    }

    public void setItem(GoodsInfo item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "OrderDetail [orderId=" + orderId + ", item=" + item + "]";
    }

}
