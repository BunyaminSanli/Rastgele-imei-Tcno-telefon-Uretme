/*
*
* @author Bünyamin Şanlı
* bunyaminsanli@ooutlook.com.tr
* @since 11.04.2020
* 
*/
package rastgelekisiuret;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Isim {
    String satir = "";
    String s = "";
    String [] veri = new String[3000];
    public String isimUret()
    {
        //dosya okuma
    try{   
         FileInputStream fStream = new FileInputStream("random_isimler.txt");
         DataInputStream dStream = new DataInputStream(fStream);
         BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream));
         
         int i=0;
         while((satir = bReader.readLine()) != null)
         {
            //null gürene kadar satırı okuyup Stringe atar onu da veri dizisine atar
            veri[i] = satir;
            i++;
         }
         dStream.close();
         }
         catch(Exception e)
         {
             System.out.println("hata" + e.getMessage());
         }
    
    int a = (int)(System.nanoTime() % 3000);
    s = veri[a];
    return s;
    }
    
}
