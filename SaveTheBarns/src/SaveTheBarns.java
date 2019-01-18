import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.io.BufferReader;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.io.IOException;
import java.util.ArrayList;

public class SaveTheBarns {
	//declaring variables for contributions
	static double cMenCont = 0.0;
	static double cWomCont = 0.0; 
	static double cDemCont = 0.0;
	static double cRepCont = 0.0;
	static double cIndCont = 0.0;
	static double cMenDemCont = 0.0;
	static double cWomDemCont = 0.0;
	static double cMenRepCont = 0.0;
	static double cWomRepCont = 0.0;
	static double cMenIndCont = 0.0;
	static double cWomIndCont = 0.0;
	static double cOverallCont = 0.0;
	
	//declaring variables for conters
	static int cMenCtr = 0;
	static int cWomCtr = 0; 
	static int cDemCtr = 0;
	static int cRepCtr = 0;
	static int cIndCtr = 0;
	static int cMenDemCtr = 0;
	static int cWomDemCtr = 0;
	static int cMenRepCtr = 0;
	static int cWomRepCtr = 0;
	static int cMenIndCtr = 0;
	static int cWomIndCtr = 0;
	static int cOverallCtr = 0;
	
	//declaring variables for averages
	static double cMenAvg = 0.0;
	static double cWomAvg = 0.0;
	static double cDemAvg = 0.0;
	static double cRepAvg = 0.0;
	static double cIndAvg = 0.0;
	static double cMenDemAvg = 0.0;
	static double cMenRepAvg = 0.0;
	static double cMenIndAvg = 0.0;
	static double cWomDemAvg = 0.0;
	static double cWomRepAvg = 0.0;
	static double cWomIndAvg = 0.0;
	static double cOverallAvg = 0.0;
	
	static String oErrMsg;
	static String iString;
	static String iAddress;
	static String iCity;
	static String iState;
	static String iContributionName;
	static Scanner FileScanner;
	static PrintWriter pw;
	static PrintWriter errpw;
	static boolean eof = false;
	static boolean errws = false;
	static String iZip;
	static String iParty;
	static char ChariParty;
	static String iGender;
	static char ChariGender;
	static String iContribution;
	static double DoubiContribution;
	static String input = "";
	static String iRec;
	
	public static void main(String[] args) {
		//call initialization
		init();

		//call loop
		while (!eof) {
		validation();
		input();
		calcs();
		}
		//call output
		output();

		//call closing
		closing();
		}

