package com.example.demo.Controller;

import com.example.demo.Dto.CIModuleDto;
import com.example.demo.Dto.TelevisionDto;
import com.example.demo.Service.CIModuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CIModuleController {

    private final CIModuleService service;

    public CIModuleController(CIModuleService service) {
        this.service = service;
    }

    @PostMapping("/cimodules")
    public ResponseEntity<Object> createCImodule(@RequestBody CIModuleDto cimoduledto, BindingResult br) {
        if(br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for(FieldError ferror: br.getFieldErrors()){
                sb.append(ferror.getField() + ":");
                sb.append(ferror.getDefaultMessage());
                sb.append("\n");
            }return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);

        }else {

            long CImodId =  service.createCIModule(cimoduledto);
            return new ResponseEntity<>(CImodId, HttpStatus.CREATED);
        }
    }


    @GetMapping("/cimodules/{id}")
    public ResponseEntity<Object> getCIModule(@Valid @PathVariable long id) {

        return new ResponseEntity<>(service.getCIModulebyId(id), HttpStatus.OK);
    }

    @GetMapping("/cimodules")
    public ResponseEntity<Object> getAllCImodules() {

        return new ResponseEntity<>(service.findAllCIModules(), HttpStatus.OK);
    }

    @DeleteMapping("/cimodules/{id}")
    public ResponseEntity <Object> deleteCImodule(@PathVariable long id) {
        service.deleteCIModulebyId(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/cimodules/{id}")
    public ResponseEntity<Object> updateCIModule(@PathVariable long id, @RequestBody CIModuleDto cimoddtoinput) {

        return new ResponseEntity<>(service.updateCIModule(cimoddtoinput,id), HttpStatus.OK);
    }


}
