
package com.gallup.gethip.resources;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.Employee;
import com.j256.ormlite.dao.Dao;

// The Java class will be hosted at the URI path "/employee"
@Path("/employee")
public class EmployeeResource {

    // TODO: update the class to suit your needs
    
    // The Java method will process HTTP GET requests
    @GET 
    // The Java method will produce content identified by the MIME Media
    // type "application/json"
    @Produces("application/json")
    public Employee getIt(@QueryParam("empno") String empno) {
    	Employee emp = null;
    	try {
			emp = getDao().queryForId(empno);
			if(emp == null){
				throw new NullPointerException("Employee does not exist");
			}else{
				return emp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// throw error message
		}
    	return emp;
        
    }
    
    @DELETE
    @Produces("text/plain")
    public String deleteEmployee(@QueryParam("empno") String empno){
    	try {
			int num = getDao().deleteById(empno);
			if(num == 1){
				return "Delete successful";
			}else{
				return "Unable to delete";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error in sql statement";
		}
    }
    
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Employee createEmployee(Employee emp){
    	try {
			Employee empPrime = getDao().createIfNotExists(emp);
			if(empPrime == null){
				// handle error
			}else{
				return empPrime;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return  null;
    }
    
    @PUT
    @Produces("text/plain")
    @Consumes("application/json")
    public String updateEmployee(Employee emp){
    	try {
			int num = getDao().update(emp);
			if(num == 1){
				return "Update successful for employee " + emp.getEmpNo();
			}else{
				return "Could not update " + emp.getEmpNo();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error updating " + emp.getEmpNo();
		}
    }
    
    private Dao<Employee, String> getDao(){
    	Dao<Employee, String> dao = DataSourceManager.getInstance().getDao(Employee.class);
    	return dao;
    }
}
