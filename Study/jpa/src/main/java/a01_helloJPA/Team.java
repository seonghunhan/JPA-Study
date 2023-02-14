package a01_helloJPA;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {


    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    //맵드바이가 중요함! -> 단방향 연관관계를 쌍방으로 2개두는것! 테이플은 단방향으로도
    // 충분히 향방향 통신(포린키이용)가능하지만 객체는 아님 그래서 이래야함
    //맵드바이로 지정된 team이 주인임!!!!
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();


    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

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
}
