package Users;
import Register.EPS;
import java.util.*;
public class Doctor extends Person{
    private String specialization;
    private EPS eps;

    private LinkedList<Patient> patients = new LinkedList<>();

    public Doctor(String especialidad, EPS eps, int id, String userName, String password, String nombre, String apellido, String fechaNacimiento, String genero, String direccion, String telefono, String email) {
        super(id, userName, password, nombre, apellido, fechaNacimiento, genero, direccion, telefono, email);
        this.specialization = especialidad;
        this.eps = eps;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public EPS getEps() {
        return eps;
    }

    public void setEps(EPS eps) {
        this.eps = eps;
    }

    public List<Patient> getPatients() {
        return patients;
    }
    public void setPatients(LinkedList<Patient> patients) {
        this.patients = patients;
    }
    public void addPatient(Patient patient) {
        patients.add(patient);
    }
    
    @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Doctor{");
    sb.append(super.toString()); // Llama al toString de la clase Persona
    sb.append(", especialidad='").append(specialization).append('\'');
    sb.append(", eps=").append(eps);
    sb.append(", pacientes=[");
    for (Patient paciente : patients) {
    sb.append(paciente.getId()).append(", ");
}
    sb.append("]");
    sb.append('}');
    return sb.toString();
}
public String toStringListPatients(){
    if(!patients.isEmpty()){
    StringBuilder sb= new StringBuilder();
    for (Patient paciente : patients) {
    sb.append(paciente.getId()).append(", ");
}
    return sb.toString();
            }else {
        return "El doctor no tiene pacientes asignados";
    }
}
    
}
