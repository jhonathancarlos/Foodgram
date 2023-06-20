package Foodgram;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import Foodgram.bean.Cliente;
import Foodgram.dao.ClienteDAO;
import Foodgram.dao.ClienteDAOImpl;
import Foodgram.bean.Empresa;
import Foodgram.dao.EmpresaDAO;
import Foodgram.dao.EmpresaDAOImpl;
import Foodgram.bean.Produto;
import Foodgram.dao.ProdutoDAO;
import Foodgram.dao.ProdutoDAOImpl;
import Foodgram.bean.Publicacao;
import Foodgram.dao.PublicacaoDAO;
import Foodgram.dao.PublicacaoDAOImpl;
import Foodgram.bean.Avaliacao;
import Foodgram.dao.AvaliacaoDAO;
import Foodgram.dao.AvaliacaoDAOImpl;

public class Executora {
	static Scanner ler = new Scanner(System.in);
	private static final ArrayList<Cliente> clientes = new ArrayList<>();
    private static final ArrayList<Empresa> empresas = new ArrayList<>();
//    private static final ArrayList<Publicacao> publicacoes = new ArrayList<>();
//    private static final ArrayList<Produto> produtos = new ArrayList<>();
//    private static final ArrayList<Avaliacao> avaliacoes = new ArrayList<>();

    private static final ClienteDAO clienteDAO = new ClienteDAOImpl();
    private static final EmpresaDAO empresaDAO = new EmpresaDAOImpl();
    private static final PublicacaoDAO publicacaoDAO = new PublicacaoDAOImpl();
    private static final ProdutoDAO produtoDAO = new ProdutoDAOImpl();
    private static final AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAOImpl();
    
    private static int iCC = 0;
    private static int iCE = 0;
    private static int iAP = 0;
    private static int iAPub = 0;
	
	public static void main(String[] args) {
		int op;
		
		do {
			System.out.println("\t\tBem-vindo ao Foodgram!\n");
			System.out.println("1 - LOGIN");
			System.out.println("2 - CADASTRAR USUARIO");
			System.out.println("0 - Sair");
			System.out.print("Informe a opcao desejada: ");
			op = ler.nextInt();
			ler.nextLine();
			
			switch(op) {
			case 1:
				System.out.println("LOGIN");
				realizarLogin();
				break;
			case 2:
				System.out.println("CADASTRO");
				realizarCadastro();
				break;
			case 0:
				System.out.println("Saindo...");
				ler.close();
				break;
			default:
				System.out.println("Opcao invalida! Tente novamente.\n");
			}
		} while(op != 0);
		
		ler.close();
	}
	
