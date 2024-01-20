package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.CreateContatoDto;
import br.com.dbc.vemser.pessoaapi.dto.ResponseContatoDto;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/contato") // localhost:8080/contato
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping // GET localhost:8080/contato
    public ResponseEntity<List<ResponseContatoDto>> list() {
        log.info("Buscando todos os contatos");
        List<ResponseContatoDto> contatoList = contatoService.list();
        log.info("Buscou todos os contatos");
        return new ResponseEntity<>(contatoList, HttpStatus.OK);
    }

    @GetMapping("/{idContato}") // GET localhost:8081/contato/1
    public ResponseEntity<List<ResponseContatoDto>> listByName(@PathVariable("idContato") @Valid Integer idPessoa) throws Exception {
        log.info("Buscando contatos pelo id {}", idPessoa);
        List<ResponseContatoDto> contatoList = contatoService.listByIdPessoa(idPessoa);
        log.info("Buscou contatos pelo id {}", idPessoa);
        return new ResponseEntity<>(contatoList, HttpStatus.OK);
    }

    @PostMapping // POST localhost:8080/contato
    public ResponseEntity<ResponseContatoDto> create(@RequestBody @Valid CreateContatoDto contato) throws Exception {
        log.info("Criando contato");
        contato.setNumero(contato.getNumero().replaceAll("[^0-9]", ""));
        ResponseContatoDto createdContato = contatoService.create(contato);
        log.info("Criou contato");
        return new ResponseEntity<>(createdContato, HttpStatus.CREATED);
    }

    @PutMapping("/{idContato}") // PUT localhost:8080/contato/1000
    public ResponseEntity<ResponseContatoDto> update(@PathVariable("idContato") @Valid Integer id,
                                         @RequestBody @Valid CreateContatoDto contatoAtualizar) throws Exception {
        log.info("Atualizando contato com id {}", id);
        ResponseContatoDto updatedContato = contatoService.update(id, contatoAtualizar);
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
//@Slf4j
//@RestController
//@RequestMapping("/contato") // localhost:8080/contato
//public class ContatoController {
//
//    private final ContatoService contatoService;
//
//    public ContatoController(ContatoService contatoService) {
//
//        this.contatoService = contatoService;
//    }
//
//    @GetMapping // GET localhost:8080/contato
//    public List<ResponseContatoDto> list() {
//
//        return contatoService.list();
//    }
//
//    @GetMapping("/{idContato}") // GET localhost:8081/contato/1
//    public List<ResponseContatoDto> listByName(@PathVariable("idContato") @Valid Integer idPessoa) throws Exception {
//        return contatoService.listByIdPessoa(idPessoa);
//    }
//
//    @PostMapping // POST localhost:8080/contato
//    public ResponseContatoDto create(@RequestBody @Valid CreateContatoDto contato) throws Exception {
//        log.debug("Controller | Criando pessoa ");
//        contato.setNumero(contato.getNumero().replaceAll("[^0-9]", ""));
//        return contatoService.create(contato);
//    }
//    @PutMapping("/{idContato}") // PUT localhost:8080/contato/1000
//    public ResponseContatoDto update(@PathVariable("idContato") @Valid Integer id,
//                         @RequestBody @Valid CreateContatoDto contatoAtualizar) throws Exception {
//        return contatoService.update(id, contatoAtualizar);
//    }
//    @DeleteMapping("/{idContato}") // DELETE localhost:8080/contato/10
//    public ResponseEntity<String> delete(@PathVariable("idContato") @Valid Integer id) throws Exception {
//        contatoService.delete(id);
//        return new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK);
//    }
//}
