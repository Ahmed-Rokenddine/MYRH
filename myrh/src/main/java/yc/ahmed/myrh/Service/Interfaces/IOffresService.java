package yc.ahmed.myrh.Service.Interfaces;

import org.springframework.data.domain.Page;
import yc.ahmed.myrh.DTO.OffresResponseDTO;
import yc.ahmed.myrh.Entities.Offres;

public interface IOffresService {

    Page<Offres> getAllOffress(int page, int size);
    Offres getOffresById(long OffresId);
    boolean createOffres(OffresResponseDTO offres);
    void updateOffres(Offres offres);
    void deleteOffres(long OffresId);
}
