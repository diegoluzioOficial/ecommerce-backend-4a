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

import br.edu.unifio.ecommerce.entidades.ItemPedido;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ItemPedidoRepositorioTests {

    @Autowired
    private ItemPedidoRepositorio itemPedidoRepositorio;

    @Test
    public void deveBuscarUmItemPedidoPorId() {
        Optional<ItemPedido> itemOptional = itemPedidoRepositorio.findById(1);

        assertTrue(itemOptional.isPresent());

        ItemPedido item = itemOptional.get();
        assertEquals(1, item.getQuantidade());
        assertEquals(0, item.getValorUnitario().compareTo(new BigDecimal("73.44")));
    }

    @Test
    public void deveListarTodosOsItensPedido() {
        List<ItemPedido> itens = itemPedidoRepositorio.findAll();

        assertNotNull(itens);
        assertEquals(5, itens.size());
    }

    @Test
    public void itemPedidoDeveEstarRelacionadoComPedidoEProduto() {
        Optional<ItemPedido> itemOptional = itemPedidoRepositorio.findById(1);

        assertTrue(itemOptional.isPresent());
        ItemPedido item = itemOptional.get();

        assertNotNull(item.getPedido());
        assertEquals(Integer.valueOf(1), item.getPedido().getId());

        assertNotNull(item.getProduto());
        assertEquals("Código Limpo", item.getProduto().getNome());
    }
}