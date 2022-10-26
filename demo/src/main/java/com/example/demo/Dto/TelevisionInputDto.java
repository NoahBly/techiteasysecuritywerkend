package com.example.demo.Dto;

import com.example.demo.Model.Television;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class TelevisionInputDto {


    @NotBlank
    public String type;
    @NotBlank
    public String name;
    @NotBlank
    public String brand;
    @NotBlank
    public double price;
    @NotBlank
    public double availableSize;
    @NotBlank
    public double refreshRate;
    @NotBlank
    public String screenType;
    @NotBlank
    public String screenQuality;
    @NotBlank
    public boolean smartTv;
    @NotBlank
    public boolean wifi;
    @NotBlank
    public boolean voiceControl;
    @NotBlank
    public boolean hdr;
    @NotBlank
    public boolean bluetooth;
    @NotBlank
    public boolean ambiLight;
    @NotEmpty
    public int originalStock;
    @NotEmpty
    public int sold;

    public static Television toTelevision(TelevisionDto dto){
        Television tv = new Television();
        tv.setType(dto.type);
        tv.setName(dto.name);
       tv.setBrand(dto.brand);
         tv.setPrice(dto.price);
         tv.setAvailableSize(dto.availableSize);
       tv.setRefreshRate(dto.refreshRate);
         tv.setScreenType(dto.screenType);
        tv.setScreenQuality(dto.screenQuality);
        tv.setSmartTv(dto.smartTv);
      tv.setWifi(dto.wifi);
         tv.setVoiceControl(dto.voiceControl);
        tv.setHdr(dto.hdr);
        tv.setBluetooth(dto.bluetooth);
         tv.setAmbiLight(dto.ambiLight);
         tv.setOriginalStock(dto.originalStock);
        tv.setSold(dto.sold);
        if(dto.remoteController != null) {
            tv.setRemoteController(RemoteControllerInputDto.toRemoteController(dto.remoteController));
        }
        return tv;
    }
}
