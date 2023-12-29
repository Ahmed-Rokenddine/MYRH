package yc.ahmed.myrh.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import yc.ahmed.myrh.DTO.SocietyRequestDTO;
import yc.ahmed.myrh.DTO.SocietyResponseDTO;
import yc.ahmed.myrh.Entities.Society;
import yc.ahmed.myrh.Repository.SocietyRepository;
import yc.ahmed.myrh.Service.Interfaces.ISocietyService;

import java.util.stream.Collectors;

@Service
public class SocietyService implements ISocietyService  {
    private final yc.ahmed.myrh.Repository.SocietyRepository SocietyRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public SocietyService(
            SocietyRepository SocietyRepository, ModelMapper modelMapper){
        this.SocietyRepository=SocietyRepository;
        this.modelMapper = modelMapper;
    }

    private SocietyRequestDTO convertToDto(Society Society) {
        return modelMapper.map(Society, SocietyRequestDTO.class);
    }

    @Override
    public Society getSocietyById(long SocietyId) {
        return SocietyRepository.findById(SocietyId).orElse(null);

    }

    @Override
    public Page<Society> getAllSocietys(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Society> SocietyPage = SocietyRepository.findAll(paging);
        SocietyPage.getContent().stream().collect(Collectors.toList());
        return SocietyPage;

    }

    @Override
    public boolean createSociety(SocietyResponseDTO SocietyDTO) {
        Society Society =  modelMapper.map(SocietyDTO, Society.class);

        SocietyRepository.save(Society);

        return true;

    }

    @Override
    public void updateSociety(Society Society) {
        SocietyRepository.save(Society);
    }

    @Override
    public void deleteSociety(long SocietyId) {
        SocietyRepository.deleteById(SocietyId);
    }
}
