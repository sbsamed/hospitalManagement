
package randevu;
import doktor.dbDoktorYonetim;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import hasta.dbHastaYonetim;

/**
 *
 * @author Samed
 */
public class dbRandevuYonetim {
     Connection con ;
     public static String randevuTarihi;
      public static String randevuBolumu;
     
        
    public dbRandevuYonetim(Connection con) {
        this.con = con;
    }
    
    
     public boolean randevuKayit (randevu hasta){
        boolean set = false;
        try{
           
         String query = "insert into randevu(TcNo,AdSoyad,Tarih,Bölüm) values(?,?,?,?);";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, hasta.getTcNumber());
           pt.setString(2, hasta.getName());
           pt.setString(3, hasta.getDate());
           pt.setString(4, hasta.getDepartment());

           
           pt.executeUpdate();
            System.out.println("Randevu Kaydı Eklendi");
           set = true;
        }catch(Exception e){
            System.out.println("Randevu Kaydı Eklenemedi");
            e.printStackTrace();
        }
        return set;
    }
     
     dbHastaYonetim dbHastaYonetim= new dbHastaYonetim();
     public List<randevu> randevuGetir(){
         
        List<randevu> randevular = new ArrayList<>();
        
        try{
            
            String query = "select *from hastane.randevu where TcNo="+dbHastaYonetim.hastaTc+";";
            PreparedStatement pt = this.con.prepareStatement(query);
            ResultSet rs = pt.executeQuery();
            
            while(rs.next()){
                 randevu row = new randevu();
                row.setTcNumber(rs.getString("TcNo"));
                row.setName(rs.getString("AdSoyad"));
                row.setDate(rs.getString("Tarih")); 
                row.setDepartment(rs.getString("Bölüm"));
                randevular.add(row);
            }
            
        }catch(Exception e){
            e.printStackTrace();

        }
        return randevular;
     }
     /*******************************/
      
      public List<randevu> randevuGetirDoktor(){
       
          dbDoktorYonetim dbDoktorYonetimm=new dbDoktorYonetim();
         
        List<randevu> randevularr = new ArrayList<>();
        
        try{
            String query = "select *from hastane.randevu where Bölüm=?;";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1,  dbDoktorYonetimm.doktorBolum);
            ResultSet rs = pt.executeQuery();
           
           
            while(rs.next()){
                 randevu row = new randevu();
                row.setTcNumber(rs.getString("TcNo"));
                row.setName(rs.getString("AdSoyad"));
                row.setDate(rs.getString("Tarih")); 
                row.setDepartment(rs.getString("Bölüm"));
                randevularr.add(row);
            }
            
        }catch(Exception e){
            e.printStackTrace();

        }
        return randevularr;
     }
     
     
     public randevu randevuDuzenle(String tarih){
        randevu randevu = null;
        
        try{
            String query = "select * from randevu where Tarih=? and TcNo=?;";
            
            PreparedStatement pt = this.con.prepareStatement(query);
             pt.setString(1, tarih);
            pt.setString(2, dbHastaYonetim.hastaTc);
            ResultSet rs= pt.executeQuery();
            
            while(rs.next()){
                
                String tc = rs.getString("TcNo");
                String adSoyad = rs.getString("AdSoyad");
                String date = rs.getString("Tarih");
                String poliklinik  = rs.getString("Bölüm");
                this.randevuTarihi=date;
                this.randevuBolumu=poliklinik;
                randevu = new randevu(tc,adSoyad,date,poliklinik);
            }
        }catch(Exception ex){
            ex.printStackTrace();;
        }
        return randevu;
    }
     
   
     
     
     public boolean randevuGuncelle(String date,String poliklinik){
         
         String query="UPDATE hastane.randevu SET Tarih =?, Bölüm =? WHERE (TcNo=? and Tarih=? and Bölüm=? );";
          try{
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, date);
           pt.setString(2, poliklinik );
           pt.setString(3, dbHastaYonetim.hastaTc);
           pt.setString(4, this.randevuTarihi );
           pt.setString(5, this.randevuBolumu );
           pt.execute();
           return true;
            
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
         
        
     }
     
     public void randevuSil(String tarih){
         try{
            
           String query= "delete from randevu where (Tarih=? and TcNo=?);";
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, tarih);
           pt.setString(2, dbHastaYonetim.hastaTc);
                                              
           pt.execute();
            
        }
         catch(Exception ex){
            ex.printStackTrace();;
        }
     }
     
    
}
