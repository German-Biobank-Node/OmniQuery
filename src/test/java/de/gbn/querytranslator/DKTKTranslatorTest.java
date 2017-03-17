/*
 * TODO: This License should be changed. 2016.
 */
package de.gbn.querytranslator;

import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import de.gbn.querytranslator.omniquery.ConstraintNode;
import de.gbn.querytranslator.omniquery.ConstraintType;
import de.gbn.querytranslator.omniquery.LogicNode;
import de.gbn.querytranslator.omniquery.LogicType;
import de.gbn.querytranslator.omniquery.OmniQuery;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.DefaultNodeMatcher;
import org.xmlunit.diff.Diff;
import org.xmlunit.diff.ElementSelectors;

/**
 *
 * @author Patric Vormstein <vormstein@med.uni-frankfurt.de>
 */
public class DKTKTranslatorTest {
    
    static String DKTK_XML_PATH_EQUALS = "xml/dktk_test_query_equals.xml";
    static String DKTK_XML_PATH_NOT_EQUALS = "xml/dktk_test_query_not_equals.xml";
    static String DKTK_XML_PATH_GREATER = "xml/dktk_test_query_greater.xml";
    static String DKTK_XML_PATH_GREATER_EQUALS = "xml/dktk_test_query_greater_equals.xml";
    static String DKTK_XML_PATH_LESS = "xml/dktk_test_query_less.xml";
    static String DKTK_XML_PATH_LESS_EQUALS = "xml/dktk_test_query_less_equals.xml";
    static String DKTK_XML_PATH_IS_NULL = "xml/dktk_test_query_is_null.xml";
    static String DKTK_XML_PATH_IS_NOT_NULL = "xml/dktk_test_query_is_not_null.xml";
    static String DKTK_XML_PATH_IN = "xml/dktk_test_query_in.xml";
    static String DKTK_XML_PATH_BETWEEN = "xml/dktk_test_query_between.xml";
    static String DKTK_XML_PATH_LIKE = "xml/dktk_test_query_like.xml";
    static String DKTK_XML_PATH_ORDER_BY = "xml/dktk_test_query_order_by.xml";
    static String DKTK_XML_PATH_GROUP_BY = "xml/dktk_test_query_group_by.xml";
    static String DKTK_XML_PATH_INTERMEDIATE = "xml/dktk_test_query_intermediate.xml";
    static String DKTK_XML_PATH_COMPLEX = "xml/dktk_test_query_complex.xml";
    static String DKTK_XML_PATH_NON_CNF = "xml/dktk_test_query_non_cnf.xml";
    static String DKTK_XML_PATH_CNF = "xml/dktk_test_query_cnf.xml";
    
    
    // Translator
    DKTKTranslator<I2B2Translator> DKTKtoI2B2Translator;    
       
