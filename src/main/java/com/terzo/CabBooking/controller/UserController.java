package com.terzo.CabBooking.controller;

import com.terzo.CabBooking.Dto.UserDto;
import com.terzo.CabBooking.model.TripInfo;
import com.terzo.CabBooking.model.User;
import com.terzo.CabBooking.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.findAll();
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDto user){
        userService.save(user);
        return "You're registered.";
    }

    @GetMapping("/{id}/rides")
    public List<TripInfo> getRidesInfo(@PathVariable("id") long id){
        return userService.findAllTripById(id);
    }

    @DeleteMapping("/{id}/delete")
    public String deleteUserById(@PathVariable("id") long id){
        userService.delete(id);
        return "User Deleted";
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") long id){
        return userService.findById(id);
    }
}
