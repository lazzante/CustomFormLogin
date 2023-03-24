package laurentiuspilca.managing_users_lesson_01.services;

import laurentiuspilca.managing_users_lesson_01.repositories.UserRepository;
import laurentiuspilca.managing_users_lesson_01.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username){
        var user = userRepository.findUserByUsername(username);

        return user.map(SecurityUser::new)
                .orElseThrow(()->new UsernameNotFoundException("Username Not Found - "+username));
    }
}
