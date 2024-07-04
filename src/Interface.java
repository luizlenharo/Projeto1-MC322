import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interface {
    private JFrame frame;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public void Frame() {
        // Cria a tela
        frame = new JFrame("Mecânica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 650);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(TelaProdutos(), "TelaProdutos");

        mainPanel.add(TelaInicial(), "TelaInicial");

        frame.add(mainPanel);

        frame.setVisible(true);

        cardLayout.show(mainPanel, "TelaInicial");
    }

    public JPanel TelaInicial() {
        // Cria a tela inicial
        JPanel telaInicialPanel = new JPanel(new BorderLayout());
        // Painel do titulo
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        JLabel titleLabel = new JLabel("Mecânica", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 42));
        titleLabel.setForeground(new Color(0,0,0));
        titlePanel.setBorder(new EmptyBorder(50, 20, 0, 20));
        titlePanel.setBackground(new Color(158, 158, 158));
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        telaInicialPanel.add(titlePanel, BorderLayout.NORTH);

        // Painel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2, 30, 30));
        buttonPanel.setBorder(new EmptyBorder(50, 100, 100, 100));
        buttonPanel.setBackground(new Color(158, 158, 158));

        // Botão Produtos
        JButton produtosButton = new JButton("Produtos");
        produtosButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        produtosButton.setFont(new Font("Arial", Font.BOLD, 20));
        produtosButton.setBackground(Color.DARK_GRAY);
        produtosButton.setForeground(Color.white);
        produtosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "TelaProdutos");
            }
        });

        // Botão Clientes
        JButton clientesButton = new JButton("Clientes");
        clientesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        clientesButton.setFont(new Font("Arial", Font.BOLD, 20));
        clientesButton.setBackground(Color.DARK_GRAY);
        clientesButton.setForeground(Color.white);

        // Botão Serviços
        JButton servicosButton = new JButton("Serviços");
        servicosButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        servicosButton.setFont(new Font("Arial", Font.BOLD, 20));
        servicosButton.setBackground(Color.DARK_GRAY);
        servicosButton.setForeground(Color.white);

        //Botão Novo Pedido
        JButton novoPedidoButton = new JButton("Novo Pedido");
        novoPedidoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        novoPedidoButton.setFont(new Font("Arial", Font.BOLD, 20));
        novoPedidoButton.setBackground(Color.DARK_GRAY);
        novoPedidoButton.setForeground(Color.white);

        // Botão Finanças
        JButton financasButton = new JButton("Finanças");
        financasButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        financasButton.setFont(new Font("Arial", Font.BOLD, 20));
        financasButton.setBackground(Color.DARK_GRAY);
        financasButton.setForeground(Color.white);

        // Botão Sair
        JButton sairButton = new JButton("Sair");
        sairButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sairButton.setFont(new Font("Arial", Font.BOLD, 20));
        sairButton.setBackground(new Color(178, 57, 57, 255));
        sairButton.setForeground(Color.white);
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);  // Fecha o programa
            }
        });

        buttonPanel.add(produtosButton);
        buttonPanel.add(clientesButton);
        buttonPanel.add(servicosButton);
        buttonPanel.add(novoPedidoButton);
        buttonPanel.add(financasButton);
        buttonPanel.add(sairButton);

        telaInicialPanel.add(buttonPanel, BorderLayout.CENTER);

        return telaInicialPanel;
        //dispose
    }

    public JPanel TelaProdutos() {
        // Tela de Produtos
        JPanel telaProdutosPanel = new JPanel(new BorderLayout());

        // Painel do titulo
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        // Titulo
        JLabel titleLabel = new JLabel("Produtos", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 42));
        titleLabel.setForeground(new Color(0,0,0));
        titlePanel.setBorder(new EmptyBorder(50, 20, 0, 20));
        titlePanel.setBackground(new Color(158, 158, 158));
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        // Botão Voltar
        JButton voltarButton = new JButton("Voltar");
        voltarButton.setBackground(new Color(178, 57, 57, 255));
        voltarButton.setForeground(Color.white);
        voltarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "TelaInicial");
            }
        });
        titlePanel.add(voltarButton, BorderLayout.LINE_START);

        telaProdutosPanel.add(titlePanel, BorderLayout.NORTH);

        // Painel de conteudo
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(50, 100, 100, 100));
        contentPanel.setBackground(new Color(158, 158, 158));

        // Lista de produtos
        Produto newProduto = new Produto(200, "pneu", TipoProduto.MECANICA);
        newProduto.setPreco(newProduto.calculaPreco());
        Mecanica.getProdutos().add(newProduto);
        Produto produto2 = new Produto(1000, "aerofolio", TipoProduto.ESTETICA);
        produto2.setPreco(produto2.calculaPreco());
        Mecanica.getProdutos().add(produto2);

        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Nome", "Preço", "Quantidade"}, 0);

        for (Produto produto : Mecanica.getProdutos()) {
            tableModel.addRow(new Object[]{produto.getNome(), produto.getPreco(), produto.getEstoque()});
        }

        // Criação da JTable com o modelo
        JTable table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        telaProdutosPanel.add(scrollPane, BorderLayout.CENTER);

        return telaProdutosPanel;
    }
}
