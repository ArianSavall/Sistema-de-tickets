package test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import dao.HibernateUtil;
import datos.*;

import java.time.LocalDateTime;
import java.util.*;

public class TestTraerObjetos {

	public static void main(String[] args) throws Exception {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		// TAREAS
        List<Tarea> tareas = session.createQuery("FROM Tarea", Tarea.class).list();
        System.out.println("==== TAREAS ====");
        tareas.forEach(System.out::println);


        // CLIENTES
        List<Cliente> clientes = session.createQuery("FROM Cliente", Cliente.class).list();
        System.out.println("==== CLIENTES ====");
        clientes.forEach(System.out::println);

        // SOPORTES
        List<Soporte> soportes = session.createQuery("FROM Soporte", Soporte.class).list();
        System.out.println("==== SOPORTES ====");
        soportes.forEach(System.out::println);

        // ADMINISTRADORES
        List<Admin> admins = session.createQuery("FROM Admin", Admin.class).list();
        System.out.println("==== ADMINISTRADORES ====");
        admins.forEach(System.out::println);

        // ESPECIALIDADES
        List<Especialidad> especialidades = session.createQuery("FROM Especialidad", Especialidad.class).list();
        System.out.println("==== ESPECIALIDADES ====");
        especialidades.forEach(System.out::println);
		
		 
		// TICKETS
        List<Ticket> tickets = session.createQuery("FROM Ticket", Ticket.class).list();
        System.out.println("==== TICKETS ====");
        tickets.forEach(System.out::println);

        // COMENTARIOS
        List<Comentario> comentarios = session.createQuery("FROM Comentario", Comentario.class).list();
        System.out.println("==== COMENTARIOS ====");
        comentarios.forEach(System.out::println);

        // VALORACIONES
        List<Valoracion> valoraciones = session.createQuery("FROM Valoracion", Valoracion.class).list();
        System.out.println("==== VALORACIONES ====");
        valoraciones.forEach(System.out::println);
		

		// --- Finalizar ---
		tx.commit();
		session.close();
		factory.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/**
		
		// --- Crear ESPECIALIDADES ---
		Especialidad esp1 = new Especialidad("Redes", "Problemas de conexión");
		Especialidad esp2 = new Especialidad("Impresoras", "Problemas de impresión");

		session.persist(esp1);
		session.persist(esp2);

		// --- Crear CLIENTES ---
		Cliente c1 = new Cliente("Luciano", "Rodriguez", "luciano@gmail.com", "1234", "20301234567", "foto1.jpg",
				"RRHH");
		Cliente c2 = new Cliente("Valeria", "Martinez", "vale@gmail.com", "abcd", "20303334444", "foto2.jpg", "IT");

		session.persist(c1);
		session.persist(c2);

		// --- Crear SOPORTES con especialidades ---
		Set<Especialidad> setEspS1 = new HashSet<>();
		setEspS1.add(esp1);

		Set<Especialidad> setEspS2 = new HashSet<>();
		setEspS2.add(esp2);

		Soporte s1 = new Soporte("Jorge", "Pérez", "jorge@soporte.com", "qwerty", "20305556666", "foto3.jpg", setEspS1);
		Soporte s2 = new Soporte("Laura", "Gómez", "laura@soporte.com", "asdf", "20306667777", "foto4.jpg", setEspS2);

		session.persist(s1);
		session.persist(s2);

		// --- Crear ADMIN ---
		Admin a1 = new Admin("Ana", "Admin", "ana@admin.com", "admin", "20309998888", "foto5.jpg");
		session.persist(a1);

		// --- Crear fechas de prueba ---
		LocalDateTime fecha1 = LocalDateTime.of(2024, 5, 1, 10, 30);
		LocalDateTime fecha2 = LocalDateTime.of(2024, 5, 5, 14, 0);
		LocalDateTime fecha3 = LocalDateTime.of(2024, 5, 8, 12, 15);

		// Ticket sin valoración (todavía)
		Ticket t1 = new Ticket("No anda el wifi", "Sin conexión en oficina", fecha1, null, Prioridad.ALTA, Estado.NUEVO,
				s1, c1, new HashSet<>(), // tareas vacías
				new HashSet<>(), // comentarios vacíos
				null // sin valoración aún
		);

		// Ticket cerrado con valoración
		Ticket t2 = new Ticket("No imprime", "No responde impresora HP", fecha2, fecha3, Prioridad.MEDIA,
				Estado.COMPLETADO, s1, c2, new HashSet<>(), // tareas vacías
				new HashSet<>(), 
				null 
		);

		// Persistir tickets primero
		session.persist(t1);
		session.persist(t2);

		// Crear valoración asociada a t2
		Valoracion val1 = new Valoracion(5, fecha3, "Muy buena atención", t2);

		// Asignar valoración al ticket (por si es bidireccional)
		t2.setValoracion(val1);

		// Persistir valoración
		session.persist(val1);

		// Actualizar ticket con valoración (opcional si usás cascada)
		session.persist(t2);

		// --- Crear COMENTARIOS ---
		Comentario com1 = new Comentario(LocalDateTime.of(2024, 5, 1, 16, 0), "¿Probaste reiniciar?", s1, t1);
		Comentario com2 = new Comentario(LocalDateTime.of(2024, 5, 2, 10, 0), "Sí, sigue sin andar", (Usuario) c1, t1);

		session.persist(com1);
		session.persist(com2);

		// --- Crear TAREAS ---
		Tarea tarea1 = new Tarea("Verificar router", false, "Revisión", t1);
		Tarea tarea2 = new Tarea("Reinstalar drivers", true, "Drivers", t2);

		session.persist(tarea1);
		session.persist(tarea2);

		// --- Finalizar ---
		tx.commit();
		session.close();
		factory.close();

		System.out.println("✅ Datos insertados correctamente con Hibernate.");
		
		
		
		// --- Crear ESPECIALIDADES ---
		Especialidad esp1 = new Especialidad("Redes", "Problemas de conexión");
		Especialidad esp2 = new Especialidad("Impresoras", "Problemas de impresión");

		session.persist(esp1);
		session.persist(esp2);

		// --- Crear CLIENTES ---
		Cliente c1 = new Cliente("Luciano", "Rodriguez", "luciano@gmail.com", "1234", "20301234567", "foto1.jpg",
				"RRHH");
		Cliente c2 = new Cliente("Valeria", "Martinez", "vale@gmail.com", "abcd", "20303334444", "foto2.jpg", "IT");

		session.persist(c1);
		session.persist(c2);

		// --- Crear SOPORTES con especialidades ---
		Set<Especialidad> setEspS1 = new HashSet<>();
		setEspS1.add(esp1);

		Set<Especialidad> setEspS2 = new HashSet<>();
		setEspS2.add(esp2);

		Soporte s1 = new Soporte("Jorge", "Pérez", "jorge@soporte.com", "qwerty", "20305556666", "foto3.jpg", setEspS1);
		Soporte s2 = new Soporte("Laura", "Gómez", "laura@soporte.com", "asdf", "20306667777", "foto4.jpg", setEspS2);

		session.persist(s1);
		session.persist(s2);

		// --- Crear ADMIN ---
		Admin a1 = new Admin("Ana", "Admin", "ana@admin.com", "admin", "20309998888", "foto5.jpg");
		session.persist(a1);

		// --- Crear fechas de prueba ---
		LocalDateTime fecha1 = LocalDateTime.of(2024, 5, 1, 10, 30);
		LocalDateTime fecha2 = LocalDateTime.of(2024, 5, 5, 14, 0);
		LocalDateTime fecha3 = LocalDateTime.of(2024, 5, 8, 12, 15);

		// Ticket sin valoración (todavía)
		Ticket t1 = new Ticket("No anda el wifi", "Sin conexión en oficina", fecha1, null, Prioridad.ALTA, Estado.NUEVO,
				s1, c1, new HashSet<>(), // tareas vacías
				new HashSet<>(), // comentarios vacíos
				null // sin valoración aún
		);

		// Ticket cerrado con valoración
		Ticket t2 = new Ticket("No imprime", "No responde impresora HP", fecha2, fecha3, Prioridad.MEDIA,
				Estado.COMPLETADO, s1, c2, new HashSet<>(), // tareas vacías
				new HashSet<>(), 
				null 
		);

		// Persistir tickets primero
		session.persist(t1);
		session.persist(t2);

		// Crear valoración asociada a t2
		Valoracion val1 = new Valoracion(5, fecha3, "Muy buena atención", t2);

		// Asignar valoración al ticket (por si es bidireccional)
		t2.setValoracion(val1);

		// Persistir valoración
		session.persist(val1);

		// Actualizar ticket con valoración (opcional si usás cascada)
		session.persist(t2);

		// --- Crear COMENTARIOS ---
		Comentario com1 = new Comentario(LocalDateTime.of(2024, 5, 1, 16, 0), "¿Probaste reiniciar?", s1, t1);
		Comentario com2 = new Comentario(LocalDateTime.of(2024, 5, 2, 10, 0), "Sí, sigue sin andar", (Usuario) c1, t1);

		session.persist(com1);
		session.persist(com2);

		// --- Crear TAREAS ---
		Tarea tarea1 = new Tarea("Verificar router", false, "Revisión", t1);
		Tarea tarea2 = new Tarea("Reinstalar drivers", true, "Drivers", t2);

		session.persist(tarea1);
		session.persist(tarea2);

		// --- Finalizar ---
		tx.commit();
		session.close();
		factory.close();

		System.out.println("✅ Datos insertados correctamente con Hibernate.");
		 */
	}
}
