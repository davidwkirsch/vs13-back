package br.com.dbc.vemser.pessoaapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PessoaDadosPessoaisService {

    private final DadosPessoaisService dadosPessoaisService;
    private final PessoaService pessoaService;


//    public List<PessoaDadosPessoaisDTO> list() throws Exception {
//        List<PessoaDTO> pessoaList = pessoaService.list();
//        List<DadosPessoaisDTO> dadosPessoaisList = dadosPessoaisService.getAll();
//        return mergePessoaAndDadosPessoais(pessoaList, dadosPessoaisList);
//    }
//
//    public List<PessoaDadosPessoaisDTO> listByCpf(String cpf) throws Exception {
//        List<PessoaDTO> pessoaList = List.of(pessoaService.getByCpf(cpf));
//        List<DadosPessoaisDTO> dadosPessoaisList = List.of(dadosPessoaisService.get(cpf));
//        return mergePessoaAndDadosPessoais(pessoaList, dadosPessoaisList);
//    }
//
//    public PessoaDadosPessoaisDTO create(PessoaDadosPessoaisDTO pessoaDadosPessoaisDTO) throws Exception {
//        PessoaDTO pessoaDTO = pessoaService.create(PessoaMapper.pessoaDadosPessoaisToPessoaCreateDto(pessoaDadosPessoaisDTO));
//        DadosPessoaisDTO dadosPessoaisDTO = dadosPessoaisService.post(pessoaDadosPessoaisDTO);
//        return mergePessoaAndDadosPessoais(List.of(pessoaDTO), List.of(dadosPessoaisDTO)).get(0);
//    }
//
//    public PessoaDadosPessoaisDTO update(PessoaDadosPessoaisDTO pessoaDadosPessoaisDTO) throws Exception {
//        PessoaDTO pessoaDTO = pessoaService.update(PessoaMapper.pessoaDadosPessoaisToPessoaCreateDto(pessoaDadosPessoaisDTO));
//        DadosPessoaisDTO dadosPessoaisDTO = dadosPessoaisService.put(
//                pessoaDadosPessoaisDTO.getCpf(),
//                DadosPessoaisMapper.pessoaDadosPessoaisDtoToDadosPessoaisDto(pessoaDadosPessoaisDTO));
//        return mergePessoaAndDadosPessoais(List.of(pessoaDTO), List.of(dadosPessoaisDTO)).get(0);
//    }
//
//    public void delete(String cpf) throws Exception {
//        dadosPessoaisService.delete(cpf);
//        pessoaService.delete(cpf);
//    }
//
//
//    public List<PessoaDadosPessoaisDTO> mergePessoaAndDadosPessoais(List<PessoaDTO> pessoaList, List<DadosPessoaisDTO> dadosPessoaisList) {
//        List<PessoaDadosPessoaisDTO> mergedList = new ArrayList<>();
//
//        for (PessoaDTO pessoa : pessoaList) {
//            for (DadosPessoaisDTO dadosPessoais : dadosPessoaisList) {
//                if (pessoa.getCpf().equals(dadosPessoais.getCpf()) && !pessoa.getCpf().isEmpty()) {
//                    PessoaDadosPessoaisDTO merged = PessoaDadosPessoaisMapper.mergeIntoPessoaDadosPessoaisDTO(pessoa, dadosPessoais);
//                    mergedList.add(merged);
//                }
//            }
//        }
//        if (!mergedList.isEmpty()) {
//            for (PessoaDTO pessoa : pessoaList) {
//                if (mergedList.stream().noneMatch(pessoaDadosPessoaisDTO -> pessoaDadosPessoaisDTO.getCpf().equals(pessoa.getCpf()))) {
//                    mergedList.add(PessoaDadosPessoaisMapper.mergeIntoPessoaDadosPessoaisDTO(pessoa));
//                }
//            }
//
//            for (DadosPessoaisDTO dadosPessoais : dadosPessoaisList) {
//                if (mergedList.stream().noneMatch(pessoaDadosPessoaisDTO -> pessoaDadosPessoaisDTO.getCpf().equals(dadosPessoais.getCpf()))) {
//                    mergedList.add(PessoaDadosPessoaisMapper.mergeIntoPessoaDadosPessoaisDTO(dadosPessoais));
//                }
//            }
//        } else {
//            for (PessoaDTO pessoa : pessoaList) {
//                mergedList.add(PessoaDadosPessoaisMapper.mergeIntoPessoaDadosPessoaisDTO(pessoa));
//            }
//
//            for (DadosPessoaisDTO dadosPessoais : dadosPessoaisList) {
//                mergedList.add(PessoaDadosPessoaisMapper.mergeIntoPessoaDadosPessoaisDTO(dadosPessoais));
//            }
//        }
//        return mergedList;
//    }

}
