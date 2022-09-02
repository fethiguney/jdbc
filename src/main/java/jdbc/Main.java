package jdbc;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        //DBWork objesi olustur

       DBWork db=new DBWork();

       //Connection fonksiyonunu getirir
       Connection con= db.connect_to_db("techproed", "postgres", "274817");

        //Yeni table olusturma methodu
        db.createTable(con, "employees");




    }
}
