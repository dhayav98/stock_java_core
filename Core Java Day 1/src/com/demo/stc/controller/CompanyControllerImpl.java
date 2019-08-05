package com.demo.stc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import com.demo.stc.model.Company;
import com.demo.stc.service.CompanyService;
import com.demo.stc.service.CompanyServiceImpl;

public class CompanyControllerImpl implements CompanyController {

	private CompanyService companyService = new CompanyServiceImpl();

	public Company insertCompany(Company company) throws SQLException, ClassNotFoundException {
		companyService.insertCompany(company);
		return company;
	}

	@Override
	public Company updateCompany(Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> getCompanyList() throws Exception {
		return companyService.getCompanyList();
	}

	// try
	public static void main(String[] args) {
		CompanyController controller = new CompanyControllerImpl();
		try {
			System.out.println(controller.getCompanyList());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}