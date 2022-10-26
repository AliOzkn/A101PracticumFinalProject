
<p align="center">
  <img src="https://user-images.githubusercontent.com/107454207/197718671-1d47817c-d706-47f6-b67b-fb501bd2dfb7.jpg"/>
</p>

---

<h2>Proje Hakkında</h2>

Bu proje, Patika.dev ve A101 ortaklığı ile düzenlenen ***Test Automation Practicum*** programı kapsamında geliştirilmiştir.<br>
Belirlenen web sitesinin fonksiyonlarının düzgün çalıştığını doğrulamak amacıyla testler yapılmaktadır.

<h3>Test Senaryoları</h3>

<details> <summary>  <b>1. Test senaryosunu görüntülemek için tıklayınız.</b> </summary> 

<b>*Kullanıcı girişi yapılarak sepete ürün eklenmesi* </b>

- Kullanıcı hepsiburada.com sitesini ziyaret eder.
- Kullanıcı giriş işlemi yapılır.
- Yönlendirmeden sonra anasayfada kullanıcı giriş işleminin yapıldığı doğrulanır.
- Kullanıcı, burada satın almak istediği ürün için arama yapacaktır.
- Kullanıcı, arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.
- Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.
- Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.
</details> <br>

<details> <summary> <b>2. Test senaryosunu görüntülemek için tıklayınız.</b> </summary>

<b>*Kullanıcı girişi yapılmadan sepete ürün eklenmesi*</b>

- Kullanıcı hepsiburada.com sitesini ziyaret eder.
- Kullanıcı, arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.
- Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.
- Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.
</details> 

<h3>Proje Mimarisi</h3>

Page Object Model anlayışına uygun şekilde hazırlanan yapı, site üzerindeki fonksiyonların gerçekleştirildiği kısım ve
test işlemlerinin gerçekleştirildiği kısım olmak üzere 2 bölümden oluşmaktadır.

- Aşağıdaki resimde görüldüğü üzere, web sitesi, pageobjects klasörü içinde 4 sınıfa ayrılmıştır.
    - <b>MainPage</b> sınıfı, kullanıcı girişi ve ürün arama işlemlerini yapmaktadır.
    - <b>ProductsPage</b> sınıfı, aranan ürüne göre mevcut ürünlerin listesini gösterip, listeden 1 adet ürünü seçmektedir.
    - <b>ProductDetailPage</b> sınıfı, seçilen ürünü, 2 farklı satıcıdan olmak üzere 2 adet olarak sepete eklemektedir.
    - <b>CartPage</b> sınıfında ise sepete eklenen ürünün, seçilen ürün ile aynı olduğunun doğrulaması yapılmaktadır.
    - <b>Components</b> paketindeki sınıflarda ise bu ana sınıflar için yardımcı ögeler bulunmaktadır.

<p align="center">
 <img src="https://user-images.githubusercontent.com/107454207/198012941-1afe0299-b99f-440c-ad55-913cec36918a.png"/>
</p>


- Bu kısım testlerle alakalıdır.
    - <b>TestComponents</b> paketindeki sınıflarda, driver'ın ayağa kaldırılması, config.properties dosyasının okunması, testin başarısız olması durumunda ekran görüntüsü alma gibi fonksiyonlar bulunmaktadır.
    - <b>Tests</b> paketindeki sınıflarda ise istenen senaryolara uygun 2 adet test bulunmaktadır.

<p align="center">
 <img src="https://user-images.githubusercontent.com/107454207/198013167-3364517f-9ae5-459d-85a1-de4e2706bcf0.png"/>
</p>

---

<h2> 💻 Projenin Kurulumu Ve Çalıştırılması </h2>


