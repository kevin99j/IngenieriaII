package Services;

import java.util.List;
import Entities.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProcesosServices {
	private String nombreProceso;
	private int idProceso;
	private List<Usuario>participantes;
	private List<Tarea>tareas;
	public ProcesosServices() {
		
	}
	public ProcesosServices(String nombreProceso, int idProceso, List<Usuario> participantes, List<Tarea> tareas) {
		
		this.nombreProceso = nombreProceso;
		this.idProceso = idProceso;
		this.participantes = participantes;
		this.tareas = tareas;
	}
	public String getNombreProceso() {
		return nombreProceso;
	}
	public void setNombreProceso(String nombreProceso) {
		this.nombreProceso = nombreProceso;
	}
	public int getIdProceso() {
		return idProceso;
	}
	public void setIdProceso(int idProceso) {
		this.idProceso = idProceso;
	}
	public List<Usuario> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(List<Usuario> participantes) {
		this.participantes = participantes;
	}
	public List<Tarea> getTareas() {
		return tareas;
	}
	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	
	
}
