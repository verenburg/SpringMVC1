package org.example.ontrollers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {
    @GetMapping("/hello") // Если нужен целиком объект то можно в параметры метода передать объект HttpServletRequest
    public String seyHello(HttpServletRequest request) {
        String name = request.getParameter("name" );
        String surname = request.getParameter("surname");

        System.out.println("Hello " + surname + " " + name);

        return "First/hello";
    }

    // Оба метода работают одинаково в части работы с параметрами

    @GetMapping("/goodbye") // Если нужны только параметры запроса, то лучше использовать аннотацию @RequestParam
    public  String seyGoodbye(@RequestParam(value = "name", required = false //если в запросе не будет этого параметра ошибка не возникнет
                                                                            )String name,
                              @RequestParam(value = "surname", required = false) String surname) {

        System.out.println("Goodbye " + surname + " " + name);

        return "First/goodbye";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam(value = "a", required = false) String a,
                            @RequestParam(value = "b", required = false) String b,
                            @RequestParam(value = "action", required = false) String action,
                            Model model) {

        double result = 0.0;
        String answer = "";
        boolean isActionCorrect = false;
        try {
            Integer first = Integer.parseInt(a);
            Integer second = Integer.parseInt(b);
            switch (action) {
                case "division":
                    result = first / (double)second;
                    isActionCorrect = true;
                    break;
                case "multiplication":
                    result = first * second;
                    isActionCorrect = true;
                    break;
                case "addition":
                    result = first + second;
                    isActionCorrect = true;
                    break;
                case "subtraction":
                    result = first - second;
                    isActionCorrect = true;
                    break;
            }
            if (!isActionCorrect)
                throw new RuntimeException();

            answer = "a " + action + " b = " + result;
        } catch (Exception e) {
            answer = "некорректно заданы параметры";
        }

        model.addAttribute("answer", answer);

        return "First/calculator";
    }

}