	public static void realizarLogin() {
		int op;
		
		do {
            System.out.println("1. Login como Cliente");
            System.out.println("2. Login como Empresa");
            System.out.println("0. Voltar");
            System.out.print("Informe a opcao desejada: ");
            op = ler.nextInt();
            ler.nextLine();

            switch (op) {
                case 1:
                    loginCliente();
                    break;
                case 2:
                    loginEmpresa();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...\n");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.\n");
            }
        } while (op != 0);
    }
	
	public static void realizarCadastro() {
		int op;
		
		do {
            System.out.println("\n=== Menu de Cadastro ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Empresa");
            System.out.println("0. Voltar");
            System.out.print("Informe a opcao desejada: ");
            op = ler.nextInt();
            ler.nextLine();

            switch (op) {
                case 1:
                	System.out.println("\n=== Cadastro Cliente ===");
                    cadastrarCliente();
                    break;
                case 2:
                	System.out.println("\n=== Cadastro Empresa ===");
                    cadastrarEmpresa();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...\n");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.\n");
            }
        } while (op != 0);
	}
	
	private static void loginCliente() {
        System.out.println("\n=== Login Cliente ===");
        System.out.print("Email: ");
        String email = ler.nextLine();
        System.out.print("Senha: ");
        String senha = ler.nextLine();

        Cliente cliente = clienteDAO.buscarClientePorEmail(email);

        if (cliente != null && cliente.getSenha().equals(senha)) {
            System.out.println("Login realizado com sucesso!\n");
            menuCliente(cliente);
        } else {
            System.out.println("Email ou senha incorretos!\n");
        }
    }
	
	private static void loginEmpresa() {
        System.out.println("\n=== Login Empresa ===");
        System.out.print("Email: ");
        String email = ler.nextLine();
        System.out.print("Senha: ");
        String senha = ler.nextLine();

        Empresa empresa = empresaDAO.buscarEmpresaPorEmail(email);

        if (empresa != null && empresa.getSenha().equals(senha)) {
            System.out.println("Login realizado com sucesso!\n");
            menuEmpresa(empresa);
        } else {
            System.out.println("Email ou senha incorretos!\n");
        }
    }
	
	public static void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = ler.nextLine();
        System.out.print("Email: ");
        String email = ler.nextLine();
        System.out.print("Senha: ");
        String senha = ler.nextLine();
        System.out.print("Registro: ");
        String registro = ler.nextLine();
        System.out.print("Telefone: ");
        String telefone = ler.nextLine();

        Cliente cliente = new Cliente(iCC, nome, email, senha, registro, telefone);
        clienteDAO.adicionarCliente(cliente);
        clientes.add(cliente);
        iCC++;

        System.out.println("Cadastro realizado com sucesso!\n");
	}
	
	public static void cadastrarEmpresa() {
        System.out.print("Nome: ");
        String nome = ler.nextLine();
        System.out.print("Email: ");
        String email = ler.nextLine();
        System.out.print("Senha: ");
        String senha = ler.nextLine();
        System.out.print("Registro: ");
        String registro = ler.nextLine();
        System.out.print("Telefone: ");
        String telefone = ler.nextLine();

        Empresa empresa = new Empresa(iCE, nome, email, senha, registro, telefone);
        empresaDAO.adicionarEmpresa(empresa);
        empresas.add(empresa);
        iCE++;
        
        System.out.println("Cadastro realizado com sucesso!\n");
	}
	
	private static void menuCliente(Cliente cliente) {
        int op;

        do {
            System.out.println("\n=== Menu Cliente ===");
            System.out.println("1. Avaliar");
            System.out.println("2. Meus Dados");
            System.out.println("0. Sair");
            System.out.print("Informe a opcao desejada: ");
            op = ler.nextInt();
            ler.nextLine();

            switch (op) {
                case 1:
                    gerenciarAvaliacoes(cliente);
                    break;
                case 2:
                    meusDadosCliente(cliente);
                    break;
                case 0:
                    System.out.println("Encerrando a sessao do cliente...\n");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.\n");
            }
        } while (op != 0);
    }
	
	private static void menuEmpresa(Empresa empresa) {
        int op;

        do {
            System.out.println("\n=== Menu Empresa ===");
            System.out.println("1. Gerenciar Produtos");
            System.out.println("2. Gerenciar Publicacoes");
            System.out.println("3. Meus Dados");
            System.out.println("0. Sair");
            System.out.print("Informe a opcao desejada: ");
            op = ler.nextInt();
            ler.nextLine();

            switch (op) {
                case 1:
                    gerenciarProdutos(empresa);
                    break;
                case 2:
                    gerenciarPublicacoes(empresa);
                    break;
                case 3:
                	meusDadosEmpresa(empresa);
                    break;
                case 0:
                    System.out.println("Encerrando a sessao da empresa...\n");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.\n");
            }
        } while (op != 0);
    }
	
	private static void gerenciarProdutos(Empresa empresa) {
        int op;

        do {
            System.out.println("\n=== Gerenciar Produtos ===");
            System.out.println("1. Listar Produtos");
            System.out.println("2. Adicionar Produto");
            System.out.println("3. Remover Produto");
            System.out.println("0. Voltar");
            System.out.print("Informe a opcao desejada: ");
            op = ler.nextInt();
            ler.nextLine();

            switch (op) {
                case 1:
                    listarProdutos(empresa);
                    break;
                case 2:
                    adicionarProduto(empresa);
                    break;
                case 3:
                    removerProduto(empresa);
                    break;
                case 0:
                    System.out.println("Voltando ao menu da empresa...\n");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.\n");
            }
        } while (op != 0);
    }
	
	private static void gerenciarPublicacoes(Empresa empresa) {
        int op;

        do {
            System.out.println("\n=== Gerenciar Publicacoes ===");
            System.out.println("1. Listar Publicacoes");
            System.out.println("2. Adicionar Publicacao");
            System.out.println("3. Remover Publicacao");
            System.out.println("0. Voltar");
            System.out.print("Informe a opcao desejada: ");
            op = ler.nextInt();
            ler.nextLine();

            switch (op) {
                case 1:
                    listarPublicacoes(empresa);
                    break;
                case 2:
                    adicionarPublicacao(empresa);
                    break;
                case 3:
                    removerPublicacao(empresa);
                    break;
                case 0:
                    System.out.println("Voltando ao menu da empresa...\n");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.\n");
            }
        } while (op != 0);
    }
	
	private static void meusDadosCliente(Cliente cliente) {
		int op;
		
		do {
            System.out.println("\n=== Meus Dados ===");
            System.out.println("1. Visualizar Dados");
            System.out.println("2. Alterar Dados");
            System.out.println("0. Sair");
            System.out.print("Informe a opcao desejada: ");
            op = ler.nextInt();
            ler.nextLine();

            switch (op) {
                case 1:
                	System.out.println(cliente.toString());
                    break;
                case 2:
                    editarDadosCliente(cliente);
                    break;
                case 0:
                    System.out.println("Encerrando a sessao do cliente...\n");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.\n");
            }
        } while (op != 0);
	}
	
	private static void editarDadosCliente(Cliente cliente) {
	    System.out.println("\n=== Editar Dados do Cliente ===");
	    System.out.print("Email do cliente: ");
	    String emailCliente = ler.nextLine();

	    cliente = clienteDAO.buscarClientePorEmail(emailCliente);

	    if (cliente != null) {
	        System.out.print("Novo nome: ");
	        String novoNome = ler.nextLine();
	        System.out.print("Nova senha: ");
	        String novaSenha = ler.nextLine();
	        System.out.print("Novo email: ");
	        String novoEmail = ler.nextLine();
	        System.out.print("Novo telefone: ");
	        String novoTelefone = ler.nextLine();

	        cliente.setNome(novoNome);
	        cliente.setSenha(novaSenha);
	        cliente.setEmail(novoEmail);
	        cliente.setTelefone(novoTelefone);

	        clienteDAO.atualizarCliente(cliente);
	        System.out.println("Dados do cliente atualizados com sucesso!\n");
	    } else {
	        System.out.println("Cliente nao encontrado.\n");
	    }
	}
	
	private static void meusDadosEmpresa(Empresa empresa) {
		int op;
		
		do {
            System.out.println("\n=== Meus Dados ===");
            System.out.println("1. Visualizar Dados");
            System.out.println("2. Alterar Dados");
            System.out.println("0. Sair");
            System.out.print("Informe a opcao desejada: ");
            op = ler.nextInt();
            ler.nextLine();

            switch (op) {
                case 1:
                	System.out.println(empresa.toString());
                    break;
                case 2:
                    editarDadosEmpresa(empresa);
                    break;
                case 0:
                    System.out.println("Encerrando a sessao do cliente...\n");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.\n");
            }
        } while (op != 0);
	}

	private static void editarDadosEmpresa(Empresa empresa) {
	    System.out.println("\n=== Editar Dados da Empresa ===");
	    System.out.print("Email da empresa: ");
	    String emailEmpresa = ler.nextLine();

	    empresa = empresaDAO.buscarEmpresaPorEmail(emailEmpresa);

	    if (empresa != null) {
	        System.out.print("Novo nome: ");
	        String novoNome = ler.nextLine();
	        System.out.print("Nova senha: ");
	        String novaSenha = ler.nextLine();
	        System.out.print("Novo email: ");
	        String novoEmail = ler.nextLine();
	        System.out.print("Novo telefone: ");
	        String novoTelefone = ler.nextLine();

	        empresa.setNome(novoNome);
	        empresa.setSenha(novaSenha);
	        empresa.setEmail(novoEmail);
	        empresa.setTelefone(novoTelefone);

	        empresaDAO.atualizarEmpresa(empresa);
	        System.out.println("Dados da empresa atualizados com sucesso!\n");
	    } else {
	        System.out.println("Empresa nao encontrada.\n");
	    }
	}
	
    private static void gerenciarAvaliacoes(Cliente cliente) {
        int op;

        do {
            System.out.println("\n=== Gerenciar Avaliacoes ===");
            System.out.println("1. Listar Avaliacoes");
            System.out.println("2. Adicionar Avaliacao");
            System.out.println("3. Remover Avaliacao");
            System.out.println("0. Voltar");
            System.out.print("Informe a opcao desejada: ");
            op = ler.nextInt();
            ler.nextLine();

            switch (op) {
                case 1:
                    listarAvaliacoes(cliente);
                    break;
                case 2:
                    adicionarAvaliacao(cliente);
                    break;
                case 3:
                    removerAvaliacao(cliente);
                    break;
                case 0:
                    System.out.println("Voltando ao menu do cliente...\n");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.\n");
            }
        } while (op != 0);
    }
    
    private static void listarProdutos(Empresa empresa) {
        System.out.println("\n=== Lista de Produtos ===");
        List<Produto> produtos = produtoDAO.buscarProdutosPorEmpresaId(empresa.getId());

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.\n");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }
    
    private static void adicionarProduto(Empresa empresa) {
        System.out.println("\n=== Adicionar Produto ===");
        System.out.print("Descricao: ");
        String descricao = ler.nextLine();
        System.out.print("Valor: ");
        float valor = ler.nextFloat();

        Produto produto = new Produto(iAP, descricao, valor, empresa.getId());
        produtoDAO.adicionarProduto(produto);
        iAP++;
        System.out.println("Produto adicionado com sucesso!\n");
        
    }
    
    private static void removerProduto(Empresa empresa) {
        System.out.println("\n=== Remover Produto ===");
        System.out.print("ID do produto: ");
        int id = ler.nextInt();
        ler.nextLine();

        Produto produto = produtoDAO.buscarProdutoPorId(id);

        if (produto != null && produto.getId_Empresa() == empresa.getId()) {
            produtoDAO.removerProduto(produto);
            System.out.println("Produto removido com sucesso!\n");
        } else {
            System.out.println("Produto nao encontrado ou nao pertence a empresa.\n");
        }
    }
    
    private static void listarPublicacoes(Empresa empresa) {
        System.out.println("\n=== Lista de Publicacoes ===");
        List<Publicacao> publicacoes = publicacaoDAO.buscarPublicacoesPorEmpresaId(empresa.getId());

        if (publicacoes.isEmpty()) {
            System.out.println("Nenhuma publicacao cadastrada.\n");
        } else {
            for (Publicacao publicacao : publicacoes) {
                System.out.println(publicacao);
            }
        }
    }
    
    private static void adicionarPublicacao(Empresa empresa) {
        System.out.println("\n=== Adicionar Publicacao ===");
        System.out.print("Descricao: ");
        String descricao = ler.nextLine();
        System.out.print("ID do produto: ");
        int Id_Produto = ler.nextInt();
        ler.nextLine();

        Produto produto = produtoDAO.buscarProdutoPorId(Id_Produto);

        if (produto != null && produto.getId_Empresa() == empresa.getId()) {
            Publicacao publicacao = new Publicacao(iAPub, descricao, Id_Produto, empresa.getId());
            publicacaoDAO.adicionarPublicacao(publicacao);
            iAPub++;
            System.out.println("Publicacao adicionada com sucesso!\n");
        } else {
            System.out.println("Produto nao encontrado ou nao pertence a empresa.\n");
        }
    }
    
    private static void removerPublicacao(Empresa empresa) {
        System.out.println("\n=== Remover Publicacao ===");
        System.out.print("ID da publicacao: ");
        int id = ler.nextInt();
        ler.nextLine();

        Publicacao publicacao = publicacaoDAO.buscarPublicacaoPorId(id);

        if (publicacao != null && publicacao.getId_Empresa() == empresa.getId()) {
            publicacaoDAO.removerPublicacao(publicacao);
            System.out.println("Publicacao removida com sucesso!\n");
        } else {
            System.out.println("Publicacao nao encontrada ou nao pertence a empresa.\n");
        }
    }
    
    private static void listarAvaliacoes(Cliente cliente) {
        System.out.println("\n=== Lista de Avaliacoes ===");
        List<Avaliacao> avaliacoes = avaliacaoDAO.buscarAvaliacoesPorClienteId(cliente.getId());

        if (avaliacoes.isEmpty()) {
            System.out.println("Nenhuma avaliacao cadastrada.\n");
        } else {
            for (Avaliacao avaliacao : avaliacoes) {
                System.out.println(avaliacao);
            }
        }
    }
    
    private static void adicionarAvaliacao(Cliente cliente) {
        System.out.println("\n=== Adicionar Avaliacao ===");
        System.out.print("Descricao: ");
        String descricao = ler.nextLine();
        System.out.print("Estrelas: ");
        float estrelas = ler.nextFloat();
        System.out.print("ID da publicacao: ");
        int idPublicacao = ler.nextInt();
        ler.nextLine();

        Publicacao publicacao = publicacaoDAO.buscarPublicacaoPorId(idPublicacao);

        if (publicacao != null) {
            Avaliacao avaliacao = new Avaliacao(0, descricao, estrelas, cliente.getId(), idPublicacao);
            avaliacaoDAO.adicionarAvaliacao(avaliacao);
            System.out.println("Avaliação adicionada com sucesso!\n");
        } else {
            System.out.println("Publicação não encontrada.\n");
        }
    }
    
    private static void removerAvaliacao(Cliente cliente) {
        System.out.println("\n=== Remover Avaliacao ===");
        System.out.print("ID da avaliacao: ");
        int id = ler.nextInt();
        ler.nextLine();

        Avaliacao avaliacao = avaliacaoDAO.buscarAvaliacaoPorId(id);

        if (avaliacao != null && avaliacao.getId_Cliente() == cliente.getId()) {
            avaliacaoDAO.removerAvaliacao(avaliacao);
            System.out.println("Avaliacao removida com sucesso!\n");
        } else {
            System.out.println("Avaliacao nao encontrada ou nao pertence ao cliente.\n");
        }
    }

}