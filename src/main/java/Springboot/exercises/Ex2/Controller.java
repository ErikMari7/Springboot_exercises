package Springboot.exercises.Ex2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2")
public class Controller {
    @GetMapping("/ciao/Lombardia")
    public User ciao(@RequestParam String nome){
        String provincia = "Lombardia";
        String saluto = null;

        return new User(nome,provincia,saluto);
    }

}
