package Register;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import Users.*;
import Register.*;

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
    public void addRegistroMedico(Doctor usuario,int id){
        if(usuario instanceof Doctor){
            Patient paciente = this.getUser(usuario,id);
            List<RegistroMedico> historiaClinica=paciente.getHistoriasClinica();
            System.out.println("Ingrese el diagnostico del paciente: ");
            Scanner s= new Scanner(java.lang.System.in);
            String diagnostico=s.nextLine();
            System.out.println("Ingrese el tratamiento a seguir: ");
            String tratamiento=s.nextLine();
            System.out.println("Ingrese oberservaciones adicionales: ");
            String observaciones=s.nextLine();
            try{
                RegistroMedico registro=new RegistroMedico(diagnostico,tratamiento,observaciones,usuario);
                historiaClinica.add(registro);
                paciente.setHistoriasClinica(historiaClinica);
            }
            catch(Exception e){
                java.lang.System.out.println("Error al actaulizar resgstro");
            }
        }
        else java.lang.System.out.println("esto no debia pasar onooooo");

    }
    public Patient getUser(User user, int id){
        if(user instanceof Patient){
            return null;
        }
        int index = patients.indexOf(id);//Se usará el id para instanciar el objeto paciente cada vez que se cree uno nuevo
        if (index==-1) return null;
        Patient patient = patients.get(index);

        return patient;
    }
    public Object getUser(int id){
        int index = patients.indexOf(id);
        if (index==-1){
            index = doctors.indexOf(id);
            if(index==-1){
                index = admins.indexOf(id);
                if(index==-1){
                    return null;
                } else {
                    Admin user = admins.get(index);
                    return user;
                }
            } else {
                Doctor user = doctors.get(index);
                return user;
            }
        } else {
            Patient user = patients.get(index);
            return user;
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
        doctors.add(new Doctor("Pediatra",epsHolder,1,"doc0","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com"));
        doctors.add(new Doctor("Neurologo",epsHolder,2,"doc0","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com"));

    }

}
    
    

