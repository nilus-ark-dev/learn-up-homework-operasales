package operasales;

import operasales.services.interfaces.PremiereService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EntityScan({"operasales.events"})
public class OperaSalesApplication {

	public static void main(String[] args) {
		final ConfigurableApplicationContext ctx = SpringApplication.run(OperaSalesApplication.class, args);
		final PremiereService premiereService = ctx.getBean(PremiereService.class);

		premiereService.addPremiere("Кармэн", "Опера в двух действиях", 12, 250, 250);
		premiereService.addPremiere("Призрак Оперы", "Опера в трех действиях", 18, 350, 350);

		premiereService.showAllPremieres();
		premiereService.showPremiere("Призрак Оперы");
	}
}
