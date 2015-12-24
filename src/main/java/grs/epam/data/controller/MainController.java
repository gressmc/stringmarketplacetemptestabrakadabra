package grs.epam.data.controller;

import grs.epam.data.dto.UserDTO;
import grs.epam.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value = "/")
public class MainController {

//    @Autowired
//    private UserService userService;

    @RequestMapping
    public ModelAndView save(ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam(value = "login") String login,
                             @RequestParam(value = "password") String password, ModelAndView modelAndView) {

//        userService.create(new UserDTO(login, password));
        modelAndView.addObject("userName", login);
        modelAndView.setViewName("success");
        return modelAndView;
    }

}
