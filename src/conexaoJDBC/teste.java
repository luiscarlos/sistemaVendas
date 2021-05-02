/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaoJDBC;

import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author luis.dasilva
 */
public class teste {
    public static void main(String[] args) {
        try {
            SingleConnection.getConnection();
            JOptionPane.showMessageDialog(null,"conexao realizada com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ocorreu" + e);
        }
    }
}
