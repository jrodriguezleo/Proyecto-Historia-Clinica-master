package Register;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Objects;
import java.util.*;
import java.util.HashMap;

import Users.*;
import Util.RecursiveBinarySearchTree;


import javax.swing.JOptionPane;

public class Engine {
    // Patients
    public HashMap<Integer, Patient> patients = new HashMap<>();
    public HashMap<String, Integer> patientsUsernameToId = new HashMap<>();

    public void patientAdd(Patient patient){
        patients.put(patient.getId(), patient);
        patientsUsernameToId.put(patient.getUserName(), patient.getId());
    }

    public void patientRemove(Patient patient){
        patients.remove(patient.getId());
        patientsUsernameToId.remove(patient.getUserName());
    }




    Set<Doctor> doctors = new TreeSet<>();
    

    private LinkedList<Admin> admins = new LinkedList<>();
    private LinkedList<EPS> listEps  = new LinkedList<>();
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
        Patient p = patients.get(patientsUsernameToId.get(userName));
        if (p != null && p.getPassword().equals(password)) {
            return p;
        }

        for (Doctor d: doctors) {
            if(Objects.equals(d.getUserName(), userName) && Objects.equals(d.getPassword(), password)) return d;
        }
        for (Admin a: admins) {
            if(Objects.equals(a.getUserName(), userName) && Objects.equals(a.getPassword(), password)) return a;
        }

