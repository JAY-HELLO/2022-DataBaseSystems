package DTO;

//DTO는 데이터 를실어나르는 객체
//2018038006 이정주
public class userDTO {
    private Integer ussn;
    private String name;
    private String phone;

    public Integer getUssn() {
        return ussn;
    }

    public void setUssn(Integer ussn) {
        this.ussn = ussn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
