package com.all.core.java.pdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.TreeSet;
import java.util.logging.Logger;

import com.all.core.java.misc.GenerateBday;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class DecryptPdfDocument {

	private static final Logger logger = Logger.getLogger(DecryptPdfDocument.class.getName());

	static String owner = "";
	static String original = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\Infosys_F16_00687656_2017.PDF";
	static String destination = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\Infosys_F16_00687656_2017_Decrypt.PDF";

	public static void main(String... args) throws IOException, DocumentException {

		GenerateBday generateBday = new GenerateBday();
		TreeSet<String> bDayTreeSet = generateBday.bDay();
		System.out.println("bDayTreeSet.size() " + bDayTreeSet.size());
		int count = 0;
		// for(int i = 0; i < bDayTreeSet.size(); i++){
		for (String strPWD : bDayTreeSet) {
			try {
				if (count <= 2) {
					PdfReader reader = new PdfReader(original, strPWD.toString().getBytes());
					System.out.println("createFakeFontSubsets " + reader.createFakeFontSubsets());
					System.out.println("dumpPerc " + reader.dumpPerc());
					System.out.println("getCertificationLevel " + reader.getCertificationLevel());
					System.out.println("getCryptoMode " + reader.getCryptoMode());
					System.out.println("getEofPos " + reader.getEofPos());
					System.out.println("getFileLength " + reader.getFileLength());
					System.out.println("getJavaScript " + reader.getJavaScript());
					System.out.println("getLastXref " + reader.getLastXref());
					System.out.println("getNumberOfPages " + reader.getNumberOfPages());
					System.out.println("getPdfVersion " + reader.getPdfVersion());
					System.out.println("getPermissions " + reader.getPermissions());
					System.out.println("getSimpleViewerPreferences " + reader.getSimpleViewerPreferences());
					System.out.println("getXrefSize " + reader.getXrefSize());
					System.out.println("removeUnusedObjects " + reader.removeUnusedObjects());
					System.out.println("shuffleSubsetNames " + reader.shuffleSubsetNames());
					System.out.println("computeUserPassword " + reader.computeUserPassword());
					System.out.println("getAcroFields " + reader.getAcroFields());
					System.out.println("getAcroForm " + reader.getAcroForm());
					System.out.println("getCatalog " + reader.getCatalog());
					System.out.println("getClass().getSimpleName() " + reader.getClass().getSimpleName());
					System.out.println("getInfo " + reader.getInfo());
					System.out.println("getMetadata " + reader.getMetadata());
					System.out.println("getNamedDestination " + reader.getNamedDestination());
					System.out.println("getNamedDestinationFromNames " + reader.getNamedDestinationFromNames());
					System.out.println("getNamedDestinationFromStrings " + reader.getNamedDestinationFromStrings());
					System.out.println("getSafeFile " + reader.getSafeFile());
					System.out.println("getTrailer " + reader.getTrailer());
					System.out.println("is128Key " + reader.is128Key());
					System.out.println("isAppendable " + reader.isAppendable());
					System.out.println("isEncrypted " + reader.isEncrypted());
					System.out.println("isHybridXref " + reader.isHybridXref());
					System.out.println("isHybridXref " + reader.isMetadataEncrypted());
					System.out.println("isNewXrefType " + reader.isNewXrefType());
					System.out.println("isOpenedWithFullPermissions " + reader.isOpenedWithFullPermissions());
					System.out.println("isRebuilt " + reader.isRebuilt());
					System.out.println("isRebuilt " + reader.isTampered());
					reader.consolidateNamedDestinations();
					reader.eliminateSharedStreams();
					reader.makeRemoteNamedDestinationsLocal();
					reader.releaseLastXrefPartial();
					reader.removeAnnotations();
					reader.removeFields();
					reader.removeUsageRights();
					reader.resetLastXrefPartial();
					reader.resetReleasePage();
					System.out.println("");
					PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(destination));
					System.out.println("isFullCompression " + stamper.isFullCompression());
					System.out.println("isRotateContents " + stamper.isRotateContents());
					System.out.println("getAcroFields " + stamper.getAcroFields());
					// System.out.println("getLtvVerification " + stamper.getLtvVerification());
					System.out.println("getMoreInfo " + stamper.getMoreInfo());
					System.out.println("getPdfLayers " + stamper.getPdfLayers());
					System.out.println("getReader " + stamper.getReader());
					System.out.println("getSignatureAppearance " + stamper.getSignatureAppearance());
					System.out.println("getWriter " + stamper.getWriter());
					stamper.setFullCompression();
					stamper.close();
				}
				// if(count == 1){
				// break;
				// }
				count++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
