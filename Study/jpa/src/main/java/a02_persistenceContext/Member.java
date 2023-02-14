//package a02_persistenceContext;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//
////이거 어노테이션으로 인식함 꼭 넣어야함
//@Entity
//public class Member {
//
//    @Id //이게 키값 지정 어노인듯?
//    private Long id;
//    private String name;
//
//    // JPA는 내부적으로 리플렉션등 동적으로 사용하기에 기본생성자있어야함
//    public Member(){
//
//    }
//
//// 생성자한개 만듬(귀찮아서)
//    public Member(Long id, String name) {
//        this.id = id;
//        this.name = name;
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
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
