package src;

import java.util.ArrayList;
import java.util.Set;

public class Kanban {
	private String nombreIdentificador;
	private ArrayList<Tarea> tareas;
	private Set<Usuario> colaboradores;

	public Kanban(String nombreIdentificador) {
		super();
		this.nombreIdentificador = nombreIdentificador;
	}

	public Boolean agregarUnaTarea(Tarea nueva) {
		Boolean sePudoAgregar;
		sePudoAgregar = tareas.add(nueva);
		return sePudoAgregar;
	}

	public String getNombreIdentificador() {
		return nombreIdentificador;
	}

	public void setNombreIdentificador(String nombreIdentificador) {
		this.nombreIdentificador = nombreIdentificador;
	}

	public void aniadirUnColaborador(Usuario nuevo) {
		this.colaboradores.add(nuevo);
		nuevo.unirAUnKanban(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreIdentificador == null) ? 0 : nombreIdentificador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kanban other = (Kanban) obj;
		if (nombreIdentificador == null) {
			if (other.nombreIdentificador != null)
				return false;
		} else if (!nombreIdentificador.equals(other.nombreIdentificador))
			return false;
		return true;
	}

}
