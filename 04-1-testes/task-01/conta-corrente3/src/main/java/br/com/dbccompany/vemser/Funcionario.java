package br.com.dbccompany.vemser;

import java.time.LocalDate;
import java.time.Period;

public class Funcionario {
  String nome;
  LocalDate dataNascimento;
  LocalDate dataContratacao;
  double salario;

  public Funcionario(String nome, LocalDate dataNascimento, LocalDate dataContratacao, double salario) {
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.dataContratacao = dataContratacao;
    this.salario = salario;
  }

  public int calcularTempoDeEmpresa() {
    return Period.between(dataContratacao, LocalDate.now()).getYears();
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    if(nome == null || nome == "") {
      throw new IllegalArgumentException("Nome não pode ser vazio ou nulo");
    }
    this.nome = nome;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public LocalDate getDataContratacao() {
    return dataContratacao;
  }

  public void setDataContratacao(LocalDate dataContratacao) {
    this.dataContratacao = dataContratacao;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }
}
