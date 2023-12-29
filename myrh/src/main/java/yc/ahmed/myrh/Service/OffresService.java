package yc.ahmed.myrh.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import yc.ahmed.myrh.DTO.OffresRequestDTO;
import yc.ahmed.myrh.DTO.OffresResponseDTO;
import yc.ahmed.myrh.Repository.OffresRepository;
import yc.ahmed.myrh.Entities.Offres;
import yc.ahmed.myrh.Service.Interfaces.IOffresService;


import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OffresService implements IOffresService {
    private final OffresRepository OffresRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public OffresService(
            OffresRepository OffresRepository, ModelMapper modelMapper){
        this.OffresRepository=OffresRepository;
        this.modelMapper = modelMapper;
    }

    private OffresRequestDTO convertToDto(Offres Offres) {
        return modelMapper.map(Offres, OffresRequestDTO.class);
    }

    @Override
    public Offres getOffresById(long OffresId) {
        return OffresRepository.findById(OffresId).orElse(null);

    }

    @Override
    public Page<Offres> getAllOffress(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Offres> OffresPage = OffresRepository.findAll(paging);
        OffresPage.getContent().stream().collect(Collectors.toList());
        return OffresPage;

    }

    @Override
    public boolean createOffres(OffresResponseDTO OffresDTO) {
        Offres Offres =  modelMapper.map(OffresDTO, Offres.class);

            OffresRepository.save(Offres);

            return true;

    }

    @Override
    public void updateOffres(Offres Offres) {
        OffresRepository.save(Offres);
    }

    @Override
    public void deleteOffres(long OffresId) {
        OffresRepository.deleteById(OffresId);
    }
}
