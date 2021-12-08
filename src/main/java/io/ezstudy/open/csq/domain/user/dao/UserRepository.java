package io.ezstudy.open.csq.domain.user.dao;

import io.ezstudy.open.csq.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
