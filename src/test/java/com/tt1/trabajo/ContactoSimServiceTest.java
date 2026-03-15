package com.tt1.trabajo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.DatosSimulation;
import modelo.DatosSolicitud;
import modelo.Entidad;
import servicios.ContactoSimService;

class ContactoSimServiceTest {

	private ContactoSimService service;

	@BeforeEach
	void setUp() {service = new ContactoSimService();}
	@Test
	void testSolicitarSimulation() {
		Map<Integer, Integer> nums = new HashMap<>();
		nums.put(1, 10);
		nums.put(2, 20);
		assertTrue(service.solicitarSimulation(new DatosSolicitud(nums)) > 0);
	}
	@Test
	void testSolicitarSimulationReturnsDifferentTokens() {
		Map<Integer, Integer> nums = new HashMap<>();
		nums.put(1, 10);
		int token1 = service.solicitarSimulation(new DatosSolicitud(nums));
		int token2 = service.solicitarSimulation(new DatosSolicitud(nums));
		assertNotEquals(token1, token2);
	}
	@Test
	void testDescargarDatos() {
		Map<Integer, Integer> nums = new HashMap<>();
		nums.put(1, 10);
		int ticket = service.solicitarSimulation(new DatosSolicitud(nums));
		assertNotNull(service.descargarDatos(ticket));
	}
	@Test
	void testDescargarDatosWithInvalidTicket() {assertNull(service.descargarDatos(99999));}
	@Test
	void testGetEntities() {
		List<Entidad> entidades = service.getEntities();
		assertNotNull(entidades);
		assertFalse(entidades.isEmpty());
		assertEquals(3, entidades.size());
	}
	@Test
	void testGetEntitiesHaveValidData() {
		List<Entidad> entidades = service.getEntities();
		for (Entidad e : entidades) {
			assertTrue(e.getId() > 0);
			assertNotNull(e.getName());
			assertNotNull(e.getDescripcion());
		}
	}
	@Test
	void testIsValidEntityIdReturnsTrueForValidIds() {
		assertTrue(service.isValidEntityId(1));
		assertTrue(service.isValidEntityId(2));
		assertTrue(service.isValidEntityId(3));
	}
	@Test
	void testIsValidEntityIdReturnsFalseForInvalidIds() {
		assertFalse(service.isValidEntityId(99));
		assertFalse(service.isValidEntityId(-1));
		assertFalse(service.isValidEntityId(0));
	}
}
