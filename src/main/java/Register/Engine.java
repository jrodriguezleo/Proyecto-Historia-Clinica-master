package Register;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Objects;
import java.util.Scanner;
import java.util.*;

import Users.*;
import Util.RecursiveBinarySearchTree;


import javax.print.Doc;

public class Engine {
    private LinkedList<Patient> patients = new LinkedList<>();
    Set<Doctor> doctors = new TreeSet<>();
    private LinkedList<Admin> admins = new LinkedList<>();
    private LinkedList<EPS> listEps  = new LinkedList<>();
//    private Stack<LinkedList> changes = new Stack<>();
//    private Stack<Patient> ePatients = new Stack<>();
//    private Stack<Doctor> eDoctorPatient = new Stack<>();
//    private Stack<Doctor> eDoctor = new Stack<>();
    private Stack<Person> persona= new Stack();
     private Stack<ArrayList> action= new Stack();

    private TreeMap<Integer, Patient> patientstree = new TreeMap<>();
    private RecursiveBinarySearchTree<Integer> doctorsid = new RecursiveBinarySearchTree<>();
    private RecursiveBinarySearchTree<String> usernames = new RecursiveBinarySearchTree<>();
    private RecursiveBinarySearchTree<String> systemeps = new RecursiveBinarySearchTree<>();

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
    
    public void adUsuario(User usuario,int opcion){
        Scanner scan=new Scanner(System.in);
       switch(opcion){
           case 0 ->{
               System.out.println("Ingrese los datos del nuevo ususario Doctor");
               System.out.println("Ingrese la identificación: ");
               int id=scan.nextInt();
               while(getUser(usuario, id)!=null){
                   System.out.println("Ya hay un usuario con esa id, ingrese otra");
                   id=scan.nextInt();
               }
               scan.nextLine();
               System.out.println("Ingrese el nombre de usuario");
               String userName=scan.nextLine();
               System.out.println("Ingrese la contraseña");
               String password=scan.nextLine();
               System.out.println("Ingrese el nombre");
               String nombre=scan.nextLine();
               System.out.println("Ingrese el apellido");
               String apellido=scan.nextLine();
               System.out.println("Ingrese especialidad");
               String especialidad=scan.nextLine();
               System.out.println("Ingrese el nombre de la EPS");
               String nameEps =scan.nextLine();
               while(verificarNameEps(nameEps)==null){
                   System.out.println("Esa eps no existe en nuestro sistema, ingreselo nuevamente");
               nameEps =scan.nextLine();
               }
               EPS eps=verificarNameEps(nameEps);
               System.out.println("Ingrese la fecha de nacimiento");
               String nacimiento=scan.nextLine();
               System.out.println("Ingrese el genero");
               String genero=scan.nextLine();
               System.out.println("Ingrese la dirección");
               String direccion=scan.nextLine();
               System.out.println("Ingrese el numero de telefono");
               String telefono=scan.nextLine();
               System.out.println("Ingrese su email");
               String email=scan.nextLine();
               Doctor newDoctor= new Doctor(especialidad,eps,id,userName,password,nombre,apellido,nacimiento,genero,direccion,telefono,email);
               doctors.add(newDoctor);
               System.out.println("El doctor fue añadido con exito");
           }case 1 ->{
               
               System.out.println("Ingrese los datos del nuevo ususario Paciente");
               System.out.println("Ingrese la identificación: ");
               int id=scan.nextInt();
               while(getUser(usuario, id)!=null){
                   System.out.println("Ya hay un usuario con esa id");
                       
                   
                   id=scan.nextInt();
               }
               scan.nextLine();
               System.out.println("Ingrese el nombre de usuario");
               String userName=scan.nextLine();
               System.out.println("Ingrese la contraseña");
               String password=scan.nextLine();
               System.out.println("Ingrese el nombre");
               String nombre=scan.nextLine();
               System.out.println("Ingrese el apellido");
               String apellido=scan.nextLine();
               System.out.println("Ingrese el nombre de la EPS");
               String nameEps =scan.nextLine();
               while(verificarNameEps(nameEps)==null){
                   System.out.println("Esa eps no existe en nuestro sistema, ingreselo nuevamente");
               nameEps =scan.nextLine();
               }
               EPS eps=verificarNameEps(nameEps);
               System.out.println("Ingrese la fecha de nacimiento");
               String nacimiento=scan.nextLine();
               System.out.println("Ingrese el genero");
               String genero=scan.nextLine();
               System.out.println("Ingrese la dirección");
               String direccion=scan.nextLine();
               System.out.println("Ingrese el numero de telefono");
               String telefono=scan.nextLine();
               System.out.println("Ingrese su email");
               String email=scan.nextLine();
               Patient newPatient= new Patient(id,userName,password,nombre,apellido,nacimiento,genero,direccion,telefono,email,eps);
               patients.add(newPatient);
               if (usuario instanceof Doctor){ 
                ((Doctor)usuario).addPatient(newPatient);
           }
               System.out.println("El paciente fue añadido con exito");
               
           }
       
       }
       
    }
    
    
    public EPS verificarNameEps(String nombre){
        for(EPS eps:listEps){
            if(eps.getName().equals(nombre)) return eps;
            
            
        }
        return null;
    }
    
