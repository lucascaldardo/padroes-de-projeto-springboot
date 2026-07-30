package lucas.padroes_de_projeto_springboot.controller;

import lucas.padroes_de_projeto_springboot.model.Cliente;
import lucas.padroes_de_projeto_springboot.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/todos")
    public ResponseEntity<Iterable<Cliente>> buscarTodos(){
        clienteService.buscarTodos();
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        clienteService.buscarPorId(id);
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping("/criar")
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente){
        Cliente clienteSalvo = clienteService.inserir(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
        Cliente clienteAtualizado = clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
