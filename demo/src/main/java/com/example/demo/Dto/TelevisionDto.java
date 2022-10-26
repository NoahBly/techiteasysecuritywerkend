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

    public RemoteControllerDto remoteController;

    public static TelevisionDto fromTelevision(Television television){
    TelevisionDto dto = new TelevisionDto();
       dto.type = television.getType();
        dto.name = television.getName();
       dto.brand = television.getBrand();
        dto.price = television.getPrice();
       dto.availableSize = television.getAvailableSize();
        dto.refreshRate = television.getRefreshRate();
      dto.screenType = television.getScreenType();
        dto.screenQuality = television.getScreenQuality();
      dto.smartTv = television.isSmartTv();
       dto.wifi = television.isWifi();
        dto.voiceControl = television.isVoiceControl();
       dto.hdr = television.isHdr();
       dto.bluetooth = television.isBluetooth();
      dto.ambiLight = television.isAmbiLight();
      dto.originalStock = television.getOriginalStock();
       dto.sold = television.getSold();
       if(television.getRemoteController() != null){
           dto.remoteController = RemoteControllerDto.fromRemoteController( television.getRemoteController());
       }
        return dto;
    }
}
