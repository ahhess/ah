/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package bwbv.rlt.client.ui.widget;

/**
 * An indicator for an on going process.
 *
 * Borrowed from Beginning Google Web Toolkit Book
 */
public interface ProgressIndicator {

    public final static String DEFAULT_MESSAGE = "Loading";

    /**
     * Sets the message shown by this indicator.
     *
     * @param message The message that should shown by this indicator.
     */
    void setMessage(String message);

    /**
     * Hides this indicator.
     */
    void hide();

}
