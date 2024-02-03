package Springboot.exercises.Libri;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/v1")
public class Controller {
    List<Libri> libriList = new ArrayList<>();

    public Controller(){
        libriList.add(new Libri(1,"Naruto","ciccio","Anime"));
        libriList.add(new Libri(2,"Il signore degli anelli","Tolkien","Fantasy"));
        libriList.add(new Libri(3,"Il codice da Vinci","Dan Brown","Giallo"));
    }
    @GetMapping("/libri1/{id}")
    public Libri getLibriById(@PathVariable int id){
        for(Libri libri: libriList) {
            if(id == libri.getId()){
                return libri;
            }
        }
        return null;
    }

    @GetMapping("/libri2")
    public List<Libri> getLibriList(){
        return libriList;
    }

    @GetMapping("/libri3/{genere}")
    public Libri getLibriByGenere(@PathVariable String genere){
        for(Libri libri: libriList) {
            if(genere.equals(libri.getGenere())){
                return libri;
            }
        }
        return null;
    }
}
