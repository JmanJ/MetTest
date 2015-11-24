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

@Title("������ ��������� �������� ��������������� ��������� (� ������ � ������ �����).")
public class IrrationalNumberTest {

    @Test()
    @Title("Calculat irrational expression")
    @Description("������ ������� ��������� ���������� ��������� �������� � ��������� �����������. " +
            "��������� ����� � ��������� �������� ��������������� �������.")
    @Severity(SeverityLevel.CRITICAL)
    @Features({"Keyboard", "Addition", "Power", "Division", "Brackets"})
    public void CalcIrrational() {
        Browser b = MainPageService.start_test();
        MainPageService.makeScreen("Main screen");
        b.insert_value("(4.5 + 0.7) * 3.3 - 2.05 / (2.8 + 0.5 * 4.1) * 2.7");
        MainPageService.makeScreen("The expression is typed");
        b.klick_imitation(MainPageService.equalElement);
        MainPageService.makeScreen("Result");
        Assert.assertEquals(b.get_value(), "16.018762886597937");
    }
}