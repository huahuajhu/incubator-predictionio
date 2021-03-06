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


package org.apache.predictionio.tools.console

import org.apache.predictionio.tools.Runner

case class ExportArgs(
  appId: Int = 0,
  channel: Option[String] = None,
  outputPath: String = "",
  format: String = "json")

object Export {
  def eventsToFile(ca: ConsoleArgs): Int = {
    val channelArg = ca.export.channel
      .map(ch => Seq("--channel", ch)).getOrElse(Nil)
    Runner.runOnSpark(
      "org.apache.predictionio.tools.export.EventsToFile",
      Seq(
        "--appid",
        ca.export.appId.toString,
        "--output",
        ca.export.outputPath,
        "--format",
        ca.export.format) ++ channelArg,
      ca,
      Nil)
  }
}
