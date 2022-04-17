import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.ThreadLocalRandom;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SeleniumTask {
    public static void main(String[] args) {
        String email1 = "pritty" + getRandom(100000000, 1000000000) +"@gmail.com";
        String password1 = "testyoyo";

        String email2 = "pritty" + getRandom(100000000, 1000000000) +"@gmail.com";
        String password2 = "testyoyo";
        System.out.println(email1);
        System.out.println(email2);

        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();

//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));


        register(driver, email1, password1);
        loginAndCheckout(driver, email1, password1);

        register(driver, email2, password2);
        loginAndCheckout(driver, email2, password2);


        driver.quit();
    }

    public static String getRandom(int min, int max) {
        return Integer.toString(ThreadLocalRandom.current().nextInt(min, max + 1));
    }

    public static void register(ChromeDriver driver, String email, String password) {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));

        driver.findElement(By.className("login")).click();

        driver.findElement(By.id("email_create")).sendKeys(email);

        driver.findElement(By.id("SubmitCreate")).click();
//        new WebDriverWait(driver, Duration.ofSeconds(3))
//                .until(dd -> dd.findElement(By.id("id_gender1")));
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("test");
        driver.findElement(By.id("customer_lastname")).sendKeys("yoyo");
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("company")).sendKeys("testing");
        driver.findElement(By.id("address1")).sendKeys("demo");
        driver.findElement(By.id("city")).sendKeys("atlia");

        WebElement selectElement1 = driver.findElement(By.id("id_state"));
        Select selectObject1 = new Select(selectElement1);
        selectObject1.selectByValue("6");
        driver.findElement(By.id("postcode")).sendKeys("34523");

        WebElement selectElement = driver.findElement(By.id("id_country"));
        Select selectObject = new Select(selectElement);
        selectObject.selectByValue("21");


        driver.findElement(By.id("phone_mobile")).sendKeys("136462465");
        driver.findElement(By.id("submitAccount")).click();
        driver.findElement(By.className("logout")).click();


    }
    public static void loginAndCheckout(ChromeDriver driver, String email, String password) {
        driver.get("http://automationpractice.com/index.php");

//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        driver.findElement(By.className("login")).click();

        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();

        String yoyo = "//*[@title='Casual Dresses']";
        driver.get(driver.findElement(By.xpath(yoyo)).getAttribute("href"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        driver.findElement(By.className("ajax_add_to_cart_button")).click();

        String yolo = "//*[@title='T-shirts']";
        driver.get(driver.findElement(By.xpath(yolo)).getAttribute("href"));
        driver.findElement(By.id("layered_id_attribute_group_14")).click();
        driver.findElement(By.id("color_2")).click();
        driver.findElement(By.id("add_to_cart")).findElement(By.name("Submit")).click();
        String yoyol = "//*[@title='Proceed to checkout']";
        driver.get(driver.findElement(By.xpath(yoyol)).getAttribute("href"));
        driver.findElement(By.className("standard-checkout")).click();
        driver.findElement(By.name("processAddress")).click();
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.name("processCarrier")).click();
        driver.findElement(By.className("cheque")).click();
        driver.findElement(By.id("cart_navigation")).findElement(By.className("button")).click();
        driver.findElement(By.className("logout")).click();

        System.out.println("hi");
    }
}
