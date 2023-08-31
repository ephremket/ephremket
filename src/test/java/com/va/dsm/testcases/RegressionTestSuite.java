package com.va.dsm.testcases;

import com.va.dsm.pages.*;
import com.va.dsm.util.CommonUtil;
import com.va.dsm.util.LoadDriver;
import com.va.dsm.util.ReadExcelData;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // To run methods in certain order
public class RegressionTestSuite extends LoadDriver {
	private static WebDriver driver = null;
	private static String excelFilePath = null;
	private static String browserName = null;
	private static String applicationURL = null;

	@BeforeClass
	public static void beforeTest() throws Exception {
		System.out.println("RegressionTestSuite DSM Execution");
		try {
			excelFilePath = ReadExcelData.readFilePathFromConfig(); // Read file path from config file

			ReadExcelData excelUtil = new ReadExcelData(excelFilePath);
			browserName = excelUtil.getCellData("Main", "Browser", 2); // get the browser name to run the application
			applicationURL = excelUtil.getCellData("Main", "URL", 2); // get DSM application URL

			System.out.println("browserName ->" + browserName);
			System.out.println("applicationURL->" + applicationURL);

			driver = LoadDriver.createDriver(browserName);
			System.out.println("Navigate to VA WebMail");

			System.out.println("After driver 1e");
			CommonUtil.waitForPageToLoad();
			System.out.println("After driver 1f");
			System.out.println("driver.getTitle() ->" + driver.getTitle());

			System.out.println("After driver 1g");
			driver.get(applicationURL);
			Robot robot =new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			driver.manage().window().maximize();
			System.out.println("Navigate to VA WebMail");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@AfterClass
	public static void afterTest() throws Exception {
		System.out.println("Run this after class");

	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ START ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	@Test
	public void Test001_DSM_Email_Compose_No_Attachment() throws Exception {
		System.out.println("Test001");
// WARNING NOT USED   		String sheetName = "DSM Login";

		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmailPage.class);
			CommonUtil.waitForPageToLoad();

			// Test DSM Email Compose with No Attachment
			DSMEmailPage.Test_DSM_Email_Compose_No_Attachment(excelFilePath, "DSM Email No Attachment");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void Test002_DSM_Email_Compose_With_Attachment() throws Exception {
		System.out.println("Test002");


		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmailPage.class);
			CommonUtil.waitForPageToLoad();

			// Test DSM Email Compose with Attachment
			DSMEmailPage.Test_DSM_Email_Compose_With_Attachment(excelFilePath, "DSM Email With Attachment");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Test
	public void Test003_DSM_Email_Compose_With_CCD_Attachment() throws Exception {
		System.out.println("Test003");


		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmailPage.class);
			CommonUtil.waitForPageToLoad();

			// Test DSM Email Compose with CCD Attachment
			DSMEmailPage.Test_DSM_Email_Compose_With_CCD_Attachment(excelFilePath, "DSM Email With CCD Attachment");
			Thread.sleep(6000);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	@Test
	public void Test004_DSM_Email_Create_Folder() throws Exception {
		System.out.println("Test004");


		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmailPage.class);
			CommonUtil.waitForPageToLoad();

			// Test DSM Email - Remaining functionalities like Archive, Folder creation, Move To, Mark as Read and Unread
			DSMEmailPage.Test_DSM_Email_Create_Folder(excelFilePath, "Create Folder");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	@Test
	public void Test005_DSM_Email_Drafts_Archive_Discard() throws Exception {
		System.out.println("Test005");


		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmailPage.class);
			CommonUtil.waitForPageToLoad();

			// Test DSM Email - Remaining functionalities like Draft - Archive and Discard
			DSMEmailPage.Test_DSM_Email_Drafts_Archive_Discard(excelFilePath, "Drafts-Archive and Discard");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void Test006_DSM_Email_Archive_Functionalities() throws Exception {
		System.out.println("Test006");


		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmailPage.class);
			CommonUtil.waitForPageToLoad();

			// Test DSM Email - Archive option functionalities
			DSMEmailPage.Test_DSM_Email_Archive_Functionalities(excelFilePath, "Archive");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void Test007_DSM_Email_Outbox() throws Exception {
		System.out.println("Test007");

		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmailPage.class);
			CommonUtil.waitForPageToLoad();

			// Test DSM Email - Outbox functionalities
			DSMEmailPage.Test_DSM_Email_Outbox(excelFilePath, "Outbox");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void Test008_DSM_Email_Inbox() throws Exception {
		System.out.println("Test008");


		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmailPage.class);
			CommonUtil.waitForPageToLoad();

			// Test DSM Email - Inbox functionalities
			DSMEmailPage.Test_DSM_Email_Inbox(excelFilePath, "Inbox");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void Test009_DSM_Email_Sent() throws Exception {
		System.out.println("Test009");

		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmailPage.class);
			CommonUtil.waitForPageToLoad();

			// Test DSM Email - Sent functionalities
			DSMEmailPage.Test_DSM_Email_Sent(excelFilePath, "Sent");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void Test010_DSM_Email_AccountSettings() throws Exception {
		System.out.println("Test010");


		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmailPage.class);
			CommonUtil.waitForPageToLoad();

			// Test DSM Email - Account Settings functionalities
			DSMEmailPage.Test_DSM_Email_AccountSettings(excelFilePath, "Account Settings");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void Test011_DSM_Email_NotificationSettings() throws Exception {
		System.out.println("Test011");


		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmailPage.class);
			CommonUtil.waitForPageToLoad();

			// Test DSM Email - Notification Settings functionalities
			DSMEmailPage.Test_DSM_Email_NotificationSettings(excelFilePath, "Notification Settings");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	@Test
	public void Test012_DSM_Email_ApplicationSettings() throws Exception {
		System.out.println("Test012");


		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmailPage.class);
			CommonUtil.waitForPageToLoad();

			// Test DSM Email - Application Settings functionalities
			DSMEmailPage.Test_DSM_Email_ApplicationSettings(excelFilePath, "Application Settings");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

//	@Test
//	public void Test34_DSM_Email_AutomaticReplies() throws Exception {
//		System.out.println("Test013");
//
//
//		try {
//			Thread.sleep(200);
//
//			PageFactory.initElements(driver, DSMEmailPage.class);
//			CommonUtil.waitForPageToLoad();
//
//			// Test DSM Email - Automatic Replies functionalities
//			DSMEmailPage.Test_DSM_Email_AutomaticReplies(excelFilePath, "Application Settings");
//			Thread.sleep(1000);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}
//	}

	@Test
	public void Test013_DSM_Email_Feedback() throws Exception {
		System.out.println("Test014");


		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmailPage.class);
			CommonUtil.waitForPageToLoad();

			// Test DSM Email - Feedback functionalities
			DSMEmailPage.Test_DSM_Email_Feedback(excelFilePath, "Feedback");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	@Test
	public void Test014_DSM_Email_Reports() throws Exception {
		System.out.println("Test015");


		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmailPage.class);
			CommonUtil.waitForPageToLoad();

			// Test DSM Email - Reports functionalities
			DSMEmailPage.Test_DSM_Email_Reports(excelFilePath, "Reports");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void Test015_DSM_Email_Directory_Search_NonVA_Addresses() throws Exception {
		System.out.println("Test016");


		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, InternalDirectAddressesPage.class);
			CommonUtil.waitForPageToLoad();

			// Test DSM Email - Non VA Address functionalities
			InternalDirectAddressesPage.Test_DSM_Email_Directory_Search_NonVA_Addresses(excelFilePath, "Directory Search - Non VA Addr");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	@Test
	public void Test016_DSM_Email_Directory_Search_InternalVA_Addresses() throws Exception {
		System.out.println("Test016");


		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, ExternalDirectAddressesPage.class);
			CommonUtil.waitForPageToLoad();

			// Test DSM Email - Internal VA Address functionalities
			ExternalDirectAddressesPage.Test_DSM_Email_Directory_Search_InternalVA_Addresses(excelFilePath, "Directory Search - Int VA Addr");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	@Test
	public void Test016_DSM_Email_Directory_Search_Personal_Contacts() throws Exception {
		System.out.println("Test016");


		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, PersonalContactsPage.class);
			CommonUtil.waitForPageToLoad();

			// Test DSM Email - Personal Contacts functionalities
			PersonalContactsPage.Test_DSM_Email_Directory_Search_Personal_Contacts(excelFilePath, "Directory Search - Per Contacts");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	@Test
	public void Test017_DSM_Email_Admin_Reports() throws Exception {
		System.out.println("Test017");


		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, AdminReportsPage.class);
			CommonUtil.waitForPageToLoad();

			// Test DSM Email - Admin Reports functionalities
			AdminReportsPage.Test_DSM_Email_Admin_Reports(excelFilePath, "Admin - Reports");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void Test018_DSM_Email_Admin_Logs() throws Exception {
		System.out.println("Test017");

		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, AdminLogsPage.class);
			CommonUtil.waitForPageToLoad();

			// Test DSM Email - Admin Logs functionalities
			AdminLogsPage.Test_DSM_Email_Admin_Logs(excelFilePath, "Admin - Logs");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void Test019_DSM_Email_Admin_Manage_Users() throws Exception {
		System.out.println("Test018");

		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, AdminManageUsersPage.class);
			CommonUtil.waitForPageToLoad();

			// Test DSM Email - Admin Manage Users functionalities
			AdminManageUsersPage.Test_DSM_Email_Admin_Manage_Users(excelFilePath, "Admin - Manage Users");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ END ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
