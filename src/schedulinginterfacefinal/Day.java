/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author andrewwarner
 */
public class Day {
    private String day;
    
    static private PreparedStatement getAllDays;
    static private PreparedStatement addDay;
    static private PreparedStatement getDayList;
    static private PreparedStatement clear;
    
    static {
        try {
            Connection connection = ConnectionClass.getConnection();
            getAllDays = connection.prepareStatement("SELECT DISTINCT * FROM Days");
            addDay = connection.prepareStatement("INSERT INTO Days (Day) VALUES (?)");
            getDayList = connection.prepareStatement("SELECT * FROM Days WHERE Day = ?");
            clear = connection.prepareStatement("DELETE FROM Days");
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }   
    }
    
    public Day(String day) {
        setDay(day);
    }
    
    /*
    Setters
    */
    public void setDay(String day) {
        this.day = day;
    }
    
    /*
    Getters
    */
    public String getDay() {
        return this.day;
    }
    
    /*
    SQL Queries
    */
    static public List< Day > getAllDays() {
        List< Day > results = null;
        ResultSet resultSet = null;
        
        try {
            resultSet = getAllDays.executeQuery();
            results = new ArrayList< Day >();
            
            while (resultSet.next()) {
                results.add(new Day(resultSet.getString("Day")));
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        finally {
            try {
                resultSet.close();
            }
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
                ConnectionClass.close();
            }
        }
        
        // Sort Days for JComboBox
        Collections.sort(results, new Comparator<Day>() {
            @Override
            public int compare(Day o1, Day o2) {
                return o1.getDay().compareTo(o2.getDay());
            }
        });

        return results;
    }
    
    static public List< Day > getDayList(String day) {
        List< Day > results = null;
        ResultSet resultSet = null;
        
        try {
            getDayList.setString(1, day);
            
            resultSet = getDayList.executeQuery();
            results = new ArrayList< Day >();
            
            while (resultSet.next()) {
                results.add(new Day(resultSet.getString("Day")));
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        finally {
            try {
                resultSet.close();
            }
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
                ConnectionClass.close();
            }
        }
        
        return results;
    }
    
    static public int addDay(String day) {
        int result = 0;
        
        try {
            addDay.setString(1, day);
            result = addDay.executeUpdate();   
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
            ConnectionClass.close();
        }
        
        return result;
    }

    
    @Override
    public String toString() {
        return this.day;
    }  
    
      static public void clear() {
        try {
            clear.execute();
        }
        catch (SQLException sqlException) {
            ConnectionClass.close();
        }
    }
}
