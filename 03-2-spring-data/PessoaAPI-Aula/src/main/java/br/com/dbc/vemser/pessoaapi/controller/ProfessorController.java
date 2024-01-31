package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.ProfessorCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ProfessorDTO;
import br.com.dbc.vemser.pessoaapi.entity.ProfessorPK;
import br.com.dbc.vemser.pessoaapi.service.ProfessorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@Validated
@RequiredArgsConstructor
@Tag(name = "ProfessorEntity", description = "Endpoints do CRUD de ProfessorEntity")
@RestController
@RequestMapping("/professor") // localhost:8081/professor
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping // GET localhost:8081/professor
    public ResponseEntity<List<ProfessorDTO>> list() throws Exception {
        log.info("Buscando todas os professores");
        List<ProfessorDTO> professorList = professorService.getAll();
        log.info("Buscou todas os professores");
        return new ResponseEntity<>(professorList, HttpStatus.OK);
    }

    @GetMapping("/") // GET localhost:8081/professor/?nome=Rafa
    public ResponseEntity<List<ProfessorDTO>> listByName(@RequestParam("nome") @NotEmpty @Valid String nome) throws Exception{
        log.info("Buscando professores pelo nome {}", nome);
        List<ProfessorDTO> professorList = professorService.getByName(nome);
        log.info("Buscou professores pelo nome {}", nome);
        return new ResponseEntity<>(professorList, HttpStatus.OK);
    }

    @PostMapping // POST localhost:8081/professor
    public ResponseEntity<ProfessorDTO> create(@Valid @RequestBody ProfessorCreateDTO professor) throws Exception {
        log.info("Criando professor");
        ProfessorDTO createdProfessor = professorService.save(professor);
        log.info("Criou professor");
        return new ResponseEntity<>(createdProfessor, HttpStatus.CREATED);
    }

    @PutMapping("/editar") // PUT localhost:8081/professor/1000
    public ResponseEntity<ProfessorDTO> update(@RequestParam("idProfessor") @NotNull @Valid Integer idProfessor,
                                               @RequestParam("idUniversidade") @NotNull @Valid Integer idUniversidade,
                                                @RequestBody @Valid ProfessorCreateDTO professorAtualizar) throws Exception {
        log.info("Atualizando professor com id {} e universidade id {}", idProfessor, idUniversidade);
        professorAtualizar.setProfessorPK(new ProfessorPK(idProfessor, idUniversidade));
        ProfessorDTO updatedProfessor = professorService.update(professorAtualizar);
        log.info("Atualizou professor com id {} e universidade id {}", idProfessor, idUniversidade);
        return new ResponseEntity<>(updatedProfessor, HttpStatus.OK);
    }

    @DeleteMapping("/delete") // DELETE localhost:8081/professor/1000
    public ResponseEntity<Void> delete(@RequestParam("idProfessor") @NotNull @Valid Integer idProfessor,
                                       @RequestParam("idUniversidade") @NotNull @Valid Integer idUniversidade) throws Exception {
        log.info("Deletando professor com id {} e universidade id {}", idProfessor, idUniversidade);
        professorService.deleteById(idProfessor, idUniversidade);
        log.info("Deletou professor com id {} e universidade id {}", idProfessor, idUniversidade);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
