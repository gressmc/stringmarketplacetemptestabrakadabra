package grs.epam.data.controller;

import grs.epam.data.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
    private GenericService userService;

    @RequestMapping
    public ModelAndView save(ModelAndView modelAndView) {
//        modelAndView.setViewName("people");
        return new ModelAndView("index", "user", userService.findAll());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam(value = "login") String login,
                             @RequestParam(value = "password") String password, ModelAndView modelAndView) {

//        userService.create(new UserDTO(login, password));
        modelAndView.addObject("userName", login);
        modelAndView.setViewName("success");
        return modelAndView;
    }



    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam(value = "login") String login,
                             @RequestParam(value = "password") String password, ModelAndView modelAndView) {

//        userService.create(new UserDTO(login, password));
        modelAndView.addObject("userName", login);
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
