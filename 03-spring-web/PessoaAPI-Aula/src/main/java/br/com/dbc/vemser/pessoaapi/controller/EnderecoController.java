package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.web.bind.annotation.*;
import javax.validation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
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
    public Endereco listByIdEndereco(@PathVariable("idEndereco") @Valid Integer idEndereco) throws Exception {
        return enderecoService.getEnderecoById(idEndereco);
    }
    @GetMapping("/{idPessoa}/pessoa") // GET localhost:8081/endereco/?pessoa=1
    public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") @Valid Integer idPessoa) throws Exception {
        return enderecoService.getByIdPessoa(idPessoa);
    }
    @PostMapping ("/{idPessoa}")// POST localhost:8080/endereco
    public Endereco create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody @Valid Endereco endereco) throws Exception{
        return enderecoService.create(idPessoa, endereco);
    }
    @PutMapping("/{idEndereco}") // PUT localhost:8080/endereco/1000
    public Endereco update(@PathVariable("idEndereco") @Valid Integer id,
                           @RequestBody @Valid Endereco enderecoAtualizar) throws Exception {
        enderecoAtualizar.setIdEndereco(id);
        return enderecoService.update(enderecoAtualizar);
    }
    @DeleteMapping("/{idEndereco}") // DELETE localhost:8080/endereco/10
    public void delete(@PathVariable("idEndereco") @Valid Integer id) throws Exception {
        enderecoService.delete(id);
    }
}
