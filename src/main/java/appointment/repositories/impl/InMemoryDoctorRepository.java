package appointment.repositories.impl;

import appointment.entities.Doctor;
import appointment.repositories.DoctorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryDoctorRepository implements DoctorRepository {
    private List<Doctor> doctors = new ArrayList<>();

    @Override
    public void save(Doctor doctor) {
        doctors.add(doctor);
    }

    @Override
    public void update(Doctor doctor) {
        // En un sistema real, buscarías y actualizarías el objeto.
        // Aquí, por simplicidad, lo reemplazaremos.
        Optional<Doctor> existingDoctor = doctors.stream()
                .filter(d -> d.getDoctorId().equals(doctor.getDoctorId()))
                .findFirst();
        existingDoctor.ifPresent(d -> {
            int index = doctors.indexOf(d);
            doctors.set(index, doctor);
        });
    }

    @Override
    public void delete(String doctorId) {
        doctors.removeIf(d -> d.getDoctorId().equals(doctorId));
    }

    @Override
    public Doctor findById(String doctorId) {
        return doctors.stream()
                .filter(d -> d.getDoctorId().equals(doctorId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Doctor> findAll() {
        return new ArrayList<>(doctors);
    }
}
