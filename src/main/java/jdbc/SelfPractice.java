package jdbc;

import java.sql.*;

public class SelfPractice {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");

        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/sql_practice", "postgres", "274817");

        Statement st=con.createStatement();

        //personel tablosundan  id'si 8 olan personel bilgilerini listeleyiniz

        String sql1="SELECT * from personel where id=8";
        ResultSet result1=st.executeQuery(sql1);

        while(result1.next()){
            System.out.println(result1.getInt(1) +
                    "--" + result1.getString(2) +
                    "--" + result1.getInt(3)+
                    "--"+ result1.getInt(4)+
                    "--"+result1.getString(5));
        }

        //id'si 5 olan personelin isim, yaş ve email bilgilerini listeleyiniz
        /*
        30 yaşından buyuk personeli listeleyin
        maası 21000 olmayan personel bilgilerini listeleyiniz.
        ismi a harfi ile başlayan personel bilgilerini listeleyiniz.
        ismi n harfi ile biten personel bilgilerini listeleyiniz.
        id'si 3,5,7 ve 9 olan personel bilgilerini listeleyiniz.
         yaşı 39,48 ve 54 olmayan personel bilgilerini listeleyiniz.
          yaşı 30 ve 40 arasında olan personel bilgilerini listeleyiniz.
          yaşı 30 ve 40 arasında olmyan personel bilgilerini listeleyiniz.
           emaili null olan personel bilgilerini listeleyiniz.
           personel bilgilerini yaşa göre sıralayınız.
           personel bilgilerini maaşa göre sıralayınız.
           personelin yaşlarını büyükten küçüğe doğru sıralayınız.
           personelin maaşlarını büyükten küçüğe doğru sıralayınız.
           En yüksek maaş olan ilk 3 personel bilgilerini sıralayınız
     */




    }

}
