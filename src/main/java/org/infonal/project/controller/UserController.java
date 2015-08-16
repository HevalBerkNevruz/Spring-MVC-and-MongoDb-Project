package org.infonal.project.controller;

import com.google.code.kaptcha.servlet.KaptchaExtend;
import org.apache.log4j.Logger;
import org.infonal.project.model.User;
import org.infonal.project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by heval-Computer on 23.2.2015.
 */

@Controller
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    private KaptchaExtend kaptchaExtend = new KaptchaExtend();

    @Autowired
    private IUserService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView pageLoad(ModelAndView modelAndView) {
        User user = new User();
        List<User> userList = service.getAllUser();
        modelAndView.addObject("user", user);
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("usermanagement");
        return modelAndView;
    }

    @RequestMapping(value = "/newuser/{captcha}", method = RequestMethod.POST)
    public
    @ResponseBody
    User addUser(@RequestBody User user, @PathVariable String captcha, HttpServletRequest request) {
        if (captcha.equals(kaptchaExtend.getGeneratedKey(request))) {
            service.addUser(user);
            logger.debug("Captcha is True");
        } else {
            logger.error("Captcha Error");
        }
        return user;
    }

    @RequestMapping(value = "/edituser", method = RequestMethod.POST)
    public
    @ResponseBody
    User editUser(@RequestBody User user) {
        service.addUser(user);
        return user;
    }

    @RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    void deleteUser(@PathVariable String id) {
        service.deleteUser(id);
    }
}