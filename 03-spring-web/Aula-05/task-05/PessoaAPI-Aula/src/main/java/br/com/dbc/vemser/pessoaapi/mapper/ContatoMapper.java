package br.com.dbc.vemser.pessoaapi.mapper;

import br.com.dbc.vemser.pessoaapi.dto.CreateContatoDto;
import br.com.dbc.vemser.pessoaapi.dto.ResponseContatoDto;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import org.springframework.web.bind.annotation.Mapping;

public class ContatoMapper {

    public static Contato createContatoDtoToContato(CreateContatoDto createContatoDto) {
        Contato contato = new Contato();
        contato.setIdContato(createContatoDto.getIdContato());
        contato.setIdPessoa(createContatoDto.getIdPessoa());
        contato.setTipoContato(createContatoDto.getTipoContato());
        contato.setNumero(createContatoDto.getNumero());
        contato.setDescricao(createContatoDto.getDescricao());
        return contato;
    }

    public static ResponseContatoDto contatoToContatoResponseDto(Contato contato) {
        ResponseContatoDto responseContatoDto = new ResponseContatoDto();
        responseContatoDto.setIdContato(contato.getIdContato());
        responseContatoDto.setIdContato(contato.getIdContato());
        responseContatoDto.setIdPessoa(contato.getIdPessoa());
        responseContatoDto.setTipoContato(contato.getTipoContato());
        responseContatoDto.setNumero(contato.getNumero());
        responseContatoDto.setDescricao(contato.getDescricao());
        return responseContatoDto;
    }
}
