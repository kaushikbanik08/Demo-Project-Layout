package POCPackage.javaServiceDemo;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.ArrayList;
// --- <<IS-END-IMPORTS>> ---

public final class javaServiceWithSource

{
	// ---( internal utility methods )---

	final static javaServiceWithSource _instance = new javaServiceWithSource();

	static javaServiceWithSource _newInstance() { return new javaServiceWithSource(); }

	static javaServiceWithSource _cast(Object o) { return (javaServiceWithSource)o; }

	// ---( server methods )---




	public static final void addNum (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(addNum)>> ---
		// @sigtype java 3.5
		// [i] field:0:required num1
		// [i] field:0:required num2
		// [o] field:0:required addRes
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	num1 = IDataUtil.getString( pipelineCursor, "num1" );
			String	num2 = IDataUtil.getString( pipelineCursor, "num2" );
		pipelineCursor.destroy();
		
		int temp=Integer.valueOf(num1)+Integer.valueOf(num2);
		temp=temp+1;
		int addRes=temp-2;
		IDataUtil.remove(pipelineCursor, num1);
		IDataUtil.remove(pipelineCursor, num2);
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "addRes", String.valueOf(addRes) );
		pipelineCursor_1.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void addNumList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(addNumList)>> ---
		// @sigtype java 3.5
		// [i] record:1:required inputDocList
		// [i] - field:0:required str
		// [i] - field:0:required add
		// [o] record:1:required outputDocList
		// [o] - field:0:required result
		// pipeline
		strList.clear();
		outList.clear();
		addList.clear();
		IDataCursor pipelineCursor = pipeline.getCursor();
		
			// inputDocList
			IData[]	inputDocList = IDataUtil.getIDataArray( pipelineCursor, "inputDocList" );
			if ( inputDocList != null)
			{
				for ( int i = 0; i < inputDocList.length; i++ )
				{
					IDataCursor inputDocListCursor = inputDocList[i].getCursor();
						strList.add(IDataUtil.getString( inputDocListCursor, "str" ));
						addList.add(IDataUtil.getString( inputDocListCursor, "add" ));
					inputDocListCursor.destroy();
				}
			}
		pipelineCursor.destroy();
		
		for(int i=0;i<strList.size();i++){
			outList.add(strList.get(i)+addList.get(i));
		}
		
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		
		// outputDocList
		IData[]	outputDocList = new IData[outList.size()];
		for(int j=0;j<outList.size();j++){
			outputDocList[j] = IDataFactory.create();
			IDataCursor outputDocListCursor = outputDocList[j].getCursor();
			IDataUtil.put( outputDocListCursor, "result", outList.get(j));
			outputDocListCursor.destroy();
		}
		IDataUtil.put( pipelineCursor_1, "outputDocList", outputDocList );
		pipelineCursor_1.destroy();
			
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	static ArrayList <String> strList=new ArrayList<String>();
	static ArrayList <String> addList=new ArrayList<String>();
	static ArrayList <String> outList=new ArrayList<String>();
	// --- <<IS-END-SHARED>> ---
}

