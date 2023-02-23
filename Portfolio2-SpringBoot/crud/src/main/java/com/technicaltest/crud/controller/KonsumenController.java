package com.technicaltest.crud.controller;

import com.technicaltest.crud.models.entities.Barang;
import com.technicaltest.crud.models.entities.Konsumen;
import com.technicaltest.crud.services.KonsumenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("konsumen")
public class KonsumenController {

    @Autowired
    KonsumenServices konsumenServices;

    @PostMapping
    @RequestMapping("/insert")
    public Konsumen insert(@RequestBody Konsumen konsumen){
        return konsumenServices.insert(konsumen);
    }

    @GetMapping
    @RequestMapping("/inquiry")
    public Iterable<Konsumen> inquiry(){
        return konsumenServices.inquiry();
    }

    @GetMapping
    @RequestMapping("/entity/{id}")
    public Konsumen entity(@PathVariable("id") Long id){
        return konsumenServices.entity(id);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        konsumenServices.delete(id);
        return ResponseEntity.ok("Delete Successfully");
    }

    @PutMapping
    @RequestMapping("/update")
    public Konsumen update(@RequestBody Konsumen konsumen){
        return konsumenServices.insert(konsumen);
    }
}
