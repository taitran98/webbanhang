package com.example.demo.tmpuser;

import com.example.demo.DemoApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TUService implements UserDetailsService {
    private  TURepository tuRepository;
    private DemoApplication.CustomPasswordEncoder passwordEncoder;

    @Autowired
    public TUService(TURepository tuRepository, @Lazy DemoApplication.CustomPasswordEncoder passwordEncoder)
    {
        this.tuRepository = tuRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public TUService(TURepository tuRepository) {
        this.tuRepository = tuRepository;
    }
    public void addNewUser(TmpUser tmpUser)
    {
        tmpUser.setPass(this.passwordEncoder.encode(tmpUser.getPass()));
        this.tuRepository.save(tmpUser);
    }

    public boolean authenticate(TmpUser tmpUser)
    {
        TmpUser user = this.tuRepository.findById(tmpUser.getEmail()).get();

        return (user != null && this.passwordEncoder.matches(tmpUser.getPass(), user.getPass()));
    }

    public List<TmpUser> getAllUsers()
    {
        return this.tuRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TmpUser user = new TmpUser();
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPass(), Collections.emptyList());
    }
}
