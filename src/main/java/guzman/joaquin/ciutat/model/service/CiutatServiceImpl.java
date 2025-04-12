package guzman.joaquin.ciutat.model.service;

import guzman.joaquin.ciutat.model.domain.Ciutat;
import guzman.joaquin.ciutat.model.repository.CiutatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiutatServiceImpl implements CiutatService {
    private final CiutatRepository ciutatRepository;

    @Autowired
    public CiutatServiceImpl(CiutatRepository ciutatRepository) {
        this.ciutatRepository = ciutatRepository;
    }

    @Override
    public Ciutat add(Ciutat ciutat) {
        return ciutatRepository.save(ciutat);
    }

    @Override
    public Ciutat update(Ciutat ciutat) {
        validaCiutat(ciutat);
        return ciutatRepository.save(ciutat);
    }

    @Override
    public void delete(int id) {
        ciutatRepository.deleteById(id);
    }

    @Override
    public Ciutat findById(int id) {
        Ciutat result = null;

        Optional<Ciutat> ciutat = ciutatRepository.findById(id);
        if (ciutat.isPresent()) {
            result = ciutat.get();
        }

        return result;
    }

    @Override
    public List<Ciutat> findAll() {
        return ciutatRepository.findAll();
    }

    private void validaCiutat(Ciutat ciutat) {
        if (ciutat == null) {
            throw new RuntimeException("No definida");
        }
        if (ciutat.getNom() == null || ciutat.getNom().isEmpty()) {
            throw new RuntimeException("Nom nula");
        }
        if (ciutat.getPrefixTel() <= 0) {
            throw new IllegalArgumentException("El prefix telefonic ha de ser un nombre positiu.");
        }
    }
}
