# Rastgele-imei-Tcno-telefon-Uretme
Java programlama dilini kullanarak rastgele kişi üretebilecek kütüphane. Bu kütüphane çalıştırılabilir bir program değildir. Kişi sınıfı özellikleri;

- T.C. Kimlik (Nesne referansı)
- İsim, soyisim
- Yaş
- Telefon (Nesne referansı)

Kişi rastgele üretileceği zaman isimler “random_isimler.txt” dosyasından çekilmektedir. Bu dosya github'a yüklenmiştir. Yaş 0-100 arası rastgele atanacaktır. T.C. kimlik numarası yine rastgele oluşturulacak fakat hesaplama kuralına sadık kalınacaktır. T.C. Kimlik numarasının bir hesaplama algoritması vardır. Her üretilen kişiye rastgele atanacak T.C. kimlik numarası bu hesaplamaya uymalıdır. Kişinin telefonu rastgele üretilecek bir numara olup Türkiye’deki numaralara uyumlu olmalıdır. Ve her telefon’a ait bir IMEI numarası olmalı ve bu numarada rastgele oluşturulmalıdır. 15 haneli bir numara olan IMEI ilk 14 hanesi ile belli hesaplamalar yapılarak 15. Hanesi bulunmaktadır. Rastgelelikte bu kurala uyulmalıdır.

(Random gibi hazır metot veya sınıflar kullanılamaz.) 

RASTGELEKISIURET (Kütüphane adı)
Kisi (Sınıf)
KimlikNo (Sınıf)
Telefon (Sınıf)
IMEINo (Sınıf)

➢ KimlikNo ve IMEINo sınıfları içerisinde rastgele ilgili numaradan üreten metot ve üretilmiş bir numaranın doğruluğunu kontrol eden metot vardır.
Modüler sınıf yapısı olması gereken bu ödevde her metot ve sınıf sadece kendisinden beklenen görevi yerine getirmektedir.
kütüphaneyi kullanacak proje çalıştırıldığında ekrana aşağıdaki menü gelmelidir.

1- Rastgele Kişi Üret
2- Üretilmiş Dosya Kontrol Et
3- Çıkış

Rastgele Kişi Üret
Kullanıcıdan kaç adet kişi üretileceği alındıktan sonra Yukarıda tasarlanmış kütüphane kullanılarak kişiler üretilip Kisiler.txt dosyasına aşağıdaki formatta yazılacaktır.

12345678924 Ahmet Koşar 27 05361234567 (453658912575898)

Üretilmiş Dosya Kontrol Et
Bu seçenek seçildiğinde yukarıdaki formata uygun Kisiler.txt isimli bir dosyayı programınız okuyup içerisinde üretilen kişilerin T.C. Kimlik ve IMEI numaraları doğru girilmiş mi kontrol edecek ve ekrana aşağıdakine benzer bir çıktı verecektir. Bu kontrol işlemlerini  kütüphaneyi kullanarak yapmaktadır.

T.C. Kimlik Kontrol
754 Geçerli
246 Geçersiz

IMEI Kontrol
960 Geçerli
40 Geçersiz

Çıkış seçeneği seçilmediği sürece program çalışmaya devam etmektedir.

