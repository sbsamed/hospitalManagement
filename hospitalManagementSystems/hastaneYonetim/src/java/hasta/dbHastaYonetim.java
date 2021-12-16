package hasta;

import java.sql.*;

public class dbHastaYonetim {
    Connection con ;
   public static String hastaTc;
    public static String hastaAdSoyad;
    
  
    public dbHastaYonetim() {
    }

    public dbHastaYonetim(Connection con) {
        this.con = con;
    }
    
    public boolean hastaKayit (hasta hasta){
        boolean set = false;
        try{
           
   String query = "insert into hasta(TcNo,Ad,Soyad,Yaş,İletişim,Parola) values(?,?,?,?,?,?);";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, hasta.getTcNumber());
           pt.setString(2, hasta.getName());
           pt.setString(3, hasta.getSurName());
           pt.setString(4, hasta.getAge());
           pt.setString(5, hasta.getTelephone());
           pt.setString(6, hasta.getPassword());
           
           pt.executeUpdate();
            System.out.println("Hasta Kaydı Eklendi");
           set = true;
        }catch(Exception e){
            System.out.println("Hasta Kayd Eklenemedi");
            e.printStackTrace();
        }
        return set;
    }
    
    
      public hasta login(String tc, String password){
        hasta user=null;
        
        try{
            String query ="select *from hasta where TcNo=? and Parola=?;";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, tc);
            pst.setString(2, password);
            
            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                
               user = new hasta();
                user.setTcNumber(rs.getString("TcNo"));
                 user.setName(rs.getString("Ad"));
                  user.setSurName(rs.getString("Soyad"));
                   user.setAge(rs.getString("Yaş"));
                   user.setTelephone(rs.getString("İletişim"));
                    user.setPassword(rs.getString("Parola"));
                    hastaTc=tc;
                    hastaAdSoyad=user.getName()+" "+user.getSurName();
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
      
       public hasta hastaBilgiGetir(String tc){
        hasta user=null;
        
        try{
            String query ="select *from hasta where TcNo=?;";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, tc);
           
            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                
               user = new hasta();
                user.setTcNumber(rs.getString("TcNo"));
                 user.setName(rs.getString("Ad"));
                  user.setSurName(rs.getString("Soyad"));
                   user.setAge(rs.getString("Yaş"));
                   user.setTelephone(rs.getString("İletişim"));
                    user.setPassword(rs.getString("Parola"));
                    hastaTc=tc;
                    hastaAdSoyad=user.getName()+" "+user.getSurName();
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
       
       
       /* public boolean hastaGuncelle(String tc,String ad,
      String soyad,String yaş,String telefon,String parola){      
      String query=
    "UPDATE hastane.hasta SET TcNo = ?, Ad=?, Soyad=?, Yaş=?,İletişim = ?,Parola= ? WHERE TcNo=?;";
          try{
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, tc);
           pt.setString(2, ad );
           pt.setString(3, soyad);
          pt.setString(4, yaş);
          pt.setString(5, telefon);
          pt.setString(6, parola);
          pt.setString(7, tc);
           pt.execute();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
      }*/
    
    
    
}