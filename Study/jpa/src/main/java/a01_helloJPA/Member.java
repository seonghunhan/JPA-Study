package a01_helloJPA;

import javax.persistence.Entity;
import javax.persistence.Id;

//이거 어노테이션으로 인식함 꼭 넣어야함
@Entity
public class Member {

    @Id //이게 키값 지정 어노인듯?
    private Long id;
    private String name;

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
