
import conexaoJDBC.SingleConnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luis.dasilva
 */
public class TesteBnacoJDBC {
    
    public void initBanco(){
        SingleConnection.getConnection();
    }
}
