package lucas.padroes_de_projeto_springboot.service.impl;

import lucas.padroes_de_projeto_springboot.model.Cliente;
import lucas.padroes_de_projeto_springboot.model.Endereco;
import lucas.padroes_de_projeto_springboot.repository.ClienteRepository;
import lucas.padroes_de_projeto_springboot.repository.EnderecoRepository;
import lucas.padroes_de_projeto_springboot.service.ClienteService;
import lucas.padroes_de_projeto_springboot.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public Cliente inserir(Cliente cliente) {
        return salvarClienteComCep(cliente);
    }


    @Override
    public Cliente atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()){
            return salvarClienteComCep(cliente);
        }
        return null;
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private Cliente salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        return clienteRepository.save(cliente);
    }
}
