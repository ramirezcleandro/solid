package appointment.entities;

import java.time.LocalDateTime;

public class Appointment {
    private Long appointmentId;
    private Long patientId;
    private String doctorId;
    private LocalDateTime dateTime;
    private String status; // Ej: "pending", "approved", "canceled"
    private String consultationSummary;

    public Appointment(Long patientId, String doctorId, LocalDateTime dateTime, String status, String consultationSummary) {

        this.patientId = patientId;
        this.doctorId = doctorId;
        this.dateTime = dateTime;
        this.status = status;
        this.consultationSummary = consultationSummary;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConsultationSummary() {
        return consultationSummary;
    }

    public void setConsultationSummary(String consultationSummary) {
        this.consultationSummary = consultationSummary;
    }
}
