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

@Title("������ ���������� ��������� � ������� ����� ��������� ����������� ���� ��� �����.")
public class BigNumbersTest {

    @Test()
     @Title("Get big number")
     @Description("��������� �����, ������������ ��������� ����������� ���� ��� �����.")
     @Severity(SeverityLevel.NORMAL)
     @Features({"Keyboard", "BigNumbers", "Power"})
     public void CalcBigNumber() {
        Browser b = MainPageService.start_test();
        MainPageService.makeScreen("Main screen");
        b.insert_value("100000000000*100000000000");
        MainPageService.makeScreen("The expression is typed");
        b.klick_imitation(MainPageService.equalElement);
        MainPageService.makeScreen("Result");
        Assert.assertEquals(b.get_value(), "1e+22");
    }
    @Test()
    @Title("Div big number")
    @Description("������� �������� �����. ��������� ��������� � ���� ��� �����.")
    @Severity(SeverityLevel.NORMAL)
    @Features({"Keyboard", "BigNumbers", "Division"})
    public void DivBigNumber() {
        Browser b = MainPageService.start_test();
        MainPageService.makeScreen("Main screen");
        b.insert_value("1e+22/1000000000000");
        MainPageService.makeScreen("The expression is typed");
        b.klick_imitation(MainPageService.equalElement);
        MainPageService.makeScreen("Result");
    }
}
