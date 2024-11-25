package pacote;

import java.io.*;
import java.util.Hashtable;

public class News_DB implements Serializable {
    private static final long serialVersionUID = 1L;
    private Hashtable<String, NewsInfo> tabela;
    private int Id = 1;

    public News_DB() {
        tabela = new Hashtable<>();
        loadNewsFromFile(); // Carregar dados ao inicializar
    }

    public void storeNewNews(String titulo, NewsInfo n) {
        System.out.println("DEBUG: storeNewNews: tema=" + titulo);
        tabela.put(titulo, n);
        Id++;

        try (FileOutputStream datafile = new FileOutputStream("C:\\Users\\jring\\.vscode\\P.O.O\\SisCamp\\news_db.dat");
             ObjectOutputStream obj = new ObjectOutputStream(datafile)) {

            // Gravar a tabela completa no arquivo
            obj.writeObject(tabela); // Grava a `tabela` completa para manter todas as notícias
            System.out.println("DEBUG: Tabela de notícias gravada com sucesso.");

        } catch (IOException error) {
            System.out.println("Erro de escrita no ficheiro: " + error.getMessage());
        }
    }

    public void loadNewsFromFile() {
        File file = new File("C:\\Users\\jring\\.vscode\\P.O.O\\SisCamp\\news_db.dat");

        // Verificar se o arquivo existe antes de tentar ler
        if (!file.exists()) {
            System.out.println("Arquivo de notícias não encontrado. Nenhuma notícia carregada.");
            return;
        }

        try (FileInputStream datafile = new FileInputStream(file);
             ObjectInputStream obj = new ObjectInputStream(datafile)) {
             
            // Tentativa de ler o objeto
            Object loadedData = obj.readObject();

            // Verificar se o objeto lido é uma Hashtable, para evitar ClassCastException
            if (loadedData instanceof Hashtable) {
                tabela = (Hashtable<String, NewsInfo>) loadedData;
                Id = tabela.size() + 1; // Atualizar o Id com base no tamanho da tabela
                System.out.println("DEBUG: Notícias carregadas com sucesso.");
            } else {
                System.out.println("Erro: Dados carregados não são do tipo Hashtable.");
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de notícias: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro de classe não encontrada ao carregar notícias: " + e.getMessage());
        }
    }

    /*public boolean checkNews(String tema, String titulo) {
        NewsInfo n = tabela.get(titulo);
        return n != null && n.getTema().equals(tema);
    }*/

    public boolean NewsExist(String titulo) {
        return tabela.containsKey(titulo);
    }

    public Hashtable<String, NewsInfo> getAllNews() {
        System.out.println("DEBUG: Retornando todas as notícias carregadas.");
        return tabela; // Retorna a tabela completa, já carregada pelo método `loadNewsFromFile`
    }
}
