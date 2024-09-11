package br.com.sge.services;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.sge.dto.PedidoEntregaDTO;
import br.com.sge.entities.PedidoEntrega;
import br.com.sge.repositories.PedidoEntregaRepository;
import br.com.sge.services.exceptions.ResourceNotFoundException;
import br.com.sge.tests.Factory;

@ExtendWith(SpringExtension.class)
public class PedidoEntregaServiceTests {

    @InjectMocks
    private PedidoEntregaService service;

    @Mock
    private PedidoEntregaRepository repository;

    private long idExistente;
    private long idInexistente;
    private PedidoEntrega pedidoEntrega;

    @BeforeEach
    void setUp() throws Exception {
        idExistente = 1L;
        idInexistente = 100L;
        pedidoEntrega = Factory.createPedidoEntrega(idExistente);

        // Mock para findById com ID existente
        Mockito.when(repository.findById(idExistente)).thenReturn(Optional.of(pedidoEntrega));

        // Mock para findById com ID inexistente
        Mockito.when(repository.findById(idInexistente)).thenReturn(Optional.empty());

        // Mock para deleteById com ID existente
        Mockito.doNothing().when(repository).deleteById(idExistente);

        // Mock para deleteById com ID inexistente
        Mockito.doThrow(EmptyResultDataAccessException.class).when(repository).deleteById(idInexistente);

        // Mock para salvar
        Mockito.when(repository.save(Mockito.any())).thenReturn(pedidoEntrega);
    }


    @Test
    public void findByIdDeveriaLancarResourceNotFoundExceptionQuandoIdInexistente() {
        // Assert
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            // Act
            service.findById(idInexistente);
        });

        Mockito.verify(repository, Mockito.times(1)).findById(idInexistente);
    }

    @Test
    public void deleteDeveriaRemoverPedidoQuandoIdExistente() {
        // Act
        Assertions.assertDoesNotThrow(() -> {
            service.delete(idExistente);
        });

        Mockito.verify(repository, Mockito.times(1)).deleteById(idExistente);
    }

    @Test
    public void deleteDeveriaLancarResourceNotFoundExceptionQuandoIdInexistente() {
        // Assert
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            // Act
            service.delete(idInexistente);
        });

        Mockito.verify(repository, Mockito.times(1)).deleteById(idInexistente);
    }
}
