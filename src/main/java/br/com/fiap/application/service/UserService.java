package br.com.fiap.application.service;

import br.com.fiap.application.dto.UserDisplayDto;
import br.com.fiap.application.dto.UserRegisterDto;
import br.com.fiap.application.exception.ExceptionHandler;
import br.com.fiap.application.model.User;
import br.com.fiap.application.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserDisplayDto registerUser(UserRegisterDto userRegisterDto) {
        String EncryptedPassword = new BCryptPasswordEncoder().encode(userRegisterDto.password());

        User user = new User();
        BeanUtils.copyProperties(userRegisterDto, user);
        user.setPassword(EncryptedPassword);

        User registeredUser = repository.save(user);

        return new UserDisplayDto(registeredUser);

    }

    public UserDisplayDto findById(Long id) {
        Optional<User> optionalUser = repository.findById(id);

        if(optionalUser.isPresent()) {
            return new UserDisplayDto(optionalUser.get());
        } else {
            throw new ExceptionHandler("User does not exist in the database");
        }
    }

/*    public UserDisplayDto findByEmail(String email) {
        Optional<User> optionalUser = repository.findByEmail(email);

        if(optionalUser.isPresent()) {
            return new UserDisplayDto(optionalUser.get());
        } else {
            throw new ExceptionHandler("User does not exist in the database");
        }
    }*/

    public List<UserDisplayDto> findAll() {
        return repository
                .findAll()
                .stream()
                .map(UserDisplayDto::new)
                .toList();
    }

    public void delete(Long id) {
        Optional<User> optionalUser = repository.findById(id);

        if(optionalUser.isPresent()) {
            repository.delete(optionalUser.get());
        } else {
            throw new RuntimeException("Not found");
        }
    }

    public User update(User user) {
        Optional<User> optionalUser = repository.findById(user.getUserId());

        if(optionalUser.isPresent()) {
            return repository.save(user);
        } else {
            throw new RuntimeException("User not found!");
        }
    }



}
