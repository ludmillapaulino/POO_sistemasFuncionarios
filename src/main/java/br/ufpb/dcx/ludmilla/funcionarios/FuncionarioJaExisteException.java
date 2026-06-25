package br.ufpb.dcx.ludmilla.funcionarios;

public class FuncionarioJaExisteException extends Exception {

    public FuncionarioJaExisteException(String mensagem) {
        super(mensagem);
    }
}