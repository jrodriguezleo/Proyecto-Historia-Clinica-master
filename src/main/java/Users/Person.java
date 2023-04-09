package Users;
public abstract class Person extends User{
    protected String name;
    protected String lastName;
    protected String birthdate;
    protected String gender;
    protected String address;
    protected String phone;
    protected String email;

    public Person(int id, String userName, String password, String name, String lastName,
                  String birthdate, String gender, String address, String phone, String email) {
        //initiate for User info
        super(id,userName, password);
        //initiate for Person info
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
@Override
    public String toString() {
    return "Nombre: " + name + "\n" +
           "Apellido: " + lastName + "\n" +
           "Fecha de nacimiento: " + birthdate + "\n" +
           "Género: " + gender + "\n" +
           "Dirección: " + address + "\n" +
           "Teléfono: " + phone + "\n" +
           "Email: " + email;
}


}
