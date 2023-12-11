package com.peralta.financenow.controller;

import com.peralta.financenow.domain.model.request.user.UserDTO;
import com.peralta.financenow.exception.FinanceNowException;
import com.peralta.financenow.domain.model.entity.User;
import com.peralta.financenow.domain.model.response.DataResponse;
import com.peralta.financenow.service.user.IUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user")
@CrossOrigin(origins = "*")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public DataResponse<User> registerNewUser(
            @RequestBody UserDTO user
    ) throws FinanceNowException {

            return userService.registerNewUser(user);

    }

    @GetMapping("/login")
    public DataResponse<User> validateLogin(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password
    ) throws FinanceNowException {

            return userService.validateLogin(username, password);

    }

}
