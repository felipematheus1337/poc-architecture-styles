package identity_service.v1.infra.presentation;

import identity_service.v1.domain.service.UserService;
import identity_service.v1.infra.dtos.UserRequest;
import identity_service.v1.infra.dtos.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/identity")
@AllArgsConstructor
public class IdentityController {

    private final UserService service;

    @PostMapping("/users")
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> get(@PathVariable("id") Long id)  {
        return ResponseEntity.ok(service.get(id));
    }

}
