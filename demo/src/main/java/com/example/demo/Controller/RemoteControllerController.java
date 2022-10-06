package com.example.demo.Controller;


import com.example.demo.Dto.RemoteControllerDto;
import com.example.demo.Dto.TelevisionDto;
import com.example.demo.Service.RemoteControllerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RemoteControllerController {

    private RemoteControllerService service;

    public RemoteControllerController(RemoteControllerService service) {
        this.service = service;
    }

    @PostMapping("/remotecontrollers")
    public ResponseEntity<Object> createRemoteController(@RequestBody RemoteControllerDto remotecontroldto, BindingResult br) {
        if(br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for(FieldError ferror: br.getFieldErrors()){
                sb.append(ferror.getField() + ":");
                sb.append(ferror.getDefaultMessage());
                sb.append("\n");
            }return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);

        }else {

            long remoteId =  service.createRemoteController(remotecontroldto);

            return new ResponseEntity<>(remoteId, HttpStatus.CREATED);
        }
    }

    @GetMapping("/remotecontrollers/{id}")
    public ResponseEntity<Object> getRemoteController(@Valid @PathVariable long id) {

        return new ResponseEntity<>(service.getRemoteControllerbyID(id), HttpStatus.OK);
    }

    @GetMapping("/remotecontrollers")
    public ResponseEntity<Object> getAllRemoteControllers() {

        return new ResponseEntity<>(service.findallRemoteControllers(), HttpStatus.OK);
    }

    @DeleteMapping("/remotecontrollers/{id}")
    public ResponseEntity <Object> deleteRemoteController(@PathVariable long id) {
        service.deleteRemoteControllerbyId(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/remotecontrollers/{id}")
    public ResponseEntity<Object> updateRemoteController(@PathVariable long id, @RequestBody RemoteControllerDto remotedtoinput) {

        return new ResponseEntity<>(service.updateRemoteController(remotedtoinput,id), HttpStatus.OK);
    }

}
