package br.com.fiap.application.dto;

import br.com.fiap.application.model.User;
import br.com.fiap.application.model.UserRole;

public record UserDisplayDto(
        Long userId,
        String name,
        String email,
        UserRole role
) {
    public UserDisplayDto(User user) {
        this(
                user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }
}
