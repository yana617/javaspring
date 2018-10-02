package dispatcher.controller;

import model.BirthdayResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BirthdayController {
    @RequestMapping("/birthday")
    public String home(String inputDate, Model model){
        System.out.println(inputDate);
        BirthdayResolver date = new BirthdayResolver(inputDate);
        model.addAttribute("inputDate", inputDate);
        model.addAttribute("daysCount",date.timeBeforeBirthdayAndYearsOld());
        return "index";
    }
}