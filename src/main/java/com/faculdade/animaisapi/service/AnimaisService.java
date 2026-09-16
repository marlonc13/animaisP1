package com.faculdade.animaisapi.service;

import com.faculdade.animaisapi.exception.AnimaisNotFoundException;
import com.faculdade.animaisapi.model.Animais;
import com.faculdade.animaisapi.repository.AnimaisRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnimaisService {

    private final AnimaisRepository animaisRepository;

    public AnimaisService(AnimaisRepository animaisRepository) {
        this.animaisRepository = animaisRepository;
    }

    public Animais cadastrar(Animais animais) {
        return animaisRepository.save(animais);
    }

    public List<Animais> listarTodos() {
        return animaisRepository.findAll();
    }

    public Optional<Animais> buscarPorId(UUID _id) {
        return animaisRepository.findById(_id);
    }

    public Animais atualizar(UUID id, Animais animalAtualizado) {
        Animais animal = animaisRepository.findById(id)
                .orElseThrow(AnimaisNotFoundException::new);

        animal.setNome(animalAtualizado.getNome());
        animal.setEspecie(animalAtualizado.getEspecie());
        animal.setRaca(animalAtualizado.getRaca());
        animal.setIdade(animalAtualizado.getIdade());
        animal.setSexo(animalAtualizado.getSexo());
        animal.setDisponivelParaAdocao(animalAtualizado.getDisponivelParaAdocao());

        return animaisRepository.save(animal);
    }

    public void excluir(UUID id) {
        if (!animaisRepository.existsById(id)) {
            throw new AnimaisNotFoundException();
        }

        animaisRepository.deleteById(id);
    }
}
