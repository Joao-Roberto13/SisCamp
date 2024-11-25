package pacote;
import java.io.Serializable;

public class NewsInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titulo;
    private String horaInicio;
    private String horaFim;
    private String equipasEmJogo;
    private String marcasJogo;
    private String autoresMarca;
    private String arbitros;

    // Construtor vazio
    public NewsInfo() {}

    // Construtor com todos os parâmetros
    public NewsInfo(String titulo, String horaInicio, String horaFim,
                    String equipasEmJogo, String marcasJogo, String autoresMarca, String arbitros) {
        this.titulo = titulo;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.equipasEmJogo = equipasEmJogo;
        this.marcasJogo = marcasJogo;
        this.autoresMarca = autoresMarca;
        this.arbitros = arbitros;
    }

    // Métodos getters e setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getHoraInicio() { return horaInicio; }
    public void setHoraInicio(String horaInicio) { this.horaInicio = horaInicio; }

    public String getHoraFim() { return horaFim; }
    public void setHoraFim(String horaFim) { this.horaFim = horaFim; }

    public String getEquipasEmJogo() { return equipasEmJogo; }
    public void setEquipasEmJogo(String equipasEmJogo) { this.equipasEmJogo = equipasEmJogo; }

    public String getMarcasJogo() { return marcasJogo; }
    public void setMarcasJogo(String marcasJogo) { this.marcasJogo = marcasJogo; }

    public String getAutoresMarca() { return autoresMarca; }
    public void setAutoresMarca(String autoresMarca) { this.autoresMarca = autoresMarca; }

    public String getArbitros() { return arbitros; }
    public void setArbitros(String arbitros) { this.arbitros = arbitros; }
}
