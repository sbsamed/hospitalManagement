/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yonetici;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class dbYoneticiKontrol {
   
    Connection con ;
   public static String yoneticiTc;
    public static String yoneticiAdSoyad;
    
  
    public dbYoneticiKontrol() {
    }

    public dbYoneticiKontrol(Connection con) {
        this.con = con;
    }
    
     public yonetici login(String tc,String soyad, String parola){
        yonetici user=null;
        
        try{
            String query ="select *from hastane.yonetici where (TcNo=? and Soyad=? and Parola=?);";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, tc);
            pst.setString(2, soyad);
            pst.setString(3, parola);
            
            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                
               user = new yonetici();
                user.setTcNumber(rs.getString("TcNo"));
                 user.setName(rs.getString("Ad"));
                  user.setSurName(rs.getString("Soyad"));
                    user.setPassword(rs.getString("Parola"));
                    yoneticiTc=tc;
                    yoneticiAdSoyad=user.getName()+" "+user.getSurName();
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
    
}
