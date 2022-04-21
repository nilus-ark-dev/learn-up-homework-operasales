package operasales.services;

import operasales.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.*;

import static java.util.Arrays.asList;

public class InMemoryDetailsUserService implements UserDetailsService {

    private Map<String, User> repository;

    private PasswordEncoder encoder;

    @Autowired
    public InMemoryDetailsUserService(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = repository.get(username);
        if (user == null) throw new UsernameNotFoundException("Пользователь не найден");
        return user;
    }

    @PostConstruct
    public void init() {
        repository = new HashMap<>();
        repository.put("guest",
                new User(
                        "guest",
                        encoder.encode("guest"),
                        asList("ROLE_GUEST")));
        repository.put("user",
                new User(
                        "user",
                        encoder.encode("user123"),
                        asList("ROLE_USER", "ROLE_GUEST")));
        repository.put("admin",
                new User(
                        "admin",
                        encoder.encode("admin123"),
                        asList("ROLE_USER", "ROLE_GUEST", "ROLE_ADMIN")));
    }
}
