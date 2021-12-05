package io.ezstudy.open.csq.domain.oauth.dao;

import io.ezstudy.open.csq.domain.oauth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
