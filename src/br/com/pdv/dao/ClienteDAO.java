/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdv.dao;

import br.com.pdv.model.Cliente;
import conexaoJDBC.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author luis.dasilva
 */
public class ClienteDAO {
    
    private Connection connection;
    
    
    public ClienteDAO(){
        this.connection = new SingleConnection().getConnection();
    }

    // Metodo cadastrar clientes
    public void cadastrarClientes(Cliente cliente) {
        try {
            //1-passo = criar comando sql
            String sql = "insert into tb_clientes(nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

            //2-passo = conectar o banco de dados e organizar o comando sql
            PreparedStatement insert = connection.prepareStatement(sql);

            insert.setString(1, cliente.getNome());
            insert.setString(2, cliente.getRg());
            insert.setString(3, cliente.getCpf());
            insert.setString(4, cliente.getEmail());
            insert.setString(5, cliente.getTelefone());
            insert.setString(6, cliente.getCelular());
            insert.setString(7, cliente.getCep());
            insert.setString(8, cliente.getEndereco());
            insert.setInt(9, cliente.getNumero());
            insert.setString(10, cliente.getComplemento());
            insert.setString(11, cliente.getBairro());
            insert.setString(12, cliente.getCidade());
            insert.setString(13, cliente.getUf());
            insert.execute();

            connection.commit();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no cadastro" + erro);
        }
    }

    // Metodo alterar cliente
    public void alterarClientes(Cliente obj) {
         try {
            //1-passo = criar comando sql
            String sql = "update tb_clientes set nome=?,rg=?,cpf=?,email=?,telefone=?,celular=?,cep=?,endereco=?,"
                    + "numero=?,complemento=?,bairro=?,cidade=?,estado=? where id=?";
            

            //2-passo = conectar o banco de dados e organizar o comando sql
            PreparedStatement insert = connection.prepareStatement(sql);

            insert.setString(1, obj.getNome());
            insert.setString(2, obj.getRg());
            insert.setString(3, obj.getCpf());
            insert.setString(4, obj.getEmail());
            insert.setString(5, obj.getTelefone());
            insert.setString(6, obj.getCelular());
            insert.setString(7, obj.getCep());
            insert.setString(8, obj.getEndereco());
            insert.setInt(9, obj.getNumero());
            insert.setString(10, obj.getComplemento());
            insert.setString(11, obj.getBairro());
            insert.setString(12, obj.getCidade());
            insert.setString(13, obj.getUf());
            insert.setInt(14, obj.getId());
            insert.execute();

            connection.commit();
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar cadastro" + erro);
        }
    }

    // metodo excluir cliente
    public void excluirClientes(Cliente obj) {
        try {
            
            // criar comando sql
            String sql = "delete from tb_clientes where id = ?";
            
            // conectar com banco e organizar comandos sql
            PreparedStatement excluir = connection.prepareCall(sql);
            excluir.setInt(1, obj.getId());
            excluir.execute();
            
            connection.commit();
            
            JOptionPane.showMessageDialog(null,"Cliente excluido com sucesso");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir clientes" + erro);
        }

    }

    // metodo listar todos os clientes
    public List<Cliente> listarClientes() {
        try {
            // criar lista
            List<Cliente> lista = new ArrayList<>();

            // criar comando sql
            String sql = "select * from tb_clientes ";

            // organizar SQL
            PreparedStatement listarTodos = connection.prepareStatement(sql);
            ResultSet resultado = listarTodos.executeQuery();

            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultado.getInt("id"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setCelular(resultado.getString("celular"));
                cliente.setCep(resultado.getString("cep"));
                cliente.setEndereco(resultado.getString("endereco"));
                cliente.setNumero(resultado.getInt("numero"));
                cliente.setComplemento(resultado.getString("complemento"));
                cliente.setBairro(resultado.getString("bairro"));
                cliente.setCidade(resultado.getString("cidade"));
                cliente.setUf(resultado.getString("estado"));

                lista.add(cliente);

                connection.commit();
            }

            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes" + erro);
            return null;
        }

    }
         
    // Listar clientes por nome
    
     public List<Cliente> buscarClientesPorNome(String nome) {
        try {
            // criar lista
            List<Cliente> lista = new ArrayList<>();

            // criar comando sql
            String sql = "select * from tb_clientes where nome like ? ";

            // organizar SQL
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, nome);
            
            
            ResultSet resultado = stm.executeQuery();

            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultado.getInt("id"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setCelular(resultado.getString("celular"));
                cliente.setCep(resultado.getString("cep"));
                cliente.setEndereco(resultado.getString("endereco"));
                cliente.setNumero(resultado.getInt("numero"));
                cliente.setComplemento(resultado.getString("complemento"));
                cliente.setBairro(resultado.getString("bairro"));
                cliente.setCidade(resultado.getString("cidade"));
                cliente.setUf(resultado.getString("estado"));

                lista.add(cliente);

                connection.commit();
            }

            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes" + erro);
            return null;
        }

    }
    
     
}
