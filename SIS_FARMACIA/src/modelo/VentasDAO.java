/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author NANDO1
 */
public class VentasDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r=0;
    
    public String idVentas(){
        String idv="";
        String sql="select max(IdVentas) from ventas";
        try{
        con=(com.mysql.jdbc.Connection) cn.Conectar();
        ps=(PreparedStatement) con.prepareStatement(sql);
        rs=ps.executeQuery();

        while(rs.next()){
        idv=rs.getString(1);


        }
        }catch(Exception e){
        }
    return idv;
    }
    
    public int GuardarVentas(Ventas v){
        Ventas ventas= new Ventas();
        String sql="INSERT INTO ventas(idClientes,idVendedor,NumeroSerie,FechaVentas,Monto,Estado) VALUES(?,?,?,?,?,?)";
        try{
        con=(com.mysql.jdbc.Connection) cn.Conectar();
        ps=(PreparedStatement) con.prepareStatement(sql);
        ps.setInt(1, v.getIdCliente());
        ps.setInt(2, v.getIdVendedor());
        ps.setString(3, v.getSerie());
        ps.setString(4, v.getFecha());
        ps.setDouble(5, v.getMonto());
        ps.setString(6, v.getEstado());
        r=ps.executeUpdate();

        }catch(Exception e){
        }
    return r;
    
    }
    
    public int GuardarDetalleVentas(DetalleVentas dv){
        String sql="insert into detalle_ventas(idVentas,idProducto,Cantidad,PrecioVenta) values(?,?,?,?)";
        try{
        con=(com.mysql.jdbc.Connection) cn.Conectar();
        ps=(PreparedStatement) con.prepareStatement(sql);
        ps.setInt(1, dv.getIdVentas());
        ps.setInt(2, dv.getIdProductos());
        ps.setInt(3, dv.getCantidad());
        ps.setDouble(4, dv.getPreVenta());
        r=ps.executeUpdate();
        }catch(Exception e){
        }
    return r;
    }
}
