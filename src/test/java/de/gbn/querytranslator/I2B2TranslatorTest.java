/*
 * TODO: This License should be changed. 2016.
 */
package de.gbn.querytranslator;

import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import de.gbn.querytranslator.omniquery.ConstraintNode;
import de.gbn.querytranslator.omniquery.OmniQuery;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.Diff;

/**
 *
 * @author Patric Vormstein <vormstein@med.uni-frankfurt.de>
 */
public class I2B2TranslatorTest {

	// Translator
	I2B2Translator translator1;
	DKTKTranslator translator2;

	public I2B2TranslatorTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		// Create Translator
		translator1 = new I2B2Translator();
		translator2 = new DKTKTranslator();
	}

	@After
	public void tearDown() {
	}

	// -- BEGIN TESTS
	// TODO add test methods here.
	// The methods must be annotated with annotation @Test. For example:
	//
	// @Test
	// public void hello() {}

	@Test
	public void li2b2_test_query() {
		OmniQuery omni;
		System.out.println("Running Test xml/li2b2_test_query.xml");
		String xml = readXml("xml/li2b2_test_query.xml");
		xml = xml.replaceAll("<query_definition>", "<ns3:query_definition xmlns:ns3=\"http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/\">").replaceAll("</query_definition>",
				"</ns3:query_definition>");

		System.out.println(xml);

		omni = translator1.translateXmlToOmni(xml);
		String dktk = translator2.translateOmniToXml(omni);
		System.out.println(prettyFormat(dktk));
	}

	/*
	 * @Test public void i2b2_test_query_complex() { OmniQuery omni; System.out.println("Running Test xml/i2b2_test_query_complex.xml"); String xml =
	 * readXml("xml/i2b2_test_query_complex.xml"); omni = translator1.translateXmlToOmni(xml); String dktk = translator2.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * 
	 * @Test public void i2b2_test_query_cbv_BETWEEN() { OmniQuery omni; System.out.println("Running Test xml/i2b2_test_query_cbv_BETWEEN.xml"); String xml =
	 * readXml("xml/i2b2_test_query_cbv_BETWEEN.xml"); omni = translator1.translateXmlToOmni(xml); String dktk = translator2.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void i2b2_test_query_cbv_EQ() { OmniQuery omni; System.out.println("Running Test xml/i2b2_test_query_cbv_EQ.xml"); String xml =
	 * readXml("xml/i2b2_test_query_cbv_EQ.xml"); omni = translator1.translateXmlToOmni(xml); String dktk = translator2.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void i2b2_test_query_cbv_GE() { OmniQuery omni; System.out.println("Running Test xml/i2b2_test_query_cbv_GE.xml"); String xml =
	 * readXml("xml/i2b2_test_query_cbv_GE.xml"); omni = translator1.translateXmlToOmni(xml); String dktk = translator2.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void i2b2_test_query_cbv_GT() { OmniQuery omni; System.out.println("Running Test xml/i2b2_test_query_cbv_GT.xml"); String xml =
	 * readXml("xml/i2b2_test_query_cbv_GT.xml"); omni = translator1.translateXmlToOmni(xml); String dktk = translator2.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void i2b2_test_query_cbv_LE() { OmniQuery omni; System.out.println("Running Test xml/i2b2_test_query_cbv_LE.xml"); String xml =
	 * readXml("xml/i2b2_test_query_cbv_LE.xml"); omni = translator1.translateXmlToOmni(xml); String dktk = translator2.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void i2b2_test_query_cbv_LT() { OmniQuery omni; System.out.println("Running Test xml/i2b2_test_query_cbv_LT.xml"); String xml =
	 * readXml("xml/i2b2_test_query_cbv_LT.xml"); omni = translator1.translateXmlToOmni(xml); String dktk = translator2.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void i2b2_test_query_constrain_by_date() { OmniQuery omni; System.out.println("Running Test xml/i2b2_test_query_constrain_by_date.xml");
	 * String xml = readXml("xml/i2b2_test_query_constrain_by_date.xml"); omni = translator1.translateXmlToOmni(xml); String dktk =
	 * translator2.translateOmniToXml(omni); System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void i2b2_test_query_constrain_by_flag() { OmniQuery omni; System.out.println("Running Test xml/i2b2_test_query_constrain_by_flag.xml");
	 * String xml = readXml("xml/i2b2_test_query_constrain_by_flag.xml"); omni = translator1.translateXmlToOmni(xml); String dktk =
	 * translator2.translateOmniToXml(omni); System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void i2b2_test_query_constrain_by_no_value() { OmniQuery omni; System.out.println(
	 * "Running Test xml/i2b2_test_query_constrain_by_no_value.xml"); String xml = readXml("xml/i2b2_test_query_constrain_by_no_value.xml"); omni =
	 * translator1.translateXmlToOmni(xml); String dktk = translator2.translateOmniToXml(omni); System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void i2b2_test_query_EXCLUDE1() { OmniQuery omni; System.out.println("Running Test xml/i2b2_test_query_EXCLUDE1.xml"); String xml =
	 * readXml("xml/i2b2_test_query_EXCLUDE1.xml"); omni = translator1.translateXmlToOmni(xml); String dktk = translator2.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void i2b2_test_query_EXCLUDE2() { OmniQuery omni; System.out.println("Running Test xml/i2b2_test_query_EXCLUDE2.xml"); String xml =
	 * readXml("xml/i2b2_test_query_EXCLUDE2.xml"); omni = translator1.translateXmlToOmni(xml); String dktk = translator2.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void i2b2_test_query_occurance() { OmniQuery omni; System.out.println("Running Test xml/i2b2_test_query_occurance.xml"); String xml =
	 * readXml("xml/i2b2_test_query_occurance.xml"); omni = translator1.translateXmlToOmni(xml); String dktk = translator2.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void i2b2_test_query_temporal() { OmniQuery omni; System.out.println("Running Test xml/i2b2_test_query_temporal.xml"); String xml =
	 * readXml("xml/i2b2_test_query_temporal.xml"); omni = translator1.translateXmlToOmni(xml); String dktk = translator2.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 */

	// ---------------------------------------------------------------------------------
	@Test
	public void dktk_test_0() {
		OmniQuery omni;
		System.out.println("Running Test xml/dktk_real_query_2.xml");
		String xml = readXml("xml/dktk_real_query_2.xml");
		omni = translator2.translateXmlToOmni(xml);
		String dktk = translator1.translateOmniToXml(omni);
		System.out.println(prettyFormat(dktk));
	}

	
	
	/*
	 * 
	 * 
	 * 
	 * @Test public void dktk_test_1() { OmniQuery omni; System.out.println("Running Test xml/dktk_real_query_2.xml"); String xml =
	 * readXml("xml/dktk_real_query_2.xml"); omni = translator2.translateXmlToOmni(xml); String dktk = translator1.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void dktk_test_2() { OmniQuery omni; System.out.println("Running Test xml/dktk_real_query_2.xml"); String xml =
	 * readXml("xml/dktk_real_query_2.xml"); omni = translator2.translateXmlToOmni(xml); String dktk = translator1.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * 
	 * @Test public void dktk_test_3() { OmniQuery omni; System.out.println("Running Test xml/dktk_test_query_between.xml"); String xml =
	 * readXml("xml/dktk_test_query_between.xml"); omni = translator2.translateXmlToOmni(xml); String dktk = translator1.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void dktk_test_4() { OmniQuery omni; System.out.println("Running Test xml/dktk_test_query_cnf.xml"); String xml =
	 * readXml("xml/dktk_test_query_cnf.xml"); omni = translator2.translateXmlToOmni(xml); String dktk = translator1.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void dktk_test_5() { OmniQuery omni; System.out.println("Running Test xml/dktk_test_query_complex.xml"); String xml =
	 * readXml("xml/dktk_test_query_complex.xml"); omni = translator2.translateXmlToOmni(xml); String dktk = translator1.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void dktk_test_6() { OmniQuery omni; System.out.println("Running Test xml/dktk_test_query_equals.xml"); String xml =
	 * readXml("xml/dktk_test_query_equals.xml"); omni = translator2.translateXmlToOmni(xml); String dktk = translator1.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void dktk_test_7() { OmniQuery omni; System.out.println("Running Test xml/dktk_test_query_greater_equals.xml"); String xml =
	 * readXml("xml/dktk_test_query_greater_equals.xml"); omni = translator2.translateXmlToOmni(xml); String dktk = translator1.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void dktk_test_8() { OmniQuery omni; System.out.println("Running Test xml/dktk_test_query_greater.xml"); String xml =
	 * readXml("xml/dktk_test_query_greater.xml"); omni = translator2.translateXmlToOmni(xml); String dktk = translator1.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void dktk_test_9() { OmniQuery omni; System.out.println("Running Test xml/dktk_test_query_group_by.xml"); String xml =
	 * readXml("xml/dktk_test_query_group_by.xml"); omni = translator2.translateXmlToOmni(xml); String dktk = translator1.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void dktk_test_10() { OmniQuery omni; System.out.println("Running Test xml/dktk_test_query_in.xml"); String xml =
	 * readXml("xml/dktk_test_query_in.xml"); omni = translator2.translateXmlToOmni(xml); String dktk = translator1.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void dktk_test_11() { OmniQuery omni; System.out.println("Running Test xml/dktk_test_query_intermediate.xml"); String xml =
	 * readXml("xml/dktk_test_query_intermediate.xml"); omni = translator2.translateXmlToOmni(xml); String dktk = translator1.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void dktk_test_12() { OmniQuery omni; System.out.println("Running Test xml/dktk_test_query_is_not_null.xml"); String xml =
	 * readXml("xml/dktk_test_query_is_not_null.xml"); omni = translator2.translateXmlToOmni(xml); String dktk = translator1.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void dktk_test_13() { OmniQuery omni; System.out.println("Running Test xml/dktk_test_query_is_null.xml"); String xml =
	 * readXml("xml/dktk_test_query_is_null.xml"); omni = translator2.translateXmlToOmni(xml); String dktk = translator1.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void dktk_test_14() { OmniQuery omni; System.out.println("Running Test xml/dktk_test_query_less_equals.xml"); String xml =
	 * readXml("xml/dktk_test_query_less_equals.xml"); omni = translator2.translateXmlToOmni(xml); String dktk = translator1.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void dktk_test_15() { OmniQuery omni; System.out.println("Running Test xml/dktk_test_query_less.xml"); String xml =
	 * readXml("xml/dktk_test_query_less.xml"); omni = translator2.translateXmlToOmni(xml); String dktk = translator1.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void dktk_test_16() { OmniQuery omni; System.out.println("Running Test xml/dktk_test_query_like.xml"); String xml =
	 * readXml("xml/dktk_test_query_like.xml"); omni = translator2.translateXmlToOmni(xml); String dktk = translator1.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void dktk_test_17() { OmniQuery omni; System.out.println("Running Test xml/dktk_test_query_non_cnf.xml"); String xml =
	 * readXml("xml/dktk_test_query_non_cnf.xml"); omni = translator2.translateXmlToOmni(xml); String dktk = translator1.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void dktk_test_18() { OmniQuery omni; System.out.println("Running Test xml/dktk_test_query_not_equals.xml"); String xml =
	 * readXml("xml/dktk_test_query_not_equals.xml"); omni = translator2.translateXmlToOmni(xml); String dktk = translator1.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 * @Test public void dktk_test_19() { OmniQuery omni; System.out.println("Running Test xml/dktk_test_query_order_by.xml"); String xml =
	 * readXml("xml/dktk_test_query_order_by.xml"); omni = translator2.translateXmlToOmni(xml); String dktk = translator1.translateOmniToXml(omni);
	 * System.out.println(prettyFormat(dktk)); }
	 * 
	 */

	// ---------------------------------------------------------------------------------

	String readXml(String path) {
		String xml = "";

		try (InputStream is = getClass().getClassLoader().getResourceAsStream(path)) {
			xml = IOUtils.toString(is, "UTF-8");
		} catch (IOException ioEx) {
			ioEx.printStackTrace(); // TODO
		}

		return xml;
	}

	public static String prettyFormat(String input, int indent) {

		return input;

		/*
		 * try { Source xmlInput = new StreamSource(new StringReader(input)); StringWriter stringWriter = new StringWriter(); StreamResult xmlOutput = new
		 * StreamResult(stringWriter); TransformerFactory transformerFactory = TransformerFactory.newInstance();
		 * transformerFactory.setAttribute("indent-number", indent); Transformer transformer = transformerFactory.newTransformer();
		 * transformer.setOutputProperty(OutputKeys.INDENT, "yes"); transformer.transform(xmlInput, xmlOutput); return xmlOutput.getWriter().toString(); } catch
		 * (Exception e) { throw new RuntimeException(e); // simple exception handling, please review it }
		 */
	}

	public static String prettyFormat(String input) {
		return prettyFormat(input, 2);
	}

}
