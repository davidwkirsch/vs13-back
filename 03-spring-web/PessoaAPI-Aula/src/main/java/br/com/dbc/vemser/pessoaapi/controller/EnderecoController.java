package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco") // localhost:8080/endereco
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {

        this.enderecoService = enderecoService;
    }

    @GetMapping // GET localhost:8080/endereco
    public List<Endereco> list() {
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}") // GET localhost:8081/endereco/?pessoa=1
    public List<Endereco> listByName(@RequestParam("pessoa") Integer idPessoa) {
        return enderecoService.listByIdPessoa(idPessoa);
    }

    @GetMapping("//{idPessoa}/pessoa") // GET localhost:8081/endereco/?pessoa=1
    public List<Endereco> listByName(@RequestParam("pessoa") Integer idPessoa) {
        return enderecoService.listByIdPessoa(idPessoa);
    }

    @PostMapping // POST localhost:8080/endereco
    public Endereco create(@RequestBody Endereco endereco) {
        return enderecoService.create(endereco);
    }

    @PutMapping("/{idEndereco}") // PUT localhost:8080/endereco/1000
    public Endereco update(@PathVariable("idEndereco") Integer id,
                         @RequestBody Endereco enderecoAtualizar) throws Exception {
        return enderecoService.update(id, enderecoAtualizar);
    }

    @DeleteMapping("/{idEndereco}") // DELETE localhost:8080/endereco/10
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }
}
