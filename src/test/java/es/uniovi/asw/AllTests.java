package es.uniovi.asw;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.uniovi.asw.Checker.CheckerTest;
import es.uniovi.asw.associations.AsignarTest;
import es.uniovi.asw.parser.ReadTest;

@RunWith(Suite.class)
@SuiteClasses({ AsignarTest.class,
				ReadTest.class,
				CheckerTest.class,
				ReadTest.class
  			  })

public class AllTests {

}
