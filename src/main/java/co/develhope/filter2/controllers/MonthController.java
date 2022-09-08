package co.develhope.filter2.controllers;


import co.develhope.filter2.entities.Month;
import co.develhope.filter2.filters.MonthInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController@RequestMapping("/months")
public class MonthController extends MonthInterceptor {


    @GetMapping("")
    public Optional<Month> get(HttpServletRequest request){
        Optional<Month> month = (Optional<Month>) request.getAttribute("month");
        return month;
    }
}
