package com.fooddeliveryservice.Controller.SecurityController;

import com.fooddeliveryservice.Config.Exception.AppException;
import com.fooddeliveryservice.Config.Payload.ApiResponse;
import com.fooddeliveryservice.Config.Payload.JwtAuthenticationResponse;
import com.fooddeliveryservice.Config.Payload.LoginRequest;
import com.fooddeliveryservice.Config.Payload.SignUpRequest;
import com.fooddeliveryservice.Config.Security.JwtTokenProvider;
import com.fooddeliveryservice.Entity.Role;
import com.fooddeliveryservice.Entity.RoleName;
import com.fooddeliveryservice.Entity.User;
import com.fooddeliveryservice.Repository.IUserRepository;
import com.fooddeliveryservice.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserLogin(),
                        loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/user")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
//        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
//                    HttpStatus.BAD_REQUEST);
//        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }
        Role role = new Role(RoleName.ROLE_USER);
        role.setId(1);
        User user = new User(signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getUsername(), signUpRequest.getPassword(),
                role, signUpRequest.getEmail());
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        //TODO make it work
//        Role userRole = roleRepository.findByName(RoleName.ROLE_USER.name())
//                .orElseThrow(() -> new AppException("User Role not set."));
//        user.setRole(userRole);
        User result = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/users/{username}")
                .buildAndExpand(result.getUserName())
                .toUri();
        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}
