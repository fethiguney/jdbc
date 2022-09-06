package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PracticeQuery02 {
    public static void main(String[] args) throws SQLException {

        DBWork db=new DBWork();

        Connection con=db.connect_to_db("sql_practice", "postgres", "274817");

        //Soru: Ogrenciler tablosundaki erkek ogrencileri listeleyiniz

        Statement st=con.createStatement();

        String sql1="Select * from ogrenciler where cinsiyet='E'";

        ResultSet result1=st.executeQuery(sql1);

        while (result1.next()) {
            System.out.println(result1.getInt(1) +
                    "--" + result1.getString(2) +
                    "--" + result1.getString(3) +
                    "--" + result1.getString(4));
        }





    }
}
