package com.example.demo.Service;

import com.example.demo.Dto.WallBracketDto;
import com.example.demo.Model.WallBracket;
import com.example.demo.Repository.WallBracketRepository;
import org.springframework.stereotype.Service;

@Service
public class WallBracketService {

    private WallBracketRepository repos;

    public WallBracketService(WallBracketRepository repos) {
        this.repos = repos;
    }

    public long createWallBracket(WallBracketDto inputWallBracketDto) {
        WallBracket newWallBracket = new WallBracket();

        newWallBracket.setName(inputWallBracketDto.name);
        newWallBracket.setPrice(inputWallBracketDto.price);
        newWallBracket.setAjustable(inputWallBracketDto.ajustable);
        newWallBracket.setSize(inputWallBracketDto.size);

        WallBracket savedWallBracket = repos.save(newWallBracket);

        return savedWallBracket.getId();
    }

    public WallBracket getWallBracketbyId(long id) {
        return repos.findById(id).get();
    }

    public Iterable<WallBracket> findAllWallBrackets(){
        return repos.findAll();
    }

    public void deleteWallBracketbyId(long id) {
        repos.deleteById(id);
    }

    public WallBracket updateWallBracket(WallBracketDto inputWallBracketDto, long id) {
        WallBracket newWallBracket = new WallBracket();

        if(!newWallBracket.getName().equals(inputWallBracketDto.name)) {
            newWallBracket.setName(inputWallBracketDto.name);
        } if(newWallBracket.getPrice() != inputWallBracketDto.price) {
            newWallBracket.setPrice(inputWallBracketDto.price);
        } if (!newWallBracket.getSize().equals(inputWallBracketDto.size)) {
            newWallBracket.setSize(inputWallBracketDto.size);
        } if(newWallBracket.isAjustable() != inputWallBracketDto.ajustable) {
            newWallBracket.setAjustable(inputWallBracketDto.ajustable);
        } return newWallBracket;
    }

}
