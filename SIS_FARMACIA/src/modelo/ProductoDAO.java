/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements CRUD{
    
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    Producto pro=new Producto();
    
    public Producto listarID(int id){
      Producto p=new Producto();
      String sql="select * from producto where Idproducto=?";
      try{
        con = (com.mysql.jdbc.Connection) cn.Conectar();
        ps=(PreparedStatement) con.prepareStatement(sql);
        ps.setInt(1, id);
        rs=ps.executeQuery();
        while(rs.next()){
        p.setId(rs.getInt(1));
        p.setNombres(rs.getString(2));
        p.setPrecio(rs.getDouble(3));
        p.setStock(rs.getInt(4));
        p.setEstado(rs.getString(15));
        }
       }
       catch(Exception e)
       {
         
       }
         return p;
    }
    //-----MANTENIMIENTO CRUD----///
    @Override
    public List listar() {
        List<Producto> lista = new ArrayList<>();
      String sql="select * from Producto";
       try{
        con = (com.mysql.jdbc.Connection) cn.Conectar();
        ps=(PreparedStatement) con.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            Producto p = new Producto();
            p.setId(rs.getInt(1));
            p.setNombres(rs.getString(2));
            p.setPrecio(rs.getDouble(3));
            p.setStock(rs.getInt(4));
            p.setEstado(rs.getString(5));
            lista.add(p);
        }
       }
       catch(Exception e)
       {
         
       }
       return lista;
    }

    @Override
   public int add(Object[] oj) {
        int r=0;
        String sql="insert into producto (Nombres,Precio,Stock,Estado) values(?,?,?,?)";
         try{
        con = (com.mysql.jdbc.Connection) cn.Conectar();
        ps=(PreparedStatement) con.prepareStatement(sql);
        ps.setObject(1, oj[0]);
        ps.setObject(2, oj[1]);
        ps.setObject(3, oj[2]);
        ps.setObject(4, oj[3]);
        r=ps.executeUpdate();
        
       }
       catch(Exception e)
       {
         
       }
         return r;
    }


    @Override
    public int actualizar(Object[] oj) {
       int r=0;
        String sql="update Producto set Nombres=?,Precio=?,Stock=?,Estado=? where IdProducto=?";
         try{
        con = (com.mysql.jdbc.Connection) cn.Conectar();
        ps=(PreparedStatement) con.prepareStatement(sql);
        ps.setObject(1, oj[0]);
        ps.setObject(2, oj[1]);
        ps.setObject(3, oj[2]);
        ps.setObject(4, oj[3]);
        ps.setObject(5, oj[4]);
        r=ps.executeUpdate();
        
       }
       catch(Exception e)
       {
         
       }
         return r;
    }

    @Override
    public void eliminar(int id) {
      String sql="delete from Producto where IdProducto=?";
       try{
        con = (com.mysql.jdbc.Connection) cn.Conectar();
        ps=(PreparedStatement) con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        
       }
       catch(Exception e)
       {
         
       }
    }
}
