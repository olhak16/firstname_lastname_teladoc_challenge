package teladoc.step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import teladoc.pages.PracticePage;
import teladoc.utils.ConfigurationReader;
import teladoc.utils.Driver;

import java.util.List;

public class AddUserStepDefs {
    PracticePage practicePage = new PracticePage();
    Faker faker = new Faker();


    @Given("User is on the practice page")
    public void user_is_on_the_practice_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Assert.assertEquals(Driver.getDriver().getTitle().toString(), "Protractor practice website - WebTables");

    }
    @When("User clicks on Add User button")
    public void user_clicks_on_add_user_button() {
        practicePage.addUserBtn.click();

    }
    @Then("new window pops up and user has to input information")
    public void new_window_pops_up_and_user_has_to_input_information() {
        //to verify that new window pops up - //h3[.='Add User']
        Assert.assertTrue(practicePage.titleInNewWindow.isDisplayed());
    }
    @Then("User has to fill out First Name field")
    public void user_has_to_fill_out_first_name_field() {
        practicePage.firstNameField.sendKeys("Olha");

    }
    @Then("User has to fill out Last Name field")
    public void user_has_to_fill_out_last_name_field() {
        practicePage.lastNameField.sendKeys(faker.name().lastName());
    }
    @Then("User has to fill out User Name field")
    public void user_has_to_fill_out_user_name_field() {
        practicePage.userNameField.sendKeys(faker.name().username());
    }
    @Then("User has to fill out Password field")
    public void user_has_to_fill_out_password_field() {
        practicePage.passwordField.sendKeys(faker.code().asin());
    }
    @Then("User has to chose a role")
    public void user_has_to_chose_a_role() {
        Select select = new Select(practicePage.selectRoleDropDown);
        select.selectByVisibleText("Customer");
    }
    @Then("User needs to add email")
    public void user_needs_to_add_email() {
      practicePage.emailField.sendKeys(faker.name().firstName() + "@gmail.com");
    }
    @Then("User needs to add phone number and click Save button")
    public void user_needs_to_add_phone_number_and_click_save_button() {
       practicePage.phoneNumberField.sendKeys(faker.phoneNumber().cellPhone());
       new WebDriverWait(Driver.getDriver(),10);
       practicePage.saveBtn.click();
    }
    @Then("User should be able to see his info added to the list")
    public void user_should_be_able_to_see_his_info_added_to_the_list() {
       Assert.assertEquals(practicePage.userInfo.getText(), "Olha");
    }

    //2-nd scenario - delete "novak" user
    @Given("User locates novak user and clicks on remove icon")
    public void userLocatesNovakUserAndClicksOnRemoveIcon() {
        practicePage.novakUser.click();
    }


    @Then("new window pops up and User needs to click ok button")
    public void newWindowPopsUpAndUserNeedsToClickOkButton() {
        practicePage.OKBtn.click();
    }

    @Then("User can confirm that novak information has been deleted successfully")
    public void userCanConfirmThatNovakInformationHasBeenDeletedSuccessfully() {
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//tbody/tr"));
        for(WebElement element : list) {
            if(element.getText().equals("novak") || element.getText().equals("Novak")) {
                System.out.println("The user was not deleted!");
            } else {
                System.out.println("Novak user was successfully deleted!");

            }
        }
    }
}



