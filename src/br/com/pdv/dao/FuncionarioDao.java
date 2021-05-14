/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdv.dao;

import br.com.pdv.model.Cliente;
import br.com.pdv.model.Funcionario;
import conexaoJDBC.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author luis.dasilva
 */
public class FuncionarioDao {

    private Connection connection;

    public FuncionarioDao() {
        this.connection = new SingleConnection().getConnection();
    }
    
    
    // Metodo cadastrar funcionarios
    public void cadastrarFuncionarios(Funcionario funcionario) {
        try {
            //1-passo = criar comando sql
            String sql = "insert into tb_funcionarios(nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            //2-passo = conectar o banco de dados e organizar o comando sql
            PreparedStatement insert = connection.prepareStatement(sql);

            insert.setString(1, funcionario.getNome());
            insert.setString(2, funcionario.getRg());
            insert.setString(3, funcionario.getCpf());
            insert.setString(4, funcionario.getEmail());
            insert.setString(5, funcionario.getSenha());
            insert.setString(6, funcionario.getCargo());
             insert.setString(7, funcionario.getNivelAcesso());
            insert.setString(8, funcionario.getTelefone());
            insert.setString(9, funcionario.getCelular());
            insert.setString(10, funcionario.getCep());
            insert.setString(11, funcionario.getEndereco());
            insert.setInt(12, funcionario.getNumero());
            insert.setString(13, funcionario.getComplemento());
            insert.setString(14, funcionario.getBairro());
            insert.setString(15, funcionario.getCidade());
            insert.setString(16, funcionario.getUf());
            insert.execute();

            connection.commit();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no cadastro" + erro);
        }
    }
}
