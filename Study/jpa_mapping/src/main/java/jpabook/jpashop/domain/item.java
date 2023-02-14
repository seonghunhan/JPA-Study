package jpabook.jpashop.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class item {

    // 테이블에서는 ITEM_ID이지만 객체에서는 id로 사용하고싶을때! pdf04 엔티티 설계와 매핑 참고!
    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockquantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockquantity() {
        return stockquantity;
    }

    public void setStockquantity(int stockquantity) {
        this.stockquantity = stockquantity;
    }
}
