package com.technicaltest.crud.controller;


import com.technicaltest.crud.models.entities.Barang;
import com.technicaltest.crud.services.BarangServices;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("barang")
public class BarangController {

    @Autowired
    BarangServices barangServices;

    @PostMapping
    @RequestMapping("/insert")
    public Barang insert(@RequestBody Barang barang){
        return barangServices.insert(barang);
    }

    @GetMapping
    @RequestMapping("/inquiry")
    public Iterable<Barang> inquiry(){
        return barangServices.inquiry();
    }

    @GetMapping
    @RequestMapping("/entity/{id}")
    public Barang entity(@PathVariable("id") Long id){
        return barangServices.entity(id);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        barangServices.delete(id);
        return ResponseEntity.ok("Delete Successfully");
    }

    @PutMapping
    @RequestMapping("/update")
    public Barang update(@RequestBody Barang barang){
        return barangServices.insert(barang);
    }
}
