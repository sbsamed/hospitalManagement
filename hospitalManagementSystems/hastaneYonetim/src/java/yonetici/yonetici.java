/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yonetici;

/**
 *
 * @author Samed
 */
public class yonetici {
    private String tcNumber;
    private String name;
    private String surName;
    private String password;

    public yonetici() {
    }

    public yonetici(String tcNumber, String name, String surName, String password) {
        this.tcNumber = tcNumber;
        this.name = name;
        this.surName = surName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
          
    
}
