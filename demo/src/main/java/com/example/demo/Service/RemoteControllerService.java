package com.example.demo.Service;

import com.example.demo.Dto.RemoteControllerDto;
import com.example.demo.Model.RemoteController;
import com.example.demo.Repository.RemoteControllerRepository;
import org.springframework.stereotype.Service;

@Service
public class RemoteControllerService {

    private RemoteControllerRepository repos;

    public RemoteControllerService(RemoteControllerRepository repos) {
        this.repos = repos;
    }

    public long createRemoteController(RemoteControllerDto remotecontroldto) {
        RemoteController newRemoteControl = new RemoteController();

        newRemoteControl.setBrand(remotecontroldto.brand);
        newRemoteControl.setName(remotecontroldto.name);
        newRemoteControl.setPrice(remotecontroldto.price);
        newRemoteControl.setOriginalStock(remotecontroldto.originalStock);
        newRemoteControl.setBatteryType(remotecontroldto.batteryType);
        newRemoteControl.setCompatibleWith(remotecontroldto.compatibleWith);

        RemoteController savedRemote = repos.save(newRemoteControl);

        return savedRemote.getId();
    }

    public RemoteController getRemoteControllerbyID(long id) {
        return repos.findById(id).get();
    }

    public Iterable <RemoteController> findallRemoteControllers() {
        return repos.findAll();
    }

    public void deleteRemoteControllerbyId(long id) {
        repos.deleteById(id);
    }

    public RemoteController updateRemoteController(RemoteControllerDto inputRemoteControlDto, long id) {
        RemoteController newRemoteControl = getRemoteControllerbyID(id);

        if(!newRemoteControl.getBrand().equals(inputRemoteControlDto.brand)){
        newRemoteControl.setBrand(inputRemoteControlDto.brand);
        }if(!newRemoteControl.getName().equals(inputRemoteControlDto.name)){
            newRemoteControl.setName(inputRemoteControlDto.name);
        }if(newRemoteControl.getPrice() != inputRemoteControlDto.price) {
            newRemoteControl.setPrice(inputRemoteControlDto.price);
        }if(newRemoteControl.getOriginalStock() != inputRemoteControlDto.originalStock) {
            newRemoteControl.setOriginalStock(inputRemoteControlDto.originalStock);
        }if(!newRemoteControl.getBatteryType().equals(inputRemoteControlDto.batteryType)) {
            newRemoteControl.setBatteryType(inputRemoteControlDto.batteryType);
        }if(!newRemoteControl.getCompatibleWith().equals(inputRemoteControlDto.compatibleWith)){
            newRemoteControl.setCompatibleWith(inputRemoteControlDto.compatibleWith);
        }repos.save(newRemoteControl);
    return newRemoteControl;
    }
}
