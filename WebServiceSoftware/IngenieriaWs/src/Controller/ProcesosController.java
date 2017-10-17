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

import Entities.Proceso;
import Services.*;
@Path("/procesosController")
public class ProcesosController {
private String nombreProceso;
private int idProceso;
private List<ProcesosServices>procesos;

private List<TareasServices>tareas;
private EntityManager em;
private EntityManagerFactory emf;
private Proceso proceso;

public ProcesosController() {
	emf=Persistence.createEntityManagerFactory("IngenieriaWs");
	em = this.emf.createEntityManager();
	this.proceso = new Proceso();
	this.procesos = consultarProcesos();
	
}


@POST
@Path("/crearProcesos")
@Consumes(MediaType.APPLICATION_JSON)
public void crearProceso(ProcesosServices proceso) {
	Proceso Proccess = new Proceso();
	Proccess.setIdProceso(proceso.getIdProceso());
	Proccess.setNombreProceso(proceso.getNombreProceso());
	Proccess.setTareas((proceso.getTareas()));
	Proccess.setUsuarios(proceso.getParticipantes());
	try {
		em.getTransaction().begin();
		em.persist(Proccess);
		em.getTransaction().commit();
	} catch (Exception e) {
		System.out.println("error: "+e);
	}
}


@GET
@Path("/consultarProcesos")
@Produces(MediaType.APPLICATION_JSON)
public List<ProcesosServices>consultarProcesos(){
	String consulta = "Select p From Procesos p";
	Query query = em.createQuery(consulta);
	List<Proceso>procesos =query.getResultList();
	List<ProcesosServices> Procesos2 = new ArrayList<ProcesosServices>();
	ProcesosServices process ;
	for (Proceso proceso : procesos) {
		process = new ProcesosServices(proceso.getNombreProceso(),proceso.getIdProceso()
				,proceso.getUsuarios(),proceso.getTareas());
		Procesos2.add(process);
	}
	return Procesos2;
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

public List<ProcesosServices> getProcesos() {
	return procesos;
}

public void setProcesos(List<ProcesosServices> procesos) {
	this.procesos = procesos;
}

public List<TareasServices> getTareas() {
	return tareas;
}

public void setTareas(List<TareasServices> tareas) {
	this.tareas = tareas;
}


}
