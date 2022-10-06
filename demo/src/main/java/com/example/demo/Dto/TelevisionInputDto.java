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

    public static Television toTelevision(Television television){
        Television tv = new Television();

        tv.setName(television.getName());
       tv.setBrand(television.getBrand());
         tv.setPrice(television.getPrice());
         tv.setAvailableSize(television.getAvailableSize());
       tv.setRefreshRate(television.getRefreshRate());
         tv.setScreenType(tv.getScreenType());
        tv.setScreenQuality(television.getScreenQuality());
        tv.setSmartTv(television.isSmartTv());
      tv.setWifi(television.isWifi());
         tv.setVoiceControl(television.isVoiceControl());
        tv.setHdr(television.isHdr());
        tv.setBluetooth(television.isBluetooth());
         tv.setAmbiLight(television.isAmbiLight());
         tv.setOriginalStock(television.getOriginalStock());
        tv.setSold(television.getSold());

        return tv;
    }
}
