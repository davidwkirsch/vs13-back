package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.EnderecoPessoaEntity;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoPessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnderecoPessoaService {

    private final EnderecoPessoaRepository enderecoPessoaRepository;

    public List<EnderecoPessoaEntity> list() {
        return enderecoPessoaRepository.findAll();
    }

    public List<EnderecoPessoaEntity> findByIdPessoa(Integer idPessoa) {
        return enderecoPessoaRepository.findByIdPessoa(idPessoa);
    }

    public List<EnderecoPessoaEntity> findByIdEndereco(Integer idEndereco) {
        return enderecoPessoaRepository.findByIdEndereco(idEndereco);
    }
}
