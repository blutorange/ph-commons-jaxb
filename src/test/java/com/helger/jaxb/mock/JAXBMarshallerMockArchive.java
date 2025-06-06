/*
 * Copyright (C) 2014-2023 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.jaxb.mock;

import javax.xml.namespace.QName;

import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.jaxb.GenericJAXBMarshaller;
import com.helger.xml.namespace.MapBasedNamespaceContext;

import javax.xml.bind.JAXBElement;

public final class JAXBMarshallerMockArchive extends
                                             GenericJAXBMarshaller <com.helger.jaxb.mock.external.MockJAXBArchive>
{
  private static final ClassPathResource WITH_NS = new ClassPathResource ("xml/mock-without-ns.xsd",
                                                                          JAXBMarshallerMockArchive.class.getClassLoader ());

  public JAXBMarshallerMockArchive ()
  {
    this (true);
  }

  public JAXBMarshallerMockArchive (final boolean bValidate)
  {
    // No XSD available
    super (com.helger.jaxb.mock.external.MockJAXBArchive.class,
           bValidate ? new CommonsArrayList <> (WITH_NS) : null,
           x -> new JAXBElement <> (new QName ("", "Root"), com.helger.jaxb.mock.external.MockJAXBArchive.class, x));
    setFormattedOutput (true);
    setNamespaceContext (new MapBasedNamespaceContext ().addMapping ("def", ""));
  }
}
