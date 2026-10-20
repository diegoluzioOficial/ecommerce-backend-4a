package br.edu.unifio.ecommerce.repositorios;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import br.edu.unifio.ecommerce.entidades.Categoria;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoriaRepositorioTests {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Test
    public void deveBuscarUmaCategoriaPorId() {
        Optional<Categoria> categoriaOptional = categoriaRepositorio.findById(Short.parseShort("2"));

        assertTrue(categoriaOptional.isPresent());

        Categoria categoria = categoriaOptional.get();
        assertEquals("Eletrônicos", categoria.getNome());
        assertEquals("Equipamentos Eletrônicos", categoria.getDescricao());
    }

    @Test
    public void deveListarTodasAsCategorias() {
        List<Categoria> categorias = categoriaRepositorio.findAll();

        assertNotNull(categorias);
        assertEquals(5, categorias.size());
    }
}