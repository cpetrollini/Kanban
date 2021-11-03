package src;

import java.util.ArrayList;

public class Usuario {
	
	private String nombreDeUsuario;
	private ArrayList<Tarea> tareas;
	private ArrayList<Kanban> tableros;
	private Kanban kanbanActual;
	
	public Usuario(String nombreDeUsuario) {
		super();
		this.nombreDeUsuario = nombreDeUsuario;
	}

	public void seleccionarUnKanbanParaTrabajar(String nombreDelKanban) {
		for (Kanban kanban : tableros) {
			if (kanban.getNombreIdentificador().equals(nombreDelKanban)) {
				this.kanbanActual = kanban;
				break;
			}
		}
	}
	
	public void unirAUnKanban(Kanban kanbanNuevo) {
		tableros.add(kanbanNuevo);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreDeUsuario == null) ? 0 : nombreDeUsuario.hashCode());
		return result;
	}

	public void crearTarea(String asunto) {
		Tarea nueva = new Tarea(this, asunto);
		nueva.setKanban(this.kanbanActual);
		this.kanbanActual.agregarUnaTarea(nueva);
	}
	
	public Boolean finalizarTarea(Integer id){
		boolean finalizada = false;
		for (Tarea tarea : tareas) {
			if (tarea.getId().equals(id)) {
				tarea.cambiarEstadoAFinalizada(this);
				finalizada = true;
			}
		}
		return finalizada;
	}
	
	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}

	public ArrayList<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(ArrayList<Tarea> tareas) {
		this.tareas = tareas;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nombreDeUsuario == null) {
			if (other.nombreDeUsuario != null)
				return false;
		} else if (!nombreDeUsuario.equals(other.nombreDeUsuario))
			return false;
		return true;
	}
	
}
