package yc.ahmed.myrh.DTO;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yc.ahmed.myrh.Enums.OffresStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OffresResponseDTO {
    private int id;
    private String profil;
    private String study;
    private String salaire;
    private String ville;
    private SocietyResponseDTO Society;
    @Enumerated(EnumType.STRING)
    private OffresStatus status;


}
