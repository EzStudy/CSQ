package io.ezstudy.open.csq.domain.oauth.application;

import io.ezstudy.open.csq.domain.oauth.dao.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;


}
