package guzman.joaquin.ciutat.controller;

import guzman.joaquin.ciutat.model.domain.Ciutat;
import guzman.joaquin.ciutat.model.service.CiutatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ciutat")
public class CiutatController {
    private final CiutatService ciutatService;

    @Autowired
    public CiutatController(CiutatService ciutatService) {
        this.ciutatService = ciutatService;
    }

    @GetMapping("/health")
    public String health() {
        return "L'API funciona correctament!";
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCiutat(@RequestBody Ciutat ciutat) {
        ResponseEntity<?> response;

        try {
            Ciutat novaCiutat = ciutatService.add(ciutat);
            response = ResponseEntity.status(HttpStatus.OK).body(novaCiutat);
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return response;
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCiutat(@RequestBody Ciutat ciutat) {
        ResponseEntity<?> response;

        try {
            Ciutat ciutatActualitzat = ciutatService.update(ciutat);
            response = ResponseEntity.status(HttpStatus.OK).body(ciutatActualitzat);
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCiutat(@PathVariable int id) {
        ResponseEntity<?> response;

        try {
            ciutatService.delete(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Ciutat amb id " + id + " eliminada.");
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return response;
    }

    @GetMapping("/find")
    public ResponseEntity<?> findCiutatById(@RequestParam int id) {
        ResponseEntity<?> response;

        try {
            Ciutat ciutat = ciutatService.findById(id);
            if (ciutat != null) {
                response = ResponseEntity.status(HttpStatus.OK).body(ciutat);
            } else {
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ciutat amb id " + id + " no trobada.");
            }
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return response;
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllCiutat() {
        ResponseEntity<?> response;

        try {
            List<Ciutat> ciutatList = ciutatService.findAll();
            if (ciutatList == null) {
                ciutatList = new ArrayList<>();
            }

            response = ResponseEntity.status(HttpStatus.OK).body(ciutatList);
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return response;
    }
}
