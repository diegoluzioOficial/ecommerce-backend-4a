package br.edu.unifio.ecommerce.repositorios;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import br.edu.unifio.ecommerce.entidades.Pagamento;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PagamentoRepositorioTests {

    @Autowired
    private PagamentoRepositorio pagamentoRepositorio;

    @Test
    public void deveBuscarUmPagamentoPorId() {
        Optional<Pagamento> pagamentoOptional = pagamentoRepositorio.findById(1);

        assertTrue(pagamentoOptional.isPresent());

        Pagamento pagamento = pagamentoOptional.get();
        assertEquals("Pago", pagamento.getStatus());
        assertEquals("Cartão de Crédito", pagamento.getTipo());
    }

    @Test
    public void deveListarTodosOsPagamentos() {
        List<Pagamento> pagamentos = pagamentoRepositorio.findAll();

        assertNotNull(pagamentos);
        assertEquals(5, pagamentos.size());
    }

    @Test
    public void pagamentoDeveEstarRelacionadoComPedido() {
        Optional<Pagamento> pagamentoOptional = pagamentoRepositorio.findById(1);

        assertTrue(pagamentoOptional.isPresent());
        Pagamento pagamento = pagamentoOptional.get();

        assertNotNull(pagamento.getPedido());
        assertEquals(Integer.valueOf(1), pagamento.getPedido().getId());
    }
}