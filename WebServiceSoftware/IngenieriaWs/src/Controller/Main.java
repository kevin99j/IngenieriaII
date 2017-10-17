package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Entities.Rol;
import Entities.Usuario;
import Services.UsuarioServices;

public class Main {
	static String nombre;
	static String apellido;
	static String Password;
	static String nickName;
	static int idUsuario;
	static String email;
	static List<Rol>roles;
	static EntityManager em;
	static EntityManagerFactory emf;
	static List<UsuarioServices> usuarios;
	static List<Usuario> users;
	public static void main(String[] args) {
		emf = Persistence.createEntityManagerFactory("IngenieriaWs");
		em = emf.createEntityManager();
crearUsuario();
	}

	
	
	public static void crearUsuario() {
		roles = consultaRoles();
		users= consultausers();
		Usuario user= new Usuario();
		user.setNombre("mariela");
		
		user.setApellido("hernandez");
		user.setPassword("sdfghjkl");
		user.setEmail("mernandes");
		user.setNickname("keernal");
		System.out.println("  ");
		for (Rol rol : roles) {
			System.out.println(rol.getNombreRol());
			if(rol.getNombreRol().equals("Participante")) {
				user.setRolBean(rol);
			System.out.println(rol.getNombreRol()+"entro acaá" );
			}else {
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

	public static List<Rol>consultaRoles() {
		String consulta = "SELECT r FROM Rol r";
		Query query = em.createQuery(consulta);
		List<Rol>roles = query.getResultList();
		return roles;
	}
	public static List<Usuario>consultausers() {
		String consulta = "SELECT r FROM Rol r";
		Query query = em.createQuery(consulta);
		List<Usuario>users = query.getResultList();
		return users;
	}

}
