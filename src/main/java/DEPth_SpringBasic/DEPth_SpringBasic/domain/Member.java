package DEPth_SpringBasic.DEPth_SpringBasic.domain;

public class Member {
    private Long id;
    private String name;

    //단축키 alt+insert 사용->Getter Setter 자동 생성

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
