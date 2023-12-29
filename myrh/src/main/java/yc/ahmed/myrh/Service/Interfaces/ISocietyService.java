package yc.ahmed.myrh.Service.Interfaces;

import org.springframework.data.domain.Page;
import yc.ahmed.myrh.DTO.SocietyResponseDTO;
import yc.ahmed.myrh.Entities.Society;

public interface ISocietyService {
    Page<Society> getAllSocietys(int page, int size);
    Society getSocietyById(long SocietyId);
    boolean createSociety(SocietyResponseDTO Society);
    void updateSociety(Society Society);
    void deleteSociety(long SocietyId);
}
