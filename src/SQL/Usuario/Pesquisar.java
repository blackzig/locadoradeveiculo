/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadoradeveiculo.conexao.Conexao;
import modelo.Usuario;

/**
 *
 * @author Michel
 */
public class Pesquisar {

    Connection con = null;
    List<Usuario> listaUsuario = new ArrayList<>();

    public Pesquisar() {
        con = Conexao.conectar();
    }

    public Boolean login(Usuario u) throws SQLException {
        Boolean existe = false;
        ResultSet rs = null;
        try {
            String sql = "select * from usuario where usuario=? and senha=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getSenha());

            rs = ps.executeQuery();
            while (rs.next()) {
                existe = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro login " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return existe;
    }

    public List<Usuario> todosOsUsuarios() throws SQLException {
        ResultSet rs = null;
        try {
            String sql = "select * from usuario";
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");

                Usuario u = new Usuario();
                u.setNome(nome);
                u.setEmail(email);
                listaUsuario.add(u);
            }
            return listaUsuario;
        } catch (SQLException e) {
            System.out.println("Erro todosOsUsuarios " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return null;
    }

}
