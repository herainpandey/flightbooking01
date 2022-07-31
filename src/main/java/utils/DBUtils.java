package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {

    public static List<String> getDataFromDB(String query) throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery(query);
        List<String> record =new ArrayList<String>();
        while(res.next()){
            record.add(res.getString("firstName"));
        }
        return record;
    }

}
