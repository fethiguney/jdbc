package jdbc;

import java.sql.*;

public class PracticeQuery03 {
    public static void main(String[] args) throws SQLException {



        DBWork db=new DBWork();

        Connection con=db.connect_to_db("sql_practice", "postgres", "274817");

        //Soru: Ogrenciler tablosundaki erkek ogrencileri listeleyiniz

        PreparedStatement ps1=con.prepareStatement("Select * from ogrenciler");

        ResultSet result1=ps1.executeQuery();

        ResultSetMetaData rsmd=result1.getMetaData();

        System.out.println(rsmd.getColumnCount());

        System.out.println("1.sutunun ismi "+rsmd.getColumnName(1));
        System.out.println("2.sutunun ismi "+rsmd.getColumnName(2));
        System.out.println("3.sutunun ismi "+rsmd.getColumnName(3));
        System.out.println("4.sutunun ismi "+rsmd.getColumnName(4));




    }
}
