/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobs.service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mahes
 */
public class Utility {

    public static String getCurrentDate() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            return "" + formatter.format(date);
        } catch (Exception e) {
        }
        return "";
    }
}
