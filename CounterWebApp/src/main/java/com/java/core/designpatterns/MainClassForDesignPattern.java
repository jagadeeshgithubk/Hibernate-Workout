package com.java.core.designpatterns;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.sun.imageio.plugins.common.InputStreamAdapter;

public class MainClassForDesignPattern {

	public static void main(String[] args) throws FileNotFoundException {
		SingleTonClass singleTon1 = SingleTonClass.getSingleTon();

		SingleTonClass singleTon2 = SingleTonClass.getSingleTon();

		/*
		 * ClassicSingleton singleTon1 = ClassicSingleton.getInstance();
		 * ClassicSingleton singleTon2 = ClassicSingleton.getInstance();
		 */System.out.println(singleTon1 == singleTon2);
		String s = "test";
		String s1 = s + "tampered";
		System.out.println(s);
		StringBuilder stringBuilder = new StringBuilder("first one");
		stringBuilder.append("second");
		System.out.println(stringBuilder.toString());

		char[] charArray = s.toCharArray();
		List<Character> arrayList = new ArrayList<>();
		for (int i = charArray.length - 1; i >= 0; i--) {
			arrayList.add(charArray[i]);
		}

		for (Character character : arrayList) {
			System.out.println(character);
		}
		ImmutableClass instance = ImmutableClass.getInstance(90);
		Integer integer = instance.getInteger();
		System.out.println(++integer);
		System.out.println(instance.getInteger());
		
		FacadeDesignPattern facadeDesignPattern = new FacadeDesignPattern();
		facadeDesignPattern.executeMethod("Qa");
		new TemplateDesignImpl();
	}

}
