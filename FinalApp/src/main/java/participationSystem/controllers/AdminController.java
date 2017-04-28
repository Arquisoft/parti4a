package participationSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import participationSystem.domain.Configuration;
import participationSystem.domain.Sugerencia;
import participationSystem.services.AdminService;
import participationSystem.services.SuggestionService;
import participationSystem.services.SystemServices;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by pelay on 02/04/2017.
 */
@Controller
@Scope("session")
public class AdminController {


    private SystemServices systemService;
    private SuggestionService suggestionService;
    private AdminService adminService;
    @Autowired
    public  void setAdminService(AdminService adminService){
        this.adminService=adminService;
    }

    @Autowired
    public void setSuggestionService(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @Autowired
    public void setSystemService(SystemServices systemService) {
        this.systemService = systemService;
    }


    @RequestMapping(value = "/goToEdit")
    public String goToEdit(@RequestParam String idSug, HttpSession session, Model model) {
        Long id = Long.parseLong(idSug);
        Sugerencia sug = suggestionService.findById(id);
        model.addAttribute("suggestion",sug);

        return "/admin/editSuggestion";
    }


    @RequestMapping(value = "/editSuggestion")
    public String addSuggestion(@RequestParam String tituloSugerencia, @RequestParam String idSug, @RequestParam String contSugerencia, HttpSession session, Model model){
        Long id = Long.parseLong(idSug);
        Sugerencia sug = suggestionService.findById(id);



            adminService.editarSugerencia(sug, tituloSugerencia, contSugerencia);


        List<Sugerencia> listaSugerencias =suggestionService.findSugerenciaWithMinVotes();
        session.setAttribute("listaSugerencias", listaSugerencias);
        return "/admin/adminIndex";
    }

    @RequestMapping(value = "/goToAddWord")
    public String chargeWords(Model model){
        Configuration conf =  systemService.getConfiguration();
        List<String>listaPalabras = conf.getPalabrasNoPermitidas();
        model.addAttribute("palabras",listaPalabras);
        model.addAttribute("votes", conf.getMinimoVotos());
        return "/admin/addWord";
    }

    @RequestMapping(value = "/addWord")
    public String chargeWords(@RequestParam String word){
        adminService.addPalabraProhibida(word);
        return "/admin/addWord";
    }

    @RequestMapping(value = "/changeVotes")
    public String changeVotes(@RequestParam String votes, Model model){
        adminService.setMinimoVotos(Integer.parseInt(votes));
        Configuration conf =  systemService.getConfiguration();
        model.addAttribute("votes", conf.getMinimoVotos());
        return "/admin/addWord";
    }



}


