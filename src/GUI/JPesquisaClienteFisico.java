package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import BancoDeDados.Conexao;
import Controllers.CtrlCliente;
import Controllers.CtrlEndereco;
import Extras.ListaCidadesEstados;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JPesquisaClienteFisico extends JPanel {
	private JTextField textFieldNome;
	private JTextField textFieldRG;
	private JTextField textFieldEmail;
	private JTextField textFieldRua;
    private JTextField textFieldNumero;
    private JTextField textFieldComplemento;
    private JTextField textFieldBairro;
    private JTextField textFieldCidade;
    
	private JFormattedTextField formattedTextFieldCPF;
	private JFormattedTextField formattedTextFieldTelefone;
	private JFormattedTextField formattedTextFieldCelular;
    
    private MaskFormatter ftmTelefone;
    private MaskFormatter ftmCelular;
    private MaskFormatter ftmCPF;
    private MaskFormatter ftmCEP;
    
    ListaCidadesEstados listaCidadesEstados = new ListaCidadesEstados();

	/**
	 * Cria o Painel
	 * @throws ParseException 
	 */
	public JPesquisaClienteFisico() throws ParseException
	{
		/*
		 * Apenas cria os formatos corretos para os devidos campos
		 */
		ftmTelefone = new MaskFormatter("(##) ####-####");
        ftmTelefone.setValidCharacters("0123456789");
        
        ftmCelular = new MaskFormatter("(##) ####-####");
        ftmCelular.setValidCharacters("0123456789");
        
        ftmCPF = new MaskFormatter("###.###.###-##");
        ftmCPF.setValidCharacters("0123456789");
        
        ftmCEP = new MaskFormatter("#####-###");
        ftmCEP.setValidCharacters("0123456789");
		
		setLayout(null);
		this.setBackground(new Color(222, 184, 135));
		this.setBounds(0, 0, 594, 350);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabbedPane.setBounds(0, 0, 594, 301);
		add(tabbedPane);
		
		JPanel panelInfoGerais = new JPanel();
		panelInfoGerais.setBackground(new Color(222, 184, 135));
		tabbedPane.addTab("Informações Gerais", null, panelInfoGerais, null);
		panelInfoGerais.setLayout(null);
		
		JPanel panelEndereco = new JPanel();
		panelEndereco.setBackground(new Color(222, 184, 135));
		tabbedPane.addTab("Endereço", null, panelEndereco, null);
		panelEndereco.setLayout(null);
		
		final JComboBox<String> comboBoxSelecionaCliente = new JComboBox<String>();
		comboBoxSelecionaCliente.setModel(new DefaultComboBoxModel<String>(new Vector<String>(carregaListaClientesFisicos())));
		comboBoxSelecionaCliente.setBackground(new Color(222, 184, 135));
		comboBoxSelecionaCliente.setBounds(76, 11, 295, 20);
		panelInfoGerais.add(comboBoxSelecionaCliente);
		
		final JButton buttonSelecionar = new JButton("Selecionar");
		buttonSelecionar.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonSelecionar.setBackground(new Color(222, 184, 135));
		buttonSelecionar.setBounds(381, 11, 118, 23);
		panelInfoGerais.add(buttonSelecionar);
		
		JButton btnNovaConsulta = new JButton("Nova");
		btnNovaConsulta.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNovaConsulta.setBackground(new Color(222, 184, 135));
		btnNovaConsulta.setBounds(509, 11, 70, 23);
		panelInfoGerais.add(btnNovaConsulta);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(10, 60, 46, 14);
		panelInfoGerais.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setEditable(false);
		textFieldNome.setForeground(Color.WHITE);
		textFieldNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldNome.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textFieldNome.setBackground(new Color(222, 184, 135));
		textFieldNome.setBounds(76, 60, 503, 20);
		panelInfoGerais.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRg.setBounds(10, 90, 46, 14);
		panelInfoGerais.add(lblRg);
		
		textFieldRG = new JTextField();
		textFieldRG.setEditable(false);
		textFieldRG.setForeground(Color.WHITE);
		textFieldRG.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldRG.setColumns(10);
		textFieldRG.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textFieldRG.setBackground(new Color(222, 184, 135));
		textFieldRG.setBounds(76, 90, 180, 20);
		panelInfoGerais.add(textFieldRG);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(325, 90, 46, 14);
		panelInfoGerais.add(lblCpf);
		
		formattedTextFieldCPF = new JFormattedTextField(ftmCPF);
		formattedTextFieldCPF.setEditable(false);
		formattedTextFieldCPF.setForeground(Color.WHITE);
		formattedTextFieldCPF.setFont(new Font("Tahoma", Font.BOLD, 14));
		formattedTextFieldCPF.setColumns(10);
		formattedTextFieldCPF.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		formattedTextFieldCPF.setBackground(new Color(222, 184, 135));
		formattedTextFieldCPF.setBounds(399, 90, 180, 20);
		panelInfoGerais.add(formattedTextFieldCPF);
		
		JLabel labelTelefone = new JLabel("Telefone:");
		labelTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelTelefone.setBounds(10, 120, 64, 14);
		panelInfoGerais.add(labelTelefone);
		
		formattedTextFieldTelefone = new JFormattedTextField(ftmTelefone);
		formattedTextFieldTelefone.setEditable(false);
		formattedTextFieldTelefone.setForeground(Color.WHITE);
		formattedTextFieldTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
		formattedTextFieldTelefone.setColumns(10);
		formattedTextFieldTelefone.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		formattedTextFieldTelefone.setBackground(new Color(222, 184, 135));
		formattedTextFieldTelefone.setBounds(76, 120, 180, 20);
		panelInfoGerais.add(formattedTextFieldTelefone);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCelular.setBounds(325, 120, 70, 14);
		panelInfoGerais.add(lblCelular);
		
		formattedTextFieldCelular = new JFormattedTextField(ftmCelular);
		formattedTextFieldCelular.setEditable(false);
		formattedTextFieldCelular.setForeground(Color.WHITE);
		formattedTextFieldCelular.setFont(new Font("Tahoma", Font.BOLD, 14));
		formattedTextFieldCelular.setColumns(10);
		formattedTextFieldCelular.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		formattedTextFieldCelular.setBackground(new Color(222, 184, 135));
		formattedTextFieldCelular.setBounds(399, 120, 180, 20);
		panelInfoGerais.add(formattedTextFieldCelular);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(10, 150, 64, 14);
		panelInfoGerais.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setEditable(false);
		textFieldEmail.setText(" ");
		textFieldEmail.setForeground(Color.WHITE);
		textFieldEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textFieldEmail.setBackground(new Color(222, 184, 135));
		textFieldEmail.setBounds(76, 150, 503, 20);
		panelInfoGerais.add(textFieldEmail);
		
		JLabel lblObs = new JLabel("Obs:");
		lblObs.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblObs.setBounds(10, 210, 64, 14);
		panelInfoGerais.add(lblObs);
		
		final JTextPane textPaneObs = new JTextPane();
		textPaneObs.setEditable(false);
		textPaneObs.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		textPaneObs.setForeground(Color.WHITE);
		textPaneObs.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneObs.setBounds(76, 180, 503, 80);
		textPaneObs.setBackground(new Color(222, 184, 135));
		panelInfoGerais.add(textPaneObs);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCep.setBounds(10, 10, 46, 14);
		panelEndereco.add(lblCep);
		
		final JFormattedTextField formattedTextFieldCEP = new JFormattedTextField(ftmCEP);
		formattedTextFieldCEP.setEditable(false);
		formattedTextFieldCEP.setForeground(Color.WHITE);
		formattedTextFieldCEP.setFont(new Font("Tahoma", Font.BOLD, 14));
		formattedTextFieldCEP.setColumns(10);
		formattedTextFieldCEP.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		formattedTextFieldCEP.setBackground(new Color(222, 184, 135));
		formattedTextFieldCEP.setBounds(76, 10, 180, 20);
		panelEndereco.add(formattedTextFieldCEP);
		
		final JButton btnBuscarCep = new JButton("Buscar CEP");
		btnBuscarCep.setEnabled(false);
		btnBuscarCep.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscarCep.setBackground(new Color(222, 184, 135));
		btnBuscarCep.setBounds(274, 8, 115, 23);
		panelEndereco.add(btnBuscarCep);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRua.setBounds(10, 40, 46, 14);
		panelEndereco.add(lblRua);
		
		textFieldRua = new JTextField();
		textFieldRua.setEditable(false);
		textFieldRua.setForeground(Color.WHITE);
		textFieldRua.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldRua.setColumns(10);
		textFieldRua.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textFieldRua.setBackground(new Color(222, 184, 135));
		textFieldRua.setBounds(76, 39, 503, 20);
		panelEndereco.add(textFieldRua);
		
		JLabel labelNumero = new JLabel("N\u00FAmero:");
		labelNumero.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelNumero.setBounds(10, 70, 61, 14);
		panelEndereco.add(labelNumero);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setEditable(false);
		textFieldNumero.setForeground(Color.WHITE);
		textFieldNumero.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldNumero.setColumns(10);
		textFieldNumero.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textFieldNumero.setBackground(new Color(222, 184, 135));
		textFieldNumero.setBounds(76, 70, 60, 20);
		panelEndereco.add(textFieldNumero);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblComplemento.setBounds(279, 70, 110, 14);
		panelEndereco.add(lblComplemento);
		
		textFieldComplemento = new JTextField();
		textFieldComplemento.setEditable(false);
		textFieldComplemento.setForeground(Color.WHITE);
		textFieldComplemento.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldComplemento.setColumns(10);
		textFieldComplemento.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textFieldComplemento.setBackground(new Color(222, 184, 135));
		textFieldComplemento.setBounds(399, 70, 180, 20);
		panelEndereco.add(textFieldComplemento);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBairro.setBounds(10, 100, 61, 14);
		panelEndereco.add(lblBairro);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setEditable(false);
		textFieldBairro.setForeground(Color.WHITE);
		textFieldBairro.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldBairro.setColumns(10);
		textFieldBairro.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textFieldBairro.setBackground(new Color(222, 184, 135));
		textFieldBairro.setBounds(76, 100, 180, 20);
		panelEndereco.add(textFieldBairro);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEstado.setBounds(10, 130, 61, 14);
		panelEndereco.add(lblEstado);
		
		final JComboBox<String> comboBoxEstado = new JComboBox<String>();
		comboBoxEstado.setEnabled(false);
		comboBoxEstado.setBackground(new Color(222, 184, 135));
		comboBoxEstado.setModel(new DefaultComboBoxModel<String>(listaCidadesEstados.getListaEstados()));
		comboBoxEstado.setBounds(76, 130, 60, 20);
		panelEndereco.add(comboBoxEstado);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCidade.setBounds(10, 160, 61, 14);
		panelEndereco.add(lblCidade);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setEditable(false);
		textFieldCidade.setForeground(Color.WHITE);
		textFieldCidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldCidade.setColumns(10);
		textFieldCidade.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textFieldCidade.setBackground(new Color(222, 184, 135));
		textFieldCidade.setBounds(76, 160, 180, 20);
		panelEndereco.add(textFieldCidade);
		
		JButton buttonCancelar = new JButton("");
		buttonCancelar.setIcon(new ImageIcon(JCadastroClienteFisico.class.getResource("/Images/exit.png")));
		buttonCancelar.setBorder(null);
		buttonCancelar.setBounds(40, 308, 32, 32);
		buttonCancelar.setBackground(new Color(222, 184, 135));
		add(buttonCancelar);
		
		final JButton buttonEditar = new JButton("");
		buttonEditar.setEnabled(false);
		buttonEditar.setIcon(new ImageIcon(JPesquisaClienteFisico.class.getResource("/Images/change.png")));
		buttonEditar.setBorder(null);
		buttonEditar.setBounds(444, 308, 32, 32);
		buttonEditar.setBackground(new Color(222, 184, 135));
		add(buttonEditar);
		
		final JButton buttonSalvar = new JButton("");
		buttonSalvar.setEnabled(false);
		buttonSalvar.setIcon(new ImageIcon(JCadastroClienteFisico.class.getResource("/Images/save.png")));
		buttonSalvar.setBorder(null);
		buttonSalvar.setBounds(495, 308, 32, 32);
		buttonSalvar.setBackground(new Color(222, 184, 135));
		add(buttonSalvar);
		
		final JButton buttonExcluir = new JButton("");
		buttonExcluir.setIcon(new ImageIcon(JPesquisaClienteFisico.class.getResource("/Images/Trash.png")));
		buttonExcluir.setEnabled(false);
		buttonExcluir.setBorder(null);
		buttonExcluir.setBackground(new Color(222, 184, 135));
		buttonExcluir.setBounds(396, 308, 32, 32);
		add(buttonExcluir);
		
		/*
		 * A partir deste ponto são declarados todos os eventos deste frame
		 */
		buttonCancelar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
			}
		});
		
		buttonEditar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textFieldNome.setEditable(true);
		        textFieldRG.setEditable(true);
		        formattedTextFieldCPF.setEditable(true);
		        formattedTextFieldTelefone.setEditable(true);
		        formattedTextFieldCelular.setEditable(true);
		        textFieldEmail.setEditable(true);
		        formattedTextFieldCEP.setEditable(true);
		        textFieldRua.setEditable(true);
		        textFieldNumero.setEditable(true);
		        textFieldComplemento.setEditable(true);
		        textFieldBairro.setEditable(true);
		        textFieldCidade.setEditable(true);
		        comboBoxEstado.setEnabled(true);
		        textPaneObs.setEditable(true);
		        
		        buttonSalvar.setEnabled(true);
		        btnBuscarCep.setEnabled(true);
		        buttonExcluir.setEnabled(true);
		        
		        buttonEditar.setEnabled(false);
			}
		});
		
		btnBuscarCep.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				CtrlEndereco ctrl = new CtrlEndereco();
		        
		        ctrl.verificarCEP(formattedTextFieldCEP.getText());
		        
		        textFieldRua.setText(ctrl.getLogradouro());
		        textFieldBairro.setText(ctrl.getBairro());
		        textFieldCidade.setText(ctrl.getCidade());
		        comboBoxEstado.setSelectedItem(ctrl.getEstado());
			}
		});
		
		buttonSelecionar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
		        {
					CtrlCliente ctrl = new CtrlCliente();
					
		            String nome = comboBoxSelecionaCliente.getSelectedItem().toString();

		            java.sql.ResultSet rs = ctrl.consultar(criaSTMCliente(), nome);

		            while(rs.next())
		            {
		                textFieldNome.setText(rs.getString("nome"));
		                textFieldRG.setText(rs.getString("rg"));
		                formattedTextFieldCPF.setText(rs.getString("cpf"));
		                textFieldEmail.setText(rs.getString("email"));
		                textFieldRua.setText(rs.getString("logradouro"));
		                textFieldNumero.setText(rs.getString("numero"));
		                textFieldComplemento.setText(rs.getString("complemento"));
		                formattedTextFieldCEP.setText(rs.getString("cep"));
		                textFieldBairro.setText(rs.getString("bairro"));
		                textFieldCidade.setText(rs.getString("cidade"));
		                comboBoxEstado.setSelectedItem(rs.getString("estado"));
		                formattedTextFieldTelefone.setText(rs.getString("telefone"));
		                formattedTextFieldCelular.setText(rs.getString("celular"));
		                textPaneObs.setText(rs.getString("Observacoes"));
		            }   
		                
		            buttonEditar.setEnabled(true);
		            
		            buttonSelecionar.setEnabled(false);
		            comboBoxSelecionaCliente.setEnabled(false);
		        }
		        catch (Exception e) { JOptionPane.showMessageDialog(null, "Não Existe Cadastro!"); }
			}
		});
		
		btnNovaConsulta.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
		        {
		            comboBoxSelecionaCliente.setEnabled(true);
		            buttonSelecionar.setEnabled(true);
		            
		            buttonSalvar.setEnabled(false);
		            buttonEditar.setEnabled(false);
		            buttonExcluir.setEnabled(false);
		            
		            textFieldNome.setText("");
		            textFieldRG.setText("");
		            formattedTextFieldCPF.setText("");
		            formattedTextFieldTelefone.setText("");
		            formattedTextFieldCelular.setText("");
		            textFieldEmail.setText("");
		            textPaneObs.setText("");
		            formattedTextFieldCEP.setText("");
		            textFieldRua.setText("");
		            textFieldNumero.setText("");
		            textFieldComplemento.setText("");
		            textFieldBairro.setText("");
		            textFieldCidade.setText("");
		            comboBoxEstado.setSelectedIndex(0);
		            
		            textFieldNome.setEditable(false);
		            textFieldRG.setEditable(false);
		            formattedTextFieldCPF.setEditable(false);
		            formattedTextFieldTelefone.setEditable(false);
		            formattedTextFieldCelular.setEditable(false);
		            textFieldEmail.setEditable(false);
		            textPaneObs.setEditable(false);
		            formattedTextFieldCEP.setEditable(false);
		            textFieldRua.setEditable(false);
		            textFieldNumero.setEditable(false);
		            textFieldComplemento.setEditable(false);
		            textFieldBairro.setEditable(false);
		            textFieldCidade.setEditable(false);
		            comboBoxEstado.setEditable(false);
		        }
		        catch (Exception e1) { }
			}
		});
		
		buttonExcluir.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String nome = comboBoxSelecionaCliente.getSelectedItem().toString();
		        
		        try
		        {
		            CtrlCliente ctrl = new CtrlCliente();
		            
		            Object[] options = {"Sim","Não"};
		            
		           int resposta = JOptionPane.showOptionDialog(null, "Você está certo disso?", "",   
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		            
		            if(resposta == JOptionPane.YES_OPTION)
		            {
		                ctrl.excluir(criaSTMCliente(), nome);
		                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
		            }
		        }
		        catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Operacão não realizada!"); }
		        
		        catch (Exception e2) { JOptionPane.showMessageDialog(null, "Operacão não realizada!"); }
		        
		        setVisible(false);
			}
		});
		
		buttonSalvar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
		        {
		            CtrlCliente ctrl = new CtrlCliente();
		        
		            if (textFieldNome.getText().compareTo("") > 0)
		            {
		            	String nome_anterior = comboBoxSelecionaCliente.getSelectedItem().toString();
			            
			            ctrl.alterar(criaSTMCliente(), nome_anterior, textFieldNome.getText(), textFieldRG.getText(), formattedTextFieldCPF.getText(), textPaneObs.getText(), formattedTextFieldTelefone.getText(), formattedTextFieldCelular.getText(), textFieldEmail.getText(), formattedTextFieldCEP.getText(), textFieldBairro.getText(), textFieldCidade.getText(), textFieldRua.getText(), textFieldComplemento.getText(), comboBoxEstado.getSelectedItem().toString(), textFieldNumero.getText(), null);
			            
			            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
			        
			            setVisible(false);
		            }
		            
		            else JOptionPane.showMessageDialog(null, "Nome não pode ser nulo!");
		        }
		        catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Operacão não realizada!"); }
		        catch (Exception e2) { JOptionPane.showMessageDialog(null, "Operacão não realizada!"); }
			}
		});
	}
	
	/**
	 * Método para carregar todos os clientes físicos do Banco de Dados
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public List<String> carregaListaClientesFisicos()
	{
		try
        {
            CtrlCliente ctrl = new CtrlCliente();
        
			java.util.List<String> lista = new ArrayList<String>();
            
            lista = ctrl.carregaJListClienteFisico(criaSTMCliente());
            
            return lista;
        }
        catch (Exception e) { }
		
		return null;
	}

	/**
	 * Método para retornar o STM de consulta
	 * @return
	 * @throws SQLException
	 */
	public Statement criaSTMCliente() throws SQLException
	{
		Connection con = (Connection) Conexao.conectaAoBanco();

        Statement stm = (Statement) con.createStatement();
        
        return stm;
	}
}
