package appointment.repositories.impl;

import appointment.entities.Patient;
import appointment.repositories.PatientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryPatientRepository implements PatientRepository {
    private List<Patient> patients = new ArrayList<>();

    @Override
    public void save(Patient patient) {
        patients.add(patient);
    }

    @Override
    public void update(Patient patient) {
        Optional<Patient> existingPatient = patients.stream()
                .filter(p -> p.getId().equals(patient.getId()))
                .findFirst();
        existingPatient.ifPresent(p -> {
            int index = patients.indexOf(p);
            patients.set(index, patient);
        });
    }

    @Override
    public void delete(String patientId) {
        patients.removeIf(p -> p.getId().equals(patientId));
    }

    @Override
    public Optional<Patient> findById(String patientId) {
        return patients.stream()
                .filter(p -> p.getId().equals(patientId))
                .findFirst();
    }

    @Override
    public List<Patient> findAll() {
        return new ArrayList<>(patients);
    }
}
