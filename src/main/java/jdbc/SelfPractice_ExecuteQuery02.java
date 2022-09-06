package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelfPractice_ExecuteQuery02 {
    public static void main(String[] args) throws SQLException {

        DBWork db=new DBWork();

        Connection con=db.connect_to_db("sql_practice", "postgres", "274817");

        Statement st=con.createStatement();

        String sql="Select * from personel where id in (3, 5, 7, 9)";
        ResultSet result1=st.executeQuery(sql);

        while(result1.next()){
            System.out.println(result1.getInt(1) +
                    "--" + result1.getString(2) +
                    "--" + result1.getInt(3)+
                    "--"+ result1.getInt(4)+
                    "--"+result1.getString(5));
        }

        System.out.println("====================================");

        //   personel bilgilerini maaşa göre sıralayınız.
        String sql2="Select * from personel order by maas";
        ResultSet result2=st.executeQuery(sql2);

        while(result2.next()){
            System.out.println(result2.getInt(1) +
                    "--" + result2.getString(2) +
                    "--" + result2.getInt(3)+
                    "--"+ result2.getInt(4)+
                    "--"+result2.getString(5));
        }

        System.out.println("====================================");

        //En yüksek maaş olan ilk 3 personel bilgilerini sıralayınız
        String sql3="Select * from personel order by maas desc limit 3";
        ResultSet result3=st.executeQuery(sql3);

        while(result3.next()){
            System.out.println(result3.getInt(1) +
                    "--" + result3.getString(2) +
                    "--" + result3.getInt(3)+
                    "--"+ result3.getInt(4)+
                    "--"+result3.getString(5));
        }



        con.close();
        st.close();







    }
}
