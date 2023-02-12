package a03_EntityMapping;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

//persistence.xml에서 create옵션 활성화시켜주고 실행함
//이거 어노테이션으로 인식함 꼭 넣어야함
@Entity(name="Member") // 보통 안쓴다. JPA가 클래스이름으로 알아서 맵핑함
public class Member {

        //PK 맵핑
        @Id
        private Long id;

        // 객체는 username이라고 쓰고싶지만 DB에는 name이라고 쓸때
        @Column(name = "name")
        private String username;
        private Integer age;

        //pdf04 이넘보면 여기에 ORDINAL 아니면 STRING인데 ORDINAL은 순서를 데베에 저장한다함 그래서 밑처럼 STRING으로 해야함!
        //JPA에서 이넘타입을쓰고 싶을때 그리고! 스트링으로 안하면 파람추가하면 완전 날라감 -> 순서가 중요해서
        @Enumerated(EnumType.STRING)
        private RoleType roleType;

        //날짜타입(생성,수정일자)
        @Temporal(TemporalType.TIMESTAMP) // DATE, TIME, TIMESTAMP 3가지 있음 (TIMESTAMP는 날짜시간)
        private Date createdDate;

        @Temporal(TemporalType.TIMESTAMP)
        private Date lastModifiedDate;

        //최신버전은 위처럼 Temporal어노 필요없이 아래처럼 사용가능
        private LocalDate testLocalDate;
        private LocalDateTime testLocalDateTime;

        @Lob
        private String description;



        public Member(){
        }



        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public Integer getAge() {
                return age;
        }

        public void setAge(Integer age) {
                this.age = age;
        }

        public RoleType getRoleType() {
                return roleType;
        }

        public void setRoleType(RoleType roleType) {
                this.roleType = roleType;
        }

        public Date getCreatedDate() {
                return createdDate;
        }

        public void setCreatedDate(Date createdDate) {
                this.createdDate = createdDate;
        }

        public Date getLastModifiedDate() {
                return lastModifiedDate;
        }

        public void setLastModifiedDate(Date lastModifiedDate) {
                this.lastModifiedDate = lastModifiedDate;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }
}

