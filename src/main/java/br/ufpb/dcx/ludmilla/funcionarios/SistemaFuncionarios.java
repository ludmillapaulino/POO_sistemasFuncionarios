package br.ufpb.dcx.ludmilla.funcionarios;

import java.util.List;

public interface SistemaFuncionarios {

    void cadastrarFuncionario(Funcionario funcionario)
            throws FuncionarioJaExisteException;

    void cadastrarFuncionario(String cpf,
                              String nome,
                              TipoFuncionario tipo,
                              double salario)
            throws FuncionarioJaExisteException;

    void alterarSalarioDeFuncionario(String cpfFuncionario,
                                     double novoSalario)
            throws FuncionarioInexistenteException;

    int contarFuncionariosDoTipo(TipoFuncionario tipo);

    boolean funcionarioJaExiste(String cpfFuncionario);

    List<Funcionario> pesquisarFuncionariosPorTipo(
            TipoFuncionario tipo);

    Funcionario pesquisarFuncionario(String cpfFuncionario)
            throws FuncionarioInexistenteException;

    List<Funcionario> pesquisarFuncionariosComSalarioMaiorQue(
            double valor);
}