package com.example.demo.tmpuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class TUController {
    @Autowired
    private final TUService tuService;

    public TUController(TUService tuService) {
        this.tuService = tuService;
    }

    @GetMapping("/alluser")
    private List<TmpUser> getAllUsers()
    {
        return this.tuService.getAllUsers();
    }

    @PostMapping("/adduser")
    private void addNewUser(@RequestBody TmpUser tmpUser)
    {
        this.tuService.addNewUser(tmpUser);
    }

    @PostMapping ("/auth")
    private boolean authenticate(@RequestBody TmpUser tmpUser)
    {
        return this.tuService.authenticate(tmpUser);
    }
}
