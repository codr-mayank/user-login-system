package com.example.uls.userloginsystem.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

  private final RegistrationService registrationService;

  @GetMapping(path = "ping")
  public String checkHealth() {
    return "server: up";
  }

  @PostMapping
  public String register(@RequestBody RegistrationRequest request) {
    return registrationService.register(request);
  }

  @GetMapping(path = "confirm")
  public String confirm(@RequestParam("token") String token) {
    return registrationService.confirmToken(token);
  }
}
