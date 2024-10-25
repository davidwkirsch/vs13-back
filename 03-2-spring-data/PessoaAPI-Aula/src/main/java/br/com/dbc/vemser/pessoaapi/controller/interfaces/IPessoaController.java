package br.com.dbc.vemser.pessoaapi.controller.interfaces;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface IPessoaController {

    @Operation(summary = "Listar pessoas", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<List<PessoaDTO>> listByDataNascimento(@RequestParam(value = "dataInicio", required = false) @Valid String dataInicio,
                                                                @RequestParam(value = "dataFinal", required = false) @Valid String dataFinal) throws Exception;

    @Operation(summary = "Criar pessoa", description = "Cria uma pessoa no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Cria e retorna a pessoa criada"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping
    ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception;

    @Operation(summary = "Editar pessoa", description = "Editar uma pessoa no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Editar e retorna a pessoa atualizada"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idPessoa}")
    ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") @Valid Integer id,
                                            @RequestBody @Valid PessoaCreateDTO pessoaAtualizar) throws Exception;

    @Operation(summary = "Deletar pessoa", description = "Deletar uma pessoa no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Deleta a pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idPessoa}")
    ResponseEntity<String> delete(@PathVariable("idPessoa") @Valid Integer id) throws Exception;
}


