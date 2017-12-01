package employeeapp;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/**
 * @author DaoNguyen
 */
public class CreateXMLFile {
    
    public static void insertEmployee(Document document, Element company, Employee employee){
        Element employeeElement = document.createElement("employee");
        Element id = document.createElement("id");
        Element fullName = document.createElement("fullName");
        Element address = document.createElement("address");
        Element salary = document.createElement("salary");
        Element department = document.createElement("department");
        Element departmentName = document.createElement("departmentName");
        Element mobile = document.createElement("mobile");
        
        Text txtId = document.createTextNode(employee.getId());
        Text txtFullName = document.createTextNode(employee.getFullName());
        Text txtAddress = document.createTextNode(employee.getAddress());
        Text txtSalary = document.createTextNode(employee.getSalary());
        Text txtDepartmentName = document.createTextNode(employee.getDepartmentName());
        Text txtMobile = document.createTextNode(employee.getMobile());
        
        company.appendChild(employeeElement);
        employeeElement.appendChild(id);
        employeeElement.appendChild(fullName);
        employeeElement.appendChild(address);
        employeeElement.appendChild(salary);
        employeeElement.appendChild(department);
        department.appendChild(departmentName);
        department.appendChild(mobile);
        
        id.appendChild(txtId);
        fullName.appendChild(txtFullName);
        address.appendChild(txtAddress);
        salary.appendChild(txtSalary);
        departmentName.appendChild(txtDepartmentName);
        mobile.appendChild(txtMobile);
    }
    
    public static void main(String[] args){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            Document doc = builder.newDocument();
            
            Element company = doc.createElement("company");
            Employee emp01 = new Employee("emp01", "Nguyen Van Teo", "Ho Chi Minh", "1500 USD", "Developer", "0901234567");
            Employee emp02 = new Employee("emp02", "Nguyen Thi Met", "Ha Noi", "1000 USD", "Designer", "0123456789");
        
            insertEmployee(doc, company, emp01);
            insertEmployee(doc, company, emp02);
            
            doc.appendChild(company);
            
            //write file
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("src/employeeapp/employee.xml");
            transformer.transform(source, result);
            
            System.out.println("Create file successfully");
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CreateXMLFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(CreateXMLFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(CreateXMLFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
