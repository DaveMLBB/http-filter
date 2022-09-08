package co.develhope.filter2.filters;

import co.develhope.filter2.entities.Month;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    public static List<Month> monthList = new ArrayList<>(Arrays.asList(
            new Month(1, "january","gennaio","januar"),
            new Month(2, "february","febbraio","februar"),
            new Month(3, "march", "marzo","marz"),
            new Month(4,"april","aprile","april"),
            new Month(5,",may","maggio","mai"),
            new Month(6,"june","giugno","juni")
    ));

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String monthNumberString = request.getHeader("monthNumber");
        Optional<Month> emptyMonth = Optional.of(new Month("nope", "nope", "nope"));

        if(     monthNumberString == null   ||
                monthNumberString.isBlank()){
            System.out.println(emptyMonth);
            request.setAttribute("month", emptyMonth);
            response.setStatus(404);
            return true;
        }

        int monthNumber = Integer.parseInt(monthNumberString);

        Optional<Month> monthFound = monthList.stream().filter(singleMonth ->{
            return singleMonth.getMonthNumber() == monthNumber;
        }).findFirst();

        if(!monthFound.isPresent()){
            System.out.println(emptyMonth);
            request.setAttribute("month", emptyMonth);
            response.setStatus(404);
            return true;
        }
        request.setAttribute("month", monthFound);
        System.out.println(monthFound);
        response.setStatus(200);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
