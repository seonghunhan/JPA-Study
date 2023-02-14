package jpabook.jpashop.domain;


import javax.persistence.*;
import java.time.LocalDateTime;

// 오더는 DB별로 ORDER BY땜에 충돌날 경우가 있음 -> 테이블을 ORDERS로 하기!
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID" )
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId;

    private Member member;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    //스프링부트는 기본 관례를 오버라이딩하기쉬움
    //ORDER_DATE, order_date가 DB 컬럼명 관행임
    private LocalDateTime orderDate;

    // 이넘은 꼭 스트링으로! 순서에 의존적이지 '않다'
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
