package com.budserwis.javacore.api.manager;

import com.budserwis.javacore.domain.exception.UserDoesNotExist;
import com.budserwis.javacore.infrastructure.manager.ManagerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin
public class ManagerApi {
    private ManagerService service;
    @Value("${front.url}")
    private String url;

    public ManagerApi(ManagerService service) {
        this.service = service;
    }


    @RequestMapping(value = "/budserwis/admin/login", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        return new ModelAndView("redirect:" + url + "/views/admin/login.html");
    }

    @PostMapping("/budserwis/admin/page")
    public ModelAndView enterSystem(@RequestParam("username") String username, @RequestParam("password") String password) throws UserDoesNotExist {
        var manager = service.verifyManager(username, password);
        if (manager!=null) {
            return new ModelAndView("redirect:" + url + "/views/admin/admin.html");
        }else{
            return null; // TODO: handle else block
        }
    }





}
