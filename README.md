# 📚 SmartLibrary  
### Java • SQLite • JDBC • OOP • Maven Konsol Uygulaması

## 👨‍💻 Proje Sahibi

- ****Ad Soyad:**** Samet ERDOĞAN

- ****Öğrenci Numarası:**** 20230108039

- ****Bölüm:**** Bilgisayar Programcılığı

- ****Ders Adı:**** Nesneye Dayalı Programlama 2

- ****Ders Kodu:**** BIP2037

- ****Öğretim Görevlisi:**** Emrah SARIÇİÇEK

- ****Teslim Tarihi:**** 05/12/2025

> SmartLibrary, **kütüphane yönetim sistemidir**;  
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

tümü programda uygulanmıştır.

---

## 🔧 Kullanılan Teknolojiler

| Teknoloji | Kullanım Amacı |
|---|---|
| **Java ** | Ana geliştirme dili |
| **SQLite** | Veritabanı – dosya tabanlı |
| **JDBC + PreparedStatement** | Güvenli SQL CRUD işlemleri |
| **OOP** | Class – Constructor – Encapsulation – Nesne ilişkileri |
| **Maven** | Bağımlılık yönetimi |
| **Console UI** | Kullanıcı etkileşimli menü |

---

## 📦 Kurulum

### 1️⃣ Projeyi IntelliJ IDEA ile Aç  
✔ File → Open → PruNesneyeDayaliProg2_Vize klasörünü seç  

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

```
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
## (Önemli Not :Listeleme Sorgularını yapmadan önce lütfen öğrenci ve kitap ekleyin.)
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
