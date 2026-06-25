import br.ufpb.dcx.ludmilla.funcionarios.SistemaFuncionarios;
import br.ufpb.dcx.ludmilla.funcionarios.SistemaFuncionariosBomPrato;
import br.ufpb.dcx.ludmilla.funcionarios.TipoFuncionario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@Test
public void testaFuncionarioJaExiste() {

    SistemaFuncionarios sistema =
            new SistemaFuncionariosBomPrato();

    try {

        sistema.cadastrarFuncionario(
                "111.111.111-11",
                "Maria",
                TipoFuncionario.GERENTE,
                3000);

        assertTrue(
                sistema.funcionarioJaExiste(
                        "111.111.111-11"));

    } catch (Exception e) {
        fail("Não deveria lançar exceção");
    }
}

void main() {
}