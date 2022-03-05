package exercise;

import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // BEGIN
        exercise.model.User findUser = repository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        String userRole = String.valueOf(findUser.getRole());

        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(userRole));

        return new User(email, findUser.getPassword(), authorities);
        // END
    }
}
