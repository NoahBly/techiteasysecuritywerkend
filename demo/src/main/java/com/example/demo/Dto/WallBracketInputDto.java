package com.example.demo.Dto;

import javax.validation.constraints.NotBlank;

public class WallBracketInputDto {

    @NotBlank
    public long id;
    @NotBlank
    public String size;
    @NotBlank
    public boolean ajustable;
    @NotBlank
    public String name;
    @NotBlank
    public double price;
}
