package com.technicaltest.crud.models.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
public class Penjualan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "menuSeqPenjualan",
            sequenceName = "menu_penjualan_seq",
            allocationSize = 1,
            initialValue = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "menuSeqPenjualan")
    @Column(name = "id_penjualan")
    private Long idPenjualan;

    @Column(name = "tanggal_faktur_penjualan")
    @NotNull(message = "tanggal faktur tidak boleh kosong")
    private Date tglFaktur;

    @Column(name = "no_faktur_penjualan")
    @NotBlank(message = "no faktur penjualan tidak boleh kosong")
    private String noFaktur;

    @Column(name = "nama_konsumen")
    @NotBlank(message = "nama konsumen tidak boleh kosong")
    private String namaKonsumen;

    @Column(name = "kode_barang")
    @NotBlank(message = "kode barang tidak boleh kosong")
    private String kodeBarang;

    @Column(name = "jumlah")
    @NotNull(message = "jumlah tidak boleh kosong")
    private Integer jumlah;

    @Column(name = "harga_satuan")
    @NotNull(message = "harga satuan tidak boleh kosong")
    private Long hargaSatuan;

    @Column(name = "harga_total")
    @NotNull(message = "harga total tidak boleh kosong")
    public Long hargaTotal;

    @OneToOne
    @JoinColumn(name = "id_konsumen", referencedColumnName = "id_konsumen")
    public Konsumen konsumen;
}
