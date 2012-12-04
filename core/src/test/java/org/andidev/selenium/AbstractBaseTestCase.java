package org.andidev.selenium;
//
//import java.io.File;

import junit.framework.TestCase;

//import java.io.IOException;
//import java.net.BindException;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
//import junit.framework.Assert;
//import junit.framework.TestCase;
//
//import org.apache.commons.lang.StringUtils;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Rule;
//import org.junit.rules.MethodRule;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized.Parameters;
//import org.junit.runners.model.FrameworkMethod;
//import org.junit.runners.model.Statement;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriverBackedSelenium;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.server.RemoteControlConfiguration;
//import org.openqa.selenium.server.SeleniumServer;
//
//import org.openqa.selenium.chrome.ChromeDriverService;
//
//import com.eniro.swat.core.annotation.Jira;
//import com.eniro.swat.core.domain.TestConfiguration;
//import com.eniro.swat.core.domain.TestConfiguration.Browser;
//import com.eniro.swat.core.domain.TestConfiguration.Localization;
//import com.eniro.swat.core.domain.TestStatus;
//import com.eniro.swat.core.domain.TestStatus.Status;
//import com.eniro.swat.core.domain.TestStatusWrapper;
//import com.eniro.swat.core.domain.builder.TestConfigurationBuilder;
//import com.eniro.swat.core.exception.CouldNotStartSeleniumServerException;
//import com.eniro.swat.core.exception.PropertyFileNotFoundException;
//import com.eniro.swat.core.handler.EventHandler;
//import com.eniro.swat.core.loader.LocalizationPropertyLoader;
//import com.eniro.swat.core.loader.PropertyLoader;
//import com.eniro.swat.core.runner.SeleniumSuiteRunner;
//import com.eniro.swat.core.util.HttpUtil;
//import com.eniro.swat.core.util.StackTraceUtil;
//import com.thoughtworks.selenium.DefaultSelenium;
//import com.thoughtworks.selenium.Selenium;

