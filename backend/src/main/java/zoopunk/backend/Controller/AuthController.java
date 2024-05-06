package zoopunk.backend.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import zoopunk.backend.Service.AuthenticationService;
import zoopunk.backend.dto.JwtAuthenticationResponse;
import zoopunk.backend.dto.SignInRequest;
import zoopunk.backend.dto.SignUpRequest;
import zoopunk.backend.exception.BadSignupException;

import java.util.List;

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
                    .token("")
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<JwtAuthenticationResponse> handleConstraintViolation(MethodArgumentNotValidException ex, WebRequest request) {
        List<FieldError> errors = ex.getFieldErrors();
        StringBuilder message = new StringBuilder();
        for (FieldError error : errors) {
            message.append(error.getDefaultMessage());
            message.append("\n");
        }

        var response = JwtAuthenticationResponse.builder()
                .token("")
                .status("Error")
                .message(message.toString()).build();

        return ResponseEntity.ok(response);
    }
}
