package br.com.dbc.vemser.pessoaapi.client;

import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(value="dados-pessoais-api", url="http://vemser-dbc.dbccompany.com.br:39000/vemser/dados-pessoais-api")
@Headers("Content-Type: application/json")
public interface DadosPessoaisClient {

    @Operation(summary = "Listar dados pessoais", description = "Lista todos os dados pessoais do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de dados pessoais"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @RequestLine("GET /dados-pessoais")
    List<DadosPessoaisDTO> getAll();

    @Operation(summary = "Criar dados pessoais", description = "Cria um dado pessoal no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Cria e retorna o dado pessoal criado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @RequestLine("POST /dados-pessoais")
    DadosPessoaisDTO post(DadosPessoaisDTO dadosPessoaisDTO);

    @Operation(summary = "Editar dados pessoais", description = "Editar um dado pessoal no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Editar e retorna o dado pessoal atualizado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @RequestLine("PUT /dados-pessoais/{cpf}")
    DadosPessoaisDTO put(@Param("cpf") String cpf, DadosPessoaisDTO dadosPessoaisDTO);

    @Operation(summary = "Deletar dados pessoais", description = "Deleta um dado pessoal no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Deleta o dado pessoal"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @RequestLine("DELETE /dados-pessoais/{cpf}")
    void delete(@Param("cpf") String cpf);

    @Operation(summary = "Listar dados pessoais pelo cpf", description = "Lista todos os dados pessoais do banco que contenham o cpf informado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna os dados pessoais solicitados"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @RequestLine("GET /dados-pessoais/{cpf}")
    DadosPessoaisDTO get(@Param("cpf") String cpf);
}
