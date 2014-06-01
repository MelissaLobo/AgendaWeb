package persistencia;

import java.util.List;

import model.Contato;

public interface AgendaDAO {
	
	Contato salvaContato(Contato contato);
    Contato buscaContatoPorID(Long id);
    List<Contato> buscaTodosOsContatos();
    void deletarPorNome(String contato);
  
    
}

