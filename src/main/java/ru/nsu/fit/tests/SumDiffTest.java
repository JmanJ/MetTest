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

@Title("�������� ������ ������ � ������� ���������� ��������� �������� � ��������� �������� ���������� ����� � " +
        "��������� ������.")
public class SumDiffTest {

    @Test()
    @Title("Summ")
    @Description("���������� 3 ����� �����. ����� �������������� � ������� ������ ����������.")
    @Severity(SeverityLevel.CRITICAL)
    @Features({"UI feature", "Addition "})
    public void SumThreeNumbers() {
        Browser b = MainPageService.start_test();
        MainPageService.makeScreen("Main screen");
        b.klick_imitation(MainPageService.oneElement);
        b.klick_imitation(MainPageService.plusElement);
        b.klick_imitation(MainPageService.threeElement);
        b.klick_imitation(MainPageService.plusElement);
        b.klick_imitation(MainPageService.fiveElement);
        MainPageService.makeScreen("The expression is typed");
        b.klick_imitation(MainPageService.equalElement);
        MainPageService.makeScreen("Result");
        Assert.assertEquals(b.get_value(), "9");
    }

    @Test()
    @Title("Diff")
    @Description("�������� 3 ����� �����. ����� �������������� � ������� ������ ����������.")
    @Severity(SeverityLevel.CRITICAL)
    @Features({"UI feature", "Subtraction"})
    public void SubsThreeNumbers() {
        Browser b = MainPageService.start_test();
        MainPageService.makeScreen("Main screen");
        b.klick_imitation(MainPageService.nineElement);
        b.klick_imitation(MainPageService.minusElement);
        b.klick_imitation(MainPageService.oneElement);
        b.klick_imitation(MainPageService.minusElement);
        b.klick_imitation(MainPageService.threeElement);
        b.klick_imitation(MainPageService.minusElement);
        b.klick_imitation(MainPageService.fiveElement);
        MainPageService.makeScreen("The expression is typed");
        b.klick_imitation(MainPageService.equalElement);
        MainPageService.makeScreen("Result");
        Assert.assertEquals(b.get_value(), "0");
    }
}