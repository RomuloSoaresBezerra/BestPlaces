package com.ifpb.bestplaces01.interfaces;


import com.ifpb.bestplaces01.daos.UsuarioDAO;
import com.ifpb.bestplaces01.entidades.Usuario;
import java.sql.SQLException;


public interface IAutenticavelUsuario {
    
    public default boolean autenticarUsuario(String email, String senha) 
            throws SQLException, ClassNotFoundException {
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario u = userDAO.read(email);
        if(u != null)
            return u.getEmail().equals(email) && u.getSenha().equals(senha);
        else return false;
    }
}

    