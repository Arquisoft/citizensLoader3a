package es.uniovi.asw.associations;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.uniovi.asw.parser.ReadTest;

@RunWith(Suite.class)
@SuiteClasses({ AsignarTest.class,
				ReadTest.class
			  })

public class AllTests {

}