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

import Entities.*;
import Services.*;

@Path("/usuarioController")
public class UsuarioController {
	private String nombre;
	private String apellido;
	private String Password;
	private String nickName;
	private int idUsuario;
	private String email;
	private List<Rol>roles;
	private Usuario usuario;
	private EntityManager em;
	private EntityManagerFactory emf;
	private List<UsuarioServices> usuarios;
private List<Usuario> users;


	public UsuarioController() { 
		emf = Persistence.createEntityManagerFactory("IngenieriaWs");
		em = this.emf.createEntityManager();
		this.roles=consultaRoles();
		this.usuario= new Usuario();
		this.usuarios= consultarUsuarios();
		this.users = consultausers();

	}
	@GET
	@Path("/consultarUsuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioServices> consultarUsuarios() {
		String consulta = "SELECT u FROM Usuario u";
		Query query = em.createQuery(consulta);
		List<Usuario>usuarios= query.getResultList();
		List<UsuarioServices>users= new ArrayList<>();
		for (Usuario user : usuarios) {
			UsuarioServices uno =  new UsuarioServices(user.getNombre(),
					user.getApellido(),user.getPassword(),user.getNickname(),user.getEmail(),user.getRolBean().getNombreRol());
			users.add(uno);
			System.out.println(uno+ "object: ");
		}

		return users;
	}

	@POST
	@Path("/crearUsuarios")
	@Consumes(MediaType.APPLICATION_JSON)
	public void crearUsuario(UsuarioServices usuario) {
		Usuario user= new Usuario();
		user.setNombre(usuario.getNombre());
		user.setApellido(usuario.getApellido());
		user.setPassword(usuario.getPassword());
		user.setEmail(usuario.getEmail());
		user.setNickname(usuario.getNickName());
	
		for (Rol rol : roles) {
			System.out.println(rol.getNombreRol());
			System.out.println(usuario.getRol());
			if(usuario.getRol().equals(rol.getNombreRol())) {
				user.setRolBean(rol);
				System.out.println("done");
			}else{
				System.out.println("Que intenta hacer Perro ?");
			}
		}

		
		System.out.println(user);

		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("error: "+e);
		}

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/imprimir")
	public void imprimir(String e) {
		System.out.println(e);
	}

	public List<Rol>consultaRoles() {
		String consulta = "SELECT r FROM Rol r";
		Query query = em.createQuery(consulta);
		List<Rol>roles = query.getResultList();
		return roles;
	}

	public List<Usuario>consultausers() {
		String consulta = "SELECT r FROM Rol r";
		Query query = em.createQuery(consulta);
		List<Usuario>users = query.getResultList();
		return users;
	}

@POST
@Path("/modificarUsers")
@Consumes(MediaType.APPLICATION_JSON)
public void modificarUsers(UsuarioServices usuarioWS) {
	//Usuario usuario = new Usuario();
	for (Usuario user : users) {
		if(user.getNickname().equals(usuarioWS.getNickName())) {
			this.usuario =user;
			
		}
	}
	
	try {
		this.em.getTransaction().begin();
		this.em.merge(this.usuario);
		this.em.getTransaction().commit();
		
	} catch (Exception e) {
		System.out.println(e);
	}
}

@POST
@Path("/eliminarUsers")
@Consumes(MediaType.APPLICATION_JSON)
public void eliminarUsers(UsuarioServices nickName) {

	users.forEach((user)->{
		if(user.getNickname().equals(nickName.getNickName())) {
			try {
System.out.println(user.getNickname());
				this.em.getTransaction().begin();
				this.em.remove(user);
				this.em.getTransaction().commit();
				this.em = this.emf.createEntityManager();
				this.usuario = new Usuario();
				this.usuarios = consultarUsuarios();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
	});
		if (nickName != null) {
			
			
		}

	}

public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	public List<UsuarioServices> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<UsuarioServices> usuarios) {
		this.usuarios = usuarios;
	}



}
