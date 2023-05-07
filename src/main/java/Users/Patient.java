package Users;
import Register.RegistroMedico;
import Register.EPS;
import java.util.*;
public class Patient extends Person {
    private List<RegistroMedico> historiaClinica;
    private EPS eps;

    public Patient(int id, String userName, String password, String name, String lastName, String birthdate, String gender, String address, String phone, String email,EPS eps) {
        //initiate for User and Person info
        super(id, userName, password, name, lastName, birthdate, gender, address, phone, email);
        //initiate for Patient info
        this.historiaClinica = new LinkedList<>();
        this.eps = eps;
    }

    public List<RegistroMedico> getHistoriasClinica() {
        return historiaClinica;
    }

    public void setHistoriasClinica(List<RegistroMedico> historiasClinica) {
        this.historiaClinica = historiasClinica;
    }

    public EPS getEps() {
        return eps;
    }

    public void setEps(EPS eps) {
        this.eps = eps;
    }
     @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Paciente: ").append(super.toString()).append("\n");
    sb.append("EPS: ").append(eps.getName()).append("\n");
    sb.append("Historia clínica:\n");
    sb.append(toStringHistoClinica());
    return sb.toString();
}
public String toStringHistoClinica(){
    if(!historiaClinica.isEmpty()){
    StringBuilder sb=new StringBuilder();
    sb.append("Historia clínica:\n");
    for (RegistroMedico registro : historiaClinica) {
        sb.append("- ").append(registro.getDiagnostico()).append(", ").append(registro.getTratamiento())
                .append(", ").append(registro.getObservaciones()).append(", ")
                .append(registro.getFechaCreacion()).append(", ")
                .append(registro.getMedicoTratante().getName()).append("\n");
    }
    return sb.toString();
    } else return "EL paciente no tiene historia clínica";
    
    
}


    
    
}
