package br.com.dbccompany.vemser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Classe Funcionário - Teste")
class FuncionarioTest {

    Funcionario func = new Funcionario("Pedro", LocalDate.parse("2000-12-12"), LocalDate.parse("2020-01-01"), 2000);

    //Endereços
    Endereco endereco1Cliente1 = new Endereco(1, 1000, "R. Bananeira", "",
            "Ivoti", "93900-000","RS", "Brasil");
    Endereco endereco2Cliente1 = new Endereco(2, 2000, "R. Macieira", "",
            "Ivoti", "93900-000","RS", "Brasil");
    Endereco endereco1Cliente2 = new Endereco(1, 2222, "Av. Nemaquinemla", "Casa de rico",
            "São Paulo", "45800.600", "SP", "Brasil");

    //Contatos
    Contato contato1Cliente1 = new Contato(1, "Cel", "(51) 980805050");
    Contato contato1Cliente2 = new Contato(1, "Whats", "985214752");
    Contato contato2Cliente2 = new Contato(2, "Cel Empresa", "51 3030-8020");

    //Clientes
    Cliente cliente1 = new Cliente("David Kirsch", "123.456.789-00",
            new Contato[]{contato1Cliente1, null}, new Endereco[]{endereco1Cliente1, endereco2Cliente1});
    Cliente cliente2 = new Cliente("Lucas Brasil", "85465485813",
            new Contato[]{contato1Cliente2, contato2Cliente2}, new Endereco[]{endereco1Cliente2, null});

    //Contas
    ContaCorrente contaCorrenteCliente1 = new ContaCorrente("123456", 1234, cliente1, 300);
    ContaPoupanca contaCliente2 = new ContaPoupanca("333666", 1034, cliente2);
    ContaPagamento contaPagamentoCliente1 = new ContaPagamento("888888", 9999, cliente1);

//  @BeforeEach
//  void setup() {
//
//  }

    @Test
    @DisplayName("Deveria retornar 4 como tempo de empresa se a data de contratação for 2020-01-01")
    void calcularTempoDeEmpresa() {
      int idadeEmpresaObtida = func.calcularTempoDeEmpresa();
      int idadeEmpresaEsperada = 4;

      // Assertiva
      Assertions.assertEquals(idadeEmpresaEsperada, idadeEmpresaObtida);
    }

    @Test
    @DisplayName("Deveria lançar IllegalArgumentException se o nome for nulo")
    void setarNomeNulo() {
      Assertions.assertThrows(IllegalArgumentException.class, () -> func.setNome(null));
    }

    @Test
    @DisplayName("Não deveria lançar IllegalArgumentException se o nome for válido")
    void setarNomeValido() {
      Assertions.assertDoesNotThrow(() -> func.setNome("Nome qualquer"));
    }

    @Test
    @DisplayName("Deveria testar saque da conta corrente e verificar o saldo")
      void testarSaqueContaCorrente() {
          contaCorrenteCliente1.depositar(1000);
          contaCorrenteCliente1.sacar(100);
          assertEquals(900, contaCorrenteCliente1.getSaldo());
      }

    @Test
    @DisplayName("Deveria testar saque de conta corrente sem saldo")
    void testarSaqueContaCorrenteSemSaldo() {
      contaCorrenteCliente1.depositar(1000);
      Assertions.assertThrows(IllegalArgumentException.class, () -> contaCorrenteCliente1.sacar(10000));
    }

    @Test
    @DisplayName("Deveria testar saque de conta poupança e verificar saldo com sucesso")
    void testarSaqueContaPoupanca() {
      contaCliente2.depositar(1000);
      contaCliente2.sacar(100);
      assertEquals(900, contaCliente2.getSaldo());
    }

    @Test
    @DisplayName("Deveria testar saque de conta poupança sem saldo")
    void testarSaqueContaPoupancaSemSaldo() {
      contaCliente2.depositar(1000);
      Assertions.assertThrows(IllegalArgumentException.class, () -> contaCliente2.sacar(10000));
    }

    @Test
    @DisplayName("Deveria testar saque de conta pagamento e verificar saldo com sucesso")
    void testarSaqueContaPagamento() {
      contaPagamentoCliente1.depositar(1000);
      contaPagamentoCliente1.sacar(100);
      assertEquals(895.75, contaPagamentoCliente1.getSaldo());
    }

    @Test
    @DisplayName("Deveria testar saque de conta pagamento sem saldo")
    void testarSaqueContaPagamentoSemSaldo() {
      contaPagamentoCliente1.depositar(1000);
      Assertions.assertThrows(IllegalArgumentException.class, () -> contaPagamentoCliente1.sacar(10000));
    }

    @Test
    @DisplayName("Deveria testar transferência entre contas e verificar saldo com sucesso")
    void testarTransferenciaEntreContas() {
      contaCorrenteCliente1.depositar(1000);
      contaCliente2.depositar(1000);
      contaCorrenteCliente1.transferir(contaCliente2, 100);
      assertEquals(900, contaCorrenteCliente1.getSaldo());
      assertEquals(1100, contaCliente2.getSaldo());
    }

    @Test
    @DisplayName("Deveria testar transferência entre contas sem saldo")
    void testarTransferenciaEntreContasSemSaldo() {
      contaCorrenteCliente1.depositar(1000);
      contaCliente2.depositar(1000);
      Assertions.assertThrows(IllegalArgumentException.class, () -> contaCorrenteCliente1.transferir(contaCliente2, 10000));
    }

    @Test
    @DisplayName("Deveria testar deposito em cada conta e verificar saldo com sucesso")
    void testarDepositoEmCadaConta() {
      contaCorrenteCliente1.depositar(1000);
      contaCliente2.depositar(1000);
      contaPagamentoCliente1.depositar(1000);
      assertEquals(1000, contaCorrenteCliente1.getSaldo());
      assertEquals(1000, contaCliente2.getSaldo());
      assertEquals(1000, contaPagamentoCliente1.getSaldo());
    }

    @Test
    @DisplayName("Deveria testar deposito negativo na conta")
    void testarDepositoNegativoEmCadaConta() {
      Assertions.assertThrows(IllegalArgumentException.class, () -> contaCorrenteCliente1.depositar(-1000));
    }

}