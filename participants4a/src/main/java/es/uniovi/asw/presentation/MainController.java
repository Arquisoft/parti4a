package es.uniovi.asw.presentation;

import java.util.ArrayList;

//import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.uniovi.asw.business.Participant;
import es.uniovi.asw.dto.CitizenDTO;

@Controller
public class MainController {

	private Participant participant = new Participant();
	private CitizenDTO response;
	private UserInfo userInfo;

	@RequestMapping("/")
	public String landing(Model model) {
		model.addAttribute("login", new Login());
		return "WelcomePage";
	}

	@RequestMapping(value = "/showParticipantInfo", method = RequestMethod.POST)
	public String getPIP(@RequestParam Login login, Model model) {
		this.response = participant.getPR(login.getEmail(), login.getContrasena());
		userInfo = new UserInfo(login.getEmail(), login.getContrasena());
		ArrayList<Object> atributos = new ArrayList<Object>();
		atributos.add(this.response);
//		System.out.println("!!!!!!!!!!!!!!!!!!!!!MIRA AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII !!!!!!!!!!!!!!!!!!!!!!!!!!!");
//		System.out.println(atributos);
		model.addAttribute("atributes", atributos);
		return "InfoPage";
	}

}
