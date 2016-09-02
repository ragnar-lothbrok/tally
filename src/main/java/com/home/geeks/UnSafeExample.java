package com.home.geeks;

import sun.misc.Unsafe;

public class UnSafeExample {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		final java.lang.reflect.Field field = Unsafe.class.getDeclaredField("theUnsafe");
		field.setAccessible(true);
		Unsafe unsafe = (Unsafe) field.get(Unsafe.class);
		System.out.println(unsafe);
	}
}
