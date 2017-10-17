package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Entities.Tarea;

import Services.TareasServices;

@Path("/tareasController")
public class TareasController {

	private int idTarea;
	private Double tiempoInicio;
	private Double tiempoFin;
	private String nombreTarea;
	private EntityManager em;
	private EntityManagerFactory emf;

	public TareasController() {
		emf =Persistence.createEntityManagerFactory("IngenieriaWs");
        em= this.emf.createEntityManager();
	}
	
	@POST
	@Path("/crearTareas")
	@Consumes(MediaType.APPLICATION_JSON)
	public void crearTarea(TareasServices task) {
	Tarea tarea = new Tarea();
	tarea.setIdTarea(task.getIdTareaWS());
	tarea.setNombreTarea(task.getNombreTareaWS());
	tarea.setTiempoFin(task.getTiempoFinWS());
	tarea.setTiempoInicio(task.getTiempoInicioWS());
try {
	em.getTransaction().begin();
	em.persist(tarea);
	em.getTransaction().commit();
} catch (Exception e) {
	System.out.println("error: "+e);
}
	
	}
	
	
@GET
@Path("/consultarTareas")
@Produces(MediaType.APPLICATION_JSON)
public List<TareasServices>consultarTareas(){
	String consulta= "Select t From Tarea t";
	Query query = em.createQuery(consulta);
	List<Tarea>tareas= query.getResultList();
	List<TareasServices>tasks= new ArrayList<TareasServices>();
	TareasServices task;
	for (Tarea tarea : tareas) {
		task= new TareasServices(tarea.getIdTarea(),tarea.getTiempoInicio(),tarea.getTiempoFin(),tarea.getNombreTarea());
tasks.add(task);	
	}
	
	return tasks;
}
	
	
	
	
	public int getIdTarea() {
		return idTarea;
	}
	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}
	public Double getTiempoInicio() {
		return tiempoInicio;
	}
	public void setTiempoInicio(Double tiempoInicio) {
		this.tiempoInicio = tiempoInicio;
	}
	public Double getTiempoFin() {
		return tiempoFin;
	}
	public void setTiempoFin(Double tiempoFin) {
		this.tiempoFin = tiempoFin;
	}
	public String getNombreTarea() {
		return nombreTarea;
	}
	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}




}
