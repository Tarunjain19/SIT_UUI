package flow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

import com.avaya.sce.runtime.tracking.TraceInfo;
import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;



/**
 * The Data class handles many types of server-side operations including data
 * collection (from a data sources such as a database, or web service), variable
 * assignments and operations (like copying variable values, performing mathematic
 * operations, and collection iteration), conditional evaluation to control callflow
 * execution based on variable values, and logging/tracing statements.
 * 
 * Items created in the getDataActions() method are executed/evaluated in order
 * and if a condional branch condition evaluates to "true" then the branch is
 * activated and the execution of data actions is halted.  If no "true" conditions
 * are encountered, then all data actions will be executed/evaluated and the 
 * application will proceed to the "Default" servlet.
 * Last generated by Orchestration Designer at: 2020-APR-15  02:26:11 PM
 */
public class Set_Data extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2020-APR-15  02:26:11 PM
	 */
	public Set_Data() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2020-APR-15  10:43:59 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("Transfer", "Default");
		next.setDebugId(26);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2020-APR-15  10:43:59 PM
	 */
	public java.util.Collection<VariableInfo> getLocalVariables(){
		java.util.Collection<VariableInfo> variables = new java.util.ArrayList<VariableInfo>();

		return variables;
	}
	/**
	 * Creates and conditionally executes operations that have been configured
	 * in the Callflow.  This method will build a collection of operations and
	 * have the framework execute the operations by calling evaluateActions().
	 * If the evaluation causes the framework to forward to a different servlet
	 * then execution stops.
	 * Returning true from this method means that the framework has forwarded the
	 * request to a different servlet.  Returning false means that the default
	 * Next will be invoked.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2020-APR-15  10:43:59 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.varoperations.PrepareAAI("Shared", "session:ucid", "", "", "Call_Data:UUI_DATA", "Call_Data:UUI_DATA").setDebugId(29));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	
	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		ITraceInfo trace=mySession.getTraceOutput();
		String CLASS_NAME = this.getName();
		
		try{
			
			String VDN="310101010003";
  	      String UUI="2|102|6|1|310101010003|9818556803|GOLD|1|0|Kumar Sundeep|Xiaomi RedmiNote5Pro|4gDATA|";
			
			String dtmf = mySession.getVariableField(IProjectVariables.PROMPT__COLLECT,IProjectVariables.PROMPT__COLLECT_FIELD_VALUE).getStringValue();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,CLASS_NAME+" DTMF is "+dtmf);
			
			
			
			String path = this.getClass().getClassLoader().getResource("").getPath();
			
			
			
			//System.out.println(this.getClass().getClassLoader().getResource("").getPath());
			
		//	String dir= this.getClass().getClassLoader().getResource("").getPath();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,CLASS_NAME+" path: "+path);
			
			String tomcatBase = System.getProperty("catalina.base");
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,CLASS_NAME+" tomcatBase: "+tomcatBase);
			
			String webApp = String.format("%s/webapps/SIT_UUI", tomcatBase);
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,CLASS_NAME+" webApp: "+webApp);
			
			
			String result ="";
			
			Properties prop =new Properties();
			
			
			
			String propFileName="IVRConfig.properties";
			
			 InputStream inputstream=new FileInputStream( webApp+"/data/IVRConfig.properties");
			
	     // InputStream inputstream=getClass().getClassLoader().getResourceAsStream(propFileName);
	      
	      trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,CLASS_NAME+"inputstream : "+inputstream);
	      
	      if(inputstream!=null)
	      {
	    	  trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,CLASS_NAME+"not null and load : "+inputstream);
	    	  prop.load(inputstream);
	    	  
	    	  
	    	  
	    	  if(dtmf.equalsIgnoreCase("1"))
	    	  {
	    	   VDN=prop.getProperty("1_VDN");
	    	   UUI =prop.getProperty("1");
	    	  }
	    	  else if(dtmf.equalsIgnoreCase("2"))
	    	  {
	    		   VDN=prop.getProperty("2_VDN");
		    	  UUI=prop.getProperty("2");
	    		  
	    	  }
	    	  else if(dtmf.equalsIgnoreCase("3"))
	    	  {
	    		  VDN=prop.getProperty("3_VDN");
		    	  UUI=prop.getProperty("3");
	    		  
	    	  }
	    	  else if(dtmf.equalsIgnoreCase("4"))
	    	  {
	    		   VDN=prop.getProperty("4_VDN");
		    	   UUI=prop.getProperty("4");
	    		  
	    	  }
	    	  else if(dtmf.equalsIgnoreCase("5"))
	    	  {
	    		   VDN=prop.getProperty("5_VDN");
		    	  UUI=prop.getProperty("5");
	    		  
	    	  }
	    	  else if(dtmf.equalsIgnoreCase("6"))
	    	  {
	    		  VDN=prop.getProperty("6_VDN");
		    	   UUI=prop.getProperty("6");
	    	  }
	    	  else
	    	  {
	    		  VDN="310101010003";
	    	      UUI="2|102|6|1|310101010003|9818556803|GOLD|1|0|Kumar Sundeep|Xiaomi RedmiNote5Pro|4gDATA|";
	    	  }
	    	  
	    	  trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,CLASS_NAME+"VDN is : "+VDN+" UUI :"+UUI);
	    	  
	    	  mySession.getVariableField(IProjectVariables.CALL__DATA, IProjectVariables.CALL__DATA_FIELD_TRANSFER__VDN).setValue(VDN);
	    	  mySession.getVariableField(IProjectVariables.CALL__DATA, IProjectVariables.CALL__DATA_FIELD_UUI__DATA).setValue(UUI);
	    	  
	      }
	      else
	      {
	    	  trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,CLASS_NAME+" in else: ");
	    	  throw new FileNotFoundException("File not found "+propFileName);
	      }
	      
			

			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,CLASS_NAME+" | ACTUAL MOBILE_NO: "+mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_ANI).getStringValue());
			
			
			/*String CLID = mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_ANI).getStringValue();
			
			String SIP_test = mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_MEDIATYPE).getStringValue();
			
			String SIP_test1 = mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_EXIT_INFO_1).getStringValue();
			
			String SIP_Info1 = mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_EXIT_INFO_1).getStringValue();
			String SIP_Info2 = mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_EXIT_INFO_2).getStringValue();
			String SIP_Customerid = mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_EXIT_CUSTOMER_ID).getStringValue();
			String SIP_parentid = mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_EXIT_PARENT_ID).getStringValue();
			
			//String SIP_Info1 = mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_EXIT_INFO_2).getStringValue();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,CLASS_NAME+" | SIP_Info1: "+SIP_Info1);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,CLASS_NAME+" | SIP_Info2: "+SIP_Info2);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,CLASS_NAME+" | SIP_Customerid: "+SIP_Customerid);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,CLASS_NAME+" | SIP_parentid: "+SIP_parentid);
			*/
		
			
			
			
		}catch(Exception e){
			TraceInfo.trace(ITraceInfo.TRACE_LEVEL_ERROR, "$$$$$$$$$$$$$$$$$$$$$ Getting exception in :: "+CLASS_NAME+":: "+e+"$$$$$$$$$$$$$$$$$$$$$ ", mySession);
        	e.printStackTrace();
		}	
	}
		
}
