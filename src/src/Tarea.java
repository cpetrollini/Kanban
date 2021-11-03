package src;

public class Tarea {
	
	private Integer CONTADOR_ID;
	private Integer id;
	private String asunto;
	private Estado estado;
	private Usuario creador;
	private Usuario quienLaRealiza;
	private Kanban kanban;
	


	public Tarea(Usuario creador, String asunto) {
		this.asunto = asunto;
		this.id = CONTADOR_ID++;
		this.creador = creador;
		this.quienLaRealiza = null;
		this.estado = Estado.PENDIENTE;
	}
	
	public Boolean realizarTarea(Usuario quienLaRealiza) {
		Boolean puedeRealizarla = false;
		if (this.estado.equals(Estado.PENDIENTE)) {
			this.quienLaRealiza = quienLaRealiza;
			this.estado = Estado.EN_CURSO;
			puedeRealizarla = true;
		}
	return puedeRealizarla;
	}
	
	public Boolean cambiarEstadoAFinalizada(Usuario queLaFinaliza) {
		Boolean sePudoCambiarEstadoAFinalizada = false;
		if(this.quienLaRealiza.getNombreDeUsuario().equals(queLaFinaliza.getNombreDeUsuario())) {
			this.estado = Estado.FINALIZADA;
			sePudoCambiarEstadoAFinalizada = true;
		}
		return sePudoCambiarEstadoAFinalizada;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

	public Usuario getQuienLaRealiza() {
		return quienLaRealiza;
	}

	public void setQuienLaRealiza(Usuario quienLaRealiza) {
		this.quienLaRealiza = quienLaRealiza;
	}

	
	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public Kanban getKanban() {
		return kanban;
	}

	public void setKanban(Kanban kanban) {
		this.kanban = kanban;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Tarea other = (Tarea) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
