/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author NANDO1
 */
public interface CRUD {
    
    public List listar();
    public int add(Object[] oj);
    public int actualizar(Object[] oj);
    public void eliminar(int id);
    
    
}
