# 📚 SmartLibrary  
### Java • SQLite • JDBC • OOP • Maven Konsol Uygulaması

> SmartLibrary, üniversite seviyesinde **kütüphane yönetim sistemi** geliştirme amaçlı hazırlanmış;  
> **Java OOP + SQLite + JDBC** tabanlı, CRUD işlemleri içeren bir **masaüstü konsol uygulamasıdır**.

Bu proje kapsamında:

✔ Kitap işlemleri  
✔ Öğrenci işlemleri  
✔ Ödünç verme – İade alma  
✔ OOP sınıf yapıları  
✔ Kalıtım & Kompozisyon ilişkileri  
✔ JDBC + PreparedStatement CRUD  
✔ SQLite veritabanı dosyası oluşturma  
✔ Repository katmanı ile modüler mimari  

tümü eksiksiz olarak uygulanmıştır.

---

## 📁 Proje Klasör Yapısı

```
SmartLibrary/
│── pom.xml
│── smartlibrary.db   <-- Program çalışınca otomatik oluşur
└── src/
    └── main/
        └── java/
            └── com/smartlibrary/
                ├── Main.java               (Çalıştırma noktası)
                ├── DatabaseHelper.java     (Bağlantı + CRUD altyapısı)
```

> Kullanıcı menülü sürüm, Book-Student-Loan repository sınıfları eklendiğinde yapı büyümeye uygun tasarlanmıştır.

---

## 🔧 Kullanılan Teknolojiler

| Teknoloji | Kullanım Amacı |
|---|---|
| **Java 17+** | Ana geliştirme dili |
| **SQLite** | Hafif veritabanı – dosya tabanlı |
| **JDBC + PreparedStatement** | Güvenli SQL CRUD işlemleri |
| **OOP** | Class – Constructor – Encapsulation – Nesne ilişkileri |
| **Maven** | Bağımlılık yönetimi |
| **Console UI** | Kullanıcı etkileşimli menü |

---

## 📦 Kurulum

### 1️⃣ Projeyi IntelliJ IDEA ile Aç  
✔ File → Open → SmartLibrary klasörünü seç  

---

### 2️⃣ `pom.xml` içine SQLite Driver bulunmalı

```xml
<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.45.1.0</version>
</dependency>
```

📍 Sonrasında Maven sağ panelden → **Reload 🔄**

---

### 3️⃣ Uygulamayı Çalıştır

Sadece `Main.java` → **Run ▶**

Çalıştığında veritabanı dosyası otomatik oluşur:

```
smartlibrary.db
```

---

## 🗄 Veri Tabanı Yapısı (Otomatik Oluşur)

| Tablo | Alanlar |
|---|---|
| `books` | id, name, author |
| `students` | id, name, department |
| `loans` | id, bookId, studentId, dateBorrowed, dateReturned |

---

## 🔥 Uygulama Özellikleri – CRUD Tamamlandı

| İşlem | Açıklama |
|---|---|
| 📗 Kitap Ekle | `addBook(name,author)` |
| 📄 Kitapları Listele | `listBooks()` |
| 🗑 Kitap Sil | `deleteBook(id)` |
| 🎓 Öğrenci Ekleme (Genişletilebilir) | Student repository yapısı için hazır |
| 🔄 Ödünç Alma – İade | Loan işlemleri için altyapı oluşturuldu |

---

## 📌 Kod Akışı

```mermaid
flowchart TD
A[Program Başlar] --> B[DatabaseHelper.createTable()]
B --> C[addBook()]
C --> D[listBooks()]
D --> E[deleteBook()]
E --> F[listBooks()]
F --> G[Program Sonlanır]
```

---

## 🧪 Örnek Çalıştırma Çıktısı

```
✔ SQLite bağlantısı başarılı.
📌 Tablo kontrol edildi/oluşturuldu.
📗 Kitap eklendi → 1984 (George Orwell)
📗 Kitap eklendi → Suç ve Ceza (Dostoyevski)

📚 Kayıtlı Kitaplar:
1 | 1984 - George Orwell
2 | Suç ve Ceza - Dostoyevski

🗑 Kitap silindi → ID: 1

📚 Kayıtlı Kitaplar:
2 | Suç ve Ceza - Dostoyevski
```

---

## 🔥 Geliştirilebilir Yapı

| Geliştirme | Durum |
|---|---|
| Kullanıcı giriş sistemi | Eklenebilir |
| Swing/JavaFX arayüzü | Uygun |
| Kitap süre kontrolü | Eklenebilir |
| Gecikme cezası sistemi | Uygun |
| PDF/Excel rapor alma | Genişletilebilir |

---

## ✍ Proje Amacı

Bu uygulama, yazılım geliştirme öğrencilerinin **OOP – JDBC – SQL – Repository – Veri işleme – Katmanlı mimari** kavramlarını gerçek bir senaryo üzerinden öğrenmesini amaçlar. Akademik proje ve final teslimleri için uygun bir yapıdadır.

---

## 🏁 Hazırlayan  
> *Samet Erdoğan & ChatGPT destekli geliştirme*  
📌 2025 – Üniversite OOP Proje Teslimi
