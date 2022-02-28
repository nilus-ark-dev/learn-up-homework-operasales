package operasales.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NotifierAspect {

    private String email;

    @Pointcut("@annotation(operasales.annotations.Notifiable)")
    public void sendMsg() {}


    @After("sendMsg()")
    public void sendMsgAfter(JoinPoint point) {
        // Логика отправки письма после события
        print("Информация о покупке билета отправена получателю на почту " + email);
        print("Письмо отправлено после выполнения метода " + point.getSignature().getName() + "()\n");
    }

    private void print(Object o) {
        System.out.println(o);
    }
}
