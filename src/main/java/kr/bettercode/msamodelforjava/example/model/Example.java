package kr.bettercode.msamodelforjava.example.model;

import java.util.Objects;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class Example {

  private Long id;

  @NotEmpty
  private String name;

  @Positive
  private Integer age;

  @Email
  private String email;

  public Example() {}

  public Example(String name, Integer age, String email) {
    this.name = name;
    this.age = age;
    this.email = email;
  }

  public Example(Long id, String name, Integer age, String email) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.email = email;
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Example example = (Example) o;
    return Objects.equals(getId(), example.getId()) && Objects.equals(getName(), example.getName())
        && Objects.equals(getAge(), example.getAge()) && Objects.equals(getEmail(),
        example.getEmail());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getAge(), getEmail());
  }

  @Override
  public String toString() {
    return "Example{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", age=" + age +
        ", email='" + email + '\'' +
        '}';
  }
}
