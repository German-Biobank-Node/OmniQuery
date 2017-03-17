/*
 * TODO: This License should be changed. 2016.
 */
package de.gbn.querytranslator;

import java.io.File;
import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import de.gbn.querytranslator.omniquery.AbstractNode;
import org.i2b2.xsd.hive.msg._1.ObjectFactory;
import de.gbn.querytranslator.omniquery.ConstraintNode;
import de.gbn.querytranslator.omniquery.ConstraintType;
import de.gbn.querytranslator.omniquery.LogicNode;
import de.gbn.querytranslator.omniquery.LogicType;
import de.gbn.querytranslator.omniquery.OmniQuery;
import de.gbn.querytranslator.semanticshandler.Mapper;
import de.samply.share.model.osse.And;
import de.samply.share.model.osse.Attribute;
import de.samply.share.model.osse.Between;
import de.samply.share.model.osse.ConditionType;
import de.samply.share.model.osse.Eq;
import de.samply.share.model.osse.Geq;
import de.samply.share.model.osse.GroupBy;
import de.samply.share.model.osse.Gt;
import de.samply.share.model.osse.In;
import de.samply.share.model.osse.IsNotNull;
import de.samply.share.model.osse.IsNull;
import de.samply.share.model.osse.Leq;
import de.samply.share.model.osse.Like;
import de.samply.share.model.osse.Lt;
import de.samply.share.model.osse.MultivalueAttribute;
import de.samply.share.model.osse.Neq;
import de.samply.share.model.osse.Or;
import de.samply.share.model.osse.Order;
import de.samply.share.model.osse.OrderBy;
import de.samply.share.model.osse.Query;
import de.samply.share.model.osse.RangeAttribute;
import de.samply.share.model.osse.Where;

import org.i2b2.xsd.hive.msg._1.*;
import org.i2b2.xsd.cell.crc.psm._1.*;
import org.i2b2.xsd.cell.crc.psm.querydefinition._1.ConstrainDateType;
import org.i2b2.xsd.cell.crc.psm.querydefinition._1.ConstrainOperatorType;
import org.i2b2.xsd.cell.crc.psm.querydefinition._1.ConstrainValueType;
import org.i2b2.xsd.cell.crc.psm.querydefinition._1.ItemType;
import org.i2b2.xsd.cell.crc.psm.querydefinition._1.ItemType.ConstrainByDate;
import org.i2b2.xsd.cell.crc.psm.querydefinition._1.ItemType.ConstrainByModifier;
import org.i2b2.xsd.cell.crc.psm.querydefinition._1.ItemType.ConstrainByModifier.ConstrainByValue;
import org.i2b2.xsd.cell.crc.psm.querydefinition._1.PanelType;
import org.i2b2.xsd.cell.crc.psm.querydefinition._1.PanelType.TotalItemOccurrences;
import org.i2b2.xsd.cell.crc.psm.querydefinition._1.QueryDefinitionType;

import java.io.File;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import org.w3c.dom.Node;

import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import com.sun.org.apache.xerces.internal.xni.NamespaceContext;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;

public class I2B2Translator<T extends IQueryTranslator> extends AbstractTranslator<T> {

	static String VALUE_NAMESPACE_URI = "http://schema.samply.de/osse/Value";
	static String VALUE_LOCAL_NAME = "Value";

