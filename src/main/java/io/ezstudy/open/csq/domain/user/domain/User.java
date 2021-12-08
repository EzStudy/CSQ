package io.ezstudy.open.csq.domain.user.domain;

import io.ezstudy.open.csq.domain.model.BaseTimeEntity;
import io.ezstudy.open.csq.global.Constants.PROVIDER;
import io.ezstudy.open.csq.global.Constants.ROLE;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Entity
@Table(name = "user")
@NoArgsConstructor
public class User extends BaseTimeEntity {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(columnDefinition = "VARCHAR(36)", insertable = false, updatable = false, nullable = false)
  private String id;

  @Column(length = 20)
  private String name;

  @Email
  @Column(length = 100, unique = true, nullable = false)
  private String email;

  @Column(length = 20)
  private String gender;

  @Column(length = 20)
  @Enumerated(value = EnumType.STRING)
  private PROVIDER provider;

  @Column(length = 10)
  @Enumerated(value = EnumType.STRING)
  private ROLE role;

  @Builder
  public User(String id, String name, String email, String gender, PROVIDER provider, ROLE role,
      String createdAt, String updatedAt, String deletedAt) {

    super(createdAt, updatedAt, deletedAt);
    this.id = id;
    this.name = name;
    this.email = email;
    this.gender = gender;
    this.provider = provider;
    this.role = role;
  }

  @Override
  public String toString() {
    return "User{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", gender='" + gender + '\'' +
        ", provider=" + provider +
        ", role=" + role +
        ", createdAt='" + createdAt + '\'' +
        ", updatedAt='" + updatedAt + '\'' +
        ", deletedAt='" + deletedAt + '\'' +
        '}';
  }
}
