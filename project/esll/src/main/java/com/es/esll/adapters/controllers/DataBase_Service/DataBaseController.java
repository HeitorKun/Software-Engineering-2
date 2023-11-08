import com.es.esll.adapters.controllers.DataBaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Completar")
public class DataBaseController {
    
    @Autowired
    public DataBaseController(){
    }

    // 1. Registra o user: username e password
    @PostMapping("/createUser") 
    @CrossOrigin(origins = "*")
    public String createUser(@RequestBody final User user) {
        return "Log createUser";
    }

    //2. Consulta um estudante pelo número de matrícula;
    @GetMapping("/Completar")
    @CrossOrigin(origins = "*")
    public String studentByCode(@RequestParam final int studentCode) {
        return "Completar";
    }
}
