package com.org.acme;

import com.org.acme.models.Mahasiswa;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.common.Sort;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.org.acme.models.MataKuliah;

import java.util.List;
import java.util.Set;

@Path("/mataKuliah")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MataKuliahResources extends PanacheEntityBase {
    @Inject
    Validator validator;

    /** Method untuk mendapat seluruh data  **/
    @GET
    @Path("/inquiry")
    public Notif inquiry() {
        List<MataKuliah> inquiry = MataKuliah.listAll(Sort.ascending("id"));
        if (inquiry.isEmpty()) {
            return new Notif(false, Code.FAIL_CODE, Code.FAILED, "data not found");
        } else {
            return new Notif(true, Code.SUCCESS_CODE, Code.SUCCESS, inquiry);
        }
    }


     /** Menthod untuk mendapat salah satu data**/
    @GET
    @Path("/entity/{idInput}")
    public Notif entity(@PathParam("idInput") Long idInput) {
        MataKuliah search = MataKuliah.findById(idInput);
        if (search == null) {
            return new Notif(false, Code.FAIL_CODE, Code.FAILED, "data not found");
        } else {
            return new Notif(true, Code.SUCCESS_CODE, Code.SUCCESS, search);
        }
    }


    /** Method untuk memasukkan data oleh user **/
    @POST
    @Transactional
    @Path("/insert")
    public Notif insert(MataKuliah mataKuliah) {
        Set<ConstraintViolation<MataKuliah>> violations = validator.validate(mataKuliah);
        if (violations.isEmpty()) {
            mataKuliah.persist();
            return new Notif(true, Code.SUCCESS_CODE, Code.SUCCESS,mataKuliah);
        } else {
            return new Notif(violations);
        }
    }


    /** Mengubah atrubit pada objek tertentu dengan acuan ID Mata Kuliah **/
    @PUT
    @Transactional
    @Path("/update/{idInput}")
    public Notif update(@PathParam("idInput") Long idInput, MataKuliah mkId) {
        MataKuliah editMataKuliah = MataKuliah.findById(idInput);
        Set<ConstraintViolation<MataKuliah>> violations = validator.validate(mkId);
        if (editMataKuliah == null) {
            return new Notif(false, Code.FAIL_CODE, Code.FAILED, "data not found");
        } 
        else if (violations.isEmpty()) {
            editMataKuliah.setNamaMk(mkId.getNamaMk());
            editMataKuliah.setSks(mkId.getSks());
            editMataKuliah.setKapasitas(mkId.getKapasitas());
            return new Notif(true, Code.SUCCESS_CODE, Code.SUCCESS, editMataKuliah);
        }
        else {
            return new Notif(violations);
        }

    }
    

    /** Menthod untuk menghapus salah satu data  **/
    @DELETE
    @Path("/delete/{idInput}")
    @Transactional
    public Notif delete(@PathParam("idInput") Long idInput) {
        if (MataKuliah.deleteById(idInput)){
            return new Notif (true, Code.SUCCESS_CODE, Code.SUCCESS, "delete successfully");
        }
        else {
            return new Notif (false, Code.FAIL_CODE, Code.FAILED, new String());
        }
    }
}
