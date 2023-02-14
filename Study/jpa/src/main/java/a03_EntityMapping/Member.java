//package a03_EntityMapping;
//
//import javax.persistence.*;
//
////persistence.xml에서 create옵션 활성화시켜주고 실행함
////이거 어노테이션으로 인식함 꼭 넣어야함
//@Entity //(name="Member") // 보통 안쓴다. JPA가 클래스이름으로 알아서 맵핑함
//public class Member {
//
//    //PK 맵핑
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id; // 타입을 인티저로 하긴하는데, 10억쯤되면 한바퀴돌아서 부적절함 그래서 결론은 Long을 써야함(공간이 인티저보다 2배이상이지만 요즘은 속도차이 별 없음)
//
//    // 객체는 username이라고 쓰고싶지만 DB에는 name이라고 쓸때
//    @Column(name = "name", nullable = false)
//    private String username;
//
//    public Member(){
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//}
//
