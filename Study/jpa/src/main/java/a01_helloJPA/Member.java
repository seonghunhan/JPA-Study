package a01_helloJPA;

import javax.persistence.*;

//이거 어노테이션으로 인식함 꼭 넣어야함
@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String Username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    //DB에서 누가 1인지 N인지 JPA한테 알려줘야함
    //멤버입장에서는 N(Many)이고 팀은 1(One) -> pdf 05연관관계에서 객체 지향 모델링 참고!
    @ManyToOne
    @JoinColumn(name = "TEAM_ID") //멤버테이블의 TEAM_ID와 객체 team을 맵핑한것!
    private Team team;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String USERNAME) {
        this.Username = Username;
    }

}
