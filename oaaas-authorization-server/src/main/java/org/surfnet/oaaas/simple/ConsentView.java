/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.surfnet.oaaas.simple;

import org.apache.commons.lang.StringUtils;
import org.surfnet.oaaas.model.Client;

import com.yammer.dropwizard.views.View;

public class ConsentView extends View {

  private Context context;
  private String[] scopes;

  public ConsentView(String actionUri, String authState, Client client) {
    super("consent.ftl");
    this.context = new Context(actionUri, authState, client);
    this.scopes = StringUtils.isBlank(client.getScopes()) ? new String[] {} : client.getScopes().split(",");
  }

  /**
   * @return the context
   */
  public Context getContext() {
    return context;
  }

  /**
   * @return the scopes
   */
  public String[] getScopes() {
    return scopes;
  }

}