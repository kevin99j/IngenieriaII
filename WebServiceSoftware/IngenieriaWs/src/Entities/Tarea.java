package Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tareas database table.
 * 
 */
@Entity
@Table(name="tareas")
@NamedQuery(name="Tarea.findAll", query="SELECT t FROM Tarea t")
public class Tarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTarea;

	private String nombreTarea;

	private double tiempoFin;

	private double tiempoInicio;

	//bi-directional many-to-one association to Proceso
	@OneToMany(mappedBy="tarea")
	private List<Proceso> procesos;

	public Tarea() {
	}

	public int getIdTarea() {
		return this.idTarea;
	}

	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}

	public String getNombreTarea() {
		return this.nombreTarea;
	}

	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}

	public double getTiempoFin() {
		return this.tiempoFin;
	}

	public void setTiempoFin(double tiempoFin) {
		this.tiempoFin = tiempoFin;
	}

	public double getTiempoInicio() {
		return this.tiempoInicio;
	}

	public void setTiempoInicio(double tiempoInicio) {
		this.tiempoInicio = tiempoInicio;
	}

	public List<Proceso> getProcesos() {
		return this.procesos;
	}

	public void setProcesos(List<Proceso> procesos) {
		this.procesos = procesos;
	}

	public Proceso addProceso(Proceso proceso) {
		getProcesos().add(proceso);
		proceso.setTarea(this);

		return proceso;
	}

	public Proceso removeProceso(Proceso proceso) {
		getProcesos().remove(proceso);
		proceso.setTarea(null);

		return proceso;
	}

}