package com.example.demo.Service;

import com.example.demo.Dto.CIModuleDto;
import com.example.demo.Model.CIModule;
import com.example.demo.Repository.CIModuleRepository;
import org.springframework.stereotype.Service;

@Service
public class CIModuleService {

    private CIModuleRepository repos;

    public CIModuleService(CIModuleRepository repos) {
        this.repos = repos;
    }

    public long createCIModule(CIModuleDto inputCIModuledto) {
        CIModule newCIModule = new CIModule();

        newCIModule.setName(inputCIModuledto.name);
        newCIModule.setPrice(inputCIModuledto.price);
        newCIModule.setType(inputCIModuledto.type);

        CIModule savedCIModule = repos.save(newCIModule);

        return savedCIModule.getId();
    }

    public CIModule getCIModulebyId(long id){
        return repos.findById(id).get();
    }

    public Iterable<CIModule> findAllCIModules(){
        return repos.findAll();
    }

    public void deleteCIModulebyId(long id){
        repos.deleteById(id);
    }

    public CIModule updateCIModule(CIModuleDto inputCIModuleDto, long id){
        CIModule newCIModule = getCIModulebyId(id);

        if(!newCIModule.getName().equals(inputCIModuleDto.name)){
            newCIModule.setName(inputCIModuleDto.name);
        }if(newCIModule.getPrice() != inputCIModuleDto.price) {
            newCIModule.setPrice(inputCIModuleDto.price);
        }if(!newCIModule.getType().equals(inputCIModuleDto.type)) {
            newCIModule.setPrice(inputCIModuleDto.price);
        } return newCIModule;
    }
}
