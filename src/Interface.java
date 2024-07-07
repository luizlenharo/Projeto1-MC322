import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.prefs.BackingStoreException;

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

    //######################################################################################################### FINANÇAS
        // Tela de Finanças
        JPanel telaFinancasPanel = new JPanel(new BorderLayout());

        // Painel do titulo
        JPanel titleFinPanel = new JPanel();
        titleFinPanel.setLayout(new BorderLayout());
        // Titulo
        JLabel titleFinLabel = new JLabel("Finanças", SwingConstants.CENTER);
        titleFinLabel.setFont(new Font("Arial", Font.BOLD, 42));
        titleFinLabel.setForeground(new Color(0,0,0));
        titleFinLabel.setBorder(new EmptyBorder(0,0,25,0));
        titleFinPanel.setBorder(new EmptyBorder(50,100, 0, 100));
        titleFinPanel.setBackground(new Color(158, 158, 158));
        titleFinPanel.add(titleFinLabel, BorderLayout.NORTH);

        // Botão Voltar
        JButton voltarButton = new JButton("Voltar");
        voltarButton.setBackground(new Color(178, 57, 57, 255));
        voltarButton.setFont(new Font("Arial", Font.BOLD, 15));
        voltarButton.setForeground(Color.white);
        voltarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "TelaInicial");
            }
        });

        // Painel de conteudo
        JPanel contentFinPanel = new JPanel();
        contentFinPanel.setLayout(new BorderLayout());
        contentFinPanel.setBorder(new EmptyBorder(10, 100, 70, 100));
        contentFinPanel.setBackground(new Color(158, 158, 158));

        // Painel de dados
        JPanel dadosFinPanel = new JPanel();
        dadosFinPanel.setLayout(new GridLayout(4,1,0,10));
        dadosFinPanel.setBackground(new Color(158, 158, 158));

        JLabel faturamentoLabel = new JLabel("Faturamento: R$ " + Mecanica.getFinancas().getFaturamento());
        faturamentoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel gastosLabel = new JLabel("Gastos: R$ " + Mecanica.getFinancas().getGastos());
        gastosLabel.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel caixaLabel = new JLabel("Caixa: R$ " + Mecanica.getFinancas().getCaixa());
        caixaLabel.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel caixaProdutoLabel = new JLabel("Caixa em Produtos: R$ " + Mecanica.getFinancas().getCaixaEmProdutos());
        caixaProdutoLabel.setFont(new Font("Arial", Font.BOLD, 20));

        dadosFinPanel.add(faturamentoLabel);
        dadosFinPanel.add(gastosLabel);
        dadosFinPanel.add(caixaLabel);
        dadosFinPanel.add(caixaProdutoLabel);

        // Botões
        JPanel buttonFinPanel = new JPanel();
        buttonFinPanel.setLayout(new GridLayout(2,1, 0,15));
        buttonFinPanel.setBackground(new Color(158, 158, 158));
        buttonFinPanel.setBorder(new EmptyBorder(70,70,120,60));
        // Botao Atualizar Caixa
        JButton atualizarButton = new JButton("Atualizar Caixa");
        atualizarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        atualizarButton.setFont(new Font("Arial", Font.BOLD, 15));
        atualizarButton.setBackground(Color.DARK_GRAY);
        atualizarButton.setForeground(Color.white);
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Frame de Atualização
                JFrame atualizacaoFrame = new JFrame("Atualização do caixa");
                atualizacaoFrame.setSize(650, 450);
                atualizacaoFrame.setLayout(new BorderLayout());
                atualizacaoFrame.setLocationRelativeTo(null);
                atualizacaoFrame.setResizable(false);

                // Titulo Label
                JLabel titleLabel = new JLabel("Atualização do Caixa", SwingConstants.CENTER);
                titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
                titleLabel.setForeground(new Color(0,0,0));
                titleLabel.setBorder(new EmptyBorder(10,10,20,10));

                atualizacaoFrame.add(titleLabel, BorderLayout.NORTH);

                // Forms Panel
                JPanel formsPanel = new JPanel();
                formsPanel.setLayout(new GridLayout(1,1,10,10));

                // Label para quantia
                JLabel quantiaLabel = new JLabel("Nova Quantia: ", SwingConstants.CENTER);
                quantiaLabel.setFont(new Font("Arial", Font.BOLD, 20));
                quantiaLabel.setForeground(new Color(0,0,0));

                // Field para quantia
                JTextField quantiaField = new JTextField();
                quantiaField.setPreferredSize(new Dimension(100, 25));

                // Panel para quantia
                JPanel quantiaPanel = new JPanel();
                quantiaPanel.setLayout(new FlowLayout());
                quantiaPanel.add(quantiaLabel);
                quantiaPanel.add(quantiaField);
                formsPanel.add(quantiaPanel);

                atualizacaoFrame.add(formsPanel, BorderLayout.CENTER);

                // Botão Confirmar
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new BorderLayout());
                JButton confirmarButton = new JButton("Confirmar atualização");
                confirmarButton.setFont(new Font("Arial", Font.BOLD, 20));
                confirmarButton.setBackground(Color.DARK_GRAY);
                confirmarButton.setForeground(Color.white);
                confirmarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                buttonPanel.add(confirmarButton, BorderLayout.CENTER);
                buttonPanel.setBorder(new EmptyBorder(30,60,30,60));
                atualizacaoFrame.add(buttonPanel, BorderLayout.PAGE_END);
                confirmarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int quantia = Integer.parseInt(quantiaField.getText());
                        Mecanica.getFinancas().setCaixa(quantia);
                        caixaLabel.setText("Caixa: R$ " + Mecanica.getFinancas().getCaixa());
                        atualizacaoFrame.dispose();
                    }
                });
                atualizacaoFrame.setVisible(true);
            }
        });

        // Botao Resetar Gastos e Finaças
        JButton resetButton = new JButton("Resetar Gastos e Faturamento");
        resetButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        resetButton.setFont(new Font("Arial", Font.BOLD, 15));
        resetButton.setBackground(new Color(178, 57, 57, 255));
        resetButton.setForeground(Color.white);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mecanica.getFinancas().setGastos(0);
                Mecanica.getFinancas().setFaturamento(0);
                gastosLabel.setText("Gastos: R$ " + Mecanica.getFinancas().getGastos());
                faturamentoLabel.setText("Faturamento: R$ " + Mecanica.getFinancas().getFaturamento());
            }
        });

        buttonFinPanel.add(atualizarButton);
        buttonFinPanel.add(resetButton);

        titleFinPanel.add(voltarButton, BorderLayout.LINE_START);

        contentFinPanel.add(dadosFinPanel, BorderLayout.LINE_START);
        contentFinPanel.add(buttonFinPanel, BorderLayout.CENTER);

        telaFinancasPanel.add(titleFinPanel, BorderLayout.NORTH);
        telaFinancasPanel.add(contentFinPanel, BorderLayout.CENTER);
        mainPanel.add(telaFinancasPanel, "TelaFinanças");


    //######################################################################################################### SERVIÇOS
        // Tela de Serviços
        JPanel telaServicosPanel = new JPanel(new BorderLayout());

        // Painel do titulo
        JPanel titleServPanel = new JPanel();
        titleServPanel.setLayout(new BorderLayout());
        // Titulo
        JLabel titleServLabel = new JLabel("Serviços", SwingConstants.CENTER);
        titleServLabel.setFont(new Font("Arial", Font.BOLD, 42));
        titleServLabel.setForeground(new Color(0,0,0));
        titleServLabel.setBorder(new EmptyBorder(0,0,25,0));
        titleServPanel.setBorder(new EmptyBorder(50,100, 0, 100));
        titleServPanel.setBackground(new Color(158, 158, 158));
        titleServPanel.add(titleServLabel, BorderLayout.NORTH);

        // Botão Voltar
        JButton voltarServButton = new JButton("Voltar");
        voltarServButton.setBackground(new Color(178, 57, 57, 255));
        voltarServButton.setFont(new Font("Arial", Font.BOLD, 15));
        voltarServButton.setForeground(Color.white);
        voltarServButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        voltarServButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "TelaInicial");
            }
        });

        // Painel de conteudo
        JPanel contentServPanel = new JPanel();
        contentServPanel.setLayout(new BorderLayout());
        contentServPanel.setBorder(new EmptyBorder(10, 100, 70, 100));
        contentServPanel.setBackground(new Color(158, 158, 158));

        NonEditableTableModel tableServModel = new NonEditableTableModel(new Object[]{"Nome", "Preço"}, 0);

        for (Servico servico : Mecanica.getServicos()) {
            if (servico != null) {
                tableServModel.addRow(new Object[]{servico.getNome(), servico.getPreco()});
            }
        }

        // Criação da JTable com o modelo
        JTable tableServ = new JTable(tableServModel);
        tableServ.setFont(new Font("Arial", Font.TRUETYPE_FONT, 16));
        JTableHeader tableServHeader = tableServ.getTableHeader();
        tableServHeader.setFont(new Font("Arial", Font.BOLD, 18));

        JScrollPane scrollServPane = new JScrollPane(tableServ);
        scrollServPane.getViewport().setBackground(new Color(158, 158, 158));
        contentServPanel.add(scrollServPane);
        tableServ.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    Servico servico = Mecanica.getServicos().get(row);

                    // Janela com detalhes do serviço
                    JFrame detalheFrame = new JFrame("Detalhes do Serviço");
                    detalheFrame.setSize(650, 450);
                    detalheFrame.setLayout(new BorderLayout());
                    detalheFrame.setLocationRelativeTo(null);

                    // Titulo
                    JPanel titleServicoPanel = new JPanel();
                    titleServicoPanel.setLayout(new FlowLayout());
                    titleServicoPanel.setBackground(new Color(158,158,158));
                    titleServicoPanel.setBorder(new EmptyBorder(20,10,20,10));
                    JLabel titleServicoLable = new JLabel(servico.getNome());
                    titleServicoLable.setForeground(new Color(0,0,0));
                    titleServicoLable.setFont(new Font("Arial", Font.BOLD, 30));
                    titleServicoPanel.add(titleServicoLable);

                    // Detalhes do Serviço
                    JPanel contentPanel = new JPanel();
                    contentPanel.setLayout(new GridLayout(5,1));
                    contentPanel.setBackground(new Color(158, 158, 158));
                    contentPanel.setBorder(new EmptyBorder(10,90,10,10));
                    JLabel custoLabel = new JLabel("Custo: " + servico.getCusto());
                    custoLabel.setFont(new Font("Arial", Font.BOLD, 17));
                    JLabel precoLabel = new JLabel("Preço: " + servico.getPreco());
                    precoLabel.setFont(new Font("Arial", Font.BOLD, 17));
                    JLabel descricaoLabel = new JLabel("Descrição: " + servico.getDescricao());
                    descricaoLabel.setFont(new Font("Arial", Font.BOLD, 17));

                    contentPanel.add(custoLabel);
                    contentPanel.add(precoLabel);
                    contentPanel.add(descricaoLabel);

                    // Botões
                    JPanel buttonPanel = new JPanel();
                    buttonPanel.setLayout(new GridLayout(2,1, 0,15));
                    buttonPanel.setBackground(new Color(158, 158, 158));
                    buttonPanel.setBorder(new EmptyBorder(70,85,120,120));
                    // Botao Excluir Serviço
                    JButton excluirServicoButton = new JButton("Excluir Serviço");
                    excluirServicoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    excluirServicoButton.setFont(new Font("Arial", Font.BOLD, 15));
                    excluirServicoButton.setBackground(new Color(178, 57, 57, 255));
                    excluirServicoButton.setForeground(Color.white);
                    excluirServicoButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tableServModel.removeRow(target.getSelectedRow());
                            int indiceremovido = row;
                            for (int i = 0; i < Mecanica.getServicos().size() - 1; i++) {
                                if (i >= indiceremovido) {
                                    Mecanica.getServicos().set(i, Mecanica.getServicos().get(i + 1));
                                }
                            }
                            Mecanica.getServicos().set(Mecanica.getServicos().size() - 1, null);

                            detalheFrame.dispose();
                        }
                    });
                    buttonPanel.add(excluirServicoButton);

                    detalheFrame.add(titleServicoPanel, BorderLayout.NORTH);
                    detalheFrame.add(contentPanel, BorderLayout.LINE_START);
                    detalheFrame.add(buttonPanel, BorderLayout.CENTER);

                    detalheFrame.setVisible(true);
                }
            }
        });

        // Botão Cadastro Servico
        JButton cadastroServButton = new JButton("Cadastrar Serviço");
        cadastroServButton.setBackground(Color.DARK_GRAY);
        cadastroServButton.setFont(new Font("Arial", Font.BOLD, 18));
        cadastroServButton.setForeground(Color.white);
        cadastroServButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cadastroServButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Frame de cadastro
                JFrame cadastroFrame = new JFrame("Cadastro de Serviço");
                cadastroFrame.setSize(650, 450);
                cadastroFrame.setLayout(new BorderLayout());
                cadastroFrame.setLocationRelativeTo(null);
                cadastroFrame.setResizable(false);

                // Titulo Label
                JLabel titleLabel = new JLabel("Cadastro de Serviço", SwingConstants.CENTER);
                titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
                titleLabel.setForeground(new Color(0,0,0));
                titleLabel.setBorder(new EmptyBorder(10,10,20,10));

                cadastroFrame.add(titleLabel, BorderLayout.NORTH);

                // Forms Panel
                JPanel formsPanel = new JPanel();
                formsPanel.setLayout(new GridLayout(3,1,10,10));

                // Label para nome
                JLabel nameLabel = new JLabel("Nome: ", SwingConstants.CENTER);
                nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
                nameLabel.setForeground(new Color(0,0,0));

                // Field para nome
                JTextField nameField = new JTextField();
                nameField.setPreferredSize(new Dimension(100, 25));

                // Panel para nome
                JPanel namePanel = new JPanel();
                namePanel.setLayout(new FlowLayout());
                namePanel.add(nameLabel);
                namePanel.add(nameField);
                formsPanel.add(namePanel);

                // Label para Custo
                JLabel custoLabel = new JLabel("Custo: ", SwingConstants.CENTER);
                custoLabel.setFont(new Font("Arial", Font.BOLD, 20));
                custoLabel.setForeground(new Color(0,0,0));

                // Field para cpf
                JTextField custoField = new JTextField();
                custoField.setPreferredSize(new Dimension(100, 25));

                // Panel para cpf
                JPanel custoPanel = new JPanel();
                custoPanel.setLayout(new FlowLayout());
                custoPanel.add(custoLabel);
                custoPanel.add(custoField);
                formsPanel.add(custoPanel);

                // Label para descrição
                JLabel descricaoLabel = new JLabel("Descricao: ", SwingConstants.CENTER);
                descricaoLabel.setFont(new Font("Arial", Font.BOLD, 20));
                descricaoLabel.setForeground(new Color(0,0,0));

                // Field para decrição
                JTextField descricaoField = new JTextField();
                descricaoField.setPreferredSize(new Dimension(100, 25));

                // Panel para decrição
                JPanel descricaoPanel = new JPanel();
                descricaoPanel.setLayout(new FlowLayout());
                descricaoPanel.add(descricaoLabel);
                descricaoPanel.add(descricaoField);
                formsPanel.add(descricaoPanel);

                cadastroFrame.add(formsPanel, BorderLayout.CENTER);

                // Botão Confirmar
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new BorderLayout());
                JButton confirmarButton = new JButton("Confirmar cadastro");
                confirmarButton.setFont(new Font("Arial", Font.BOLD, 20));
                confirmarButton.setBackground(Color.DARK_GRAY);
                confirmarButton.setForeground(Color.white);
                confirmarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                buttonPanel.add(confirmarButton, BorderLayout.CENTER);
                buttonPanel.setBorder(new EmptyBorder(30,60,30,60));
                cadastroFrame.add(buttonPanel, BorderLayout.PAGE_END);
                confirmarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int custo = Integer.parseInt(custoField.getText());
                        String nome = nameField.getText();
                        String descricao = descricaoField.getText();
                        Servico newServico = new Servico(custo, nome, descricao);
                        if (Mecanica.getServicos().isEmpty()) {
                            Mecanica.getServicos().add(newServico);
                        } else {
                            for (int i = 0; i < Mecanica.getServicos().size(); i ++) {
                                if (Mecanica.getServicos().get(i) == null) {
                                    Mecanica.getServicos().set(i, newServico);
                                    break;
                                } else if (i == Mecanica.getServicos().size() - 1) {
                                    Mecanica.getServicos().add(newServico);
                                    break;
                                }
                            }
                            newServico.setPreco(newServico.calculaPreco());
                            tableServModel.addRow(new Object[]{newServico.getNome(), newServico.getPreco()});
                            cadastroFrame.dispose();
                        }
                    }
                });
                cadastroFrame.setVisible(true);
            }
        });

        titleServPanel.add(voltarServButton, BorderLayout.LINE_START);

        titleServPanel.add(cadastroServButton, BorderLayout.LINE_END);

        telaServicosPanel.add(titleServPanel, BorderLayout.NORTH);

        telaServicosPanel.add(contentServPanel, BorderLayout.CENTER);
        mainPanel.add(telaServicosPanel, "TelaServiços");


    //######################################################################################################### CLIENTES
        // Tela de Clientes
        JPanel telaClientesPanel = new JPanel(new BorderLayout());

        // Painel do titulo
        JPanel titleCliPanel = new JPanel();
        titleCliPanel.setLayout(new BorderLayout());
        // Titulo
        JLabel titleCliLabel = new JLabel("Clientes", SwingConstants.CENTER);
        titleCliLabel.setFont(new Font("Arial", Font.BOLD, 42));
        titleCliLabel.setForeground(new Color(0,0,0));
        titleCliLabel.setBorder(new EmptyBorder(0,0,25,0));
        titleCliPanel.setBorder(new EmptyBorder(50,100, 0, 100));
        titleCliPanel.setBackground(new Color(158, 158, 158));
        titleCliPanel.add(titleCliLabel, BorderLayout.NORTH);

        // Botão Voltar
        JButton voltarCliButton = new JButton("Voltar");
        voltarCliButton.setBackground(new Color(178, 57, 57, 255));
        voltarCliButton.setFont(new Font("Arial", Font.BOLD, 15));
        voltarCliButton.setForeground(Color.white);
        voltarCliButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        voltarCliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "TelaInicial");
            }
        });

        // Painel de conteudo
        JPanel contentCliPanel = new JPanel();
        contentCliPanel.setLayout(new BorderLayout());
        contentCliPanel.setBorder(new EmptyBorder(10, 100, 70, 100));
        contentCliPanel.setBackground(new Color(158, 158, 158));

        NonEditableTableModel tableCliModel = new NonEditableTableModel(new Object[]{"Nome", "CPF"}, 0);

        for (Cliente cliente : Mecanica.getClientes()) {
            if (cliente != null) {
                tableCliModel.addRow(new Object[]{cliente.getNome(), cliente.getCpf()});
            }
        }

        // Criação da JTable com o modelo
        JTable tableCli = new JTable(tableCliModel);
        tableCli.setFont(new Font("Arial", Font.TRUETYPE_FONT, 16));
        JTableHeader tableCliHeader = tableCli.getTableHeader();
        tableCliHeader.setFont(new Font("Arial", Font.BOLD, 18));

        JScrollPane scrollCliPane = new JScrollPane(tableCli);
        scrollCliPane.getViewport().setBackground(new Color(158, 158, 158));
        contentCliPanel.add(scrollCliPane);
        tableCli.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    Cliente cliente = Mecanica.getClientes().get(row);

                    // Janela com detalhes do cliente
                    JFrame detalheFrame = new JFrame("Detalhes do Cliente");
                    detalheFrame.setSize(650, 450);
                    detalheFrame.setLayout(new BorderLayout());
                    detalheFrame.setLocationRelativeTo(null);

                    // Titulo
                    JPanel titleClientePanel = new JPanel();
                    titleClientePanel.setLayout(new FlowLayout());
                    titleClientePanel.setBackground(new Color(158,158,158));
                    titleClientePanel.setBorder(new EmptyBorder(20,10,20,10));
                    JLabel titleClienteLable = new JLabel(cliente.getNome());
                    titleClienteLable.setForeground(new Color(0,0,0));
                    titleClienteLable.setFont(new Font("Arial", Font.BOLD, 30));
                    titleClientePanel.add(titleClienteLable);

                    // Detalhes do Cliente
                    JPanel contentPanel = new JPanel();
                    contentPanel.setLayout(new GridLayout(5,1));
                    contentPanel.setBackground(new Color(158, 158, 158));
                    contentPanel.setBorder(new EmptyBorder(10,90,10,10));
                    JLabel nomeLabel = new JLabel("Nome: " + cliente.getNome());
                    nomeLabel.setFont(new Font("Arial", Font.BOLD, 17));
                    JLabel cpfLabel = new JLabel("CPF: " + cliente.getCpf());
                    cpfLabel.setFont(new Font("Arial", Font.BOLD, 17));

                    contentPanel.add(nomeLabel);
                    contentPanel.add(cpfLabel);

                    // Botões
                    JPanel buttonPanel = new JPanel();
                    buttonPanel.setLayout(new GridLayout(2,1, 0,15));
                    buttonPanel.setBackground(new Color(158, 158, 158));
                    buttonPanel.setBorder(new EmptyBorder(70,100,120,120));
                    // Botao Excluir Cliente
                    JButton excluirClienteButton = new JButton("Excluir Cliente");
                    excluirClienteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    excluirClienteButton.setFont(new Font("Arial", Font.BOLD, 15));
                    excluirClienteButton.setBackground(new Color(178, 57, 57, 255));
                    excluirClienteButton.setForeground(Color.white);
                    excluirClienteButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tableCliModel.removeRow(target.getSelectedRow());
                            int indiceremovido = row;
                            for (int i = 0; i < Mecanica.getClientes().size() - 1; i++) {
                                if (i >= indiceremovido) {
                                    Mecanica.getClientes().set(i, Mecanica.getClientes().get(i + 1));
                                }
                            }
                            Mecanica.getClientes().set(Mecanica.getClientes().size() - 1, null);

                            detalheFrame.dispose();
                        }
                    });
                    buttonPanel.add(excluirClienteButton);

                    detalheFrame.add(titleClientePanel, BorderLayout.NORTH);
                    detalheFrame.add(contentPanel, BorderLayout.LINE_START);
                    detalheFrame.add(buttonPanel, BorderLayout.CENTER);

                    detalheFrame.setVisible(true);
                }
            }
        });

        // Botão Cadastro Cliente
        JButton cadastroCliButton = new JButton("Cadastrar Cliente");
        cadastroCliButton.setBackground(Color.DARK_GRAY);
        cadastroCliButton.setFont(new Font("Arial", Font.BOLD, 18));
        cadastroCliButton.setForeground(Color.white);
        cadastroCliButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cadastroCliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente newCliente;
                // Frame de cadastro
                JFrame cadastroFrame = new JFrame("Cadastro do Cliente");
                cadastroFrame.setSize(650, 450);
                cadastroFrame.setLayout(new BorderLayout());
                cadastroFrame.setLocationRelativeTo(null);
                cadastroFrame.setResizable(false);

                // Titulo Label
                JLabel titleLabel = new JLabel("Cadastro de Cliente", SwingConstants.CENTER);
                titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
                titleLabel.setForeground(new Color(0,0,0));
                titleLabel.setBorder(new EmptyBorder(10,10,20,10));

                cadastroFrame.add(titleLabel, BorderLayout.NORTH);

                // Forms Panel
                JPanel formsPanel = new JPanel();
                formsPanel.setLayout(new GridLayout(3,1,10,10));

                // Label para nome
                JLabel nameLabel = new JLabel("Nome: ", SwingConstants.CENTER);
                nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
                nameLabel.setForeground(new Color(0,0,0));

                // Field para nome
                JTextField nameField = new JTextField();
                nameField.setPreferredSize(new Dimension(100, 25));

                // Panel para nome
                JPanel namePanel = new JPanel();
                namePanel.setLayout(new FlowLayout());
                namePanel.add(nameLabel);
                namePanel.add(nameField);
                formsPanel.add(namePanel);

                // Label para cpf
                JLabel cpfLabel = new JLabel("CPF: ", SwingConstants.CENTER);
                cpfLabel.setFont(new Font("Arial", Font.BOLD, 20));
                cpfLabel.setForeground(new Color(0,0,0));

                // Field para cpf
                JTextField cpfField = new JTextField();
                cpfField.setPreferredSize(new Dimension(100, 25));

                // Panel para cpf
                JPanel cpfPanel = new JPanel();
                cpfPanel.setLayout(new FlowLayout());
                cpfPanel.add(cpfLabel);
                cpfPanel.add(cpfField);
                formsPanel.add(cpfPanel);

                cadastroFrame.add(formsPanel, BorderLayout.CENTER);

                // Botão Confirmar
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new BorderLayout());
                JButton confirmarCadCliButton = new JButton("Confirmar cadastro");
                confirmarCadCliButton.setFont(new Font("Arial", Font.BOLD, 20));
                confirmarCadCliButton.setBackground(Color.DARK_GRAY);
                confirmarCadCliButton.setForeground(Color.white);
                confirmarCadCliButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                buttonPanel.add(confirmarCadCliButton, BorderLayout.CENTER);
                buttonPanel.setBorder(new EmptyBorder(30,60,30,60));
                cadastroFrame.add(buttonPanel, BorderLayout.PAGE_END);
                confirmarCadCliButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nome = nameField.getText();
                        String cpf = cpfField.getText();
                        Cliente newCliente = new Cliente(cpf, nome);
                        if (Mecanica.getClientes().isEmpty()) {
                            Mecanica.getClientes().add(newCliente);
                        } else {
                            for (int i = 0; i < Mecanica.getClientes().size(); i ++) {
                                if (Mecanica.getClientes().get(i) == null) {
                                    Mecanica.getClientes().set(i, newCliente);
                                    break;
                                } else if (i == Mecanica.getClientes().size() - 1) {
                                    Mecanica.getClientes().add(newCliente);
                                    break;
                                }
                            }
                            tableCliModel.addRow(new Object[]{newCliente.getNome(), newCliente.getCpf()});
                            cadastroFrame.dispose();
                        }
                    }
                });
                cadastroFrame.setVisible(true);
            }
        });

        titleCliPanel.add(voltarCliButton, BorderLayout.LINE_START);

        titleCliPanel.add(cadastroCliButton, BorderLayout.LINE_END);

        telaClientesPanel.add(titleCliPanel, BorderLayout.NORTH);

        telaClientesPanel.add(contentCliPanel, BorderLayout.CENTER);
        mainPanel.add(telaClientesPanel, "TelaClientes");


    //######################################################################################################### PRODUTOS
        // Tela de Produtos
        JPanel telaProdutosPanel = new JPanel(new BorderLayout());

        // Painel do titulo
        JPanel titleProdPanel = new JPanel();
        titleProdPanel.setLayout(new BorderLayout());
        // Titulo
        JLabel titleProdLabel = new JLabel("Produtos", SwingConstants.CENTER);
        titleProdLabel.setFont(new Font("Arial", Font.BOLD, 42));
        titleProdLabel.setForeground(new Color(0,0,0));
        titleProdLabel.setBorder(new EmptyBorder(0,0,25,0));
        titleProdPanel.setBorder(new EmptyBorder(50,100, 0, 100));
        titleProdPanel.setBackground(new Color(158, 158, 158));
        titleProdPanel.add(titleProdLabel, BorderLayout.NORTH);

        // Botão Voltar
        JButton voltarProdButton = new JButton("Voltar");
        voltarProdButton.setBackground(new Color(178, 57, 57, 255));
        voltarProdButton.setFont(new Font("Arial", Font.BOLD, 15));
        voltarProdButton.setForeground(Color.white);
        voltarProdButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        voltarProdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "TelaInicial");
            }
        });

        // Painel de conteudo
        JPanel contentProdPanel = new JPanel();
        contentProdPanel.setLayout(new BorderLayout());
        contentProdPanel.setBorder(new EmptyBorder(10, 100, 70, 100));
        contentProdPanel.setBackground(new Color(158, 158, 158));

        NonEditableTableModel tableProdModel = new NonEditableTableModel(new Object[]{"Nome", "Preço", "Quantidade", "Tipo"}, 0);

        for (Produto produto : Mecanica.getProdutos()) {
            if (produto != null){
                tableProdModel.addRow(new Object[]{produto.getNome(), produto.getPreco(), produto.getEstoque(), produto.getTipo()});
            }
        }

        // Criação da JTable com o modelo
        JTable tableProd = new JTable(tableProdModel);
        tableProd.setFont(new Font("Arial", Font.TRUETYPE_FONT, 16));
        JTableHeader tableProdHeader = tableProd.getTableHeader();
        tableProdHeader.setFont(new Font("Arial", Font.BOLD, 18));

        JScrollPane scrollProdPane = new JScrollPane(tableProd);
        scrollProdPane.getViewport().setBackground(new Color(158, 158, 158));
        contentProdPanel.add(scrollProdPane);
        tableProd.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    Produto produto = Mecanica.getProdutos().get(row);

                    // Janela com detalhes do produto
                    JFrame detalheFrame = new JFrame("Detalhes do Produto");
                    detalheFrame.setSize(650, 450);
                    detalheFrame.setLayout(new BorderLayout());
                    detalheFrame.setLocationRelativeTo(null);

                    // Titulo
                    JPanel titleProdutoPanel = new JPanel();
                    titleProdutoPanel.setLayout(new FlowLayout());
                    titleProdutoPanel.setBackground(new Color(158,158,158));
                    titleProdutoPanel.setBorder(new EmptyBorder(20,10,20,10));
                    JLabel titleProdutoLable = new JLabel(produto.getNome());
                    titleProdutoLable.setForeground(new Color(0,0,0));
                    titleProdutoLable.setFont(new Font("Arial", Font.BOLD, 30));
                    titleProdutoPanel.add(titleProdutoLable);

                    // Detalhes do Produto
                    JPanel contentPanel = new JPanel();
                    contentPanel.setLayout(new GridLayout(5,1));
                    contentPanel.setBackground(new Color(158, 158, 158));
                    contentPanel.setBorder(new EmptyBorder(10,90,10,10));
                    JLabel custoLabel = new JLabel("Custo: " + produto.getCusto());
                    custoLabel.setFont(new Font("Arial", Font.BOLD, 17));
                    JLabel precoLabel = new JLabel("Preço: R$ " + produto.getPreco());
                    precoLabel.setFont(new Font("Arial", Font.BOLD, 17));
                    JLabel quantidadeLabel = new JLabel("Quantidade: " + produto.getEstoque());
                    quantidadeLabel.setFont(new Font("Arial", Font.BOLD, 17));
                    JLabel tipoLabel = new JLabel("Tipo: " + produto.getTipo());
                    tipoLabel.setFont(new Font("Arial", Font.BOLD, 17));

                    contentPanel.add(custoLabel);
                    contentPanel.add(precoLabel);
                    contentPanel.add(quantidadeLabel);
                    contentPanel.add(tipoLabel);

                    // Botões
                    JPanel buttonPanel = new JPanel();
                    buttonPanel.setLayout(new GridLayout(2,1, 0,15));
                    buttonPanel.setBackground(new Color(158, 158, 158));
                    buttonPanel.setBorder(new EmptyBorder(70,120,120,120));
                    // Botao Repor Estoque
                    JButton reporEstoqueButton = new JButton("Repor Estoque");
                    reporEstoqueButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    reporEstoqueButton.setFont(new Font("Arial", Font.BOLD, 15));
                    reporEstoqueButton.setBackground(Color.DARK_GRAY);
                    reporEstoqueButton.setForeground(Color.white);
                    reporEstoqueButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (Mecanica.reporEstoque(produto, 1) == false) {
                                JOptionPane.showMessageDialog(
                                        reporEstoqueButton,
                                        "Saldo insuficiente para repor estoque!\n" +
                                                "Saldo nescessário: " + produto.getCusto() +
                                                "\nSaldo Atual: " + Mecanica.getFinancas().getCaixa(),
                                        "Alerta",
                                        JOptionPane.WARNING_MESSAGE
                                );
                            } else {
                                quantidadeLabel.setText("Quantidade: " + produto.getEstoque());
                                tableProdModel.setValueAt(produto.getEstoque(), row, 2);
                                gastosLabel.setText("Gastos: R$ " + Mecanica.getFinancas().getGastos());
                                caixaProdutoLabel.setText("Caixa em Produtos: R$ " + Mecanica.getFinancas().getCaixaEmProdutos());
                            }
                        }
                    });

                    // Botao Excluir Produto
                    JButton excluirProdutoButton = new JButton("Excluir Produto");
                    excluirProdutoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    excluirProdutoButton.setFont(new Font("Arial", Font.BOLD, 15));
                    excluirProdutoButton.setBackground(new Color(178, 57, 57, 255));
                    excluirProdutoButton.setForeground(Color.white);
                    excluirProdutoButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tableProdModel.removeRow(target.getSelectedRow());
                            int indiceremovido = row;
                            for (int i = 0; i < Mecanica.getProdutos().size() - 1; i++) {
                                if (i >= indiceremovido) {
                                    Mecanica.getProdutos().set(i, Mecanica.getProdutos().get(i + 1));
                                }
                            }
                            Mecanica.getProdutos().set(Mecanica.getProdutos().size() - 1, null);
                            detalheFrame.dispose();
                        }
                    });

                    buttonPanel.add(reporEstoqueButton);
                    buttonPanel.add(excluirProdutoButton);

                    detalheFrame.add(titleProdutoPanel, BorderLayout.NORTH);
                    detalheFrame.add(contentPanel, BorderLayout.LINE_START);
                    detalheFrame.add(buttonPanel, BorderLayout.CENTER);

                    detalheFrame.setVisible(true);
                }
            }
        });

        // Botão Cadastro produto
        JButton cadastroProdButton = new JButton("Cadastrar Produto");
        cadastroProdButton.setBackground(Color.DARK_GRAY);
        cadastroProdButton.setFont(new Font("Arial", Font.BOLD, 18));
        cadastroProdButton.setForeground(Color.white);
        cadastroProdButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cadastroProdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Produto newProduto;
                // Frame de cadastro
                JFrame cadastroFrame = new JFrame("Cadastro do Produto");
                cadastroFrame.setSize(650, 450);
                cadastroFrame.setLayout(new BorderLayout());
                cadastroFrame.setLocationRelativeTo(null);
                cadastroFrame.setResizable(false);

                // Titulo Label
                JLabel titleLabel = new JLabel("Cadastro de Produto", SwingConstants.CENTER);
                titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
                titleLabel.setForeground(new Color(0,0,0));
                titleLabel.setBorder(new EmptyBorder(10,10,20,10));

                cadastroFrame.add(titleLabel, BorderLayout.NORTH);

                // Forms Panel
                JPanel formsPanel = new JPanel();
                formsPanel.setLayout(new GridLayout(3,1,10,10));

                // Label para nome
                JLabel nameLabel = new JLabel("Nome: ", SwingConstants.CENTER);
                nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
                nameLabel.setForeground(new Color(0,0,0));

                // Field para nome
                JTextField nameField = new JTextField();
                nameField.setPreferredSize(new Dimension(100, 25));

                // Panel para nome
                JPanel namePanel = new JPanel();
                namePanel.setLayout(new FlowLayout());
                namePanel.add(nameLabel);
                namePanel.add(nameField);
                formsPanel.add(namePanel);

                // Label para custo de aquisição
                JLabel custoLabel = new JLabel("Custo de aquisição: ", SwingConstants.CENTER);
                custoLabel.setFont(new Font("Arial", Font.BOLD, 20));
                custoLabel.setForeground(new Color(0,0,0));

                // Field para custo de aquisição
                JTextField custoField = new JTextField();
                custoField.setPreferredSize(new Dimension(100, 25));

                // Panel para custo de aquisição
                JPanel custoPanel = new JPanel();
                custoPanel.setLayout(new FlowLayout());
                custoPanel.add(custoLabel);
                custoPanel.add(custoField);
                formsPanel.add(custoPanel);

                // Label para tipo
                JLabel tipoLabel = new JLabel("Tipo: ", SwingConstants.CENTER);
                tipoLabel.setFont(new Font("Arial", Font.BOLD, 20));
                tipoLabel.setForeground(new Color(0,0,0));

                // CheckBox para tipo
                JCheckBox mecanicaBox = new JCheckBox("Mecânica");
                mecanicaBox.setFont(new Font("Arial",Font.BOLD, 15));
                JCheckBox esteticaBox = new JCheckBox("Estética");
                esteticaBox.setFont(new Font("Arial",Font.BOLD, 15));

                // Panel para tipo
                JPanel tipoPanel = new JPanel();
                tipoPanel.setLayout(new FlowLayout());
                tipoPanel.add(tipoLabel);
                tipoPanel.add(mecanicaBox);
                tipoPanel.add(esteticaBox);
                formsPanel.add(tipoPanel);

                cadastroFrame.add(formsPanel, BorderLayout.CENTER);

                // Botão Confirmar
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new BorderLayout());
                JButton confirmarButton = new JButton("Confirmar cadastro");
                confirmarButton.setFont(new Font("Arial", Font.BOLD, 20));
                confirmarButton.setBackground(Color.DARK_GRAY);
                confirmarButton.setForeground(Color.white);
                confirmarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                buttonPanel.add(confirmarButton, BorderLayout.CENTER);
                buttonPanel.setBorder(new EmptyBorder(30,60,30,60));
                cadastroFrame.add(buttonPanel, BorderLayout.PAGE_END);
                confirmarButton.addActionListener(new ActionListener() {
                    TipoProduto tipoProduto;
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int custo = Integer.parseInt(custoField.getText());
                        String nome = nameField.getText();
                        boolean respostaMecanicaBox = mecanicaBox.isSelected();
                        boolean respostaEsteticaBox = esteticaBox.isSelected();
                        if (respostaMecanicaBox == true) {
                            tipoProduto = TipoProduto.MECANICA;
                        } else if (respostaEsteticaBox == true) {
                            tipoProduto = TipoProduto.ESTETICA;
                        }
                        Produto newProduto = new Produto(custo, nome, tipoProduto);
                        newProduto.setPreco(newProduto.calculaPreco());
                        if (Mecanica.getProdutos().isEmpty())
                            Mecanica.getProdutos().add(newProduto);
                        else
                            for (int i = 0; i < Mecanica.getProdutos().size(); i ++) {
                                if (Mecanica.getProdutos().get(i) == null) {
                                    Mecanica.getProdutos().set(i, newProduto);
                                    break;
                                } else if (i == Mecanica.getProdutos().size() - 1) {
                                    Mecanica.getProdutos().add(newProduto);
                                    break;
                                }
                            }
                        tableProdModel.addRow(new Object[]{newProduto.getNome(), newProduto.getPreco(),
                                newProduto.getEstoque(), newProduto.getTipo()});
                        cadastroFrame.dispose();
                    }
                });
                cadastroFrame.setVisible(true);
            }
        });

        titleProdPanel.add(voltarProdButton, BorderLayout.LINE_START);

        titleProdPanel.add(cadastroProdButton, BorderLayout.LINE_END);

        telaProdutosPanel.add(titleProdPanel, BorderLayout.NORTH);

        telaProdutosPanel.add(contentProdPanel, BorderLayout.CENTER);
        mainPanel.add(telaProdutosPanel, "TelaProdutos");


        //################################################################################################## Novo Pedido
        // Tela de Novo Pedido
        JPanel telaNovoPedPanel = new JPanel(new BorderLayout());
        Pedido novoPedido = new Pedido();

        // Painel do titulo
        JPanel titleNovoPedPanel = new JPanel();
        titleNovoPedPanel.setLayout(new BorderLayout());
        // Titulo
        JLabel titleNovoPedLabel = new JLabel("Novo Pedido", SwingConstants.CENTER);
        titleNovoPedLabel.setFont(new Font("Arial", Font.BOLD, 42));
        titleNovoPedLabel.setForeground(new Color(0,0,0));
        titleNovoPedLabel.setBorder(new EmptyBorder(0,0,25,0));
        titleNovoPedPanel.setBorder(new EmptyBorder(50,100, 0, 100));
        titleNovoPedPanel.setBackground(new Color(158, 158, 158));
        titleNovoPedPanel.add(titleNovoPedLabel, BorderLayout.NORTH);

        // Botão Voltar
        JButton voltarNovoPedButton = new JButton("Voltar");
        voltarNovoPedButton.setBackground(new Color(178, 57, 57, 255));
        voltarNovoPedButton.setFont(new Font("Arial", Font.BOLD, 15));
        voltarNovoPedButton.setForeground(Color.white);
        voltarNovoPedButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Painel de conteudo
        JPanel contentNovoPedPanel = new JPanel(cardLayout);
        contentNovoPedPanel.setBorder(new EmptyBorder(10, 100, 0, 0));
        contentNovoPedPanel.setBackground(new Color(158, 158, 158));

        // Carrinho Panel
        JPanel carrinhoPanel = new JPanel();
        carrinhoPanel.setLayout(new BorderLayout());
        carrinhoPanel.setBorder(new EmptyBorder(10,0,0,0));
        carrinhoPanel.setBackground(new Color(158,158,158));
        // Painel do titulo carrinho
        JPanel titlecarrinhoPanel = new JPanel();
        titlecarrinhoPanel.setLayout(new BorderLayout());
        // Titulo carrinho
        JLabel titlecarrinhoLabel = new JLabel("Carrinho", SwingConstants.CENTER);
        titlecarrinhoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titlecarrinhoLabel.setForeground(Color.white);
        titlecarrinhoLabel.setBorder(new EmptyBorder(25,60,25,60));
        titlecarrinhoPanel.setBackground(Color.DARK_GRAY);
        titlecarrinhoPanel.add(titlecarrinhoLabel, BorderLayout.NORTH);
        carrinhoPanel.add(titlecarrinhoPanel, BorderLayout.NORTH);
        // Total Panel
        JPanel totalPanel = new JPanel();
        totalPanel.setLayout(new BorderLayout());
        // Total Label
        JLabel totalLabel = new JLabel("Total: R$ " + novoPedido.getPrecoTotal(), SwingConstants.CENTER);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 17));
        totalLabel.setForeground(Color.white);
        totalLabel.setBorder(new EmptyBorder(25,0,25,60));
        totalPanel.setBackground(new Color(21, 21, 21));
        totalPanel.add(totalLabel, BorderLayout.NORTH);
        // Finalizar Button
        JButton finalizarButton = new JButton("Finalizar compra");
        finalizarButton.setBackground(new Color(6, 8, 106));
        finalizarButton.setForeground(Color.white);
        finalizarButton.setFont(new Font("Arial", Font.BOLD, 20));
        finalizarButton.setBorder(new EmptyBorder(25,60,25,60));
        finalizarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        totalPanel.add(finalizarButton, BorderLayout.SOUTH);
        carrinhoPanel.add(totalPanel, BorderLayout.SOUTH);
        // Itens Panel
        JPanel itensPanel = new JPanel();
        itensPanel.setLayout(new BorderLayout());
        itensPanel.setBackground(new Color(158, 158, 158));
        NonEditableTableModel tableItensModel = new NonEditableTableModel(new Object[]{"Nome", "Quant.", "Preço"}, 0);
        JTable tableItens = new JTable(tableItensModel);
        tableItens.setFont(new Font("Arial", Font.TRUETYPE_FONT, 16));
        tableItens.setPreferredScrollableViewportSize(new Dimension(250, 100));
        JTableHeader tableItensHeader = tableItens.getTableHeader();
        tableItensHeader.setFont(new Font("Arial", Font.BOLD, 18));

        JScrollPane scrollItensPane = new JScrollPane(tableItens);
        scrollItensPane.setBackground(new Color(158, 158, 158));
        scrollItensPane.getViewport().setBackground(new Color(158, 158, 158));
        itensPanel.add(scrollItensPane, BorderLayout.CENTER);
        carrinhoPanel.add(itensPanel, BorderLayout.CENTER);

        // Produtos e Serviços Panel
        JPanel prodServPanel = new JPanel();
        prodServPanel.setLayout(new GridLayout(1,2));
        prodServPanel.setBackground(new Color(158,158,158));
        // Produtos List
        NonEditableTableModel tableProdNPModel = new NonEditableTableModel(new Object[]{"Nome", "Quant.", "Preço"}, 0);
        for (Produto produto : Mecanica.getProdutos()) {
            if (produto != null){
                tableProdNPModel.addRow(new Object[]{produto.getNome(), produto.getEstoque(), produto.getPreco()});
            }
        }
        // Criação da JTable com o modelo
        JTable tableProdNP = new JTable(tableProdNPModel);
        tableProdNP.setFont(new Font("Arial", Font.TRUETYPE_FONT, 16));
        JTableHeader tableProdNPHeader = tableProdNP.getTableHeader();
        tableProdNPHeader.setFont(new Font("Arial", Font.BOLD, 18));

        JScrollPane scrollProdNPPane = new JScrollPane(tableProdNP);
        scrollProdNPPane.getViewport().setBackground(new Color(158, 158, 158));
        prodServPanel.add(scrollProdNPPane);
        tableProdNP.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    Produto produtoadd = Mecanica.getProdutos().get(row);
                    if (novoPedido.adicionarItem(produtoadd, 1) == true) {
                        System.out.print(produtoadd);
                        if (tableItens.getRowCount() == 0) {
                            tableItensModel.addRow(new Object[]{produtoadd.getNome(),
                                    novoPedido.getProdutoQuantidade().get(produtoadd), produtoadd.getPreco()});
                        }
                        for (int i = 0; i < tableItens.getRowCount(); i++) {
                            if (produtoadd.getNome().equals(tableItens.getValueAt(i, 0))) {
                                tableItensModel.setValueAt(novoPedido.getProdutoQuantidade().get(produtoadd), i, 1);
                                tableItensModel.setValueAt(novoPedido.getProdutoQuantidade().get(produtoadd) * produtoadd.getPreco(),
                                        i, 2);
                                break;
                            } else if (i == tableItens.getRowCount() - 1) {
                                tableItensModel.addRow(new Object[]{produtoadd.getNome(),
                                        novoPedido.getProdutoQuantidade().get(produtoadd), produtoadd.getPreco()});
                                break;
                            }
                        }
                        totalLabel.setText("Total: R$ " + novoPedido.getPrecoTotal());
                        tableProdNPModel.setValueAt(produtoadd.getEstoque(), row, 1);
                        int intLinhaProdList;
                        for (int i = 0; i < tableProd.getRowCount(); i++) {
                            if (produtoadd.getNome().equals(tableProd.getValueAt(i, 0))) {
                                tableProdModel.setValueAt(produtoadd.getEstoque(), i, 2);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(
                                tableProdNP,
                                "Produto sem estoque\n",
                                "Alerta",
                                JOptionPane.WARNING_MESSAGE
                        );
                    }
                }
            }
        });
        // Serviços List
        NonEditableTableModel tableServNPModel = new NonEditableTableModel(new Object[]{"Nome", "Preço"}, 0);

        for (Servico servico : Mecanica.getServicos()) {
            if (servico != null) {
                tableServNPModel.addRow(new Object[]{servico.getNome(), servico.getPreco()});
            }
        }

        // Criação da JTable com o modelo
        JTable tableServNP = new JTable(tableServNPModel);
        tableServNP.setFont(new Font("Arial", Font.TRUETYPE_FONT, 16));
        JTableHeader tableServNPHeader = tableServNP.getTableHeader();
        tableServNPHeader.setFont(new Font("Arial", Font.BOLD, 18));

        JScrollPane scrollServNPPane = new JScrollPane(tableServNP);
        scrollServNPPane.getViewport().setBackground(new Color(158, 158, 158));
        prodServPanel.add(scrollServNPPane);
        tableServNP.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    Servico servico = Mecanica.getServicos().get(row);
                    novoPedido.adicionarItem(servico);
                    if (tableItens.getRowCount() == 0) {
                        tableItensModel.addRow(new Object[]{servico.getNome(), "único", servico.getPreco()});
                    }
                    for (int i = 0; i < tableItens.getRowCount(); i++) {
                        if (servico.getNome().equals(tableItens.getValueAt(i, 0))) {
                            tableItensModel.setValueAt("único", i, 1);
                            tableItensModel.setValueAt(servico.getPreco(), i, 2);
                            break;
                        } else if (i == tableItens.getRowCount() - 1) {
                            tableItensModel.addRow(new Object[]{servico.getNome(), "único", servico.getPreco()});
                            break;
                        }
                    }
                    totalLabel.setText("Total: R$ " + novoPedido.getPrecoTotal());
                }
            }
        });

        // Cliente Panel
        JPanel clienteNovoPedPanel = new JPanel();
        clienteNovoPedPanel.setLayout(new GridLayout(1,1));
        clienteNovoPedPanel.setBackground(new Color(158,158,158));
        clienteNovoPedPanel.setBorder(new EmptyBorder(0,0,20,0));
        // Clientes List
        NonEditableTableModel tableCliNPModel = new NonEditableTableModel(new Object[]{"Nome", "CPF"}, 0);

        for (Cliente cliente : Mecanica.getClientes()) {
            if (cliente != null) {
                tableCliNPModel.addRow(new Object[]{cliente.getNome(), cliente.getCpf()});
            }
        }

        // Criação da JTable com o modelo
        JTable tableCliNP = new JTable(tableCliNPModel);
        tableCliNP.setFont(new Font("Arial", Font.TRUETYPE_FONT, 16));
        JTableHeader tableCliNPHeader = tableCliNP.getTableHeader();
        tableCliNPHeader.setFont(new Font("Arial", Font.BOLD, 18));

        JScrollPane scrollCliNPPane = new JScrollPane(tableCliNP);
        scrollCliNPPane.getViewport().setBackground(new Color(158, 158, 158));
        clienteNovoPedPanel.add(scrollCliNPPane);
        tableCliNP.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    Cliente clienteNovoPed = Mecanica.getClientes().get(row);
                    clienteNovoPed.setPedidoAtual(novoPedido);
                    cardLayout.show(contentNovoPedPanel, "prodServPanel");
                }
            }
        });

        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                novoPedido.finalizarPedido();
                faturamentoLabel.setText("Faturamento: R$ " + Mecanica.getFinancas().getFaturamento());
                caixaLabel.setText("Caixa: R$ " + Mecanica.getFinancas().getCaixa());
                caixaProdutoLabel.setText("Caixa em Produtos: R$ " + Mecanica.getFinancas().getCaixaEmProdutos());
                cardLayout.show(mainPanel, "TelaInicial");
                cardLayout.show(contentNovoPedPanel, "clienteNovoPedPanel");
                tableItensModel.setRowCount(0);

            }
        });

        voltarNovoPedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "TelaInicial");
                cardLayout.show(contentNovoPedPanel, "clienteNovoPedPanel");
            }
        });

        contentNovoPedPanel.add(prodServPanel, "prodServPanel");

        contentNovoPedPanel.add(clienteNovoPedPanel, "clienteNovoPedPanel");

        titleNovoPedPanel.add(voltarNovoPedButton, BorderLayout.LINE_START);

        telaNovoPedPanel.add(titleNovoPedPanel, BorderLayout.NORTH);

        telaNovoPedPanel.add(carrinhoPanel, BorderLayout.LINE_END);

        telaNovoPedPanel.add(contentNovoPedPanel, BorderLayout.CENTER);

        cardLayout.show(contentNovoPedPanel, "clienteNovoPedPanel");

        mainPanel.add(telaNovoPedPanel, "TelaNovoPedido");


        //####################################################################################################### INICIO
        // Cria a tela inicial
        JPanel telaInicialPanel = new JPanel(new BorderLayout());
        // Painel do titulo
        JPanel titleTIPanel = new JPanel();
        titleTIPanel.setLayout(new BorderLayout());
        JLabel titleTILabel = new JLabel("Mecânica", SwingConstants.CENTER);
        titleTILabel.setFont(new Font("Arial", Font.BOLD, 42));
        titleTILabel.setForeground(new Color(0,0,0));
        titleTIPanel.setBorder(new EmptyBorder(50, 20, 0, 20));
        titleTIPanel.setBackground(new Color(158, 158, 158));
        titleTIPanel.add(titleTILabel, BorderLayout.CENTER);
        telaInicialPanel.add(titleTIPanel, BorderLayout.NORTH);

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
        clientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "TelaClientes");
            }
        });

        // Botão Serviços
        JButton servicosButton = new JButton("Serviços");
        servicosButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        servicosButton.setFont(new Font("Arial", Font.BOLD, 20));
        servicosButton.setBackground(Color.DARK_GRAY);
        servicosButton.setForeground(Color.white);
        servicosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "TelaServiços");
            }
        });

        //Botão Novo Pedido
        JButton novoPedidoButton = new JButton("Novo Pedido");
        novoPedidoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        novoPedidoButton.setFont(new Font("Arial", Font.BOLD, 20));
        novoPedidoButton.setBackground(Color.DARK_GRAY);
        novoPedidoButton.setForeground(Color.white);
        novoPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "TelaNovoPedido");
            }
        });

        // Botão Finanças
        JButton financasButton = new JButton("Finanças");
        financasButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        financasButton.setFont(new Font("Arial", Font.BOLD, 20));
        financasButton.setBackground(Color.DARK_GRAY);
        financasButton.setForeground(Color.white);
        financasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "TelaFinanças");
            }
        });

        // Botão Sair
        JButton sairButton = new JButton("Sair");
        sairButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sairButton.setFont(new Font("Arial", Font.BOLD, 20));
        sairButton.setBackground(new Color(178, 57, 57, 255));
        sairButton.setForeground(Color.white);
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(Mecanica.getProdutos());
                JsonParser jp = new JsonParser();
                jp.salvarMecanicaParaJson();
                System.exit(0);
            }
        });

        buttonPanel.add(produtosButton);
        buttonPanel.add(clientesButton);
        buttonPanel.add(servicosButton);
        buttonPanel.add(novoPedidoButton);
        buttonPanel.add(financasButton);
        buttonPanel.add(sairButton);

        telaInicialPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(telaInicialPanel, "TelaInicial");

        frame.add(mainPanel);

        frame.setVisible(true);

        cardLayout.show(mainPanel, "TelaInicial");
    }
}
