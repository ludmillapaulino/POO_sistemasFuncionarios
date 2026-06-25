package br.ufpb.dcx.ludmilla.funcionarios;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SistemaFuncionariosBomPrato
        implements SistemaFuncionarios {

    private Map<String, Funcionario> funcionarios;

    public SistemaFuncionariosBomPrato() {
        this.funcionarios = new HashMap<>();
    }

    @Override
    public void cadastrarFuncionario(Funcionario funcionario)
            throws FuncionarioJaExisteException {

        if (funcionarios.containsKey(funcionario.getCpf())) {
            throw new FuncionarioJaExisteException(
                    "Funcionário já cadastrado");
        }

        funcionarios.put(
                funcionario.getCpf(),
                funcionario);
    }

    @Override
    public void cadastrarFuncionario(String cpf,
                                     String nome,
                                     TipoFuncionario tipo,
                                     double salario)
            throws FuncionarioJaExisteException {

        if (funcionarios.containsKey(cpf)) {
            throw new FuncionarioJaExisteException(
                    "Já existe funcionário com o cpf " + cpf);
        }

        funcionarios.put(
                cpf,
                new Funcionario(
                        cpf,
                        nome,
                        tipo,
                        salario));
    }

    @Override
    public void alterarSalarioDeFuncionario(
            String cpfFuncionario,
            double novoSalario)
            throws FuncionarioInexistenteException {

        Funcionario f = funcionarios.get(cpfFuncionario);

        if (f == null) {
            throw new FuncionarioInexistenteException(
                    "Funcionário inexistente");
        }

        f.setSalario(novoSalario);
    }

    @Override
    public int contarFuncionariosDoTipo(
            TipoFuncionario tipo) {

        int contador = 0;

        for (Funcionario f : funcionarios.values()) {
            if (f.getTipo() == tipo) {
                contador++;
            }
        }

        return contador;
    }

    @Override
    public boolean funcionarioJaExiste(
            String cpfFuncionario) {

        return funcionarios.containsKey(cpfFuncionario);
    }

    @Override
    public List<Funcionario> pesquisarFuncionariosPorTipo(
            TipoFuncionario tipo) {

        List<Funcionario> lista = new LinkedList<>();

        for (Funcionario f : funcionarios.values()) {
            if (f.getTipo() == tipo) {
                lista.add(f);
            }
        }

        return lista;
    }

    @Override
    public Funcionario pesquisarFuncionario(
            String cpfFuncionario)
            throws FuncionarioInexistenteException {

        Funcionario f = funcionarios.get(cpfFuncionario);

        if (f == null) {
            throw new FuncionarioInexistenteException(
                    "Funcionário inexistente");
        }

        return f;
    }

    @Override
    public List<Funcionario>
    pesquisarFuncionariosComSalarioMaiorQue(
            double valor) {

        List<Funcionario> lista = new LinkedList<>();

        for (Funcionario f : funcionarios.values()) {
            if (f.getSalario() > valor) {
                lista.add(f);
            }
        }

        return lista;
    }
}