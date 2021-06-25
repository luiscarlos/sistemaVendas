/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdv.dao;


import br.com.pdv.model.Cliente;
import br.com.pdv.model.Vendas;
import conexaoJDBC.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.management.RuntimeErrorException;
import javax.swing.JOptionPane;

/**
 *
 * @author luis.dasilva
 */
public class VendasDao {
    
    
      private Connection connection;
    
    public VendasDao(){
         this.connection = new SingleConnection().getConnection();
    }
    
    
    //cADASTRAR VENDA
    public void cadastrarVenda(Vendas venda){
        try {
            String sql = "insert into tb_vendas(cliente_id, data_venda,total_venda, observacoes)values(?,?,?,?)";
            PreparedStatement inserte = connection.prepareCall(sql);
            
            inserte.setInt(1, venda.getCliente().getId());
            inserte.setString(2, venda.getData_venda());
            inserte.setDouble(3, venda.getTotal_venda());
            inserte.setString(4, venda.getObs());
            
            inserte.execute();
            connection.commit();
                    
                    

           JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no cadastro" + erro);
        }
    }
    //Retorna ultima venda
    
    public int retornaUltimaVenda(){
        try {
            
               int idVenda = 0;
             
             String query ="select max(id) id from tb_vendas";
             
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet resultado = ps.executeQuery();
             
             if(resultado.next()){
                 Vendas venda = new Vendas();
                 venda.setId(resultado.getInt("id"));
                 idVenda = venda.getId();
             }
             
             return idVenda;
             
            
            
         
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }
    
    
    // metodo que filtra vendas por data
    public List<Vendas> listarVendasPorPeriodo(LocalDate data_Inicio, LocalDate data_final) {
        try {
            List<Vendas> lista = new ArrayList<Vendas>();

            String sql = "select v.id, date_format(v.data_venda,'%d/%m/%y') as data_formatada, c.nome, v.total_venda, v.observacoes from tb_vendas as v "
                    + " inner join tb_clientes as c on(v.cliente_id = c.id) where v.data_venda BETWEEN ? AND ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, data_Inicio.toString());
            stm.setString(2, data_final.toString());
            
            ResultSet resultado = stm.executeQuery();

            while (resultado.next()) {
                Vendas venda = new Vendas();
                Cliente cliente = new Cliente();
                
                venda.setId(resultado.getInt("v.id"));
                venda.setData_venda(resultado.getString("data_formatada"));
                cliente.setNome(resultado.getString("c.nome"));
                venda.setTotal_venda(resultado.getDouble("v.total_venda"));
                venda.setObs(resultado.getString("v.observacoes"));
                venda.setCliente(cliente);

                

                lista.add(venda);

            }
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar historico " + erro);
            return null;
        }
    }
    
    // calcula total de vendas por data
    public double retorneTotalDavendaPorData(LocalDate data_venda){
        try {
            
            double totalVenda = 0;
            String sql = "select sum(total_venda)as total from tb_vendas where data_venda = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, data_venda.toString());
            ResultSet resultado = stm.executeQuery();
            
            if(resultado.next()){
                totalVenda = resultado.getDouble("total");
            }
            return totalVenda;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
