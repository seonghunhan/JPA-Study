package jpabook.jpashop.domain;

import javax.persistence.*;

// 보통 여기에 제약같은것도 다 명시해둠! ex) @Column(length=10) 이렇게해야 여기만 보고 딱 알수 있잖슴
@Entity
public class Member {

    // 컬럼을 안붙여도 알아서 매핑하지만 테이블에서의 이름을 객체에서는 다르게 사용하고싶을때 사용
    @Id @GeneratedValue()
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;
    private String city;
    private String street;
    private String zipcode;



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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
