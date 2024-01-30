package br.com.dbc.vemser.pessoaapi.controller.interfaces;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface IContatoController {

    @Operation(summary = "Listar contatos", description = "Lista todos os contatos do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    ResponseEntity<List<ContatoDTO>> list();

    @Operation(summary = "Listar contatos pelo id", description = "Lista todos os contatos do banco que contenham o id informado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna os contatos solicitados"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idContato}")
    ResponseEntity<List<ContatoDTO>> listById(@PathVariable("idContato") @Valid Integer idPessoa) throws Exception;

    @Operation(summary = "Criar contato", description = "Cria um contato no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Cria e retorna o contato criado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping
    ResponseEntity<ContatoDTO> create(@RequestBody @Valid ContatoCreateDTO contato) throws Exception;

    @Operation(summary = "Editar contato", description = "Editar um contato no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Editar e retorna o contato atualizado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idContato}")
    ResponseEntity<ContatoDTO> update(@PathVariable("idContato") @Valid Integer id,
                                             @RequestBody @Valid ContatoCreateDTO contatoAtualizar) throws Exception;

    @Operation(summary = "Deletar contato", description = "Deletar um contato no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Deleta o contato"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idContato}")
    ResponseEntity<String> delete(@PathVariable("idContato") @Valid Integer id) throws Exception;
}