package appointment.repositories;

import appointment.entities.Appointment;

import java.util.List;

public interface AppointmentRepository {
    void save(Appointment appointment);
    void update(Appointment appointment);
    void delete(String appointmentId);
    Appointment findById(String appointmentId);
    List<Appointment> findByDoctor(String doctorId);
    List<Appointment> findByPatient(String patientId);
}
