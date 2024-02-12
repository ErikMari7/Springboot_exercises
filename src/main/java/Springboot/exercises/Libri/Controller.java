package Springboot.exercises.Libri;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

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
    @Operation(summary = "Restituisce un libro da un id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "OK"),
            @ApiResponse(responseCode = "400",description = "bad request")
    })
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
    public List<Libri> getLibriByGenere(@PathVariable String genere){
        List<Libri> libriGenere = new ArrayList<>();
        for(Libri libri: libriList) {
            if(genere.equals(libri.getGenere())){
                libriGenere.add(libri);
            }
        }
        return libriGenere;
    }

    @PostMapping("/libri4/add")
    public String addBook(@RequestBody Libri newBook){
        libriList.add(newBook);
        return newBook.toString();
    }
}