    public DKTKTranslatorTest() {           
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
        DKTKtoI2B2Translator = new DKTKTranslator<>(I2B2Translator.class);
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
    /*@Test
    public void testToI2B2() {
        DKTKtoI2B2Translator.translate(DKTK_XML_PATH_INTERMEDIATE);
    }*/
    
    
    @Test
    public void testNonCNFtoCNF() {
        String actual;
        String expected = readXml(DKTK_XML_PATH_CNF);
        OmniQuery tempOmni;
        
        String xml = readXml(DKTK_XML_PATH_NON_CNF);
        tempOmni = DKTKtoI2B2Translator.translateXmlToOmni(xml);
        tempOmni = tempOmni.convertToCNF();
        actual = DKTKtoI2B2Translator.translateOmniToXml(tempOmni);
        
        Diff xmlDiff = DiffBuilder.compare(expected)
                .withTest(actual)
                .checkForSimilar()
                .normalizeWhitespace()
                .ignoreComments()
                .ignoreWhitespace()
                .withNodeMatcher(new DefaultNodeMatcher(ElementSelectors.byName))
                .build();
        
        assertFalse(xmlDiff.toString(), xmlDiff.hasDifferences());
    }
    
    @Test
    public void testIntermediateXmlToOmni() {        
        OmniQuery actual;
        OmniQuery expected;
        
        String xml = readXml(DKTK_XML_PATH_INTERMEDIATE);
        actual = DKTKtoI2B2Translator.translateXmlToOmni(xml);
        
        // The expected result
        expected = createIntermediateOmni();
        
        assertThat(actual, sameBeanAs(expected));
    }
    
    @Test
    public void testComplexXmlToOmni() {        
        OmniQuery actual;
        OmniQuery expected;
        
        String xml = readXml(DKTK_XML_PATH_COMPLEX);
        actual = DKTKtoI2B2Translator.translateXmlToOmni(xml);
        
        // The expected result
        expected = createComplexOmni();
        
        assertThat(actual, sameBeanAs(expected));
    }
    
    @Test
    public void testSimpleEqualsToOmni() {
        OmniQuery actual;
        OmniQuery expected;
        
        // Translate Xml
        String xml = readXml(DKTK_XML_PATH_EQUALS);
        actual = DKTKtoI2B2Translator.translateXmlToOmni(xml);
        
        // The expected result
        expected = createOmniEquals();
        
        assertThat(actual, sameBeanAs(expected));
    }
    
    @Test
    public void testSimpleNotEqualsToOmni() {
        OmniQuery actual;
        OmniQuery expected;
        
        // Translate Xml
        String xml = readXml(DKTK_XML_PATH_NOT_EQUALS);
        actual = DKTKtoI2B2Translator.translateXmlToOmni(xml);
        
        // The expected result
        expected = createOmniNotEquals();
        
        assertThat(actual, sameBeanAs(expected));
    }
    
    @Test
    public void testSimpleGreaterToOmni() {
        OmniQuery actual;
        OmniQuery expected;
        
        // Translate Xml
        String xml = readXml(DKTK_XML_PATH_GREATER);
        actual = DKTKtoI2B2Translator.translateXmlToOmni(xml);
        
        // The expected result
        expected = createOmniGreater();
        
        assertThat(actual, sameBeanAs(expected));
    }
    
    @Test
    public void testSimpleGreaterEqualsToOmni() {
        OmniQuery actual;
        OmniQuery expected;
        
        // Translate Xml
        String xml = readXml(DKTK_XML_PATH_GREATER_EQUALS);
        actual = DKTKtoI2B2Translator.translateXmlToOmni(xml);
        
        // The expected result
        expected = createOmniGreaterEquals();
        
        assertThat(actual, sameBeanAs(expected));
    }
    
    @Test
    public void testSimpleLessToOmni() {
        OmniQuery actual;
        OmniQuery expected;
        
        // Translate Xml
        String xml = readXml(DKTK_XML_PATH_LESS);
        actual = DKTKtoI2B2Translator.translateXmlToOmni(xml);
        
        // The expected result
        expected = createOmniLess();
        
        assertThat(actual, sameBeanAs(expected));
    }
    
    @Test
    public void testSimpleLessEqualsToOmni() {
        OmniQuery actual;
        OmniQuery expected;
        
        // Translate Xml
        String xml = readXml(DKTK_XML_PATH_LESS_EQUALS);
        actual = DKTKtoI2B2Translator.translateXmlToOmni(xml);
        
        // The expected result
        expected = createOmniLessEquals();
        
        assertThat(actual, sameBeanAs(expected));
    }
    
    @Test
    public void testSimpleIsNullToOmni() {
        OmniQuery actual;
        OmniQuery expected;
        
        // Translate Xml
        String xml = readXml(DKTK_XML_PATH_IS_NULL);
        actual = DKTKtoI2B2Translator.translateXmlToOmni(xml);
        
        // The expected result
        expected = createOmniIsNull();
        
        assertThat(actual, sameBeanAs(expected));
    }
    
    @Test
    public void testSimpleIsNotNullToOmni() {
        OmniQuery actual;
        OmniQuery expected;
        
        // Translate Xml
        String xml = readXml(DKTK_XML_PATH_IS_NOT_NULL);
        actual = DKTKtoI2B2Translator.translateXmlToOmni(xml);
        
        // The expected result
        expected = createOmniIsNotNull();
        
        assertThat(actual, sameBeanAs(expected));
    }
    
    @Test
    public void testSimpleBetweenToOmni() {
        OmniQuery actual;
        OmniQuery expected;
        
        // Translate Xml
        String xml = readXml(DKTK_XML_PATH_BETWEEN);
        actual = DKTKtoI2B2Translator.translateXmlToOmni(xml);
        
        // The expected result
        expected = createOmniBetween();
        
        assertThat(actual, sameBeanAs(expected));
    }
    
    @Test
    public void testSimpleInToOmni() {
        OmniQuery actual;
        OmniQuery expected;
        
        // Translate Xml
        String xml = readXml(DKTK_XML_PATH_IN);
        actual = DKTKtoI2B2Translator.translateXmlToOmni(xml);
        
        // The expected result
        expected = createOmniIn();
        
        assertThat(actual, sameBeanAs(expected));
    }
    
    @Test
    public void testSimpleLikeToOmni() {
        OmniQuery actual;
        OmniQuery expected;
        
        // Translate Xml
        String xml = readXml(DKTK_XML_PATH_LIKE);
        actual = DKTKtoI2B2Translator.translateXmlToOmni(xml);
        
        // The expected result
        expected = createOmniLike();
        
        assertThat(actual, sameBeanAs(expected));
    }
    
    @Test
    public void testSimpleOrderByToOmni() {
        OmniQuery actual;
        OmniQuery expected;
        
        // Translate Xml
        String xml = readXml(DKTK_XML_PATH_ORDER_BY);
        actual = DKTKtoI2B2Translator.translateXmlToOmni(xml);
        
        // The expected result
        expected = createOmniOrderBy();
        
        assertThat(actual, sameBeanAs(expected));
    }
       
    @Test
    public void testSimpleGroupByToOmni() {
        OmniQuery actual;
        OmniQuery expected;
        
        // Translate Xml
        String xml = readXml(DKTK_XML_PATH_GROUP_BY);
        actual = DKTKtoI2B2Translator.translateXmlToOmni(xml);
        
        // The expected result
        expected = createOmniGroupBy();
        
        assertThat(actual, sameBeanAs(expected));
    }
    
    @Test
    public void testOmniEqualsToXml() {
        // Create the constraint
        OmniQuery omniEquals = createOmniEquals();
        
        // Test Method
        String actual = DKTKtoI2B2Translator.translateOmniToXml(omniEquals);
        String expected = readXml(DKTK_XML_PATH_EQUALS);
        
        Diff xmlDiff = DiffBuilder.compare(actual)
                .withTest(expected)
                .checkForSimilar()
                .normalizeWhitespace()
                .build();
        
        assertFalse(xmlDiff.toString(), xmlDiff.hasDifferences());
    }
    
    @Test
    public void testOmniNotEqualsToXml() {
        // Create the constraint
        OmniQuery omniNotEquals = createOmniNotEquals();
        
        // Test Method
        String actual = DKTKtoI2B2Translator.translateOmniToXml(omniNotEquals);
        String expected = readXml(DKTK_XML_PATH_NOT_EQUALS);
        
        Diff xmlDiff = DiffBuilder.compare(actual)
                .withTest(expected)
                .checkForSimilar()
                .normalizeWhitespace()
                .build();
        
        assertFalse(xmlDiff.toString(), xmlDiff.hasDifferences());
    }
    
    @Test
    public void testOmniGreaterToXml() {
        // Create the constraint
        OmniQuery omniGreater = createOmniGreater();
        
        // Test Method
        String actual = DKTKtoI2B2Translator.translateOmniToXml(omniGreater);
        String expected = readXml(DKTK_XML_PATH_GREATER);
        
        Diff xmlDiff = DiffBuilder.compare(actual)
                .withTest(expected)
                .checkForSimilar()
                .normalizeWhitespace()
                .build();
        
        assertFalse(xmlDiff.toString(), xmlDiff.hasDifferences());
    }
    
    @Test
    public void testOmniGreaterEqualsToXml() {
        // Create the constraint
        OmniQuery omniGreaterEquals = createOmniGreaterEquals();
        
        // Test Method
        String actual = DKTKtoI2B2Translator.translateOmniToXml(omniGreaterEquals);
        String expected = readXml(DKTK_XML_PATH_GREATER_EQUALS);
        
        Diff xmlDiff = DiffBuilder.compare(actual)
                .withTest(expected)
                .checkForSimilar()
                .normalizeWhitespace()
                .build();
        
        assertFalse(xmlDiff.toString(), xmlDiff.hasDifferences());
    }
    
    @Test
    public void testOmniLessToXml() {
        // Create the constraint
        OmniQuery omniLess = createOmniLess();
        
        // Test Method
        String actual = DKTKtoI2B2Translator.translateOmniToXml(omniLess);
        String expected = readXml(DKTK_XML_PATH_LESS);
        
        Diff xmlDiff = DiffBuilder.compare(actual)
                .withTest(expected)
                .checkForSimilar()
                .normalizeWhitespace()
                .build();
        
        assertFalse(xmlDiff.toString(), xmlDiff.hasDifferences());
    }
    
    @Test
    public void testOmniLessEqualsToXml() {
        // Create the constraint
        OmniQuery omniLessEquals = createOmniLessEquals();
        
        // Test Method
        String actual = DKTKtoI2B2Translator.translateOmniToXml(omniLessEquals);
        String expected = readXml(DKTK_XML_PATH_LESS_EQUALS);
        
        Diff xmlDiff = DiffBuilder.compare(actual)
                .withTest(expected)
                .checkForSimilar()
                .normalizeWhitespace()
                .build();
        
        assertFalse(xmlDiff.toString(), xmlDiff.hasDifferences());
    }
    
    @Test
    public void testOmniIsNullToXml() {
        // Create the constraint
        OmniQuery omniIsNull = createOmniIsNull();
        
        // Test Method
        String actual = DKTKtoI2B2Translator.translateOmniToXml(omniIsNull);
        String expected = readXml(DKTK_XML_PATH_IS_NULL);
        
        Diff xmlDiff = DiffBuilder.compare(actual)
                .withTest(expected)
                .checkForSimilar()
                .normalizeWhitespace()
                .build();
        
        assertFalse(xmlDiff.toString(), xmlDiff.hasDifferences());
    }
    
    @Test
    public void testOmniIsNotNullToXml() {
        // Create the constraint
        OmniQuery omniIsNotNull = createOmniIsNotNull();
        
        // Test Method
        String actual = DKTKtoI2B2Translator.translateOmniToXml(omniIsNotNull);
        String expected = readXml(DKTK_XML_PATH_IS_NOT_NULL);
        
        Diff xmlDiff = DiffBuilder.compare(actual)
                .withTest(expected)
                .checkForSimilar()
                .normalizeWhitespace()
                .build();
        
        assertFalse(xmlDiff.toString(), xmlDiff.hasDifferences());
    }
    
    @Test
    public void testOmniInToXml() {
        // Create the constraint
        OmniQuery omniIn = createOmniIn();
        
        // Test Method
        String actual = DKTKtoI2B2Translator.translateOmniToXml(omniIn);
        String expected = readXml(DKTK_XML_PATH_IN);
        
        Diff xmlDiff = DiffBuilder.compare(actual)
                .withTest(expected)
                .checkForSimilar()
                .normalizeWhitespace()
                .build();
        
        assertFalse(xmlDiff.toString(), xmlDiff.hasDifferences());
    }
    
    @Test
    public void testOmniBetweenToXml() {
        // Create the constraint
        OmniQuery omniBetween = createOmniBetween();
        
        // Test Method
        String actual = DKTKtoI2B2Translator.translateOmniToXml(omniBetween);
        String expected = readXml(DKTK_XML_PATH_BETWEEN);
        
        Diff xmlDiff = DiffBuilder.compare(actual)
                .withTest(expected)
                .checkForSimilar()
                .normalizeWhitespace()
                .build();
        
        assertFalse(xmlDiff.toString(), xmlDiff.hasDifferences());
    }
    
    @Test
    public void testOmniLikeToXml() {
        // Create the constraint
        OmniQuery omniLike = createOmniLike();
        
        // Test Method
        String actual = DKTKtoI2B2Translator.translateOmniToXml(omniLike);
        String expected = readXml(DKTK_XML_PATH_LIKE);
        
        Diff xmlDiff = DiffBuilder.compare(actual)
                .withTest(expected)
                .checkForSimilar()
                .normalizeWhitespace()
                .build();
        
        assertFalse(xmlDiff.toString(), xmlDiff.hasDifferences());
    }
    
    @Test
    public void testOmniOrderByToXml() {
        // Create the constraint
        OmniQuery omniOrderBy = createOmniOrderBy();
        
        // Test Method
        String actual = DKTKtoI2B2Translator.translateOmniToXml(omniOrderBy);
        String expected = readXml(DKTK_XML_PATH_ORDER_BY);
        
        Diff xmlDiff = DiffBuilder.compare(actual)
                .withTest(expected)
                .checkForSimilar()
                .normalizeWhitespace()
                .build();
        
        assertFalse(xmlDiff.toString(), xmlDiff.hasDifferences());
    }
    
    @Test
    public void testIntermediateOmniToXml() {
        // Create the constraint
        OmniQuery intermediateOmni = createIntermediateOmni();
        
        // Test Method
        String actual = DKTKtoI2B2Translator.translateOmniToXml(intermediateOmni);
        String expected = readXml(DKTK_XML_PATH_INTERMEDIATE);
        
        Diff xmlDiff = DiffBuilder.compare(actual)
                .withTest(expected)
                .checkForSimilar()
                .normalizeWhitespace()
                .build();
        
        assertFalse(xmlDiff.toString(), xmlDiff.hasDifferences());
    }
    
    @Test
    public void testComplexOmniToXml() {
        // Create the constraint
        OmniQuery complexOmni = createComplexOmni();
        
        // Test Method
        String actual = DKTKtoI2B2Translator.translateOmniToXml(complexOmni);
        String expected = readXml(DKTK_XML_PATH_COMPLEX);
        
        Diff xmlDiff = DiffBuilder.compare(actual)
                .withTest(expected)
                .checkForSimilar()
                .normalizeWhitespace()
                .build();
        
        assertFalse(xmlDiff.toString(), xmlDiff.hasDifferences());
    }
    // -- END TESTS
    
    
    OmniQuery createOmniEquals() {
        OmniQuery equals = new OmniQuery();
        equals.setNode(new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "9382/3"));
        
        return equals;
    }
    
