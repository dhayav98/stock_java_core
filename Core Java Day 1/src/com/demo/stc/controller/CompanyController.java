package com.demo.stc.controller;


import java.sql.SQLException;
import java.util.List;

import com.demo.stc.model.Company;

public interface CompanyController {

  	    public Company insertCompany(Company company) throws SQLException,ClassNotFoundException ;
	    public Company updateCompany(Company company);
		public List<Company> getCompanyList() throws Exception;

	
}