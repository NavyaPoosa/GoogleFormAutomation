package demo;

import java.time.LocalTime;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    /*
     * Navigate to the google form "https://forms.gle/wjPkzeSEk1CM7KgGA"
     * locate the name field using Xpath "//div[@class='rFrNMe k3kHxc RdH0ib yqQS1 zKHdkd']//div[@class='aCsJod oJeWuf']"
     * locate the why automation field using Xpath "//textarea[@aria-label='Your answer']"
     * select the radio button using the Xpath "//div[@id='i13']//div[@class='rseUEf nQOrEb']"
     * 
     
     */

    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://forms.gle/wjPkzeSEk1CM7KgGA");
        Thread.sleep(2000);

        WebElement nameField = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        nameField.sendKeys("Navya Poosa");
        nameField.sendKeys(Keys.TAB);
        Thread.sleep(1000);
       
        WebElement whyAutomation = driver.findElement(By.xpath("//textarea[@aria-label='Your answer']"));
        long epoch = System.currentTimeMillis()/1000;
        whyAutomation.sendKeys("I want to be the best QA Engineer!" + epoch);
        whyAutomation.sendKeys(Keys.TAB);
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("(//div[@class='AB7Lab Id5V1'])[1]"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        Thread.sleep(1000);
        
       
        WebElement checkbox1 = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[1]"));
        checkbox1.click();

        WebElement checkbox2 = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[2]"));
        checkbox2.click();
        
        WebElement checkbox3 = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[4]"));
        checkbox3.click();
       
        Thread.sleep(1000);

        WebElement dropDown = driver.findElement(By.xpath("//span[normalize-space()='Choose']"));
        dropDown.click();
       

        List<WebElement> options = driver.findElements(By.xpath("//div[@class='OA0qNb ncFHed QXL7Te']/div"));
        for(int i=0;i<options.size();i++){
            if(options.get(i).getText().contains("Ms")){
                options.get(i).click();
                Thread.sleep(2000);
                break;
            }
        }

        WebElement date = driver.findElement(By.xpath("//div[@class='rFrNMe yqQS1 hatWr zKHdkd']"));
        js.executeScript("arguments[0].scrollIntoView();", date);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys("04").perform();
        action.sendKeys("05").perform();
        action.sendKeys("2024").perform();

        LocalTime myObj = LocalTime.now();
        int hour= myObj.getHour();
        WebElement hourElement = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
        String h = String.valueOf(hour);
        hourElement.sendKeys(h);
        Thread.sleep(1000);

        int minute = myObj.getMinute();
        WebElement minuteElement = driver.findElement(By.xpath("//input[@aria-label='Minute']"));
        String m= String.valueOf(minute);
        minuteElement.sendKeys(m);
        minuteElement.sendKeys(Keys.TAB);
        Thread.sleep(2000);

        driver.navigate().to("https://www.amazon.in/");
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        WebElement submitButton = driver.findElement(By.xpath("//span[@class='NPEfkd RveJvd snByac' and text()='Submit']"));
        submitButton.click();
        Thread.sleep(2000);
        System.out.println("End Test case: testCase01");
        }
     }


