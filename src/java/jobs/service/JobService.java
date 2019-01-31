/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jobs.db.DbConnection;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author mahes
 */
public class JobService {

    ResultSet rs;
    static Connection conn;
    PreparedStatement pstmt;
    JSONArray jSONArray;

    
    static {
        conn = DbConnection.connect();
    }
    
    public JSONArray getAllJobs() {
        try {
            pstmt = conn.prepareStatement("select * from job_data");
            rs = pstmt.executeQuery();
            jSONArray = new JSONArray();
            while (rs.next()) {
                JSONObject json = new JSONObject();
                json.put("id", rs.getInt("id"));
                json.put("title", rs.getString("title"));
                json.put("location", rs.getString("location"));
                json.put("type", rs.getString("type"));
                json.put("qualification", rs.getString("qualification"));
                json.put("experience", rs.getString("experience"));
                json.put("skills", rs.getString("skills"));
                json.put("description", rs.getString("description"));
                json.put("start_date_time", rs.getString("start_date_time"));
                json.put("end_date_time", rs.getString("end_date_time"));
                json.put("budget", rs.getString("budget"));
                json.put("job_client_id", rs.getString("job_client_id"));
                json.put("created_at", rs.getString("created_at"));
                json.put("updated_at", rs.getString("updated_at"));
                jSONArray.put(json);

            }

        } catch (Exception e) {
            System.out.println("getAllJobs() :" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("JobServices/getAllJobs(): " + e);
            }
        }
        return jSONArray;
    }

    public JSONArray getAllJobsByClient(int id) {
        try {
            pstmt = conn.prepareStatement("select * from job_data where job_client_id=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            jSONArray = new JSONArray();
            while (rs.next()) {
                JSONObject json = new JSONObject();
                json.put("id", rs.getInt("id"));
                json.put("title", rs.getString("title"));
                json.put("location", rs.getString("location"));
                json.put("type", rs.getString("type"));
                json.put("qualification", rs.getString("qualification"));
                json.put("experience", rs.getString("experience"));
                json.put("skills", rs.getString("skills"));
                json.put("description", rs.getString("description"));
                json.put("start_date_time", rs.getString("start_date_time"));
                json.put("end_date_time", rs.getString("end_date_time"));
                json.put("budget", rs.getString("budget"));
                json.put("job_client_id", rs.getString("job_client_id"));
                json.put("created_at", rs.getString("created_at"));
                json.put("updated_at", rs.getString("updated_at"));
                jSONArray.put(json);

            }

        } catch (Exception e) {
            System.out.println("getAllJobsByClient() :" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("JobServices/getAllJobsByClient(): " + e);
            }
        }
        return jSONArray;
    }

    public boolean addJob(String objbean) {
        try {
            JSONObject json = new JSONObject(objbean);
            
            pstmt = conn.prepareStatement("insert into job_data(title,location,type,qualification,experience,skills,description,start_date_time,end_date_time,budget,job_client_id,created_at) values(?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, json.getString("title"));
            pstmt.setString(2, json.getString("location"));
            pstmt.setString(3, json.getString("type"));
            pstmt.setString(4, json.getString("qualification"));
            pstmt.setString(5, json.getString("experience"));
            pstmt.setString(6, json.getString("skills"));
            pstmt.setString(7, json.getString("description"));
            pstmt.setString(8, json.getString("start_date_time"));
            pstmt.setString(9, json.getString("end_date_time"));
            pstmt.setString(10, json.getString("budget"));
            pstmt.setString(11, json.getString("job_client_id"));
            pstmt.setString(12, Utility.getCurrentDate());

            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("JobServices/addJob(): " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("JobServices/AddJob(): " + e);
            }
        }
        return false;
    }

    public boolean updateJob(String objbean) {
        try {
            JSONObject json = new JSONObject(objbean);
            pstmt = conn.prepareStatement("update client_data set title=?,location=?,type=?,qualification=?,experience=?,skills=?,description=?,start_date_time=?,end_date_time=?,budget=?,updated_at=? where id=?");
            pstmt.setString(1, json.getString("title"));
            pstmt.setString(2, json.getString("location"));
            pstmt.setString(3, json.getString("type"));
            pstmt.setString(4, json.getString("qualification"));
            pstmt.setString(5, json.getString("experience"));
            pstmt.setString(6, json.getString("skills"));
            pstmt.setString(7, json.getString("description"));
            pstmt.setString(8, json.getString("start_date_time"));
            pstmt.setString(9, json.getString("end_date_time"));
            pstmt.setString(10, json.getString("budget"));
            pstmt.setString(11, Utility.getCurrentDate());
            pstmt.setInt(12, json.getInt("id"));

            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("JobServices/updateJob(): " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("JobServices/updateJob(): " + e);
            }
        }
        return false;
    }

    
    
}
