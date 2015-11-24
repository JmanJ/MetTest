package ru.nsu.fit.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.nsu.fit.services.browser.Browser;
import ru.nsu.fit.services.browser.MainPageService;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Title("Acceptance test")
public class ACTest{

    @Test()
    @Title("Calculate the sum of the two numbers")
    @Description("Check that Online Calculator right calculates sum of the two numbers (input case - keyboard)")
    @Severity(SeverityLevel.BLOCKER)
    @Features({"UI feature", "Addition"})
    public void testSum(){
        Browser b = MainPageService.start_test();
        MainPageService.makeScreen("Main screen");
        b.insert_value("6 + 3");
        MainPageService.makeScreen("The expression is typed");
        b.klick_imitation(MainPageService.equalElement);
        MainPageService.makeScreen("Result");
        Assert.assertEquals(b.get_value(), "9");
    }

    @Test()
    @Title("Calculate the multiplication of the two numbers")
    @Description("Check that Online Calculator right calculates multiplication of the two numbers (input case - keyboard)")
    @Severity(SeverityLevel.BLOCKER)
    @Features({"UI feature", "Multiplication"})
    public void testMul(){
        Browser b = MainPageService.start_test();
        MainPageService.makeScreen("Main screen");
        b.insert_value("6 * 3");
        MainPageService.makeScreen("The expression is typed");
        b.klick_imitation(MainPageService.equalElement);
        MainPageService.makeScreen("Result");
        Assert.assertEquals(b.get_value(), "18");
    }

    @Test()
    @Title("Calculate the subtraction of the two numbers")
    @Description("Check that Online Calculator right calculates subtraction of the two numbers (input case - keyboard)")
    @Severity(SeverityLevel.BLOCKER)
    @Features({"UI feature", "Subtraction"})
    public void testSub(){
        Browser b = MainPageService.start_test();
        MainPageService.makeScreen("Main screen");
        b.insert_value("6 - 3");
        MainPageService.makeScreen("The expression is typed");
        b.klick_imitation(MainPageService.equalElement);
        MainPageService.makeScreen("Result");
        Assert.assertEquals(b.get_value(), "3");
    }

    @Test()
    @Title("Calculate the division of the two numbers")
    @Description("Check that Online Calculator right calculates division of the two numbers (input case - keyboard)")
    @Severity(SeverityLevel.BLOCKER)
    @Features({"UI feature", "Division"})
    public void testDiv(){
        Browser b = MainPageService.start_test();
        MainPageService.makeScreen("Main screen");
        b.insert_value("6 / 3");
        MainPageService.makeScreen("The expression is typed");
        b.klick_imitation(MainPageService.equalElement);
        MainPageService.makeScreen("Result");
        Assert.assertEquals(b.get_value(), "2");
    }
}
