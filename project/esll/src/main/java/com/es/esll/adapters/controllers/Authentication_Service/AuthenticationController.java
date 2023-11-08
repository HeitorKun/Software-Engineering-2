import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/ControllerAuthorization")
public class AuthenticationController {
    
    @Autowired
    public AuthenticationController(){

    }

    //@GetMapping("/authorize")
    @CrossOrigin(origins = "*")
    public String authorize(@RequestParam final String token) {

        if("A".equals(token)){
            return "Yes";
        }
        return "No";
    }
}
