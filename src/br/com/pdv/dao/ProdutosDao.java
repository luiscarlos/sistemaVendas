/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdv.dao;

import br.com.pdv.model.Fornecedores;
import br.com.pdv.model.Produtos;
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
public class ProdutosDao {
    private Connection connection;
    
    public ProdutosDao(){
         this.connection = new SingleConnection().getConnection();
    }
    
    public void cadastrarProdutos(Produtos produto){
        try {
            String sql = "insert into tb_produtos (descricao,preco,qtd_estoque,for_id)values(?,?,?,?)";
            
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setString(1, produto.getDescricao());
            insert.setDouble(2, produto.getPreço());
            insert.setInt(3, produto.getQtd_estoque());
            insert.setInt(4, produto.getFornecedor().getId());
            
             insert.execute();

            connection.commit();
             JOptionPane.showMessageDialog(null, "produto cadastrado com sucesso");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produtos" + erro);
        }
    }
    
    public List<Produtos> listarProdutos(){
        try {
            List<Produtos> lista = new ArrayList<Produtos>();
            
            String sql = "select p.id,p.descricao,p.preco,p.qtd_estoque,f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id)";
            
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet resultado = stm.executeQuery();
            
            while (resultado.next()) {
               Produtos produto = new Produtos();
                Fornecedores fornecedor = new Fornecedores();
               
               produto.setId(resultado.getInt("p.id"));
               produto.setDescricao(resultado.getString("p.descricao"));
               produto.setPreço(resultado.getDouble("p.preco"));
               produto.setQtd_estoque(resultado.getInt("p.qtd_estoque"));
               
               fornecedor.setNome(resultado.getString("f.nome"));
               produto.setFornecedor(fornecedor);
               
               lista.add(produto);
                
            }
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos " + erro);
            return null;
        }
    }
    
    public void alterarProdutos(Produtos produto){
        try {
            
            String sql = "update tb_produtos set descricao = ?, preco = ?, qtd_estoque = ?, for_id = ? where id = ?";
            
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setString(1, produto.getDescricao());
            insert.setDouble(2, produto.getPreço());
            insert.setInt(3, produto.getQtd_estoque());
            insert.setInt(4, produto.getFornecedor().getId());
            
            insert.setInt(5, produto.getId());
            
             insert.execute();

            connection.commit();
             JOptionPane.showMessageDialog(null, "produto alterado com sucesso");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar produtos" + erro);
        }
    }
    
      public void excluirProdutos(Produtos obj) {
        try {

            // criar comando sql
            String sql = "delete  from tb_produtos where id = ?";

            // conectar com banco e organizar comandos sql
            PreparedStatement excluir = connection.prepareStatement(sql);
            excluir.setInt(1, obj.getId());
            excluir.execute();

            connection.commit();

            JOptionPane.showMessageDialog(null, "Produto excluido com sucesso");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Produto" + erro);
        }

    }
      
       
    public List<Produtos> listarProdutosPorNome(String nome){
        try {
            List<Produtos> lista = new ArrayList<Produtos>();
            
            String sql = "select p.id,p.descricao,p.preco,p.qtd_estoque,f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao like ?";
            
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, nome);
            ResultSet resultado = stm.executeQuery();
            
            while (resultado.next()) {
               Produtos produto = new Produtos();
                Fornecedores fornecedor = new Fornecedores();
               
               produto.setId(resultado.getInt("p.id"));
               produto.setDescricao(resultado.getString("p.descricao"));
               produto.setPreço(resultado.getDouble("p.preco"));
               produto.setQtd_estoque(resultado.getInt("p.qtd_estoque"));
               
               fornecedor.setNome(resultado.getString("f.nome"));
               produto.setFornecedor(fornecedor);
               
               lista.add(produto);
                
            }
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos " + erro);
            return null;
        }
    }
    
    public Produtos consultarProdutoPorNome(String nome){
        try {
      String sql = "select p.id,p.descricao,p.preco,p.qtd_estoque,f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao = ?";
            
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, nome);
            ResultSet resultado = stm.executeQuery();
            
            
            Produtos produto = new Produtos();
            Fornecedores fornecedor = new Fornecedores();
            if (resultado.next()) {           
               produto.setId(resultado.getInt("p.id"));
               produto.setDescricao(resultado.getString("p.descricao"));
               produto.setPreço(resultado.getDouble("p.preco"));
               produto.setQtd_estoque(resultado.getInt("p.qtd_estoque"));
               
               fornecedor.setNome(resultado.getString("f.nome"));
               produto.setFornecedor(fornecedor);              
            }
            return produto;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos " + erro);
            return null;
        }
    }
    
}

