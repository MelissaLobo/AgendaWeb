package persistencia;

import java.util.List;

import model.Contato;
import model.Usuario;

public interface AgendaDAO {
	
	Contato salvaContato(Contato contato, Usuario usuario);
    Contato buscaContatoPorID(Long id);
    List<Contato> buscaTodosOsContatos(Usuario usuario);
    void deletarPorNome(String contato);
  
    
}

