package com.test.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	
	public static void main(String[] args) {

		CSVReader obj = new CSVReader();
		
		String transactions = "C:\\Users\\Jagadeesh\\Desktop\\Rajini\\FX test\\transactions.csv";
		
		List<String[]> parseTransactions = obj.parseCSV(transactions);
		System.out.println("...........Transactions.............");

		for (String[] strings : parseTransactions) {
			for (String string : strings) {
				System.out.println(string);
			}
			System.out.println("..............");
		}

		String rates = "C:\\Users\\Jagadeesh\\Desktop\\Rajini\\FX test\\rates.csv";
		List<String[]> parseRates = obj.parseCSV(rates);
		
		System.out.println("...........RATES.............");
		for (String[] strings : parseRates) {
			for (String string : strings) {
				System.out.println(string);
			}
			System.out.println("..............");
		}
		
		
		
	}

	public  List<String[]> parseCSV(String csvFile) {

		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		String[] transactions = null;
		List<String[]> arrayList = new ArrayList<>();
		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				
				// use comma as separator
				transactions = line.split(cvsSplitBy);
				arrayList.add(transactions);
//				System.out.println("....................");
			}
			return arrayList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
		return arrayList;
	}

}

class TransactionsModel{
	String baseCurrency;
	String wantedCurrency;
	Long amountInBaseCurrency;	
	String clientType;	
	Float transactionTime;
	
	public TransactionsModel(String baseCurrency, String wantedCurrency,
			Long amountInBaseCurrency, String clientType,
			Float transactionTime) {
		super();
		this.baseCurrency = baseCurrency;
		this.wantedCurrency = wantedCurrency;
		this.amountInBaseCurrency = amountInBaseCurrency;
		this.clientType = clientType;
		this.transactionTime = transactionTime;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public String getWantedCurrency() {
		return wantedCurrency;
	}

	public Long getAmountInBaseCurrency() {
		return amountInBaseCurrency;
	}

	public String getClientType() {
		return clientType;
	}

	public Float getTransactionTime() {
		return transactionTime;
	}
}
 
