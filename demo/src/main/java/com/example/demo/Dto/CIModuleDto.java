package com.example.demo.Dto;

import javax.validation.constraints.NotBlank;

public class CIModuleDto {
    @NotBlank
    public long id;
    @NotBlank
    public String name;
    @NotBlank
    public String type;
    @NotBlank
    public double price;
}
