package zoopunk.backend.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import zoopunk.backend.Service.AuthenticationService;
import zoopunk.backend.dto.JwtAuthenticationResponse;
import zoopunk.backend.dto.SignInRequest;
import zoopunk.backend.dto.SignUpRequest;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private AuthenticationService authenticationService;


//    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody @Valid SignUpRequest request) {
        return authenticationService.signUp(request);
    }

//    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequest request) {
        return authenticationService.signIn(request);
    }
}
