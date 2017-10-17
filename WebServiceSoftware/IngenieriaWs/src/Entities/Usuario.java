package Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String apellido;

	private String email;

	private String nickname;

	private String nombre;

	private String password;

	//bi-directional many-to-one association to Proceso
	@OneToMany(mappedBy="usuario")
	private List<Proceso> procesos;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="rol")
	private Rol rolBean;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Proceso> getProcesos() {
		return this.procesos;
	}

	public void setProcesos(List<Proceso> procesos) {
		this.procesos = procesos;
	}

	public Proceso addProceso(Proceso proceso) {
		getProcesos().add(proceso);
		proceso.setUsuario(this);

		return proceso;
	}

	public Proceso removeProceso(Proceso proceso) {
		getProcesos().remove(proceso);
		proceso.setUsuario(null);

		return proceso;
	}

	public Rol getRolBean() {
		return this.rolBean;
	}

	public void setRolBean(Rol rolBean) {
		this.rolBean = rolBean;
	}

}