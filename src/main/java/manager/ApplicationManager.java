package manager;

public class ApplicationManager {
    WebDriver wd;

    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro.web.app/login?url=%2Fsearch");
    }

    public void stop() {
        wd.quit();
    }
}
