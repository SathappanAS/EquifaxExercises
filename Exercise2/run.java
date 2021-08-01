

import java.util.ArrayList;
import static io.restassured.RestAssured.*;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import org.json.JSONObject;
import org.json.JSONArray;


public class run {

   final static String getAllEmployeesEndpoint="http://dummy.restapiexample.com/api/v1/employees";
   final static String deleteAnEmployeeEndpoint="http://dummy.restapiexample.com/api/v1/delete";
   final static String getSingleEmployeeEndpoint="http://dummy.restapiexample.com/api/v1/employee";

   public static void main(String args[]) {
	   
	   getAllEmployeesStatusCode();
	   deleteAnEmployeeStatusCode(2);
	   getSpecificEmployeeDetail(1);
	   deleteSpecificEmployeeData(1);

; }
   
   public static void getAllEmployeesStatusCode() {
	   
	   int statusCode = given().when().get(getAllEmployeesEndpoint).statusCode();
	   assert(statusCode != 200);
	   
   }
   
   public static void deleteAnEmployeeStatusCode(int employeeId) {
	   
	   int statusCode = given().when().get(deleteAnEmployeeEndpoint+"/"+employeeId).statusCode();
	   assert(statusCode != 200);  
   }
   
   public static void getSpecificEmployeeDetail(int employeeId) {
	   
	   String employeeData = given().when().get(getSingleEmployeeEndpoint+"/"+employeeId).asPrettyString();
	   System.out.print(employeeData);
   }
   
   public static void deleteSpecificEmployeeData(int employeeId) {
	   
	   String deleteResponse = given().when().get(getSingleEmployeeEndpoint+"/"+employeeId).asPrettyString();
	   System.out.print(deleteResponse);

    }
}
