package com.grupo13.model;

import com.grupo13.mock.dto.DtoTestCase;
import com.grupo13.mock.dto.DtoTestSuite;
import com.grupo13.mock.idto.IDtoTest;



public class App {

	public static void main(String[] args) {
    	IDtoTest idtoTestCase1 = new DtoTestCase("TestCase1");
    	IDtoTest idtoTestCase2 = new DtoTestCase("TestCase2");
    	IDtoTest idtoTestCase3 = new DtoTestCase("TestCase3");
    	DtoTestSuite dtoTestSuite1 = new DtoTestSuite("MyTestSuite1");
    	
    	dtoTestSuite1.add(idtoTestCase1);
    	dtoTestSuite1.add(idtoTestCase2);
    	dtoTestSuite1.add(idtoTestCase3);
    	
    	DtoTestSuite dtoTestSuite2 = new DtoTestSuite("MyTestSuite2");
    	
    	dtoTestSuite1.add(dtoTestSuite2);
    	
    	IDtoTest idtoTestCase4 = new DtoTestCase("TestCase4");
    	IDtoTest idtoTestCase5 = new DtoTestCase("TestCase5");
    	IDtoTest idtoTestCase6 = new DtoTestCase("TestCase6");
    	IDtoTest idtoTestCase7 = new DtoTestCase("TestCase7");
    	IDtoTest idtoTestCase8 = new DtoTestCase("TestCase8");
    	IDtoTest idtoTestCase9 = new DtoTestCase("TestCase9");
    	
    	dtoTestSuite2.add(idtoTestCase4);
    	dtoTestSuite2.add(idtoTestCase5);
    	dtoTestSuite2.add(idtoTestCase6);
    	dtoTestSuite2.add(idtoTestCase7);
    	dtoTestSuite2.add(idtoTestCase8);
    	dtoTestSuite2.add(idtoTestCase9);
    	
    	DtoTestSuite dtoTestSuite3 = new DtoTestSuite("MyTestSuite3");
    	dtoTestSuite1.add(dtoTestSuite3);
 
    	IDtoTest idtoTestCase10 = new DtoTestCase("TestCase10");
    	IDtoTest idtoTestCase11 = new DtoTestCase("TestCase11");
    	IDtoTest idtoTestCase12 = new DtoTestCase("TestCase12");
    	
    	dtoTestSuite3.add(idtoTestCase10);
    	dtoTestSuite3.add(idtoTestCase11);
    	dtoTestSuite3.add(idtoTestCase12);
    	
    	
    	DtoTestSuite dtoTestSuite4 = new DtoTestSuite("MyTestSuite4");
    	dtoTestSuite3.add(dtoTestSuite4);
    	
    	IDtoTest idtoTestCase13 = new DtoTestCase("TestCase13");
    	IDtoTest idtoTestCase14 = new DtoTestCase("TestCase14");
    	
    	dtoTestSuite4.add(idtoTestCase13);
    	dtoTestSuite4.add(idtoTestCase14);
    	
    	DtoTestSuite dtoTestSuite5 = new DtoTestSuite("MyTestSuite5");
    	dtoTestSuite1.add(dtoTestSuite5);
    	
    	IDtoTest idtoTestCase15 = new DtoTestCase("TestCase15");
    	
    	dtoTestSuite5.add(idtoTestCase15);

    	
        System.out.println( dtoTestSuite1.getMessage("com") );

	}

}