    public static void init() {
		try {
		FileScanner = new Scanner(new File("contributors.dat"));
		FileScanner.useDelimiter("r/n/");
		}
			
		catch (FileNotFoundException e) {
			System.out.println("Input file error. Program terminated");
		}
	}
		
		
	public static void validation() { 
		iContributionName = iRec.substring(0,24).trim();
		if (iContributionName.isEmpty()) {
			System.out.print("Contributor name is required.");
			return;
		}
		
		iAddress = iRec.substring(24,49).trim();
		if (iContributionName.isEmpty()) {
			System.out.print("Address is required.");
			return;
		}
		
		iCity = iRec.substring(49,64).trim();
		if (iContributionName.isEmpty()) {
			System.out.print("City is required.");
			return;
		}
		
		iState = iRec.substring(64,66).trim();
		if (iContributionName.isEmpty()) {
			System.out.print("State is required.");
			return;
		}
		
		iZip = iRec.substring(66,71).trim();
		if (iContributionName.isEmpty()) {
			System.out.print("Zip code is required.");
			return;
		}
		
		iParty = iRec.substring(71,72).trim();
		if (iParty.isEmpty()) {
			System.out.print("Party type is required.");
			return;
		}
		
		iGender = iRec.substring(72,73).trim();
		if (iGender.isEmpty()) {
			System.out.print("Gender is required.");
			return;
		}
		
		iContribution = iRec.substring(73,80).trim();
		if (iContribution.isEmpty()) {
			System.out.print("Contribution is required.");
			return;
		}
	}
		
		
	public static void input() {
		if (FileScanner.hasNext()) {
			iRec = FileScanner.next();
			iContributionName = iRec.substring(0, 24);
			iAddress = iRec.substring(24, 49);
			iCity = iRec.substring(49, 64);
			iState = iRec.substring(64, 66);
			iZip = iRec.substring(66,71);
			iParty = iRec.substring(71, 72);
			iGender = iRec.substring(72,73);
			iContribution = iRec.substring(73,80);
		}
		else
			eof = true;
			
		DoubiContribution = Double.parseDouble(iContribution);
			
	}
		
		
	public static void calcs() {
			
		switch(iParty.toUpperCase()) {
			case "D":
				if(iGender=="M") {
				cMenDemCtr += 1;
				cMenCtr += 1;
				cDemCtr += 1;}
					
				if(iGender=="F") {
				cWomDemCtr+=1;
				cWomCtr += 1;
				cDemCtr += 1;}
			case "I":
				if(iGender=="M") {
				cMenIndCtr += 1;
				cMenCtr += 1;
				cIndCtr += 1;}
					
				if(iGender=="F") {
				cWomIndCtr += 1;
				cWomCtr += 1;
				cIndCtr += 1;}
			case "R":
				if(iGender=="M") {
				cMenRepCtr += 1;
				cMenCtr += 1;
				cRepCtr += 1;}
					
				if(iGender=="F") {
				cWomRepCtr += 1;
				cWomCtr += 1;
				cRepCtr += 1;}
		}
		switch(iParty.toUpperCase()) {
			case "D":
				if(iGender=="M") {
				cMenDemCont = cMenDemCont + DoubiContribution;
				cMenCont = cMenCont + DoubiContribution;
				cDemCont = cDemCont + DoubiContribution;}
					
				if(iGender=="F") {
				cWomDemCont = cWomDemCont + DoubiContribution;
				cWomCont = cWomCont + DoubiContribution;
				cDemCont = cDemCont + DoubiContribution;}
			case "I":
				if(iGender=="M") {
				cMenIndCont = cMenIndCont + DoubiContribution;
				cMenCont = cMenCont + DoubiContribution;
				cIndCont = cIndCont + DoubiContribution;}
					
				if(iGender=="F") {
				cWomIndCont = cWomIndCont + DoubiContribution;
				cWomCont = cWomCont + DoubiContribution;
				cIndCont = cIndCont + DoubiContribution;}
			case "R":
				if(iGender=="M") {
				cMenRepCont = cMenRepCont + DoubiContribution;
				cMenCont = cMenCont + DoubiContribution;
				cRepCont = cRepCont + DoubiContribution;}
					
				if(iGender=="F") {
				cWomRepCont = cWomRepCont + DoubiContribution;
				cWomCont = cWomCont + DoubiContribution;
				cRepCont = cRepCont + DoubiContribution;}
		}
		
			cOverallCtr += 1;
			cOverallCont = cOverallCont + DoubiContribution;
	
		}
		
		
		public static void output() {
			
			cMenAvg = cMenCont/cMenCtr;
			cWomAvg = cWomCont/cWomCtr;
			cDemAvg = cDemCont/cDemCtr;
			cIndAvg = cIndCont/cIndCtr;
			cRepAvg = cRepAvg/cRepCtr;
			cMenDemAvg = cMenDemCont/cMenDemCtr;
			cMenIndAvg = cMenIndCont/cMenIndCtr;
			cMenRepAvg = cMenRepCont/cMenRepCtr;
			cWomDemAvg = cWomDemCont/cWomDemCtr;
			cWomIndAvg = cWomIndCont/cWomIndCtr;
			cWomRepAvg = cWomRepCont/cWomRepCtr;
			cOverallAvg = cOverallCont/cOverallCtr;
			
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
			Date date = new Date();		
			DecimalFormat df = new DecimalFormat(".00");
			System.out.println("Date: " + dateFormat.format(date));
			System.out.println("");
			System.out.println("SUMMARY REPORT");
			System.out.println("Record Count: " + cOverallCtr);
			System.out.println("Men: %.2f\n"+ cMenCont);
		
			System.out.printf("Women: %.2f\n", cWomCont);
			System.out.printf("Democrats: %.2f\n", cDemCont);
			System.out.printf("Republicans: %.2f\n", cIndCont);
			System.out.printf("Independents: %.2f\n", cIndCont);
			System.out.printf("DemocraticMen: %.2f\n", cMenDemCont);
			System.out.printf("DemocraticWomen: %.2f\n", cWomDemCont);
			System.out.printf("RepublicanMen: %.2f\n", cMenRepCont);
			System.out.printf("RepublicanWomen: %.2f\n", cWomRepCont);
			System.out.printf("IndependentMen: %.2f\n", cMenIndCont);
			System.out.printf("IndependentWomen: %.2f\n", cWomIndCont);
			System.out.printf("Overall: %.2f\n", cOverallAvg);

		}
		
		
		public static void closing() {

		}
	}


