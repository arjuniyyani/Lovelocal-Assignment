package utils;

import org.testng.annotations.DataProvider;

public class DataUtils {
    @DataProvider(name = "loginData")
    public Object[][] getDataFromExcel() {
        String excelPath = "/Users/arjunraju/IdeaProjects/Selenium/src/test/resources/testdata.xlsx";
        return ExcelUtils.getTestData(excelPath, "Sheet0");
    }
    @DataProvider(name = "MobileloginData")
    public Object[][] getMobileLoginData() {
        String excelPath = "/Users/arjunraju/IdeaProjects/Selenium/src/test/resources/testdata.xlsx";
        return ExcelUtils.getTestData(excelPath, "Sheet1");
    }
}
