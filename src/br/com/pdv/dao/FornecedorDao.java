/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdv.dao;

import br.com.pdv.model.Cliente;
import br.com.pdv.model.Fornecedores;
import br.com.pdv.model.Funcionario;
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
public class FornecedorDao {
    
    private Connection connection;
    
    public FornecedorDao(){
         this.connection = new SingleConnection().getConnection();
    }
    
    
      // Metodo cadastrar fornecedores
    public void cadastrarFornecedor(Fornecedores fornecedor) {
        try {
            //1-passo = criar comando sql
            String sql = "insert into tb_fornecedores(nome,cnpj,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?)";

            //2-passo = conectar o banco de dados e organizar o comando sql
            PreparedStatement insert = connection.prepareStatement(sql);

            insert.setString(1, fornecedor.getNome());
            insert.setString(2, fornecedor.getCnpj());
            insert.setString(3, fornecedor.getEmail());
            insert.setString(4, fornecedor.getTelefone());
            insert.setString(5, fornecedor.getCelular());
            insert.setString(6, fornecedor.getCep());
            insert.setString(7, fornecedor.getEndereco());
            insert.setInt(8, fornecedor.getNumero());
            insert.setString(9, fornecedor.getComplemento());
            insert.setString(10, fornecedor.getBairro());
            insert.setString(11, fornecedor.getCidade());
            insert.setString(12, fornecedor.getUf());
            insert.execute();

            connection.commit();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no cadastro" + erro);
        }
    }
    
    
    
      // metodo excluir fornecedores
    public void excluirFornecedores(Fornecedores obj) {
        try {

            // criar comando sql
            String sql = "delete from tb_fornecedores where id = ?";

            // conectar com banco e organizar comandos sql
            PreparedStatement excluir = connection.prepareStatement(sql);
            excluir.setInt(1, obj.getId());
            excluir.execute();

            connection.commit();

            JOptionPane.showMessageDialog(null, "Fornecedor excluido com sucesso");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir fornecedores" + erro);
        }

    }
    
     // Metodo alterar fornecedores
    public void alterarFornecedores(Fornecedores obj) {
        try {
            //1-passo = criar comando sql
            String sql = "update tb_fornecedores set nome=?,cnpj=?,email=?,telefone=?,celular=?,cep=?,endereco=?,"
                    + "numero=?,complemento=?,bairro=?,cidade=?,estado=? where id=?";

            //2-passo = conectar o banco de dados e organizar o comando sql
            PreparedStatement insert = connection.prepareStatement(sql);

          insert.setString(1, obj.getNome());
            insert.setString(2, obj.getCnpj());
            insert.setString(3, obj.getEmail());
            insert.setString(4, obj.getTelefone());
            insert.setString(5, obj.getCelular());
            insert.setString(6, obj.getCep());
            insert.setString(7, obj.getEndereco());
            insert.setInt(8, obj.getNumero());
            insert.setString(9, obj.getComplemento());
            insert.setString(10, obj.getBairro());
            insert.setString(11, obj.getCidade());
            insert.setString(12, obj.getUf());
            insert.setInt(13, obj.getId());
            insert.execute();

            connection.commit();
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar cadastro" + erro);
        }
    }
     // Listar todos os fornecedores
    public List<Fornecedores> listarFornecedoreses() {
        try {
            // criar lista
            List<Fornecedores> lista = new ArrayList<>();

            // criar comando sql
            String sql = "select * from tb_fornecedores ";

            // organizar SQL
            PreparedStatement listarTodos = connection.prepareStatement(sql);
            ResultSet resultado = listarTodos.executeQuery();

            while (resultado.next()) {
                Fornecedores fornecedores = new Fornecedores();
                fornecedores.setId(resultado.getInt("id"));
                fornecedores.setNome(resultado.getString("nome"));
                fornecedores.setCnpj(resultado.getString("cnpj"));
                fornecedores.setEmail(resultado.getString("email"));
                fornecedores.setTelefone(resultado.getString("telefone"));
                fornecedores.setCelular(resultado.getString("celular"));
                fornecedores.setCep(resultado.getString("cep"));
                fornecedores.setEndereco(resultado.getString("endereco"));
                fornecedores.setNumero(resultado.getInt("numero"));
                fornecedores.setComplemento(resultado.getString("complemento"));
                fornecedores.setBairro(resultado.getString("bairro"));
                fornecedores.setCidade(resultado.getString("cidade"));
                fornecedores.setUf(resultado.getString("estado"));

                lista.add(fornecedores);

                connection.commit();
            }

            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar funcionarios" + erro);
            return null;
        }

    }
    
     // Listar fornecedor por nome
    public List<Fornecedores> buscarFornecedorPorNome(String nome) {
        try {
            // criar lista
            List<Fornecedores> lista = new ArrayList<>();

            // criar comando sql
            String sql = "select * from tb_fornecedores where nome like ? ";

            // organizar SQL
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, nome);

            ResultSet resultado = stm.executeQuery();

            while (resultado.next()) {
                Fornecedores fornecedores = new Fornecedores();
                fornecedores.setId(resultado.getInt("id"));
                fornecedores.setNome(resultado.getString("nome"));
                fornecedores.setCnpj(resultado.getString("cnpj"));
                fornecedores.setEmail(resultado.getString("email"));
                fornecedores.setTelefone(resultado.getString("telefone"));
                fornecedores.setCelular(resultado.getString("celular"));
                fornecedores.setCep(resultado.getString("cep"));
                fornecedores.setEndereco(resultado.getString("endereco"));
                fornecedores.setNumero(resultado.getInt("numero"));
                fornecedores.setComplemento(resultado.getString("complemento"));
                fornecedores.setBairro(resultado.getString("bairro"));
                fornecedores.setCidade(resultado.getString("cidade"));
                fornecedores.setUf(resultado.getString("estado"));

                lista.add(fornecedores);

                connection.commit();
            }

            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar fornecedores" + erro);
            return null;
        }

    }
    
     // Consultar fornecedore por nome
    public Fornecedores consultarFornecedorPorNome(String nome) {
        try {

            // criar comando sql
            String sql = "select * from tb_fornecedores where nome = ? ";

            // organizar SQL
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, nome);
            ResultSet resultado = stm.executeQuery();

            Fornecedores fornecedor = new Fornecedores();
            if (resultado.next()) {
                fornecedor.setId(resultado.getInt("id"));
                fornecedor.setNome(resultado.getString("nome"));
                fornecedor.setCnpj(resultado.getString("cnpj"));
                fornecedor.setEmail(resultado.getString("email"));
                fornecedor.setTelefone(resultado.getString("telefone"));
                fornecedor.setCelular(resultado.getString("celular"));
                fornecedor.setCep(resultado.getString("cep"));
                fornecedor.setEndereco(resultado.getString("endereco"));
                fornecedor.setNumero(resultado.getInt("numero"));
                fornecedor.setComplemento(resultado.getString("complemento"));
                fornecedor.setBairro(resultado.getString("bairro"));
                fornecedor.setCidade(resultado.getString("cidade"));
                fornecedor.setUf(resultado.getString("estado"));
            }
            return fornecedor;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, " Fornecedor nao encontrado " + erro);
            return null;
        }

    }
}
