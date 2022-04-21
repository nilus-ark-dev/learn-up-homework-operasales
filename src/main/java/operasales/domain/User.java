package operasales.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class User implements UserDetails {

    private String login;
    private String pass;
    private List<String> authoritiesNames;

    public User(String login, String pass, List<String> authoritiesNames) {
        this.login = login;
        this.pass = pass;
        this.authoritiesNames = authoritiesNames;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authoritiesNames.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(toList());
    }

    @Override
    public String getPassword() {
        return pass;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
