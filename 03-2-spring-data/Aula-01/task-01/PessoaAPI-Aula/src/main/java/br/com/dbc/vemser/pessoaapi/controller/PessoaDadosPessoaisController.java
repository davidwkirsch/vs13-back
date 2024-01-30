package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PessoaDadosPessoaisDTO;
import br.com.dbc.vemser.pessoaapi.service.PessoaDadosPessoaisService;
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
@Tag(name = "PessoaEntity & Dados Pessoais", description = "Endpoints do CRUD de PessoaEntity & Dados Pessoais")
@RestController
@RequestMapping("/pessoa-dados-pessoais")
public class PessoaDadosPessoaisController {

    private final PessoaDadosPessoaisService pessoaDadosPessoaisService;

//
//    @GetMapping // GET localhost:8081/pessoa-dados-pessoais
//    public ResponseEntity<List<PessoaDadosPessoaisDTO>> list() throws Exception {
//        log.info("Buscando todas as pessoas");
//        List<PessoaDadosPessoaisDTO> pessoaList = pessoaDadosPessoaisService.list();
//        log.info("Buscou todas as pessoas");
//        return new ResponseEntity<>(pessoaList, HttpStatus.OK);
//    }
//
//    @GetMapping("/{cpf}") // GET localhost:8081/pessoa-dados-pessoais/1000
//    public ResponseEntity<?> listByCpf(@PathVariable("cpf") String cpf) throws Exception {
//        log.info("Buscando pessoa com cpf {}", cpf);
//        List<PessoaDadosPessoaisDTO> pessoaList = pessoaDadosPessoaisService.listByCpf(cpf);
//        log.info("Buscou pessoa com cpf {}", cpf);
//        return new ResponseEntity<>(pessoaList, HttpStatus.OK);
//    }
//
//    @PutMapping("/{cpf}") // PUT localhost:8081/pessoa-dados-pessoais/1000
//    public ResponseEntity<PessoaDadosPessoaisDTO> update(@PathVariable("cpf") String cpf,
//                                                          @RequestBody @Valid PessoaDadosPessoaisDTO pessoaAtualizar) throws Exception {
//        log.info("Atualizando pessoa com cpf {}", cpf);
//        pessoaAtualizar.setCpf(cpf);
//        PessoaDadosPessoaisDTO updatedPessoa = pessoaDadosPessoaisService.update(pessoaAtualizar);
//        log.info("Atualizou pessoa com cpf {}", cpf);
//        return new ResponseEntity<>(updatedPessoa, HttpStatus.OK);
//    }
//
//    @PostMapping // POST localhost:8081/pessoa-dados-pessoais
//    public ResponseEntity<PessoaDadosPessoaisDTO> create(@RequestBody PessoaDadosPessoaisDTO pessoaDadosPessoaisDTO) throws Exception {
//        log.info("Criando pessoa");
//        PessoaDadosPessoaisDTO createdPessoa = pessoaDadosPessoaisService.create(pessoaDadosPessoaisDTO);
//        log.info("Criou pessoa");
//        return new ResponseEntity<>(createdPessoa, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/{cpf}") // DELETE localhost:8081/pessoa-dados-pessoais/1000
//    public ResponseEntity<String> delete(@PathVariable("cpf") String cpf) throws Exception {
//        log.info("Deletando pessoa com cpf {}", cpf);
//        pessoaDadosPessoaisService.delete(cpf);
//        log.info("Deletou pessoa com cpf {}", cpf);
//        return new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK);
//    }

}
