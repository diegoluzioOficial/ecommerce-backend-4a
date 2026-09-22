package br.edu.unifio.ecommerce.repositorios;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import br.edu.unifio.ecommerce.entidades.Cliente;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClienteRepositorioTests {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Test
    public void deveBuscarUmClientePorId() {
        Optional<Cliente> clienteOptional = clienteRepositorio.findById(1);

        assertTrue(clienteOptional.isPresent());

        Cliente cliente = clienteOptional.get();
        assertEquals("Guilherme", cliente.getNome());
        assertEquals("GuiGonViado@email.com", cliente.getEmail());
    }

    @Test
    public void deveListarTodosOsClientes() {
        List<Cliente> clientes = clienteRepositorio.findAll();

        assertNotNull(clientes);
        assertEquals(5, clientes.size());
        assertTrue(clientes.stream().anyMatch(c -> c.getNome().equals("Daniel")));
    }
}