	/**
	 * Translates i2b2-xml into the OmniQuery transmission format.
	 * 
	 * @param xml
	 *            The given Xml as string
	 * @return The translated OmniQuery
	 */
	@SuppressWarnings("unchecked")
	@Override
	public OmniQuery translateXmlToOmni(String xml) {

		OmniQuery result = new OmniQuery();

		try {

			/*
			 * // Unmarshall outer i2b2 XML request message: JAXBContext jaxbContext; jaxbContext = JAXBContext.newInstance(RequestMessageType.class);
			 * Unmarshaller unmarshaller = jaxbContext.createUnmarshaller(); JAXBElement<RequestMessageType> requestMessageType; requestMessageType =
			 * (JAXBElement<RequestMessageType>) unmarshaller.unmarshal(new StringReader(xml)); RequestMessageType requestMessage =
			 * requestMessageType.getValue(); // Split request message into parts ... BodyType messageBody = requestMessage.getMessageBody(); // ... and
			 * continue with the message body, which needs to be // unmarshalled again: List<Object> messageBodies = messageBody.getAny(); Object content =
			 * messageBodies.get(1); JAXBContext context = JAXBContext.newInstance("org.i2b2.xsd.cell.crc.psm._1"); Unmarshaller um =
			 * context.createUnmarshaller(); QueryDefinitionRequestType queryDefinitionType = (QueryDefinitionRequestType)
			 * JAXBIntrospector.getValue(um.unmarshal((Node) content));
			 * 
			 */

			JAXBContext jaxbContext;
			jaxbContext = JAXBContext.newInstance("org.i2b2.xsd.cell.crc.psm.querydefinition._1");

			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			JAXBElement<QueryDefinitionType> queryDefinition;
			queryDefinition = (JAXBElement<QueryDefinitionType>) unmarshaller.unmarshal(new StringReader(xml));

			QueryDefinitionType definition = queryDefinition.getValue();

			List<PanelType> panelList = definition.getPanel();

			List<QueryDefinitionType> subQueries = definition.getSubquery();
			if (subQueries.size() > 0) {
				throw new NotSupportedException("i2b2 subqueries / temporal queries are not supported");
			}

			// Iterate over all "panels" and build the OmniQuery:

			LogicNode rootNode = new LogicNode(LogicType.And);

			for (int panel = 0; panel < panelList.size(); panel++) {

				LogicNode panelNode = new LogicNode(LogicType.Or);

				if (panelList.get(panel).getInvert() == 1) {
					throw new NotSupportedException("i2b2 exclude panel is not supported");
				}

				if (panelList.get(panel).getTotalItemOccurrences().getValue() != 1)
					throw new NotSupportedException("i2b2 panel occurance " + panelList.get(panel).getTotalItemOccurrences().getValue() + " is not supported");

				List<ItemType> itemList = panelList.get(panel).getItem();

				for (int item = 0; item < itemList.size(); item++) {

					Mapper mapper = new Mapper(1, null, itemList.get(item));

					// Get the paths for the i2b2 ontology:

					String itemKey = itemList.get(item).getItemKey().toString(); // .replace("\\\\i2b2\\", "\\");
					String itemIcon = itemList.get(item).getItemIcon();
					String itemName = itemList.get(item).getItemName();
					String simplifiedName = simplify(itemName);
					ConstrainByModifier modifier = itemList.get(item).getConstrainByModifier();

					List<org.i2b2.xsd.cell.crc.psm.querydefinition._1.ItemType.ConstrainByValue> cbv = itemList.get(item).getConstrainByValue();

					// Handle "constrain by value" query attributes:

					Boolean doConstrainByValue = false;
					String valueConstraint = null;
					ConstrainOperatorType valueOperator = null;
					ConstrainValueType valueType = null;
					String valueUnitsOfMeasure = null;

					if (cbv.size() > 1) {

						throw new NotSupportedException("i2b2 multiple constrain by value are not supported");

					} else if (cbv.size() == 1) {

						// System.out.println("Constrain By Value");
						doConstrainByValue = true;
						valueConstraint = cbv.get(0).getValueConstraint();
						valueOperator = cbv.get(0).getValueOperator();
						valueType = cbv.get(0).getValueType();
						valueUnitsOfMeasure = cbv.get(0).getValueUnitOfMeasure(); // TODO: Handle unit conversion

					}

					// Handle "constrain by date" query attributes:

					Boolean doConstrainByDate = false;

					List<ConstrainByDate> cbd = itemList.get(item).getConstrainByDate();
					XMLGregorianCalendar dateFrom;
					XMLGregorianCalendar dateTo;

					if (cbd.size() > 1) {

						throw new NotSupportedException("i2b2 multiple constrain by date are not supported");

					} else if (cbd.size() == 1) {

						System.out.println("Constrain By Date");
						doConstrainByDate = true;
						dateFrom = cbd.get(0).getDateFrom().getValue();
						dateTo = cbd.get(0).getDateTo().getValue();
						System.out.println(dateFrom + " - " + dateTo);

						throw new NotSupportedException("i2b2 constrain by date is not supported");
					}

					if (modifier != null) { // Uses i2b2 modifiers. TODO maybe in a future version of this project!

						// throw new NotSupportedException("i2b2 modifiers are not supported");

						String modifierKey = modifier.getModifierKey().replace("\\\\i2b2\\", "\\");
						String modifierConcept = modifier.getModifierName();
						if (itemIcon.equals("LA")) {
							System.out.println(" Item: " + itemKey + " | " + modifierKey);
						} else {
							System.out.println(" Item: " + itemKey + "% | " + modifierKey);
						}

					} else { // No i2b2 modifiers. We need to handle this part.

						if (itemIcon != null) {
							// if (itemIcon.equals("LA")) { // Item is a leaf, which means: query only this item. May use constrain by value

							String MDRKey = mapper.getsKey();
							String MDRValue = mapper.getsValue();

							if (!doConstrainByValue) { // Only query for item existence

								ConstraintNode eq1 = null;

								if (mapper.getsType().equals("IsNotNull")) {
									eq1 = new ConstraintNode(ConstraintType.IsNotNull, MDRKey, MDRValue);
								} else if (mapper.getsType().equals("Equals")) {
									eq1 = new ConstraintNode(ConstraintType.Equals, MDRKey, MDRValue);
								} else if (mapper.getsType().equals("Like")) {
									eq1 = new ConstraintNode(ConstraintType.Like, MDRKey, MDRValue);
								} else if (mapper.getsType().equals("Between")) {
									eq1 = new ConstraintNode(ConstraintType.Between, MDRKey, MDRValue);

									List<String> values = new ArrayList<String>();
									values.add(mapper.getsLowerBound());
									values.add(mapper.getsUpperBound());
									eq1.setValues(values);

								} else {
									System.out.println("Unknown Node type in I2B2Translator: " + mapper.getsType());
								}

								if (itemList.size() == 1) {
									rootNode.addNode(eq1);
								} else {
									panelNode.addNode(eq1);
								}

							} else { // Constrain by value

								if (valueType.toString().equals("NUMBER")) {

									// To handle the BETWEEN operator, we may need to split the constraint into upper and lower. I'm not that happy with my
									// implementation, as it looks confusing.

									String valueLower = valueConstraint; // Assume valueLower is the default
									String valueUpper = "";

									if (valueConstraint.contains(" and ")) { // Split if necessary ...
										String[] values = valueConstraint.split(" and ");
										valueLower = values[0];
										valueUpper = values[1];
									}

									ConstraintNode eq1 = new ConstraintNode(getOmniConstrainType(valueOperator), MDRKey, valueLower);

									if (valueConstraint.contains(" and ")) // ... and add the upper value if necessary
										eq1.addValue(valueUpper);

									if (itemList.size() == 1) {
										rootNode.addNode(eq1);
									} else {
										panelNode.addNode(eq1);
									}

								} else {
									// TODO: Handle non-numeric "constrain by value"
									throw new NotSupportedException("i2b2 function constrain by value " + valueType.toString() + " is not supported");
								}
							}

							// } else { // Item is a folder, which means: include all sub-concepts.
							//
							// // System.out.println(" Item: " + itemKey + "%");
							//
							// String MDRKey = itemKey;
							// String MDRValue = itemKey + "%";
							//
							// ConstraintNode eq1 = new ConstraintNode(ConstraintType.Like, MDRKey, MDRValue);
							//
							// if (itemList.size() == 1) {
							// rootNode.addNode(eq1);
							// } else {
							// panelNode.addNode(eq1);
							// }
							//
							// }
						}
					}
				}

				if (itemList.size() > 1)
					rootNode.addNode(panelNode);

			}
			result.setNode(rootNode);
		} catch (Exception ex) {
			ex.printStackTrace(); // TODO
		}
		return result;
	}

