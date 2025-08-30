package appointment.repositories.impl;

import appointment.entities.Appointment;
import appointment.repositories.AppointmentRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAppointmentRepository {
    // Ejemplo de implementación del repositorio en memoria
    public class InMemoryAppointmentRepository implements AppointmentRepository {
        private List<Appointment> appointments = new ArrayList<>();

        @Override
        public void save(Appointment appointment) {
            appointments.add(appointment);
        }

        @Override
        public void update(Appointment appointment) {
            // Lógica para actualizar en la lista
        }

        @Override
        public void delete(String appointmentId) {
            // Lógica para eliminar de la lista
        }

        @Override
        public Appointment findById(String appointmentId) {
            return appointments.stream().filter(a -> a.getAppointmentId().equals(appointmentId)).findFirst().orElse(null);
        }

        // ... Implementaciones de findByDoctor y findByPatient
    }
}
