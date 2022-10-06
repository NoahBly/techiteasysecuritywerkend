package com.example.demo.Dto;

import com.example.demo.Model.Television;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class TelevisionDto {

private long id;

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

    public RemoteControllerDto remoteControllerDto;

    public static TelevisionDto fromTelevision(Television television){
    TelevisionDto dto = new TelevisionDto();
    Television tv = new Television();
       dto.type = tv.getType();

        dto.name = tv.getName();
       dto.brand = tv.getBrand();
        dto.price = tv.getPrice();
       dto.availableSize = tv.getAvailableSize();
        dto.refreshRate = tv.getRefreshRate();
      dto.screenType = tv.getScreenType();
        dto.screenQuality = tv.getScreenQuality();
      dto.smartTv = tv.isSmartTv();
       dto.wifi = tv.isWifi();
        dto.voiceControl = tv.isVoiceControl();
       dto.hdr = tv.isHdr();
       dto.bluetooth = tv.isBluetooth();
      dto.ambiLight = tv.isAmbiLight();
      dto.originalStock = tv.getOriginalStock();
       dto.sold = tv.getSold();


        return dto;
    }
}
