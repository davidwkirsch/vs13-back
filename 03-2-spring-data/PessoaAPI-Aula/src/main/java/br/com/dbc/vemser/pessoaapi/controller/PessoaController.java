package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Tag(name = "PessoaEntity", description = "Endpoints do CRUD de PessoaEntity")
@RestController
@RequestMapping( "/pessoa") // localhost:8081/pessoa
//public class PessoaController implements IPessoaController {
public class PessoaController {

    private final PessoaService pessoaService;
    private final ContatoService contatoService;

    @Hidden
    @GetMapping // GET localhost:8081/pessoa
    public ResponseEntity<List<PessoaDTO>> list() throws RegraDeNegocioException {
        log.info("Buscando todas as pessoas");
        List<PessoaDTO> pessoaList = pessoaService.list();
        log.info("Buscou todas as pessoas");
        return new ResponseEntity<>(pessoaList, HttpStatus.OK);
    }

    @GetMapping(value = "/", params = "nome")
    public ResponseEntity<List<PessoaDTO>> listByName(@RequestParam(value = "nome", required = false) @Valid String nome) throws Exception{
        log.info("Buscando pessoas pelo nome {}", nome);
        List<PessoaDTO> pessoaList = pessoaService.listByName(nome);
        log.info("Buscou pessoas pelo nome {}", nome);
        return new ResponseEntity<>(pessoaList, HttpStatus.OK);
    }

    @GetMapping(value = "/", params = "cpf")
    public ResponseEntity<PessoaDTO> listByCpf(@RequestParam(value = "cpf", required = false) @Valid String cpf) throws Exception{
        log.info("Buscando pessoas pelo cpf {}", cpf);
        PessoaDTO pessoaList = pessoaService.getByCpf(cpf);
        log.info("Buscou pessoas pelo cpf {}", cpf);
        return new ResponseEntity<>(pessoaList, HttpStatus.OK);
    }

    @GetMapping(value = "/", params = {"dataInicio", "dataFinal"})
    public ResponseEntity<List<PessoaDTO>> listByDataNascimento(@RequestParam(value = "dataInicio", required = false) @Valid String dataInicio,
                                                                @RequestParam(value = "dataFinal", required = false) @Valid String dataFinal) throws Exception{
        log.info("Buscando pessoas que nasceram entre {} e {}", dataInicio, dataFinal);
        List<PessoaDTO> pessoaList = pessoaService.getByDataNascimento(dataInicio, dataFinal);
        log.info("Buscou pessoas que nasceram entre {} e {}", dataInicio, dataFinal);
        return new ResponseEntity<>(pessoaList, HttpStatus.OK);
    }

    @GetMapping("/com-enderecos")
    public ResponseEntity<List<PessoaEnderecoDTO>> listEnderecos(@RequestParam(value = "idPessoa", required = false) @Valid Integer idPessoa) throws Exception{
        log.info("Buscando pessoas pelo nome {}", idPessoa);
        List<PessoaEnderecoDTO> pessoaList = pessoaService.getByIdEndereco(idPessoa);
        log.info("Buscou pessoas pelo nome {}", idPessoa);
        return new ResponseEntity<>(pessoaList, HttpStatus.OK);
    }

    @GetMapping("/com-contatos")
    public ResponseEntity<List<PessoaContatoDTO>> listContatos(@RequestParam(value = "idPessoa", required = false) @Valid Integer idPessoa) throws Exception{
        log.info("Buscando pessoas pelo nome {}", idPessoa);
        List<PessoaContatoDTO> pessoaList = pessoaService.getByIdContato(idPessoa);
        log.info("Buscou pessoas pelo nome {}", idPessoa);
        return new ResponseEntity<>(pessoaList, HttpStatus.OK);
    }

    @GetMapping("/com-pets")
    public ResponseEntity<List<PessoaPetDTO>> listPets(@RequestParam(value = "idPessoa", required = false) @Valid Integer idPessoa) throws Exception{
        log.info("Buscando pessoas pelo nome {}", idPessoa);
        List<PessoaPetDTO> pessoaList = pessoaService.getByIdPet(idPessoa);
        log.info("Buscou pessoas pelo nome {}", idPessoa);
        return new ResponseEntity<>(pessoaList, HttpStatus.OK);
    }

    @PostMapping // POST localhost:8081/pessoa
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {
        log.info("Criando pessoa");
        PessoaDTO createdPessoa = pessoaService.create(pessoa);
        log.info("Criou pessoa");
        return new ResponseEntity<>(createdPessoa, HttpStatus.CREATED);
    }

    @PutMapping("/{idPessoa}") // PUT localhost:8081/pessoa/1000
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") @Valid Integer id,
                                            @RequestBody @Valid PessoaCreateDTO pessoaAtualizar) throws Exception {
        log.info("Atualizando pessoa com id {}", id);
        pessoaAtualizar.setIdPessoa(id);
        PessoaDTO updatedPessoa = pessoaService.update(id, pessoaAtualizar);
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