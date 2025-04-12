package guzman.joaquin.ciutat.model.service;

import guzman.joaquin.ciutat.model.domain.Ciutat;

import java.util.List;

public interface CiutatService {
    Ciutat add(Ciutat ciutat);
    Ciutat update(Ciutat ciutat);
    void delete(int id);
    Ciutat findById(int id);
    List<Ciutat> findAll();
}
