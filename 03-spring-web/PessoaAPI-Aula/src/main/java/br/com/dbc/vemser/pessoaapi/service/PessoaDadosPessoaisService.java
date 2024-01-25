package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PessoaDadosPessoaisService {

    private final DadosPessoaisService dadosPessoaisService;
    private final PessoaService pessoaService;


    public List<PessoaDadosPessoaisDTO> list() throws Exception {
        List<PessoaDTO> pessoaList = pessoaService.list();
        List<DadosPessoaisDTO> dadosPessoaisList = dadosPessoaisService.getAll();
        return mergePessoaAndDadosPessoais(pessoaList, dadosPessoaisList);
    }

    public List<PessoaDadosPessoaisDTO> listByCpf(Integer cpf) throws Exception {
        List<PessoaDTO> pessoaList = List.of(pessoaService.getPessoaByCpf(cpf));
        List<DadosPessoaisDTO> dadosPessoaisList = List.of(dadosPessoaisService.get(cpf.toString()));
        return mergePessoaAndDadosPessoais(pessoaList, dadosPessoaisList);
    }

    public PessoaDadosPessoaisDTO create(PessoaDadosPessoaisDTO pessoaDadosPessoaisDTO) throws Exception {
        PessoaDTO pessoaDTO = pessoaService.create(pessoaDadosPessoaisDTO);
        DadosPessoaisDTO dadosPessoaisDTO = dadosPessoaisService.post(pessoaDadosPessoaisDTO);
        return mergePessoaAndDadosPessoais(List.of(pessoaDTO), List.of(dadosPessoaisDTO)).get(0);
    }
    
    public void delete(Integer cpf) throws Exception {
        dadosPessoaisService.delete(cpf.toString());
        pessoaService.delete(cpf);
    }


    public List<PessoaDadosPessoaisDTO> mergePessoaAndDadosPessoais(List<PessoaDTO> pessoaList, List<DadosPessoaisDTO> dadosPessoaisList) {
        List<PessoaDadosPessoaisDTO> mergedList = new ArrayList<>();

        for (PessoaDTO pessoa : pessoaList) {
            for (DadosPessoaisDTO dadosPessoais : dadosPessoaisList) {
                if (pessoa.getCpf().equals(dadosPessoais.getCpf()) && !pessoa.getCpf().isEmpty()) {
                    PessoaDadosPessoaisDTO merged = getPessoaDadosPessoaisDTO(pessoa, dadosPessoais);
                    mergedList.add(merged);
                }
            }
        }

        if (!mergedList.isEmpty()) {
            for (PessoaDTO pessoa : pessoaList) {

                if (mergedList.stream().noneMatch(pessoaDadosPessoaisDTO -> pessoaDadosPessoaisDTO.getCpf().equals(pessoa.getCpf()))) {
                    PessoaDadosPessoaisDTO merged = new PessoaDadosPessoaisDTO();
                    merged.setNome(pessoa.getNome());
                    merged.setDataNascimento(pessoa.getDataNascimento());
                    merged.setCpf(pessoa.getCpf());
                    merged.setEmail(pessoa.getEmail());
                    mergedList.add(merged);
                }
            }

            for (DadosPessoaisDTO dadosPessoais : dadosPessoaisList) {
                if (mergedList.stream().noneMatch(pessoaDadosPessoaisDTO -> pessoaDadosPessoaisDTO.getCpf().equals(dadosPessoais.getCpf()))) {
                    PessoaDadosPessoaisDTO merged = new PessoaDadosPessoaisDTO();
                    merged.setNome(dadosPessoais.getNome());
                    merged.setCpf(dadosPessoais.getCpf());
                    merged.setRg(dadosPessoais.getRg());
                    merged.setCnh(dadosPessoais.getCnh());
                    merged.setNomeMae(dadosPessoais.getNomeMae());
                    merged.setNomePai(dadosPessoais.getNomePai());
                    merged.setTituloEleitor(dadosPessoais.getTituloEleitor());
                    merged.setSexo(dadosPessoais.getSexo());
                    mergedList.add(merged);
                }
            }
        } else {
            for (PessoaDTO pessoa : pessoaList) {
                PessoaDadosPessoaisDTO merged = new PessoaDadosPessoaisDTO();
                merged.setNome(pessoa.getNome());
                merged.setDataNascimento(pessoa.getDataNascimento());
                merged.setCpf(pessoa.getCpf());
                merged.setEmail(pessoa.getEmail());
                mergedList.add(merged);
            }

            for (DadosPessoaisDTO dadosPessoais : dadosPessoaisList) {
                PessoaDadosPessoaisDTO merged = new PessoaDadosPessoaisDTO();
                merged.setNome(dadosPessoais.getNome());
                merged.setCpf(dadosPessoais.getCpf());
                merged.setRg(dadosPessoais.getRg());
                merged.setCnh(dadosPessoais.getCnh());
                merged.setNomeMae(dadosPessoais.getNomeMae());
                merged.setNomePai(dadosPessoais.getNomePai());
                merged.setTituloEleitor(dadosPessoais.getTituloEleitor());
                merged.setSexo(dadosPessoais.getSexo());
                mergedList.add(merged);
            }
        }

        return mergedList;
    }

    private static PessoaDadosPessoaisDTO getPessoaDadosPessoaisDTO(PessoaDTO pessoa, DadosPessoaisDTO dadosPessoais) {
        PessoaDadosPessoaisDTO merged = new PessoaDadosPessoaisDTO();
        merged.setNome(pessoa.getNome());
        merged.setDataNascimento(pessoa.getDataNascimento());
        merged.setCpf(dadosPessoais.getCpf());
        merged.setEmail(pessoa.getEmail());
        merged.setRg(dadosPessoais.getRg());
        merged.setCnh(dadosPessoais.getCnh());
        merged.setNomeMae(dadosPessoais.getNomeMae());
        merged.setNomePai(dadosPessoais.getNomePai());
        merged.setTituloEleitor(dadosPessoais.getTituloEleitor());
        merged.setSexo(dadosPessoais.getSexo());
        return merged;
    }
}
