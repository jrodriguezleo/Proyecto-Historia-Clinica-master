/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Register;
import Users.Doctor;

import java.util.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author st_va
 */
public class RegistroMedico {
    private int id;
    private String fechaCreacion;
    private String diagnostico;
    private String tratamiento;
    private String observaciones;
    private Doctor medicoTratante;
    private String especialidad;
    private List<NotaClinica> notasClinicas;

    public RegistroMedico(String diagnostico, String tratamiento, String observaciones, Doctor medico){
        Date date=new Date();
        SimpleDateFormat formateo= new SimpleDateFormat("dd/MM/yy");
        this.fechaCreacion=formateo.format(date);
        this.medicoTratante=medico;
        this.diagnostico=diagnostico;
        this.tratamiento=tratamiento;
        this.observaciones=observaciones;
        this.especialidad = medicoTratante.getSpecialization();
        this.notasClinicas=new LinkedList<NotaClinica>();
        this.id=(int)Math.floor(Math.random()*(1000+1));   
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Doctor getMedicoTratante() {
        return medicoTratante;
    }

    public void setMedicoTratante(Doctor medicoTratante) {
        this.medicoTratante = medicoTratante;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }

    public List<NotaClinica> getNotasClinicas() {
        return notasClinicas;
    }

    public void setNotasClinicas(List<NotaClinica> notasClinicas) {
        this.notasClinicas = notasClinicas;
    }
    
}
