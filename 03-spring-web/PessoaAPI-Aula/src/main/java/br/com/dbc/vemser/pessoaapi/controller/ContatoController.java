package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato") // localhost:8080/contato
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {

        this.contatoService = contatoService;
    }

    @GetMapping // GET localhost:8080/contato
    public List<Contato> list() {

        return contatoService.list();
    }

    @GetMapping("/{idContato}") // GET localhost:8081/contato/1
    public List<Contato> listByName(@PathVariable("idContato") @Valid Integer idPessoa) {
        return contatoService.listByIdPessoa(idPessoa);
    }

    @PostMapping // POST localhost:8080/contato
    public Contato create(@RequestBody @Valid Contato contato) throws Exception {

        contato.setNumero(contato.getNumero().replaceAll("[^0-9]", ""));
        return contatoService.create(contato);
    }
    @PutMapping("/{idContato}") // PUT localhost:8080/contato/1000
    public Contato update(@PathVariable("idContato") @Valid Integer id,
                         @RequestBody @Valid Contato contatoAtualizar) throws Exception {
        return contatoService.update(id, contatoAtualizar);
    }
    @DeleteMapping("/{idContato}") // DELETE localhost:8080/contato/10
    public void delete(@PathVariable("idContato") @Valid Integer id) throws Exception {
        contatoService.delete(id);
    }
}
