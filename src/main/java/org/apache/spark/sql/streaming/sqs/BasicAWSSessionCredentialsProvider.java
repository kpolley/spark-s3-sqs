/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.sql.streaming.sqs;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.auth.AWSCredentials;

public class BasicAWSSessionCredentialsProvider implements AWSCredentialsProvider {
  private final String accessKey;
  private final String secretKey;
  private final String sessionToken;

  public BasicAWSSessionCredentialsProvider(String accessKey, String secretKey, String sessionToken) {
    this.accessKey = accessKey;
    this.secretKey = secretKey;
    this.sessionToken = sessionToken;

  }

  public AWSCredentials getCredentials() {
    if (this.accessKey != "" && this.secretKey != "" && this.sessionToken != "") {
      return new BasicSessionCredentials(accessKey, secretKey, sessionToken);
    }
    throw new AmazonClientException(
        "Access key or secret key is null");
  }

  public void refresh() {}

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }

}
