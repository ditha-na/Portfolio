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
public class Konsumen implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "menuSeqKonsumen",
            sequenceName = "menu_konsumen_seq",
            allocationSize = 1,
            initialValue = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "menuSeqKonsumen")
    @Column(name = "id_konsumen")
    private Long idKonsumen;
    
    @Column(name = "nama_konsumen")
    @NotBlank(message = "nama konsumen tidak boleh kosong")
    private String namaKonsumen;

    @Column(name = "alamat_konsumen")
    @NotBlank(message = "alamat konsumen tidak boleh kosong")
    private String alamatKonsumen;

    @Column(name = "nomor_telepon")
    @NotNull(message = "nomor telepon tidak boleh kosong")
    private Long nomorTelepon;

    @OneToOne
    @JoinColumn(name = "id_penjualan", referencedColumnName = "id_penjualan")
    public Penjualan penjualan;
}
