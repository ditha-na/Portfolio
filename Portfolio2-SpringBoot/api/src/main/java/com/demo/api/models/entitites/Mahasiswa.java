package com.demo.api.models.entitites;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "daftar_data_mahasiswa")
@Getter
@Setter
public class Mahasiswa {

    @Id
    @SequenceGenerator(
        name = "menuSeqMs",
        sequenceName = "menu_nimMs_seq",
        allocationSize = 1,
        initialValue = 42022201)
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "menuSeqMs")
    @Column(name = "NIM_Mahasiswa")
    private Long nimMahasiswa;

    @NotBlank(message = "Data Nama Mahasiswa Wajib Diisi")
    private String namaMs;

    @NotNull(message = "Data Tanggal Lahir Mahasiswa Wajib Diisi")
    private Date tglMs;
    
    enum Gender{
        pria, wanita
    }
    
    @Column(name = "gender_mahasiswa")
    @NotBlank(message = "Data Jenis Kelamin Mahasiswa Wajib Diisi")
    private Gender genderMS;

    @Column(name = "alamat_mahasiswa")
    @NotBlank(message = "Data Alamat Mahasiswa Wajib Diisi")
    private String alamatMs;

    @Column(name = "telepon_mahasiswa")
    @NotBlank(message = "Data Telepon Mahasiswa Wajib Diisi")
    private String tlpMs;

    @Column(name = "email_mahasiswa")
    @NotBlank(message = "Data Email Mahasiswa Wajib Sesuai")
    private String emailMs;

    @Column(name = "kelas_mahasiswa")
    @NotBlank(message = "Data Kelas Wajib Diisi")
    private String kelas;

    @Column (name = "IP_semester")
    @NotNull(message = "Data IP Semester Mahasiswa Wajib Diisi")
    private Float ipSmt;
    
}
