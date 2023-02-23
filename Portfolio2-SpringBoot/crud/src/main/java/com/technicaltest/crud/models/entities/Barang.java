package com.technicaltest.crud.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table
@Getter
@Setter
public class Barang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "menuSeqBarang",
            sequenceName = "menu_barang_seq",
            allocationSize = 1,
            initialValue = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "menuSeqBarang")
    @Column(name = "id_barang")
    private Long idBarang;

    @Column(name = "kode_barang")
    @NotBlank(message = "kode barang tidak boleh kosong")
    private String kodeBarang;

    @Column(name = "nama_barang")
    @NotBlank(message = "nama barang tidak boleh kosong")
    private String namaBarang;

    @Column(name = "harga_jual_barang")
    @NotNull(message = "harga jual barang tidak boleh kosong")
    private Long hargaJual;

    @Column(name = "harga_beli_barang")
    @NotNull(message = "harga beli barang tidak boleh kosong")
    private Long hargaBeli;

    @Column(name = "satuan_barang")
    @NotNull(message = "satuan barang tidak boleh kosong")
    private Integer satuan;

    @Column(name = "kategori_barang")
    @NotBlank(message = "kategori barang tidak boleh kosong")
    private String kategoriBarang;

    @ManyToOne
    @JoinColumn(name = "id_penjualan", referencedColumnName = "id_penjualan")
    public Penjualan penjualan;
}
