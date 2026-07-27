package lucas.padroes_de_projeto_springboot.repository;

import lucas.padroes_de_projeto_springboot.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
