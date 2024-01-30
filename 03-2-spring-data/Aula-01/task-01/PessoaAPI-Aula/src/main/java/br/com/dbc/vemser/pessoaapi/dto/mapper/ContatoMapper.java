package br.com.dbc.vemser.pessoaapi.dto.mapper;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;

public class ContatoMapper {

    public static ContatoEntity createContatoDtoToContato(ContatoCreateDTO contatoCreateDTO) {
        ContatoEntity contatoEntity = new ContatoEntity();
        contatoEntity.setIdContato(contatoCreateDTO.getIdContato());
        contatoEntity.setIdPessoa(contatoCreateDTO.getIdPessoa());
        contatoEntity.setTipoContato(contatoCreateDTO.getTipoContato());
        contatoEntity.setNumero(contatoCreateDTO.getNumero());
        contatoEntity.setDescricao(contatoCreateDTO.getDescricao());
        return contatoEntity;
    }

    public static ContatoDTO contatoToContatoResponseDto(ContatoEntity contatoEntity) {
        ContatoDTO contatoDto = new ContatoDTO();
        contatoDto.setIdContato(contatoEntity.getIdContato());
        contatoDto.setIdContato(contatoEntity.getIdContato());
        contatoDto.setIdPessoa(contatoEntity.getIdPessoa());
        contatoDto.setTipoContato(contatoEntity.getTipoContato());
        contatoDto.setNumero(contatoEntity.getNumero());
        contatoDto.setDescricao(contatoEntity.getDescricao());
        return contatoDto;
    }
}
