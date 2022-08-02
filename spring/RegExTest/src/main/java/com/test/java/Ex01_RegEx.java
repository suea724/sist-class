package com.test.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex01_RegEx {
	
	public static void main(String[] args) {
		
		/*
		
			Á¤±Ô Ç¥Çö½Ä, Regular Expression
		   - Æ¯Á¤ ÆĞÅÏÀÇ ¹®ÀÚ¿­À» °Ë»öÇÏ´Â Ç¥Çö½Ä(µµ±¸)
		   
		   Á¤±Ô Ç¥Çö½Ä ±¸¼º¿ä¼Ò
		   1. x
		   	- x´Â ÀÓÀÇÀÇ ÇÑ¹®ÀÚ
		   	- °íÁ¤ ¹®ÀÚ
		   	e.g. "a" > abc
		   
		   
		   2. ÃâÇöÈ½¼ö
		   	- ¹Ù·Î ¾ÕÀÇ ¹®ÀÚ(ÁıÇÕ)ÀÇ ÃâÇö È½¼ö¸¦ ÀÇ¹Ì
		   
		   2.1 »ı·«
		   	- ¹Ù·Î ¾Õ ´ë»óÀÇ ÃâÇö È½¼ö°¡ »ı·« X, Áßº¹ X
		   	- ÃâÇöÈ½¼ö > 1
		   
		   2.2 ?
		   	- ¹Ù·Î ¾Õ ´ë»óÀÇ ÃâÇö È½¼ö°¡ »ı·« O, Áßº¹ X
		   	- ÃâÇöÈ½¼ö > 0 ~ 1
		   	- e.g. "a?bc" > ab, abc, abbc, ac, bc, bbc, aaabc
		   	- e.g. "È«?±æµ¿" > ÇÏÀÌ ±æµ¿!
		   	- e.g. "ÀÚ¹Ù?ÄÚµå" > ÀÚ¹ÙÄÚµå°¡ ÀÖ½À´Ï´Ù. ÄÚµå¿¡ ¿¡·¯°¡ ÀÖ³×¿ä.
		   
		   2.3 +
		   	- ¹Ù·Î ¾Õ ´ë»óÀÇ ÃâÇö È½¼ö°¡ »ı·« X, Áßº¹ O
		   	- ÃâÇöÈ½¼ö > 1 ~ ¹«ÇÑ´ë
		   	- e.g. "a+bc" > ab, abc, abbc, ac, bc, bbc, aaabc
		   
		   2.4 *
		   	- ¹Ù·Î ¾Õ ´ë»óÀÇ ÃâÇö È½¼ö°¡ »ı·« O, Áßº¹ O
		   	- ÃâÇöÈ½¼ö > 0 ~ ¹«ÇÑ´ë
		   	- e.g. "a*bc" > ab, abc, abbc, ac, bc, bbc, aaabc
		   	- e.g. "ab?c+d" > abcd, bcd, abc, acd, abbcd, abccd, abcccc, acccddd
		   
		   3. ¼±ÅÃ
		   
		   3.1 [¿­°Å°ª]
		 	- e.g. "[123]" > 123. ¼ıÀÚ 5ÀÔ´Ï´Ù. ³ªÀÌ´Â 21»ìÀÔ´Ï´Ù. »ç°ú°¡ 223°³ ÀÖ½À´Ï´Ù.
		 	- e.g. "[123]45" > 12345, 145, 245, 345, 45
		 	- e.g. "[123]?45" > 12345, 145, 245, 345, 45
		 	- e.g. "[123]+45" > 12345, 145, 245, 345, 45
		 	- e.g. "[123]*45" > 12345, 145, 245, 345, 45
		 	- e.g. "[0123456789]+" > 123. ¼ıÀÚ 5ÀÔ´Ï´Ù. ³ªÀÌ´Â 21»ìÀÔ´Ï´Ù. »ç°ú°¡ 223°³ ÀÖ½À´Ï´Ù.
		 	- e.g. "[02468]", "[13579]+" > 2221 (¸øÃ£À½)
		 	- e.g. "µÎÀÚ¸® ¼ıÀÚ" > [0123456789][0123456789]
		 	- e.g. "ÀüÈ­¹øÈ£ °Ë»ö"
		 
		 	- ¿¬¼ÓµÈ ¹®ÀÚ¸¦ °£´ÜÇÏ°Ô Ç¥ÇöÇÏ´Â ¹æ¹ı > ¹®ÀÚÄÚµå È°¿ë
		 		e.g. ¼ıÀÚ > "[0123456789]" > "[0-9]"
		 		e.g. ¿µ¼Ò¹®ÀÚ > "[abcdefghijklmnopqrstuvwxyz]" > "[a-z]"
		 		e.g. ¿µ´ë¹®ÀÚ > "[ABCDEFGHIJKLMNOPQRSTUVWXYZ]" > "[A-Z]"
		 		e.g. ¿µ¹®ÀÚ > "[A-Za-z]"
		 		e.g. ÇÑ±Û > "[°¡-ÆR]"
		 		e.g. ¿µ¹®ÀÚ + ¼ıÀÚ + ÇÑ±Û > "[A-Za-z0-9°¡-ÆR]"
		 		
		 	3.2 [^¿­°Å°ª]
		 	- ¿­°Å°ªÀ» Á¦¿ÜÇÑ ÆĞÅÏ °Ë»ö
		 		e.g. [^0-9]
		 
		 	4. ÃâÇöÈ½¼ö
		 	- ¹Ù·Î ¾ÕÀÇ ¹®ÀÚ(ÁıÇÕ)ÀÇ ÃâÇö È½¼ö¸¦ ÀÇ¹Ì
		 	- ?, +, * > ´õ ¼¼¹ĞÇÑ ÆĞÅÏ ÁöÁ¤ °¡´É
		 
		 	4.1 {n}
				- n: °íÁ¤ ÃâÇö È½¼ö
				ex) "a{1}bc" > ab, abc, abbc, ac, bc, bbc, aaabc
				ex) "a{3}bc" > ab, abc, abbc, ac, bc, bbc, aaabc
				
			4.2 {n,m}
				- n: ÃÖ¼Ò ÃâÇö È½¼ö
				- m: ÃÖ´ë ÃâÇö È½¼ö
				ex) "a{1,3}bc" > ab, abc, abbc, ac, bc, bbc, aaabc, aabc, aaaaaaabc
			
			4.3 {n,}
				- n: ÃÖ¼Ò ÃâÇö È½¼ö
				- ÃÖ´ë ÃâÇö È½¼ö ¹«ÇÑ´ë
		 	
		 	ex) ÀüÈ­¹øÈ£: "010-[0-9]{4}-[0-9]{4}"
			ex) ÁÖ¹Î¹øÈ£: "[0-9]{6}-[0-9]{7}"
			ex) ÁÖ¹Î¹øÈ£: "[0-9]{6}-{0,1}[0-9]{7}"
			ex) ÁÖ¹Î¹øÈ£: "[0-9]{6}-?[0-9]{7}"
		 	
		 	ex) ¿µ¾î´Ü¾î(3¹®ÀÚ): "[A-Za-z]{3}"
				
			ex) ÀüÈ­¹øÈ£: "010-[0-9]{3,4}-[0-9]{4}"
				010-123-4567
				010-1234-5678
				
			ex) 1±ÛÀÚ ÀÌ»ó ¸ğµç ¿µ¾î´Ü¾î: "[A-Za-z]{1,}" or "[A-Za-z]+"
			ex) 2±ÛÀÚ ÀÌ»ó ¸ğµç ¿µ¾î´Ü¾î: "[A-Za-z]{2,}" or "[A-Za-z][A-Za-z]+"
			ex) 3±ÛÀÚ ÀÌ»ó ¸ğµç ¿µ¾î´Ü¾î: "[A-Za-z]{3,}" or "[A-Za-z][A-Za-z][A-Za-z]+"
			
			
			5. Ã³À½°ú ³¡
			- ÀÔ·Â ÄÁÆ®·Ñ(ÅØ½ºÆ® ¹Ú½º)À» ´ë»óÀ¸·Î »ç¿ë 
			
			5.1 ^
				- µÚÀÇ Ç¥ÇöÀ¸·Î ¹İµå½Ã ½ÃÀÛ
				- str.startsWith()
				ex) "^È«±æµ¿" > ´ë»ó ¹®ÀÚ¿­ÀÌ 'È«'À¸·Î ½ÃÀÛÇÏ¸é Ã£¾Æ¶ó!!
			
			5.2 $
				- ¾ÕÀÇ Ç¥ÇöÀ¸·Î ¹İµå½Ã ³¡
				- str.endsWith()
				ex) "È«±æµ¿$" > ´ë»ó ¹®ÀÚ¿­ÀÌ 'µ¿'À¸·Î ³¡³ª¸é Ã£¾Æ¶ó!!!
		
			
			6. ÁÙÀÓÇ¥Çö
				
			6.1 \d or \D
				- Digital > ¼ıÀÚ
				- \d > [0-9]
				- \D > [^0-9]
				
				ex) [0-9]{3}-[0-9]{3,4}-[0-9]{4}
				    \d{3}-\d{3,4}-\d{4}
				    
				    "\d+"
				    "\D+"
			
			6.2 \s or \S
				- °ø¹é¹®ÀÚ(½ºÆäÀÌ½º, ÅÇ, ¿£ÅÍ)
				
				ex) "\s+", "\S+"
				
				ex) "È«\s?±æµ¿"
				
				È«±æµ¿, È«  ±æµ¿, È« ±æµ¿
			
			6.3 \w or \W
				- word(¿µ¾î ´ë¼Ò¹®ÀÚ + ¼ıÀÚ + '_')
				
				ex) "\w{3,5}"
			
		*/
	}
	
	private static void m3() {
		
		String txt = "¾È³çÇÏ¼¼¿ä. Àú´Â È«±æµ¿ÀÔ´Ï´Ù. hong@gmail.com ¾î? ´ç½Å ÀÌ¸§µµ ±æµ¿ÀÌ³×¿ä? test_123@naver.com ±è±æµ¿ÀÌ³×¿ä. pinn.public@gmail.com ÀúÂÊ¿¡ ÃÖ±æµ¿µµ ÀÖ¾î¿ä. ÇÑ¸í ´õ ÀÖ³×¿ä~ ³²±Ã±æµ¿ÀÌµµ ÀÖ½À´Ï´Ù.";
		
		//http://regexlib.com
		
		String regex = "(\\w+)@([a-zA-Z_]+?\\.[a-zA-Z]{2,3})";
		
		Pattern p1 = Pattern.compile(regex);
		
		Matcher m1 = p1.matcher(txt);
		
		while (m1.find()) {
			System.out.println("ÀÌ¸ŞÀÏ: " + m1.group());
			System.out.println("¾ÆÀÌµğ: " + m1.group(1));
			System.out.println("µµ¸ŞÀÎ: " + m1.group(2));
			System.out.println();
		}
		
	}

	private static void m2() {
		
		String txt = "¾È³çÇÏ¼¼¿ä. Àú´Â È«±æµ¿ÀÔ´Ï´Ù. ¾î? ´ç½Å ÀÌ¸§µµ ±æµ¿ÀÌ³×¿ä? ±è±æµ¿ÀÌ³×¿ä. ÀúÂÊ¿¡ ÃÖ±æµ¿µµ ÀÖ¾î¿ä. ÇÑ¸í ´õ ÀÖ³×¿ä~ ³²±Ã±æµ¿ÀÌµµ ÀÖ½À´Ï´Ù.";
		
		//1. ¸ğµç ±æµ¿ÀÌ Ã£±â!!
		
		//String regex = "([È«±èÃÖ])?±æµ¿";
		String regex = "(È«|±è|ÃÖ|³²±Ã)?±æµ¿";
		
		Pattern p1 = Pattern.compile(regex);
		
		Matcher m1 = p1.matcher(txt);
		
		
		while (m1.find()) {
			System.out.println("Ã£Àº ÀÌ¸§: " + m1.group());
			System.out.println("¼º¾¾: " + m1.group(1));
			System.out.println("¼º¾¾: " + m1.group().substring(0, 1));
			System.out.println();
		}
		
		
	}

	private static void m1() {
		
		String txt = "¾È³çÇÏ¼¼¿ä. È«±æµ¿ÀÔ´Ï´Ù. 010-1234-5678 Áö±İ Á¤±Ô Ç¥Çö½ÄÀ» °øºÎÇÏ´Â ÁßÀÔ´Ï´Ù. 010-8547-9854 ¹Û¿¡ ºñ°¡ ³»¸³´Ï´Ù. 010-652-9854 ¹è°¡ °íÇÅ´Ï´Ù.";
		
		//1. txt ¾È¿¡ ÀüÈ­¹øÈ£°¡ ÀÖ´ÂÁö À¯¹«?
		
		//String regex = "[0-9]{3}-[0-9]{3,4}-[0-9]{4}";
		String regex = "([0-9]{3})-([0-9]{3,4})-([0-9]{4})";
		
		//Á¤±Ô½ÄÀ» »ç¿ëÇÏ´Â °Ë»ö µµ±¸ > Pattern
		Pattern p1 = Pattern.compile(regex);
		
		//°Ë»ö °á°ú > Matcher
		Matcher m1 = p1.matcher(txt);
		
		//System.out.println(m1.find());
		
//		if (m1.find()) {
//			System.out.println("txt³»¿¡ ÀüÈ­¹øÈ£°¡ ¹ß°ßµÇ¾ú½À´Ï´Ù.");
//		} else {
//			System.out.println("txt³»¿¡ ÀüÈ­¹øÈ£°¡ ¾ø½À´Ï´Ù.");
//		}
		
		
		while (m1.find()) {
			System.out.println("ÀüÈ­¹øÈ£¸¦ ¹ß°ßÇß½À´Ï´Ù.");
			System.out.println(m1.group());
			System.out.println("ÀüÃ¼ ¹®ÀÚ¿­: " + m1.group(0));
			System.out.println("Ã¹¹øÂ° °ıÈ£(Åë½Å»ç): " + m1.group(1));
			System.out.println("µÎ¹øÂ° °ıÈ£(¾ÕÀÚ¸®): " + m1.group(2));
			System.out.println("¼Â¹øÂ° °ıÈ£(µŞÀÚ¸®): " + m1.group(3));
			System.out.println();
		}
		
	}
	

}
