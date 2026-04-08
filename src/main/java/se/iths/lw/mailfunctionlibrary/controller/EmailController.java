package se.iths.lw.mailfunctionlibrary.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.iths.lw.mailfunctionlibrary.model.Email;
import se.iths.lw.mailfunctionlibrary.service.MessageService;

@Controller
@RequestMapping("/email")
public class EmailController {

    private MessageService messageService;

    public EmailController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String showForm(Model model){
        model.addAttribute("email", new Email());
        return "form";
    }

    @PostMapping
    public String mail(@ModelAttribute Email email, RedirectAttributes redirectAttribute, Model model) {
        messageService.send(email);
        redirectAttribute.addFlashAttribute("success", "Mail skickat.");
        return "redirect:/email";
    }
}
