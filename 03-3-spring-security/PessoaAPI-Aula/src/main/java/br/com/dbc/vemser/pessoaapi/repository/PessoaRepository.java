package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.dto.PessoaFullDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    List<PessoaEntity> findByCpf(String cpf);

    List<PessoaEntity> findAllByNomeContainsIgnoreCase(String nome);

    List<PessoaEntity> findAllByDataNascimentoGreaterThanAndDataNascimentoLessThan(LocalDate dataInicio, LocalDate dataFinal);

    //    @Query("select p from PESSOA p where p.cpf = ?1")
//    PessoaEntity procurarPorCPF(String cpf);

    // JPQL - VALUE É OPCIONAL

    @Query("select p from PESSOA p where p.cpf = :cpf")
    Optional<PessoaEntity> procurarPorCPF(@Param("cpf") String cpf);

//    @Query(value = "select p from PESSOA p where p.cpf = :cpf")
//    PessoaEntity procurarPorCPF(@Param("cpf") String cpf);

    // SQL NATIVO - PRECISA COLOCAR O VALUE E NATIVEQUERY

//    @Query(value = "select * from PESSOA p where p.cpf = :cpf", nativeQuery = true)
//    PessoaEntity procurarPorCPF(@Param("cpf") String cpf);

    @Query("select p from PESSOA p" +
            " join fetch p.contatos c " +
            " where c.tipoContato = 1")
    List<PessoaEntity> procurarPessoasContatoComercial();

    @Query(value = "select * from VEM_SER.PESSOA p" +
            " inner join VEM_SER.CONTATO c ON c.id_pessoa = p.id_pessoa" +
            " where c.tipo = 1", nativeQuery = true)
    List<PessoaEntity> procurarPessoasContatoComercialNative();

    @Query(value = "select p from PESSOA p" +
            " join p.enderecos e " +
            " where e is not null")
    List<PessoaEntity> procurarPessoasComEndereco();

    @Query(value = "select * from vem_ser.PESSOA p" +
            " left join vem_ser.PESSOA_X_PESSOA_ENDERECO pxpe " +
            "          on p.id_pessoa = pxpe.id_pessoa " +
            "   where pxpe.id_pessoa is null", nativeQuery = true)
    List<PessoaEntity> procurarPessoasSemEndereco();

    @Query(value = "SELECT UNIQUE p.id_pessoa AS idPessoa, p.nome AS nomePessoa, p.email AS email, c.numero AS contatoNumero, " +
            "e.cep AS cep, e.cidade AS cidade, e.estado AS estado, e.pais AS pais, pt.nome AS petNome " +
            "FROM PESSOA p " +
            "LEFT JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON pxpe.ID_PESSOA = p.ID_PESSOA " +
            "LEFT JOIN ENDERECO_PESSOA e ON pxpe.ID_ENDERECO = e.ID_ENDERECO " +
            "LEFT JOIN CONTATO c ON p.ID_PESSOA = c.ID_PESSOA " +
            "LEFT JOIN PET pt ON p.ID_PESSOA = pt.ID_PESSOA " +
            "WHERE (:idPessoa = -1 OR p.ID_PESSOA = :idPessoa)",
            nativeQuery = true)
    List<PessoaFullDTO> procurarPessoaComEnderecoContatoPet(@Param("idPessoa") Integer idPessoa);




//    @Query(value = "SELECT p.id_pessoa, p.nome, p.email, p.data_nascimento, p.cpf, " +
//            "LISTAGG(NVL(c.id_contato, '0') || ',' || NVL(c.tipo, 'default') || ',' || NVL(c.numero, 'default') || ',' || NVL(c.descricao, 'default'), ';') WITHIN GROUP (ORDER BY c.id_contato) AS contatos, " +
//            "LISTAGG(NVL(e.cep, 'default') || ',' || NVL(e.cidade, 'default') || ',' || NVL(e.estado, 'default') || ',' || NVL(e.PAIS, 'default'), ';') WITHIN GROUP (ORDER BY e.cep) AS enderecos, NVL(pt.nome, 'default') " +
//            "FROM PESSOA p " +
//            "LEFT JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON pxpe.ID_PESSOA = p.ID_PESSOA " +
//            "LEFT JOIN ENDERECO_PESSOA e ON pxpe.ID_ENDERECO = e.ID_ENDERECO " +
//            "LEFT JOIN CONTATO c ON p.ID_PESSOA = c.ID_PESSOA " +
//            "LEFT JOIN PET pt ON p.ID_PESSOA = pt.ID_PESSOA " +
//            "WHERE p.id_pessoa = :idPessoa " +
//            "GROUP BY p.id_pessoa, p.nome, p.email, p.data_nascimento, p.cpf, pt.nome",
//            nativeQuery = true)
//    List<PessoaEntity> procurarPessoaComEnderecoContatoPet(@Param("idPessoa") Integer idPessoa);

//    @Query(" select new com.dbc.pessoaapi.dto.PessoaComContatosDTO(" +
//            "p.idPessoa," +
//            "p.nome," +
//            "p.email," +
//            "c.tipoContato," +
//            "c.numero" +
//            ")" +
//            "        from PESSOA p" +
//            "  join p.contatos c" )
//    List<PessoaContatoDTO> findAllPessoasComContato();


}
