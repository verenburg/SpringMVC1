package org.example.ontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/h") // здесь в скобках пишем относительный путь до того что будем вызвать.
    public String sayHello() {
        return "First/hello"; // здесь пишем путь до HTML файла который бедем возвращать по запросу из getMapping/
    }
}
