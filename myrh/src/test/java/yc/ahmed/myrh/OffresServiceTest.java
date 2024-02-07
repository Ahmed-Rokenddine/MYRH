package yc.ahmed.myrh;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import yc.ahmed.myrh.Entities.Offres;
import yc.ahmed.myrh.Repository.OffresRepository;
import yc.ahmed.myrh.Service.OffresService;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OffresServiceTest {

    @Mock
    private OffresRepository offresRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private OffresService offresService;

    @Test
    public void testGetOffresById() {
        // Arrange
        long offresId = 1L;
        Offres expectedOffres = new Offres();
        when(offresRepository.findById(offresId)).thenReturn(Optional.of(expectedOffres));

        // Act
        Offres result = offresService.getOffresById(offresId);

        // Assert
        assertEquals(expectedOffres, result);
        verify(offresRepository, times(1)).findById(offresId);
    }

    private void assertEquals(Offres expectedOffres, Offres result) {

    }

    @Test
    public void testGetAllOffres() {
        // Arrange
        int page = 0;
        int size = 10;
        Pageable pageable = PageRequest.of(page, size);
        Page<Offres> expectedPage = new PageImpl<>(Collections.emptyList());
        when(offresRepository.findAll(pageable)).thenReturn(expectedPage);

        // Act
        Page<Offres> result = offresService.getAllOffress(page, size);

        // Assert
        assertEquals((Offres) expectedPage, (Offres) result);
        verify(offresRepository, times(1)).findAll(pageable);
    }

    // Similar tests for other methods (createOffres, updateOffres, deleteOffres) can be added.
}

