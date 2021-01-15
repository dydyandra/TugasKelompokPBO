# EXPENSE MANAGER V.2 
  [Link Menuju Folder Aplikasi](https://github.com/dydyandra/TugasKelompokPBO/tree/master/Final%20Project/ExpenseManager%20V.2%20(FIX))<br> 
  [Link Menuju Demo dan Penjelasan Aplikasi (Youtube)](https://youtu.be/BLL3N2mb2xM)
  
  Jenis aplikasi: Aplikasi desktop <br>
  Fungsi aplikasi: Untuk mengatur keuangan pengguna sehari-hari. 
  
## Class Diagram 
![class diagram](https://github.com/dydyandra/TugasKelompokPBO/blob/master/Final%20Project/doc/FP_PBO.jpg)
 
## Penjelasan Class
### Transaction
  Class ini digunakan untuk membuat objek yaitu Transaction. Dalam class ini terdapat constructor untuk menginisialisasi *instance variables* yang terdapat pada objek dan terdapat getter setter untuk variabel-variabl tersebut. Class Transaction mengimplementasikan Serializable. 
  
### SaveTransaction
  Class ini digunakan untuk menyimpan data transaksi baru. Adapun agar data di dalam file serializable dapat bertambah menggunakan method ``rewriteFile`` dan ``openFile `` yang kemudian digunakan untuk menginsert data baru dan untuk menghapus data lama.<br>
  Adapun method-method dalam class yaitu: 
  1. `deleteData` untuk menghapus data lama. 
  2. ``insertData`` untuk memasukkan data baru. 
  3. ``openFile`` untuk membuka file serializable dari path. 
  4. ``insert`` untuk memasukkan gambar.<br>
  Method untuk mendapatkan path dari gambar-gambar struk yang diupload, dengan cara memberikan path baru dan meng-*copy* file dari folder sumber ke folder proyek. Untuk method ini juga memanfaatkan class ``RandomString `` dan ``CopyFile``. 
  5. ``closeFile``
  
### LoadTransaction
  Class ini digunakan untuk mengambil/memuat data dari dalam file serializable.<br>
  Adapun beberapa method di dalam class yaitu: 
  1. ``readData`` untuk membaca data berupa category dan tanggal ke suatu List. 
  2. ``readDaily()`` untuk membaca data transaksi hari itu ke sebuah List. 
  3. ``showTransaction `` untuk mencari data berupa category dan tanggal yang diinginkan (untuk filter.)
  4. ``currentDayTransaction()`` untuk mencari data yang memiliki tanggal yang sama dengan tanggal hari tersebut. 
  
  Keempat method ini memanfaatkan List untuk membaca dan mencari data yang akan ditampilkan. 

### CopyFile
  Class ini digunakan untuk meng-*copy* file gambar transaksi dari folder *source* ke dalam folder destinasi (folder proyek). 
  
### Messages
  Class ini digunakan untuk memunculkan *alert dialog* apabila terdapat kesalahan dalam menginputkan data transaksi dan untuk konfirmasi penghapusan data. 

### RandomString
  Class ini digunakan untuk mendapatkan String acak yang kemudian akan digunakan sebagai path baru untuk file gambar transaksi. 
  
### Main
  Pada kelas Main digunakan untuk *launch* aplikasi, dimana tampilan **Main Menu** yang telah dibuat dengan Scenebuilder akan diload menggunakan kelas ``FXMLMainMenuController``. 
  
### Controller
  Controller digunakan untuk mengakses dan mengontrol akses ke *action* yang dilakukan aplikasi, dengan *control* yang telah dibuat di dalam interface aplikasi. 
  Controller ini mengatur inisialisasi aplikasi dan data yang akan ditampilkan, yang merupakan abstract method dalam class. Selain itu, dalam controller-controller lainnya terdapat beberapa method sama yaitu untuk mengontrol akses ke **Main Menu, Chart, dan Insert Data**. <br>
  Method-method tersebut adalah:
  1. ``backtoMenu`` untuk membuka fxml dari halaman utama yang berisi elemen-elemen control yang akan digunakan. 
  2. ``goToChart`` untuk membuka fxml dari halaman Chart. 
  3. ``goToInsert`` untuk membuka fxml dari halaman Insert. 
  4. ``initialize`` untuk menginisialisasi tampilan/interface aplikasi. 
    
    
### FXMLChartController
Pada kelas ini, controller mengontrol segala hal yang akan dilakukan di dalam bagian **Chart**.
  Controller ini mengatur cara menampilkan data yang diambil menggunakan class ``LoadTransaction`` dalam bentuk *pie chart*. Untuk menampilkan data tersebut menggunakan List dan iterasi untuk menjumlahkan total dari *income* dan *outcome*.<br>
  Method-method yang digunakan:
1. ``initialize `` untuk membaca data-data dari file serializable yang kemudian akan dimasukkan ke dalam List. Dari List tersebut nanti akan dicari data-data dengan kategori yang sesuai (yang kemudian dimasukkan dalam ArrayList) dan kemudian akan diiterasi untuk mencari total, dan kemudian dimasukkan ke dalam PieChart. 
2. ``count `` yang berbentuk List, yaitu method untuk menghitung total dan index dari data transaksi. 
  
### FXMLDetailDataController
  Pada kelas ini, controller mengontrol segala hal yang akan dilakukan di dalam bagian **Detail Transaksi**. Sebelumnya Detail Transaksi ini telah diload di dalam controller Main Menu, dimana controller akan mencari indeks dari data yang ingin ditampilkan. 
  Dalam Detail Data akan ditampilkan hal-hal yang telah diinput di Insert Data, seperti tipe, kategori, nilai transaksi, deskripsi dan gambar struk jika ada.<br>
  Method-method yang digunakan: 
  1. Constructor untuk menginisialisasi transaction dari objek Transaction. 
  2. ``initialize`` untuk mengambil data-data transaksi berupa tipe, deskripsi, nilai, kategori dan image Path data untuk ditampilkan dalam interface. 
  
### FXMLInsertDataController
  Pada kelas ini, controller mengontrol segala hal yang akan dilakukan di dalam bagian **Insert Data**. 
  Controller ini:
  1. Mengontrol cara memasukkan data baru, menggunakan class ``SaveTransaction`` dan control yang telah disediakan di Scenebuilder dan Javafx. 
  2. Mengatur *action event* pada *button* yang tersedia, yaitu apabila ditekan akan muncul *message dialog* apabila error, dan akan melakukan penginputan data seperti yang telah dijelaskan di no. 2. 
  3. Adapun untuk mengupload file struk, menggunakan ``FileChooser`` yang merupakan salah satu method dalam JavaFX. 
  
  Method-method yang digunakan: 
  1. ``initialize `` untuk menginisialisasi interface dan elemen-elemennya seperti memasukkan pilihan-pilihan ke dalam ChoiceBox, memasukkan action event ke beberapa button yang digunakan. 

  
#### FXMLMainMenuController
  Pada kelas ini, controller mengontrol segala hal yang akan dilakukan di dalam bagian **Main Menu**. 
  Controller ini:
  1. Mengatur cara memfilter transaksi menggunakan filter, formatter dan tabel, 
  2. Mengatur tabel yang akan menampilan data-data transaksi. 
  Method-method yang digunakan: 
  1. ``initialize`` untuk menginisialisasi interface dan elemen-elemennya, seperti beberapa fitur seperti ChoiceBox category, filter datepicker dan fitur melihat transaksi hari itu. 
  2. ``filterTransaction`` untuk mencari data dengan tanggal tertentu dan memasukkannya ke dalam List, dan dimasukkan ke dalam tabel. 
  3. ``createTable`` untuk menampilkan data dalam TableView FXML. 
  4. ``addButtontoTable`` untuk menambahkan button yang akan membawa pengguna ke halaman Details sesuai dengan data yang ingin dilihat.

### Adapun FXML-FXML yang digunakan sebagai tampilan interface yang kemudian di*load* oleh controller, yaitu mainMenu, viewChart, viewDetail dan insertData, dan juga CSS yang digunakan untuk memperbagus tampilan dari aplikasi. 

CSS ini akan dihubungkan dengan FXML-FXML sesuai dengan id/class yang ingin diberikan desain/presentasi tertentu. 

FXML sendiri kemudian akan dihubungkan dengan class-class Controller dengan cara memberikan ``fx:id`` pada elemen-elemen control FXML (seperti ``Button``, ``DatePicker ``, ``TableView``, dll).  yang kemudian akan dijadikan sebagai instance di class controller. 

Sebelumnya, FXML memiliki ``fx:controller`` dalam root file yang kemudian akan diload ke memmory menggunakan FXMLLoader, seperti contoh berikut:<br>

**Didapat dari [``Controller.java``](src/id/ac/its/fp/Controller.java)**
```FXML Loader
public void backToMenu(ActionEvent event) {
	try {
		FXMLLoader loader = new FXMLLoader() ;
		Controller controller = new FXMLMainMenuController() ;
		loader.setController(controller);
	       loader.setLocation(getClass().getResource("mainMenu.fxml"));
	       Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
		app.setScene(scene);
		app.show();
	} catch(Exception e) {
		e.printStackTrace();
	}
}
```

``fx:id`` kemudian akan dijadikan instance di dalam class-class yang merupakan controller dari interface. <br>
**Didapat dari [``FXMLMainMenuController.java``](src/id/ac/its/fp/FXMLMainMenuController.java)**

```contoh
// hanya contoh beberapa attribut dari FXML
public class FXMLMainMenuController extends Controller implements Initializable {
	@FXML
	private Button homeButton ;
  
	@FXML
	private DatePicker dateFilter ;
  
	@FXML 
	private ComboBox<String> typeFilter ; 
	
	@FXML
	private TableView<Transaction> displayTable ;
	
	public List<Transaction> transactionList ;
}
  
```


## Fitur-fitur: 
### Menampilkan income dan outcome setiap hari<br>
   Data transaksi berupa income dan outcome ditampilkan di dalam sebuah tabel dimana akan terdapat keterangan tipe, kategori dan jumlah, sehingga mudah untuk men-*tracking* keuangan. Terdapat juga button untuk menampilkan keterangan lebih lanjut seperti deskripsi transaksi dan gambar struk/bukti transaksi. Data transaksi juga dapat ditampilkan berdasarkan *order* paling baru ataupun paling lama.
   
  <p align="center"> <img src="https://github.com/dydyandra/TugasKelompokPBO/blob/master/Final%20Project/doc/mainMenu.gif" width="auto" height="300" /> </p>
   
   Selain itu, di bagian paling bawah ditampilkan jumlah pengeluaran yang dikeluarkan dan pemasukan pada tanggal tersebut, untuk memudahkan pengguna dalam menghitung.
   
### Menyimpan detail pengeluaran dan pemasukan beserta file (struk) transaksi<br>
   Terdapat tampilan form untuk memasukkan data transaksi yang telah dilakukan beserta mengupload gambar/bukti transaksi. Terdapat dua form yaitu untuk pengeluaran, dan untuk pemasukan. Pengguna juga dimudahkan dengan adanya pemilihan kategori dan memasukkan deskripsi pengeluaran/pemasukan tersebut. 
   
   <p align="center"><img src="https://github.com/dydyandra/TugasKelompokPBO/blob/master/Final%20Project/doc/insertTransaction.gif" width="auto" height="300" /></p>
   
### Memfilter transaksi berdasarkan tanggal dan kategori<br>
   Dari tabel di Main Menu dapat menampilkan data transaksi sesuai tanggal ataupun kategori. 
   
   <p align="center"><img src="https://github.com/dydyandra/TugasKelompokPBO/blob/master/Final%20Project/doc/filterDateCategory.gif" width="auto" height="300" /></p>
   
### Menampilkan detail setiap transaksi<br>
   Apabila menekan *button VIEW* di tabel halaman utama, aplikasi akan menampilkan detail transaksi lengkap berupa tipe, kategori, jumlah, deskripsi transaksi dan gambar struk. 
   
   <p align="center"><img src="https://github.com/dydyandra/TugasKelompokPBO/blob/master/Final%20Project/doc/viewDetail.gif" width="auto" height="300" /></p>
   
### Menampilkan chart income/outcome<br>
   Menampilkan *pie chart* dalam 3 jenis yaitu *income*, *outcome*, dan total dimana dibagi dengan kategori-kategori yang ada, untuk memudahkan pengguna dalam membandingkan jumlah pengeluaran/pemasukan maupun total. 
   
   <p align="center"><img src="https://github.com/dydyandra/TugasKelompokPBO/blob/master/Final%20Project/doc/viewChart.gif" width="auto" height="300" /></p>
   
### Remove transaksi<br>
   Apabila ingin menghilangkan transaksi tertentu dapat menghapus *record* dari Detail Transaksi. 
   
   <p align="center"><img src="https://github.com/dydyandra/TugasKelompokPBO/blob/master/Final%20Project/doc/deleteRecord.gif" width="auto" height="300" /></p>
   

## Referensi
[Referensi 1](https://www.youtube.com/watch?v=Dq9Z_JObYKk)

[Referensi 2](https://t.co/pHaZxoufFL?amp=1)