    OmniQuery createOmniNotEquals() {
        OmniQuery notEquals = new OmniQuery();
        notEquals.setNode(new ConstraintNode(ConstraintType.NotEquals, "urn:dktk:dataelement:7:2", "9400/3"));
        
        return notEquals;
    }
    
    OmniQuery createOmniGreater() {
        OmniQuery greater = new OmniQuery();
        greater.setNode(new ConstraintNode(ConstraintType.Greater, "urn:dktk:dataelement:7:2", "25"));
        
        return greater;
    }
    
    OmniQuery createOmniGreaterEquals() {
        OmniQuery greaterEquals = new OmniQuery();
        greaterEquals.setNode(new ConstraintNode(ConstraintType.GreaterEquals, "urn:dktk:dataelement:7:2", "45"));
        
        return greaterEquals;
    }
    
    OmniQuery createOmniLess() {
        OmniQuery less = new OmniQuery();
        less.setNode(new ConstraintNode(ConstraintType.Less, "urn:dktk:dataelement:7:2", "63"));
        
        return less;
    }
    
    OmniQuery createOmniLessEquals() {
        OmniQuery lessEquals = new OmniQuery();
        lessEquals.setNode(new ConstraintNode(ConstraintType.LessEquals, "urn:dktk:dataelement:7:2", "59"));
        
        return lessEquals;
    }
    
