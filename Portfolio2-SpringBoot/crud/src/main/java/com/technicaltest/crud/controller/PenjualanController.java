package com.technicaltest.crud.controller;

import com.technicaltest.crud.models.entities.Barang;
import com.technicaltest.crud.models.entities.Konsumen;
import com.technicaltest.crud.models.entities.Penjualan;
import com.technicaltest.crud.services.PenjualanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("penjualan")
public class PenjualanController {

    @Autowired
    PenjualanServices penjualanServices;

    @PostMapping
    @RequestMapping("/insert")
    public Penjualan insert(@RequestBody Penjualan penjualan){
        return penjualanServices.insert(penjualan);
    }

    @GetMapping
    @RequestMapping("/inquiry")
    public Iterable<Penjualan> inquiry(){
        return penjualanServices.inquiry();
    }

    @GetMapping
    @RequestMapping("/entity/{id}")
    public Penjualan entity(@PathVariable("id") Long id){
        return penjualanServices.entity(id);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        penjualanServices.delete(id);
        return ResponseEntity.ok("Delete Successfully");
    }

    @PutMapping
    @RequestMapping("/update")
    public Penjualan update(@RequestBody Penjualan penjualan){
        return penjualanServices.insert(penjualan);
    }
}
