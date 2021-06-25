/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdv.dao;

import br.com.pdv.model.Cliente;
import br.com.pdv.model.Funcionario;
import br.com.pdv.view.FrmLogin;
import br.com.pdv.view.FrmMenu;
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
    
     // Listar todos os funcionarios
    public List<Funcionario> listarFuncionarios() {
        try {
            // criar lista
            List<Funcionario> lista = new ArrayList<>();

            // criar comando sql
            String sql = "select * from tb_funcionarios ";

            // organizar SQL
            PreparedStatement listarTodos = connection.prepareStatement(sql);
            ResultSet resultado = listarTodos.executeQuery();

            while (resultado.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(resultado.getInt("id"));
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setRg(resultado.getString("rg"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setEmail(resultado.getString("email"));
                funcionario.setSenha(resultado.getString("senha"));
                funcionario.setCargo(resultado.getString("cargo"));
                funcionario.setNivelAcesso(resultado.getString("nivel_acesso"));
                funcionario.setTelefone(resultado.getString("telefone"));
                funcionario.setCelular(resultado.getString("celular"));
                funcionario.setCep(resultado.getString("cep"));
                funcionario.setEndereco(resultado.getString("endereco"));
                funcionario.setNumero(resultado.getInt("numero"));
                funcionario.setComplemento(resultado.getString("complemento"));
                funcionario.setBairro(resultado.getString("bairro"));
                funcionario.setCidade(resultado.getString("cidade"));
                funcionario.setUf(resultado.getString("estado"));

                lista.add(funcionario);

                connection.commit();
            }

            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar funcionarios" + erro);
            return null;
        }

    }
    
    
      // metodo excluir funcionario
    public void excluirFuncionario(Funcionario obj) {
        try {

            // criar comando sql
            String sql = "delete from tb_funcionarios where id = ?";

            // conectar com banco e organizar comandos sql
            PreparedStatement excluir = connection.prepareStatement(sql);
            excluir.setInt(1, obj.getId());
            excluir.execute();

            connection.commit();

            JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir clientes" + erro);
        }

    }
    
    // Metodo alterar funcionario
    public void alterarFuncionario(Funcionario obj) {
        try {
            //1-passo = criar comando sql
            String sql = "update tb_funcionarios set nome=?,rg=?,cpf=?,email=?,senha=?,cargo=?,nivel_acesso=?,telefone=?,celular=?,cep=?,endereco=?,"
                    + "numero=?,complemento=?,bairro=?,cidade=?,estado=? where id=?";

            //2-passo = conectar o banco de dados e organizar o comando sql
            PreparedStatement insert = connection.prepareStatement(sql);

            insert.setString(1, obj.getNome());
            insert.setString(2, obj.getRg());
            insert.setString(3, obj.getCpf());
            insert.setString(4, obj.getEmail());
            insert.setString(5, obj.getSenha());
            insert.setString(6, obj.getCargo());
            insert.setString(7, obj.getNivelAcesso());          
            insert.setString(8, obj.getTelefone());
            insert.setString(9, obj.getCelular());
            insert.setString(10, obj.getCep());
            insert.setString(11, obj.getEndereco());
            insert.setInt(12, obj.getNumero());
            insert.setString(13, obj.getComplemento());
            insert.setString(14, obj.getBairro());
            insert.setString(15, obj.getCidade());
            insert.setString(16, obj.getUf());
            insert.setInt(17, obj.getId());
            insert.execute();

            connection.commit();
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar cadastro" + erro);
        }
    }
    
     // Consultar funcionario por nome
    public Funcionario consultarFuncionarioPorNome(String nome) {
        try {

            // criar comando sql
            String sql = "select * from tb_funcionarios where nome = ? ";

            // organizar SQL
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, nome);
            ResultSet resultado = stm.executeQuery();

            Funcionario funcionario = new Funcionario();
            if (resultado.next()) {
                funcionario.setId(resultado.getInt("id"));
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setRg(resultado.getString("rg"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setEmail(resultado.getString("email"));
                funcionario.setSenha(resultado.getString("senha"));
                funcionario.setCargo(resultado.getString("cargo"));
                funcionario.setNivelAcesso(resultado.getString("nivel_acesso"));
                funcionario.setTelefone(resultado.getString("telefone"));
                funcionario.setCelular(resultado.getString("celular"));
                funcionario.setCep(resultado.getString("cep"));
                funcionario.setEndereco(resultado.getString("endereco"));
                funcionario.setNumero(resultado.getInt("numero"));
                funcionario.setComplemento(resultado.getString("complemento"));
                funcionario.setBairro(resultado.getString("bairro"));
                funcionario.setCidade(resultado.getString("cidade"));
                funcionario.setUf(resultado.getString("estado"));
            }
            return funcionario;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, " Funcionario nao encontrado " + erro);
            return null;
        }

    }
    
    // Listar funcionario por nome
    public List<Funcionario> buscarFuncionarioPorNome(String nome) {
        try {
            // criar lista
            List<Funcionario> lista = new ArrayList<>();

            // criar comando sql
            String sql = "select * from tb_funcionarios where nome like ? ";

            // organizar SQL
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, nome);

            ResultSet resultado = stm.executeQuery();

            while (resultado.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(resultado.getInt("id"));
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setRg(resultado.getString("rg"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setEmail(resultado.getString("email"));
                funcionario.setSenha(resultado.getString("senha"));
                funcionario.setCargo(resultado.getString("cargo"));
                funcionario.setNivelAcesso(resultado.getString("nivel_acesso"));
                funcionario.setTelefone(resultado.getString("telefone"));
                funcionario.setCelular(resultado.getString("celular"));
                funcionario.setCep(resultado.getString("cep"));
                funcionario.setEndereco(resultado.getString("endereco"));
                funcionario.setNumero(resultado.getInt("numero"));
                funcionario.setComplemento(resultado.getString("complemento"));
                funcionario.setBairro(resultado.getString("bairro"));
                funcionario.setCidade(resultado.getString("cidade"));
                funcionario.setUf(resultado.getString("estado"));

                lista.add(funcionario);

                connection.commit();
            }

            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar funcionario" + erro);
            return null;
        }

    }
    
    // metodo efetuar login
    public void efetuarLogin(String emial, String senha) {
        try {
            String sql = " select * from tb_funcionarios where email = ? and senha = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, emial);
            stm.setString(2, senha);
            
             ResultSet resultado = stm.executeQuery();
               if(resultado.next()) {
                   
                   //Caso o usuario seja do tipo ADM
                   if(resultado.getString("nivel_acesso").equalsIgnoreCase("Administrador")){
                        JOptionPane.showMessageDialog(null,"Seja bem vindo ao sistema");                 
                        FrmMenu frmMenu = new FrmMenu();
                        frmMenu.usuarioLogado = resultado.getString("nome");
                        frmMenu.setVisible(true);
                   }
                   // Caso o usuario seja do tipo limitado
                   else if(resultado.getString("nivel_acesso").equalsIgnoreCase("Usuário")){
                        JOptionPane.showMessageDialog(null,"Seja bem vindo ao sistema");                 
                        FrmMenu frmMenu = new FrmMenu();
                        frmMenu.usuarioLogado = resultado.getString("nome");
                        
                        //Desabilitar os menus
                        frmMenu.menuPosicaoDoDia.setEnabled(false);
                        frmMenu.menuHistoricoVendas.setEnabled(false);
                        frmMenu.setVisible(true);
                   }
                  
                   
               }else {
                   JOptionPane.showMessageDialog(null,"Usuário nao localizado");
                   new FrmLogin().setVisible(true);
               }


        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro: " + erro);
        }
    }

}
