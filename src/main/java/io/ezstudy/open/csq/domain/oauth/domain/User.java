package io.ezstudy.open.csq.domain.oauth.domain;

import io.ezstudy.open.csq.domain.model.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "VARCHAR(36)", insertable = false, updatable = false, nullable = false)
    private String id;

    private String name;
    private String email;
    private String gender;
    private String provider;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public User(String id, String name, String email, String gender, String provider, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.provider = provider;
        this.role = role;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

}
