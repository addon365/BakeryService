package com.addon.BakeryService.models.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addon.BakeryService.models.UOM;

@RestController
@RequestMapping("/api/uom")
@CrossOrigin(origins = "http://localhost:4200")
public interface UOMRepository extends CrudRepository<UOM, Long> {

}
