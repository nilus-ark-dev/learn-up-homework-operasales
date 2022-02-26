package operasales.services;

import org.springframework.stereotype.Component;

@Component
public class ConsoleLogger implements Logger {

    @Override
    public void log(Object o) {
        System.out.println(o);
    }
}
