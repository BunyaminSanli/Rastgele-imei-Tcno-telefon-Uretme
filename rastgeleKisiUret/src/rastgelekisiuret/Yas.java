/*
*
* @author Bünyamin Şanlı
* bunyaminsanli@ooutlook.com.tr
* @since 11.04.2020
* 
*/

package rastgelekisiuret;

//random yaş ureten sınıf
public class Yas {
    int yas;
    public int yasUret()
    {
        yas = (int)(System.nanoTime()% 101);
        return yas;
    }
}
