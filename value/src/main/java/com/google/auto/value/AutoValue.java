/*
 * Copyright (C) 2012 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.auto.value;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specifies that <a href="http://goo.gl/Ter394">AutoValue</a> should generate an implementation
 * class for the annotated abstract class, implementing the standard {@link Object} methods like
 * {@link Object#equals equals} to have conventional value semantics. A simple example: <pre>
 *
 *   &#64;AutoValue
 *   abstract class Person {
 *     static Person create(String name, int id) {
 *       return new AutoValue_Person(name, id);
 *     }
 *
 *     abstract String name();
 *     abstract int id();
 *   }</pre>
 *
 * @see <a href="http://goo.gl/Ter394">AutoValue User's Guide</a>
 *
 * <!-- MOE:begin_intracomment_strip -->
 * @see <a href="http://go/autovalue">Additional Google-internal information<a/>
 * <!-- MOE:end_intracomment_strip -->
 *
 * @author Éamonn McManus
 * @author Kevin Bourrillion
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface AutoValue {
  /**
   * Specifies whether the generated class should cache each instance's {@link Object#hashCode
   * hashCode} value in a field once it is first computed. <b>Note:</b> most classes should have
   * no need of this behavior and should omit this parameter entirely. Use only if certain of its
   * performance benefit to your application.
   *
   * <p><b>Warning:</b> while using mutable field types is strongly discouraged in general, using
   * this feature makes it <i>especially</i> dangerous.
   * 
   * <p><b>Note: the default is actually {@code true}, but this will be changed to {@code false}
   * on or around January 7, 2014.
   */
  boolean cacheHashCode() default true;
}
