package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/pessoa") // localhost:8081/pessoa
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {

        this.pessoaService = pessoaService;
    }
    @GetMapping // GET localhost:8081/pessoa
    public List<Pessoa> list() {
        return pessoaService.list();
    }
    @GetMapping("/") // GET localhost:8081/pessoa/?nome=Rafa
    public List<Pessoa> listByName(@RequestParam("nome") @Valid String nome) {
                return pessoaService.listByName(nome);
    }

    @PostMapping // POST localhost:8081/pessoa
    public ResponseEntity<Pessoa> create(@Valid @RequestBody Pessoa pessoa) throws Exception {
        return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.OK);
    }

    @PutMapping("/{idPessoa}") // PUT localhost:8081/pessoa/1000
    public ResponseEntity<Pessoa> update(@PathVariable("idPessoa") @Valid Integer id,
                                         @RequestBody @Valid Pessoa pessoaAtualizar) throws Exception {
        return new ResponseEntity<>(pessoaService.update(id, pessoaAtualizar), HttpStatus.OK);
    }
    @DeleteMapping("/{idPessoa}") // DELETE localhost:8081/pessoa/10
    public ResponseEntity<String> delete(@PathVariable("idPessoa") @Valid Integer id) throws Exception {
        pessoaService.delete(id);
        return new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK);
    }
}
