package appointment.repositories;

import appointment.entities.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientRepository {
    void save(Patient patient);
    void update(Patient patient);
    void delete(String patientId);
    Optional<Patient> findById(Long patientId);
    List<Patient> findAll();
}
