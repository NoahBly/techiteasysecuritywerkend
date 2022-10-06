package com.example.demo.Controller;


import com.example.demo.Dto.CIModuleDto;
import com.example.demo.Dto.WallBracketDto;
import com.example.demo.Service.WallBracketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class WallBracketcontroller {

    private WallBracketService service;

    public WallBracketcontroller(WallBracketService service) {
        this.service = service;
    }

    @PostMapping("/wallbrackets")
    public ResponseEntity<Object> createWallBracket(@RequestBody WallBracketDto wallbracketdto, BindingResult br) {
        if(br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for(FieldError ferror: br.getFieldErrors()){
                sb.append(ferror.getField() + ":");
                sb.append(ferror.getDefaultMessage());
                sb.append("\n");
            }return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);

        }else {

            long wallbracketId =  service.createWallBracket(wallbracketdto);
            return new ResponseEntity<>(wallbracketId, HttpStatus.CREATED);
        }
    }


    @GetMapping("/wallbrackets/{id}")
    public ResponseEntity<Object> getWallBracket(@Valid @PathVariable long id) {

        return new ResponseEntity<>(service.getWallBracketbyId(id), HttpStatus.OK);
    }

    @GetMapping("/wallbrackets")
    public ResponseEntity<Object> getAllWallBrackets() {

        return new ResponseEntity<>(service.findAllWallBrackets(), HttpStatus.OK);
    }

    @DeleteMapping("/wallbrackets/{id}")
    public ResponseEntity <Object> deleteWallBrackets(@PathVariable long id) {
        service.deleteWallBracketbyId(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/wallbrackets/{id}")
    public ResponseEntity<Object> updateWallBracket(@PathVariable long id, @RequestBody WallBracketDto wallbracketdtoinput) {

        return new ResponseEntity<>(service.updateWallBracket(wallbracketdtoinput,id), HttpStatus.OK);
    }


}
