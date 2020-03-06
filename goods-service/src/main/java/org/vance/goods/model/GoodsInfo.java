package org.vance.goods.model;

public class GoodsInfo {

    private int id;
    private String title;
    private String desc;
    private int Stock;
    private int price;

    public GoodsInfo(int id, String title, String desc, int stock, int price) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.Stock = stock;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", Stock=" + Stock +
                ", price=" + price +
                '}';
    }
}
