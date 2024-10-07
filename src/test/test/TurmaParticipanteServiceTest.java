import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.rafaelFerroPS.desafioLinkedRHBE.DTO.TurmaParticipanteDTO;
import com.rafaelFerroPS.desafioLinkedRHBE.Repository.TurmaParticipanteRepository;
import com.rafaelFerroPS.desafioLinkedRHBE.model.TurmaParticipante;
import com.rafaelFerroPS.desafioLinkedRHBE.service.TurmaParticipanteService;

public class TurmaParticipanteServiceTest {

	@InjectMocks
    private TurmaParticipanteService turmaParticipanteService;

    @Mock
    private TurmaParticipanteRepository turmaParticipanteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
    }

    @Test
    void getAllParticipantes_ShouldReturnAllParticipantes() {
        // Dado
        int turmaId = 1;
        List<TurmaParticipante> participantes = Arrays.asList(
            new TurmaParticipante(1, turmaId, 10),
            new TurmaParticipante(2, turmaId, 20)
        );
        when(turmaParticipanteRepository.findByTurmaId(turmaId)).thenReturn(participantes);

        // Quando
        List<TurmaParticipanteDTO> result = turmaParticipanteService.getAllParticipantes(turmaId);

        // Então
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getCodigo());
        assertEquals(10, result.get(0).getFuncionarioId());
        verify(turmaParticipanteRepository, times(1)).findByTurmaId(turmaId);
    }

    @Test
    void addParticipante_ShouldSaveAndReturnParticipante() {
        // Dado
        int turmaId = 1;
        TurmaParticipanteDTO participanteDTO = new TurmaParticipanteDTO(null, turmaId, 10);
        TurmaParticipante savedParticipante = new TurmaParticipante(1, turmaId, 10);
        when(turmaParticipanteRepository.save(any(TurmaParticipante.class))).thenReturn(savedParticipante);

        // Quando
        TurmaParticipanteDTO result = turmaParticipanteService.addParticipante(turmaId, participanteDTO);

        // Então
        assertNotNull(result.getCodigo());
        assertEquals(turmaId, result.getTurmaId());
        assertEquals(10, result.getFuncionarioId());
        verify(turmaParticipanteRepository, times(1)).save(any(TurmaParticipante.class));
    }

    @Test
    void removeParticipante_ShouldDeleteParticipante() {
        // Dado
        int turmaId = 1;
        int funcionarioId = 10;

        // Quando
        turmaParticipanteService.removeParticipante(turmaId, funcionarioId);

        // Então
        verify(turmaParticipanteRepository, times(1)).deleteByTurmaAndFuncionario(turmaId, funcionarioId);
    }
	
}
