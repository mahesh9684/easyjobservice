package jobs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jobs.db.DbConnection;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApplicantServices {

    ResultSet rs;
    static Connection conn;
    PreparedStatement pstmt;
    JSONArray jSONArray;

    static {
        conn = DbConnection.connect();
    }

    public JSONArray getAllApplicants() {
        try {
            pstmt = conn.prepareStatement("select * from applicant_data");
            rs = pstmt.executeQuery();
            jSONArray = new JSONArray();
            while (rs.next()) {
                JSONObject json = new JSONObject();
                json.put("id", rs.getInt("id"));
                json.put("name", rs.getString("name"));
                json.put("address", rs.getString("address"));
                json.put("contact", rs.getString("contact"));
                json.put("email_id", rs.getString("email_id"));
                json.put("qualification", rs.getString("qualification"));
                json.put("certification_training", rs.getString("certification_training"));
                json.put("experience", rs.getString("experience"));
                json.put("resume", rs.getString("resume"));
                json.put("job_type_preference", rs.getString("job_type_preference"));
                json.put("open_for_relocation", rs.getString("open_for_relocation"));
                json.put("current_salary", rs.getString("current_salary"));
                json.put("expected_salary", rs.getString("expected_salary"));
                json.put("created_at", rs.getString("created_at"));
                json.put("updated_at", rs.getString("updated_at"));
                jSONArray.put(json);

            }

        } catch (Exception e) {
            System.out.println("getAllApplicants() :" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("ApplicantServices/getAllApplicants(): " + e);
            }
        }
        return jSONArray;
    }

    public boolean addApplicant(String objbean) {
        try {
            JSONObject json = new JSONObject(objbean);
            pstmt = conn.prepareStatement("insert into applicant_data(name,address,contact,email_id,qualification,certification_training,experience,resume,user_name,password,job_type_preference,open_for_relocation,current_salary,expected_salary,created_at) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, json.getString("name"));
            pstmt.setString(2, json.getString("address"));
            pstmt.setString(4, json.getString("contact"));
            pstmt.setString(3, json.getString("email_id"));
            pstmt.setString(5, json.getString("qualification"));
            pstmt.setString(6, json.getString("certification_training"));
            pstmt.setString(7, json.getString("experience"));
            pstmt.setString(8, json.getString("resume"));
            pstmt.setString(9, json.getString("user_name"));
            pstmt.setString(10, json.getString("password"));
            pstmt.setString(11, json.getString("job_type_preference"));
            pstmt.setString(12, json.getString("open_for_relocation"));
            pstmt.setString(13, json.getString("current_salary"));
            pstmt.setString(14, json.getString("updated_salary"));
            pstmt.setString(15, Utility.getCurrentDate());

            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("addApplicant():" + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("ApplicantServices/AddApplicant():" + e);
            }
        }
        return false;
    }

    public String getApplicant(String user_name) {

        try {
            pstmt = conn.prepareStatement("select * from applicant_data where user_name=?");

            pstmt.setString(1, user_name);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                JSONObject json = new JSONObject();
                json.put("id", rs.getInt("id"));
                json.put("name", rs.getString("name"));
                json.put("address", rs.getString("address"));
                json.put("contact", rs.getString("contact"));
                json.put("email_id", rs.getString("email_id"));
                json.put("qualification", rs.getString("qualification"));
                json.put("certification_training", rs.getString("certification_training"));
                json.put("experience", rs.getString("experience"));
                json.put("resume", rs.getString("resume"));
                json.put("job_type_preference", rs.getString("job_type_preference"));
                json.put("open_for_relocation", rs.getString("open_for_relocation"));
                json.put("current_salary", rs.getString("current_salary"));
                json.put("expected_salary", rs.getString("expected_salary"));
                json.put("created_at", rs.getString("created_at"));
                json.put("updated_at", rs.getString("updated_at"));
                return json.toString();
            }

        } catch (Exception e) {
            System.out.println("getApplicant() :" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("ApplicantServices/getApplicant(): " + e);
            }
        }
        return "";
    }

    public boolean updateApplicant(String objbean) {
        try {
            JSONObject json = new JSONObject(objbean);
            pstmt = conn.prepareStatement("update applicant_data set name=?,address=?,contact=?,email_id=?,qualification=?,certification_training=?,experience=?,resume=?,password=?,job_type_preference=?,open_for_relocation=?,current_salary=?,updated_salary=?,updated_at=? where user_name=?");
            pstmt.setString(1, json.getString("name"));
            pstmt.setString(2, json.getString("address"));
            pstmt.setString(3, json.getString("contact"));
            pstmt.setString(4, json.getString("email_id"));
            pstmt.setString(5, json.getString("qualification"));
            pstmt.setString(6, json.getString("certification_training"));
            pstmt.setString(7, json.getString("experience"));
            pstmt.setString(8, json.getString("resume"));
            pstmt.setString(9, json.getString("password"));
            pstmt.setString(10, json.getString("job_type_preference"));
            pstmt.setString(11, json.getString("open_for_relocation"));
            pstmt.setString(12, json.getString("current_salary"));
            pstmt.setString(13, json.getString("updated_salary"));
            pstmt.setString(14, Utility.getCurrentDate());

            pstmt.setString(15, json.getString("user_name"));

            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("updateApplicant():" + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("ApplicantServices/updateApplicant():" + e);
            }
        }
        return false;
    }

}