	private ConstraintType getOmniConstrainType(ConstrainOperatorType valueOperator) throws NotSupportedException {
		switch (valueOperator.toString()) {
		case "EQ":
			return ConstraintType.Equals;
		case "GE":
			return ConstraintType.GreaterEquals;
		case "GT":
			return ConstraintType.Greater;
		case "LE":
			return ConstraintType.LessEquals;
		case "LT":
			return ConstraintType.Less;
		case "NE":
			return ConstraintType.NotEquals;
		case "BETWEEN":
			return ConstraintType.Between;
		case "CONTAINS":
			return ConstraintType.In;
		case "LIKE":
			throw new NotSupportedException("i2b2 constrain by value type '" + valueOperator.toString() + "' not supported");
		case "LIKE[begin]":
			throw new NotSupportedException("i2b2 constrain by value type '" + valueOperator.toString() + "' not supported");
		case "LIKE[end]":
			throw new NotSupportedException("i2b2 constrain by value type '" + valueOperator.toString() + "' not supported");
		case "LIKE[contains]":
			throw new NotSupportedException("i2b2 constrain by value type '" + valueOperator.toString() + "' not supported");
		case "LIKE[exact]":
			throw new NotSupportedException("i2b2 constrain by value type '" + valueOperator.toString() + "' not supported");
		case "CONTAINS[database]":
			throw new NotSupportedException("i2b2 constrain by value type '" + valueOperator.toString() + "' not supported");
		default:
			throw new NotSupportedException("i2b2 constrain by value type '" + valueOperator.toString() + "' not supported");
		}
	}

