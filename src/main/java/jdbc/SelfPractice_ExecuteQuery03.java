package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelfPractice_ExecuteQuery03 {
    public static void main(String[] args) throws SQLException {

        DBWork db=new DBWork();

        Connection con=db.connect_to_db("sql_practice", "postgres", "274817");

        Statement st=con.createStatement();

        /*
        -- SORU1: calisan sayisi 15.000’den cok olan markalarin
        --isimlerini ve bu
        -- markada calisanlarin isimlerini ve maaşlarini listeleyin.
         */

        String sql1="Select isim, maas, isyeri from calisanlar " +
                "where isyeri in (Select marka_isim from markalar where calisan_sayisi>15000)";

        ResultSet result1=st.executeQuery(sql1);

        while (result1.next()) {
            System.out.println(result1.getString("isim") +
                    "--" + result1.getInt("maas") +
                    "--" + result1.getString("isyeri"));
        }

        System.out.println("==============================================");

        /*
        -- SORU2: marka_id’si 101’den büyük olan marka
        --çalişanlarinin isim, maaş ve
        --şehirlerini listeleyiniz.
         */

        String sql2="select isim, maas, sehir from calisanlar\n" +
                "where isyeri in\n" +
                "(select marka_isim from markalar where marka_id >101 )";
        ResultSet result2=st.executeQuery(sql2);
        while (result2.next()) {
            System.out.println(result2.getString("isim") +
                    "--" + result2.getString("sehir") +
                    "--" + result2.getString("maas"));
        }


    }
}
