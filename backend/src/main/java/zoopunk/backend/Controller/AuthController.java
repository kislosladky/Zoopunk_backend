package zoopunk.backend.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import zoopunk.backend.Service.AuthenticationService;
import zoopunk.backend.dto.JwtAuthenticationResponse;
import zoopunk.backend.dto.SignInRequest;
import zoopunk.backend.dto.SignUpRequest;
import zoopunk.backend.exception.BadSignupException;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    AuthenticationService authenticationService;


//    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/sign-up")
    public ResponseEntity<JwtAuthenticationResponse> signUp(@RequestBody @Valid SignUpRequest request) {
        try {
            return ResponseEntity.ok(authenticationService.signUp(request));
        } catch (BadSignupException e) {
            var response = JwtAuthenticationResponse.builder()
                    .status("Error")
                    .message(e.getMessage())
                    .token(null)
                    .build();
            return ResponseEntity.ok(response);
        }
    }

//    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/sign-in")
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody @Valid SignInRequest request) {
        return ResponseEntity.ok(authenticationService.signIn(request));
    }

    @GetMapping("/guest")
    public ResponseEntity<JwtAuthenticationResponse> signInAsGuest() {
        SignInRequest signInRequest = SignInRequest.builder()
                .username("guest").password("11111111").build();

        return ResponseEntity.ok(authenticationService.signIn(signInRequest));
    }
}
