package com.org.acme.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "daftar_data_mahasiswa")
public class Mahasiswa extends PanacheEntityBase {

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

    /** Atribut Nama Mahasiswa **/
   @NotBlank(message = "Data Nama Mahasiswa Wajib Diisi")
   private String namaMs;

    /** Atribut Tanggal Lahir Mahasiswa  **/
   @NotNull(message = "Data Tanggal Lahir Mahasiswa Wajib Diisi")
   private Date tglMs;

    /** Atribut Jenis Kelamin Mahasiswa  **/
    enum Gender { pria, wanita }

    @NotNull(message = "Data Jenis Kelamin Mahasiswa Wajib Diisi")
    private Gender genderMs;

   /** Atribut Alamat Mahasiswa  **/
   @NotBlank(message = "Data Alamat Mahasiswa Wajib Diisi")
   private String alamatMs;

    /** Atribut Telepon Mahasiswa  **/
   @NotNull(message = "Data Telepon Mahasiswa Wajib Diisi")
   private String tlpMs;

    /** Atribut Email Mahasiswa  **/
   @Email(message = "Data Email Mahasiswa Wajib Sesuai")
   private String emailMs;

    /** Atribut Kelas Mahasiswa  **/
   @NotNull(message = "Data Kelas Wajib Diisi")
   private String kelas;

    /** Atribut IP Semester Mahasiswa  **/
   @NotNull(message = "Data IP Semester Mahasiswa Wajib Diisi")
   @Column (name = "IP_Semester")
   private Float ipSmt;

   /** Method Getter **/
   @JsonGetter
   public Long getNimMahasiswa() {
        return nimMahasiswa;
    }

    @JsonGetter
    public String getNamaMs() {
        return namaMs;
    }

    @JsonGetter
    public Date getTglMs() {
        return tglMs;
    }

    @JsonGetter
    public Gender getGenderMs() {
        return genderMs;
    }

    @JsonGetter
    public String getAlamatMs() {
        return alamatMs;
    }

    @JsonGetter
    public String getTlpMs() {
        return tlpMs;
    }

    @JsonGetter
    public String getEmailMs() {
        return emailMs;
    }

    @JsonGetter
    public String getKelas() {
        return kelas;
    }

    @JsonGetter
    public Float getIpSmt() {
        return ipSmt;
    }

    /** Method Setter **/
    @JsonIgnore
    public void setNimMahasiswa(Long nimMahasiswa) {
        this.nimMahasiswa = nimMahasiswa;
    }

    @JsonSetter
    public void setNamaMs(String namaMs) {
        this.namaMs = namaMs;
    }

    @JsonSetter
    public void setTglMs(Date tglMs) {
        this.tglMs = tglMs;
    }

    @JsonSetter
    public void setGenderMs(Gender genderMs) {
        this.genderMs = genderMs;
    }

    @JsonSetter
    public void setAlamatMs(String alamatMs) {
        this.alamatMs = alamatMs;
    }

    @JsonSetter
    public void setTlpMs(String tlpMs) {
        this.tlpMs = tlpMs;
    }

    @JsonSetter
    public void setEmailMs(String emailMs) {
        this.emailMs = emailMs;
    }

    @JsonSetter
    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    @JsonSetter
    public void setIpSmt(Float ipSmt) {
        this.ipSmt = ipSmt;
    }

    /** Konstruktor Kelas Mahasiswa  **/
    public Mahasiswa() {}

    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable (
            name = "Mahasiswas_MataKuliah",
            joinColumns = @JoinColumn(name = "NIM_Mahasiswa", referencedColumnName = "NIM_Mahasiswa"),
            inverseJoinColumns = @JoinColumn(name = "Id_Mata_Kuliah", referencedColumnName = "Id_Mata_Kuliah")
    )
    public List<MataKuliah> mataKuliahs;


   /** Pembuatan getter dan setter agar saat hanya memasukkan data mahasiswa website tidak meminta data mata kuliah  **/
   @JsonGetter
   public List<MataKuliah> getMataKuliahs() {
       return mataKuliahs;
   }

   @JsonIgnore
   public void setMataKuliahs(List<MataKuliah> mataKuliahs) {
       this.mataKuliahs = mataKuliahs;
   }

}
