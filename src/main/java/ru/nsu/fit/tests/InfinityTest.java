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

@Title("������ ���������� ���������� � ��������������.")
public class InfinityTest {

    @Test()
    @Title("Calculat Infinyty expression")
    @Description("��������� � �������� ��������������. ��������� � ���������� NaN.")
    @Severity(SeverityLevel.NORMAL)
    @Features({"Keyboard", "Addition", "Power", "Infinity"})
    public void CalcInfinity() {
        Browser b = MainPageService.start_test();
        MainPageService.makeScreen("Main screen");
        b.insert_value("Infinity * - Infinity");
        MainPageService.makeScreen("The expression is typed");
        b.klick_imitation(MainPageService.equalElement);
        MainPageService.makeScreen("Result1");
        Assert.assertEquals(b.get_value(), "-Infinity");
        b.insert_value("+Infinity");
        b.klick_imitation(MainPageService.equalElement);
        MainPageService.makeScreen("Result2");
        Assert.assertEquals(b.get_value(), "NaN");
    }
}