    OmniQuery createOmniIsNull() {
        OmniQuery isNull = new OmniQuery();
        isNull.setNode(new ConstraintNode(ConstraintType.IsNull, "urn:dktk:dataelement:7:2"));
        
        return isNull;
    }
    
    OmniQuery createOmniIsNotNull() {
        OmniQuery isNotNull = new OmniQuery();
        isNotNull.setNode(new ConstraintNode(ConstraintType.IsNotNull, "urn:dktk:dataelement:7:2"));
        
        return isNotNull;
    }
    
    OmniQuery createOmniIn() {
        List<String> valuesList = new ArrayList();
        valuesList.add("0");
        valuesList.add("25");
        valuesList.add("50");
        valuesList.add("75");
        valuesList.add("100");
        OmniQuery in = new OmniQuery();
        in.setNode(new ConstraintNode(ConstraintType.In, "urn:dktk:dataelement:29:2", valuesList));
        
        return in;
    }
    
    OmniQuery createOmniBetween() {
        List<String> valuesList = new ArrayList();
        valuesList.add("10");
        valuesList.add("20");
        OmniQuery between = new OmniQuery();
        between.setNode(new ConstraintNode(ConstraintType.Between, "urn:dktk:dataelement:29:2", valuesList));
        
        return between;
    }
    
