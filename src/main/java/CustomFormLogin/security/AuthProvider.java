package CustomFormLogin.security;

import CustomFormLogin.repositories.UserRepository;
import CustomFormLogin.services.JpaUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@AllArgsConstructor
@Component
public class AuthProvider implements AuthenticationProvider {

    private JpaUserDetailsService jpaUserDetailsService;
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;




    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails u = jpaUserDetailsService.loadUserByUsername(username);

        if(passwordEncoder.matches(password,u.getPassword())){
            return new UsernamePasswordAuthenticationToken(username,password,u.getAuthorities());
        }
        else{
            throw new BadCredentialsException("Invaild Login Details");
        }

    }

   /* private Authentication checkPassword(UserDetails user,String rawPassword,PasswordEncoder encoder){
        if(encoder.matches(rawPassword,user.getPassword())){
            return new UsernamePasswordAuthenticationToken(
                    user.getUsername(),
                    user.getPassword(),
                    user.getAuthorities());
        }
        else {
            throw new BadCredentialsException("Bad credentials");
        }
    }
    
    */


    @Override
    public boolean supports(Class<?> authentication) {

        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
