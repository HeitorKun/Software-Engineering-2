import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@Entity(name = "usuario")
public class User {
    @Id
    private int id;
    String nome;
    String tipo;
}
