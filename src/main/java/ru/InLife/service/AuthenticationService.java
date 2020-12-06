package ru.InLife.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.InLife.DTO.AuthenticationRequestDTO;
import ru.InLife.model.User;
import ru.InLife.repository.UserRepository;
import ru.InLife.security.JwtTokenProvider;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthenticationService(AuthenticationManager authenticationManager, UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public ResponseEntity<?> authenticate(AuthenticationRequestDTO req){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
            User user = userRepository.findByEmail(req.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User doesn't exists"));
            String token = jwtTokenProvider.createToken(req.getEmail());
            Map<Object, Object> res = new HashMap<>();
            res.put("email", req.getEmail());
            res.put("token", token);

            return ResponseEntity.ok(res);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Invalid email/password combination or banned", HttpStatus.FORBIDDEN);
        }
    }

}
