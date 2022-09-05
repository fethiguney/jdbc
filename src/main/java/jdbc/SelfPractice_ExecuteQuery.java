package jdbc;

import java.sql.*;

public class SelfPractice_ExecuteQuery {

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

        String sql2="SELECT isim, yas, email from personel where id=5";
        ResultSet result2=st.executeQuery(sql2);
        while(result2.next()){
            System.out.println(
                     result2.getString("isim") +
                    "--" + result2.getInt("yas")+
                    "--"+result2.getString("email"));
        }
        System.out.println("=========================================");
        // 30 yaşından buyuk personeli listeleyin

        String sql3="SELECT * from personel where yas>30";
        ResultSet result3=st.executeQuery(sql3);
        while(result3.next()){
            System.out.println(result3.getInt(1) +
                    "--" + result3.getString(2) +
                    "--" + result3.getInt(3)+
                    "--"+ result3.getInt(4)+
                    "--"+result3.getString(5));
        }

        System.out.println("=========================================");

        //  maası 21000 olmayan personel bilgilerini listeleyiniz.
        String sql4="Select * from personel where maas!=21000";
        ResultSet result4=st.executeQuery(sql4);
        while(result4.next()){
            System.out.println(result4.getInt(1) +
                    "--" + result4.getString(2) +
                    "--" + result4.getInt(3)+
                    "--"+ result4.getInt(4)+
                    "--"+result4.getString(5));
        }
        System.out.println("=========================================");

        //ismi a harfi ile başlayan personel bilgilerini listeleyiniz.
        String sql5="Select * from personel where isim ilike 'a%'";
        ResultSet result5=st.executeQuery(sql5);
        while(result5.next()){
            System.out.println(result5.getInt(1) +
                    "--" + result5.getString(2) +
                    "--" + result5.getInt(3)+
                    "--"+ result5.getInt(4)+
                    "--"+result5.getString(5));
        }
        System.out.println("=========================================");
       // ismi n harfi ile biten personel bilgilerini listeleyiniz.
        String sql6="Select * from personel where isim ilike '%n'";
        ResultSet result6=st.executeQuery(sql6);
        while(result6.next()){
            System.out.println(result6.getInt(1) +
                    "--" + result6.getString(2) +
                    "--" + result6.getInt(3)+
                    "--"+ result6.getInt(4)+
                    "--"+result6.getString(5));
        }
        /*
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
