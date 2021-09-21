package testCases;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


/**Number of rows and columns */
/*
@Test
public class Dynamic_Table {
    public void Number1() throws ParseException  {
        WebDriver wd;
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");
        wd= new ChromeDriver();
        wd.get("http://demo.guru99.com/test/web-table-element.php");
        //No.of Columns
        List<WebElement>  col = wd.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
        System.out.println("No of cols are : " +col.size());
        //No.of rows
        List<WebElement>   rows = wd.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
        System.out.println("No of rows are : " + rows.size());
        wd.close();
    }
}
*/

/**Getting all values in a specific row and obtaining specific data from row and column*/
/*
@Test
public class Dynamic_Table {
    public void Number2() throws ParseException {
        WebDriver wd;
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");
        wd= new ChromeDriver();
        wd.get("http://demo.guru99.com/test/web-table-element.php");
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement baseTable = wd.findElement(By.tagName("table"));

        //To find third row of table
        WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]"));
        String rowtext = tableRow.getText();
        System.out.println("Third row of table : "+rowtext);

        //to get 3rd row's 2nd column data
        WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]/td[2]"));
        String valueIneed = cellIneed.getText();
        System.out.println("Cell value is : " + valueIneed);
        wd.close();
    }
}
*/


/**Number of rows and columns also getting maximum current price {column 4} */
/*
@Test
public class Dynamic_Table {
    public void Number3() throws ParseException {
        WebDriver wd;
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");
        wd= new ChromeDriver();
        wd.get("http://demo.guru99.com/test/web-table-element.php");
        String max;
        double m=0,r=0;

        //No. of Columns
        List<WebElement> col = wd.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));
        System.out.println("Total No of columns are : " +col.size());
        //No.of rows
        List<WebElement> rows = wd.findElements(By.xpath (".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
        System.out.println("Total No of rows are : " + rows.size());
        for (int i =1;i<rows.size();i++)
        {
            max= wd.findElement(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr[" + (i+1)+ "]/td[4]")).getText();
            NumberFormat f =NumberFormat.getNumberInstance();
            Number num = f.parse(max);
            max = num.toString();
            m = Double.parseDouble(max);
            if(m>r)
            {
                r=m;
            }
        }
        System.out.println("Maximum current price is : "+ r);
    }
}
*/


/**Get all the values of a Dynamic Table */
/**Considering next table
        1   2   3
        4   5   6
        5   6
        6   7   8
        7
  */
@Test
public class Dynamic_Table {
    public void Number4() throws ParseException {
        WebDriver wd;
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("http://demo.guru99.com/test/table.html");
        //To locate table.
        WebElement mytable = wd.findElement(By.xpath("/html/body/table/tbody"));
        //To locate rows of table.
        List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
        //To calculate no of rows In table.
        int rows_count = rows_table.size();
        //Loop will execute till the last row of table.
        for (int row = 0; row < rows_count; row++) {
            //To locate columns(cells) of that specific row.
            List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
            //To calculate no of columns (cells). In that specific row.
            int columns_count = Columns_row.size();
            System.out.println("Number of cells In Row " + row + " are " + columns_count);
            //Loop will execute till the last cell of that specific row.
            for (int column = 0; column < columns_count; column++) {
                // To retrieve text from that specific cell.
                String celtext = Columns_row.get(column).getText();
                System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
            }
            System.out.println("-------------------------------------------------- ");
        }
    }
}