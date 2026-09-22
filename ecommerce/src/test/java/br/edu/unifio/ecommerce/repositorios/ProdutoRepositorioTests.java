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

import br.edu.unifio.ecommerce.entidades.Produto;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProdutoRepositorioTests {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @Test
    public void deveBuscarUmProdutoPorId() {
        Optional<Produto> produtoOptional = produtoRepositorio.findById(1);

        assertTrue(produtoOptional.isPresent());

        Produto produto = produtoOptional.get();
        assertEquals("Código Limpo", produto.getNome());
        assertEquals(0, produto.getPreco().compareTo(new BigDecimal("73.44")));
    }

    @Test
    public void deveListarTodosOsProdutos() {
        List<Produto> produtos = produtoRepositorio.findAll();

        assertNotNull(produtos);
        assertEquals(5, produtos.size());
    }

    @Test
    public void produtoDeveEstarRelacionadoComSuaCategoria() {
        Optional<Produto> produtoOptional = produtoRepositorio.findById(1);

        assertTrue(produtoOptional.isPresent());
        Produto produto = produtoOptional.get();

        assertNotNull(produto.getCategoria());
        assertEquals("Livros", produto.getCategoria().getNome());
    }
}