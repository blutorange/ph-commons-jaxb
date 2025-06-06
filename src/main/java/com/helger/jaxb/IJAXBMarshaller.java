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
package com.helger.jaxb;

import javax.annotation.Nonnull;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * A special bi-consumer that additionally can throw a {@link JAXBException}
 *
 * @author Philip Helger
 * @param <JAXBTYPE>
 *        The JAXB type to be written
 */
@FunctionalInterface
public interface IJAXBMarshaller <JAXBTYPE>
{
  /**
   * @param aMarshaller
   *        The {@link Marshaller} to use. May not be <code>null</code>.
   * @param aJAXBElement
   *        The JAXB-Element to write. May not be <code>null</code>.
   * @throws JAXBException
   *         In case writing to XML fails.
   */
  void doMarshal (@Nonnull Marshaller aMarshaller, @Nonnull JAXBElement <JAXBTYPE> aJAXBElement) throws JAXBException;
}
