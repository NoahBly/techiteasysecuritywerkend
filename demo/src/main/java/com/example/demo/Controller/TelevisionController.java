package com.example.demo.Controller;


import com.example.demo.Model.Television;
import com.example.demo.Repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TelevisionController {
    @Autowired
    TelevisionRepository repos;

    @PostMapping("/televisies")
    public ResponseEntity<Television> createTelevision(@RequestBody Television televisie) {
    Television newTelevisie = repos.save(televisie);
    return new ResponseEntity<>(newTelevisie, HttpStatus.CREATED);
    }


    @GetMapping("/televisies/goedkoop")
    public ResponseEntity<Object> getExpensiveTVs(Double price) {
        price = 150.95;
    return new ResponseEntity<>(repos.findAllByPriceLessThan(price), HttpStatus.OK);
    }

}
