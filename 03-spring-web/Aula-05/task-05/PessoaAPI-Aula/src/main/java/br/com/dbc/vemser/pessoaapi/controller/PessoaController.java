package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.CreatePessoaDto;
import br.com.dbc.vemser.pessoaapi.dto.ResponsePessoaDto;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/pessoa") // localhost:8081/pessoa
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping // GET localhost:8081/pessoa
    public ResponseEntity<List<ResponsePessoaDto>> list() throws RegraDeNegocioException {
        log.info("Buscando todas as pessoas");
        List<ResponsePessoaDto> pessoaList = pessoaService.list();
        log.info("Buscou todas as pessoas");
        return new ResponseEntity<>(pessoaList, HttpStatus.OK);
    }

    @GetMapping("/") // GET localhost:8081/pessoa/?nome=Rafa
    public ResponseEntity<List<ResponsePessoaDto>> listByName(@RequestParam("nome") @NotEmpty @Valid String nome) throws Exception{
        log.info("Buscando pessoas pelo nome {}", nome);
        List<ResponsePessoaDto> pessoaList = pessoaService.listByName(nome);
        log.info("Buscou pessoas pelo nome {}", nome);
        return new ResponseEntity<>(pessoaList, HttpStatus.OK);
    }

    @PostMapping // POST localhost:8081/pessoa
    public ResponseEntity<ResponsePessoaDto> create(@Valid @RequestBody CreatePessoaDto pessoa) throws Exception {
        log.info("Criando pessoa");
        ResponsePessoaDto createdPessoa = pessoaService.create(pessoa);
        log.info("Criou pessoa");
        return new ResponseEntity<>(createdPessoa, HttpStatus.CREATED);
    }

    @PutMapping("/{idPessoa}") // PUT localhost:8081/pessoa/1000
    public ResponseEntity<ResponsePessoaDto> update(@PathVariable("idPessoa") @Valid Integer id,
                                         @RequestBody @Valid CreatePessoaDto pessoaAtualizar) throws Exception {
        log.info("Atualizando pessoa com id {}", id);
        ResponsePessoaDto updatedPessoa = pessoaService.update(id, pessoaAtualizar);
        log.info("Atualizou pessoa com id {}", id);
        return new ResponseEntity<>(updatedPessoa, HttpStatus.OK);
    }

    @DeleteMapping("/{idPessoa}") // DELETE localhost:8081/pessoa/10
    public ResponseEntity<String> delete(@PathVariable("idPessoa") @Valid Integer id) throws Exception {
        log.info("Deletando pessoa com id {}", id);
        pessoaService.delete(id);
        log.info("Deletou pessoa com id {}", id);
        return new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK);
    }
}