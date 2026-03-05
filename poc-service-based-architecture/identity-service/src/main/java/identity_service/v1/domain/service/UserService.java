package identity_service.v1.domain.service;

import identity_service.v1.domain.model.User;
import identity_service.v1.infra.dtos.UserRequest;
import identity_service.v1.infra.dtos.UserResponse;
import identity_service.v1.infra.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    @Transactional
    public UserResponse create(UserRequest request) {

        User user = toUser(request);

        return toResponse(repository.save(user));
    }

    public UserResponse get(Long id) {

        return toResponse(repository.findById(id)
                .orElseThrow(() -> new RuntimeException()));
    }

    private User toUser(UserRequest request) {
        if (request == null) throw new IllegalArgumentException();

        Assert.notNull(request.name(), "Name is necessary.");

        Assert.notNull(request.email(), "Email is necessary.");

        return User.builder()
                .name(request.name())
                .email(request.email())
                .createdAt(LocalDateTime.now())
                .build();
    }

    private UserResponse toResponse(User user) {
        return UserResponse
                .builder()
                .createdAt(user.getCreatedAt())
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }
}
