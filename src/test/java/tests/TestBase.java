package tests;

import manager.ApplicationManager;

public class TestBase {
    static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();

    }
}
