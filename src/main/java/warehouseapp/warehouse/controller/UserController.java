package warehouseapp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import warehouseapp.warehouse.payload.ApiResponse;
import warehouseapp.warehouse.payload.UserDto;
import warehouseapp.warehouse.repository.UserRepository;
import warehouseapp.warehouse.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @PostMapping
    public HttpEntity<?> save(@RequestBody UserDto userDto) {
        ApiResponse apiResponse = userService.save(userDto);
        return ResponseEntity.status(apiResponse.isSuccess()
                        ? HttpStatus.CREATED :
                        HttpStatus.CONFLICT).
                body(apiResponse);
    }

    @GetMapping
    public HttpEntity<?> getAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getOne(id));
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody UserDto userDto) {
        ApiResponse response = userService.edit(id, userDto);
        return ResponseEntity.status(response.isSuccess()
                        ? HttpStatus.CREATED :
                        HttpStatus.CONFLICT).
                body(response);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.delete(id));
    }

}
