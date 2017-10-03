package com.qfedu.util;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import static com.qfedu.util.CommonUtil.*;
import static java.lang.System.*;
import static org.junit.Assert.*;

// Keep your bar green!!!
public class CommonUtilTest {

	@Test
	public void testGetUniqueFilename() {
		Set<String> set = new HashSet<>();
		for (int i = 1; i <= 1000000; ++i) {
			set.add(getUniqueFilename());
		}
		assertEquals(1000000, set.size());
		out.print(getUniqueFilename());
	}

	@Test
	public void testGetFilenameSuffix() {
		// out.println("Hello, world!");
		assertEquals(".jpg", getFilenameSuffix("hello.jpg"));
		assertEquals(".jpg", getFilenameSuffix("a.b.c.jpg"));
		assertEquals("", getFilenameSuffix("hello"));
		assertEquals("", getFilenameSuffix(".jpg"));
		assertEquals("", getFilenameSuffix("hello."));
	}

}