    OmniQuery createOmniOrderBy() {
        OmniQuery orderBy = new OmniQuery();
        orderBy.setNode(new ConstraintNode(ConstraintType.IsNotNull, "urn:dktk:dataelement:3:5"));
        orderBy.addOrder("A|urn:dktk:dataelement:7:2");
        orderBy.addOrder("D|urn:dktk:dataelement:10:3");
        
        return orderBy;
    }
    
    OmniQuery createOmniGroupBy() {
        OmniQuery groupBy = new OmniQuery();
        groupBy.setNode(new ConstraintNode(ConstraintType.IsNotNull, "urn:dktk:dataelement:3:5"));
        groupBy.setGroupBy("urn:dktk:dataelement:7:2");
        
        return groupBy;
    }
    
    OmniQuery createOmniLike() {
        OmniQuery like = new OmniQuery();
        like.setNode(new ConstraintNode(ConstraintType.Like, "urn:dktk:dataelement:29:2", "%C71.%"));
        
        return like;
    }
    
    OmniQuery createIntermediateOmni() {
        OmniQuery intermediate = new OmniQuery();
        
        // 1. Level - And
        LogicNode and1 = new LogicNode(LogicType.And);
        intermediate.setNode(and1);
        
        // 2. Level - And
        LogicNode and2 = new LogicNode(LogicType.And);
        and1.addNode(and2);
        
        // 3. Level - Or, Or, Eq
        LogicNode or1 = new LogicNode(LogicType.Or);
        and2.addNode(or1);

        LogicNode or2 = new LogicNode(LogicType.Or);
        and2.addNode(or2);

        ConstraintNode eq1 = new ConstraintNode(ConstraintType.Equals, "urn:adt:dataelement:108:1", "R2");
        and2.addNode(eq1);

        // 4. Level - (Like, Like), (Eq, Eq, Eq, Eq, Eq, Eq)
        ConstraintNode like1 = new ConstraintNode(ConstraintType.Like, "urn:dktk:dataelement:29:2", "%C71.%");
        or1.addNode(like1);
        
        ConstraintNode like2 = new ConstraintNode(ConstraintType.Like, "urn:dktk:dataelement:29:2", "%C72.%");
        or1.addNode(like2);
        
        ConstraintNode eq2 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "9382/3");
        or2.addNode(eq2);
        
