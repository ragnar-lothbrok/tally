import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.csvreader.CsvReader;

/**
 * 
 * [﻿"customer_id", "email", "country", "is_active", "created_at", "firstname",
 * "lastname", "contact", "password_hash", "dob", "gender", "source"]
 * 
 */
public class ReadCSV {
	public static final String SEPERATOR = ",";
	public static final String STRING_IDENTIFIER = "'";

	public static void main(String[] args) throws NumberFormatException, SQLException {

		String csvFile = "/home/raghunandangupta/Downloads/customerData (copy).csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		// 255792
		try {
			int count = 0;
			CsvReader products = new CsvReader(csvFile);
			products.readHeaders();
			String[] country = new String[12];
			StringBuffer sb = new StringBuffer();
			int skipCount = 0;
			boolean skipped = false;
			PreparedStatement pp = updateToDatabase();
			while (products.readRecord()) {
//				pp.setInt(1, Integer.parseInt(products.get(0)));
//				pp.setString(2, products.get("email"));
//				pp.setString(3, products.get("country"));
//				pp.setString(4, products.get("is_active"));
//				pp.setString(5, products.get("created_at"));
//				pp.setString(6, products.get("firstname"));
//				pp.setString(7, products.get("lastname"));
//				pp.setString(8, products.get("contact"));
//				pp.setString(9, products.get("password_hash"));
//				pp.setString(10, products.get("dob"));
//				pp.setString(11, products.get("gender"));
//				pp.setString(12, products.get("source"));
				pp.setString(1, products.get("firstname"));
				pp.setString(2, products.get("lastname"));
				pp.setInt(3, Integer.parseInt(products.get(0)));
				try{
					if(products.get("firstname").indexOf("'") == -1 && products.get("lastname").indexOf("'") == -1){
						continue;
					}
					pp.executeUpdate();
				}catch(Exception exception){
					System.out.println(exception.getMessage());
				}
				
//				country[0] = products.get(0);
//				country[1] = products.get("email");
//				country[2] = products.get("country");
//				country[3] = products.get("is_active");
//				country[4] = products.get("created_at");
//				country[5] = products.get("firstname");
//				
//				country[6] = products.get("lastname");
//				
//				country[7] = products.get("contact");
//				country[8] = products.get("password_hash");
//				country[9] = products.get("dob");
//				country[10] = products.get("gender");
//				country[11] = products.get("source");
//				count++;
//				if (skipped)
//					sb.append(
//							"insert into account(id,email_id,country,is_active,create_date,first_name,last_name,phone_number,password_hash,dob,gender,sso_provider) values("
//									+ generateValues(country) + ");")
//							.append("\n");
			}
//			System.out.println("skip count : " + skipCount);
//			File file = new File("account_skipper.sql");
//			file.createNewFile();
//			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//			bw.write(sb.toString());
			// System.out.println(sb.toString()+" "+count);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch(Exception exception){
			System.out.println(exception.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
	}
	
	public static PreparedStatement updateToDatabase() {
		// JDBC driver name and database URL
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost/backup_ABC";

		// Database credentials
		final String USER = "root";
		final String PASS = "root";

		Connection conn = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");

			PreparedStatement updateemp = conn.prepareStatement(
					"update account set first_name=?,last_name=? where id=?");

			return updateemp;
		} catch (Exception exception) {
			System.out.println("Exception occured : "+exception.getMessage());
		}
		return null;

	}


	public static PreparedStatement insertIntoDatabase() {
		// JDBC driver name and database URL
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost/backup_ABC";

		// Database credentials
		final String USER = "root";
		final String PASS = "root";

		Connection conn = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");

			PreparedStatement updateemp = conn.prepareStatement(
					"insert into account(id,email_id,country,is_active,create_date,first_name,last_name,phone_number,password_hash,dob,gender,sso_provider) values(?,?,?,?,?,?,?,?,?,?,?,?)");

			return updateemp;
		} catch (Exception exception) {
			System.out.println("Exception occured : "+exception.getMessage());
		}
		return null;

	}

	public static String generateValues(String[] country) {
		StringBuilder sb = new StringBuilder();
		sb.append(country[0] + ",'" + country[1] + "','" + country[2] + "'," + country[3] + ",'" + country[4] + "','"
				+ country[5] + "','" + country[6] + "','" + country[7] + "','" + country[8] + "','" + country[9] + "','"
				+ country[10] + "','" + country[11] + "'");

		return sb.toString().replaceAll("\"", "");
	}

}
