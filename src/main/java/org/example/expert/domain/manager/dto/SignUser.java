package org.example.expert.domain.manager.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SignUser {

    private final Long id;
    private final String email;

}
