package com.all.core.java.email.smtp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.TreeSet;
import java.util.logging.Logger;

import org.xbill.DNS.Lookup;
import org.xbill.DNS.MXRecord;
import org.xbill.DNS.Record;
import org.xbill.DNS.Type;

import com.all.core.java.email.validator.EmailValidator2;
import com.all.core.java.misc.MXRecordLookupFour;
import com.google.common.collect.SortedSetMultimap;
import com.google.common.collect.TreeMultimap;

public class MXLookupExample {

	private static final Logger logger = Logger.getLogger(MXLookupExample.class.getName());

	static int readCountFail = 0;
	static int readCountWorking = 0;
	static int writeCountFail = 0;
	static int writeCountWorking = 0;

	public static void main(String[] args) {

		EmailValidator2 emailValidator2 = new EmailValidator2();
		SMTPDialogTwo smtpDialogTwo = new SMTPDialogTwo();

		// https://support.wix.com/en/article/changing-the-priority-of-your-mx-records
		TreeSet<String> Priority0 = new TreeSet<>();
		TreeSet<String> Priority1 = new TreeSet<>();
		TreeSet<String> Priority5 = new TreeSet<>();
		TreeSet<String> Priority10 = new TreeSet<>();

		TreeSet<String> valid = new TreeSet<>();
		TreeSet<String> inValid = new TreeSet<>();

		SortedSetMultimap<String, String> failEmailID = TreeMultimap.create();
		SortedSetMultimap<String, String> workingEmailID = TreeMultimap.create();

		try {

			String fileName = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\01-All-Company-ID.txt";

			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String stringLine = null;
			while ((stringLine = bufferedReader.readLine()) != null) {

				stringLine = stringLine.replace(",", "");
				if (stringLine.contains("@")) {
					String[] splitDomain = stringLine.split("@");
					if (splitDomain.length < 2)
						continue;
					String domain = splitDomain[1];

					boolean mxValid = MXRecordLookupFour.mxRecordLookup(stringLine);
					System.out.println(mxValid + "  - " + stringLine);

					if (EmailValidator2.isValidSMTP(stringLine)) {
						valid.add(stringLine);
					} else {
						inValid.add(stringLine);
					}

					Record[] records = new Lookup(domain, Type.MX).run();
					if (records == null) {
						// System.out.println("No MX records found for domain: " + stringLine);
						// return;

						failEmailID.put(splitDomain[1], stringLine);
						readCountFail++;
					}

					if (records != null) {
						for (Record record : records) {
							MXRecord mx = (MXRecord) record;
							// mx.getTarget();
							// mx.getPriority();

							StringBuffer stringBuffer = new StringBuffer(mx.getTarget().toString());
							stringBuffer.deleteCharAt(stringBuffer.length() - 1);

							if (mx.getPriority() <= 10) {
								// System.out.println(stringLine + " " + mx.getPriority());
								Priority0.add(stringLine);
							} else if (mx.getPriority() > 10 && mx.getPriority() <= 20) {
								// System.out.println(stringLine + " " + mx.getPriority());
								Priority1.add(stringLine);
							} else if (mx.getPriority() > 20 && mx.getPriority() <= 40) {
								// System.out.println(stringLine + " " + mx.getPriority());
								Priority5.add(stringLine);
							} else if (mx.getPriority() > 40 && mx.getPriority() <= 60) {
								// System.out.println(stringLine + " " + mx.getPriority());
								Priority10.add(stringLine);
							}

							// System.out.println("Host: " + mx.getTarget() + ", Priority: " +
							// mx.getPriority());
							// workingEmailID.put(splitDomain[1], stringLine);
							// System.out.println(stringLine);
						}
						// System.out.println();
						// System.out.println(stringLine);
						readCountWorking++;
					}
				}
			}

			bufferedReader.close();

			String failEmailIDFile = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\OutputFile1.txt";

			// Assume default encoding.
			FileWriter fileWriterFail = new FileWriter(failEmailIDFile);

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriterFail = new BufferedWriter(fileWriterFail);

			for (String strFail : failEmailID.values()) {
				bufferedWriterFail.write(strFail);
				// bufferedWriter.write(strOut + ",");
				bufferedWriterFail.newLine();
				writeCountFail++;
			}

			String workingEmailIDFile = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\OutputFile2.txt";

			// Assume default encoding.
			FileWriter fileWriterWorking = new FileWriter(workingEmailIDFile);

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriterWorking = new BufferedWriter(fileWriterWorking);

			for (String strWorking : workingEmailID.values()) {
				bufferedWriterWorking.write(strWorking);
				// bufferedWriterOth.write(strOut + ",");
				bufferedWriterWorking.newLine();
				writeCountWorking++;
			}

			bufferedWriterWorking.close();
			bufferedWriterFail.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("readCountFail- " + readCountFail);
		System.out.println();
		System.out.println("readCountWorking- " + readCountWorking);
		System.out.println();
		System.out.println("writeCountFail- " + writeCountFail);
		System.out.println();
		System.out.println("writeCountWorking- " + writeCountWorking);
		System.out.println();
		System.out.println("failEmailID- " + failEmailID);
		System.out.println();
		System.out.println("failEmailID size- " + failEmailID.size());
		System.out.println();
		System.out.println("workingEmailID- " + workingEmailID);
		System.out.println();
		System.out.println("workingEmailID size- " + workingEmailID.size());
		System.out.println();
		// System.out.println("Priority0 " + Priority0);
		System.out.println();
		// System.out.println("Priority1 " + Priority1);
		System.out.println();
		// System.out.println("Priority5 " + Priority5);
		System.out.println();
		// System.out.println("Priority10 " + Priority10);
		System.out.println();
		System.out.println("valid " + valid);
		System.out.println();
		System.out.println("inValid " + inValid);
	}
}
