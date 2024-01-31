package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.service.PetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Validated
@RequiredArgsConstructor
@Tag(name = "PetEntity", description = "Endpoints do CRUD de PetEntity")
@RestController
@RequestMapping("/pet") // localhost:8081/pet
public class PetController {

    private final PetService petService;

    @GetMapping // GET localhost:8081/pet
    public ResponseEntity<List<PetDTO>> list() throws Exception {
        log.info("Buscando todas os pets");
        List<PetDTO> petList = petService.getAll();
        log.info("Buscou todas os pets");
        return new ResponseEntity<>(petList, HttpStatus.OK);
    }

    @PostMapping // POST localhost:8081/pet
    public ResponseEntity<PetDTO> create(@Valid @RequestBody PetCreateDTO pet) throws Exception {
        log.info("Criando pet");
        PetDTO createdPet = petService.create(pet);
        log.info("Criou pet");
        return new ResponseEntity<>(createdPet, HttpStatus.CREATED);
    }

    @PutMapping("/editar") // PUT localhost:8081/pet/1000
    public ResponseEntity<PetDTO> update(@RequestParam("idPet") @Valid Integer idPet,
                                                @RequestBody @Valid PetCreateDTO petAtualizar) throws Exception {
        log.info("Atualizando pet com id {}", idPet);
        petAtualizar.setIdPet(idPet);
        PetDTO updatedPet = petService.update(petAtualizar);
        log.info("Atualizou pet com id {}", idPet);
        return new ResponseEntity<>(updatedPet, HttpStatus.OK);
    }

    @DeleteMapping("/deletar") // DELETE localhost:8081/pet/1000
    public ResponseEntity<PetDTO> delete(@RequestParam("idPet") @Valid Integer idPet) throws Exception {
        log.info("Deletando pet com id {}", idPet);
        PetDTO deletedPet = petService.delete(idPet);
        log.info("Deletou pet com id {}", idPet);
        return new ResponseEntity<>(deletedPet, HttpStatus.OK);
    }




}
