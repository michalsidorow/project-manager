package com.projectmanager.projectmanager.Controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AppErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError(HttpServletRequest request){
        Object attribute = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if(attribute!=null){
            Integer statusCode = Integer.valueOf(attribute.toString());
            if(attribute == HttpStatus.NOT_FOUND){
                return "errorPages/error-404";
            }else if(attribute == HttpStatus.INTERNAL_SERVER_ERROR){
                return "errorPages/error-500";
            }else if(attribute == HttpStatus.FORBIDDEN){
                return "errorPages/error-403";
            }
        }
        return "errorPages/error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