    public void editUsuario(User user,int id){
        Scanner scan=new Scanner(System.in);
        User userEdit=getUser(user,id);
        if (userEdit==null){
            System.out.println("No existe ningún usuario con ese numero de identificación");
            return;
        }
        else if(userEdit instanceof Doctor){
            System.out.println("Ingrese los nuevos datos del doctor:");
            System.out.println("Id: "+userEdit.getId());
            System.out.println("Ingrese especialidad");
            ((Doctor) userEdit).setSpecialization(scan.nextLine());
            System.out.println("Ingrese Nombre de Usuario");
            ((Doctor) userEdit).setUserName(scan.nextLine());
            System.out.println("Ingrese contraseña");
            ((Doctor) userEdit).setPassword(scan.nextLine());
            System.out.println("Ingrese nombre");
            ((Doctor) userEdit).setName(scan.nextLine());
            System.out.println("Ingrese apellido");
            ((Doctor) userEdit).setLastName(scan.nextLine());
            System.out.println("Ingrese FechaNacimiento");
            ((Doctor) userEdit).setBirthdate(scan.nextLine());
            System.out.println("Ingrese genero");
            ((Doctor) userEdit).setGender(scan.nextLine());
            System.out.println("Ingrese direccion");
            ((Doctor) userEdit).setAddress(scan.nextLine());
            System.out.println("Ingrese email");
            ((Doctor) userEdit).setEmail(scan.nextLine());
            System.out.println("Ingrese telefono");
            ((Doctor) userEdit).setPhone(scan.nextLine());
            
            
        }
        else if(userEdit instanceof Patient){
            System.out.println("Ingrese los nuevos datos del paciente:");
            System.out.println("Id: "+userEdit.getId());
            System.out.println("Ingrese Nombre de Usuario");
            ((Patient) userEdit).setUserName(scan.nextLine());
            System.out.println("Ingrese contraseña");
            ((Patient) userEdit).setPassword(scan.nextLine());
            System.out.println("Ingrese nombre");
            ((Patient) userEdit).setName(scan.nextLine());
            System.out.println("Ingrese apellido");
            ((Patient) userEdit).setLastName(scan.nextLine());
            System.out.println("Ingrese FechaNacimiento");
            ((Patient) userEdit).setBirthdate(scan.nextLine());
            System.out.println("Ingrese genero");
            ((Patient) userEdit).setGender(scan.nextLine());
            System.out.println("Ingrese direccion");
            ((Patient) userEdit).setAddress(scan.nextLine());
            System.out.println("Ingrese email");
            ((Patient) userEdit).setEmail(scan.nextLine());
            System.out.println("Ingrese telefono");
            ((Patient) userEdit).setPhone(scan.nextLine());
        }
        System.out.println("El usuario con el numero de identificacion "+id+" fue modificado satisfactoriamente");
        
    }
    public void addPaciente(User usuario, int id){
        for(Patient paciente: ((Doctor)usuario).getPatients()){
            if (paciente.getId()==id){
                System.out.println("Ud ya tiene un paciente con ese numero de identificacion");    
                return;
            }
        }
       for (Patient paciente : patients) {
                if (paciente.getId() == id) {
                    ((Doctor)usuario).addPatient(paciente);
                    System.out.println("Paciente añadido con exito");
                    return ;
                }
            }
        System.out.println("EL paciente no se encuentra registrado");
            
    }
    
    
    
    
    public void addRegistroMedico(User usuario,int id){
        if(usuario instanceof Doctor ){
            Patient paciente = (Patient)(getUser(usuario,id));
            if (paciente==null) {
                System.out.println("Ud no tiene ningun paciente con ese numero de identificacion");
                return;}
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
                
                return null;
            } else{
            for(Patient patient:((Doctor)user).getPatients()){
                if (patient.getId() == id){
                    return patient;
                }
              
            } 
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
        
        return null;
                   
    }
        
    }
   
