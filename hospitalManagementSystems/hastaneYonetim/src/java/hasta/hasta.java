/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hasta;


public class hasta {
     String tcNumber;
    String name;
    String surName;
    String age;
    String telephone;
    String password;

    public hasta() {
       
    }
    public hasta(String tcNumber, String password) {
        this.tcNumber = tcNumber;
        this.password = password;
    }
       public hasta(String tcNumber, String name, String surName, String age, String telephone, String password) {
        this.tcNumber = tcNumber;
        this.name = name;
        this.surName = surName;
        this.age = age;
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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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
