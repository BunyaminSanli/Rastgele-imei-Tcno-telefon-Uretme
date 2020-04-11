/*
*
* @author Bünyamin Şanlı
* bunyaminsanli@ooutlook.com.tr
* @since 11.04.2020
* 
*/

/*
 * substring: İfadenin başlangıç ve bitiş indisleri arasındaki karakterleri döndürür. 
 */

package pdp_odev2;
//kutuphanelerimizi import ederiz
import java.io.*;
import java.util.Scanner;
import rastgelekisiuret.ImeiNo;
import rastgelekisiuret.Isim;
import rastgelekisiuret.KimlikNo;
import rastgelekisiuret.Kisi;
import rastgelekisiuret.Rastgele;
import rastgelekisiuret.Yas;

public class PDP_Odev2 {
    public static void main(String[] args) throws IOException {
        //nuradaki kod bloğunda kutuphaneden kullanacağımız sınıf nesnelerini oluştururuz
        Rastgele rastgele = new Rastgele();
        Isim isim = new Isim();
        Yas yas = new Yas();
        Kisi kisi = new Kisi();
        KimlikNo kimlikno = new KimlikNo();
        ImeiNo imei = new ImeiNo();
        
        long gidenTc, gidenImei;    //kutuphaneye yollayacagım tc ve imei
        int ss = satirSayisi();     //satirSayisi fonksiyonundan aldığım satır sayısı
        int a = 0;  //kullanıcı menüsü seçim atancak int değer
        int adet = 0;   //kullanıcıdan alınacak üretilecek kişi sayısının adedi
        
        //dosya yazma
        String yol="kisiler.txt";
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(yol, true)));
        
        //while da 3 tuşuna basana kadar sonsun döngü
        while (a != 3)
        {   //kullanıcı menüsü
            System.out.println("1 -> Rastgele Kişi Üret");
            System.out.println("2 -> Üretilmiş Dosya Kontrol Et");
            System.out.println("3 -> Çıkış");
            //kullanıcı girdisi alma
            Scanner girdi = new Scanner(System.in);
            a = girdi.nextInt();
           
            switch(a)
            {   //durum 1 kişi üretme durumu
                case 1:
                    System.out.println("kaç kişi üretilecek");
                    Scanner b = new Scanner(System.in);
                    adet = b.nextInt(); //üretilecek kişi adedi kullanıcıdan alınır
                    //burada adet sayıınca for döner ve kişi sınıfının tüm özellikleri set edilir
                    for(int i = 0; i < adet; i++)
                    {
                       kisi.setImei(rastgele.RandImei());
                       kisi.setAdSoyad(isim.isimUret());
                       kisi.setTckn(rastgele.RandTckn());
                       kisi.setTelefon(rastgele.RandTelefon());
                       kisi.setYas(yas.yasUret());
                       //burada da set edilen metotlar txt yazdırmak için get metodu ile çağırılır
                       out.println(kisi.getTckn()+" " + kisi.getAdSoyad()+" " + kisi.getYas()+" " + kisi.getTelefon()+" " + "(" + kisi.getImei() + ")");
                    }
                    out.close();
                    System.out.println(adet + " Kişi Eklendi...\n");
                    break;
                
                case 2: //durum 2 kontrol durumu
                    int tcDogruSayac = 0;
                    int imeiDogruSayac = 0;
                    int tcYanlisSayac = 0;
                    int imeiYanlisSayac = 0;
                    String [] veri;    //daha sonra satırları diziye atamak için bir dizi tanımladım
                    veri = new String[ss+adet];     //veri dizisinin boyutunu atıyorum ve yeni kişi üretilmişse onları da alsın diye ekliyorum
                    String str = "";   //txt den aldığımız her satırı tek tek atmak için bos bir string tanımladım
                    
                    //dosya okuma işlemleri
                    FileInputStream fStream = new FileInputStream("kisiler.txt");
                    DataInputStream dStream = new DataInputStream(fStream);
                    BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream));
         
                    int i = 0;  //burada dosya kuma işlemi yapılıp satır satır diziye atanır
                    while((str = bReader.readLine()) != null)
                    {
                        veri[i] = str;
                        i++;
                    }
                    
                    dStream.close();
                    String bolunmusDizi[];
                    //bu forun ss ve adet kadar dönmesinin sebebi satır sayısı ilk başta belirleniyor
                    // ve daha sonra case1 seçilirse ve yeni kişiler üretilirse onları da kapsama almak
                    for(int c = 0; c < ss+adet; c++)
                    {
                        bolunmusDizi = veri[c].split(" ");  //boşluğa göre split
                        gidenTc = Long.valueOf(bolunmusDizi[0]);    //ilk eleman her zaman tc 
                        gidenImei =  Long.valueOf(bolunmusDizi[5].substring(1, 16)); //6. eleman her zaman imei substring kullanarak parantezleri dahil etmiyorum 
                        //bu blokta sayaçlar artırılıyor
                        if(imei.imeiKontrol(gidenImei) == true)
                        {
                            imeiDogruSayac++;
                        }
                        else
                        {
                            imeiYanlisSayac++;
                        }
                        if(kimlikno.tcknKontrol(gidenTc) == true)
                        {      
                            tcDogruSayac++;
                        } 
                        else
                        {
                            tcYanlisSayac++;
                        }
                    }
                    //ekrana sayaçları yazdırma 
                    System.out.println("\nT.C. Kimlik Kontrol\n"+(tcDogruSayac)+ "\t" + "Geçerli\n" + (tcYanlisSayac)+ "\t" + "Geçersiz");
                    System.out.println("\nIMEI Kontrol\n"+(imeiDogruSayac)+ "\t" + "Geçerli\n" +(imeiYanlisSayac)+ "\t" + "Geçersiz\n"); 
            }
        }
    }
    
    //bu fonksiyon txt deki satır sayısını prgram çalıştığında bize döndürece ve işlmelerimiz kolyalaştıracak
    public static int satirSayisi()
    {
       int sayac = 0;
       
       try{
           FileInputStream fStream = new FileInputStream("kisiler.txt");
           DataInputStream dStream = new DataInputStream(fStream);
           BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream));
           while(bReader.readLine() != null)
           {
              sayac++;
           }
         
           dStream.close();
         }
         catch(Exception e)
         {
            System.out.println("hata" + e.getMessage());
         }
         return sayac;
   }
    
}
