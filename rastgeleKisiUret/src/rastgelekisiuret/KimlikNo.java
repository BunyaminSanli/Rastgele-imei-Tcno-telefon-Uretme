/*
*
* @author Bünyamin Şanlı
* bunyaminsanli@ooutlook.com.tr
* @since 11.04.2020
* 
*/

/*
 * Bu sınıfta tc algoritmasının hesaplama yöntemine göre
 * tc no hesaplanır ve gelen no eğer geçerli bir tc içeriyorosa
 * true dödüren bir fonksiyona sahiptir
 */

package rastgelekisiuret;

public class KimlikNo {
    public boolean tcknKontrol(long gelenTcno){
        int [] tcDizi = new int [11];
        int toplam1 = 0;    //10. haneyi bulmak için tek haneleri topladığımız değişken
        int toplam2 = 0;    //10. haneyi bulurken çift haneleri topladığım değişken
        int toplam3 = 0;    //11. haneyi bulurken rakamları topladığım değişken
        int i = 0;
        long gelenTcno1 = gelenTcno;
        //gelenTcno rakamlarının diziye atanması
        while (gelenTcno1 > 0)
        { 
            // Sayı sıfırdan büyük olduğu sürece tekrarlanacak :  
            tcDizi [i] = ((int)(gelenTcno1 % 10)); 
            gelenTcno1 = gelenTcno1 / 10;  
            i++;
        }
        
        for(int j = 10; j>1; j--)
        {
           if(j % 2 == 0)
           {
              toplam1 += tcDizi[j];
           }
           
           if(j % 2 == 1)
           {
               toplam2 += tcDizi[j];
           }
        }
        
        for(int c=10; c>0; c--)
        {
            toplam3 += tcDizi[c];
        }
        //gelen tc no algoritmasına uygunsa ve 11 haneyse true döndürecek if bloğu
       if((((toplam1 * 7) - toplam2) % 10) == tcDizi[1] && (toplam3 % 10) == tcDizi[0] && gelenTcno > 10000000000L)
       {
         // System.out.println("doğru kimlik no");
          return true;
       }
       
       return false;
    }               
    
}
