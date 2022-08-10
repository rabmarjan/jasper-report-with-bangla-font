package com.javatechie.report.service;

import com.javatechie.report.entity.Employee;
import com.javatechie.report.repository.EmployeeRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private EmployeeRepository repository;


    public void exportReport(String reportFormat, OutputStream outputStream) throws FileNotFoundException, JRException {
        Path path = Paths.get("/home/marjan/Pictures");
        List<Employee> employees = repository.findAll();
        final InputStream stream = this.getClass().getResourceAsStream("/employees.jrxml");
        final JasperReport jasperReport = JasperCompileManager.compileReport(stream);
        //load file and compile it
       // File file = ResourceUtils.getFile("classpath:employees.jrxml");
       // JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Java Techie");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "/BanglaPdfReport.html");

        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
          //  JasperExportManager.exportReportToPdfFile(jasperPrint, path + "/BanglaPdfReport.pdf");
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        }

     //   return "report generated in path : " + path;
    }
}
