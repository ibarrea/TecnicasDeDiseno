package com.grupo13.model;

import com.grupo13.iview.IViewTestCase;
import com.grupo13.mock.dto.DtoTestCase;
import com.grupo13.mock.dto.DtoTestSuite;
import com.grupo13.mock.idto.IDtoTest;
import com.grupo13.view.ViewTestCase;



public class App {

	public static void main(String[] args) {
    	IDtoTest idtoTestCase1 = new DtoTestCase(false, false,  "TestCase1: FAIL");
    	IDtoTest idtoTestCase2 = new DtoTestCase(false, true, "TestCase2: OK");
    	IDtoTest idtoTestCase3 = new DtoTestCase(true, false,  "TestCase3: FAIL");
    	DtoTestSuite dtoTestSuite1 = new DtoTestSuite("MyTestSuite1");
    	
    	dtoTestSuite1.add(idtoTestCase1);
    	dtoTestSuite1.add(idtoTestCase2);
    	dtoTestSuite1.add(idtoTestCase3);
    	
    	DtoTestSuite dtoTestSuite2 = new DtoTestSuite("MyTestSuite2");
    	
    	dtoTestSuite1.add(dtoTestSuite2);
    	
    	IDtoTest idtoTestCase4 = new DtoTestCase(false, false, "TestCase4: FAIL");
    	IDtoTest idtoTestCase5 = new DtoTestCase(false, false, "TestCase5: FAIL");
    	IDtoTest idtoTestCase6 = new DtoTestCase(true, true, "TestCase6: FAIL");
    	IDtoTest idtoTestCase7 = new DtoTestCase(false, true,"TestCase7: OK");
    	IDtoTest idtoTestCase8 = new DtoTestCase(false, true,"TestCase8: OK");
    	IDtoTest idtoTestCase9 = new DtoTestCase(false, false, "TestCase9: FAIL");
    	
    	dtoTestSuite2.add(idtoTestCase4);
    	dtoTestSuite2.add(idtoTestCase5);
    	dtoTestSuite2.add(idtoTestCase6);
    	dtoTestSuite2.add(idtoTestCase7);
    	dtoTestSuite2.add(idtoTestCase8);
    	dtoTestSuite2.add(idtoTestCase9);
    	
    	DtoTestSuite dtoTestSuite3 = new DtoTestSuite("MyTestSuite3");
    	dtoTestSuite1.add(dtoTestSuite3);
 
    	IDtoTest idtoTestCase10 = new DtoTestCase(false, true,"TestCase10: OK");
    	IDtoTest idtoTestCase11 = new DtoTestCase(false, false, "TestCase11: FAIL");
    	IDtoTest idtoTestCase12 = new DtoTestCase(false, true,"TestCase12: OK");
    	
    	dtoTestSuite3.add(idtoTestCase10);
    	dtoTestSuite3.add(idtoTestCase11);
    	dtoTestSuite3.add(idtoTestCase12);
    	
    	
    	DtoTestSuite dtoTestSuite4 = new DtoTestSuite("MyTestSuite4");
    	dtoTestSuite3.add(dtoTestSuite4);
    	
    	IDtoTest idtoTestCase13 = new DtoTestCase(false, true,"TestCase13: OK");
    	IDtoTest idtoTestCase14 = new DtoTestCase(false, false, "TestCase14: FAIL");
    	
    	dtoTestSuite4.add(idtoTestCase13);
    	dtoTestSuite4.add(idtoTestCase14);
    	
    	DtoTestSuite dtoTestSuite5 = new DtoTestSuite("MyTestSuite5");
    	dtoTestSuite1.add(dtoTestSuite5);
    	
    	IDtoTest idtoTestCase15 = new DtoTestCase(false, false, "TestCase15: FAIL");
    	
    	dtoTestSuite5.add(idtoTestCase15);


		IViewTestCase iviewTestCase = new ViewTestCase(dtoTestSuite1);
    	iviewTestCase.prepareViewTestCase().showViewTestCase();
        //System.out.println( dtoTestSuite1.getMessage("com") );

	}

}
