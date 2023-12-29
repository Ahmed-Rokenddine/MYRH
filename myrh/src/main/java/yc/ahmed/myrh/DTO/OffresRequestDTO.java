package yc.ahmed.myrh.DTO;

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
public class OffresRequestDTO {
    private int id;
    private String profil;
    private String study;
    private String salaire;
    private String ville;
    @Enumerated(EnumType.STRING)
    private OffresStatus status;

    private SocietyResponseDTO Society;
}
