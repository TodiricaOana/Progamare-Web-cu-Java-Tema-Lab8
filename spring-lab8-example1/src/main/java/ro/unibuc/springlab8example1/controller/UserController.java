package ro.unibuc.springlab8example1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.unibuc.springlab8example1.domain.UserType;
import ro.unibuc.springlab8example1.dto.UserDto;
import ro.unibuc.springlab8example1.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/student")
    public ResponseEntity<UserDto> createStudent(@RequestBody UserDto userDto) {
        return ResponseEntity
                .ok()
                .body(userService.create(userDto, UserType.STUDENT));
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> get(@PathVariable String username) {
        return ResponseEntity
                .ok()
                .body(userService.getOne(username));
    }

    @GetMapping("/type/{userType}")
    public ResponseEntity<List<UserDto>> get(@PathVariable UserType userType) {
        return ResponseEntity
                .ok()
                .body(userService.getUsersByType(userType));
    }

    @PutMapping("/update/student/{id}")
    public ResponseEntity<UserDto> updateStudent(@RequestBody UserDto userDto, @PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(userService.updateUser(userDto, id, UserType.STUDENT));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserDto> delete( @PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
