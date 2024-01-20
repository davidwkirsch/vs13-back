package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.CreateEnderecoDto;
import br.com.dbc.vemser.pessoaapi.dto.ResponseEnderecoDto;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/endereco") // localhost:8080/endereco
public class EnderecoController {

    private final EnderecoService enderecoService;

    @GetMapping // GET localhost:8080/endereco
    public ResponseEntity<List<ResponseEnderecoDto>> list() {
        log.info("Buscando todos os endereços");
        List<ResponseEnderecoDto> enderecoList = enderecoService.list();
        log.info("Buscou todos os endereços");
        return new ResponseEntity<>(enderecoList, HttpStatus.OK);
    }

    @GetMapping("/{idEndereco}") // GET localhost:8081/endereco/?pessoa=1
    public ResponseEntity<Endereco> listByIdEndereco(@PathVariable("idEndereco") @Valid Integer idEndereco) throws Exception {
        log.info("Buscando endereço com id {}", idEndereco);
        Endereco endereco = enderecoService.getEnderecoById(idEndereco);
        log.info("Buscou endereço com id {}", idEndereco);
        return new ResponseEntity<>(endereco, HttpStatus.OK);
    }

    @GetMapping("/{idPessoa}/pessoa") // GET localhost:8081/endereco/?pessoa=1
    public ResponseEntity<List<ResponseEnderecoDto>> listByIdPessoa(@PathVariable("idPessoa") @Valid Integer idPessoa) throws Exception {
        log.info("Buscando endereços para pessoa com id {}", idPessoa);
        List<ResponseEnderecoDto> enderecoList = enderecoService.getByIdPessoa(idPessoa);
        log.info("Buscou endereços para pessoa com id {}", idPessoa);
        if (enderecoList.isEmpty()) {
            return new ResponseEntity<>(enderecoList, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(enderecoList, HttpStatus.OK);
        }
    }

    @PostMapping("/{idPessoa}")// POST localhost:8080/endereco
    public ResponseEntity<ResponseEnderecoDto> create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody @Valid CreateEnderecoDto endereco) throws Exception {
        log.info("Criando endereço para pessoa com id {}", idPessoa);
        ResponseEnderecoDto createdEndereco = enderecoService.create(idPessoa, endereco);
        log.info("Criou endereço para pessoa com id {}", idPessoa);
        return new ResponseEntity<>(createdEndereco, HttpStatus.CREATED);
    }

    @PutMapping("/{idEndereco}") // PUT localhost:8080/endereco/1000
    public ResponseEntity<ResponseEnderecoDto> update(@PathVariable("idEndereco") @Valid Integer id,
                           @RequestBody @Valid CreateEnderecoDto enderecoAtualizar) throws Exception {
        log.info("Atualizando endereço com id {}", id);
        enderecoAtualizar.setIdEndereco(id);
        ResponseEnderecoDto updatedEndereco = enderecoService.update(enderecoAtualizar);
        log.info("Atualizou endereço com id {}", id);
        return new ResponseEntity<>(updatedEndereco, HttpStatus.OK);
    }

    @DeleteMapping("/{idEndereco}") // DELETE localhost:8080/endereco/10
    public ResponseEntity<String> delete(@PathVariable("idEndereco") @Valid Integer id) throws Exception {
        log.info("Deletando endereço com id {}", id);
        enderecoService.delete(id);
        log.info("Deletou endereço com id {}", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}