package io.ao9.winewiki.wine.service;

import io.ao9.winewiki.wine.jpa.WineEntity;
import io.ao9.winewiki.wine.jpa.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WineServiceImpl implements WineService {

    @Autowired
    private WineRepository wineRepository;

    @Override
    public WineEntity save(WineEntity inputWine) {
        WineEntity outputWine = wineRepository.save(inputWine);
        return outputWine;
    }

    @Override
    public List<WineEntity> findAll() {
        return wineRepository.findAll();
    }

    @Override
    public WineEntity findById(int id) {
        Optional<WineEntity> optionalWineEntity = wineRepository.findById(id);

        WineEntity outputWine = optionalWineEntity.orElse(null);
//        WineEntity outputWine;
//        if(optionalWineEntity.isPresent()) {
//            outputWine = optionalWineEntity.get();
//        } else {
//            outputWine = null;
//        }

        return outputWine;
    }

    @Override
    public void deleteById(int id) {
        wineRepository.deleteById(id);
    }

}
