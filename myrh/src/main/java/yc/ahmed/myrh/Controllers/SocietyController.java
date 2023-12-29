package yc.ahmed.myrh.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yc.ahmed.myrh.DTO.SocietyResponseDTO;
import yc.ahmed.myrh.Entities.Society;
import yc.ahmed.myrh.Service.Interfaces.ISocietyService;

@RestController
@RequestMapping("app")
@CrossOrigin(origins = { "http://localhost:4200" })
public class SocietyController {
    @Autowired
    private ISocietyService SocietyService;

    @GetMapping("Society")
    public ResponseEntity<Society> getSocietyById(@RequestParam("id") long id) {
        System.out.println("id: " + id);
        Society Society = SocietyService.getSocietyById(id);
        return new ResponseEntity<Society>(Society, HttpStatus.OK);
    }

    @GetMapping("/allSociety")
    public Page<Society> getAllSociety(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return SocietyService.getAllSocietys(page, size);

    }

    @PostMapping("Society")
    public String createSociety(@RequestBody SocietyResponseDTO Society) {
        SocietyService.createSociety(Society);
        return "Created SUCCESSFULLY" ;
    }



    @PutMapping("Society")
    public ResponseEntity<Society> updateSociety(@RequestBody Society Society) {
        SocietyService.updateSociety(Society);
        return new ResponseEntity<Society>(Society, HttpStatus.OK);
    }

    @DeleteMapping("Society")
    public ResponseEntity<Void> deleteSociety(@RequestParam("id") long id) {
        SocietyService.deleteSociety(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
