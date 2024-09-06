package br.com.sge.services;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.sge.dto.PedidoEntregaDTO;
import br.com.sge.entities.PedidoEntrega;
import br.com.sge.repositories.ClienteRepository;
import br.com.sge.repositories.PedidoEntregaRepository;
import br.com.sge.repositories.VeiculoRepository;
import br.com.sge.services.exceptions.ResourceNotFoundException;
import br.com.sge.tests.Factory;
import jakarta.persistence.EntityNotFoundException;

@ExtendWith(SpringExtension.class) // Integra o suporte do Spring Test com o JUnit 5
public class PedidoEntregaServiceTests {

    @InjectMocks
    private PedidoEntregaService service; // Serviço que será testado

    @Mock
    private PedidoEntregaRepository repository; // Repositório simulado
    
    @Mock
    private ClienteRepository clienteRepository; // Repositório simulado para Cliente

    @Mock
    private VeiculoRepository veiculoRepository; // Repositório simulado para Veículo

    // IDs e objetos para teste
    private long idExistente;
    private long idInexistente;
    private long idDependente;
    private PedidoEntrega pedidoEntrega;
    private PageImpl<PedidoEntrega> page;

    @BeforeEach
    void setUp() throws Exception {
        // Configura IDs e objetos para os testes
        idExistente = 2L;  // ID de um pedido de entrega existente
        idInexistente = 30L; // ID de um pedido de entrega inexistente
        idDependente = 1L; // ID de um pedido de entrega com dependências
        pedidoEntrega = Factory.createPedidoEntrega(); // Cria um objeto PedidoEntrega
        page = new PageImpl<>(List.of(pedidoEntrega)); // Página contendo o pedido de entrega

        // Configura os comportamentos esperados dos mocks

        // Excluir Dados
        Mockito.doNothing().when(repository).deleteById(idExistente); // Exclui com sucesso
        Mockito.doThrow(EmptyResultDataAccessException.class).when(repository).deleteById(idInexistente); // Lança exceção para ID inexistente

        // Salvar Dados
        Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(pedidoEntrega); // Salva e retorna o pedido de entrega
        
        Mockito.when(repository.getReferenceById(idExistente)).thenReturn(pedidoEntrega); // Retorna pedido de entrega existente
        Mockito.when(repository.getReferenceById(idInexistente)).thenThrow(EntityNotFoundException.class); // Lança exceção para ID inexistente

        // Consultar Dados
        Mockito.when(repository.findAll((Pageable) ArgumentMatchers.any())).thenReturn(page); // Retorna página de pedidos de entrega

        // Consultar por Id
        Mockito.when(repository.findById(idExistente)).thenReturn(Optional.of(pedidoEntrega)); // Retorna pedido de entrega existente
        Mockito.when(repository.findById(idInexistente)).thenReturn(Optional.empty()); // Retorna Optional vazio para ID inexistente
    }

    @Test
    public void updateDeveriaLancarResourceNotFoundExceptionQuandoIdInexistente() {
        // Testa se a atualização lança ResourceNotFoundException para ID inexistente
        PedidoEntregaDTO dto = Factory.createPedidoEntregaDTO();
        
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.update(idInexistente, dto); // Chama método de atualização com ID inexistente
        });
    }
    
    @Test
    public void insertDeveriaSalvarQuandoIdNulo() {
        // Testa se a inserção salva o pedido de entrega quando o ID é nulo
        PedidoEntregaDTO dto = Factory.createPedidoEntregaDTO();
        dto.setId(null); // Define ID como nulo
        dto = service.insert(dto); // Chama método de inserção
        Assertions.assertNotNull(dto); // Verifica se o objeto não é nulo após a inserção
    }    
    
    @Test
    public void updateDeveriaAtualizarQuandoIdExistente() {
        // Testa se a atualização ocorre corretamente quando o ID existe
        PedidoEntregaDTO dto = Factory.createPedidoEntregaDTO();
    
        dto = service.update(idExistente, dto); // Chama método de atualização com ID existente
        Assertions.assertNotNull(dto); // Verifica se o objeto atualizado não é nulo
    }    
    
    @Test
    public void findByIdDeveriaLancarResourceNotFoundExceptionQuandoIdInexistente() {
        // Testa se o método findById lança ResourceNotFoundException para ID inexistente
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.findById(idInexistente); // Chama método de busca por ID
        });
    }
    
    @Test
    public void findByIdDeveriaRetornarObjetoQuandoIdExistente() {
        // Testa se o método findById retorna o objeto quando o ID existe
        PedidoEntregaDTO dto = service.findById(idExistente); // Chama método de busca por ID existente
        Assertions.assertNotNull(dto); // Verifica se o objeto retornado não é nulo
    }

    @Test
    public void findAllPagedDeveriaRetornarPagina() {
        // Testa se o método findAllPaged retorna uma página de pedidos de entrega
        Pageable pageable = Pageable.ofSize(10); // Define o tamanho da página
        Page<PedidoEntregaDTO> pagina = service.findAllPaged(pageable); // Chama método de busca paginada
        Assertions.assertNotNull(pagina); // Verifica se a página retornada não é nula
    }

    @Test
    public void deleteDeveriaFazerNadaQuandoIdExistente() {
        // Testa se o método delete não lança exceção para ID existente
        Assertions.assertDoesNotThrow(() -> {
            service.delete(idExistente); // Chama método de exclusão com ID existente
        });
    }

    @Test
    public void deleteDeveriaLancarResourceNotFoundExceptionQuandoIdInexistente() {
        // Testa se o método delete lança ResourceNotFoundException para ID inexistente
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.delete(idInexistente); // Chama método de exclusão com ID inexistente
        });
        Mockito.verify(repository).deleteById(idInexistente); // Verifica se o método deleteById foi chamado
    }

    // Teste comentado: 
    // @Test
    // public void deleteDeveriaLancarDataBaseExceptionQuandoIdDependente() {
    //     // Testa se o método delete lança DataBaseException quando o ID possui dependências
    //     Assertions.assertThrows(DataBaseException.class, () -> {
    //         service.delete(idDependente); // Chama método de exclusão com ID dependente
    //     });
    // }
}
