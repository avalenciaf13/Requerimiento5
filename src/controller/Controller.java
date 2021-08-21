package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Req1;
import model.Req2;
import model.Req3;
import services.Conector;

public class Controller {

    private ArrayList<String> req1s5;
    private ArrayList<String> req2s5;
    private ArrayList<String> req3s5;

    private Conector conectorDB;

    public Controller(String url) {
        super();
        req1s5 = new ArrayList<>();
        req2s5 = new ArrayList<>();
        req3s5 = new ArrayList<>();
        
        conectorDB = new Conector(url);
    }

    public void req15() {
        req1s5.clear();
        ResultSet rs = conectorDB.getReq1DB();        
        try {
            while (rs.next()) {
                Req1 req1 = new Req1(rs.getInt("total"), 
                rs.getInt("id_proyecto"), 
                rs.getString("pagado"), 
                rs.getString("proveedor"));
                req1s5.add(req1.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public void req25() {
        req2s5.clear();
        ResultSet rs = conectorDB.getReq2DB();      
        try {
            while(rs.next()){
                Req2 req2 = new Req2(rs.getString("Inicio"),
                rs.getInt("financiable"),
                rs.getInt("estrato"),
                rs.getDouble("Proyecto.Porcentaje_Cuota_Inicial * 100"));
                req2s5.add(req2.toString());
            }
        } catch (SQLException e) {
            System.out.println("ruta del error");
            e.printStackTrace();
        }
    }

    public void req35() {
        req3s5.clear();
        ResultSet rs = conectorDB.getReq3DB();      
        try {
            while(rs.next()){
                Req3 req3 = new Req3(rs.getInt("ID_Proyecto"),
                rs.getString("pagado"),
                rs.getString("clasificacion"));
                req3s5.add(req3.toString()); 
            }
        } catch (SQLException e) {
            System.out.println("ruta del error");
            e.printStackTrace();
        }
    }



    public ArrayList<String> getReq1s5() {
        return req1s5;
    }

    public void setReq1s5(ArrayList<String> req1s5) {
        this.req1s5 = req1s5;
    }

    public ArrayList<String> getReq2s5() {
        return req2s5;
    }

    public void setReq2s5(ArrayList<String> req2s5) {
        this.req2s5 = req2s5;
    }

    public ArrayList<String> getReq3s5() {
        return req3s5;
    }

    public void setReq3s5(ArrayList<String> req3s5) {
        this.req3s5 = req3s5;
    }


}