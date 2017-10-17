package Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the proceso database table.
 * 
 */
@Entity
@NamedQuery(name="Proceso.findAll", query="SELECT p FROM Proceso p")
public class Proceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idProceso;

	private String nombreProceso;

	//bi-directional many-to-one association to Tarea
	@ManyToOne
	@JoinColumn(name="Tareas")
	private Tarea tarea;
	private List<Tarea> tareas;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="Participantes")
	private Usuario usuario;
	private List<Usuario>usuarios;

	public Proceso() {
	}

	public int getIdProceso() {
		return this.idProceso;
	}

	public void setIdProceso(int idProceso) {
		this.idProceso = idProceso;
	}

	public String getNombreProceso() {
		return this.nombreProceso;
	}

	public void setNombreProceso(String nombreProceso) {
		this.nombreProceso = nombreProceso;
	}

	public Tarea getTarea() {
		return this.tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	

}