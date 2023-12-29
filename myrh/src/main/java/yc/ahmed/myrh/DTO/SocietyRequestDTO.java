package yc.ahmed.myrh.DTO;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SocietyRequestDTO {
    private int id;
    private String name;
    private String login;
    private String password;
    private String adresse;
    private String email;
    private Long num;
    private String image;

    private List<OffresResponseDTO> offres = new ArrayList<OffresResponseDTO>();
}
