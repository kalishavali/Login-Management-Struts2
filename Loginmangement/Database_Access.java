package Testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import oracle.jdbc.OracleTypes;

public class Database_Access {
	static final String DB_DRIVER="oracle.jdbc.driver.OracleDriver";
	static final String DB_URL="jdbc:oracle:thin:@10.138.134.107:1521:webdev";
	static final String USERNAME="apregs_admin";
	static final String PASSWORD="apregs_admin";
	public static void main(String[] args){
		Database_Access dbaccess=new Database_Access();
	}
	public static ArrayList getHeadings(String did,String mid,String pid){
		Connection connection=null;
		CallableStatement callablestatement=null;
		ArrayList DataList=new ArrayList();
		try{
			Class.forName(DB_DRIVER);
			connection=DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			String plsql="{call HEAD_PCKG_DASHBOARD_AP.FormPonds(?,?,?,?)}";
			callablestatement=connection.prepareCall(plsql);
			callablestatement.setString(1, did);
			callablestatement.setString(2, mid);
			callablestatement.setString(3, pid);
			callablestatement.registerOutParameter(4,OracleTypes.CURSOR);
			callablestatement.executeQuery();
			ResultSet rs=(ResultSet)callablestatement.getObject(4);
			
			
			ResultSetMetaData rsMetaData=rs.getMetaData();
		    int columnCount=rsMetaData.getColumnCount();
		    DecimalFormat frmt = new DecimalFormat("########,##,##,##0.00 ");
		    DecimalFormat frmt1 = new DecimalFormat("########,##,##,###");
			while(rs.next()){
	              ArrayList alist=new ArrayList();
	              for(int loopCount=1;loopCount<=columnCount;loopCount++)
	              {
		              if(rsMetaData.getColumnTypeName(loopCount).equalsIgnoreCase("Decimal"))
		              {
		                 alist.add(frmt.format(rs.getFloat(loopCount)));
		              }
		              else if(rsMetaData.getColumnTypeName(loopCount).equalsIgnoreCase("float"))
		              {
		                 alist.add(frmt.format(rs.getFloat(loopCount)));
		              } 
		              else  if(rsMetaData.getColumnTypeName(loopCount).equalsIgnoreCase("double"))
		              {
		                 alist.add(frmt.format(rs.getFloat(loopCount)));
		              }
		              else if(rsMetaData.getColumnType(loopCount)==Types.NUMERIC){
		            	  if(rs!=null && rs.getString(loopCount).startsWith(".")) {
		            		  alist.add("0"+rs.getString(loopCount));
		            	  }
		            	  else {
		            		  alist.add(rs.getString(loopCount));
		            	  }
		              }
		              else if(rsMetaData.getColumnType(loopCount)==Types.INTEGER||rsMetaData.getColumnType(loopCount)==Types.BIGINT)
		              {
		                 alist.add(frmt1.format(rs.getInt(loopCount)));
		              }
		              else if(rsMetaData.getColumnType(loopCount)==Types.BLOB||rsMetaData.getColumnType(loopCount)==Types.BLOB)
		              {
		            	  /*Blob blob =lrs.getBlob(loopCount);
		            	  byte[] bdata = blob.getBytes(1, (int) blob.length());
		            	  alist.add(new String(bdata));*/
		            	  /*Blob blob = lrs.getBlob(loopCount); //blob of image from db
		            	  StringBuffer strOut = new StringBuffer();
		                  String aux;
		                  BufferedReader br;

		                  br = new BufferedReader(new InputStreamReader(blob.getBinaryStream()));
		                  while ((aux=br.readLine())!=null) {
		                      strOut.append(aux);
		                  }
		                  String offerPicStr = strOut.toString();
		                  alist.add(offerPicStr);*/
		            	  InputStream  is= rs.getBinaryStream(loopCount);
		            	  BufferedReader br = null;
			          		StringBuilder sb = new StringBuilder();
		
			          		String line;
			          		try {
		
			          			br = new BufferedReader(new InputStreamReader(is));
			          			while ((line = br.readLine()) != null) {
			          				sb.append(line);
			          			}
		
			          		} catch (IOException e) {
			          			e.printStackTrace();
			          		} finally {
			          			if (br != null) {
			          				try {
			          					br.close();
			          				} catch (IOException e) {
			          					e.printStackTrace();
			          				}
			          			}
			          		}
			          		alist.add(sb.toString());
		              }
		              
		              else
		              {
		            	  
		                 alist.add(rs.getString(loopCount));
		              }
		               
	              }      
	              DataList.add(alist);
	           }
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(callablestatement!=null){
					callablestatement.close();
				}
			}catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
			try{
				if(connection!=null){
					connection.close();
				}
			}catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
		}
		ArrayList dlistnew = new ArrayList();
		ArrayList<ArrayList<String>> dlistfinal2 = new ArrayList<ArrayList<String>>();
		ArrayList dlistfinal = new ArrayList();
		dlistnew = (ArrayList) DataList.get(0);
		for (int i = 0; i < dlistnew.size(); i++) {
			if (!dlistnew.get(i).equals("$")) {
				dlistfinal.add((String) dlistnew.get(i));
			} else{
				dlistfinal2.add(dlistfinal);
				dlistfinal = new ArrayList<String>();
			}
		}
		return dlistfinal2;
		
	}
	public static ArrayList getDataList(String did,String mid,String pid){

		Connection connection=null;
		CallableStatement callablestatement=null;
		ArrayList DataList=new ArrayList();
		try{
			Class.forName(DB_DRIVER);
			connection=DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			String plsql="{call spl_cs_report.SPL_CS_FARMPOND(?,?,?,?)}";
			callablestatement=connection.prepareCall(plsql);
			callablestatement.setString(1, did);
			callablestatement.setString(2, mid);
			callablestatement.setString(3, pid);
			callablestatement.registerOutParameter(4,OracleTypes.CURSOR);
			callablestatement.executeQuery();
			ResultSet rs=(ResultSet)callablestatement.getObject(4);
			
			
			ResultSetMetaData rsMetaData=rs.getMetaData();
		    int columnCount=rsMetaData.getColumnCount();
		    DecimalFormat frmt = new DecimalFormat("########,##,##,##0.00 ");
		    DecimalFormat frmt1 = new DecimalFormat("########,##,##,###");
			while(rs.next()){
	              ArrayList alist=new ArrayList();
	              for(int loopCount=1;loopCount<=columnCount;loopCount++)
	              {
		              if(rsMetaData.getColumnTypeName(loopCount).equalsIgnoreCase("Decimal"))
		              {
		                 alist.add(frmt.format(rs.getFloat(loopCount)));
		              }
		              else if(rsMetaData.getColumnTypeName(loopCount).equalsIgnoreCase("float"))
		              {
		                 alist.add(frmt.format(rs.getFloat(loopCount)));
		              } 
		              else  if(rsMetaData.getColumnTypeName(loopCount).equalsIgnoreCase("double"))
		              {
		                 alist.add(frmt.format(rs.getFloat(loopCount)));
		              }
		              else if(rsMetaData.getColumnType(loopCount)==Types.NUMERIC){
		            	  if(rs!=null && rs.getString(loopCount).startsWith(".")) {
		            		  alist.add("0"+rs.getString(loopCount));
		            	  }
		            	  else {
		            		  alist.add(rs.getString(loopCount));
		            	  }
		              }
		              else if(rsMetaData.getColumnType(loopCount)==Types.INTEGER||rsMetaData.getColumnType(loopCount)==Types.BIGINT)
		              {
		                 alist.add(frmt1.format(rs.getInt(loopCount)));
		              }
		              else if(rsMetaData.getColumnType(loopCount)==Types.BLOB||rsMetaData.getColumnType(loopCount)==Types.BLOB)
		              {
		            	  /*Blob blob =lrs.getBlob(loopCount);
		            	  byte[] bdata = blob.getBytes(1, (int) blob.length());
		            	  alist.add(new String(bdata));*/
		            	  /*Blob blob = lrs.getBlob(loopCount); //blob of image from db
		            	  StringBuffer strOut = new StringBuffer();
		                  String aux;
		                  BufferedReader br;

		                  br = new BufferedReader(new InputStreamReader(blob.getBinaryStream()));
		                  while ((aux=br.readLine())!=null) {
		                      strOut.append(aux);
		                  }
		                  String offerPicStr = strOut.toString();
		                  alist.add(offerPicStr);*/
		            	  InputStream  is= rs.getBinaryStream(loopCount);
		            	  BufferedReader br = null;
			          		StringBuilder sb = new StringBuilder();
		
			          		String line;
			          		try {
		
			          			br = new BufferedReader(new InputStreamReader(is));
			          			while ((line = br.readLine()) != null) {
			          				sb.append(line);
			          			}
		
			          		} catch (IOException e) {
			          			e.printStackTrace();
			          		} finally {
			          			if (br != null) {
			          				try {
			          					br.close();
			          				} catch (IOException e) {
			          					e.printStackTrace();
			          				}
			          			}
			          		}
			          		alist.add(sb.toString());
		              }
		              
		              else
		              {
		            	  
		                 alist.add(rs.getString(loopCount));
		              }
		               
	              }      
	              DataList.add(alist);
	           }
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(callablestatement!=null){
					callablestatement.close();
				}
			}catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
			try{
				if(connection!=null){
					connection.close();
				}
			}catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
		}
		return DataList;
		
	
	}
	public static ArrayList getCommonDataList(){
		ArrayList data=new ArrayList();
		data.add("2015-2016");
		data.add("02");
		data.add("February");
		data.add("State");
		data.add("Andhrapradesh");
		return data;
	}
	public static String getReportName() {
		return "R.3Daily Progress repot as Labour and Expenditure details";
	}
	public static ArrayList getId(String id) {
		ArrayList idList=new ArrayList();
		String subid=null;
		if(id.length()==2){
			idList.add(id);
		}
		if(id.length()==4){
			idList.add(id.substring(0,2));
			idList.add(id.substring(2));
		}
		if(id.length()==6){
			idList.add(id.substring(0,2));
			idList.add(id.substring(2,4));
			idList.add(id.substring(4));
		}
		if(id.length()>=8){
			idList.add(id.substring(0,2));
			idList.add(id.substring(2,4));
			idList.add(id.substring(4,6));
			idList.add(id.substring(6));
		}
		return idList;
	}
	public static Map<String,String> getDbDistricts(String state){
		Map<String,String> dbDistricts=new HashMap<String,String>();
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.138.134.107:1521:webdev","apregs_admin","apregs_admin");
    	PreparedStatement pre=con.prepareStatement("SELECT district_id,district_description district_description ,region_code from new_District_Master d where  d.flag='Y' and d.state_code=? and d.district_id<>'00' order by district_description");
        pre.setString(1, state);
        ResultSet res=pre.executeQuery();
        while(res.next()){
        	dbDistricts.put(res.getString("district_id"),res.getString("district_description"));
        }
	}
	catch(Exception e){
		System.out.println(e);
	}
	return dbDistricts;
	}
	public static Map<String,String> getDbMandals(String state,String district){
		Map<String,String> dbDistricts=new HashMap<String,String>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.138.134.107:1521:webdev","apregs_admin","apregs_admin");
	    	PreparedStatement pre=con.prepareStatement("SELECT mandal_id,mandal_description mandal_description from new_Mandal_Master m where m.district_id=?  and m.state_code=? order by mandal_description");
	        pre.setString(1, district);
	        pre.setString(2, state);
	        ResultSet res=pre.executeQuery();
	        while(res.next()){
	        	dbDistricts.put(res.getString("mandal_id"),res.getString("mandal_description"));
	        }
	}
	catch(Exception e){
		System.out.println(e);
	}
		return dbDistricts;
	}
	public static Map<String,String> getPanchayats(String state,String district,String mandal){
		Map<String,String> dbDistricts=new HashMap<String,String>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.138.134.107:1521:webdev","apregs_admin","apregs_admin");
	    	PreparedStatement pre=con.prepareStatement("SELECT panchayat_code,panchayat_name panchayat_name ,panchayat_head from new_Panchayat_Master p where p.mandal_code =? and p.district_code=? and p.state_code=? order by panchayat_name");
	        pre.setString(1, mandal);
	        pre.setString(2, district);
	        pre.setString(3, state);
	        ResultSet res=pre.executeQuery();
	        while(res.next()){
	        	dbDistricts.put(res.getString("panchayat_code"),res.getString("panchayat_name"));
	        }
	}
	catch(Exception e){
		System.out.println(e);
	}
		return dbDistricts;
	}
	public static Map<String,String> getVillages(String state,String district,String mandal,String panchayat){
		Map<String,String> dbDistricts=new HashMap<String,String>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.138.134.107:1521:webdev","apregs_admin","apregs_admin");
	    	PreparedStatement pre=con.prepareStatement("SELECT village_code,village_name village_name from new_Village_Master where panchayat_code=? and mandal_code =? and district_code=? and state_code=? order by village_name");
	        pre.setString(1, panchayat);
	        pre.setString(2, mandal);
	        pre.setString(3, district);
	        pre.setString(4, state);
	        ResultSet res=pre.executeQuery();
	        while(res.next()){
	        	dbDistricts.put(res.getString("village_code"),res.getString("village_name"));
	        }
	}
	catch(Exception e){
		System.out.println(e);
	}
		return dbDistricts;
	}
}
