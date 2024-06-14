package br.com.fiap.application.controller;

import br.com.fiap.application.dto.UserDisplayDto;
import br.com.fiap.application.dto.UserRegisterDto;
import br.com.fiap.application.model.User;
import br.com.fiap.application.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collect")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDisplayDto register(@RequestBody @Valid UserRegisterDto userRegisterDto){
        return service.registerUser(userRegisterDto);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDisplayDto> findAll(){
        return service.findAll();
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDisplayDto> findById(@PathVariable Long userId){
        return ResponseEntity.ok(service.findById(userId));
    }

/*  @RequestMapping(value = "/users", params = "email")
    @ResponseStatus(HttpStatus.OK)
    public UserDisplayDto findByEmail(@RequestParam String email){
        return service.findByEmail(email);
    }*/

    @DeleteMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long userId){
        service.delete(userId);
    }

    @PutMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public User update(@RequestBody User user){
        return service.update(user);
    }

}
