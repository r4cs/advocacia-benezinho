package br.com.fiap;

import br.com.fiap.domain.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("maria-db");
    private static EntityManager manager = factory.createEntityManager();
    public static void main(String[] args) {

        populateEstados();
        populateTipoDeAcao();

        boolean continuar = true;

        while (continuar) {
            int escolha = showMenu();

            switch (escolha) {
                case 1:
                    inserirProcessos();
                    break;
                case 2:
                    consultaTodosProcessos();
                    break;
                case 3:
                    consultaProcesso();
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        manager.close();
        factory.close();
    }

    private static void consultaProcesso() {
            String id_processo = JOptionPane.showInputDialog( "Insira o id do processo: " );
            manager.find(Processo.class, id_processo);
            Processo processo = manager.find(Processo.class, id_processo);
            if (processo != null) {
                manager.getTransaction().begin();
                System.out.println("Processo encontrado!");
                System.out.println("Info: " + processo);
            } else {
                System.out.println("Processo não encontrado!");
            }

            System.out.println("Pesquisa de processo encerrada.");
        }

    private static void consultaTodosProcessos() {
        try {
            TypedQuery<Processo> query = manager.createQuery("SELECT p FROM Processo p", Processo.class);
            List<Processo> processos = query.getResultList();

            for (Processo p : processos) {
                System.out.println("Processo: " + p);
            }
        } finally {
            System.out.println("Pesquisa encerrada.");
        }
    }

    private static TipoDeAcao selecTipoDeAcao() {
        List<TipoDeAcao> listaAcoesJud = new ArrayList<>();
        for (TpAcaoJud taj: TpAcaoJud.values()) {
            listaAcoesJud.add(taj.getTipoDeAcao());
        }
        // incluir aqui JOPane
        return selectInfoTpAcao(listaAcoesJud);
    }

    private static Estado selectEstados() {
        List<Estado> estadosBrasileiros = new ArrayList<>();
        for (UfBrasileiras uf: UfBrasileiras.values()) {
            estadosBrasileiros.add(uf.getEstado());
            System.out.println("estado: " + uf.getEstado());
        }
        // incluir aqui JOPane
        return selectInfoEstado(estadosBrasileiros);
    }

    private static void populateTipoDeAcao() {
        for (TpAcaoJud taj: TpAcaoJud.values()) {
            try {
                manager.getTransaction().begin();
                manager.persist(taj.getTipoDeAcao());
                manager.getTransaction().commit();
                System.out.println(taj.getTipoDeAcao());
            } catch (Exception e) {
                System.out.println("Erro em populateTpAcaoJud(): " + e);
            }
        }
    }
    private static void populateEstados() {
        for (UfBrasileiras uf: UfBrasileiras.values()) {
            try {
                manager.getTransaction().begin();
                manager.persist( uf.getEstado() );
                manager.getTransaction().commit();
                System.out.println( uf.getEstado() );
            } catch (Exception e) {
                System.out.println("Erro! em populateEstados(): " + e);
            }
        }
    }

    private static void CreateTpProcesso() {
    manager.getTransaction().begin();
    for (TipoDeAcao tda : TipoDeAcao.class.getEnumConstants()) {
        TipoDeAcao tipoDeAcao = new TipoDeAcao();
        tipoDeAcao.setNome(tda.getNome());

        manager.persist(tipoDeAcao);
    }
        manager.getTransaction().commit();
    }

//    private static <T> T selectInfo(List<T> options) {
    private static TipoDeAcao selectInfoTpAcao(List<TipoDeAcao> options) {
        TipoDeAcao selectedIndex = (TipoDeAcao) JOptionPane.showInputDialog(
                null,
                "Selecione um Tipo de ação",
                "Seleção de Tipo de ação",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options.toArray(),
                options.get( 0 )
        );
        return selectedIndex;
    }

    private static Estado selectInfoEstado(List<Estado> options) {
        Estado selectedIndex = (Estado) JOptionPane.showInputDialog(
                null,
                "Selecione o Estado",
                "Seleção de Estado",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options.toArray(),
                options.get( 0 )
        );
        return selectedIndex;
    }

    private static Advogado inserirAdv() {
        // advogado => null id, Stting nome, String oab, Estado uf
        String nomeAdv = JOptionPane.showInputDialog("Insira o nome do advogado: ");
        String oab = JOptionPane.showInputDialog("Insira a OAB do advogado: ");

        Advogado advogado = new Advogado(null, nomeAdv, oab, selectEstados());
        try {
            manager.getTransaction().begin();
            manager.persist(advogado);
            manager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro! em inserirAdv(): " + e);
        }

        return advogado;
    }

    private static void inserirProcessos() {
       // null id, String numero, Boolean proBono, Advogado advogado, TipoDeAcao tipoDeAcao
        String numeroProc = JOptionPane.showInputDialog("Insira o numero do processo: ");
        Boolean proBono = Boolean.valueOf(JOptionPane.showInputDialog("Pro bono (true/false) ?"));
        Processo processo = new Processo(
                                    null,
                                    numeroProc,
                                    proBono,
                                    inserirAdv(),
                                    selecTipoDeAcao()
        );
        try {
            manager.getTransaction().begin();
            manager.persist(processo);
            manager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro! em inserirProcesso(): " + e);
        }

    }

    private static int showMenu() {
        String[] opcoes = {"Inserir Processo", "Consultar Todos os Processos", "Consultar Processo", "Sair"};
        return JOptionPane.showOptionDialog(
                null,
                "Escolha uma opção:",
                "Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );
    }
}