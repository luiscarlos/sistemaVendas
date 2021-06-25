/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdv.dao;

import br.com.pdv.model.Cliente;
import br.com.pdv.model.ItemVenda;
import br.com.pdv.model.Produtos;
import br.com.pdv.model.Vendas;
import conexaoJDBC.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author luis.dasilva
 */
public class ItemVendaDao {
    private Connection connection;

    public ItemVendaDao() {
        this.connection = new SingleConnection().getConnection();
    }
    
    
    public void cadastrarItem(ItemVenda itemVenda){
        try {
            
            String sql = "insert into tb_itensvendas (venda_id, produto_id,qtd,subtotal)values(?,?,?,?)";
            PreparedStatement insert = connection.prepareStatement(sql);
            
            insert.setInt(1, itemVenda.getVenda().getId());
            insert.setInt(2, itemVenda.getProduto().getId());
            insert.setInt(3, itemVenda.getQtd());
            insert.setDouble(4, itemVenda.getSubtotal());
            insert.execute();
            
             connection.commit();
           
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no cadastro" + erro);
        }
    }
    
    
    // metodo que lista itens de uma venda por id
    
     public List<ItemVenda> listarItemPorVenda(int venda_id) {
        try {
            List<ItemVenda> lista = new ArrayList<ItemVenda>();

            String query ="select i.id, p.descricao, i.qtd, p.preco, i.subtotal from tb_itensvendas as i inner join tb_produtos as p on(i.produto_id = p.id) where i.venda_id =?";

            PreparedStatement stm = connection.prepareStatement(query);
            stm.setInt(1, venda_id);
            ResultSet resultado = stm.executeQuery();

            while (resultado.next()) {
               ItemVenda item = new ItemVenda();
               Produtos produto = new Produtos();
    
               produto.setDescricao(resultado.getString("p.descricao"));
               item.setQtd(resultado.getInt("i.qtd"));
               produto.setPreco(resultado.getDouble("p.preco"));
               item.setSubtotal(resultado.getDouble("i.subtotal"));
               
               item.setProduto(produto);
               
                lista.add(item);

            }
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar detalhamento " + erro);
            return null;
        }
    }
}
