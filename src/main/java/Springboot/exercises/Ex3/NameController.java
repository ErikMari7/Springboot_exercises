package Springboot.exercises.Ex3;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class NameController {
    @GetMapping("/name")
    public String getName(@RequestParam String name){
        return name;
    }

    @PostMapping("/reverse-name")
    public String reverseName(@RequestParam String name){
        StringBuilder reversedName = new StringBuilder(name);
        return reversedName.reverse().toString();
    }

}
