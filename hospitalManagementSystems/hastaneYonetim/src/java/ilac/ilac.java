
package ilac;


public class ilac {
    private String tcNumber;
     private String name;
    private String deparment;
    private String ilac;

    public ilac() {
    }

    public ilac(String tcNumber, String name) {
        this.tcNumber = tcNumber;
        this.name = name;
    }

    public ilac(String tcNumber, String name, String deparment, String ilac) {
        this.tcNumber = tcNumber;
        this.name = name;
        this.deparment = deparment;
        this.ilac = ilac;
    }

    public String getTcNumber() {
        return tcNumber;
    }

    public void setTcNumber(String tcNumber) {
        this.tcNumber = tcNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeparment() {
        return deparment;
    }

    public void setDeparment(String deparment) {
        this.deparment = deparment;
    }

    public String getIlac() {
        return ilac;
    }

    public void setIlac(String ilac) {
        this.ilac = ilac;
    }
    
    
}
