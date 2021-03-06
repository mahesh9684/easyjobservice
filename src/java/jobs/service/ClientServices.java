package jobs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jobs.db.DbConnection;
import org.json.JSONArray;
import org.json.JSONObject;

public class ClientServices {

    ResultSet rs;
   static Connection conn;
    PreparedStatement pstmt;
    JSONArray jSONArray;

    static {
        conn = DbConnection.connect();
    }
    
    public JSONArray getAllClients() {
        try {
            pstmt = conn.prepareStatement("select * from client_data");
            rs = pstmt.executeQuery();
            jSONArray = new JSONArray();
            while (rs.next()) {
                JSONObject json = new JSONObject();
                json.put("id", rs.getInt("id"));
                json.put("name", rs.getString("name"));
                json.put("address", rs.getString("address"));
                json.put("email_id", rs.getString("email_id"));
                json.put("contact", rs.getString("contact"));
                json.put("web_address", rs.getString("web_address"));
                json.put("user_name", rs.getString("user_name"));
                json.put("password", rs.getString("password"));
                json.put("created_at", rs.getString("created_at"));
                json.put("updated_at", rs.getString("updated_at"));
                jSONArray.put(json);

            }

        } catch (Exception e) {
            System.out.println("getAllClients() :" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("ClientServices/getAllClients(): " + e);
            }
        }
        return jSONArray;
    }

    public boolean addClient(String objbean) {
        try {
            JSONObject json = new JSONObject(objbean);
            pstmt = conn.prepareStatement("insert into client_data(name,address,email_id,contact,web_address,user_name,password,created_at) values(?,?,?,?,?,?,?,?)");
            pstmt.setString(1, json.getString("name"));
            pstmt.setString(2, json.getString("address"));
            pstmt.setString(3, json.getString("email_id"));
            pstmt.setString(4, json.getString("contact"));
            pstmt.setString(5, json.getString("web_address"));
            pstmt.setString(6, json.getString("user_name"));
            pstmt.setString(7, json.getString("password"));
            pstmt.setString(8, Utility.getCurrentDate());

            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("addClient():" + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("ClientServices/AddClient():" + e);
            }
        }
        return false;
    }

    public String getClient(String user_name) {
        try {
            pstmt = conn.prepareStatement("select * from client_data where user_name = ?");
            pstmt.setString(1, user_name);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                JSONObject json = new JSONObject();
                json.put("id", rs.getInt("id"));
                json.put("name", rs.getString("name"));
                json.put("address", rs.getString("address"));
                json.put("email_id", rs.getString("email_id"));
                json.put("contact", rs.getString("contact"));
                json.put("web_address", rs.getString("web_address"));
                json.put("user_name", rs.getString("user_name"));
                json.put("password", rs.getString("password"));
                json.put("created_at", rs.getString("created_at"));
                json.put("updated_at", rs.getString("updated_at"));
                return json.toString();

            }

        } catch (Exception e) {
            System.out.println("getClient() :" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("ClientServices/getClient(): " + e);
            }
        }
        return "";
    }

    public boolean updateClient(String objbean) {
        try {
            JSONObject json = new JSONObject(objbean);
            pstmt = conn.prepareStatement("update client_data set name=?,address=?,email_id=?,contact=?,web_address=?,password=?,updated_at=? where user_name=?");
            pstmt.setString(1, json.getString("name"));
            pstmt.setString(2, json.getString("address"));
            pstmt.setString(3, json.getString("email_id"));
            pstmt.setString(4, json.getString("contact"));
            pstmt.setString(5, json.getString("web_address"));
            pstmt.setString(6, json.getString("password"));
            pstmt.setString(7, Utility.getCurrentDate());
            pstmt.setString(8, json.getString("user_name"));
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("updateClient():" + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("ClientServices/updateClient():" + e);
            }
        }
        return false;
    }

}
