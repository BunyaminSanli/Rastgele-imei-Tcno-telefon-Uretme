/*
*
* @author Bünyamin Şanlı
* bunyaminsanli@ooutlook.com.tr
* @since 11.04.2020
*
*/ 

package rastgelekisiuret;

/**
 *
 * @author bunyamin
 */
public class Kisi {
    private long tckn;
    private String adSoyad;
    private String telefon;
    private long imei;
    private int yas;
       
        //tc kimlik get set metodu
    public void setTckn(long tckn)
    {
        this.tckn = tckn;
    }
    public long getTckn()
    {
       return this.tckn;
    }
       
    //ad soyad get set metodu
    public void setAdSoyad(String adSoyad)
    {
        this.adSoyad = adSoyad;
    }
     public String getAdSoyad()
    {
       return this.adSoyad;
    }
    
     //telefon no get set metodu
    public void setTelefon(String telefon)
    {
        this.telefon = telefon;
    }
    public String getTelefon()
    {
       return this.telefon;
    }
     
    //imei get set metodu
    public void setImei(long imei)
    {
        this.imei = imei;
    }
    public long getImei()
    {
       return this.imei;
    } 
    
    //yas get set metodu
    public void setYas(int yas)
    {
        this.yas = yas;
    }
    public int getYas()
    {
       return this.yas;
    } 
}
