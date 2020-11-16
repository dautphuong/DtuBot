package com.dtubot.service.security;



import com.dtubot.entity.security.user.User;
import com.dtubot.entity.security.utils.UserPrincipal;
import com.dtubot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow (
                () -> new UsernameNotFoundException("Username [" + username +"] not found!")
        );
        return UserPrincipal.build(user);
    }
}
