package appointment.repositories;

import appointment.entities.Doctor;

import java.util.List;

public interface DoctorRepository {
    void save(Doctor doctor);
    void update(Doctor doctor);
    void delete(String doctorId);
    Doctor findById(String doctorId);
    List<Doctor> findAll();
}