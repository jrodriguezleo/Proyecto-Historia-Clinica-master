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
    private List<NotaClinica> notasClinicas;
    public RegistroMedico(String diagnostico, String tratamiento, String observaciones, Doctor medico){
        Date date=new Date();
        SimpleDateFormat formateo= new SimpleDateFormat("dd/MM/yy");
        this.fechaCreacion=formateo.format(date);
        this.medicoTratante=medico;
        this.diagnostico=diagnostico;
        this.tratamiento=tratamiento;
        this.observaciones=observaciones;
        this.notasClinicas=new LinkedList<NotaClinica>();
        this.id=(int)Math.floor(Math.random()*(1000+1));
        
        
    }
}
