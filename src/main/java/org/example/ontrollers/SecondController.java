package org.example.ontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {
   @GetMapping("/exit")
   public String seyHello() {
       return "Second/exit";
   }
}
