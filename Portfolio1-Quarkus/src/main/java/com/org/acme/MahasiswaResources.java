package com.org.acme;


import com.org.acme.models.Mahasiswa;
import com.org.acme.models.MataKuliah;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.common.Sort;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;
import java.util.Set;

@Path("/mahasiswa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MahasiswaResources extends PanacheEntityBase {

    /** Validator untuk membuat validasi pada setiap method  **/
    @Inject
    Validator validator;

    /** Mendapatkan seluruh data yang ada  **/
    @GET
    @Path("/inquiry")
    public Notif inquiry() {
        List<Mahasiswa> inquiry = Mahasiswa.listAll(Sort.ascending("id"));
        if (inquiry.isEmpty()) {
            return new Notif(false, Code.FAIL_CODE, Code.FAILED, "data not found");
        } else {
            return new Notif(true, Code.SUCCESS_CODE, Code.SUCCESS, inquiry);
        }
    }


    /** Method untuk hanya mengambil data tertentu based on nim mahasiswa  **/
    @GET
    @Path("/entity/{idInput}")
    public Notif entity(@PathParam("idInput") Long idInput) {
        Mahasiswa search = Mahasiswa.findById(idInput);
        if (search == null) {
            return new Notif(false, Code.FAIL_CODE, Code.FAILED, "data not found");
        } else {
            return new Notif(true, Code.SUCCESS_CODE, Code.SUCCESS, search);
        }
    }


    /** Method untuk memasukkan data oleh user  **/
    @POST
    @Transactional
    @Path("/insert")
    public Notif insert(Mahasiswa mahasiswa) {
        Set<ConstraintViolation<Mahasiswa>> violations = validator.validate(mahasiswa);
        if (violations.isEmpty()) {
            mahasiswa.persist();
            return new Notif(true, Code.SUCCESS_CODE, Code.SUCCESS,mahasiswa);
        } else {
            return new Notif(violations);
        }
    }


    /** Mengubah atrubit pada objek tertentu dengan id bernama NIM Mahasiswa  **/
    @PUT
    @Transactional
    @Path("/update/{idInput}")
    public Notif update(@PathParam("idInput") Long idInput, Mahasiswa msId) {
        Set<ConstraintViolation<Mahasiswa>> violations = validator.validate(msId);
        Mahasiswa editMahasiswa = Mahasiswa.findById(idInput);
        if (editMahasiswa == null) {
            return new Notif(false, Code.FAIL_CODE, Code.FAILED, "data not found");
        } else if (violations.isEmpty()) {
            editMahasiswa.setNamaMs(msId.getNamaMs());
            editMahasiswa.setTglMs(msId.getTglMs());
            editMahasiswa.setGenderMs(msId.getGenderMs());
            editMahasiswa.setAlamatMs(msId.getAlamatMs());
            editMahasiswa.setTlpMs(msId.getTlpMs());
            editMahasiswa.setEmailMs(msId.getEmailMs());
            editMahasiswa.setKelas(msId.getKelas());
            editMahasiswa.setIpSmt(msId.getIpSmt());
            return new Notif(true, Code.SUCCESS_CODE, Code.SUCCESS, editMahasiswa);
        } else {
            return new Notif(violations);
        }
    }


    /** Method untuk menghapus data id tertentu  **/
    @DELETE
    @Path("/delete/{idInput}")
    @Transactional
    public Notif delete(@PathParam("idInput") Long idInput) {
        if (Mahasiswa.deleteById(idInput)){
            return new Notif (true, Code.SUCCESS_CODE, Code.SUCCESS, "delete successfully");
        }
        else {
            return new Notif (false, Code.FAIL_CODE, Code.FAILED, new String());
        }
    }


    /** Memasukkan data mahasiswa untuk mata kuliah **/
    @POST
    @Transactional
    @Path("insertMahasiswaWithMataKuliah/{nimMahasiswa}/mataKuliahs/{idMataKuliah}")
    public Notif insertMahasiswaWithMataKuliah(@PathParam("nimMahasiswa")Long nimMahasiswa,
                                               @PathParam("idMataKuliah") Long idMataKuliah)
    {
        Mahasiswa mahasiswa = Mahasiswa.findById(nimMahasiswa);
        MataKuliah mataKuliah = MataKuliah.findById(idMataKuliah);
        if (mahasiswa == null) {
            return new Notif(false, Code.FAIL_CODE, Code.FAILED, "data not found");
        } else if (mataKuliah == null) {
            return new Notif(false, Code.FAIL_CODE, Code.FAILED, "data not found");
        } else {
            mahasiswa.mataKuliahs.add(mataKuliah);
            mahasiswa.persist();
            return new Notif(true, Code.SUCCESS_CODE, Code.SUCCESS, mahasiswa);
        }
    }
}