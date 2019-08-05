package com.demo.stc.dao;


import java.sql.SQLException;

import com.demo.stc.model.Company;

public interface CompanyDao {
	public Company insertCompany(Company company)throws ClassNotFoundException, SQLException;
    public Company updateCompany(Company company)throws ClassNotFoundException, SQLException;
}
