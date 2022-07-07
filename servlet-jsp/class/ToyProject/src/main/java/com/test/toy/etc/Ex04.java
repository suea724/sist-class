package com.test.toy.etc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ex04 {
	
	public static void main(String[] args) throws Exception  {
		
		/**
		 * Jsoup 방식
		 * - 인증이 불필요한 페이지에서 사용 가능
		 * - 인증이 필요한 페이지에서 사용 불가능 > 고비용
		 * - JavaScript 실행이 필요한 페이지에서 사용 불가 > Ajax 페이지
		 * 
		 *  웹 응용 프로그램 자동화 프로그램
		 *  - 셀레니움
		 *  - 사람 대신 프로그램이 사람처럼 웹사이트에 방문해서 여러가지 행동을 하는 프로그램
		 *  - 크롤링 작업도 가능하다.
		 *  - 인증이 필요한 페이지에서 사용 가능
		 *  - JavaScript 실행이 필요한 페이지에서 사용 가능
		 *  - 준비물 > 드라이버 > 브라우저 종류 + 버전
		 */
		
		// m1();
		// m2();
		m3();
	}

	private static void m3() {
		
		String webDriverID = "webdriver.chrome.driver";
		String path = "B:\\class\\chromedriver.exe";
		
		System.setProperty(webDriverID, path);
		
		// client-combined-3.141.59
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		
		WebDriver driver = new ChromeDriver(options);
		
		// 자동으로 페이지 열고 로그인 하기!
		
		String url = "https://www.musinsa.com/auth/login?referer=https%3A%2F%2Fwww.musinsa.com%2Fapp%2F";
		
		driver.get(url);
		
		WebElement id = driver.findElement(By.cssSelector("input[name=id]"));
		id.sendKeys("suea724");
		
		WebElement pw = driver.findElement(By.cssSelector("input[name=pw]"));
		pw.sendKeys("dlfnek1191");
		
		WebElement btn = driver.findElement(By.cssSelector("body > div.container.login > section > div.login-member > form > div.login-button.login-button--static > button"));
		btn.click();
		
		// WebElement info = driver.findElement(By.cssSelector("#default_top > div.header-member > div:nth-child(1) > a"));
		// System.out.println(info.getText());
		
	}

	private static void m2() {
		String webDriverID = "webdriver.chrome.driver";
		String path = "B:\\class\\chromedriver.exe";
		
		System.setProperty(webDriverID, path);
		
		// client-combined-3.141.59
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		
		WebDriver driver = new ChromeDriver(options);
		
		String url = "http://localhost:8090/toy/etc/expage.do";
		
		driver.get(url);
		
		WebElement name = driver.findElement(By.id("name"));
		
		System.out.println(name.getText());
	}

	private static void m1() throws Exception {
		
		String url = "http://localhost:9090/toy/etc/expage.do";
		
		Document doc = Jsoup.connect(url).get();
		
		Element span = doc.selectFirst("body > main > section > span");
		
		System.out.println(span.text());
		
		Element span2 = doc.selectFirst("#name");
		
		System.out.println(span2.text());
	}
}
