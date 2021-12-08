package io.ezstudy.open.csq.domain.user.domain;

import io.ezstudy.open.csq.domain.model.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "VARCHAR(36)", insertable = false, updatable = false, nullable = false)
    private String id;

    @NotNull
    @Column(length = 20, nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 20)
    private String gender;

    @NotNull
    @Column(length = 20, nullable = false)
    private String provider;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(length = 10, nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String gneder, String provider,
        Role role, String createdAt, String updatedAt, String deletedAt){
        super(createdAt, updatedAt, deletedAt);
        this.name = name;
        this.email = email;
        this.gender = gneder;
        this.provider = provider;
        this.role = role;
    }
    public User update(String name){
        this.name = name;
        return this;
    }
    public String getRoleKey(){
        return this.role.getKey();
    }
}
