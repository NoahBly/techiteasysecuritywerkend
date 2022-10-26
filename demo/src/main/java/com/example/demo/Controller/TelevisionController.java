package com.example.demo.Controller;


import com.example.demo.Dto.IdinputDto;
import com.example.demo.Dto.TelevisionDto;
import com.example.demo.Model.Television;
import com.example.demo.Repository.TelevisionRepository;
import com.example.demo.Service.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TelevisionController {
  private final TelevisionService service;

    public TelevisionController(TelevisionService service) {
        this.service = service;
    }

    @PostMapping("/televisies")
    public ResponseEntity<Object> createTelevision(@RequestBody TelevisionDto tvdto, BindingResult br) {
        if(br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for(FieldError ferror: br.getFieldErrors()){
                sb.append(ferror.getField() + ":");
                sb.append(ferror.getDefaultMessage());
                sb.append("\n");
            }return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);

        }else {

        long TvID =  service.createTelevision(tvdto);
    return new ResponseEntity<>(TvID, HttpStatus.CREATED);
        }
    }


    @GetMapping("/televisies/{id}")
    public ResponseEntity<Object> getTV(@Valid @PathVariable long id) {

    return new ResponseEntity<>(service.getTelevisionbyID(id), HttpStatus.OK);
    }

    @GetMapping("/televisies")
    public ResponseEntity<Object> getAllTVs() {

        return new ResponseEntity<>(service.findAllTelevision(), HttpStatus.OK);
    }

    @DeleteMapping("/televisies/{id}")
    public ResponseEntity <Object> deleteTv(@PathVariable long id) {
        service.deleteByIdTelevision(id);

      return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/televisies/{id}")
    public ResponseEntity<Object> updateTv(@PathVariable long id, @RequestBody TelevisionDto tvdtoinput) {

        return new ResponseEntity<>(service.updateTelevision(tvdtoinput,id), HttpStatus.OK);
    }

    @PutMapping("/televisies/{id}/remotecontroller")
    public ResponseEntity<Object> assignRemotetoTelevision(@PathVariable long id, @RequestBody IdinputDto idinput) {

    return new ResponseEntity<>(service.assignRemoteControllertoTelevision(id,idinput.Id), HttpStatus.OK);
    }
}
