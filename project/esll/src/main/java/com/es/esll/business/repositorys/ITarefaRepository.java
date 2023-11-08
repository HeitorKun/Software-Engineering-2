import java.util.List;

public interface ITarefaRepository {
    List<Comentario> todos();
    boolean cadastra(int idUs, int idRec, Comentario comentario);
    void removeTodos();
}

