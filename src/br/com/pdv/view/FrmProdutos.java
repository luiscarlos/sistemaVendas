/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdv.view;

import br.com.pdv.dao.ClienteDAO;
import br.com.pdv.dao.FornecedorDao;
import br.com.pdv.dao.ProdutosDao;
import br.com.pdv.dao.utilitarios.Utilitarios;
import br.com.pdv.model.Cliente;
import br.com.pdv.model.Fornecedores;
import br.com.pdv.model.Produtos;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis.dasilva
 */
public class FrmProdutos extends javax.swing.JFrame {
   
    
    public void listarProdutos() {
        ProdutosDao produtosDAO = new ProdutosDao();
        List<Produtos> listaProdutos = produtosDAO.listarProdutos();
        DefaultTableModel dados = (DefaultTableModel) tabelaFornecedor.getModel();
        dados.setNumRows(0);
        
        for(Produtos p: listaProdutos){
            dados.addRow(new Object[]{
                p.getId(),
                p.getDescricao(),
                p.getPreco(),
                p.getQtd_estoque(),
                p.getFornecedor().getNome()
      
            });
        }
        
    }
    /**
     * Creates new form FrmCliente
     */
    public FrmProdutos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tabelaConsultaProdutos = new javax.swing.JTabbedPane();
        PainelDadosPessoais = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbFornecedor = new javax.swing.JComboBox();
        btnBuscar = new javax.swing.JButton();
        txtQtaEstoque = new javax.swing.JTextField();
        PainelConsultaClientes = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtPesquisarNome = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFornecedor = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de produtos");
        setExtendedState(6);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastro de produtos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        PainelDadosPessoais.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Codigo:");

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Descri????o:");

        txtDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });

        txtPreco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Pre??o:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Qtd. Estoque:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Fornecedor: ");

        cbFornecedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbFornecedor.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbFornecedorAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cbFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbFornecedorMouseClicked(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscar.setText("Pesquisar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtQtaEstoque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout PainelDadosPessoaisLayout = new javax.swing.GroupLayout(PainelDadosPessoais);
        PainelDadosPessoais.setLayout(PainelDadosPessoaisLayout);
        PainelDadosPessoaisLayout.setHorizontalGroup(
            PainelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(24, 24, 24)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(PainelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelDadosPessoaisLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(12, 12, 12)
                                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtQtaEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49))
                            .addGroup(PainelDadosPessoaisLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(btnBuscar)))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        PainelDadosPessoaisLayout.setVerticalGroup(
            PainelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelDadosPessoaisLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(PainelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtQtaEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(194, Short.MAX_VALUE))
        );

        tabelaConsultaProdutos.addTab("Dados de produtos", PainelDadosPessoais);

        PainelConsultaClientes.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Nome:");

        txtPesquisarNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPesquisarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarNomeActionPerformed(evt);
            }
        });
        txtPesquisarNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisarNomeKeyPressed(evt);
            }
        });

        btnPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tabelaFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo:", "Descri????o:", "Pre??o:", "Qtd. Estoque:", "E-mail:", "Fornecedor:"
            }
        ));
        tabelaFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFornecedorMouseClicked(evt);
            }
        });
        tabelaFornecedor.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tabelaFornecedorComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaFornecedor);

        javax.swing.GroupLayout PainelConsultaClientesLayout = new javax.swing.GroupLayout(PainelConsultaClientes);
        PainelConsultaClientes.setLayout(PainelConsultaClientesLayout);
        PainelConsultaClientesLayout.setHorizontalGroup(
            PainelConsultaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelConsultaClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelConsultaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                    .addGroup(PainelConsultaClientesLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPesquisar)))
                .addContainerGap())
        );
        PainelConsultaClientesLayout.setVerticalGroup(
            PainelConsultaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelConsultaClientesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(PainelConsultaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtPesquisarNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabelaConsultaProdutos.addTab("Consulta de produtos", PainelConsultaClientes);

        btnNovo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditar.setText("Ediatr");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabelaConsultaProdutos)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(btnNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvar)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabelaConsultaProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(805, 584));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // Botao salvar 
     
            Produtos produto = new Produtos();
            produto.setDescricao(txtDescricao.getText());
            produto.setPreco(Double.parseDouble(txtPreco.getText()));
            produto.setQtd_estoque(Integer.parseInt(txtQtaEstoque.getText()));
           
            
            Fornecedores fornecedor = new Fornecedores();
            fornecedor = (Fornecedores) cbFornecedor.getSelectedItem();
        
            produto.setFornecedor(fornecedor);

            ProdutosDao produtoDAO = new ProdutosDao();
            produtoDAO.cadastrarProdutos(produto);
            
             Utilitarios utilitarios = new Utilitarios();
            utilitarios.LimparTela(PainelDadosPessoais);

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoActionPerformed

    private void txtPesquisarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarNomeActionPerformed

    private void tabelaFornecedorComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabelaFornecedorComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaFornecedorComponentShown

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // carrega lista
        listarProdutos();
        
    }//GEN-LAST:event_formWindowActivated

    private void tabelaFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFornecedorMouseClicked
                    // TODO add your handling code here:
                    tabelaConsultaProdutos.setSelectedIndex(0);
                    txtCodigo.setText(tabelaFornecedor.getValueAt(tabelaFornecedor.getSelectedRow(), 0).toString());
                    txtDescricao.setText(tabelaFornecedor.getValueAt(tabelaFornecedor.getSelectedRow(), 1).toString());
                    txtPreco.setText(tabelaFornecedor.getValueAt(tabelaFornecedor.getSelectedRow(), 2).toString());
                     txtQtaEstoque.setText(tabelaFornecedor.getValueAt(tabelaFornecedor.getSelectedRow(), 3).toString());
                    cbFornecedor.setSelectedItem(tabelaFornecedor.getValueAt(tabelaFornecedor.getSelectedRow(), 4).toString());
                    
                    Fornecedores fornecedor = new Fornecedores();
                    FornecedorDao fornecedorDao = new FornecedorDao();
                    
                    fornecedor = fornecedorDao.consultarFornecedorPorNome(tabelaFornecedor.getValueAt(tabelaFornecedor.getSelectedRow(), 5).toString());
                    cbFornecedor.removeAllItems();
                    cbFornecedor.getModel().setSelectedItem(fornecedor);
    }//GEN-LAST:event_tabelaFornecedorMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        
            Produtos produto = new Produtos();
            produto.setId(Integer.parseInt(txtCodigo.getText()));
            produto.setDescricao(txtDescricao.getText());
            produto.setPreco(Double.parseDouble(txtPreco.getText()));
            produto.setQtd_estoque(Integer.parseInt(txtQtaEstoque.getText()));
            
            Fornecedores fornecedor = new Fornecedores();
            fornecedor = (Fornecedores) cbFornecedor.getSelectedItem();

            produto.setFornecedor(fornecedor);
          
            ProdutosDao produtoDAO = new ProdutosDao();
            produtoDAO.alterarProdutos(produto);
             
            Utilitarios utilitarios = new Utilitarios();
            utilitarios.LimparTela(PainelDadosPessoais);
            
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
                    // TODO add your handling code here:
                    
            Produtos produto = new Produtos();
            produto.setId(Integer.parseInt(txtCodigo.getText()));

            ProdutosDao produtoDAO = new ProdutosDao();
            produtoDAO.excluirProdutos(produto);
            
             Utilitarios utilitarios = new Utilitarios();
             utilitarios.LimparTela(PainelDadosPessoais);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        
        
        String nome = "%" +txtPesquisarNome.getText()+"%";
        
        ProdutosDao produtoDAO = new ProdutosDao();
        List<Produtos> listaProdutos = produtoDAO.listarProdutosPorNome(nome);
        DefaultTableModel dados = (DefaultTableModel) tabelaFornecedor.getModel();
        dados.setNumRows(0);
        
        for(Produtos p: listaProdutos){
            dados.addRow(new Object[]{
                p.getId(),
                p.getDescricao(),
                p.getPreco(),
                p.getQtd_estoque(),
                p.getFornecedor(),
          
            });
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtPesquisarNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarNomeKeyPressed
        // TODO add your handling code here:
        String nome = "%" +txtPesquisarNome.getText()+"%";
         ProdutosDao produtoDAO = new ProdutosDao();
        List<Produtos> listaProdutos = produtoDAO.listarProdutosPorNome(nome);
        DefaultTableModel dados = (DefaultTableModel) tabelaFornecedor.getModel();
        dados.setNumRows(0);
           for(Produtos p: listaProdutos){
            dados.addRow(new Object[]{
                p.getId(),
                p.getDescricao(),
                p.getPreco(),
                p.getQtd_estoque(),
                p.getFornecedor(),
            });
        }
        
    }//GEN-LAST:event_txtPesquisarNomeKeyPressed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        Utilitarios utilitarios = new Utilitarios();
        utilitarios.LimparTela(PainelDadosPessoais);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        
            
            String descricao = txtDescricao.getText();
            ProdutosDao dao = new ProdutosDao();
            Produtos produtos = new Produtos();

            produtos = dao.consultarProdutoPorNome(descricao);
            
        if (produtos.getDescricao() != null) {
            txtCodigo.setText(String.valueOf(produtos.getId()));
            txtDescricao.setText(produtos.getDescricao());
            txtPreco.setText(String.valueOf(produtos.getPreco()));
            txtQtaEstoque.setText(String.valueOf(produtos.getQtd_estoque()));
            
            Fornecedores fornecedor = new Fornecedores();
            FornecedorDao fornecedorDao = new FornecedorDao();
                    
            cbFornecedor.getModel().setSelectedItem(fornecedor);
            }else{
            JOptionPane.showMessageDialog(null, "Cliente n??o encontrado");
        }

           

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cbFornecedorAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbFornecedorAncestorAdded
        // TODO add your handling code here:
        FornecedorDao fornecedorDao = new FornecedorDao();
        List<Fornecedores> listaFornecedores = fornecedorDao.listarFornecedoreses();
        
        cbFornecedor.removeAll(); // remove todos os itens do combobox
        for(Fornecedores f: listaFornecedores){
            cbFornecedor.addItem(f);
        }
    }//GEN-LAST:event_cbFornecedorAncestorAdded

    private void cbFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbFornecedorMouseClicked
        // TODO add your handling code here:
        FornecedorDao fornecedorDao = new FornecedorDao();
        List<Fornecedores> listaFornecedores = fornecedorDao.listarFornecedoreses();
        cbFornecedor.removeAll();
        
        for(Fornecedores f: listaFornecedores){
            cbFornecedor.addItem(f);
        }
    }//GEN-LAST:event_cbFornecedorMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelConsultaClientes;
    private javax.swing.JPanel PainelDadosPessoais;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTabbedPane tabelaConsultaProdutos;
    private javax.swing.JTable tabelaFornecedor;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtPesquisarNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQtaEstoque;
    // End of variables declaration//GEN-END:variables
}
