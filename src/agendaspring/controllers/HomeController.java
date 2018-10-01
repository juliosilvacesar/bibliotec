package agendaspring.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
	public void home()	{
		System.out.println("Chamou o meu controller");
	}

}
