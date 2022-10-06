package com.example.demo.Service;

import com.example.demo.Dto.RemoteControllerDto;
import com.example.demo.Dto.TelevisionDto;
import com.example.demo.Model.RemoteController;
import com.example.demo.Model.Television;
import com.example.demo.Repository.RemoteControllerRepository;
import com.example.demo.Repository.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TelevisionService {

private final TelevisionRepository repos;
private final RemoteControllerRepository repos2;

    public TelevisionService(TelevisionRepository repos, RemoteControllerRepository repos2) {
        this.repos = repos;
        this.repos2 = repos2;
    }



    public long createTelevision(TelevisionDto tvdto) {
    Television newtelevision = new Television();

    newtelevision.setAvailableSize(tvdto.availableSize);
    newtelevision.setAmbiLight(tvdto.ambiLight);
    newtelevision.setBluetooth(tvdto.bluetooth);
    newtelevision.setBrand(tvdto.brand);
    newtelevision.setHdr(tvdto.hdr);
    newtelevision.setName(tvdto.name);
    newtelevision.setPrice(tvdto.price);
    newtelevision.setRefreshRate(tvdto.refreshRate);
    newtelevision.setOriginalStock(tvdto.originalStock);
    newtelevision.setScreenType(tvdto.screenType);
    newtelevision.setScreenQuality(tvdto.screenQuality);
    newtelevision.setSold(tvdto.sold);
    newtelevision.setWifi(tvdto.wifi);
    newtelevision.setVoiceControl(tvdto.voiceControl);
    newtelevision.setSmartTv(tvdto.smartTv);
    newtelevision.setType(tvdto.type);

Television newtelevision2 = repos.save(newtelevision);

return newtelevision2.getId();
    }


    public Television getTelevisionbyID(Long id) {
   //     if(!repos.existsById(id)) {
   //         throw new RecordNotFoundException("ID can not be found");
    //    }else {
            return repos.findById(id).get();
    //    }
    }


    public Iterable<Television> findAllTelevision(){
        return repos.findAll();
    }

    public void deleteByIdTelevision(Long id) {
         repos.deleteById(id);
    }

    public Television updateTelevision(TelevisionDto tvDtoinput, Long id) {
       Television newtv = getTelevisionbyID(id);

        if (!newtv.getBrand().equals(tvDtoinput.brand)) {
            newtv.setBrand(tvDtoinput.brand);
        } if(!newtv.getName().equals(tvDtoinput.name)) {
            newtv.setName(tvDtoinput.name);
        } if (newtv.getAvailableSize() != tvDtoinput.availableSize) {
            newtv.setAvailableSize(tvDtoinput.availableSize);
        }if (newtv.getPrice() != tvDtoinput.price) {
            newtv.setPrice(tvDtoinput.price);
        } if(newtv.getOriginalStock() != tvDtoinput.originalStock) {
            newtv.setOriginalStock(tvDtoinput.originalStock);
        } if(newtv.getRefreshRate() != tvDtoinput.refreshRate) {
            newtv.setRefreshRate(tvDtoinput.refreshRate);
        } if(!newtv.getScreenQuality().equals(tvDtoinput.screenQuality)) {
            newtv.setScreenQuality(tvDtoinput.screenQuality);
        } if(!newtv.getScreenType().equals(tvDtoinput.screenType)) {
            newtv.setScreenType(tvDtoinput.screenType);
        } if(newtv.getSold() != tvDtoinput.sold) {
            newtv.setSold(tvDtoinput.sold);
        } if(!newtv.getType().equals(tvDtoinput.type)) {
            newtv.setType(tvDtoinput.type);
        }if (newtv.isAmbiLight()!= tvDtoinput.ambiLight) {
            newtv.setAmbiLight(tvDtoinput.ambiLight);
        } if (newtv.isBluetooth() != tvDtoinput.bluetooth) {
            newtv.setBluetooth(tvDtoinput.bluetooth);
        } if(newtv.isHdr() != tvDtoinput.hdr) {
            newtv.setHdr(tvDtoinput.hdr);
        }if (newtv.isSmartTv() != tvDtoinput.smartTv) {
            newtv.setSmartTv(tvDtoinput.smartTv);
        }if (newtv.isVoiceControl() != tvDtoinput.voiceControl) {
            newtv.setVoiceControl(tvDtoinput.voiceControl);
        }if (newtv.isWifi() != tvDtoinput.wifi)  {
            newtv.setWifi(tvDtoinput.wifi);
        }
        repos.save(newtv);
    return newtv;
    }

    public Television assignRemoteControllertoTelevision( long idtv, long idremote) {
        Television newtelevision = getTelevisionbyID(idtv);
        RemoteController newremotecontroller = repos2.findById(idremote).get();

            newtelevision.setRemoteController(newremotecontroller);
    repos.save(newtelevision);
    return newtelevision;
    }
}
