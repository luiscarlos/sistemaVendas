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
}

