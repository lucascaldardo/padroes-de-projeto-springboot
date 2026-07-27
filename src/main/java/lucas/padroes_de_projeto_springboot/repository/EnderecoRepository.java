package lucas.padroes_de_projeto_springboot.repository;

import lucas.padroes_de_projeto_springboot.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
