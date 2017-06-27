package test.com.afinalstone.file; 

import com.afinalstone.file.FileDemo;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* FileDemo Tester. 
* 
* @author <Authors name> 
* @since <pre>六月 27, 2017</pre>
* @version 1.0 
*/ 
public class FileDemoTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: createFile() 
* 
*/ 
@Test
public void testCreateFile() throws Exception { 
    FileDemo.createFile();
} 


} 
