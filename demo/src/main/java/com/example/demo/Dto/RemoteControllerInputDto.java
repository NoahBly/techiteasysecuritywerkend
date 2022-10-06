package com.example.demo.Dto;

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
}
