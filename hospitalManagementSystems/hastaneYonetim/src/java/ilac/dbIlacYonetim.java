
package ilac;
import doktor.dbDoktorYonetim;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author Samed
 */
public class dbIlacYonetim {
    
    Connection con ;
    public static   String hastaTc;
     public static  String hastaAdi;
      public static String hastaBolum;
     public static  String hastaIlac;
     public static  ilac ilacHastaBilgileri = null;
        
    public dbIlacYonetim(Connection con) {
        this.con = con;
    }

    public dbIlacYonetim() {
    }
   
  
public ilac ilacBilgileriGetir(String TCNO){
          ilac i = new ilac();
          ilacHastaBilgileri = new ilac();
            
        try{
            String query = "select *from hastane.ilac where TcNo=?;";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1,  TCNO);
            ResultSet rs = pt.executeQuery();
           
           
            while(rs.next()){
                 
                i.setTcNumber(rs.getString("TcNo"));
                i.setName(rs.getString("AdSoyad"));
                i.setDeparment(rs.getString("Bölüm")); 
                i.setIlac(rs.getString("İlac"));
                ilacHastaBilgileri.setTcNumber(rs.getString("TcNo"));
                ilacHastaBilgileri.setName(rs.getString("AdSoyad"));
                ilacHastaBilgileri.setDeparment(rs.getString("Bölüm")); 
                ilacHastaBilgileri.setIlac(rs.getString("İlac"));
                hastaAdi=rs.getString("AdSoyad");
                hastaBolum=rs.getString("Bölüm"); 
                
            }
        }catch(Exception e){
            e.printStackTrace();

        }
        return i;
     }
      
       public List<ilac> ilacGetirDoktor(String tc){
           dbDoktorYonetim doktor=new dbDoktorYonetim();
           hastaTc=tc;
           
        List<ilac> ilaclar = new ArrayList<>();
        try{
            String query = "select *from hastane.ilac where (TcNo=? and Bölüm=?);";
            PreparedStatement pt = this.con.prepareStatement(query);
              pt.setString(1,  tc);
               pt.setString(2,  doktor.doktorBolum);
              
              
            ResultSet rs = pt.executeQuery();
           
           
            while(rs.next()){
                ilac row = new ilac();
                row.setTcNumber(rs.getString("TcNo"));
                row.setName(rs.getString("AdSoyad"));
                row.setDeparment(rs.getString("Bölüm")); 
                row.setIlac(rs.getString("İlac"));
                ilaclar.add(row);
                
            }
            
        }catch(Exception e){
            e.printStackTrace();

        }
        return ilaclar;
     }
       
        public ilac ilacDuzenle(String ilac){
        ilac i = null;
        try{
            String query = "select * from ilac where İlac=? and TcNo=?;";
            
            PreparedStatement pt = this.con.prepareStatement(query);
             pt.setString(1, ilac);
            pt.setString(2, hastaTc);
            ResultSet rs= pt.executeQuery();
            
            while(rs.next()){
                
                String tc = rs.getString("TcNo");
                String adSoyad = rs.getString("AdSoyad");
                String poliklinik = rs.getString("Bölüm");
                String  ilacc = rs.getString("İlac");
                hastaIlac=ilacc;
                i = new ilac(tc,adSoyad,poliklinik,ilacc);
            }
        }catch(Exception ex){
            ex.printStackTrace();;
        }
        return i;
    }
         
 public boolean ilacGuncelle(String ilacccc){
         
        String query="UPDATE hastane.ilac SET İlac =? WHERE (TcNo=? and İlac=?) ;";
          try{
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, ilacccc);
           pt.setString(2, hastaTc );
           pt.setString(3, hastaIlac);
           pt.execute();
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
         return true;
        
     }
 
 public void ilacEkle (String tc,String ad,String bolum,String newilac){
        try{
           String query = "insert into hastane.ilac(TcNo,AdSoyad,Bölüm,İlac) values(?,?,?,?);";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, tc);
           pt.setString(2, ad);
           pt.setString(3, bolum);
            pt.setString(4, newilac);
            pt.executeUpdate();
            System.out.println("İlaç Kaydı Eklendi");
           
        }catch(Exception e){
            System.out.println("İlaç Kaydı Eklenemedi");
            e.printStackTrace();
        }
      
    }
  public void ilacSil(ilac ilac){
        try{
         String query = "delete from hastane.ilac where( TcNo=? and İlac=?);";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, ilac.getTcNumber());
           pt.setString(2, ilac.getIlac());
          
            pt.executeUpdate();
            System.out.println("İlaç Kaydı Silindi");
           
        }catch(Exception e){
            System.out.println("İlaç Kaydı Silinemedi");
            e.printStackTrace();
        }
        
    }
  

 
 public List<ilac> hastaIlacBilgileri(String tc){
          List<ilac> ilaclar = new ArrayList<>();
        try{
            String query = "select *from hastane.ilac where TcNo=?;";
            PreparedStatement pt = this.con.prepareStatement(query);
              pt.setString(1,  tc);
            ResultSet rs = pt.executeQuery();
           
         while(rs.next()){
                ilac row = new ilac();
                row.setTcNumber(rs.getString("TcNo"));
                row.setName(rs.getString("AdSoyad"));
                row.setDeparment(rs.getString("Bölüm")); 
                row.setIlac(rs.getString("İlac"));
                ilaclar.add(row);
                
            }
            
        }catch(Exception e){
            e.printStackTrace();

        }
        return ilaclar;
     }

}
