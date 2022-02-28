package operasales.services;

import operasales.services.interfaces.Logger;
import org.springframework.stereotype.Component;

@Component
public class ConsoleLogger implements Logger {

    @Override
    public void log(Object o) {
        System.out.println(o);
    }
}
