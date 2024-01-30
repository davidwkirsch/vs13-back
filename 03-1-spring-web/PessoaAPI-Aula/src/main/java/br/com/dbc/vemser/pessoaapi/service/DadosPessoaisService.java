package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDadosPessoaisDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class DadosPessoaisService {

    private final DadosPessoaisClient dadosPessoaisClient;

    public List<DadosPessoaisDTO> getAll() {
        return dadosPessoaisClient.getAll();
    }

    public DadosPessoaisDTO post(DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisClient.post(dadosPessoaisDTO);
    }

    public DadosPessoaisDTO post(PessoaDadosPessoaisDTO pessoaDadosPessoaisDTO) {
        DadosPessoaisDTO dadosPessoaisDTO = new DadosPessoaisDTO();
        dadosPessoaisDTO.setCpf(pessoaDadosPessoaisDTO.getCpf());
        dadosPessoaisDTO.setRg(pessoaDadosPessoaisDTO.getRg());
        dadosPessoaisDTO.setCnh(pessoaDadosPessoaisDTO.getCnh());
        dadosPessoaisDTO.setNomeMae(pessoaDadosPessoaisDTO.getNomeMae());
        dadosPessoaisDTO.setNomePai(pessoaDadosPessoaisDTO.getNomePai());
        dadosPessoaisDTO.setTituloEleitor(pessoaDadosPessoaisDTO.getTituloEleitor());
        dadosPessoaisDTO.setSexo(pessoaDadosPessoaisDTO.getSexo());
        dadosPessoaisDTO.setNome(pessoaDadosPessoaisDTO.getNome());
        post(dadosPessoaisDTO);
        return dadosPessoaisDTO;
    }

    public DadosPessoaisDTO put(String cpf, DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisClient.put(cpf, dadosPessoaisDTO);
    }

    public void delete(String cpf) {
        dadosPessoaisClient.delete(cpf);
    }

    public DadosPessoaisDTO get(String cpf) {
        return dadosPessoaisClient.get(cpf);
    }

}
