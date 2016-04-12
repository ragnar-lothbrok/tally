package p1caccia.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MedicalHospital {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	static List<Patient> patients = new ArrayList<Patient>();

	static DecimalFormat df = new DecimalFormat("#.#");

	public static void main(String[] args) throws IOException, NumberFormatException, ParseException {

		if (args.length != 0) {
			BufferedReader br = new BufferedReader(new FileReader(
					new File(args[0])));
			String line = br.readLine();
			while (line != null) {
				String str[] = line.split("~");
				patients.add(new Patient(str[0], str[1],
						(str[5] != null || str[5].length() != 0 ? sdf.parse(str[5]) : null), str[2],
						Double.parseDouble(str[4]), (str[6] != null || str[6].length() != 0 ? sdf.parse(str[6]) : null),
						(str[7] != null || str[7].length() != 0 ? sdf.parse(str[7]) : null), Integer.parseInt(str[3])));
				line = br.readLine();
			}
		}
		String parentId = null;
		Patient patient = null;
		extracted();
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		while (true) {
			switch (choice) {
			case 1:
				if (patients != null) {
					for (Patient patient2 : patients) {
						System.out.println(patient2.getName() + "," + patient2.getParentId());
					}
				}
				break;
			case 2:
				System.out.println("Please enter parent Id : ");
				parentId = scanner.next();
				patient = new Patient(parentId);
				if (patients.indexOf(patient) != -1) {
					System.out.println("patient Already Present");
				} else {
					System.out.println("Please enter rest of the fields seperated by ~ [A~2323~12~23.55~1991-01-17~2015-03-01~2015-03-04]");
					String line = scanner.next();
					String str[] = line.split("~");
					patients.add(new Patient(str[0], parentId,
							(str[4] != null || str[4].length() != 0 ? sdf.parse(str[4]) : null), str[2],
							Double.parseDouble(str[3]), (str[5] != null || str[5].length() != 0 ? sdf.parse(str[5]) : null),
							(str[6] != null || str[6].length() != 0 ? sdf.parse(str[6]) : null), Integer.parseInt(str[2])));
				}
				break;
			case 3:
				System.out.println("Please enter parent Id : ");
				parentId = scanner.next();
				patient = new Patient(parentId);
				if (patients.indexOf(patient) != -1) {
					System.out.println(patients.get(patients.indexOf(patient)).toString());
				} else {
					System.out.println("Not Present.");
				}
				break;
			case 4:
				System.out.println("Please enter parent Id : ");
				parentId = scanner.next();
				patient = new Patient(parentId);
				if (patients.indexOf(patient) != -1) {
					patients.remove(patient);
					System.out.println("Deleted");
				} else {
					System.out.println("Not Present.");
				}
				break;
			case 5:
				double aveAge = 0.0f;
				if (patients != null) {
					for (Patient patient2 : patients) {
						aveAge += patient2.getAge();
					}
				}
				System.out.println("Average : "+df.format(aveAge / patients.size()));
				break;
			case 6:
				patient = null;
				if (patients != null) {
					for (Patient patient2 : patients) {
						if (patient == null) {
							patient = patient2;
						} else {
							if(patient2.getBirthDate() == null){
								patient = patient2;
							}else if(patient.getBirthDate().compareTo(patient2.getBirthDate()) < 0){
								patient = patient2;
							}
						}
					}
				}
				System.out.println(patient);
				break;
			case 7:
				for (Patient patient2 : patients) {
					if (patient2.getTimeSinceLastVisit() >= 3) {
						System.out.println(patient2);
					}
				}
				break;
			case 8:
				return;
			}
			System.out.println("Please enter choice : ");
			extracted();
			choice = scanner.nextInt();
		}

	}

	private static void extracted() {
		System.out.println(
				"\n1.Display List.\n2.Add New Patient\n3.Show Information Of a Patient.\n4.Delete Patient\n5.Show average Age\n6.Youngest Patient\n7.Show All\n8.Quit");
	}

	static class Patient {
		private String name;
		private String parentId;
		private String address;
		private Integer height;
		private double weight;
		private Date birthDate;
		private Date initialVisit;
		private Date lastVisit;

		public String getName() {
			return name;
		}

		public String getParentId() {
			return parentId;
		}

		public Date getBirthDate() {
			return birthDate;
		}

		public String getAddress() {
			return address;
		}

		public double getWeight() {
			return weight;
		}

		public Date getInitialVisit() {
			return initialVisit;
		}

		public Date getLastVisit() {
			return lastVisit;
		}

		public Integer getHeight() {
			return height;
		}

		public Patient(String name, String parentId, Date birthDate, String address, double weight, Date initialVisit,
				Date lastVisit, Integer height) {
			super();
			this.name = name;
			this.parentId = parentId;
			this.birthDate = birthDate;
			this.address = address;
			this.weight = weight;
			this.initialVisit = initialVisit;
			this.lastVisit = lastVisit;
			this.height = height;
		}

		public Patient(String parentId) {
			super();
			this.parentId = parentId;
		}

		public Integer getAge() {
			if (this.birthDate == null) {
				return 0;
			} else {
				Calendar cal = Calendar.getInstance();
				cal.setTime(this.birthDate);
				LocalDate birthDate = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1,
						cal.get(Calendar.DAY_OF_MONTH));
				LocalDate currentDate = LocalDate.now();
				Integer years = (int) ChronoUnit.YEARS.between(birthDate, currentDate);
				return years;
			}
		}

		public Integer getTimeAsPatient() {
			if (this.initialVisit == null) {
				return 0;
			} else {
				Calendar cal = Calendar.getInstance();
				cal.setTime(this.initialVisit);
				LocalDate initialVisit = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1,
						cal.get(Calendar.DAY_OF_MONTH));
				LocalDate currentDate = LocalDate.now();
				Integer years = (int) ChronoUnit.YEARS.between(initialVisit, currentDate);
				return years;
			}
		}

		public Integer getTimeSinceLastVisit() {
			if (this.lastVisit == null) {
				return 0;
			} else {
				Calendar cal = Calendar.getInstance();
				cal.setTime(this.lastVisit);
				LocalDate lastVisit = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1,
						cal.get(Calendar.DAY_OF_MONTH));
				LocalDate currentDate = LocalDate.now();
				Integer years = (int) ChronoUnit.YEARS.between(lastVisit, currentDate);
				return years;
			}
		}

		@Override
		public String toString() {
			return "Patient [name=" + name + ", parentId=" + parentId + ", address=" + address + ", height=" + (height != null ? (height/12 +" feet "+(height - (12 * (height/12))) +" inch") : 0)
					+ ", weight=" + weight + ", birthDate=" + getAge() + ", initialVisit=" + getTimeAsPatient()
					+ ", lastVisit=" + getTimeSinceLastVisit() + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Patient other = (Patient) obj;
			if (parentId == null) {
				if (other.parentId != null)
					return false;
			} else if (!parentId.equals(other.parentId))
				return false;
			return true;
		}

	}
}
