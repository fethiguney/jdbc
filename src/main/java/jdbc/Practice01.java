package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Practice01 {
    public static void main(String[] args) throws SQLException {


      DBWork db=new DBWork();

       Connection con= db.connect_to_db("sql_practice", "postgres", "274817");

       Statement st=con.createStatement();

       //Ogrenciler tablosuna yeni bir kayıt ekleyin
        //(300, 'Sena", 12, 'K')

      // int s1=st.executeUpdate("insert into ogrenciler values (302, 'Sena', 12, 'K')");

       // System.out.println(s1+" satir eklendi");

        //SORU: Öğrenciler tablosuna birden fazla veri ekleyin
        // (400, 'Sena Can', 12, 'K'), (401, 'Sena Can', 12, 'K'), (402, 'Sena Can', 12, 'K')

       /* String[] veri = {"insert into ogrenciler values(400, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values(401, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values(402, 'Sena Can', 12, 'K')"};

       int count=0;
       for (String each: veri) {
            count = count + st.executeUpdate(each);
        }
        System.out.println(count+" data eklendi");*/

        String[] veri2 = {"insert into ogrenciler values(500, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values(501, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values(502, 'Sena Can', 12, 'K')"};




    }
}
