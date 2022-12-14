package jdbc;

import java.sql.*;

public class Execute02 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

       Class.forName("org.postgresql.Driver");

       Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "274817");

       Statement st= con.createStatement();

        //1. Example:  region id'si 1 olan "country name" değerlerini çağırın.

        String sql1="SELECT country_name from countries where region_id=1";

       ResultSet result1= st.executeQuery(sql1);

       while(result1.next()){
           System.out.println(result1.getString("country_name"));
       }

        //2.Örnek: "region_id"nin 2'den büyük olduğu
        // "country_id" ve "country_name" değerlerini çağırın.

        String sql2="SELECT country_id, country_name from countries where region_id>2";
       ResultSet result2=st.executeQuery(sql2);
       while (result2.next()) {
           System.out.println(result2.getString("country_id") +
                   "-->" + result2.getString("country_name"));
       }

//3.Example: "number_of_employees" değeri en düşük
// olan satırın tüm değerlerini çağırın.
        String sql3="SELECT * from companies where number_of_employees =(SELECT MIN (number_of_employees) from companies)";
        ResultSet result3=st.executeQuery(sql3);
        while (result3.next()) {
            System.out.println(result3.getInt("company_id") + "--" +
                    result3.getString("company") + "--" +
                    result3.getInt("number_of_employees"));
        }

        con.close();
        st.close();

    }
}