- Proje üzerinde değişiklikler yapabilmak için bilgisayarınızda JDK kurulu olmalıdır. 
  - [Buraya](https://www.oracle.com/tr/java/technologies/javase/jdk11-archive-downloads.html)
    tıklayarak daha stabil bir sürüm olan JDK 11'i indirebilirsiniz. 
  - Windows kurulumu için [bu videoyu](https://www.youtube.com/watch?v=RBuZHg6eyIs)
    ; MAC kurulumu için ise [bu videoyu](https://www.youtube.com/watch?v=oiqKK0FOjK0) izleyebilirsiniz.
- Kodları yazabilmek için bir ortama ihtiyaç vardır. Bunun için Intellij IDEA kullanılabilir. 
  - [Buradan](https://www.jetbrains.com/idea/download/#section=windows) indirebilir; 
  - Windows kurulumu için [bu videoyu](https://www.youtube.com/watch?v=-5kIt83ldk8); MAC kurulumu için ise [bu videoyu](https://www.youtube.com/watch?v=5UDILzNBsRE)
    izleyebilirsiniz.
- Maven genellikle Java platformunda yer alan komutların derlenmesi sırasında kullanılan otomasyon ve inşa aracıdır.
  - [Buradan](https://maven.apache.org/download.cgi) indirebilir;
  - Windows kurulumu için [bu videoyu](https://www.youtube.com/watch?v=km3tLti4TCM); MAC kurulumu için ise [bu videoyu](https://www.youtube.com/watch?v=Dwwpkot6ZR0)
    izleyebilirsiniz.<br><br>

- Projede kullanıcıdan parametrik olarak bazı girdiler istenmektedir. Bunlar, config.properties dosyasında belirtilmektedir. [Dosyaya ulaşmak için tıklayınız.](https://github.com/AliOzkn/A101PracticumFinalProject/blob/2b0732e0c05ff49c4f7ddf600b027c7175e90b8a/src/main/resources/config.properties)
  <ins> <b>Buraya girilen bilgilerde Türkçe karakter kullanılmamalıdır.</b> </ins>
<p align="center">
  <img src="https://user-images.githubusercontent.com/107454207/197762991-6fa127fd-ed3e-419e-a64d-0f7862bc3170.gif"/>
</p>

     browser     : Bu proje, Chrome ve Firefox tarayıcılarını desteklemektedir.

     url         : Testin gerçekleştirileceği url yazılmalıdır.

     email       : HepsiBurada sitesinde kayıtlı bir üyeliğe ait mail adresi yazılmalıdır.

     password    : Kullanıcı girişi için belirlenmiş parola yazılmalıdır.

     productName : Sepete eklenecek ürünün adı yazılmalıdır.



- Bu bilgileri girdikten sonra, başka bir dosyaya müdahele etmeye gerek yoktur.<br>
  Proje TestNG kütüphanesi ile oluşturulduğu için testng.xml dosyası üzerinden testler yürütülmektedir. [Dosyaya ulaşmak için tıklayınız.](https://github.com/AliOzkn/A101PracticumFinalProject/blob/2b0732e0c05ff49c4f7ddf600b027c7175e90b8a/testng.xml)<br>
<p align="center">
  <img src="https://user-images.githubusercontent.com/107454207/198016668-2fe0e663-6c17-4513-8fe0-7e1bf9beef3e.png"/>
</p>

- Eğer bir test başarısız olur ve tekrar çalıştırmak istenirse testin bulunduğu sınıfa gidip, @Test notasyonunun yanına
  `
  (retryAnalyzer = Retry.class)
  `
  kodu eklenmelidir. Örneği aşağıda gösterilmiştir.
<p align="center">
 <img src="https://user-images.githubusercontent.com/107454207/197780669-93e9ecf0-051f-40c3-9906-5bf926eca68e.gif"/>
</p>

Varsayılan olarak tekrar sayısı 1 olarak belirlenmiştir. [Retry](https://github.com/AliOzkn/A101PracticumFinalCase/blob/53501586fd33691be80ffbc9b92a9aa280eb923d/src/test/java/TestComponents/Retry.java)
dosyasındaki ***MaxTry*** değişkeni tekrar sayısını belirtmektedir. İstenilen sayı yazılabilir.

<p align="center">
 <img src="https://user-images.githubusercontent.com/107454207/197781792-652a1a84-11cf-4009-a8f1-eae522b88e97.png"/>
</p><br>

- Raporlama için ExtentReport kullanılmıştır. Rapor ***index.html*** dosya adı ile ***reports*** klasörü içinde bulunmaktadır.
  Ayrıca testin başarısız olması durumunda alınan ekran görüntüleri yine bu klasöre kaydedilmektedir.

<p align="center">
 <img src="https://user-images.githubusercontent.com/107454207/198016826-33f4d096-0004-453e-8801-5def4a1376a9.png"/>
</p><br>
<p align="center">
 <img src="https://user-images.githubusercontent.com/107454207/198016830-41da1e90-5f13-4b2a-a5eb-159dc21f7728.png"/>
</p><br>

---











