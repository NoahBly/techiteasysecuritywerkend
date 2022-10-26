package com.example.demo.Dto;

import com.example.demo.Model.RemoteController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class RemoteControllerDto {

    @NotBlank
    public long id;
    @NotBlank
    public String compatibleWith;
    @NotBlank
    public String batteryType;
    @NotBlank
    public String name;
    @NotBlank
    public String brand;
    @NotBlank
    public double price;
    @NotEmpty
    public int originalStock;

    public static RemoteControllerDto fromRemoteController(RemoteController remotes) {
        RemoteControllerDto remote = new RemoteControllerDto();
        remote.compatibleWith = remotes.getCompatibleWith();
        remote.batteryType = remotes.getBatteryType();
        remote.name = remotes.getName();
        remote.brand = remotes.getBrand();
        remote.price = remotes.getPrice();
        remote.originalStock = remotes.getOriginalStock();

        return remote;
    }


}
