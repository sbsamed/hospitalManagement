/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randevu;

public class randevu {
   private  String tcNumber;
   private   String name;
  private   String date;
  private  String department;
 

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public randevu() {
   
    }
   public randevu(String date, String department) {
        this.date = date;
        this.department = department;
    }
    public randevu(String tcNumber, String name, String date, String department) {
        this.tcNumber = tcNumber;
        this.name = name;
        this.date = date;
        this.department = department;
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

   

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

   
}
