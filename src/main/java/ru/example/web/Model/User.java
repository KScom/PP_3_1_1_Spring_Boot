package ru.example.web.Model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotNull
    @NotBlank(message = "Имя не должно быть пустым")
    private String name;

    @Column(name = "age")
    @NotNull
    @Min(value = 18, message = "Возраст должен быть больше 18")
    private int age;

    @Column(name = "mail")
    @NotNull
    @Pattern(regexp = "([A-z0-9_.-]+)@([A-z0-9_.-]+).([A-z]{2,10})", message = "Введите корректный E-mail")
    private String mail;

    public User(){}

    public User(String name, int age, String mail) {
        this.name = name;
        this.age = age;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", mail='" + mail + '\'' +
                '}';
    }
}
