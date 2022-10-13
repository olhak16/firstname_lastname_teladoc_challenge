package teladoc.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticePage extends BasePage {

    @FindBy(xpath = "//button[@type='add']")
    public WebElement addUserBtn;

    //to verify that new window pops up - //h3[.='Add User']
    @FindBy(xpath = "//h3[.='Add User']")
    public WebElement titleInNewWindow;


    @FindBy(xpath = "//input[@name='FirstName']")
    public WebElement firstNameField;

    @FindBy(xpath = "//input[@name='LastName']")
    public WebElement lastNameField;

    @FindBy(xpath = "//input[@name='UserName']")
    public WebElement userNameField;

    @FindBy(xpath = "//input[@name='Password']")
    public WebElement passwordField;

    @FindBy(name = "RoleId")
    public WebElement selectRoleDropDown;

    @FindBy(xpath = "//input[@name='Email']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@name='Mobilephone']")
    public WebElement phoneNumberField;

    @FindBy(xpath = "//button[.='Save']")
    public WebElement saveBtn;

    //to verify data has been saved to the table - //tbody/tr/td[.='affs']
    @FindBy(xpath = "//tbody/tr/td[1]")
    public WebElement userInfo;


    //locate novak user
    @FindBy(xpath = "//tbody/tr/td[.='novak']/following-sibling::td/button/i[@class='icon icon-remove']")
    public WebElement novakUser;

    //new window
    @FindBy(xpath = "//div/button[.='OK']")
    public WebElement OKBtn;
}