    public void removeUser(User user,int id) {
        User userRemove=getUser(user, id);
        ArrayList<Integer> info = new ArrayList<>();

        if (userRemove==null){
        return;}
        info.add(3); //La acción 3 quiere decir editar

        if(userRemove instanceof Patient){
            this.patients.remove((Patient)userRemove);
            int numDoc=0;
            for(Doctor doctor:doctors){
                if(doctor.getPatients().contains((Patient)userRemove)){
                    numDoc+=1;
                    this.persona.add(doctor);
                }
                doctor.getPatients().remove((Patient)userRemove);
                    
                
            }
            this.persona.add((Person)userRemove);
            info.add(numDoc);
            this.action.add(info);
            
//            if (info.size() != 0){
//                changes.add(info);
//            }
            System.out.println("El paciente con id " + id + " fue eliminado.");


            return;
        }
        if(userRemove instanceof Doctor){
            persona.add((Person)userRemove);
            doctors.remove((Doctor)userRemove);
//            if (info.size() != 0){
//                changes.add(info);
//            }
            System.out.println("El doctor con id " + id + " fue eliminado.");
            return;
        }

}
    private void initialData(){
        EPS epsHolder = new EPS("SaludPublica","Calle 1 Carrera 2 #10", "3000000000");
        listEps.add(epsHolder);
        admins.add(new Admin(0,"admin0","admin01234","Developer 0",012345, epsHolder));
        admins.add(new Admin(1,"admin1","admin12345","Developer 1",123456, epsHolder));
        admins.add(new Admin(2,"admin2","admin23456","Developer 2",234567, epsHolder));

        Patient patient0 = new Patient(0,"patient0","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com",epsHolder);
        Patient patient1 = new Patient(1,"patient1","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com",epsHolder);
        Patient patient2 = new Patient(2,"patient2","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com",epsHolder);
        Patient patient3 = new Patient(3,"patient3","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com",epsHolder);
        Patient patient4 = new Patient(4,"patient4","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com",epsHolder);
        patients.add(patient0);
        patients.add(patient1);
        patients.add(patient2);
        patients.add(patient3);
        patients.add(patient4);


        doctors.add(new Doctor("Internista",epsHolder,100,"doc0","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com"));
        Doctor doc1=new Doctor("Pediatra",epsHolder,101,"doc1","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com");
        doctors.add(doc1);
        LinkedList<Patient> pacientesDoc1=doc1.getPatients();
        pacientesDoc1.add(patient1);
        doc1.setPatients(pacientesDoc1);
        
        doctors.add(new Doctor("Neurologo",epsHolder,102,"doc2","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com"));

        doctorsid.insert(100);
        doctorsid.insert(101);
        usernames.insert("admin0");
        usernames.insert("admin1");
        usernames.insert("admin2");
        usernames.insert("patient0");
        usernames.insert("patient1");
        usernames.insert("patient2");
        usernames.insert("patient3");
        usernames.insert("patient4");
        usernames.insert("doc0");
        usernames.insert("doc1");
        usernames.insert("doc2");
        listEps.add(new EPS("Saname","Calle 2 Carrera 12 #20", "3100000000"));
        systemeps.insert("SaludPublica");
        systemeps.insert("Saname");

        patientstree.put(patient0.getId(), patient0);
        patientstree.put(patient1.getId(), patient1);
        patientstree.put(patient2.getId(), patient2);
        patientstree.put(patient3.getId(), patient3);
        patientstree.put(patient4.getId(), patient4);


    }


