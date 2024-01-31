package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.controller.interfaces.IContatoController;
import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Tag(name = "ContatoEntity", description = "Endpoints do CRUD de ContatoEntity")
@RestController
@RequestMapping("/contato") // localhost:8080/contato
public class ContatoController implements IContatoController {

    private final ContatoService contatoService;

    @GetMapping // GET localhost:8080/contato
    public ResponseEntity<List<ContatoDTO>> list() throws RegraDeNegocioException {
        log.info("Buscando todos os contatos");
        List<ContatoDTO> contatoList = contatoService.list();
        log.info("Buscou todos os contatos");
        return new ResponseEntity<>(contatoList, HttpStatus.OK);
    }

    @GetMapping("/{idContato}") // GET localhost:8081/contato/1
    public ResponseEntity<ContatoDTO> listByIdContato(@PathVariable("idContato") @Valid Integer idContato) throws Exception {
        log.info("Buscando contato com o id {}", idContato);
        ContatoDTO contatoList = contatoService.listByIdContato(idContato);
        log.info("Buscou contato com o id {}", idContato);
        return new ResponseEntity<>(contatoList, HttpStatus.OK);
    }

    @PostMapping // POST localhost:8080/contato
    public ResponseEntity<ContatoDTO> create(@RequestBody @Valid ContatoCreateDTO contato) throws Exception {
        log.info("Criando contato");
        contato.setNumero(contato.getNumero().replaceAll("[^0-9]", ""));
        ContatoDTO createdContato = contatoService.create(contato);
        log.info("Criou contato");
        return new ResponseEntity<>(createdContato, HttpStatus.CREATED);
    }

    @PutMapping("/{idContato}") // PUT localhost:8080/contato/1000
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") @Valid Integer id,
                                             @RequestBody @Valid ContatoCreateDTO contatoAtualizar) throws Exception {
        log.info("Atualizando contato com id {}", id);
        ContatoDTO updatedContato = contatoService.update(id, contatoAtualizar);
        log.info("Atualizou contato com id {}", id);
        return new ResponseEntity<>(updatedContato, HttpStatus.OK);
    }

    @DeleteMapping("/{idContato}") // DELETE localhost:8080/contato/10
    public ResponseEntity<String> delete(@PathVariable("idContato") @Valid Integer id) throws Exception {
        log.info("Deletando contato com id {}", id);
        contatoService.delete(id);
        log.info("Deletou contato com id {}", id);
        return new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK);
    }
}