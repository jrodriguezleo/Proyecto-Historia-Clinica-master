package Register;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import Users.*;


import javax.print.Doc;

public class Engine {
    private LinkedList<Patient> patients = new LinkedList<>();
    private LinkedList<Doctor> doctors = new LinkedList<>();
    private LinkedList<Admin> admins = new LinkedList<>();

    public Engine(){
        initialData();
    }

    public User login(String userName, String password){
        for (Patient p: patients) {
            if(Objects.equals(p.getUserName(), userName) && Objects.equals(p.getPassword(), password)) return p;
        }
        for (Doctor d: doctors) {
            if(Objects.equals(d.getUserName(), userName) && Objects.equals(d.getPassword(), password)) return d;
        }
        for (Admin a: admins) {
            if(Objects.equals(a.getUserName(), userName) && Objects.equals(a.getPassword(), password)) return a;
        }

        return null;
    }
    public void addRegistroMedico(User usuario,int id){
        if(usuario instanceof Doctor ){
            Patient paciente = (Patient)(getUser(usuario,id));
            if (paciente==null) return;
            List<RegistroMedico> historiaClinica=paciente.getHistoriasClinica();
            System.out.println("Ingrese el diagnostico del paciente: ");
            Scanner s= new Scanner(System.in);
            String diagnostico=s.nextLine();
            System.out.println("Ingrese el tratamiento a seguir: ");
            String tratamiento=s.nextLine();
            System.out.println("Ingrese oberservaciones adicionales: ");
            String observaciones=s.nextLine();
            try{
                RegistroMedico registro=new RegistroMedico(diagnostico,tratamiento,observaciones, (Doctor)usuario);
                historiaClinica.add(registro);
                paciente.setHistoriasClinica(historiaClinica);
                
                
            }
            catch(Exception e){
                java.lang.System.out.println("Error al actaulizar resgistro");
            }
        }
        else System.out.println("esto no debia pasar onooooo");

    }
    public User getUser(User user, int id){
        
        if (user instanceof Doctor ){
            if (((Doctor)user).getPatients().isEmpty()){
                System.out.println("En este momento ud no tienen ningún paciente");
                return null;
            } else{
            for(Patient patient:((Doctor)user).getPatients()){
                if (patient.getId() == id){
                    return patient;
                }
              
            } 
            System.out.println("Ud no tiene ningún paciente con ese numero de identificación");
            return null;
            }
                
        }
        else {
            for (Patient paciente : patients) {
                if (paciente.getId() == id) {
                    return paciente;
                }
            }
    // Buscar en la lista de médicos
            for (Doctor medico : doctors) {
                if (medico.getId() == id) {
                    return medico ;
                }
            }
        System.out.println("Error: el usuario con id " + id + " no se encuentra en el sistema.");
        return null;
                   
    }
        
    }
   
    public void removeUser(User user,int id) {
        User userRemove=getUser(user, id);
        if (userRemove==null){
        return;}
        if(userRemove instanceof Patient patient){
            patients.remove(patient);
            for(Doctor doctor:doctors){
                doctor.getPatients().remove(patient);
                    
                
            }
            return;
        }
        if(userRemove instanceof Doctor doctor){
            doctors.remove(doctor);
            return;
        }
}
    private void initialData(){
        EPS epsHolder = new EPS("SaludPublica","Calle 1 Carrera 2 #10", "3000000000");
        admins.add(new Admin(0,"admin0","admin01234","Developer 0",012345, epsHolder));
        admins.add(new Admin(1,"admin1","admin12345","Developer 1",123456, epsHolder));
        admins.add(new Admin(2,"admin2","admin23456","Developer 2",234567, epsHolder));

        patients.add(new Patient(0,"patient0","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com",epsHolder));
        patients.add(new Patient(1,"patient1","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com",epsHolder));
        patients.add(new Patient(2,"patient2","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com",epsHolder));
        patients.add(new Patient(3,"patient3","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com",epsHolder));
        patients.add(new Patient(4,"patient4","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com",epsHolder));

        doctors.add(new Doctor("Internista",epsHolder,0,"doc0","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com"));
        doctors.add(new Doctor("Pediatra",epsHolder,1,"doc1","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com"));
        doctors.add(new Doctor("Neurologo",epsHolder,2,"doc2","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com"));

    }

}
    
    

