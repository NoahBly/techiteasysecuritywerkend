package com.example.demo.Dto;

import com.example.demo.Model.RemoteController;
import com.example.demo.Model.Television;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class RemoteControllerInputDto {

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

    public static RemoteController toRemoteController(RemoteControllerDto dto) {
        RemoteController remote = new RemoteController();
        remote.setCompatibleWith(dto.compatibleWith);
        remote.setBatteryType(dto.batteryType);
        remote.setName(dto.name);
        remote.setBrand(dto.brand);
        remote.setPrice(dto.price);
        remote.setOriginalStock(dto.originalStock);

        return remote;
    }
}