    public void cancel(){//        if (this.changes.size()!=0){
//            LinkedList<Object> info2 = this.changes.pop();
//            if(info2.contains("patient")){
//                Patient patient = ePatients.pop();
//                patients.add(patient);
//                if(eDoctorPatient.size()!=0){
//                   for(Doctor doctor:doctors){
//                       if(doctor.equals(eDoctorPatient.pop())){
//                           doctor.addPatient(patient);
//                       }
//                   }
//                }
//
//            }
//            if (info2.contains("doctor")){
//                doctors.add(eDoctor.pop());
//            }
//        } else {
//            System.out.println("No ha realizado ningún cambio");
//        }
        if (this.action.size() !=0) {
            int action = (int)this.action.pop().get(0);
            Person persona= this.persona.pop();
            if(action  == 3){
                
                
                if(persona instanceof Patient){
                    Patient paciente=(Patient) persona;
                    this.patients.add(paciente);
                    int countDoc=(int)this.action.pop().get(1);
                    for(int i=0;i<countDoc;i++){
                        ((Doctor)this.persona.pop()).addPatient(paciente);
                    }
                }
                else if (persona instanceof Doctor){
                    Doctor doctor=(Doctor) persona;
                    this.doctors.add(doctor);
                    
                }
                System.out.println("El usuario con el id "+ persona.getId()+"Volvió a ser agregado al sistema");
            }
        } else {
            System.out.println("No se ha realizado ningun cambio");
        }

    }
    public void testAddEps(EPS eps){
        testAddEps(listEps,eps);
    }

    public boolean testSearchEpsLL(String name){
        return testSearchEps(listEps, name);
    }

    public boolean testSearchEpsBT(String name){
        return testExistingUName(systemeps, name);
    }

    public boolean testExistingUsername(String name){
        return testExistingUName(usernames, name);
    }

    public boolean testExistingDoctorID(int id){
        return testExistingID(doctorsid, id);
    }

    public void testAddPatient(Patient patient){
        testAddPatient(patientstree,patient);
    }

    public boolean testSearchPatient(Integer i){
        boolean b = testSearchPatient(patientstree,i);
        if(b == true){System.out.println("El paciente con ID" + i + " se encuentra en el sistema.");}
        else{System.out.println("El paciente con ID" + i + " no se encuentra en el sistema.");}
        return b;
    }
    public void testAddEps(LinkedList<EPS> listEps,EPS eps){
        listEps.add(eps);
    }

    public boolean testSearchEps(LinkedList<EPS> listEps, String name){
        for(EPS eps : listEps){
            if(eps.getName().equals(name)){
                System.out.println("La EPS " + name + " se encuentra en el sistema.");
                return true;
            }
        }
        System.out.println("La EPS " + name + " no se encuentra en el sistema.");
        return false;
    }

    public boolean testExistingUName(RecursiveBinarySearchTree<String> names, String username){
        return names.search(username);
    }

    public boolean testExistingID(RecursiveBinarySearchTree<Integer> ids, int id){
        return ids.search(id);
    }

    public void testAddPatient(TreeMap<Integer,Patient> listP,Patient patient){
        listP.put(patient.getId(),patient);
    }

    public boolean testSearchPatient(TreeMap<Integer,Patient> listP, Integer i){
        return listP.containsKey(i);
    }

}
    
    
    

