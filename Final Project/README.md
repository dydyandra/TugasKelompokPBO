# EXPENSE MANAGER 
  Jenis aplikasi: Aplikasi desktop 
  Fungsi aplikasi: Untuk mengatur keuangan pengguna sehari-hari. 
  
## Class Diagram 
![class diagram](https://github.com/dydyandra/TugasKelompokPBO/blob/master/Final%20Project/doc/FP_PBO.jpg)
 
## Penjelasan Class
### Transaction
  Class ini digunakan untuk membuat objek yaitu Transaction. Dalam class ini terdapat constructor untuk menginisialisasi objek dan terdapat getter setter untuk atribut-atribut di dalam objek. 
  
### SaveTransaction
  Class ini digunakan untuk menyimpan transaksi baru. Adapun agar data di dalam file serializable dapat bertambah menggunakan method ``rewriteFile`` dan ``openFile `` yang kemudian digunakan untuk menginsert data baru dan untuk menghapus data lama.
  Di dalam class ini juga terdapat method untuk mendapatkan path dari gambar-gambar struk yang diupload, dengan cara memberikan path baru dan meng-*copy* file dari folder sumber ke folder proyek. Untuk method ini juga memanfaatkan class ``RandomString `` dan ``CopyFile``. 
  
### LoadTransaction
  Class ini digunakan untuk mengambil/memuat data dari dalam file serializable. Adapun beberapa method di dalam class yaitu untuk menampilkan beberapa jenis data (transaksi total dan *current day transaction*). Untuk melakukan ini memanfaatkan list. 

### CopyFile
  Class ini digunakan untuk meng-*copy* file gambar transaksi dari folder *source* ke dalam folder proyek.
  
### Messages
  Class ini digunakan untuk memunculkan *alert dialog* apabila terdapat kesalahan dalam menginputkan data transaksi dan untuk konfirmasi penghapusan data. 

### RandomString
  Class ini digunakan untuk mendapatkan String acak yang kemudian akan digunakan sebagai path baru untuk file gambar transaksi. 
  
  
### Main
  Pada kelas Main digunakan untuk *launch* aplikasi, dimana tampilan **Main Menu** yang telah dibuat dengan Scenebuilder akan diload menggunakan kelas ``FXMLMainMenuController``. 
  
### Controller
  Controller digunakan untuk mengakses dan mengontrol akses ke *action* yang dilakukan aplikasi, dengan *control* yang telah dibuat di dalam *interface* aplikasi. 
    Controller ini mengatur inisialisasi interface dan data yang akan ditampilkan, yang merupakan abstract method dalam class. Selain itu, dalam controller-controller lainnya terdapat beberapa method sama yaitu untuk mengontrol akses ke **Main Menu, Chart, dan Insert Data**. 
    
#### FXMLChartController
Pada kelas ini, controller mengontrol akses ke *action event* yang dilakukan di dalam interface **Chart**.
  Controller ini:
  1. Mengatur cara menampilkan data yang diambil menggunakan class ``LoadTransaction`` dalam bentuk *pie chart*. Untuk menampilkan data tersebut menggunakan List dan loop untuk menjumlahkan total dari *income* dan *outcome*. 
  
#### FXMLDetailDataController
  Pada kelas ini, controller mengontrol akses ke *action event* yang dilakukan di dalam interface **Detail Transaksi**. Sebelumnya Detail Transaksi ini telah diload di dalam controller Main Menu, dimana controller akan mencari indeks dari data yang ingin ditampilkan. 
  Dalam Detail Data akan ditampilkan hal-hal yang telah diinput di Insert Data, seperti tipe, kategori, nilai transaksi, deskripsi dan gambar struk jika ada. 
  
#### FXMLInsertDataController
  Pada kelas ini, controller mengontrol akses ke *action event* yang dilakukan di dalam interface **Insert Data**. 
  Controller ini:
  1. Mengontrol cara memasukkan data baru, menggunakan class ``SaveTransaction`` dan control yang telah disediakan di Scenebuilder dan Javafx. 
  2. Mengatur *action event* pada *button* yang tersedia, yaitu apabila ditekan akan muncul *message dialog* apabila error, dan akan melakukan penginputan data seperti yang telah dijelaskan di no. 2. 
  3. Adapun untuk mengupload file struk, menggunakan ``FileChooser`` yang merupakan salah satu method dalam JavaFX. 
  
#### FXMLMainMenuController
  Pada kelas ini, controller mengontrol akses ke *action event* yang dilakukan di dalam interface **Main Menu**. 
  Controller ini:
  1. Mengatur cara memfilter transaksi menggunakan filter, formatter dan tabel, 
  2. Mengatur tabel yang akan menampilan data-data transaksi. 
  

### Adapun FXML-FXML yang digunakan sebagai tampilan interface yang akan digunakan oleh controller, yaitu mainMenu, viewChart, viewDetail dan insertData, dan juga CSS yang digunakan untuk memperbagus tampilan dari aplikasi. 

## Fitur-fitur: 
#### Menampilkan income dan outcome setiap hari

   Data transaksi berupa income dan outcome ditampilkan di dalam sebuah tabel dimana akan terdapat keterangan tipe, kategori dan jumlah. Terdapat juga button untuk menampilkan keterangan lebih lanjut seperti deskripsi transaksi dan gambar struk/bukti transaksi. Data transaksi juga dapat ditampilkan berdasarkan *order* paling baru ataupun paling lama.
   
#### Menyimpan detail pengeluaran dan pemasukan beserta file (struk) transaksi

   Terdapat tampilan form untuk memasukkan data transaksi yang telah dilakukan beserta mengupload gambar/bukti transaksi. 
   
#### Menampilkan detail setiap transaksi

   Apabila menekan *button VIEW* di tabel Main Menu, aplikasi akan menampilkan detail transaksi lengkap berupa tipe, kategori, jumlah, deskripsi transaksi dan gambar struk. 
   
#### Menampilkan chart income/outcome 

   Menampilkan *pie chart* dalam 3 jenis yaitu *income*, *outcome*, dan total dimana dibagi dengan kategori-kategori yang ada. 
   
#### Memfilter transaksi berdasarkan tanggal dan kategori 

   Dari tabel di Main Menu dapat menampilkan data transaksi sesuai tanggal ataupun kategori. 
   
#### Remove transaksi 

   Apabila ingin menghilangkan transaksi tertentu dapat menghapus *record* dari Detail Transaksi. 


## Referensi
[Referensi 1](https://www.youtube.com/watch?v=Dq9Z_JObYKk)

[Referensi 2](https://t.co/pHaZxoufFL?amp=1)
