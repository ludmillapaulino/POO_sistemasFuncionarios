package br.ufpb.dcx.ludmilla.funcionarios;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class SistemaFuncionariosBomPratoTest {

    @Test
    public void testaCadastroEPesquisa() {

        SistemaFuncionariosBomPrato sistema =
                new SistemaFuncionariosBomPrato();

        try {

            sistema.cadastrarFuncionario(
                    "333.333.333-33",
                    "Ayla Rebouças",
                    TipoFuncionario.GERENTE,
                    3000);

            assertTrue(
                    sistema.funcionarioJaExiste(
                            "333.333.333-33"));

            Funcionario f1 =
                    sistema.pesquisarFuncionario(
                            "333.333.333-33");

            sistema.cadastrarFuncionario(
                    "222.222.222-22",
                    "João Paulo Silva",
                    TipoFuncionario.COZINHEIRO,
                    5000);

            assertEquals(
                    2,
                    sistema
                            .pesquisarFuncionariosComSalarioMaiorQue(
                                    2000)
                            .size());

            assertEquals(
                    1,
                    sistema.contarFuncionariosDoTipo(
                            TipoFuncionario.COZINHEIRO));

        } catch (FuncionarioJaExisteException |
                 FuncionarioInexistenteException e) {

            fail("Não deveria lançar exceção");
        }
    }
}