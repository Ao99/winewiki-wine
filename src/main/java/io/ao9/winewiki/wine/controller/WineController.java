package io.ao9.winewiki.wine.controller;

import io.ao9.winewiki.wine.jpa.WineEntity;
import io.ao9.winewiki.wine.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WineController {

    @Autowired
    private WineService wineService;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    @PostMapping("/wines")
    public WineEntity createWine(@RequestBody WineEntity inputWine) {
        WineEntity outputWine = wineService.save(inputWine);
        return outputWine;
    }

    @GetMapping("/wines")
    public List<WineEntity> getAllWines() {
        return wineService.findAll();
    }

    @GetMapping("/wines/{id}")
    public WineEntity getById(@PathVariable int id) {
        WineEntity outputWine = wineService.findById(id);
        return outputWine;
    }

    @DeleteMapping("/wines/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        WineEntity outputWine = wineService.findById(id);
        if (outputWine != null) {
            wineService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Wine with id-%d not found!", id));
        }
    }

}
