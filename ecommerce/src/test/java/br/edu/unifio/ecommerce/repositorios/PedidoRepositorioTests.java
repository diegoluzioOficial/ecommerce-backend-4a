package br.edu.unifio.ecommerce.repositorios;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import br.edu.unifio.ecommerce.entidades.Pedido;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PedidoRepositorioTests {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Test
    public void deveBuscarUmPedidoPorId() {
        Optional<Pedido> pedidoOptional = pedidoRepositorio.findById(1);

        assertTrue(pedidoOptional.isPresent());

        Pedido pedido = pedidoOptional.get();
        assertEquals("Enviado", pedido.getStatus());
        assertEquals(0, pedido.getValorTotal().compareTo(new BigDecimal("73.44")));
    }

    @Test
    public void deveListarTodosOsPedidos() {
        List<Pedido> pedidos = pedidoRepositorio.findAll();

        assertNotNull(pedidos);
        assertEquals(5, pedidos.size());
    }

    @Test
    public void pedidoDeveEstarRelacionadoComCliente() {
        Optional<Pedido> pedidoOptional = pedidoRepositorio.findById(1);

        assertTrue(pedidoOptional.isPresent());
        Pedido pedido = pedidoOptional.get();

        assertNotNull(pedido.getCliente());
        assertEquals("Guilherme", pedido.getCliente().getNome());
    }
}