	private ConstrainOperatorType geti2b2ConstrainType(ConstraintType constraintType) throws NotSupportedException {
		switch (constraintType.toString()) {
		case "Equals":
			return ConstrainOperatorType.EQ;
		case "GreaterEquals":
			return ConstrainOperatorType.GE;
		case "Greater":
			return ConstrainOperatorType.GT;
		case "LessEquals":
			return ConstrainOperatorType.LE;
		case "Less":
			return ConstrainOperatorType.LT;
		case "NotEquals":
			return ConstrainOperatorType.NE;
		case "Between":
			return ConstrainOperatorType.BETWEEN;
		case "In":
			return ConstrainOperatorType.CONTAINS;
		case "Like":
			return ConstrainOperatorType.LIKE;
		default:
			throw new NotSupportedException("onmiQuery constrain by value type '" + constraintType.toString() + "' not supported");
		}

	}

	private void printOmniQueryRecursive(AbstractNode node, int indentLevel) {
		for (int a = 0; a < indentLevel; a++) {
			System.out.print(" ");
		}
		System.out.print(node.getClass().getSimpleName());
		if (node instanceof LogicNode) {
			System.out.println(" " + node.getType());
			List<AbstractNode> childNodes = ((LogicNode) node).getNodes();
			for (int a = 0; a < childNodes.size(); a++) {
				printOmniQueryRecursive(childNodes.get(a), indentLevel + 2);
			}
		} else {
			System.out.println(" " + node.getType());
		}
	}

