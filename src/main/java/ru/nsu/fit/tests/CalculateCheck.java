package ru.nsu.fit.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Title("Housewife counts the amount of the check")
public class CalculateCheck extends MainPageTest {

    @Test()
    @Title("Get total sum by product")
    @Description("Multiplies the number on the price. Price can be not an integer value (input case - keyboard)")
    @Severity(SeverityLevel.CRITICAL)
    @Features({"UI feature", "Multiplication "})
    public void calcSumByProduct() {
        start_test();
        makeScreen("Main screen");
        insert_value("6 * 305.43");
        makeScreen("The expression is typed");
        klick_imitation();
        makeScreen("Result");
        Assert.assertEquals(get_value(), "1832.58");
    }

    @Test(dependsOnMethods = "calcSumByProduct")
    @Title("Calculate the sum of the two prices of products")
    @Description("Check that Online Calculator right calculates sum of the two prices of products." +
            "It can be not an integer values (input case - keyboard)")
    @Severity(SeverityLevel.CRITICAL)
    @Features({"UI feature", "Addition"})
    public void calcTotalProductsSum() {
        start_test();
        makeScreen("Main screen");
        insert_value("1832.58 + 500");
        makeScreen("The expression is typed");
        klick_imitation();
        makeScreen("Result");
        Assert.assertEquals(get_value(), "2332.58");
    }
}
