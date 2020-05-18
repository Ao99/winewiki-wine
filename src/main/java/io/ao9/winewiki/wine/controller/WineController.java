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
    public ResponseEntity<WineEntity> createWine(@RequestBody WineEntity inputWine) {
        WineEntity outputWine = wineService.save(inputWine);
        return ResponseEntity.status(HttpStatus.CREATED).body(outputWine);
    }

    @GetMapping("/wines")
    public ResponseEntity<List<WineEntity>> getAllWines() {
        return ResponseEntity.status(HttpStatus.OK).body(wineService.findAll());
    }

    @GetMapping("/wines/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        WineEntity outputWine = wineService.findById(id);
        if (outputWine != null) {
            return ResponseEntity.status(HttpStatus.OK).body(outputWine);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Wine with id-%d not found!", id));
        }
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

    @PutMapping("/wines/{id}")
    public ResponseEntity<?> updateById(@PathVariable int id, @RequestBody WineEntity inputWine) {
        WineEntity foundWine = wineService.findById(id);
        if (foundWine != null) {
            WineEntity updatedWine = wineService.save(inputWine);
            return ResponseEntity.status(HttpStatus.OK).body(updatedWine);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Wine with id-%d not found!", id));
        }
    }

}
