package com.portfolio.fontana.Security.Service;

import com.portfolio.fontana.Security.Entity.User;
import com.portfolio.fontana.Security.Entity.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String nameUser) throws UsernameNotFoundException {
        User user = userService.getByNameUser(nameUser).get();
        return UserPrincipal.build(user);
    }
}
