package grs.epam.data.service;

import grs.epam.data.dao.modelDAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service("customUserDetailsService")
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String s) {
        grs.epam.data.model.User user = userDAO.findByUserName(s);

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        String login = "guest";
        String password = "";
        Integer role = 1;

        if (user != null) {
            login = user.getLogin();
            password = user.getPassword();
            role = 2;
        }

        return new User(login, password,
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(role));
    }

    public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
        return getGrantedAuthorities(getRoles(role));
    }

    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    public List<String> getRoles(Integer role) {
        List<String> roles = new ArrayList<>();

        if (role == 1) {
            roles.add("ROLE_ANONYMOUS");
        } else if (role == 2) {
            roles.add("ROLE_USER");
        }

        return roles;
    }
}
