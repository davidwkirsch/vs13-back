package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.dbc.vemser.pessoaapi.service.DadosPessoaisService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Tag(name = "Dados Pessoais", description = "Endpoints do CRUD de Dados Pessoais")
@RestController
@RequestMapping("/dados-pessoais") // localhost:8081/dados-pessoais
public class DadosPessoaisController {

    private final DadosPessoaisService dadosPessoaisService;

    @GetMapping
    public List<DadosPessoaisDTO> getAll() {
        return dadosPessoaisService.getAll();
    }

    @PostMapping
    public DadosPessoaisDTO post(@RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisService.post(dadosPessoaisDTO);
    }

    @PutMapping("/{cpf}")
    public DadosPessoaisDTO put(@PathVariable String cpf, @RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisService.put(cpf, dadosPessoaisDTO);
    }

    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable String cpf) {
        dadosPessoaisService.delete(cpf);
    }

    @GetMapping("/{cpf}")
    public DadosPessoaisDTO get(@PathVariable String cpf) {
        return dadosPessoaisService.get(cpf);
    }
}