//@RunWith(value = SeleniumSuiteRunner.class)
public class AbstractBaseTestCase extends TestCase {
//
//	static SeleniumServer seleniumServer = null;
//	protected DefaultSelenium selenium = null;
//	private TestConfiguration config = null;
//	public static PropertyLoader propertyLoader = null;
//	public static LocalizationPropertyLoader localizationPropertyLoader = null;
//	public static Map<String, String> data;
//	public static Map<String, TestStatusWrapper> testCaseStatus = new HashMap<String, TestStatusWrapper>();
//	public static Map<String, String> testIssueKey = new HashMap<String, String>();
//
//	public static final String PAGE_LOADING_TIME = "120000";
//	protected WebDriver driver = null;
//
//	@Rule
//	public SeleniumCaptureScreenshotRule rule = new SeleniumCaptureScreenshotRule();
//
//	@Parameters
//	public static Collection<Object[]> browserData() throws IOException, PropertyFileNotFoundException {
//
//		propertyLoader = new PropertyLoader().loadProperties();
//		localizationPropertyLoader = new LocalizationPropertyLoader();
//
//		final String[] browsers = propertyLoader.getBrowsers();
//		final Object[][] browserData = new Object[browsers.length * propertyLoader.getLocale().size()][];
//
//		for (int i = 0, j = 0; i < browsers.length; i++) {
//			final Browser browser = Browser.valueOf(browsers[i].trim());
//
//			for (Localization locale : propertyLoader.getLocale()) {
//				browserData[j] = new Object[] { TestConfigurationBuilder.aTestConfiguration().forBrowser(browser).forLocalization(locale)
//						.build() };
//				j++;
//			}
//		}
//
//		return Arrays.asList(browserData);
//	}
//
//	public AbstractBaseTestCase(TestConfiguration testConfiguration) {
//		this.config = testConfiguration;
//	}
//
//	/**
//	 * Get the text for the given locale(in selenium config file)
//	 * 
//	 * @param key
//	 *            The property key
//	 * @return The text
//	 */
//	public String getLocalizationText(String key) {
//		return AbstractBaseTestCase.localizationPropertyLoader.getPropertyStr(key);
//	}
//
//	public String getData(String key) {
//		return AbstractBaseTestCase.data.get(key);
//	}
//
//	@BeforeClass
//	public static void before() throws Exception {
//
//		AbstractBaseTestCase.testCaseStatus.clear();
//
//		final int serverPort = propertyLoader.getPort();
//		final String serverHost = propertyLoader.getHost();
//
//		try {
//			RemoteControlConfiguration config = new RemoteControlConfiguration();
//			config.setPort(serverPort);
//
//			seleniumServer = new SeleniumServer(config);
//			seleniumServer.start();
//		} catch (BindException be) {
//
//			if (HttpUtil.stopServerWithHttpCommand(serverPort, serverHost)) {
//				seleniumServer = new SeleniumServer();
//				seleniumServer.start();
//			} else {
//				throw new CouldNotStartSeleniumServerException(serverHost, serverPort);
//			}
//		} catch (Exception e) {
//			throw new CouldNotStartSeleniumServerException(serverHost, serverPort, e);
//		}
//	}
//
//	@Before
//	public void beforeTest() throws PropertyFileNotFoundException, IOException {
//
//		final Browser browser = this.config.getBrowser();
//		localizationPropertyLoader.loadProperties(this.config.getLocalization());
//
//		if (browser.equals(Browser.GOOGLE_CHROME)) {
//			ChromeOptions co = new ChromeOptions();
//			File file;
//			System.out.println("OS: "+getOS());
//			if ("macosx".equals(getOS())) {
//				file = new File("../swat-commons/src/main/resources/macosx/chromedriver");
//				System.setProperty("chrome.binary", new File("/Applications/Google\\ Chrome.app/Contents/MacOS/Google\\ Chrome").getAbsolutePath());
//			} else {
//				file = new File("../swat-commons/src/main/resources/chromedriver.exe");
//			}
//			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//			co.addArguments("--allow-running-insecure-content", "--start-maximized");
//			driver = new ChromeDriver(co);
//		} else if (browser.equals(Browser.IEXPLORER)) {
//			File file = new File("../swat-shit/src/main/resources/IEDriverServer.exe");
//			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
//			driver = new InternetExplorerDriver();
//			driver.manage().window().maximize();
//		} else if (browser.equals(Browser.FIREFOX)) {
//			driver = new FirefoxDriver();
//			driver.manage().window().maximize();
//		}
//		driver.manage().timeouts().setScriptTimeout(300, TimeUnit.SECONDS);
//		this.selenium = new WebDriverBackedSelenium(driver, localizationPropertyLoader.getPropertyStr("open"));
//	}
//	
//	public String getOS() {
//		String os = System.getProperty("os.name");
//		if (os==null ) {
//			return "";
//		}
//		return os.replaceAll(" ", "").toLowerCase();
//	}
//
//	@AfterClass
//	public static void after() {
//		seleniumServer.stop();
//	}
//
//	/**
//	 * @return
//	 * @uml.property name="selenium"
//	 */
//	public Selenium getSelenium() {
//		return this.selenium;
//	}
//
//	private void addTestCase(Jira annotation, Status status) {
//
//		if (annotation == null || (StringUtils.isEmpty(annotation.issue()) && StringUtils.isEmpty(annotation.testCase()))) {
//			return;
//		}
//
//		final String key = StringUtils.isEmpty(annotation.issue()) ? annotation.testCase() : annotation.issue();
//		final TestStatus testStatus = TestStatus.create(status, this.config.getBrowser(), this.config.getLocalization());
//
//		if (AbstractBaseTestCase.testCaseStatus.get(key) != null) {
//			AbstractBaseTestCase.testCaseStatus.get(key).addTestStatus(testStatus);
//		} else {
//			AbstractBaseTestCase.testCaseStatus.put(key, new TestStatusWrapper(testStatus));
//		}
//	}
//
//	/**
//	 * Rule for capture screenshots when exception or throwable is thrown.
//	 * 
//	 * @author Jonas Biberg
//	 * 
//	 */
//	class SeleniumCaptureScreenshotRule implements MethodRule {
//
//		Statement base = null;
//		FrameworkMethod method = null;
//
//		/**
//		 * A new statement that captures screenshots if its fails and fails the
//		 * test. Finally it will close the browser and the selenium client.
//		 */
//		@Override
//		public Statement apply(final Statement base, final FrameworkMethod method, Object target) {
//
//			this.base = base;
//			this.method = method;
//
//			return new Statement() {
//
//				/**
//				 * Evaluate the rule and fails if a exception is captured.
//				 */
//				@Override
//				public void evaluate() throws Throwable {
//					try {
//						base.evaluate();
//						addTestCase(method.getAnnotation(Jira.class), Status.SUCCESS);
//						new EventHandler(propertyLoader, selenium).handleSucess(method, config);
//					} catch (Throwable e) {
//						addTestCase(method.getAnnotation(Jira.class), Status.FAILED);
//						final String issueKey = new EventHandler(propertyLoader, selenium).handleFailure(e, method, config);
//						testIssueKey.put(method.getName(), issueKey);
//						Assert.fail(StackTraceUtil.stackTraceToString(e));
//					} finally {
//						if (selenium != null)
//							selenium.stop();
//					}
//				}
//			};
//		}
//	}
}
