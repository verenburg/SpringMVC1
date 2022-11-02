package org.example.ontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransferDataToViewController {
    @GetMapping("/transfer") // Если нужны только параметры запроса, то лучше использовать аннотацию @RequestParam
    public  String seyGoodbye(@RequestParam(value = "name", required = false //если в запросе не будет этого параметра ошибка не возникнет
    )String name,
                              @RequestParam(value = "surname", required = false) String surname,
                              Model model) {

        model.addAttribute("message", "Transfer parametrs " + surname + " " + name);

        return "Transfer/datatransfer";
    }
}

