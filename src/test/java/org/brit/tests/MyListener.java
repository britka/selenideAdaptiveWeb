package org.brit.tests;

import com.microsoft.playwright.Page;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.AllureResultsWriter;
import io.qameta.allure.Attachment;
import io.qameta.allure.listener.*;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.model.TestResult;
import io.qameta.allure.testng.AllureTestNg;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.brit.driver.PlayWrightDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.List;

@Slf4j
public class MyListener extends AllureTestNg {


    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult tr) {
      //  super.onTestFailure(tr);
        log.info(tr.getName() + " failed!!!");
        createScreenShot();
        // ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(createScreenShot());
        // Allure.addAttachment("My attachment", byteArrayInputStream);
        //   Allure.addAttachment("some.png", Base64.getEncoder().encodeToString(createScreenShot()));
    }

    @Attachment
    public byte[] createScreenShot() {
        log.info("Truing to make screenshot");
        return PlayWrightDriver.getInstance().getCurrentPage().screenshot(new Page.ScreenshotOptions().setFullPage(true));
    }



}
