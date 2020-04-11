//*
*
* @author Bünyamin Şanlı
* bunyaminsanli@ooutlook.com.tr
* @since 11.04.2020
* 
package rastgelekisiuret;

/**
 *
 * @author bunyamin
 */
public class ImeiNo {
   
    public boolean imeiKontrol(long imeiKontrol) {  
        int[] imeiDizi = new int[15];   //gelen imei no yu atacağımız dizi
        int i = 0;
        int rakamToplama = 0;
        //bu while da gelen imei noyu sondan başlayarak rakamlarını diziye atar
        while (imeiKontrol > 0) 
        { 
            // Sayı sıfırdan büyük olduğu sürece tekrarlanacak :  
            imeiDizi [i] = (int)(imeiKontrol % 10); //son rakamı imeiDizi[i]'ye atar
            imeiKontrol = imeiKontrol/10;   //daha sonra 10a bölerek diziye attığımız rakamdan kurtuluruz
            i++;
        }
        
        for(int a = 0; a < imeiDizi.length; a++)  //dizi uzunluğu kadar for döncek (son hane sonradan eklenecek o yuzden -1)
        {
            if(a % 2 == 1)  //dizinin tek sıradaki elemanlarını if ile buluruz
            {
                imeiDizi[a] = imeiDizi[a] * 2;  //tek sıradaki elemanları 2 ile çarparız
            }
            if(imeiDizi[a] > 9)   // çarptığımız değer 9dan büyükse(böylelikle mod9 9 = 0 olması durumu ortadan kalkıyor)mod 9 almak icin if kullandık
            {
                imeiDizi[a] = imeiDizi[a] % 9;
                //buradaki if bloğunda mod aldığımız değer 9un katıysa 0 yerine 9 versin diye 0 durumunu kontrol ettik
                if(imeiDizi[a]==0)
                {
                 imeiDizi [a]= 9;
                }
            } 
           rakamToplama += imeiDizi[a];
        }
       
        if(rakamToplama % 10 == 0)  // rakamToplama 10'a tam bölünüyorsa imei no doğrudur
        {
            return true;
        }
       
        return false;
    }
    
}
