/*
*
* @author Bünyamin Şanlı
* bunyaminsanli@ooutlook.com.tr
* @since 11.04.2020
* 
*/


/*
 * Bu sınıfta üretim algoritmalarına göre imei, telefon ve tc no
 * üretilir ve gerekli sınıflara yollamak üzere return değerine atanır
 */
package rastgelekisiuret;

public class Rastgele {
    public long RandTckn()  //doğru formatta tckn üreten metot
    {
        
        long b = System.nanoTime() % 999999999;  //9 haneli bir rand sayı üretilir
        if(b < 99999999) //üretilen sayının 8 haneli olma durumu için if kontrolu yapılır
        {
            b = b * 10;
        }
        int[] tcDizisi = new int[9];
        int i = 0;
        //rastgele sınıfınde sayı uretip randsayi'ya atarız
        long randsayi = b;
        long x = randsayi;  //olusturudugumuz rand sayiyi kaybetmemek icin baska bir değere atariz.
        
        while (randsayi > 0)
        { 
            // Sayı sıfırdan büyük olduğu sürece tekrarlanacak :  
            tcDizisi [i] = (int) (randsayi % 10); 
            i++;
            randsayi = randsayi/10;  
        }
        int toplam3 = 0;
        for(int j = 8; j>=0; j--)
        {
            toplam3 += tcDizisi[j];
        }
          
        int toplam = 0;
        
        for(int j =0; j<9; j+=2)
        {
            toplam += tcDizisi[j];
        }
          
        toplam = toplam * 7;
        int toplam2 = 0;
        
        for(int j = 1; j<9; j+=2)
        {
            toplam2 += tcDizisi[j];
        }
          
        int tck = (toplam - toplam2) % 10;
        x = x * 10 + tck;
        int z = (toplam3 + tck) % 10;
        x = x * 10 + z;
       
       return x;
    }
     
    public long RandImei()  //buradadoğru formatta imei uretıp IMEINo sınıfına yollayacaz
    {
         int[] imeiDizisi = new int[15];
         int i = 0;
         int imeiToplama = 0;
        
        
        long imei = System.nanoTime() % 99999999999999L;
        if(imei < 9999999999999L) //üretilen sayının 13 haneli olma durumu için if kontrolu yapılır
        {
            imei = imei * 10;
        }
        long imeiSon = imei;
        while (imei > 0)
          { 
            // Sayı sıfırdan büyük olduğu sürece tekrarlanacak :  
            imeiDizisi [i] = (int) (imei % 10); 
            imei = imei/10;  
            i++;
         }
        
        for(int a = 0; a < imeiDizisi.length-1; a++)  //dizi uzunluğu kadar for döncek (son hane sonradan eklenecek o yuzden -1)
        {
            if(a % 2 == 0)  //dizinin tek sıradaki elemanlarını if ile buluruz
            {
                imeiDizisi[a] = imeiDizisi[a] * 2;  //tek sıradaki elemanları 2 ile çarparız
            }
            if(imeiDizisi[a] > 9)   // çarptığımız değer 9dan büyükse(böylelikle mod9 9 = 0 olması durumu ortadan kalkıyor)mod 9 almak icin if kullandık
            {
                  imeiDizisi[a] = imeiDizisi[a] % 9;
                 
                if(imeiDizisi[a]==0)
                {
                 imeiDizisi [a]= 9;
                }
            } 
            
            imeiToplama += imeiDizisi[a];
        }
        
        imeiToplama = imeiToplama * 9;
        imeiToplama = (imeiToplama % 10); 
        imeiDizisi[14] = imeiToplama;
        imeiSon = (imeiSon * 10) + imeiToplama; 
       return imeiSon;
    }
    
    public String RandTelefon() //burada doğru formatta telefon no üretip telefon sınıfına yollayacaz
    {
        long tel = Rastgele.this.RandTckn() / 10000 + 11111; //tc den farklı olsun diye toplama yaptım
        int [] telDizi = {501,505,506,507,551,552,
                          553,554,555,559,530,531,
                          532,533,534,535,536,537,
                          538,539,561,540,541,542,
                          544,545,546,547,548,549};
        int i = (int)(System.nanoTime() % 29);
        long tel1 = telDizi[i];
        long tel2 = tel1 * 10000000L + tel;
        String s = String.valueOf("0" + tel2);                                                 
                                       
        return s;
    }
    
}
