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

/**
 *
 * @author NANDO1
 */
public class ClienteDAO implements CRUD{
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
      List<Cliente> lista = new ArrayList<>();
      String sql="select * from cliente";
       try{
        con = (com.mysql.jdbc.Connection) cn.Conectar();
        ps=(PreparedStatement) con.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            Cliente c=new Cliente();
            c.setId(rs.getInt(1));
            c.setDni(rs.getString(2));
            c.setNom(rs.getString(3));
            c.setDir(rs.getString(4));
            c.setEstado(rs.getString(5));
            lista.add(c);
        }
       }
       catch(Exception e)
       {
         
       }
       return lista;
    }

  
    public int add(Object[] oj) {
        int r=0;
        String sql="insert into cliente(Dni,Nombres,Direccion,Estado) values(?,?,?,?)";
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

    
    public int actualizar(Object[] oj) {
        int r=0;
        String sql="update cliente set Dni=?,Nombres=?,Direccion=?,Estado=? where IdCliente=?";
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
    String sql="delete from cliente  where IdCliente=?";
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
