package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonLeadfunctions extends BaseClass{
	
	String leadId1;

	@Given("enter username as {string}")
	public void enterUsername(String Uname) {
		driver.findElement(By.id("username")).sendKeys(Uname);
	}

	@Given("enter password as {string}")
	public void enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("click on login button")
	public void clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	@When("click on CRM\\/FSA")
	public void clickCRMFSA() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@When("click on Leads")
	public void clickLeads() {
		driver.findElement(By.linkText("Leads")).click();
	}

	@When("click on Create Leads")
	public void clickCreateLeads() {
		driver.findElement(By.linkText("Create Lead")).click();
	}

	@Given("company name as {string}")
	public void companyName(String cname) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
	}

	@Given("first name as {string}")
	public void firstName(String fName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
	}

	@Given("last name as {string}")
	public void lastName(String lName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
	}

	@When("click on submit")
	public void clickOnSubmit() {
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
	}

	@Then("confirm title")
	public void confirmTitle() {
		String title = driver.getTitle();
		if(title.contains("View Lead")) {
			System.out.println(title+" - contains View Lead");
		}else {
			System.out.println(title+" - does not conatins View Lead");
		}
	}
	
	@When("click on find Leads menu")
	public void clickFindLeadsMenu() {
		driver.findElement(By.linkText("Find Leads")).click();
	}

	@Given("enter name as {string}")
	public void enterName(String name) {
		driver.findElement(By.xpath("(//div[@class='x-form-element']/input[@name='firstName'])[3]")).sendKeys(name);
	}

	@When("click on find leads")
	public void clicFfindLeads() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
	}

	@When("select first search result")
	public void selectFirstSearchResult() {
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a[@class='linktext']")).click();
	}

	@When("click on edit button")
	public void clickEditButton() {
		driver.findElement(By.linkText("Edit")).click();
	}

	@Given("enter company new name as {string}")
	public void enterCompanyName(String cName) {
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cName);
	}

	@Then("verify the updated Company name as {string}")
	public void verifyUpdatedCompanyName(String cName) {
		String companyname = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if(companyname.contains(cName)) {
			System.out.println("company name updated");
		}else {
			System.out.println("company name is not updated");
		}
	}

	@When("click on dupicate lead")
	public void clickDuplicatLead() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}
	
	@Then("verify title of duplicate lead page")
	public void VerifyDuplicateLeadTitle() {
		String title = driver.getTitle();
		if(title.contains("Duplicate Lead")) {
			System.out.println("correct page - "+title);
		}else {
			System.out.println("wrong page - "+title);
		}
	}	
		
		@Then("verify Dulicate lead name {string}")
		public void verifyDuplicateLeadName(String lName){
			String name1 = driver.findElement(By.id("viewLead_firstName_sp")).getText();
			System.out.println(name1);
			if(lName.contains(name1)) {
				System.out.println("yes "+lName+ " is duplicate lead");
			}else {
				System.out.println(lName+" is not duplicate lead");
			}
		}
		
		@When("click on Merge lead menu")
		public void clickMergeLeadMenu() {
			driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();
		}

		@Given("first Lead Name {string}")
		public void firstLeadNameSelect(String fLName) throws InterruptedException {
			driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::a[1]")).click();		
			Set<String> windowHandles1 = driver.getWindowHandles();
			List<String> window1 = new ArrayList<String>(windowHandles1);		
			driver.switchTo().window(window1.get(1));
			driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fLName);
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();		
			driver.switchTo().window(window1.get(0));
		}
		
		@Given("Second Lead Name {string}")
		public void SecondLeadNameSelect(String sLName) throws InterruptedException {
			driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::a[2]")).click();
			Set<String> windowHandles2 = driver.getWindowHandles();
			List<String> window2 = new ArrayList<String>(windowHandles2);		
			driver.switchTo().window(window2.get(1));
			driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(sLName);
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
			driver.switchTo().window(window2.get(0));
		}

		@When("cick on Merge button")
		public void cickMergeButton() {
			driver.findElement(By.linkText("Merge")).click();
			driver.switchTo().alert().accept();
		}

		@Then("verify Merge page title")
		public void verifyMergePageTitle() {
			String title = driver.getTitle();
			if(title.contains("View Contact | opentaps CRM")) {
				System.out.println("title verified successfully");
			}else {
				System.out.println("wrong page");
			}
		}
		
		@When("store Resultant searched first lead id and click lead link")
		public void store_resultant_searched_first_lead_id_and_clickLink() {
			leadId1 = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]")).getText();
			System.out.println("lead 1 id "+leadId1);
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]//a[@class='linktext']")).click();
		}
		
		@When("pass stored id to inputtext")
		public void pass_stored_id_to_inputtext() {
			driver.findElement(By.name("id")).sendKeys(leadId1);
		}

		@When("click delete button")
		public void clickDeleteButton() {
			driver.findElement(By.linkText("Delete")).click();
		}

		@Then("verify no records message")
		public void verifyNorecordsMessage() {
			String tableInfo = driver.findElement(By.className("x-paging-info")).getText();
			if(tableInfo.contains("No records to display") == true) {
				System.out.println("data does not exist");			
			}else {
				System.out.println("data exist");
			}
		}
	}


