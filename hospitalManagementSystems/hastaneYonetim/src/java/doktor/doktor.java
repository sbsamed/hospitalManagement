
package doktor;
public class doktor{
    
    private String   tcNumber ;
     private String  name ;
    private String   surname;
     private String   deparmant;
     private String   telephone ;
      private String   password  ;

    public doktor() {
    }

    public doktor(String tcNumber, String password) {
        this.tcNumber = tcNumber;
        this.password = password;
    }

    public doktor(String tcNumber, String name, String surname, String deparmant, String telephone, String password) {
        this.tcNumber = tcNumber;
        this.name = name;
        this.surname = surname;
        this.deparmant = deparmant;
        this.telephone = telephone;
        this.password = password;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDeparmant() {
        return deparmant;
    }

    public void setDeparmant(String deparmant) {
        this.deparmant = deparmant;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
      
      
}
