package ru.nsu.fit.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.nsu.fit.services.browser.Browser;
import ru.nsu.fit.services.browser.MainPageService;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Title("�������� ��������� ��������� �� ��������.")
public class BracketsTest {

    @Test()
    @Title("Brackets")
    @Description("������ ������� ��������� ���������� ��������� �������� � ��������� �����������.")
    @Severity(SeverityLevel.CRITICAL)
    @Features({"Keyboard", "Brackets"})
    public void SumThreeNumbers() {
        Browser b = MainPageService.start_test();
        MainPageService.makeScreen("Main screen");
        b.insert_value("(4 + 1) * 3 - 20 / (2 + 0.5 * 4) * 2");
        MainPageService.makeScreen("The expression is typed");
        b.klick_imitation(MainPageService.equalElement);
        MainPageService.makeScreen("Result");
        Assert.assertEquals(b.get_value(), "5");
    }
}
