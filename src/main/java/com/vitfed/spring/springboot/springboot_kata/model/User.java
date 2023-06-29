package com.vitfed.spring.springboot.springboot_kata.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @Size(min = 2, message = "(Name must be min 2 symbols)")
    @NotBlank(message = "(Name is required field)")
    @Pattern(regexp = "[a-zA-Z]+", message = "(Only letters of the Latin alphabet)")
    private String name;

    @Column(name = "lastName")
    @Size(min = 2, message = "(Lastname must be min 2 symbols)")
    @NotBlank(message = "(Lastname is required field)")
    @Pattern(regexp = "[a-zA-Z]+", message = "(Only letters of the Latin alphabet)")
    private String lastName;

    @Column(name = "age")
    @Min(value = 1, message = "Min value = 1")
    private int age;

    @Column(name = "email")
    @NotBlank(message = "(Lastname is required field)")
    @Pattern(regexp = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b",
    message = "(Value does not match the standard email pattern)")
    private String email;

    public User() {
    }

    public User(String name, String lastName, int age, String email) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (!Objects.equals(id, user.id)) return false;
        if (!Objects.equals(name, user.name)) return false;
        if (!Objects.equals(lastName, user.lastName)) return false;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}