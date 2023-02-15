package com.org.acme.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Daftar_Mata_Kuliah")
public class MataKuliah extends PanacheEntityBase {

    @Id
    @SequenceGenerator(
            name = "menuSeqMk",
            sequenceName = "menu_idMk_seq",
            allocationSize = 1,
            initialValue = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "menuSeqMk")
    @Column(name = "Id_Mata_Kuliah")
    private Long idMataKuliah;

    /** Atribut Nama Mata Kuliah  **/
    @Column(name = "Nama_Mata_Kuliah")
    @NotBlank(message = "Data Nama Mata Kuliah Wajib Diisi")
    private String namaMk;

    /** Atribut SKS  **/
    @NotNull(message = "Banyak SKS Wajib DIisi")
    private Integer sks;

    /** Atribut Kapasitas Kelas **/
    @Column(name = "Kapasitas_Kelas")
    @NotNull(message = "Kapasitas Kelas Wajib DIisi")
    private Integer kapasitas;

    /** Method Getter **/
    @JsonGetter
    public Long getIdMataKuliah() {
        return idMataKuliah;
    }

    @JsonGetter
    public String getNamaMk() {
        return namaMk;
    }

    @JsonGetter
    public Integer getSks() {
        return sks;
    }

    @JsonGetter
    public Integer getKapasitas() {
        return kapasitas;
    }

    /** Method Setter **/
    @JsonIgnore
    public void setIdMataKuliah(Long idMataKuliah) {
        this.idMataKuliah = idMataKuliah;
    }

    @JsonSetter
    public void setNamaMk(String namaMk) {
        this.namaMk = namaMk;
    }

    @JsonSetter
    public void setSks(Integer sks) {
        this.sks = sks;
    }

    @JsonSetter
    public void setKapasitas(Integer kapasitas) {
        this.kapasitas = kapasitas;
    }

    /** Konstruktor Kelas MataKuliah  **/
    public MataKuliah() {
    }
}

