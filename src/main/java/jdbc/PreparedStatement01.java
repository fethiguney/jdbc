package jdbc;

import java.sql.*;

public class PreparedStatement01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "274817");

        Statement st= con.createStatement();

//1. Örnek: Prepared statement kullanarak company adı IBM
// olan number_of_employees değerini 9999 olarak güncelleyin.

    //1.adım : Prepared statement query'sini olustur
    String sql1="UPDATE companies SET number_of_employees = ? WHERE company= ? ";

    //2.adım : PreparedStatement objesini olustur
    PreparedStatement pst1=con.prepareStatement(sql1);

    //3.adım : set () methodlari ile soru işaretleri için deger girilir
        pst1.setInt(1,9999);
        pst1.setString(2, "IBM");

    //4.adım :Execute Query
    int updateRowNumbers=pst1.executeUpdate();
        System.out.println(updateRowNumbers+" satir guncellendi");

        String sql="SELECT * from companies";
        ResultSet result1=st.executeQuery(sql);

        while (result1.next()) {
            System.out.println(result1.getInt(1) +
                    "-" + result1.getString(2) +
                    "-" + result1.getInt(3));
        }



        pst1.setInt(1,15000);
        pst1.setString(2, "GOOGLE");


        //4.adım :Execute Query
        int updateRowNumbers1=pst1.executeUpdate();
        System.out.println(updateRowNumbers+" satir guncellendi");

        String sql2="SELECT * from companies";
        ResultSet result2=st.executeQuery(sql2);

        while (result2.next()) {
            System.out.println(result2.getInt(1) +
                    "-" + result2.getString(2) +
                    "-" + result2.getInt(3));
        }

//2. Örnek: "SELECT * FROM <table name>" query'sini
// prepared statement ile kullanın.
        System.out.println("===============");

        read_Data(con, "companies");

        con.close();
        st.close();

    }

    public static void read_Data(Connection con, String tableName) {
        try {
            String query=String.format("SELECT * from %s ", tableName);
            Statement statement1=con.createStatement();
            ResultSet result=statement1.executeQuery(query);
            while (result.next()) {
                System.out.println(result.getString(1) +
                        "-" + result.getString(2) +
                        "-" + result.getInt(3));
            }



        } catch (Exception e) {
            System.out.println(e);
        }


    }


}
