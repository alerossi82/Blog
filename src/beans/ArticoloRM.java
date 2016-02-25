package beans;

public class ArticoloRM {
	private int id;
	private String ristorante;
	private String data;
	private String articolo;
	private String area;
	private String cucina;
	private String prezzo;
	private int voto;
	private String foto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRistorante() {
		return ristorante;
	}
	public void setRistorante(String ristorante) {
		this.ristorante = ristorante;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getArticolo() {
		return articolo;
	}
	/*public String getArticoloSummary() {
		return articolo.left(200) + "...";
	}*/
	public void setArticolo(String articolo) {
		this.articolo = articolo;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCucina() {
		return cucina;
	}
	public void setCucina(String cucina) {
		this.cucina = cucina;
	}
	public String getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}
	
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
}
