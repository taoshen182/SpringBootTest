package com.wangtao.study.pojo;

/**
 * @author : wangtao
 * @date : 2017/12/27 15:27
 */

public class User {
    private Integer id;
    private String username;
    private Integer age;
    private String email;

    public String getSex() {
        return sex.getSex();
    }

    public void setSex(UserSexEnum sex) {
        this.sex = sex;
    }

    private UserSexEnum sex;
    private UserStatusEnum status;

    /**
     * @return 返回枚举状态的值
     */
    public String getStatus() {
        return status.getStatusName();
    }

//    /**
//     * @return 返回枚举状态的名称
//     */
//    public UserStatusEnum getStatus() {
//        return status;
//    }


    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
