/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdv.dao.utilitarios;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author luis.dasilva
 */
public class Utilitarios {
    public void LimparTela(JPanel container){
        Component componentes[] = container.getComponents();
        for(Component component: componentes ){
            if(component instanceof JTextField){
                ((JTextField)component).setText(null);
            }
        }
    }
}