        return null;
    }

    public void addNewUser(User newUser) {
        if (newUser instanceof Patient) {
            this.patientAdd((Patient) newUser);
        } else if (newUser instanceof Doctor) {
            // this.do((Doctor) newUser);
            this.doctors.add((Doctor) newUser);
        }
    }
    
    public EPS verificarNameEps(String nombre){
        for(EPS eps:listEps){
            if(eps.getName().equals(nombre)) return eps;
            
            
        }
        return null;
    }

    public String addPaciente(User usuario, int id){
        for(Patient paciente: ((Doctor)usuario).getPatients()){
            if (paciente.getId()==id){
                return "Usted ya tiene a "+paciente.getName()+" "+paciente.getLastName()+" como paciente.";    
                
            }
        }

        Patient paciente = patients.get(id);
        if (paciente!=null) {
            ((Doctor)usuario).addPatient(paciente);
            return "Se añadió a "+paciente.getName()+" "+paciente.getLastName()+" como paciente.";
        }

        return "El paciente no se encuentra registrado";
            
    }

    public void addRegistroMedico(User usuario, int id,RegistroMedico r) {
        if (usuario instanceof Doctor) {
            Patient paciente = (Patient) (getUser(usuario, id));
            if (paciente == null) {
                System.out.println("Ud no tiene ningun paciente con ese numero de identificacion");
                return;
            }
            List<RegistroMedico> historiaClinica = paciente.getHistoriasClinica();
            historiaClinica.add(r);
            paciente.setHistoriasClinica(historiaClinica);
        }
        else System.out.println("no tiene permisos para realizar esta accion");

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

            Patient paciente = patients.get(id);
            if (paciente != null) {
                return paciente;
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
   
    public void removeUser(User user,int id,javax.swing.JRootPane rootPane) {
        User userRemove=getUser(user, id);
        if (userRemove==null){
            //System.out.println("No existe un usuario con ese id");
            JOptionPane.showMessageDialog(rootPane, "No existe un usuario con ese id");
            return;
        }
        ArrayList<Integer> info = new ArrayList<>();

        
        info.add(3); //La acción 3 quiere decir editar

        if(userRemove instanceof Patient){
            // this.patients.remove((Patient)userRemove);

            this.patientRemove((Patient)userRemove);

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
             //System.out.println("El paciente con id " + id + " fue eliminado.");
             JOptionPane.showMessageDialog(rootPane, "El paciente con id " + id + " fue eliminado.");


            return;
        }
        if(userRemove instanceof Doctor){
            persona.add((Person)userRemove);
            doctors.remove((Doctor)userRemove);
//            if (info.size() != 0){
//                changes.add(info);
//            }
            //System.out.println("El doctor con id " + id + " fue eliminado.");
            JOptionPane.showMessageDialog(rootPane, "El doctor con id " + id + " fue eliminado.");
        }

}
    
        public void removeUser(User user,int id) {
        User userRemove=getUser(user, id);
        if (userRemove==null){
            System.out.println("No existe un usuario con ese id");
            
            return;
        }
        ArrayList<Integer> info = new ArrayList<>();

        
        info.add(3); //La acción 3 quiere decir editar

        if(userRemove instanceof Patient){
            // this.patients.remove((Patient)userRemove);

            this.patientRemove((Patient)userRemove);

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
           
        }

}
    
    private void initialData(){
        EPS epsHolder = new EPS("SaludPublica","Calle 1 Carrera 2 #10", "3000000000");
        listEps.add(epsHolder);
        admins.add(new Admin(0,"admin0","admin01234","Developer 0",012345, epsHolder));
        admins.add(new Admin(1,"admin1","admin12345","Developer 1",123456, epsHolder));
        admins.add(new Admin(2,"adm","adm123","Developer 2",234567, epsHolder));

        Patient patient0 = new Patient(0,"p1","p1","Juan", "Perez","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com",epsHolder);
        Patient patient1 = new Patient(1,"patient1","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com",epsHolder);
        Patient patient2 = new Patient(2,"patient2","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com",epsHolder);
        Patient patient3 = new Patient(3,"patient3","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com",epsHolder);
        Patient patient4 = new Patient(4,"patient4","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com",epsHolder);

        patientAdd(patient0);
        patientAdd(patient1);
        patientAdd(patient2);
        patientAdd(patient3);
        patientAdd(patient4);



        doctors.add(new Doctor("Internista",epsHolder,100,"doc0","password123","My Name", "My Last Name","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com"));
        doctors.add(new Doctor("General",epsHolder,102,"doc","doc123","Vicente", "Fernandez","1-1-2000","M","Calle 123","300 123 9900","correo@gmail.com"));
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
        
  


        for (Doctor doctor: doctors) {
            if (doctor.getSpecialization().equals("Internista")) {
                doctor.addPatient(patient0);
                
                for (int i = 0; i < 5; i++) {
                    addRegistroMedico(doctor,patient0.getId(), new RegistroMedico("Dagnostico"+i, "Tratamiento"+i, "Observacion"+i, doctor) );
                }
            }
            if (doctor.getSpecialization().equals("Pediatra")) {
                doctor.addPatient(patient1);
                for (int i = 0; i < 5; i++) {
                    addRegistroMedico(doctor,patient1.getId(), new RegistroMedico("Dagnostico"+i, "Tratamiento"+i, "Observacion"+i, doctor) );
                }
            }
            if (doctor.getSpecialization().equals("Neurologo")) {
                doctor.addPatient(patient2);
                for (int i = 0; i < 5; i++) {
                    addRegistroMedico(doctor,patient2.getId(), new RegistroMedico("Dagnostico"+i, "Tratamiento"+i, "Observacion"+i, doctor) );
                }
            }
        }



    }


    public void cancel(javax.swing.JRootPane rootPane){//        if (this.changes.size()!=0){
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
            ArrayList<Integer> listAction = this.action.pop();
            int action=listAction.get(0);
            Person persona= this.persona.pop();
            if(action  == 3){
                
                
                if(persona instanceof Patient){
                    Patient paciente=(Patient) persona;
                    // this.patients.add(paciente);
                    this.patientAdd(paciente);
                    int countDoc=listAction.get(1);
                    for(int i=0;i<countDoc;i++){
                        ((Doctor)this.persona.pop()).addPatient(paciente);
                    }
                }
                else if (persona instanceof Doctor){
                    Doctor doctor=(Doctor) persona;
                    this.doctors.add(doctor);
                    
                }
                //System.out.println("El usuario con el id "+ persona.getId()+"Volvió a ser agregado al sistema");
                JOptionPane.showMessageDialog(rootPane, "El usuario con el id "+ persona.getId()+" Volvió a ser agregado al sistema");
            }
        } else {
            //System.out.println("No se ha realizado ningun cambio");
            JOptionPane.showMessageDialog(rootPane,"No se ha realizado ningun cambio");
        }

    }
    
    
    public void cancel(){
        if (this.action.size() !=0) {
            ArrayList<Integer> listAction = this.action.pop();
            int action=listAction.get(0);
            Person persona= this.persona.pop();
            if(action  == 3){
                
                
                if(persona instanceof Patient){
                    Patient paciente=(Patient) persona;
                    // this.patients.add(paciente);
                    this.patientAdd(paciente);
                    int countDoc=listAction.get(1);
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
    
    
    
    // public LinkedList<Patient> getPatients() {
    //     return patients;
    // }

    public HashMap<Integer, Patient> getPatients() {
        return patients;
    }


    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    public LinkedList<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(LinkedList<Admin> admins) {
        this.admins = admins;
    }

    public LinkedList<EPS> getListEps() {
        return listEps;
    }

    public void setListEps(LinkedList<EPS> listEps) {
        this.listEps = listEps;
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
    
    
    

