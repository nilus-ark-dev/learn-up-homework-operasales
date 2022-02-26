package operasales;

import operasales.events.Premiere;

import operasales.services.PremiereService;
import operasales.services.TicketService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OperaSalesApplication {

	public static void main(String[] args) {
		final ConfigurableApplicationContext ctx = SpringApplication.run(OperaSalesApplication.class, args);
		ctx.getBean(PremiereService.class).addPremiere("Призрак Оперы", "Опера в трех действиях", 16, 250, 250);
		ctx.getBean(PremiereService.class).addPremiere("Кармен", "Опера в двух действиях", 18, 50, 50);
		ctx.getBean(PremiereService.class).addPremiere("Евгений Онегин", "Опера", 12, 300, 300);

		ctx.getBean(PremiereService.class).showAllPremieres();
		ctx.getBean(PremiereService.class).showPremiere("Призрак Оперы");

		ctx.getBean(PremiereService.class).deletePremiere("Призрак Оперы");
		ctx.getBean(PremiereService.class).showAllPremieres();

		ctx.getBean(PremiereService.class).editPremiere("Евгений Онегин", new Premiere("Евгений Онегин", "Опера в двух действиях", 21, 150, 150));
		ctx.getBean(PremiereService.class).showPremiere("Евгений Онегин");

		ctx.getBean(TicketService.class).buyTicket("Армен");
		ctx.getBean(TicketService.class).buyTicket("Кармен");

		ctx.getBean(TicketService.class).returnTicket("Кармен");
		ctx.getBean(PremiereService.class).showPremiere("Кармен");
	}
}
