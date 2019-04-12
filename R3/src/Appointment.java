import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Appointment {
    public String clientName;
    public int time;
    public String date;
    public boolean accepted;


    public Appointment() {
        this.accepted = false;
    }

    public Appointment(String date, int time, String clientName, boolean accepted, Dentist dentist) {
        boolean flag = true;
        this.date = date;
        this.time = time;
        this.clientName = clientName;
        this.accepted = false;
        ArrayList<Appointment> appointments = dentist.appointmentList.get(date);
        if (appointments == null) {
            appointments = new ArrayList<Appointment>();
            appointments.add(this);
        } else {
            for (int i = 0; i < appointments.size(); i++) {
                if (appointments.get(i).time == time) {
                    flag = false;
                    System.out.println("This time is not available for a new appointment, request denied.");
                    break;
                } else if (appointments.get(i).time > time) {
                    Appointment temp = appointments.get(i);
                    appointments.set(i, this);
                    try {
                        if (appointments.get(i + 1) == null) {
                            appointments.add(temp);
                            break;
                        }
                    } catch (Exception e) {
                        appointments.add(temp);
                        break;
                    }

                    for (int j = i + 1; j < appointments.size(); j++) {
                        Appointment temp2 = appointments.get(j);
                        appointments.set(j, temp);
                        temp = temp2;
                    }
                    appointments.add(temp);
                    break;

                }
            }
            if (!appointments.contains(this) && flag) {
                appointments.add(this);
            }
        }
        // appointments.put(this.date, appointments);
        dentist.appointmentList.put(date, appointments);

    }

    /*public void AppointmentDone(Service S){

        Client.servicesProvided.add(s);
    }
    */
}