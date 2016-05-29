package GUI;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

@SuppressWarnings("serial")
public class JContatos extends JFrame
{
	private JPanel contentPane;

	/**
	 * Cria a Janela
	 */
	public JContatos()
	{
		setResizable(false);
		setTitle("Mr. Limp Juvevê - Contatos");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 0, 0));
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setForeground(new Color(255, 255, 255));
		menuBar.add(mnArquivo);
		
		JMenuItem mntmFechar = new JMenuItem("Fechar");
		mntmFechar.setForeground(new Color(255, 255, 255));
		mntmFechar.setBackground(new Color(0, 0, 0));
		mnArquivo.add(mntmFechar);
		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		mnCadastrar.setForeground(new Color(255, 255, 255));
		menuBar.add(mnCadastrar);
		
		JMenuItem mntmCadastroClienteFsico = new JMenuItem("Cliente Físico");
		mntmCadastroClienteFsico.setForeground(new Color(255, 255, 255));
		mntmCadastroClienteFsico.setBackground(new Color(0, 0, 0));
		mnCadastrar.add(mntmCadastroClienteFsico);
		
		JMenuItem mntmCadastroClienteJuridico = new JMenuItem("Cliente Jurídico");
		mntmCadastroClienteJuridico.setForeground(new Color(255, 255, 255));
		mntmCadastroClienteJuridico.setBackground(new Color(0, 0, 0));
		mnCadastrar.add(mntmCadastroClienteJuridico);
		
		JMenuItem mntmCadastroFornecedor = new JMenuItem("Fornecedor");
		mntmCadastroFornecedor.setForeground(new Color(255, 255, 255));
		mntmCadastroFornecedor.setBackground(new Color(0, 0, 0));
		mnCadastrar.add(mntmCadastroFornecedor);
		
		JMenu mnPesquisar = new JMenu("Pesquisar");
		mnPesquisar.setForeground(new Color(255, 255, 255));
		menuBar.add(mnPesquisar);
		
		JMenuItem mntmPesquisaClienteFisico = new JMenuItem("Cliente Físico");
		mntmPesquisaClienteFisico.setForeground(new Color(255, 255, 255));
		mntmPesquisaClienteFisico.setBackground(new Color(0, 0, 0));
		mnPesquisar.add(mntmPesquisaClienteFisico);
		
		JMenuItem mntmPesquisaClienteJuridico = new JMenuItem("Cliente Jurídico");
		mntmPesquisaClienteJuridico.setForeground(new Color(255, 255, 255));
		mntmPesquisaClienteJuridico.setBackground(new Color(0, 0, 0));
		mnPesquisar.add(mntmPesquisaClienteJuridico);
		
		JMenuItem mntmPesquisaFornecedor = new JMenuItem("Fornecedor");
		mntmPesquisaFornecedor.setForeground(new Color(255, 255, 255));
		mntmPesquisaFornecedor.setBackground(new Color(0, 0, 0));
		mnPesquisar.add(mntmPesquisaFornecedor);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * A partir deste ponto são declarados todos os eventos deste frame
		 */
		mntmFechar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) { setVisible(false); }
		});
		
		mntmCadastroClienteFsico.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JCadastroClienteFisico panel;
				
				try
				{
					panel = new JCadastroClienteFisico();
					panel.setBounds(0, 0, 594, 350);
					setContentPane(panel);
				}
				catch (ParseException e1)
				{
					JOptionPane.showMessageDialog(null, "Erro ao Tentar abrir Janela de Cadastros!");
				}
			}
		});
		
		mntmCadastroClienteJuridico.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JCadastroClienteJuridico panel;
				
				try
				{
					panel = new JCadastroClienteJuridico();
					panel.setBounds(0, 0, 594, 350);
					setContentPane(panel);
				}
				catch (ParseException e1)
				{
					JOptionPane.showMessageDialog(null, "Erro ao Tentar abrir Janela de Cadastro!");
				}
			}
		});
		
		mntmCadastroFornecedor.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JCadastroFornecedor panel;
				
				try
				{
					panel = new JCadastroFornecedor();
					panel.setBounds(0, 0, 594, 350);
					setContentPane(panel);
				}
				catch (ParseException e1)
				{
					JOptionPane.showMessageDialog(null, "Erro ao Tentar abrir Janela de Cadastro!");
				}
			}
		});
		
		mntmPesquisaClienteFisico.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JPesquisaClienteFisico panel;
				
				try
				{
					panel = new JPesquisaClienteFisico();
					panel.setBounds(0, 0, 594, 350);
					setContentPane(panel);
				}
				catch (ParseException e1)
				{
					JOptionPane.showMessageDialog(null, "Erro ao Tentar abrir Janela de Pesquisa!");
				}
			}
		});
		
		mntmPesquisaClienteJuridico.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JPesquisaClienteJuridico panel;
				
				try
				{
					panel = new JPesquisaClienteJuridico();
					panel.setBounds(0, 0, 594, 350);
					setContentPane(panel);
				}
				catch (ParseException e1)
				{
					JOptionPane.showMessageDialog(null, "Erro ao Tentar abrir Janela de Pesquisa!");
				}
			}
		});
		
		mntmPesquisaFornecedor.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JPesquisaFornecedor panel;
				
				try
				{
					panel = new JPesquisaFornecedor();
					panel.setBounds(0, 0, 594, 350);
					setContentPane(panel);
				}
				catch (ParseException e1)
				{
					JOptionPane.showMessageDialog(null, "Erro ao Tentar abrir Janela de Pesquisa!");
				}
			}
		});
	}
}
