package api.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "Data")
    public String[][] getAllData() throws IOException {
        String path = System.getProperty("C:\\Users\\farha\\IdeaProjects\\RestAssured_Api\\testData\\Userdata.xlsx");
        ExcelUtils xl = new ExcelUtils(path);

        int rownum = xl.getRowCount("user");
        int colnum = xl.getCellCount("user",1);

        String apidata[][]=new String[rownum][colnum];

        for(int i=1;i<rownum;i++)
        {
            for(int j=0;j<colnum;j++)
            {
                apidata[i-1][j]=xl.getCellData("user",i,j);
            }
        }
        return apidata;
    }

    @DataProvider(name = "UserNames")
    public String[] getUserName() throws IOException {
        String path = System.getProperty("user.dir")+"//testData//Userdata.xlsx";
        ExcelUtils xl = new ExcelUtils(path);

        int rownum = xl.getRowCount("user");

        String apidata[]=new String[rownum];
            for(int i=0;i<rownum;i++)
            {
                apidata[i-1]=xl.getCellData("user",i,1);
            }
            return apidata;
    }

}
