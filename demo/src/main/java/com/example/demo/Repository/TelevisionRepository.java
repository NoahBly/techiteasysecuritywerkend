package com.example.demo.Repository;

import com.example.demo.Model.Television;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TelevisionRepository extends CrudRepository<Television, Long> {

 List<Television>findAllByPriceLessThan(Double price);
}
