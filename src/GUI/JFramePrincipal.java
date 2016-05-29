package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;

import com.toedter.calendar.JCalendar;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;

import Extras.ListaFontes;

import javax.swing.JEditorPane;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

@SuppressWarnings({"serial", "rawtypes", "unchecked"})
public class JFramePrincipal extends JFrame
{
	ListaFontes listafontes = new ListaFontes();
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable table;
	
	SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy");
	
	String dataFormatada;

	/**
	 * Método que inicia o programa
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{					
					JFramePrincipal frame = new JFramePrincipal();
					
					frame.setVisible(true);
				}
				catch (Exception e) { e.printStackTrace(); }
			}
		});
	}

	/**
	 * Cria a Janela
	 */
	public JFramePrincipal()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFramePrincipal.class.getResource("/Images/Logo Mr Limp.png")));
		setResizable(false);
		setTitle("Mr. Limp Juvevê");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 0, 0));
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setForeground(new Color(255, 255, 255));
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setForeground(new Color(255, 255, 255));
		mntmSair.setBackground(new Color(0, 0, 0));
		mnArquivo.add(mntmSair);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		mnAjuda.setForeground(new Color(255, 255, 255));
		menuBar.add(mnAjuda);
		
		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mntmAjuda.setBackground(new Color(0, 0, 0));
		mntmAjuda.setForeground(new Color(255, 255, 255));
		mnAjuda.add(mntmAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.setForeground(new Color(255, 255, 255));
		mntmSobre.setBackground(new Color(0, 0, 0));
		mnAjuda.add(mntmSobre);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 786, 100);
		panel.setPreferredSize(new Dimension(10, 100));
		panel.setBackground(new Color(222, 184, 135));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnCalendario = new JButton("");
		btnCalendario.setBounds(12, 5, 64, 64);
		btnCalendario.setBorder(null);
		btnCalendario.setBackground(new Color(222, 184, 135));
		btnCalendario.setIcon(new ImageIcon(JFramePrincipal.class.getResource("/Images/calendar.png")));
		panel.add(btnCalendario);
		
		JButton btnToDo = new JButton("");
		btnToDo.setBounds(120, 5, 64, 64);
		btnToDo.setIcon(new ImageIcon(JFramePrincipal.class.getResource("/Images/todo.png")));
		btnToDo.setBorder(null);
		btnToDo.setBackground(new Color(222, 184, 135));
		panel.add(btnToDo);
		
		JButton btnEventos = new JButton("");
		btnEventos.setBounds(228, 5, 64, 64);
		btnEventos.setIcon(new ImageIcon(JFramePrincipal.class.getResource("/Images/timetable.png")));
		btnEventos.setBackground(new Color(222, 184, 135));
		btnEventos.setBorder(null);
		panel.add(btnEventos);
		
		JButton btnContatos = new JButton("");
		btnContatos.setBounds(336, 5, 64, 64);
		btnContatos.setIcon(new ImageIcon(JFramePrincipal.class.getResource("/Images/booklet.png")));
		btnContatos.setBackground(new Color(222, 184, 135));
		btnContatos.setBorder(null);
		panel.add(btnContatos);
		
		JButton btnConfiguracoes = new JButton("");
		btnConfiguracoes.setBounds(444, 5, 64, 64);
		btnConfiguracoes.setIcon(new ImageIcon(JFramePrincipal.class.getResource("/Images/settings.png")));
		btnConfiguracoes.setBackground(new Color(222, 184, 135));
		btnConfiguracoes.setBorder(null);
		panel.add(btnConfiguracoes);
		
		JButton btnMYSQLDB = new JButton("");
		btnMYSQLDB.setBounds(552, 5, 64, 64);
		btnMYSQLDB.setIcon(new ImageIcon(JFramePrincipal.class.getResource("/Images/databasemysql.png")));
		btnMYSQLDB.setBorder(null);
		btnMYSQLDB.setBackground(new Color(222, 184, 135));
		panel.add(btnMYSQLDB);
		
		JLabel lblCalendrio = new JLabel("Calendário");
		lblCalendrio.setPreferredSize(new Dimension(75, 15));
		lblCalendrio.setBounds(8, 73, 85, 15);
		panel.add(lblCalendrio);
		
		JLabel lblRealizar = new JLabel("À Realizar");
		lblRealizar.setPreferredSize(new Dimension(80, 15));
		lblRealizar.setBounds(115, 73, 90, 15);
		panel.add(lblRealizar);
		
		JLabel lblEventos = new JLabel("Eventos");
		lblEventos.setBounds(232, 73, 70, 15);
		panel.add(lblEventos);
		
		JLabel lblContatos = new JLabel("Contatos");
		lblContatos.setBounds(335, 73, 70, 15);
		panel.add(lblContatos);
		
		JLabel lblConfiguraes = new JLabel("Configurações");
		lblConfiguraes.setBounds(435, 73, 102, 15);
		panel.add(lblConfiguraes);
		
		JLabel lblBancoDeDados = new JLabel("MySQL");
		lblBancoDeDados.setBounds(565, 73, 90, 15);
		panel.add(lblBancoDeDados);
		
		final JCalendar calendar = new JCalendar();
		calendar.getYearChooser().getSpinner().setFont(new Font("Dialog", Font.BOLD, 12));
		calendar.getDayChooser().getDayPanel().setBackground(new Color(222, 184, 135));
		calendar.setBounds(15, 117, 293, 159);
		contentPane.add(calendar);
		
		JScrollPane scrollPaneTabela = new JScrollPane();
		scrollPaneTabela.setBackground(new Color(222, 184, 135));
		scrollPaneTabela.setBorder(null);
		scrollPaneTabela.setBounds(15, 322, 293, 177);
		contentPane.add(scrollPaneTabela);
		
		table = new JTable();
		table.setShowGrid(false);
		table.setBackground(new Color(210, 180, 140));
		table.setBorder(null);
		scrollPaneTabela.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowHeight(30);
		table.setPreferredSize(new Dimension(244, 159));
		table.getTableHeader().setBackground(new Color(222, 184, 135));
		table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
				new Object[][] {
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
					},
			new String[] {"Nome", "Início", "Fim", "Obs"}) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setMinWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(45);
		table.getColumnModel().getColumn(2).setPreferredWidth(45);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.setAutoCreateRowSorter(true);
		
		JLabel lblCompromissosPara = new JLabel("Compromissos para:");
		lblCompromissosPara.setBounds(46, 295, 145, 15);
		contentPane.add(lblCompromissosPara);
		
		dataFormatada = formatoData.format(calendar.getDate()); // Arruma o formato de exibição da Data
		
		final JLabel lblDataSelecionada = new JLabel(dataFormatada);
		lblDataSelecionada.setBounds(203, 295, 80, 15);
		contentPane.add(lblDataSelecionada);
		
		JLabel lblNotasImportantes = new JLabel("Notas Importantes para:\n");
		lblNotasImportantes.setBounds(424, 117, 179, 15);
		contentPane.add(lblNotasImportantes);
		
		final JLabel lblDataSelecionada2 = new JLabel(dataFormatada);
		lblDataSelecionada2.setBounds(613, 117, 80, 15);
		contentPane.add(lblDataSelecionada2);
		
		JComboBox FontecomboBox = new JComboBox();
		FontecomboBox.setBounds(339, 145, 152, 24);
		FontecomboBox.setModel(new DefaultComboBoxModel(listafontes.getListaFontes()));
		contentPane.add(FontecomboBox);		
		
		JComboBox NumeroFontecomboBox = new JComboBox();
		NumeroFontecomboBox.setBounds(503, 144, 46, 24);
		NumeroFontecomboBox.setModel(new DefaultComboBoxModel(listafontes.getTamanhoFonte()));
		contentPane.add(NumeroFontecomboBox);
		
		JScrollPane scrollPaneNotas = new JScrollPane();
		scrollPaneNotas.setBorder(null);
		scrollPaneNotas.setBackground(new Color(222, 184, 135));
		scrollPaneNotas.setBounds(339, 181, 445, 318);
		contentPane.add(scrollPaneNotas);
		
		String fonte = FontecomboBox.getSelectedItem().toString();
		int tamanhoFonte = Integer.parseInt(NumeroFontecomboBox.getSelectedItem().toString());
		
		final JEditorPane textArea = new JEditorPane();
		textArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textArea.setFont(new Font(fonte, Font.BOLD, tamanhoFonte));
		scrollPaneNotas.setViewportView(textArea);
		
		JButton btnNegrito = new JButton("B");
		btnNegrito.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNegrito.setBackground(new Color(238, 238, 238));
		btnNegrito.setBounds(561, 144, 28, 25);
		contentPane.add(btnNegrito);
		
		JButton btnItalico = new JButton("I");
		btnItalico.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		btnItalico.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnItalico.setBackground(new Color(238, 238, 238));
		btnItalico.setBounds(602, 144, 28, 25);
		contentPane.add(btnItalico);
		
		JButton btnSublinhado = new JButton("U");
		btnSublinhado.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSublinhado.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSublinhado.setBackground(new Color(238, 238, 238));
		btnSublinhado.setBounds(644, 144, 28, 25);
		contentPane.add(btnSublinhado);
		
		/*
		 * A partir deste ponto são declarados todos os eventos deste frame
		 */
		mntmSair.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) { System.exit(0); }
		});
		
		calendar.addPropertyChangeListener("calendar", new PropertyChangeListener()
		{
			public void propertyChange(PropertyChangeEvent e)
			{
				Calendar c = (Calendar) e.getNewValue();
				
				String dia = Integer.toString(c.get(Calendar.DAY_OF_MONTH)); // Pega o dia do mës
				String mes = Integer.toString(c.get(Calendar.MONTH) + 1); // Pega o mës
				String ano = Integer.toString(c.get(Calendar.YEAR)); // Pega o ano
				
				if (dia.length() == 1) dia = "0" + dia;
				if (mes.length() == 1) mes = "0" + mes;
				
				String dataCompleta = dia + "-" + mes + "-" + ano;
				
				alterarDataLbl(lblDataSelecionada, lblDataSelecionada2, dataCompleta);
				
			}
		});
		
		btnContatos.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JContatos frameContatos = new JContatos();
				frameContatos.setVisible(true);
			}
		});
	}
	
	/**
	 * Método para trocar a data dos labels de Notas e Compromissos
	 */
	public void alterarDataLbl(JLabel lblData, JLabel lblNotas, String data)
	{
		lblData.setText(data);
		lblNotas.setText(data);
	}
}
