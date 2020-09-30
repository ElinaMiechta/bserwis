package com.budserwis.javacore.api.manager;

import com.budserwis.javacore.domain.Product;
import com.budserwis.javacore.domain.exception.UserDoesNotExist;
import com.budserwis.javacore.infrastructure.manager.ManagerService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import java.io.IOException;
import java.io.InputStream;


@RestController
@CrossOrigin
@MultipartConfig
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

        if (manager != null) {
            return new ModelAndView("redirect:" + url + "/views/admin/admin.html");
        } else {
            return null; // TODO: handle else block
        }
    }

    @PostMapping("/budserwis/admin/save+new+product.do")
    public ResponseEntity addProductToDB(@RequestParam("productTitle") String title, @RequestParam(value = "image") MultipartFile image,
                                         @RequestParam("productDescr") String descr, @RequestParam("productPrice") Long price,
                                         @RequestParam("productCategory") String category) throws IOException, ServletException {

        /*Image upload handler part*/
        InputStream fileContent = image.getInputStream();
        byte[] imageToDB = IOUtils.toByteArray(fileContent);

        var product = new Product(imageToDB, title, descr, price, category);
        service.saveNewProductToDB(product);

        return new ResponseEntity(HttpStatus.OK);
    }
}
