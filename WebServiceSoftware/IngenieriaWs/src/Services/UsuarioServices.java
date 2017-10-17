package Services;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class UsuarioServices {
	private String nombre;
	private String apellido;
	private String Password;
	private String nickName;
	private String email;
	private String rol;
	
	
	
	public UsuarioServices(String nombre, String apellido, String password, String nickName, String email,
			String rol) {

		this.nombre = nombre;
		this.apellido = apellido;
		Password = password;
		this.nickName = nickName;
		this.email = email;
		this.rol = rol;
	}



	public UsuarioServices() {
	
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

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String roles) {
		this.rol = roles;
	}



	
}
