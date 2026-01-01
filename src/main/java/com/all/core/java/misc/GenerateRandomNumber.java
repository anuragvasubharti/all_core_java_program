package com.all.core.java.misc;

//https://www.geeksforgeeks.org/java-program-check-valid-mobile-number/
//https://www.smsgatewaycenter.com/tracker-mobile/operator/AT?circle=AP
//https://www.smsgatewaycenter.com/tracker-mobile/operator/ID?circle=AP
/*List Of Mobile Codes Andhra Pradesh
90 Series
Code Operator Circle
9000 Airtel Andhra Pradesh
9001 Airtel Rajasthan
9002 Airtel West Bengal
9003 Airtel Tamil Nadu
9004 Airtel Mumbai
9005 Airtel UP(east)
9006 Airtel Bihar Jharkhand
9007 Airtel Kolkata
9008 Airtel Karnataka
9009 Idea Madhya Pradesh
9010 Idea Andhra Pradesh
9011 Idea Maharashtra
9012 Idea UP(west)
9013 Mtnl Dolphin Delhi
9014 Reliance Gsm Andhra Pradesh
9015 Reliance Gsm Delhi
9016 Reliance Gsm Gujrat
9017 Reliance Gsm Haryana
9018 Reliance Gsm Jammu Kashmir
9019 Reliance Gsm Karnataka
9020 Reliance Gsm Kerala
9021 Reliance Gsm Maharashtra
9022 Reliance Gsm Mumbai
9023 Reliance Gsm Punjab
9024 Reliance Gsm Rajasthan
9025 Reliance Gsm Tamil Nadu
9026 Reliance Gsm UP(east)
9027 Reliance Gsm UP(west)
9028 Tata Gsm Maharashtra
9029 Tata Gsm Mumbai
9030 Tata Gsm AndHaryanaa Pradesh
9031 Tata Gsm Bihar Jharkhand
9032 Tata Gsm Delhi
9033 Tata Gsm Gujrat
9034 Tata Gsm Haryana
9035 Tata Gsm Himachal Pradesh
9036 Tata Gsm Karnataka
9037 Tata Gsm Kerala
9038 Tata Gsm Kolkata
9039 Tata Gsm Madhya Pradesh
9040 Tata Gsm Orrisa
9041 Tata Gsm Punjab
9042 Tata Gsm Rajasthan
9043 Tata Gsm Tamil Nadu
9044 Tata Gsm UP(east)
9045 Tata Gsm UP(west)
9046 Tata Gsm West Bengal
9047 Vodafone(Hutch) Tamil Nadu
9048 Vodafone(Hutch) Kerala
9049 Vodafone(Hutch) Maharashtra
9050 Vodafone(Hutch) Haryana
9051 Vodafone(Hutch) Kolkata
9052 Vodafone(Hutch) Andhra Pradesh
9053 Unitech Haryana
9054 Unitech Himachal Pradesh
9055 Unitech Jammu Kashmir
9056 Unitech Punjab
9057 Unitech Rajasthan
9058 Unitech UP(west)
9059 Unitech Andhra Pradesh
9060 Unitech Karnataka
9061 Unitech Kerala
9062 Unitech Kolkata
9063 Datacom Andhra Pradesh
9064 Datacom Assam
9065 Datacom Bihar Jharkhand
9066 Datacom Delhi
9067 Datacom Gujrat
9068 Datacom Haryana
9069 Datacom Himachal Pradesh
9070 Datacom Jammu Kashmir
9071 Datacom Karnataka
9072 Datacom Kerala
9073 Datacom Kolkata
9074 Datacom Madhya Pradesh
9075 Datacom Maharashtra
9076 Datacom Mumbai
9077 Datacom North East
9078 Datacom Orrisa
9079 Datacom Rajasthan
9080 Datacom Tamil Nadu
9081 Datacom UP(east)
9082 Datacom UP(west)
9083 Datacom West Bengal
9084 Unitech Delhi
9085 Idea Assam
9086 Idea Jammu Kashmir
9087 Idea Karnataka
9088 Idea Kolkata
9089 Idea North East
9090 Idea Orrisa
9091 Idea Punjab
9092 Idea Tamil Nadu
9093 Idea West Bengal
9094 Aircel Chennai
9095 Aircel Tamil Nadu
9096 Airtel Maharashtra
9097 Aircel Bihar Jharkhand
9098 Reliance Gsm Madhya Pradesh
9099 Vodafone(Hutch) Gujrat


91 Series
Code Operator Circle
9100 Loop (BPL) Andhra Pradesh
9101 Loop (BPL) Assam
9102 Loop (BPL) Bihar Jharkhand
9103 Loop (BPL) Delhi
9104 Loop (BPL) Gujrat
9105 Loop (BPL) Haryana
9106 Loop (BPL) Himachal Pradesh
9107 Loop (BPL) Jammu Kashmir
9108 Loop (BPL) Karnataka
9109 Loop (BPL) Kerala
9110 Loop (BPL) Kolkata
9111 Loop (BPL) Madhya Pradesh
9112 Loop (BPL) Maharashtra
9113 Loop (BPL) North East
9114 Loop (BPL) Orrisa
9115 Loop (BPL) Punjab
9116 Loop (BPL) Rajasthan
9117 Loop (BPL) Tamil Nadu
9118 Loop (BPL) UP(east)
9119 Loop (BPL) UP(west)
9120 Loop (BPL) West Bengal
9121 Unitech Assam
9122 Unitech Bihar Jharkhand
9123 Unitech North East
9124 Unitech Orrisa
9125 Unitech UP(east)
9126 Unitech West Bengal
9127 Spice Mobile. Tel Assam
9128 Spice Mobile. Tel Bihar Jharkhand
9129 Spice Mobile. Tel Himachal Pradesh
9130 Spice Mobile. Tel Jammu Kashmir
9131 Spice Mobile. Tel North East
9132 Spice Mobile. Tel Orrisa
9133 Shyam (Rainbow) Andhra Pradesh
9134 Shyam (Rainbow) Assam
9135 Shyam (Rainbow) Bihar Jharkhand
9136 Shyam (Rainbow) Delhi
9137 Shyam (Rainbow) Gujrat
9138 Shyam (Rainbow) Haryana
9139 Shyam (Rainbow) Himachal Pradesh
9140 Shyam (Rainbow) Jammu Kashmir
9141 Shyam (Rainbow) Karnataka
9142 Shyam (Rainbow) Kerala
9143 Shyam (Rainbow) Kolkata
9144 Shyam (Rainbow) Madhya Pradesh
9145 Shyam (Rainbow) Maharashtra
9146 Shyam (Rainbow) Mumbai
9147 Shyam (Rainbow) North East
9148 Shyam (Rainbow) Orrisa
9149 Shyam (Rainbow) Punjab
9150 Shyam (Rainbow) Tamil Nadu
9151 Shyam (Rainbow) UP(east)
9152 Shyam (Rainbow) UP(west)
9153 Shyam (Rainbow) West Bengal
9154 Spice Mobile Andhra Pradesh
9155 Spice Mobile Delhi
9156 Spice Mobile Haryana
9157 Spice Mobile Maharashtra
9158 Swan Telecom Andhra Pradesh
9159 Swan Telecom Delhi

9160 Swan Telecom Gujrat

9161 Swan Telecom Haryana
9162 Swan Telecom Karnataka
9163 Swan Telecom Kerala
9164 Swan Telecom Maharashtra
9165 Swan Telecom Mumbai
9166 Swan Telecom Punjab
9167 Swan Telecom Rajasthan
9168 Swan Telecom Tamil Nadu
9169 Swan Telecom UP(east)
9170 Swan Telecom UP(west)
9171 Unitech Tamil Nadu
9172 Unitech Mumbai
9173 Unitech Gujrat
9174 Unitech Madhya Pradesh
9175 Unitech Maharashtra
9176 Vodafone(Hutch) Chennai
9177 Airtel Andhra Pradesh
9178 Airtel Orrisa
9179 Airtel Madhya Pradesh
9180 Bsnl(cdma) Andhra Pradesh
9181 Bsnl(cdma) Assam
9182 Bsnl(cdma) Bihar Jharkhand
9183 Bsnl(cdma) Chennai
9184 Bsnl(cdma) Gujrat
9185 Bsnl(cdma) Himachal Pradesh
9186 Bsnl(cdma) Jammu Kashmir
9187 Bsnl(cdma) Karnataka
9188 Bsnl(cdma) Kerala
9189 Bsnl(cdma) Kolkata
9190 Bsnl(cdma) Madhya Pradesh
9191 Bsnl(cdma) North East
9192 Bsnl(cdma) Orrisa
9193 Bsnl(cdma) Punjab
9194 Bsnl(cdma) Rajasthan
9195 Bsnl(cdma) Tamil Nadu
9196 Bsnl(cdma) UP(east)
9197 Bsnl(cdma) West Bengal
9198 Airtel UP(east)
9199 Airtel Bihar Jharkhand*/
//A Java program to demonstrate random number generation 
//using java.util.Random; 
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenerateRandomNumber {
	public static void main(String args[]) {
		generatedNumber();
	}

	public static List generatedNumber() {
		// where ^ stands for the beginnig [89] stans for allowed characters 8 or 9, and
		// then \d{7} stands for further 7 digits
		String regex = "^[0-9]\\d{5}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = null;
		int count = 0;
		List<String> tempList = null;
		// create instance of Random class
		Random rand = new Random();
		// Generate random integers in range 0 to 9
		// int rand_int1 = rand.nextInt(9);
		Integer rand_int1 = 0; // rand.nextInt(99999);
		Integer rand_int2 = 0; // rand.nextInt(99999);
		Integer rand_int3 = 0; // rand.nextInt(99999);
		TreeSet<String> number6 = new TreeSet<>();
		TreeSet<String> number5 = new TreeSet<>();
		TreeSet<String> number4 = new TreeSet<>();
		String toStringInt1 = null;
		String toStringInt2 = null;
		String toStringInt3 = null;
		String toStringInt6 = null;
		String toStringInt5 = null;
		String toStringInt4 = null;
		for (int i = 0; i < 99999; i++) {
			// System.out.println("i "+ i);
			rand_int1 = rand.nextInt(10);
			rand_int2 = rand.nextInt(99);
			rand_int3 = rand.nextInt(999);
			if (rand_int3.toString().length() <= 5) {
				/*
				 * System.out.println("if Random Integers 6: "+ "9160" + rand_int2);
				 * toStringInt6 = Integer.toString(rand_int2);
				 * System.out.println("toStringInt6 number - " + toStringInt6);
				 * number6.add("9160" + toStringInt6); //if(i == 2) //break;
				 */
				// System.out.println("if Random Integers 6: "+ "9160" +
				// rand_int2);
				// toStringInt6 = Integer.toString(rand_int2);
				// toStringInt6 = Integer.toString(rand_int1) + "" +
				// Integer.toString(rand_int3); //4 digit
				toStringInt6 = Integer.toString(rand_int1) + "" + Integer.toString(rand_int2) + ""
						+ Integer.toString(rand_int3); // 6 digit
				// System.out.println("toStringInt6 number - " + toStringInt6);
				// if("1" == Integer.toString(rand_int1))
				matcher = pattern.matcher(toStringInt6);
				// System.out.println("matcher.toStringInt6 " + matcher);
				// if (matcher.matches())
				// number6.add("7658" + "9" + toStringInt6);
				// toStringInt6 = "7658" + "9" + toStringInt6;
				if (toStringInt6.length() == 4) {
					System.out.println(toStringInt6);
					number6.add(toStringInt6);
					// if(i == 50)
					// break;
				}
			} else if (rand_int2.toString().length() == 5) {
				/*
				 * System.out.println("else if Random Integers 5: "+ "91600" + rand_int2);
				 * toStringInt5 = Integer.toString(rand_int2); number5.add("91600" +
				 * toStringInt5); if(i == 2) break;
				 */
			} else {
				/*
				 * System.out.println("else Random Integers 4: " + rand_int2); toStringInt4 =
				 * Integer.toString(rand_int2); number4.add(toStringInt4); if(i == 2) break;
				 */
			}
			// if (i == 100)
			// break;
		}

		try {
			// -----------------------------------------------------------------------------
			String fileNameOut = "D:\\workspaceKepler\\EmailReader\\src\\OutputEmail2.txt";
			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(fileNameOut);
			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			// Sorting HashSet using
			tempList = new ArrayList<String>(number6);
			Collections.sort(tempList);
			for (String genNumber : tempList) {
				// System.out.println("Generate Number6 " + genNumber + " ");
				// System.out.println("matcher.matches() " + matcher.matches() + " - " +
				// genNumber);
				// if (genNumber.length() >= 6 && genNumber.contains("76589"))
				bufferedWriter.write("\"" + genNumber + "\", ");
				count++;
				if (count == 11) {
					bufferedWriter.newLine();
					count = 0;
				}
			}
			System.out.println(" ");
			/*
			 * tempList = new ArrayList<String>(number5); Collections.sort(tempList); for
			 * (String genNumber : number5) { // System.out.println("Generate Number5 " +
			 * genNumber + " "); bufferedWriter.write(genNumber + " "); count++; if (count
			 * == 10) { bufferedWriter.newLine(); count = 0; } } tempList = new
			 * ArrayList<String>(number4); Collections.sort(tempList); for (String genNumber
			 * : number4) { // System.out.println("Generate Number4 " + genNumber); }
			 */

			System.out.println("Final Number Length 6 " + number6.size());
			System.out.println("Final Number Length 5 " + number5.size());
			System.out.println("Final Number Length 4 " + number5.size());
			System.out.println("End... ");
			// Always close files.
			bufferedWriter.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return tempList;
	}
}
