package beans;

public class Articolo {

	private int id;
	private String ristorante;
	private String data;
	private String articolo;
	private int IDArea;
	private int IDCucina;
	private int IDPrezzo;
	private int IDVoto;
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

	public void setArticolo(String articolo) {
		this.articolo = articolo;
	}

	public int getIDArea() {
		return IDArea;
	}

	public void setIDArea(int iDArea) {
		IDArea = iDArea;
	}

	public int getIDCucina() {
		return IDCucina;
	}

	public void setIDCucina(int iDCucina) {
		IDCucina = iDCucina;
	}

	public int getIDPrezzo() {
		return IDPrezzo;
	}

	public void setIDPrezzo(int iDPrezzo) {
		IDPrezzo = iDPrezzo;
	}

	public int getIDVoto() {
		return IDVoto;
	}

	public void setIDVoto(int iDVoto) {
		IDVoto = iDVoto;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
