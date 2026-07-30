package lucas.padroes_de_projeto_springboot.service;

import lucas.padroes_de_projeto_springboot.model.Cliente;

public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    Cliente inserir(Cliente cliente);

    Cliente atualizar(Long id, Cliente cliente);

    void deletar(Long id);

}
