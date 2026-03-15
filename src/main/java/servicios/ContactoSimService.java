package servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import interfaces.InterfazContactoSim;
import modelo.DatosSimulation;
import modelo.DatosSolicitud;
import modelo.Entidad;

@Service
public class ContactoSimService implements InterfazContactoSim {

	private final Map<Integer, DatosSolicitud> simulaciones;
	private final Random random;
	private final List<Entidad> entidades;

	public ContactoSimService() {
		this.simulaciones = new HashMap<>();
		this.random = new Random();
		this.entidades = createEntities();
	}

	private List<Entidad> createEntities() {
		List<Entidad> list = new ArrayList<>();

		Entidad e1 = new Entidad();
		e1.setId(1);
		e1.setName("Servidores");
		e1.setDescripcion("Servidores concurrentes y eficientes");
		list.add(e1);

		Entidad e2 = new Entidad();
		e2.setId(2);
		e2.setName("Clientes");
		e2.setDescripcion("Personas que utilizan los servicios");
		list.add(e2);

		Entidad e3 = new Entidad();
		e3.setId(3);
		e3.setName("Bases de datos");
		e3.setDescripcion("Bases de datos relacionales y no relacionales");
		list.add(e3);
		return list;
	}
	@Override
	public int solicitarSimulation(DatosSolicitud sol) {
		int token;
		do {
			token = random.nextInt(100000) + 1;
		} while (simulaciones.containsKey(token));

		simulaciones.put(token, sol);
		return token;
	}
	@Override
	public DatosSimulation descargarDatos(int ticket) {
		DatosSolicitud solicitud = simulaciones.get(ticket);
		if (solicitud == null) {
			return null;
		}
		return new DatosSimulation();
	}
	@Override
	public List<Entidad> getEntities() {
		return new ArrayList<>(entidades);
	}
	@Override
	public boolean isValidEntityId(int id) {
		return entidades.stream().anyMatch(e -> e.getId() == id);
	}
}
