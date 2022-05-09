/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author rlarg
 */
public class Artist {
    private int id;
    private String name;
    
    public static ArrayList<Artist> getList() throws Exception{
        ArrayList<Artist> list = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        //O caminho do arquivo deve ser diferente se executado do seu PC
        //https://www.sqlitetutorial.net/sqlite-sample-database/
        String url = "jdbc:sqlite:C:\\Users\\Fatec\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from artists");
        while(rs.next()){
            int id = rs.getInt("ArtistId");
            String name = rs.getString("name");
            Artist a = new Artist(id, name);
            list.add(a);
        }
        rs.close();
        stmt.close();
        con.close();
        return list;
    }

    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }  
}