package io.ezstudy.open.csq.domain.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    ADMIN("ROLE_ADMIN","어드민"),
    STAFF("ROLE_STAFF","스태프");

    private final String key;
    private final String title;
}
