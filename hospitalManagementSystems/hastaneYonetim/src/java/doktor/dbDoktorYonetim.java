
package doktor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class dbDoktorYonetim {
     Connection con ;
     public static String doktorBolum;

    public dbDoktorYonetim(Connection con) {
        this.con = con;
    }

    public dbDoktorYonetim() {
     
    }
    
    public boolean doktorKayit (doktor doktor){
        boolean set = false;
        try{
           
   String query = "insert into doktor(TcNo,Ad,Soyad,Bölüm,Telefon,Parola) values(?,?,?,?,?,?);";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, doktor.getTcNumber());
           pt.setString(2, doktor.getName());
           pt.setString(3, doktor.getSurname());
           pt.setString(4, doktor.getDeparmant());
           pt.setString(5, doktor.getTelephone());
           pt.setString(6, doktor.getPassword());
           
           pt.executeUpdate();
            System.out.println("Doktor Kaydı Eklendi");
           set = true;
        }catch(Exception e){
            System.out.println("Doktor Kayd Eklenemedi");
            e.printStackTrace();
        }
        return set;
    }
    
    public doktor login(String tc, String password){
        doktor user=null;
        try{
            String query ="select *from doktor where TcNo=? and Parola=?;";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, tc);
            pst.setString(2, password);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                user = new doktor();
                user.setTcNumber(rs.getString("TcNo"));
                user.setName(rs.getString("Ad"));
                user.setSurname(rs.getString("Soyad"));
                 user.setDeparmant(rs.getString("Bölüm"));
                 user.setTelephone(rs.getString("Telefon"));
                 user.setPassword(rs.getString("Parola"));
                 doktorBolum=user.getDeparmant();
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
    
  public List<doktor> doktorGetirYonetici(){
       
        List<doktor> doktorlar = new ArrayList<>();
        
        try{
            String query = "select *from hastane.doktor ;";
            PreparedStatement pt = this.con.prepareStatement(query);
            ResultSet rs = pt.executeQuery();
           
            while(rs.next()){
                 doktor row = new doktor();
                row.setTcNumber(rs.getString("TcNo"));
                row.setName(rs.getString("Ad"));
                row.setSurname(rs.getString("Soyad")); 
                row.setDeparmant(rs.getString("Bölüm"));
                row.setTelephone(rs.getString("Telefon"));
                doktorlar.add(row);
            }
            
        }catch(Exception e){
            e.printStackTrace();

        }
        return doktorlar;
     }
    public doktor doktorBilgisiGetir(String tc){
       
       doktor row = new doktor();
        
        try{
            String query = "select *from hastane.doktor where TcNo=? ;";
            PreparedStatement pt = this.con.prepareStatement(query);
             pt.setString(1, tc);
            ResultSet rs = pt.executeQuery();
           
            while(rs.next()){
                 
                row.setTcNumber(rs.getString("TcNo"));
                row.setName(rs.getString("Ad"));
                row.setSurname(rs.getString("Soyad")); 
                row.setDeparmant(rs.getString("Bölüm"));
                row.setTelephone(rs.getString("Telefon"));
                
            }
            
        }catch(Exception e){
            e.printStackTrace();

        }
        return row;
     }
    
    
    public boolean doktorGuncelle(String tc,String ad,String soyad,String bolum,String tel){
         
String query=
 "UPDATE `hastane`.`doktor` SET `TcNo` = ?, `Ad` = ?, `Soyad` = ?, `Bölüm` = ?, `Telefon` = ? WHERE (`TcNo` = ?);";
          try{
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, tc);
           pt.setString(2, ad );
           pt.setString(3, soyad);
          pt.setString(4, bolum);
          pt.setString(5, tel);
          pt.setString(6, tc);
           pt.execute();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
      }
    
    public void doktorSil(String tc){
         try{
            
           String query= "delete from doktor where TcNo=?;";
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, tc);
           pt.execute();
            
        }
         catch(Exception ex){
            ex.printStackTrace();;
        }
     }
    
    
    
     
}
