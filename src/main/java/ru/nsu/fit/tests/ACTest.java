package ru.nsu.fit.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Title("Acceptance test")
public class ACTest extends MainPageTest {

    @Test()
    @Title("Calculate the sum of the two numbers")
    @Description("Check that Online Calculator right calculates sum of the two numbers (input case - keyboard)")
    @Severity(SeverityLevel.BLOCKER)
    @Features({"UI feature", "Addition"})
    public void testSum(){
        start_test();
        makeScreen("Main screen");
        insert_value("6 + 3");
        makeScreen("The expression is typed");
        klick_imitation();
        makeScreen("Result");
        Assert.assertEquals(get_value(), "9");
    }

    @Test()
    @Title("Calculate the multiplication of the two numbers")
    @Description("Check that Online Calculator right calculates multiplication of the two numbers (input case - keyboard)")
    @Severity(SeverityLevel.BLOCKER)
    @Features({"UI feature", "Multiplication"})
    public void testMul(){
        start_test();
        makeScreen("Main screen");
        insert_value("6 * 3");
        makeScreen("The expression is typed");
        klick_imitation();
        makeScreen("Result");
        Assert.assertEquals(get_value(), "18");
    }

    @Test()
    @Title("Calculate the subtraction of the two numbers")
    @Description("Check that Online Calculator right calculates subtraction of the two numbers (input case - keyboard)")
    @Severity(SeverityLevel.BLOCKER)
    @Features({"UI feature", "Subtraction"})
    public void testSub(){
        start_test();
        makeScreen("Main screen");
        insert_value("6 - 3");
        makeScreen("The expression is typed");
        klick_imitation();
        makeScreen("Result");
        Assert.assertEquals(get_value(), "3");
    }

    @Test()
    @Title("Calculate the division of the two numbers")
    @Description("Check that Online Calculator right calculates division of the two numbers (input case - keyboard)")
    @Severity(SeverityLevel.BLOCKER)
    @Features({"UI feature", "Division"})
    public void testDiv(){
        start_test();
        makeScreen("Main screen");
        insert_value("6 / 3");
        makeScreen("The expression is typed");
        klick_imitation();
        makeScreen("Result");
        Assert.assertEquals(get_value(), "2");
    }
}
