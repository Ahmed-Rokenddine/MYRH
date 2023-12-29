package yc.ahmed.myrh.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yc.ahmed.myrh.DTO.OffresResponseDTO;
import yc.ahmed.myrh.Entities.Offres;
import yc.ahmed.myrh.Service.Interfaces.IOffresService;

import java.util.List;
@RestController
@RequestMapping("app")
@CrossOrigin(origins = { "http://localhost:4200" })
public class OffresController {

    @Autowired
    private IOffresService OffresService;

    @GetMapping("Offres")
    public ResponseEntity<Offres> getOffresById(@RequestParam("id") long id) {
        System.out.println("id: " + id);
        Offres Offres = OffresService.getOffresById(id);
        return new ResponseEntity<Offres>(Offres, HttpStatus.OK);
    }

    @GetMapping("/allOffres")
    public Page<Offres> getAllOffres(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return OffresService.getAllOffress(page, size);

    }

    @PostMapping("Offres")
    public String createOffres(@RequestBody OffresResponseDTO Offres) {
        OffresService.createOffres(Offres);
        return "Created SUCCESSFULLY" ;
    }



    @PutMapping("Offres")
    public ResponseEntity<Offres> updateOffres(@RequestBody Offres Offres) {
        OffresService.updateOffres(Offres);
        return new ResponseEntity<Offres>(Offres, HttpStatus.OK);
    }

    @DeleteMapping("Offres")
    public ResponseEntity<Void> deleteOffres(@RequestParam("id") long id) {
        OffresService.deleteOffres(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
