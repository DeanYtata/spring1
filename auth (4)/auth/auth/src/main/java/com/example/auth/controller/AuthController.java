package com.example.auth.controller;
 
import com.example.auth.dto.LoginRequest;
import com.example.auth.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
@RestController
@RequestMapping("/auth")
public class AuthController {
 
    private final JwtUtil jwtUtil;
 
    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }
 
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
 
        // Validación manual simple
        if ("admin".equals(request.getUsername()) &&
            "admin".equals(request.getPassword())) {
 
            String token = jwtUtil.generateToken(request.getUsername());
            return ResponseEntity.ok().body(token);
        }
 
        return ResponseEntity.status(401).body("Credenciales inválidas");
    }
 
    @GetMapping("/test")
    public String test() {
        return "Ruta protegida funcionando";
    }
}