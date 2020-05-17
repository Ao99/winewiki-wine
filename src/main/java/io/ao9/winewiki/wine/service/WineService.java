package io.ao9.winewiki.wine.service;

import io.ao9.winewiki.wine.jpa.WineEntity;

import java.util.List;

public interface WineService {

    WineEntity save(WineEntity inputWine);

    List<WineEntity> findAll();

    WineEntity findById(int id);

    void deleteById(int id);
}
