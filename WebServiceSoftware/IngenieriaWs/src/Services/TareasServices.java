package Services;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TareasServices {
	private int idTareaWS;
	private Double tiempoInicioWS;
	private Double tiempoFinWS;
	private String nombreTareaWS;
	public TareasServices(int idTareaWS, Double tiempoInicioWS, Double tiempoFinWS, String nombreTareaWS) {
		
		this.idTareaWS = idTareaWS;
		this.tiempoInicioWS = tiempoInicioWS;
		this.tiempoFinWS = tiempoFinWS;
		this.nombreTareaWS = nombreTareaWS;
	}
	public TareasServices() {
		
	}
	public int getIdTareaWS() {
		return idTareaWS;
	}
	public void setIdTareaWS(int idTareaWS) {
		this.idTareaWS = idTareaWS;
	}
	public Double getTiempoInicioWS() {
		return tiempoInicioWS;
	}
	public void setTiempoInicioWS(Double tiempoInicioWS) {
		this.tiempoInicioWS = tiempoInicioWS;
	}
	public Double getTiempoFinWS() {
		return tiempoFinWS;
	}
	public void setTiempoFinWS(Double tiempoFinWS) {
		this.tiempoFinWS = tiempoFinWS;
	}
	public String getNombreTareaWS() {
		return nombreTareaWS;
	}
	public void setNombreTareaWS(String nombreTareaWS) {
		this.nombreTareaWS = nombreTareaWS;
	}
	
	
	
	
}
