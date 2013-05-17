/*
    Copyright 2010 Nathan Marz
 
    Project and contact information: http://www.cascalog.org/ 

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
   
        http://www.apache.org/licenses/LICENSE-2.0
   
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

package cascalog.aggregator;

import java.io.Serializable;

import cascalog.Util;
import clojure.lang.IFn;

public class CombinerSpec implements Serializable {
  public byte[] prepareFn;
  public final byte[] combineFn;
  public byte[] presentFn;

  public CombinerSpec(IFn combineFn) {
    this.combineFn = Util.serializeFn(combineFn);
  }

  public CombinerSpec setPrepareFn(IFn prepareFn) {
    this.prepareFn = Util.serializeFn(prepareFn);
    return this;
  }

  public CombinerSpec setPresentFn(IFn presentFn) {
    this.presentFn = Util.serializeFn(presentFn);
    return this;
  }

  public IFn getPrepareFn() {
    if (null == prepareFn)
      return null;
    else
      return Util.deserializeFn(prepareFn);
  }
  public IFn getCombineFn() {
    return Util.deserializeFn(combineFn);
  }

  public IFn getPresentFn() {
    if (null == presentFn)
      return null;
    else
      return Util.deserializeFn(presentFn);
  }
}
