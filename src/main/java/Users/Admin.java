package Users;
import Register.EPS;

public class Admin extends User{


    private String name;
    private int nit;
    private EPS eps;
 

    public Admin(int id, String userName, String password, String name, int nit, EPS eps){
        //initiate for User info
        super(id,userName,password);
        //initiate for Admin info
        this.name = name;
        this.nit = nit;
        this.eps = eps;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public EPS getEps() {
        return eps;
    }

    public void setEps(EPS eps) {
        this.eps = eps;
    }

}
