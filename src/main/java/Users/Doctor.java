package Users;
import Register.EPS;
import java.util.*;
public class Doctor extends Person{
    private String specialization;
    private EPS eps;

    private LinkedList<Patient> patients = new LinkedList<>();
    private Queue<Patient> patientQueue = new LinkedList<>();

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

    public LinkedList<Patient> getPatients() {
        return patients;
    }
    public void setPatients(LinkedList<Patient> patients) {
        this.patients = patients;
    }
    public void addPatient(Patient patient) {
        patients.add(patient);
    }
    public void addPatientToQueue(Patient patient){
        this.patientQueue.add(patient);
    }
    
    @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Doctor{");
    sb.append(super.toString()); // Llama al toString de la clase Persona
    sb.append(", especialidad='").append(specialization).append('\'');
    sb.append(", eps=").append(eps.getName());
    sb.append(", pacientes=[");
    for (Patient paciente : patients) {
    sb.append(paciente.getId()).append(", ");
}
    sb.append("]");
    sb.append('}');
    return sb.toString();
}
    private String toStringListPatients(){
        if(!patients.isEmpty()){
        StringBuilder sb= new StringBuilder();
        sb.append(", pacientes=[");
        for (Patient paciente : patients) {
        sb.append(paciente.getId()).append(", ");
        sb.append("]");
    }
        return sb.toString();
                }else {
            return "El doctor no tiene pacientes asignados";
        }
    }
    public void printPatientList(){
        System.out.println(toStringListPatients());
    }
    private String toStringPatientsQueue(){
        if(!patientQueue.isEmpty()){
            StringBuilder sb= new StringBuilder();
            int i = 1;
            sb.append(" Cola de pacientes\n");
            for (Patient paciente : patientQueue) {
                sb.append(i).append("° ");
                sb.append(paciente.getId()).append(" ");
                sb.append(paciente.getName()).append(" ");
                sb.append(paciente.getLastName()).append(" ");
            }
            return sb.toString();
        }else {
            return "El doctor no tiene pacientes agendados";
        }
    }
    public void printPatientQueue(){
        System.out.println(toStringPatientsQueue());
    }
    public void schedulePatient(){
        if(patients.isEmpty()){
            System.out.println("El doctor no tiene pacientes asignados");
            return;
        }
        System.out.println("Escoja alguno de los siguientes pacientes para atender");
        printPatientList();
        Scanner scanner = new Scanner(System.in);
        int patientID = scanner.nextInt();
        addPatientToQueue(this.patients.get(patientID));
        scanner.close();
    }

    public void removePatientFromSchedule() {
        if(patientQueue.isEmpty()){
            System.out.println("No hay pacientes en la agenda");
            return;
        }
        Patient patient = this.patientQueue.poll();
        System.out.println("El paciente "+patient.name+" "+patient.lastName+ " fue eliminado de la agenda correctamente");
    }
}
