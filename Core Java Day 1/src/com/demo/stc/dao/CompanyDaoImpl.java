package com.demo.stc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.stc.model.Company;
import com.demo.stc.model.Sector;

public class CompanyDaoImpl implements CompanyDao{

	public static Connection connect() throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stock","root","root");
		System.out.println("connect");
		return con;  
	}

	public Company insertCompany(Company company)throws ClassNotFoundException, SQLException {
		Connection con=connect();
		PreparedStatement stmt=con.prepareStatement("Insert into company values(?,?,?,?,?,?,?,?)");
		stmt.setInt(1, company.getCompanyCode());
		stmt.setString(2, company.getCompanyName());
		stmt.setDouble(3, company.getTurnOver());
		stmt.setString(4, company.getCeo());
		stmt.setString(5, company.getBoardOfDirectors());
		stmt.setInt(6, company.getSectorId());
		stmt.setString(7, company.getBriefWriteUp());
		stmt.setInt(8, company.getStockCode());
		System.out.println(stmt.execute());

		return null;
	}

	public Company updateCompany(Company company)throws ClassNotFoundException, SQLException {
		Connection con=connect();
		PreparedStatement stmt=con.prepareStatement("UPDATE company SET company_name=?,turnover=?,ceo=?,boardofdirectors=?,sector_id=?,breifwriteup=?,stock_code=? where company_code=?");
		stmt.setString(1, company.getCompanyName());
		stmt.setDouble(2, company.getTurnOver());
		stmt.setString(3, company.getCeo());
		stmt.setString(4, company.getBoardOfDirectors());
		stmt.setInt(5, company.getSectorId());
		stmt.setString(6, company.getBriefWriteUp());
		stmt.setInt(7, company.getStockCode());
		stmt.setInt(8, company.getCompanyCode());
		
		System.out.println(stmt.execute());
		
		return null;
	}
	public List<Company> GetAllCompany() throws ClassNotFoundException, SQLException {
		Connection con=connect();
		PreparedStatement stmt=con.prepareStatement("Select * from company");
		ResultSet rs=stmt.executeQuery();
		List<Company> list=new ArrayList<Company>();
		while(rs.next()) 
		{
			Company comp=new Company();
			comp.setCompanyCode(rs.getInt(1));
			comp.setCompanyName(rs.getString(2));
			comp.setTurnOver(rs.getDouble(3));
			comp.setCeo(rs.getString(4));
			comp.setBoardOfDirectors(rs.getString(5));
			comp.setSectorId(rs.getInt(6));
			comp.setBriefWriteUp(rs.getString(7));
			comp.setStockCode(rs.getInt(8));
			list.add(comp);
		
		}
		return list;
	}
	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		Company company=new Company(1004, "insofys",232.23,"sdf","sdf",1,"sdf",343);
		CompanyDaoImpl cdi=new CompanyDaoImpl();
		cdi.insertCompany(company);
		Company company1=new Company(1005, "cts",232.23,"sdf","sdf",1,"sdf",343);
		cdi.updateCompany(company1);
		CompanyDaoImpl cdl=new CompanyDaoImpl();
		List<Company> list=cdl.GetAllCompany();
		for(Company c:list)
		{
			System.out.println(c);
		}
 	}
}