	public String simpleTransform(String input, String transformation) {

		String result = "";
		try {
			StringReader reader = new StringReader(input);
			StringWriter writer = new StringWriter();
			TransformerFactory tFactory = TransformerFactoryImpl.newInstance();
			Transformer transformer = tFactory.newTransformer(new StreamSource(new File(transformation)));
			transformer.setParameter("mapURL", "xslt/dktk_map.xml");
			transformer.transform(new javax.xml.transform.stream.StreamSource(reader), new javax.xml.transform.stream.StreamResult(writer));
			result = writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Transformed: " + result + "----------");
		return result;
	}

	/**
	 * Translates a given OmniQuery into i2b2 XML.
	 * 
	 * Works equivalent to {@link #translateXmlToOmni(java.lang.String)}.
	 * 
	 * @param omniQuery
	 *            The given OmniQuery
	 * @return The translated Xml as string
	 * @see #translateXmlToOmni(java.lang.String)
	 */

	@Override
	public String translateOmniToXml(OmniQuery omniQuery) {

		// Convert omniQuery query to CNF:
		omniQuery = omniQuery.convertToCNF();

		// Prepare i2b2 query definition object (will hold the i2b2 query):
		QueryDefinitionType qdt = new QueryDefinitionType();

		java.util.Date date = new java.util.Date();
		// System.out.println(new Timestamp(date.getTime()));

		// qdt.setQueryName("Test");
		qdt.setQueryName("GBN " + (new Timestamp(date.getTime())).toString());

		// Process omniQuery:
		LogicNode rootNode = (LogicNode) omniQuery.getNode();
		printOmniQueryRecursive(rootNode, 0);

		// DKTKTranslator<I2B2Translator> DKTKtoI2B2Translator;
		// DKTKtoI2B2Translator = new DKTKTranslator<>(I2B2Translator.class);
		// String actual = DKTKtoI2B2Translator.translateOmniToXml(omniQuery);
		// System.out.println(actual);
		// System.out.println("---------------------");

		// System.setProperty("javax.xml.transform.TransformerFactory", "net.sf.saxon.TransformerFactoryImpl");
		// // DKTK to i2b2:
		// String inputXSL = "xslt/dktk_to_i2b2.xsl";
		// String result = simpleTransform(actual, inputXSL);
		// System.out.println(result);

		if (rootNode instanceof LogicNode && rootNode.getType().toString().equals("And")) { // The root node needs to be an 'And'
			List<AbstractNode> childNodes = ((LogicNode) rootNode).getNodes();

			// Iterate over CNF query and build i2b2 query

			for (int a = 0; a < childNodes.size(); a++) {

				// System.out.println("Creating i2b2 query panel #" + a);
				PanelType i2b2panel = new PanelType();
				i2b2panel.setPanelNumber(a + 1);
				i2b2panel.setPanelTiming("ANY");
				i2b2panel.setPanelAccuracyScale(100);
				i2b2panel.setInvert(0);

				TotalItemOccurrences tio = new TotalItemOccurrences();
				tio.setValue(1);

				i2b2panel.setTotalItemOccurrences(tio);

				if (childNodes.get(a).getType().toString().equals("Equals") || childNodes.get(a).getType().toString().equals("GreaterEquals")
						|| childNodes.get(a).getType().toString().equals("Greater") || childNodes.get(a).getType().toString().equals("LessEquals")
						|| childNodes.get(a).getType().toString().equals("Less") || childNodes.get(a).getType().toString().equals("NotEquals")
						|| childNodes.get(a).getType().toString().equals("Between") || childNodes.get(a).getType().toString().equals("IsNotNull") || childNodes.get(a).getType().toString().equals("In") || childNodes.get(a).getType().toString().equals("Like")) {

					// ConstraintNode cn = (ConstraintNode) childNodes.get(a);
					ItemType it = processPanelItems((ConstraintNode) childNodes.get(a));
					i2b2panel.getItem().add(it);

				} else if (childNodes.get(a).getType().toString().equals("Or")) {

					// LogicNode ln = (LogicNode) childNodes.get(a);
					List<AbstractNode> subNodes = ((LogicNode) childNodes.get(a)).getNodes();

					for (int b = 0; b < subNodes.size(); b++) {
						ConstraintNode cn = (ConstraintNode) subNodes.get(b);
						ItemType it = processPanelItems(cn);
						i2b2panel.getItem().add(it);
					}

				} else {
					try {
						throw new NotSupportedException("unexpected node type " + childNodes.get(a).getType());
					} catch (NotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				qdt.setQueryTiming("ANY");
				qdt.getPanel().add(i2b2panel);
			}

		} else {

			try {
				throw new NotSupportedException("node type " + rootNode.getType().toString() + " not supported, expected 'And' root node");
			} catch (NotSupportedException e) {

			}

		}

		// Marshal query definition to XML String:

		JAXBContext context1 = null;
		Marshaller marshaller1 = null;
		StringWriter result = new StringWriter();
		try {
			JAXBElement<QueryDefinitionType> queryDefinitionType = new JAXBElement<org.i2b2.xsd.cell.crc.psm.querydefinition._1.QueryDefinitionType>(
					new QName("http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/", "query_definition"), org.i2b2.xsd.cell.crc.psm.querydefinition._1.QueryDefinitionType.class, null, qdt);
			context1 = JAXBContext.newInstance("org.i2b2.xsd.cell.crc.psm.querydefinition._1");
			marshaller1 = context1.createMarshaller(); // //
			marshaller1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // marshaller.marshal(requestMessageType, result);
			marshaller1.marshal(queryDefinitionType, result);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		// TODO: Das geht so nicht. Lösung finden, wie man das ohne Namespaces marshallen kann ...
		String resultString = removeNamespaces(result.toString());

		return resultString;

	}

	private String removeNamespaces(String string) {
		return string.replaceAll("<ns2:query_definition xmlns:ns2=\"http://www.i2b2.org/xsd/cell/crc/psm/querydefinition/1.1/\">", "<query_definition>")
				.replaceAll("</ns2:query_definition>", "</query_definition>").replaceAll("<\\?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"\\?>", "");
	}

	private ItemType processPanelItems(ConstraintNode cn) {

		ItemType it = new ItemType();

		// System.out.println(" Id: " + cn.getId());
		// System.out.println(" Key: " + cn.getKey());
		// System.out.println(" LowerBound: " + cn.getLowerBound());
		// System.out.println(" Type: " + cn.getType());
		// System.out.println(" UpperBound: " + cn.getUpperBound());
		// System.out.println(" Value: " + cn.getValue());
		// System.out.println(" Values: " + cn.getValues());
		// System.out.println("");

		Mapper mapper = new Mapper(0, cn, null);

		it.setItemName(mapper.getiItemName());
		it.setTooltip(cn.getKey() + " " + cn.getType() + " " + cn.getValue());
		it.setItemKey(mapper.getiKey());

		it.setHlevel(3); // TODO: Berechnen und testen, ggf. von i2b2-Ontologie abfragen
		// it.setItemIcon("FA"); // Annahme: Wir erlauben nur Blätter in der Query.
		it.setItemIcon(mapper.getiItemIcon());

		it.setClazz("ENC");
		it.setItemIsSynonym(false);

		// org.i2b2.xsd.cell.crc.psm.querydefinition._1.ItemType.ConstrainByValue constraint = new
		// org.i2b2.xsd.cell.crc.psm.querydefinition._1.ItemType.ConstrainByValue();
		//
		// constraint.setValueConstraint(cn.getValue());
		// try {
		// constraint.setValueOperator(geti2b2ConstrainType(cn.getType()));
		// } catch (NotSupportedException e) {
		// e.printStackTrace();
		// }
		// it.getConstrainByValue().add(constraint);

		// If there is a modifier in the mapping, add the modifier to the i2b2 XML:

		if (!mapper.getiAppliedPath().equals("") && !mapper.getiModifierKey().equals("") && !mapper.getiModifierName().equals("")) {
			org.i2b2.xsd.cell.crc.psm.querydefinition._1.ItemType.ConstrainByModifier constraint = new org.i2b2.xsd.cell.crc.psm.querydefinition._1.ItemType.ConstrainByModifier();
			constraint.setAppliedPath(mapper.getiAppliedPath());
			constraint.setModifierKey(mapper.getiModifierKey());
			constraint.setModifierName(mapper.getiModifierName());
			it.setConstrainByModifier(constraint);
		}
		return it;

	}

	public static RequestHeaderType generateRequestHeader() {
		RequestHeaderType reqHeaderType = new RequestHeaderType();
		reqHeaderType.setResultWaittimeMs(90000);
		return reqHeaderType;
	}

	public static MessageHeaderType generateMessageHeader() {
		MessageHeaderType messageHeader = new MessageHeaderType();
		messageHeader.setI2B2VersionCompatible(new BigDecimal("1.0"));
		messageHeader.setHl7VersionCompatible(new BigDecimal("2.4"));
		ApplicationType appType = new ApplicationType();
		appType.setApplicationName("i2b2 Test");
		appType.setApplicationVersion("1.0");
		messageHeader.setSendingApplication(appType);
		/*
		 * Date currentDate = new Date(); DTOFactory factory = new DTOFactory(); messageHeader.setDatetimeOfMessage(factory
		 * .getXMLGregorianCalendar(currentDate.getTime()));
		 */
		messageHeader.setAcceptAcknowledgementType("AL");
		messageHeader.setApplicationAcknowledgementType("AL");
		messageHeader.setCountryCode("US");
		SecurityType securityType = new SecurityType();
		securityType.setDomain("demo");
		securityType.setUsername("demo");
		PasswordType ptype = new PasswordType();
		ptype.setValue("demouser");
		securityType.setPassword(ptype);
		messageHeader.setSecurity(securityType);
		messageHeader.setProjectId("Demo");
		return messageHeader;
	}

	private String simplify(String input) {

		// Taken partially from:
		// http://gordon.koefner.at/blog/coding/replacing-german-umlauts/
		String simplified = "";

		// replace all lower Umlauts
		simplified = input.replaceAll("ü", "ue").replaceAll("ö", "oe").replaceAll("ä", "ae").replaceAll("ß", "ss");

		// first replace all capital umlaute in a non-capitalized context (e.g. Übung)
		simplified = simplified.replaceAll("Ü(?=[a-zäöüß ])", "Ue").replaceAll("Ö(?=[a-zäöüß ])", "Oe").replaceAll("Ä(?=[a-zäöüß ])", "Ae");

		// now replace all the other capital umlaute
		simplified = simplified.replaceAll("Ü", "UE").replaceAll("Ö", "OE").replaceAll("Ä", "AE");

		simplified = simplified.replaceAll("[^A-Za-z0-9]", "_");

		return simplified;

	}

}
