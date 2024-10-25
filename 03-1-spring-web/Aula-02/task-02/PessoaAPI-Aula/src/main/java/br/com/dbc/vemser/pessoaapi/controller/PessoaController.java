package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8081/pessoa
public class PessoaController {

    private PessoaService pessoaService;

    public PessoaController() {
        pessoaService = new PessoaService();
    }

    @GetMapping // GET localhost:8081/pessoa
    public List<Pessoa> list() {
        return pessoaService.list();
    }

    @GetMapping("/") // GET localhost:8081/pessoa/?nome=Rafa
    public List<Pessoa> listByName(@RequestParam("nome") String nome) {
                return pessoaService.listByName(nome);
    }

    @PostMapping // POST localhost:8081/pessoa
    public Pessoa create(@RequestBody Pessoa pessoa) {
        
        return pessoaService.create(pessoa);
    }

    @PutMapping("/{idPessoa}") // PUT localhost:8081/pessoa/1000
    public Pessoa update(@PathVariable("idPessoa") Integer id,
                         @RequestBody Pessoa pessoaAtualizar) throws Exception {
        return pessoaService.update(id, pessoaAtualizar);
    }

    @DeleteMapping("/{idPessoa}") // DELETE localhost:8081/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}
