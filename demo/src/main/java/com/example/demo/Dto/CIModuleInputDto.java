package com.example.demo.Dto;

import javax.validation.constraints.NotBlank;

public class CIModuleInputDto {

    @NotBlank
    public long id;
    @NotBlank
    public String name;
    @NotBlank
    public String type;
    @NotBlank
    public double price;
}
