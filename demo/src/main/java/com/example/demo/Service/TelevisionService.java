package com.example.demo.Service;

import com.example.demo.Dto.RemoteControllerDto;
import com.example.demo.Dto.RemoteControllerInputDto;
import com.example.demo.Dto.TelevisionDto;
import com.example.demo.Dto.TelevisionInputDto;
import com.example.demo.Model.RemoteController;
import com.example.demo.Model.Television;
import com.example.demo.Repository.RemoteControllerRepository;
import com.example.demo.Repository.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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


    public TelevisionDto getTelevisionbyID(Long id) {
   //     if(!repos.existsById(id)) {
   //         throw new RecordNotFoundException("ID can not be found");
    //    }else {
        Television newTv = repos.findById(id).get();
        TelevisionDto newTvDto = TelevisionDto.fromTelevision(newTv);
            return newTvDto;
    //    }
    }


    public Iterable<TelevisionDto> findAllTelevision(){

       Iterable<Television> televisionlist = repos.findAll();
       List<TelevisionDto> televisiondtolist = new ArrayList<>();
    for(Television television : televisionlist) {
      TelevisionDto tvdto = TelevisionDto.fromTelevision(television);
        televisiondtolist.add(tvdto);
    }


       return televisiondtolist;
    }

    public void deleteByIdTelevision(Long id) {
         repos.deleteById(id);
    }

    public TelevisionDto updateTelevision(TelevisionDto tvDtoinput, Long id) {
       TelevisionDto newtvdto = getTelevisionbyID(id);
       Television newtv = TelevisionInputDto.toTelevision(newtvdto);

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
        } if(tvDtoinput.remoteController != null && !newtv.getRemoteController().equals(tvDtoinput.remoteController)) {
            newtv.setRemoteController(RemoteControllerInputDto.toRemoteController((tvDtoinput.remoteController)));
        }


        TelevisionDto newtvdtoend = TelevisionDto.fromTelevision(repos.save(newtv));
    return newtvdtoend;
    }

    public TelevisionDto assignRemoteControllertoTelevision( long idtv, long idremote) {
       Optional<Television> newtelevision = repos.findById(idtv);

        Optional<RemoteController> newremotecontroller =  repos2.findById(idremote);
    if(newtelevision.isPresent() && newremotecontroller.isPresent()) {
        Television televisionnew = newtelevision.get();
        RemoteController remotenew = newremotecontroller.get();

        televisionnew.setRemoteController(remotenew);

        TelevisionDto savedTvdto = TelevisionDto.fromTelevision(repos.save(televisionnew));

        return savedTvdto;
    }else {
        throw new RuntimeException();
    }
    }
}
