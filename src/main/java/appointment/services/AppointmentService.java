package appointment.services;

import appointment.entities.Appointment;
import appointment.entities.Patient;
import appointment.repositories.AppointmentRepository;
import appointment.repositories.DoctorRepository;
import appointment.repositories.PatientRepository;
import notification.interfaces.Notification;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class AppointmentService {
    private AppointmentRepository appointmentRepository;
    private Notification notificationMethod;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;
    private static final Logger LOGGER = Logger.getLogger(AppointmentService.class.getName());

    public AppointmentService(AppointmentRepository appointmentRepository, Notification notificationMethod, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.notificationMethod = notificationMethod;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public void scheduleAppointment(Long patientId, String doctorId, LocalDateTime dateTime) {

        LOGGER.info("Enter scheduleAppointment");
        Appointment newAppointment = new Appointment( patientId, doctorId, dateTime, "pending", null);
        LOGGER.info("Saving appointment to DB");
        appointmentRepository.save(newAppointment);
        Optional<Patient> patient = patientRepository.findById(patientId);
        String message = String.format("Tu cita con el Dr. %s ha sido agendada para el %s.", doctorRepository.findById(doctorId).getLastName(), dateTime);
        LOGGER.info("Sending Notification");
        notificationMethod.sendNotification(message);
    }

    public void cancelAppointment(String appointmentId) {
        LOGGER.info("Enter cancelAppointment");
        Appointment appointment = appointmentRepository.findById(appointmentId);
        appointment.setStatus("canceled");
        LOGGER.info("Cancelling appointment");
        appointmentRepository.update(appointment);
        LOGGER.info("Sending Notification");
        notificationMethod.sendNotification("Tu cita ha sido cancelada.");
    }

    public void approveAppointment(String appointmentId, String doctorId) {
        LOGGER.info("Enter cancelAppointment");
        Appointment appointment = appointmentRepository.findById(appointmentId);
        if (appointment != null && appointment.getDoctorId().equals(doctorId)) {
            appointment.setStatus("approved");
            LOGGER.info("Approving appointment");
            appointmentRepository.update(appointment);
            LOGGER.info("Sending Notification");
            notificationMethod.sendNotification("Tu cita ha sido aprobado.");
        } else {
            throw new IllegalArgumentException("Cita no válida o no pertenece al doctor.");
        }
    }

    public void recordConsultationSummary(String appointmentId, String summary) {
        LOGGER.info("Enter recordConsultationSummary");
        Appointment appointment = appointmentRepository.findById(appointmentId);
        if (appointment != null) {

            appointment.setConsultationSummary(summary);
            LOGGER.info("Updating Consultation Summary");
            appointmentRepository.update(appointment);
        }
    }

    public List<Appointment> getDailyAgenda(String doctorId, LocalDate date) {
        return appointmentRepository.findByDoctor(doctorId)
                .stream()
                .filter(a -> a.getDateTime().toLocalDate().isEqual(date))
                .collect(Collectors.toList());
    }
}
