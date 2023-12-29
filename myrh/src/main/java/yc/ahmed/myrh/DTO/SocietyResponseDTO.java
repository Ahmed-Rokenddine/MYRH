package yc.ahmed.myrh.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SocietyResponseDTO {
    private int id;
    private String login;
    private String name;
    private String password;
    private String adresse;
    private String email;
    private Long num;
    private String image;
}