        ConstraintNode eq3 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "9391/3");
        or2.addNode(eq3);
        
        ConstraintNode eq4 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "9400/3");
        or2.addNode(eq4);
        
        ConstraintNode eq5 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "9424/3");
        or2.addNode(eq5);
        
        ConstraintNode eq6 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "9425/3");
        or2.addNode(eq6);
        
        ConstraintNode eq7 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "9450/3");
        or2.addNode(eq7);
        
        return intermediate;
    }
    
    OmniQuery createComplexOmni() {
        OmniQuery complex = new OmniQuery();
        
        // Level 1 - And
        LogicNode and1 = new LogicNode(LogicType.And);
        complex.setNode(and1);
        
        // Level 2 - And, Or, And
        LogicNode and2 = new LogicNode(LogicType.And);
        and1.addNode(and2);
        
        LogicNode or1 = new LogicNode(LogicType.Or);
        and1.addNode(or1);
        
        LogicNode and3 = new LogicNode(LogicType.And);
        and1.addNode(and3);
        
        // Level 3 - (Or, Or), (And), (And)
        LogicNode or2 = new LogicNode(LogicType.Or);
        and2.addNode(or2);
        
        LogicNode or3 = new LogicNode(LogicType.Or);
        and2.addNode(or3);
        
        LogicNode and4 = new LogicNode(LogicType.And);
        or1.addNode(and4);
        
        LogicNode and5 = new LogicNode(LogicType.And);
        and3.addNode(and5);
        
        // Level 4 - (Like), (Eq, Eq, Eq, Eq, Eq, Eq), (Or, Or), (Or, Or)
        ConstraintNode like1 = new ConstraintNode(ConstraintType.Like, "urn:dktk:dataelement:29:2", "%C11.%");
        or2.addNode(like1);
        
        ConstraintNode eq1 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "8050/3");
        or3.addNode(eq1);
        
        ConstraintNode eq2 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "8052/3");
        or3.addNode(eq2);
        
        ConstraintNode eq3 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "8070/3");
        or3.addNode(eq3);
        
        ConstraintNode eq4 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "8071/3");
        or3.addNode(eq4);
        
        ConstraintNode eq5 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "8072/3");
        or3.addNode(eq5);
        
        ConstraintNode eq6 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "8082/3");
        or3.addNode(eq6);
        
        LogicNode or4 = new LogicNode(LogicType.Or);
        and4.addNode(or4);
        
        LogicNode or5 = new LogicNode(LogicType.Or);
        and4.addNode(or5);
        
        LogicNode or6 = new LogicNode(LogicType.Or);
        and5.addNode(or6);
        
        LogicNode or7 = new LogicNode(LogicType.Or);
        and5.addNode(or7);
        
        // Level 5 - (Like), (Eq, Eq, Eq, Eq, Eq, And), (Like), (Eq, IsNull)
        ConstraintNode like2 = new ConstraintNode(ConstraintType.Like, "urn:dktk:dataelement:29:2", "%C80.9%");
        or4.addNode(like2);
        
        ConstraintNode eq7 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "8050/3");
        or5.addNode(eq7);
        
        ConstraintNode eq8 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "8052/3");
        or5.addNode(eq8);
        
        ConstraintNode eq9 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "8070/3");
        or5.addNode(eq9);
        
        ConstraintNode eq10 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "8071/3");
        or5.addNode(eq10);
        
        ConstraintNode eq11 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "8072/3");
        or5.addNode(eq11);
        
        LogicNode and6 = new LogicNode(LogicType.And);
        or5.addNode(and6);
        
        ConstraintNode like3 = new ConstraintNode(ConstraintType.Like, "urn:dktk:dataelement:29:2", "%C64%");
        or6.addNode(like3);
        
        ConstraintNode eq12 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "8260/3");
        or7.addNode(eq12);
        
        ConstraintNode isNull1 = new ConstraintNode(ConstraintType.IsNull, "urn:dktk:dataelement:1:3");
        or7.addNode(isNull1);
        
        // Level 6 - Or, Or
        LogicNode or8 = new LogicNode(LogicType.Or);
        and6.addNode(or8);
        
        LogicNode or9 = new LogicNode(LogicType.Or);
        and6.addNode(or9);
        
        // Level 7 - (Like, Gt), (Eq, Eq, Eq, Eq, Eq, Eq, Between, IsNull)
        ConstraintNode like4 = new ConstraintNode(ConstraintType.Like, "urn:dktk:dataelement:29:2", "%C%");
        or8.addNode(like4);
        
        ConstraintNode gt1 = new ConstraintNode(ConstraintType.Greater, "urn:adt:dataelement:96:1", "17.08.2016");
        or8.addNode(gt1);
        
        ConstraintNode eq13 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "9060/3");
        or9.addNode(eq13);
        
        ConstraintNode eq14 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "9061/3");
        or9.addNode(eq14);
        
        ConstraintNode eq15 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "9062/3");
        or9.addNode(eq15);
        
        ConstraintNode eq16 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "9063/3");
        or9.addNode(eq16);
        
        ConstraintNode eq17 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "9064/3");
        or9.addNode(eq17);
        
        ConstraintNode eq18 = new ConstraintNode(ConstraintType.Equals, "urn:dktk:dataelement:7:2", "9065/3");
        or9.addNode(eq18);
        
        List<String> values = new ArrayList();
        values.add("29.12.2008");
        values.add("14.06.2010");
        ConstraintNode between1 = new ConstraintNode(ConstraintType.Between, "urn:dktk:dataelement:26:4", values);
        or9.addNode(between1);
        
        ConstraintNode isNull2 = new ConstraintNode(ConstraintType.IsNull, "urn:dktk:dataelement:53:2");
        or9.addNode(isNull2);
        
        return complex;
    }
    
    String readXml(String path) {
        String xml = "";
        
        try(InputStream is = getClass().getClassLoader().getResourceAsStream(path)) {
            xml = IOUtils.toString(is, "UTF-8");
        }
        catch(IOException ioEx) {
            ioEx.printStackTrace(); // TODO
        }
        
        return xml;
    }
}
